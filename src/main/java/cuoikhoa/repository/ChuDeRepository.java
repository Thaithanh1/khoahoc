package cuoikhoa.repository;

import cuoikhoa.entity.ChuDe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuDeRepository extends JpaRepository<ChuDe, Integer> {
}
