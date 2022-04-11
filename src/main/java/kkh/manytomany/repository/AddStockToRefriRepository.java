package kkh.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kkh.manytomany.entity.AddStockToRefriDTO;

@Repository
public interface AddStockToRefriRepository extends JpaRepository<AddStockToRefriDTO, Integer> {

}
