package umcspring.umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcspring.umc.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
