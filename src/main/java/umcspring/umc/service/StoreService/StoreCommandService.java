package umcspring.umc.service.StoreService;

import umcspring.umc.domain.Store;
import umcspring.umc.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    public Store createStore(StoreRequestDTO.CreateDTO request);
}
