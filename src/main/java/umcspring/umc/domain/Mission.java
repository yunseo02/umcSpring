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
public class Mission extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "mission_id")
    private Long id;

    private int price;
    private int point;

    @Column(columnDefinition = "Text")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissions = new ArrayList<>();

    public void setStore(Store store){
        if(this.store != null)
            store.getMissions().remove(this);
        this.store = store;
        store.getMissions().add(this);
    }
}
