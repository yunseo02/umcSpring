package umcspring.umc.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import umcspring.umc.domain.Member;
import umcspring.umc.domain.enums.Gender;
import umcspring.umc.domain.enums.Role;
import umcspring.umc.repository.MemberRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        //카카오에서 제공하는 사용자 정보를 OAuth2User객체로 받아옴
        //이 객체의 attributes에는 사용자의 닉네임 등 기본 정보가 포함되어 있음

        Map<String, Object> attributes = oAuth2User.getAttributes();
        Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");

        String nickname = (String) properties.get("nickname");
        String email = nickname + "@kakao.com";//임시 이메일 생성

        Member member = saveOrUpdateUser(email, nickname);

        Map<String, Object> modifiedAttributes = new HashMap<>(attributes);//기존 attirbutes를 복사하여 새 Map을 생성
        modifiedAttributes.put("email", email);//기존 사용자 정보에 email을 추가하거나 변경

        return new DefaultOAuth2User(
                oAuth2User.getAuthorities(),//인증된 사용자 권한 정보를 반환 *기본적으로 OAuth2인증 사용자는 ROLE_USER 같은 기본 권한을 가짐
                modifiedAttributes,
                "email"
        );
        //Spring Secutiry에서 제공되는 기본 OAuth2 사용자 객체로, OAuth2 인증 사용자 정보를 캡슐화한다.
    }

    private Member saveOrUpdateUser(String email, String nickname) {
        Member member = memberRepository.findByEmail(email)
                .orElse(Member.builder()
                        .email(email)
                        .name(nickname)
                        .password(passwordEncoder.encode("OAUTH_USER_"+ UUID.randomUUID()))
                        .gender(Gender.NONE)
                        .address("소셜로그인")
                        .specAddress("소셜로그인")
                        .role(Role.USER)
                        .build());

        return memberRepository.save(member);
    }
}

/*
attributes와 properties 설명
attributes: OAuth2 프로토콜에서 가져온 사용자 정보 전체를 담고 있는 객체, 최상위 Map 객체, 사용자 정보와 관련된 다양한 데이터를 포함
아래 전체 JSON 객체를 나타냄
{
  "id": 1234567890,
  "connected_at": "2023-12-25T12:34:56Z",
  "properties": {
    "nickname": "홍길동",
    "profile_image": "https://profile.image.url",
    "thumbnail_image": "https://thumbnail.image.url"
  },
  "kakao_account": {
    "email": "test@example.com",
    "has_email": true,
    "email_needs_agreement": false,
    "profile": {
      "nickname": "홍길동",
      "profile_image_url": "https://profile.image.url",
      "thumbnail_image_url": "https://thumbnail.image.url"
    }
  }
}

properties: attributes 안에 포함된 사용자 정보 중, 주로 프로필 관련 데이터를 담고 있는 Map 객체
attributes의 하위 Map으로, 사용자의 닉네임, 프로필 이미지, 썸네일 이미지 등 간단한 정보를 제공
아래 구조
"properties": {
  "nickname": "홍길동",
  "profile_image": "https://profile.image.url",
  "thumbnail_image": "https://thumbnail.image.url"
}
 */