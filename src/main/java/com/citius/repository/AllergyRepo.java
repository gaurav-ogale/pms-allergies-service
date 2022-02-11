package com.citius.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citius.model.Allergy;

@Repository
public interface AllergyRepo extends JpaRepository<Allergy,String> {
	
	@Query(value = "select * from allergies a where a.allergy_id = ?1",nativeQuery = true)
	public List<Allergy> getAllergyById(String id);
	
	@Query(value = "select * from allergies a where a.allergy_type = ?1",nativeQuery = true)
	public List<Allergy> getAllergyByType(String type);

	

}
