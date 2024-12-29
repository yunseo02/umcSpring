package umcspring.umc.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class CreateDTO{
        @NotNull
        Integer price;
        @NotNull
        Integer point;
        @NotBlank
        String content;
        @NotNull
        Long storeId;
    }
}
