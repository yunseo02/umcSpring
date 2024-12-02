package umcspring.umc.converter;

import umcspring.umc.domain.Review;
import umcspring.umc.web.dto.ReviewRequestDTO;
import umcspring.umc.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.CreateDTO request){
        return Review.builder()
                .score(request.getScore())
                .content(request.getContent())
                .reviewImages(new ArrayList<>())
                .build();
    }
    public static ReviewResponseDTO.CreateResultDTO toCreateResultDTO(Review review) {
        return ReviewResponseDTO.CreateResultDTO.builder()
                .reviewId(review.getId())
                .createAt(LocalDateTime.now())
                .build();
    }
}
