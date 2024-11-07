package umcspring.umc.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umcspring.umc.domain.mapping.Member;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PreferenceFood {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preference_Food_id")
    private Long id;

    private String Food;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
