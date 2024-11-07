package umcspring.umc.domain.Alarm;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@DiscriminatorValue("I")
public class InquireAlarm extends Alarm{
}
