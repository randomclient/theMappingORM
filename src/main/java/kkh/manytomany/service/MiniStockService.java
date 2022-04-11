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

	public MiniStockDTO findByName(String stockName) {
		return miniStockRepository.findByName(stockName);
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
}
