package umcspring.umc.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umcspring.umc.apiPayload.ApiResponse;
import umcspring.umc.converter.StoreConverter;
import umcspring.umc.domain.Store;
import umcspring.umc.service.StoreService.StoreCommandService;
import umcspring.umc.web.dto.StoreRequestDTO;
import umcspring.umc.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.CreateResultDTO> create(@RequestBody @Valid StoreRequestDTO.CreateDTO request){
        Store store = storeCommandService.createStore(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateResultDTO(store));
    }
}
