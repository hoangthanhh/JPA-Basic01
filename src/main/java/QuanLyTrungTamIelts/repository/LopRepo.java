package QuanLyTrungTamIelts.repository;

import QuanLyTrungTamIelts.Models.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LopRepo extends JpaRepository<Lop,Integer> {
}
