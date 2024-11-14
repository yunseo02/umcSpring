package umcspring.umc.domain.Alarm;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEventAlarm is a Querydsl query type for EventAlarm
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEventAlarm extends EntityPathBase<EventAlarm> {

    private static final long serialVersionUID = 15757637L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEventAlarm eventAlarm = new QEventAlarm("eventAlarm");

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

    public QEventAlarm(String variable) {
        this(EventAlarm.class, forVariable(variable), INITS);
    }

    public QEventAlarm(Path<? extends EventAlarm> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEventAlarm(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEventAlarm(PathMetadata metadata, PathInits inits) {
        this(EventAlarm.class, metadata, inits);
    }

    public QEventAlarm(Class<? extends EventAlarm> type, PathMetadata metadata, PathInits inits) {
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

