package umcspring.umc.repository.StoreRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umcspring.umc.domain.QStore;
import umcspring.umc.domain.Store;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    //이 필드를 사용하려면 의존성 주입을 통해 이 필드를 초기화해주는 생성자가 필요함
    //JPAQueryFactory를 @Bean으로 등록해주면, 스피링이 생성자를 통해 자동으로 JPAQueryFactory를 주입해줌(QueryDSLConfig 파일에 등록해놓았다)
    private final QStore store = QStore.store;
    @Override
    public List<Store> dynamicQueryWithBooleanBuilder(String name, Float score) {
        BooleanBuilder predicate = new BooleanBuilder();
        //BooleanBuilder는 QueryDSL에서 조건들을 동적으로 추가하기 위해 사용하는 클래스

        if (name != null) {//name조건이 주어졌을 때만
            predicate.and(store.name.eq(name));
        }
        if (score != null) {
            predicate.and(store.score.goe(score));//goe: greater than or equal to
        }
        return jpaQueryFactory
                .selectFrom(store)//Store엔티티를 조회하는 쿼리 생성
                .where(predicate)//predicate에 누적된 조건들이 where에 반영
                .fetch();//쿼리를 실행하여 결과 리스트를 반환
    }
}
