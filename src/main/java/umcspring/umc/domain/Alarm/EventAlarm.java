package umcspring.umc.domain.Alarm;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.*;

@Entity
@Getter
@DiscriminatorValue("E")
public class EventAlarm extends Alarm{
}
