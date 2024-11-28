package umcspring.umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcspring.umc.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
