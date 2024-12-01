package umcspring.umc.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umcspring.umc.validation.annotation.ExistRegion;

public class StoreRequestDTO {

    @Getter
    public static class CreateDTO {
        @NotBlank
        String name;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        @ExistRegion
        Long regionId;
    }
}
