package umcspring.umc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1569369749L;

    public static final QMember member = new QMember("member1");

    public final umcspring.umc.domain.common.QBaseEntity _super = new umcspring.umc.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final ListPath<umcspring.umc.domain.Alarm.Alarm, umcspring.umc.domain.Alarm.QAlarm> alarms = this.<umcspring.umc.domain.Alarm.Alarm, umcspring.umc.domain.Alarm.QAlarm>createList("alarms", umcspring.umc.domain.Alarm.Alarm.class, umcspring.umc.domain.Alarm.QAlarm.class, PathInits.DIRECT2);

    public final NumberPath<Integer> birthDay = createNumber("birthDay", Integer.class);

    public final NumberPath<Integer> birthMonth = createNumber("birthMonth", Integer.class);

    public final NumberPath<Integer> birthYear = createNumber("birthYear", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umcspring.umc.domain.enums.Gender> gender = createEnum("gender", umcspring.umc.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> inactive_date = createDateTime("inactive_date", java.time.LocalDateTime.class);

    public final ListPath<MemberMission, QMemberMission> memberMissions = this.<MemberMission, QMemberMission>createList("memberMissions", MemberMission.class, QMemberMission.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath phone_num = createString("phone_num");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<PreferenceFood, QPreferenceFood> preferenceFoods = this.<PreferenceFood, QPreferenceFood>createList("preferenceFoods", PreferenceFood.class, QPreferenceFood.class, PathInits.DIRECT2);

    public final ListPath<Review, QReview> reviews = this.<Review, QReview>createList("reviews", Review.class, QReview.class, PathInits.DIRECT2);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<umcspring.umc.domain.enums.MemberStatus> status = createEnum("status", umcspring.umc.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateAt = _super.updateAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

