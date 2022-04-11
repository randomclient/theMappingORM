package kkh.manytomany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kkh.manytomany.entity.AddStockToRefriDTO;
import kkh.manytomany.repository.AddStockToRefriRepository;

@Service
public class AddStockToRefriService {
	@Autowired
	AddStockToRefriRepository addStockToRefriRepository;
	
	public void insert(AddStockToRefriDTO dto) {
		addStockToRefriRepository.save(dto);
	}
}
