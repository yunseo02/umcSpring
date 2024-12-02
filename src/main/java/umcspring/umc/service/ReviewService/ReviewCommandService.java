package umcspring.umc.service.ReviewService;

import umcspring.umc.domain.Review;
import umcspring.umc.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {

    public Review createReview(ReviewRequestDTO.CreateDTO request);
}
