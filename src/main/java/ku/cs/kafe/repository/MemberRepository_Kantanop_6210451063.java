package ku.cs.kafe.repository;


import ku.cs.kafe.entity.Member_Kantanop_6210451063;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;


@Repository
public interface MemberRepository_Kantanop_6210451063 extends JpaRepository<Member_Kantanop_6210451063, UUID> {
    Member_Kantanop_6210451063 findByUsername(String username);
}
