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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_category_id")
    private FoodCategory foodCategory;

    //연관관계 매핑
    public void setMember(Member member){
        if(this.member != null)
            member.getPreferenceFoods().remove(this);
        this.member = member;
        member.getPreferenceFoods().add(this);
    }
    public void setFoodCategory(FoodCategory foodCategory){
        this.foodCategory = foodCategory;
    }
}
