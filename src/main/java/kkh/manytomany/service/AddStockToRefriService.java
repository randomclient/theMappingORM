//package kkh.manytomany.service;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import kkh.manytomany.entity.AddStockToRefriDTO;
//import kkh.manytomany.repository.AddStockToRefriRepository;
//
//@Service
//public class AddStockToRefriService {
//	@Autowired
//	AddStockToRefriRepository addStockToRefriRepository;
//
//	public void insert(AddStockToRefriDTO dto) {
//		addStockToRefriRepository.save(dto);
//	}
//
//	public AddStockToRefriDTO  findByIdAndName(String refrigeratorId, String stockName) {
//		return addStockToRefriRepository.findByIdAndName(refrigeratorId,stockName);
//	}
//
//	public List<AddStockToRefriDTO> findAll() {
//		return addStockToRefriRepository.findAll();
//	}
//
//	public boolean isStockExist(String refrigeratorId, String stockName) {
////		AddStockToRefriDTO result = addStockToRefriRepository.isStockExist(stockName);
//
////		if (result != null)
////			return 1;
////		else
////			return 0;
//		return addStockToRefriRepository.isStockExist(refrigeratorId, stockName)!=null ? true : false;
//	}
//
//	public void updateQty(Integer qty,String refrigeratorId, String stockName) {
//		addStockToRefriRepository.updateQty(qty, refrigeratorId, stockName);
//	}
//}
