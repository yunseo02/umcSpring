package umcspring.umc.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umcspring.umc.domain.Alarm.Alarm;
import umcspring.umc.domain.common.BaseEntity;
import umcspring.umc.domain.enums.Gender;
import umcspring.umc.domain.enums.MemberStatus;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate//insert와 update 시 null인 경우는 그냥 쿼리를 보내지 않도록
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 10, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int birthYear;
    private int birthMonth;
    private int birthDay;

    private String address;

    private String specAddress;

    private LocalDateTime inactive_date;

    @ColumnDefault("0")
    private Integer point;

//    @Column(nullable = false, length = 50)
    private String email;

//    @Column(length = 15, unique = true, nullable = false)
    private String phone_num;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<PreferenceFood> preferenceFoods = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Alarm> alarms = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissions = new ArrayList<>();
}
