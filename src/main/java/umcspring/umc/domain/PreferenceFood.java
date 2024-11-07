package umcspring.umc.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PreferenceFood {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preference_Food_id")
    private Long id;

    @Column(length = 20)
    private String Food;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
