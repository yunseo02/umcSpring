package umcspring.umc.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import umcspring.umc.domain.common.BaseEntity;

@Embeddable
@Getter @Setter
public class Address {

    private String city;
    private String street;
    private double latitude;
    private double longitude;
}
