package umcspring.umc.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umcspring.umc.apiPayload.code.status.ErrorStatus;
import umcspring.umc.apiPayload.exception.handler.FoodCategoryHandler;
import umcspring.umc.converter.MemberConverter;
import umcspring.umc.converter.MemberPreferConverter;
import umcspring.umc.domain.FoodCategory;
import umcspring.umc.domain.Member;
import umcspring.umc.domain.PreferenceFood;
import umcspring.umc.repository.FoodCategoryRepository;
import umcspring.umc.repository.MemberRepository;
import umcspring.umc.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);//Member 객체 빌드는 converter에서 한다

        newMember.encodePassword(passwordEncoder.encode(request.getPassword()));

        List<FoodCategory> foodCategoryList = request.getPreferenceFoods().stream()
                .map(category -> {//stream-mapping: 스트림을 원하는 모양의 새로운 스트림으로 변환하고 싶을 때
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());//결과를 모아서 리스트로 반환

        List<PreferenceFood> preferenceFoodList = MemberPreferConverter.toMemberPreferList(foodCategoryList);//preferenceFood build하면서 foodCategory 저장

        preferenceFoodList.forEach(preferenceFood -> {preferenceFood.setMember(newMember);});//preferenceFood에 member 저장

        return memberRepository.save(newMember);
    }
}
