package umcspring.umc.service.RegionService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import umcspring.umc.repository.RegionRepository;

@Service
@AllArgsConstructor
public class RegionQueryServiceImpl implements RegionQueryService{

    private final RegionRepository regionRepository;

    @Override
    public Boolean isRegionExists(Long id) {
        return regionRepository.existsById(id);
    }
}
