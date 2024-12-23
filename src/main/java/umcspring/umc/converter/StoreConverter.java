package umcspring.umc.converter;

import org.springframework.data.domain.Page;
import umcspring.umc.domain.Review;
import umcspring.umc.domain.Store;
import umcspring.umc.web.dto.ReviewResponseDTO;
import umcspring.umc.web.dto.StoreRequestDTO;
import umcspring.umc.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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


    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review) {
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createAt(review.getCreatedAt().toLocalDate())
                .body(review.getContent())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewsDTO reviewPreViewsDTO(Page<Review> reviews){
        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOS = reviews.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewsDTO.builder()
                .isLast(reviews.isLast())
                .isFirst(reviews.isFirst())
                .totalPage(reviews.getTotalPages())
                .totalElements(reviews.getTotalElements())
                .listSize(reviewPreViewDTOS.size())
                .reviews(reviewPreViewDTOS)
                .build();
    }
}
