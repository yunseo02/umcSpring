package umcspring.umc.converter;

import umcspring.umc.domain.Store;
import umcspring.umc.web.dto.StoreRequestDTO;
import umcspring.umc.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.CreateResultDTO toCreateResultDTO(Store store) {
        return StoreResponseDTO.CreateResultDTO.builder()
                .storeId(store.getId())
                .createAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.CreateDTO request) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .build();
    }
}
