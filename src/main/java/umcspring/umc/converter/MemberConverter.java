package umcspring.umc.converter;

import umcspring.umc.domain.Member;
import umcspring.umc.domain.enums.Gender;
import umcspring.umc.web.dto.MemberRequestDTO;
import umcspring.umc.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request) {
        System.out.println("gender값"+request.getGender());
        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .birthYear(request.getBirthYear())
                .birthMonth(request.getBirthMonth())
                .birthDay(request.getBirthDay())
                .preferenceFoods(new ArrayList<>())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .build();
    }
}
