package umcspring.umc.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umcspring.umc.apiPayload.code.status.ErrorStatus;
import umcspring.umc.apiPayload.exception.handler.TempHandler;
import umcspring.umc.converter.MissionConverter;
import umcspring.umc.domain.Mission;
import umcspring.umc.domain.Store;
import umcspring.umc.repository.MissionRepository;
import umcspring.umc.repository.StoreRepository.StoreRepository;
import umcspring.umc.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    public Mission createMission(MissionRequestDTO.CreateDTO request) {
        Mission newMission = MissionConverter.toMission(request);

        //store 유효성 검사 후 저장
        Long storeId = request.getStoreId();
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new TempHandler(ErrorStatus.STORE_NOT_FOUND));
        newMission.setStore(store);

        return missionRepository.save(newMission);

    }
}
