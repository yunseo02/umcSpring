package umcspring.umc.service.MissionService;

import umcspring.umc.domain.Mission;
import umcspring.umc.web.dto.MissionRequestDTO;

public interface MissionCommandService {

    public Mission createMission(MissionRequestDTO.CreateDTO request);
}
