package umcspring.umc.domain;

import jakarta.persistence.*;
import lombok.*;
import umcspring.umc.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    private int score;
    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewImage> reviewImages = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    public void setMember(Member member){
        if(this.member != null)
            member.getReviews().remove(this);
        this.member = member;
        member.getReviews().add(this);
    }

    public void setStore(Store store){
        if(this.store != null)
            store.getReviews().remove(this);
        this.store = store;
        store.getReviews().add(this);
    }
}
