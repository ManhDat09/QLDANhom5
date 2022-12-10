package crud.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import crud.server.model.Khoangsan;

public interface KhoangsanRepository extends JpaRepository <Khoangsan, Long> {
//	List<HocSinh> findByDadonghocphi(boolean dadonghocphi);
	List<Khoangsan> findByTenKhoangSanContaining(String tenKhoangSan);
}
