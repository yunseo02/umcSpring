package umcspring.umc.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import umcspring.umc.domain.Member;
import umcspring.umc.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당 이메일을 가진 유저가 존재하지 않습니다: " + username));
        System.out.println(member.getName());
        return org.springframework.security.core.userdetails.User
                .withUsername(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().name())
                .build();
    }//user를 구성!!!!
}
/*
사용자가 로그인 폼에서 이메일과 비밀번호를 입력하고 제출
Spring Security가 loadUserByUsername 메소드를 호출
이 메소드는 입력받은 이메일로 데이터베이스에서 사용자를 조회
사용자가 존재하면 User 객체로 변환하여 반환
Spring Security는 반환된 User 객체의 정보를 사용하여 인증을 수행
 */