package umcspring.umc.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umcspring.umc.apiPayload.ApiResponse;
import umcspring.umc.converter.MissionConverter;
import umcspring.umc.converter.ReviewConverter;
import umcspring.umc.converter.StoreConverter;
import umcspring.umc.domain.Mission;
import umcspring.umc.domain.Review;
import umcspring.umc.domain.Store;
import umcspring.umc.service.MissionService.MissionCommandService;
import umcspring.umc.service.ReviewService.ReviewCommandService;
import umcspring.umc.service.StoreService.StoreCommandService;
import umcspring.umc.web.dto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final ReviewCommandService reviewCommandService;
    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.CreateResultDTO> create(@RequestBody @Valid StoreRequestDTO.CreateDTO request){
        Store store = storeCommandService.createStore(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateResultDTO(store));
    }

    @PostMapping("/{storeId}/review")
    public ApiResponse<ReviewResponseDTO.CreateResultDTO> registerReview(@RequestBody @Valid ReviewRequestDTO.CreateDTO request){
        Review review = reviewCommandService.createReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toCreateResultDTO(review));
    }

    @PostMapping("/{storeId}/mission")
    public ApiResponse<MissionResponseDTO.CreateResultDTO> registerMission(@RequestBody @Valid MissionRequestDTO.CreateDTO request){
        Mission mission = missionCommandService.createMission(request);
        return ApiResponse.onSuccess(MissionConverter.toCreateResultDTO(mission));
    }
}
