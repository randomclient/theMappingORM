package kkh.manytomany.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kkh.manytomany.entity.RoomDTO;

@Repository
public interface RoomRepository extends JpaRepository<RoomDTO, String> {

	@Query(value = "SELECT * FROM room u WHERE u.room_number = ?", nativeQuery = true)
	List<RoomDTO> findByRoomNumber(String room_number);

	@Query(value = "SELECT * FROM room u WHERE u.status = 'enable'", nativeQuery = true)
	List<RoomDTO> findAllStatus();

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE room u SET u.status='disable' WHERE u.room_number=?", nativeQuery = true)
	void updateStatus(String room_number);

	@Query(value = "SELECT * FROM room u WHERE u.room_number = ?", nativeQuery = true)
	RoomDTO findByRoomnumber(String roomNumber);

	@Query(value = "SELECT * FROM room r WHERE r.room_number = ?", nativeQuery = true)
	RoomDTO getObjByRoomNumber(String roomNumber);
}
