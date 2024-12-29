package umcspring.umc.service.MemberService;

import umcspring.umc.domain.Member;
import umcspring.umc.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    public Member joinMember(MemberRequestDTO.JoinDto request);
}
