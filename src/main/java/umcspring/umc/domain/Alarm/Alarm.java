package umcspring.umc.domain.Alarm;

import jakarta.persistence.*;
import lombok.*;
import umcspring.umc.domain.mapping.Member;
import umcspring.umc.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Alarm extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alarm_id")
    private Long id;

    private String title;
    private String content;

    @Enumerated(EnumType.STRING)
    private AlarmStatus status;

    @Enumerated(EnumType.STRING)
    private IsConfirmed isConfirmed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
