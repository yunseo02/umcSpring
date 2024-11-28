package umcspring.umc.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umcspring.umc.validation.validator.CategoriesExistValidator;

import java.lang.annotation.*;

@Documented//사용자 정의 어노테이션을 만들 때
@Constraint(validatedBy = CategoriesExistValidator.class)//CategoriesExistValidator클래스를 통해 @ExistCategories가 붙은 대상을 검증
@Target( {ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})//어노테이션의 적용 범위를 지정/ 여기서는 메서드, 클래스의 필드, 매서드의 매개변수에 붙일 수 있음
@Retention(RetentionPolicy.RUNTIME)//어노테이션의 생명 주기 지정
public @interface ExistCategories {

    String message() default "해당하는 카테고리는 존재하지 않습니다.";//유효성 검증 실패 시 반환될 기본 메시지 정의
    Class<?>[] groups() default {};//유효 검증 그룹을 정의@
    Class<? extends Payload>[] payload() default {};

}
