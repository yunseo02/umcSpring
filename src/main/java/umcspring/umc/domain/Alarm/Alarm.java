package umcspring.umc.domain.Alarm;

import jakarta.persistence.*;
import lombok.*;
import umcspring.umc.domain.Member;
import umcspring.umc.domain.common.BaseEntity;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Alarm extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alarm_id")
    private Long id;

    @Column(length = 20)
    private String title;
    @Column(columnDefinition = "Text")
    private String content;

    @Enumerated(EnumType.STRING)
    private AlarmStatus status;

    @Enumerated(EnumType.STRING)
    private IsConfirmed isConfirmed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
