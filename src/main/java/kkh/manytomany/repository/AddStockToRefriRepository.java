//package kkh.manytomany.repository;
//
//import javax.transaction.Transactional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import kkh.manytomany.entity.AddStockToRefriDTO;
//
//@Repository
//public interface AddStockToRefriRepository extends JpaRepository<AddStockToRefriDTO, Integer> {
//
//	@Query(value="SELECT * FROM stock_to_refri sr WHERE sr.refrigerator_id=?1 AND sr.stock_name=?2", nativeQuery=true)
//	AddStockToRefriDTO  findByIdAndName(String refrigeratorId, String stockName);
//	
//	@Query(value = "SELECT * FROM stock_to_refri sr WHERE sr.refrigerator_id=?1 AND sr.stock_name=?2", nativeQuery = true)
//	AddStockToRefriDTO isStockExist(String refrigeratorId, String stockName);
//	
//	@Modifying(clearAutomatically = true)
//	@Transactional
//	@Query(value = "UPDATE stock_to_refri u SET u.stock_qty=?1 WHERE u.refrigerator_id=?2 AND u.stock_name=?3", nativeQuery = true)
//	void updateQty(Integer qty,String refrigeratorId, String stockName);
//
//}
