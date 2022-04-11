package kkh.manytomany.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kkh.manytomany.entity.MiniStockDTO;

@Repository
public interface MiniStockRepository extends JpaRepository<MiniStockDTO, String> {
	
	@Query(value="SELECT * FROM mini_stock u WHERE u.name=?", nativeQuery=true)
	MiniStockDTO findByName(String stockName);
	
	@Query(value="SELECT * FROM mini_stock u WHERE u.stock_id = ?", nativeQuery = true)
	List<MiniStockDTO> findBystockId(String stockId);
	
	@Query(value = "SELECT * FROM mini_stock u WHERE u.status = 'enable'", nativeQuery = true)
	List<MiniStockDTO> findAllStatus();
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE mini_stock u SET u.status='disable' WHERE u.stock_id=?", nativeQuery = true)
	void updateStatus(String stockId);
	
}
