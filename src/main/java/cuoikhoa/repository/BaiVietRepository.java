package cuoikhoa.repository;

import cuoikhoa.entity.BaiViet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaiVietRepository extends JpaRepository<BaiViet, Integer> {
    Page<BaiViet> findByTenBaiViet(String name, Pageable pageable);
}
