package umcspring.umc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPreferenceFood is a Querydsl query type for PreferenceFood
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPreferenceFood extends EntityPathBase<PreferenceFood> {

    private static final long serialVersionUID = 987348394L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPreferenceFood preferenceFood = new QPreferenceFood("preferenceFood");

    public final StringPath Food = createString("Food");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public QPreferenceFood(String variable) {
        this(PreferenceFood.class, forVariable(variable), INITS);
    }

    public QPreferenceFood(Path<? extends PreferenceFood> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPreferenceFood(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPreferenceFood(PathMetadata metadata, PathInits inits) {
        this(PreferenceFood.class, metadata, inits);
    }

    public QPreferenceFood(Class<? extends PreferenceFood> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
    }

}

