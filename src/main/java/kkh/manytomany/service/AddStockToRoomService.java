package kkh.manytomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kkh.manytomany.entity.AddStockToRoomDTO;
import kkh.manytomany.repository.AddStockToRoomRepository;

@Service
public class AddStockToRoomService {
	@Autowired
	private AddStockToRoomRepository addStockToRoomRepository;

	public List<AddStockToRoomDTO> findAll() {
		return addStockToRoomRepository.findAll();
	}

	public boolean isStockExist(String roomNumber, String brandName) {
		return addStockToRoomRepository.isStockExist(roomNumber, brandName) != null ? true : false;
	}

	public AddStockToRoomDTO findByIdAndName(String roomNumber, String brandName) {
		return addStockToRoomRepository.findByIdAndName(roomNumber,brandName);
	}

	public void updateQty(int qty, String roomNumber, String brandName) {
		addStockToRoomRepository.updateQty(qty, roomNumber, brandName);
		
	}

	public void insert(AddStockToRoomDTO dto) {
		addStockToRoomRepository.save(dto);
		
	}

}
