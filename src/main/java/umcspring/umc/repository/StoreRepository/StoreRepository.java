package umcspring.umc.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcspring.umc.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
