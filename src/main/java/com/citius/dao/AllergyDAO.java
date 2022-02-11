package com.citius.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citius.exception.AllergyException;
import com.citius.model.Allergy;
import com.citius.repository.AllergyRepo;

@Component
public class AllergyDAO {

	@Autowired
	private AllergyRepo allergyRepo;


	public List<Allergy> getAllergyById(String allergyId) throws AllergyException {
		
		List<Allergy> list = allergyRepo.getAllergyById(allergyId);
		
		if(list.isEmpty())
			throw new AllergyException("No allegy found with given id");
		else
			return list;

	}

	public List<Allergy> getAllergyByType(String allergyType) throws AllergyException{
		
		List<Allergy> list = allergyRepo.getAllergyByType(allergyType);

		if(list.isEmpty())
			throw new AllergyException("No allergy found for this allergy type");
		else
			return list;

	}


	public List<Allergy> getAllergies() throws AllergyException {
		// TODO Auto-generated method stub
		List<Allergy> list = allergyRepo.findAll();
		if(list.isEmpty())
			throw new AllergyException("No allegies found");
		return dbToJson(list);
	}

	public void enterNewAllergy(Allergy allergy) throws AllergyException {
		try 
		{
			allergyRepo.save(allergy);
		}
		catch (Exception e) 
		{
			throw new AllergyException("not saved");
		}

	}
	
	private List<Allergy> dbToJson(List<Allergy> allergyList) {
		List<Allergy> jsonList = new ArrayList<>();
		for (Allergy all : allergyList) {
			Allergy allergy = new Allergy();
			allergy.setAllergyId(all.getAllergyId());
			allergy.setAllergyType(all.getAllergyType());
			allergy.setAllergyName(all.getAllergyName());
			allergy.setAllergyAllergenSource(all.getAllergyAllergenSource());
			allergy.setAllergyIsoforms(all.getAllergyIsoforms());
			allergy.setAllergyAllerginicity(all.getAllergyAllerginicity());
			jsonList.add(allergy);
		}
		return jsonList;
	}

}
