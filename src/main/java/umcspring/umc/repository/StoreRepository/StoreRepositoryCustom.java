package umcspring.umc.repository.StoreRepository;

import umcspring.umc.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);

}
