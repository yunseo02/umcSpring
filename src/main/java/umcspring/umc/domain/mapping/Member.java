package umcspring.umc.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umcspring.umc.domain.Address;
import umcspring.umc.domain.Alarm.Alarm;
import umcspring.umc.domain.Review;
import umcspring.umc.domain.common.BaseEntity;
import umcspring.umc.domain.enums.Gender;
import umcspring.umc.domain.enums.MemberStatus;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<PreferenceFood> preferenceFoods = new ArrayList<>();

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    private LocalDateTime inactive_date;

    private Integer total_point;

    private String phone_num;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Alarm> alarms = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissions = new ArrayList<>();
}
