package umcspring.umc.converter;

import umcspring.umc.domain.Mission;
import umcspring.umc.web.dto.MissionRequestDTO;
import umcspring.umc.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.CreateDTO request){
        return Mission.builder()
                .point(request.getPoint())
                .price(request.getPrice())
                .content(request.getContent())
                .build();
    }

    public static MissionResponseDTO.CreateResultDTO toCreateResultDTO(Mission mission) {
        return MissionResponseDTO.CreateResultDTO.builder()
                .missionId(mission.getId())
                .createAt(LocalDateTime.now())
                .build();
    }
}
