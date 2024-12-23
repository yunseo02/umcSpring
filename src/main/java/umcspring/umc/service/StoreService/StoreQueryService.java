package umcspring.umc.service.StoreService;

import org.springframework.data.domain.Page;
import umcspring.umc.domain.Review;
import umcspring.umc.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    Boolean isStoreExists(Long id);

    Page<Review> getReviews(Long storeId, int page);
}
