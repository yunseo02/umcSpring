package umcspring.umc.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umcspring.umc.apiPayload.code.status.ErrorStatus;
import umcspring.umc.apiPayload.exception.handler.StoreRegionHandler;
import umcspring.umc.converter.StoreConverter;
import umcspring.umc.domain.Region;
import umcspring.umc.domain.Store;
import umcspring.umc.repository.RegionRepository;
import umcspring.umc.repository.StoreRepository.StoreRepository;
import umcspring.umc.web.dto.StoreRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store createStore(StoreRequestDTO.CreateDTO request) {
        Store newStore = StoreConverter.toStore(request);
        Long regionId = request.getRegionId();
        Region region = regionRepository.findById(regionId)
                        .orElseThrow(() -> new StoreRegionHandler(ErrorStatus.REGION_NOT_FOUND));
        newStore.setRegion(region);
        return storeRepository.save(newStore);
    }
}
