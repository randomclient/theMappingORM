package kkh.manytomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kkh.manytomany.entity.MiniRefrigeratorDTO;
import kkh.manytomany.repository.MiniRefrigeratorRepository;


@Service
public class MiniRefrigeratorService {
	@Autowired
	private MiniRefrigeratorRepository miniRefrigeratorRepository;

	public void save(MiniRefrigeratorDTO entity) {
		miniRefrigeratorRepository.save(entity);
	}

	public List<MiniRefrigeratorDTO> findAll() {
		return miniRefrigeratorRepository.findAll();
	}

	public List<MiniRefrigeratorDTO> findById(String id) {
		return miniRefrigeratorRepository.findByminiRefrigeratorId(id);
	}
	
	public MiniRefrigeratorDTO getObjById(String id) {
		return miniRefrigeratorRepository.getObjByminiRefrigeratorId(id);
	}
}
