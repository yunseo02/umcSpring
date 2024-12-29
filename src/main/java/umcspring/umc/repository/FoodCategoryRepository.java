package umcspring.umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcspring.umc.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
