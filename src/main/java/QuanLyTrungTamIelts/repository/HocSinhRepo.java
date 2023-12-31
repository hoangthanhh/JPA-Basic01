package QuanLyTrungTamIelts.repository;

import QuanLyTrungTamIelts.Models.HocSinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface HocSinhRepo extends JpaRepository<HocSinh,Integer> {
    @Query(value = "select * from hocsinh where year(ngaysinh) = :namSinh and hoten like %:hoTen%", nativeQuery = true)
    List<HocSinh> hienThiDSHocSinh(@Param("namSinh") int namSinh, @Param("hoTen") String hoTen);

    @Query(value = "select * from hocsinh order by ngaydangky desc", nativeQuery = true)
    List<HocSinh> hienThiDSHocSinhTheoNgayDangKy();

}
