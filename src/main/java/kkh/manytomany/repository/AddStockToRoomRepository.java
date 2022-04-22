package kkh.manytomany.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kkh.manytomany.entity.AddStockToRoomDTO;

@Repository
public interface AddStockToRoomRepository extends JpaRepository<AddStockToRoomDTO, Integer> {

	@Query(value="SELECT * FROM stock_to_room sr WHERE sr.room_number=?1 AND sr.brand_name=?2", nativeQuery=true)
	AddStockToRoomDTO  findByIdAndName(String roomNumber, String brandName);
	
	@Query(value = "SELECT * FROM stock_to_room sr WHERE sr.room_number=?1 AND sr.brand_name=?2", nativeQuery = true)
	AddStockToRoomDTO isStockExist(String roomNumber, String brandName);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE stock_to_room u SET u.stock_qty=?1 WHERE u.room_number=?2 AND u.brand_name=?3", nativeQuery = true)
	void updateQty(Integer qty,String roomNumber, String brandName);

}
