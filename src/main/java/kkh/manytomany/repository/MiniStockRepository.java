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

	@Query(value = "SELECT * FROM mini_stock u WHERE u.brand_name=?", nativeQuery = true)
	MiniStockDTO findByName(String brandName);

	@Query(value = "SELECT * FROM mini_stock u WHERE u.stock_id = ?", nativeQuery = true)
	List<MiniStockDTO> findBystockId(String stockId);

	@Query(value = "SELECT * FROM mini_stock u WHERE u.status = 'enable'", nativeQuery = true)
	List<MiniStockDTO> findAllStatus();
	
	@Query(value = "SELECT * FROM mini_stock u WHERE u.brand_name = ?", nativeQuery = true)
	List<MiniStockDTO> findByBrandName(String brandName);


	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE mini_stock u SET u.status='disable' WHERE u.stock_id=?", nativeQuery = true)
	void updateStatus(String stockId);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE mini_stock u SET u.qty=?1 WHERE u.stock_id=?2", nativeQuery = true)
	void updateExistingStock(int qty,String stockId);

	@Query(value="SELECT * FROM mini_stock u WHERE  u.name=?1 AND u.brand_name=?2 AND u.supplier=?3",nativeQuery = true)
	List<MiniStockDTO> getObj(String name, String brandName, String supplier);

}
