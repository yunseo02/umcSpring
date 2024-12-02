package umcspring.umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcspring.umc.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
