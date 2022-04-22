package kkh.manytomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kkh.manytomany.entity.MiniStockDTO;
import kkh.manytomany.repository.MiniStockRepository;

@Service
public class MiniStockService {
	@Autowired
	private MiniStockRepository miniStockRepository;

	public List<MiniStockDTO> select() {
		List<MiniStockDTO> list = (List<MiniStockDTO>) miniStockRepository.findAll();
		return list;
	}

	public MiniStockDTO save(MiniStockDTO dto) {

		return miniStockRepository.save(dto);
	}

	public MiniStockDTO findByName(String brandName) {
		return miniStockRepository.findByName(brandName);
	}
	
	public List<MiniStockDTO> findByid(String stockId) {
		return miniStockRepository.findBystockId(stockId);
	}

	public List<MiniStockDTO> findAllStatus() {
		return miniStockRepository.findAllStatus();
	}
	
	public List<MiniStockDTO> findAll() {
		return miniStockRepository.findAll();
	}

	public void update(MiniStockDTO miniStock, String stockId) {
		miniStockRepository.save(miniStock);
	}

	public void updateStatus(String stockId) {
		miniStockRepository.updateStatus(stockId);
	}
	
	public List<MiniStockDTO> getObj(String name, String brandName, String supplier){
		return miniStockRepository.getObj(name,brandName,supplier);
	}
	
	public void updateExistingStock(int qty, String stockId) {
		miniStockRepository.updateExistingStock(qty, stockId);
	}

	public List<MiniStockDTO> findByBrandName(String brandName) {
		return miniStockRepository.findByBrandName(brandName);
	}

	
}
