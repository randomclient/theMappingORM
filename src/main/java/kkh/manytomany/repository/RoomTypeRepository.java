package kkh.manytomany.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kkh.manytomany.entity.RoomTypeDTO;

@Repository 
public interface RoomTypeRepository extends JpaRepository<RoomTypeDTO, String>{
	@Query(value = "SELECT * FROM room_type u WHERE u.roomtype_name = ?", nativeQuery = true)
	List<RoomTypeDTO> findByRoomTypeName(String roomtype_name);

	@Query(value = "SELECT * FROM room_type u WHERE u.roomtype_id = ?", nativeQuery = true)
	List<RoomTypeDTO> findByroomTypeId(String roomtype_id);

	@Query(value = "SELECT * FROM room_type u WHERE u.roomtype_status='Active' and u.status='enable'", nativeQuery = true)
	List<RoomTypeDTO> findByRoomTypeStatus();

	@Query(value = "SELECT * FROM room_type u WHERE u.status = 'enable'", nativeQuery = true)
	List<RoomTypeDTO> findAllRoomTypeStatus();

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE room_type u SET u.status='disable' WHERE u.roomtype_id=?", nativeQuery = true)
	void updateStatus(String roletype_id);
}
