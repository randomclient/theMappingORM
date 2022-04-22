package kkh.manytomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kkh.manytomany.entity.RoomTypeDTO;
import kkh.manytomany.repository.RoomTypeRepository;

@Service
public class RoomTypeService {
	@Autowired
	private RoomTypeRepository roomTypeRepository;

	public RoomTypeDTO save(RoomTypeDTO dto) {
		return roomTypeRepository.save(dto);
	}

	public void deleteId(String id) {
		roomTypeRepository.deleteById(id);
	}

	public void update(RoomTypeDTO roomType, String roomtype_id) {
		roomTypeRepository.save(roomType);
	}

	public List<RoomTypeDTO> findAll() {
		return roomTypeRepository.findAll();
	}

	public List<RoomTypeDTO> findAllRoomTypeStatus() {
		return roomTypeRepository.findByRoomTypeStatus();
	}

	public RoomTypeDTO selectOne(String roomtype_id) {
		return roomTypeRepository.findById(roomtype_id).get();
	}

	public List<RoomTypeDTO> findByNameandId(String roomtype_name) {
		return roomTypeRepository.findByRoomTypeName(roomtype_name);
	}

	public List<RoomTypeDTO> findByid(String roomtype_id) {
		return roomTypeRepository.findByroomTypeId(roomtype_id);
	}

	public void updateStatus(String roletype_id) {
		roomTypeRepository.updateStatus(roletype_id);
	}

	public List<RoomTypeDTO> findAllStatus() {
		return roomTypeRepository.findAllRoomTypeStatus();
	}
}
