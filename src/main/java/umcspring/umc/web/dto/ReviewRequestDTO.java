package umcspring.umc.web.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;
import umcspring.umc.validation.annotation.ExistRegion;

import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class CreateDTO {
        @Min(0) @Max(5)
        Integer score;
        @NotBlank
        String content;

        List<Long> reviewImages;
        @NotNull
        Long memberId;
        @NotNull
        Long storeId;
    }
}
