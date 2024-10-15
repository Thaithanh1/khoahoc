package cuoikhoa.repository;

import cuoikhoa.entity.KhoaHoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhoaHocRepository extends JpaRepository<KhoaHoc, Integer> {
    Page<KhoaHoc> findByTenKhoaHocContaining(String tenKhoaHoc, Pageable pageable);
}
