package cuoikhoa.repository;

import cuoikhoa.entity.DangKyHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DangKyHocRepository extends JpaRepository<DangKyHoc, Integer> {

    int countByKhoaHocIDAndTinhTrangHocIDIn(int khoaHocID, List<Integer> tinhTrangHocIDs);
}
