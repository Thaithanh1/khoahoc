package cuoikhoa.repository;

import cuoikhoa.entity.HocVien;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface HocVienRepository extends JpaRepository<HocVien, Integer> {
    Optional<Object> findByEmail(String email);

    Optional<Object> findBySoDienThoai(String soDienThoai);

    Page<HocVien> findByHoTenContainingAndEmailContaining(String name, String email, org.springframework.data.domain.Pageable pageable);
}
