package challenge.apirest.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import challenge.apirest.domain.model.Audit;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Long> {
    List<Audit> findAllByRequestDateBetween(LocalDateTime start, LocalDateTime end);
}
