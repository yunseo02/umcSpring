package umcspring.umc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import umcspring.umc.domain.common.BaseEntity;

@Embeddable
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Address {

    @Column(length = 50)
    private String city;

    @Column(length = 50)
    private String street;

    @Column(precision = 10, scale = 8)
    private double latitude;

    @Column(precision = 10, scale = 8)
    private double longitude;
}
