package kkh.manytomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kkh.manytomany.entity.RoomDTO;
import kkh.manytomany.repository.RoomRepository;

@Service
public class RoomService {
	@Autowired
	public RoomRepository roomRepository;

	public void save(RoomDTO dto) {
		roomRepository.save(dto);
	}

	public List<RoomDTO> findAll() {
		return roomRepository.findAll();
	}

	public void delete(String id) {
		roomRepository.deleteById(id);

	}

	public RoomDTO update(RoomDTO room, String room_number) {
		return roomRepository.save(room);
	}

	public List<RoomDTO> findByNumber(String room_number) {
		return roomRepository.findByRoomNumber(room_number);
	}

	public List<RoomDTO> findAllStatus() {
		return roomRepository.findAllStatus();
	}

	public void updateStatus(String room_number) {
		roomRepository.updateStatus(room_number);
	}

	public RoomDTO findByRoomnumber(String roomNumber) {
		return roomRepository.findByRoomnumber(roomNumber);
	}

	public List<RoomDTO> findByRoomNumber(String room_number) {
		return roomRepository.findByRoomNumber(room_number);
	}

	public RoomDTO getObjById(String roomNumber) {
		return roomRepository.getObjByRoomNumber(roomNumber);
	}
}
