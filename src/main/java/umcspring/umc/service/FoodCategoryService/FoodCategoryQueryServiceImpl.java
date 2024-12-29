package umcspring.umc.service.FoodCategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umcspring.umc.repository.FoodCategoryRepository;

@Service
@RequiredArgsConstructor
public class FoodCategoryQueryServiceImpl implements FoodCategoryQueryService{

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public Boolean isFoodCategoryExists(Long id) {
        return foodCategoryRepository.existsById(id);
    }
}
