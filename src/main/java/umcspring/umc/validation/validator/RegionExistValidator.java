package umcspring.umc.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umcspring.umc.apiPayload.code.status.ErrorStatus;
import umcspring.umc.repository.RegionRepository;
import umcspring.umc.service.RegionService.RegionQueryService;
import umcspring.umc.validation.annotation.ExistRegion;

@Component
@RequiredArgsConstructor
public class RegionExistValidator implements ConstraintValidator<ExistRegion, Long> {

    private final RegionQueryService regionQueryService;

    @Override
    public void initialize(ExistRegion constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = regionQueryService.isRegionExists(value);

        if(!isValid) {
            context.disableDefaultConstraintViolation();;
            context.buildConstraintViolationWithTemplate(ErrorStatus.REGION_NOT_FOUND.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
