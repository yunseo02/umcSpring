package umcspring.umc.domain.Alarm;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewAlarm is a Querydsl query type for ReviewAlarm
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewAlarm extends EntityPathBase<ReviewAlarm> {

    private static final long serialVersionUID = -2058432981L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewAlarm reviewAlarm = new QReviewAlarm("reviewAlarm");

    public final QAlarm _super;

    //inherited
    public final StringPath content;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final EnumPath<IsConfirmed> isConfirmed;

    // inherited
    public final umcspring.umc.domain.QMember member;

    //inherited
    public final EnumPath<AlarmStatus> status;

    //inherited
    public final StringPath title;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateAt;

    public QReviewAlarm(String variable) {
        this(ReviewAlarm.class, forVariable(variable), INITS);
    }

    public QReviewAlarm(Path<? extends ReviewAlarm> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewAlarm(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewAlarm(PathMetadata metadata, PathInits inits) {
        this(ReviewAlarm.class, metadata, inits);
    }

    public QReviewAlarm(Class<? extends ReviewAlarm> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QAlarm(type, metadata, inits);
        this.content = _super.content;
        this.createdAt = _super.createdAt;
        this.id = _super.id;
        this.isConfirmed = _super.isConfirmed;
        this.member = _super.member;
        this.status = _super.status;
        this.title = _super.title;
        this.updateAt = _super.updateAt;
    }

}

