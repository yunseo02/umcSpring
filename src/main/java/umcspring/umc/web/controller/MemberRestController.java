package umcspring.umc.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umcspring.umc.apiPayload.ApiResponse;
import umcspring.umc.converter.MemberConverter;
import umcspring.umc.domain.Member;
import umcspring.umc.service.MemberService.MemberCommandService;
import umcspring.umc.web.dto.MemberRequestDTO;
import umcspring.umc.web.dto.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }//@RequestBody: 클라이언트로부터 전달된 json 데이터를 memberRequestDTO.JoinDto 객체로 매핑한다.
}
