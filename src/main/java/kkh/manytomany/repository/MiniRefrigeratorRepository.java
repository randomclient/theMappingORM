package kkh.manytomany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kkh.manytomany.entity.MiniRefrigeratorDTO;


@Repository
public interface MiniRefrigeratorRepository extends JpaRepository<MiniRefrigeratorDTO, String>{

	@Query(value="SELECT * FROM mini_refrigerator m WHERE m.mini_refrigerator_id = ?", nativeQuery = true)
	List<MiniRefrigeratorDTO> findByminiRefrigeratorId(String id);
	
	@Query(value="SELECT * FROM mini_refrigerator m WHERE m.mini_refrigerator_id = ?", nativeQuery = true)
	MiniRefrigeratorDTO getObjByminiRefrigeratorId(String id);
	
}
