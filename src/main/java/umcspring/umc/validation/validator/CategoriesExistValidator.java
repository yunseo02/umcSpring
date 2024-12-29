package umcspring.umc.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umcspring.umc.apiPayload.code.status.ErrorStatus;
import umcspring.umc.repository.FoodCategoryRepository;
import umcspring.umc.service.FoodCategoryService.FoodCategoryQueryService;
import umcspring.umc.validation.annotation.ExistCategories;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {//ConstaintValidator 내부 인터페이스 상속

    private final FoodCategoryQueryService foodCategoryQueryService;

    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {//values: 유효성을 검사할 데이터 리스트/ context: 유효성 검사 실패시 아요자 정의 메시지를 생성하고 설정할 수 있는 객체
        boolean isValid = values.stream()
                .allMatch(value -> foodCategoryQueryService.isFoodCategoryExists(value));

        if(!isValid) {
            context.disableDefaultConstraintViolation();//기본적으로 제공되는 제약 조건 위반 메시지를 비활성화
            context.buildConstraintViolationWithTemplate(//새로운 제약 조건 위반 메세지 생성
                    ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }           //사용자 정의 메세지로 설정됨                       생성한 메시지를 제약 조건 위반 컨텍스트에 추가

        return isValid;
    }
}
