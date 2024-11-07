package umcspring.umc.domain;

import jakarta.persistence.Embeddable;
import lombok.*;
import umcspring.umc.domain.common.BaseEntity;

@Embeddable
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Address {

    private String city;
    private String street;
    private double latitude;
    private double longitude;
}
