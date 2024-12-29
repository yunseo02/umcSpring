package umcspring.umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcspring.umc.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
