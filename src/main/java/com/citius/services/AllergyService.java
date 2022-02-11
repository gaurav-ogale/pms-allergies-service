package com.citius.services;

import java.util.List;

import com.citius.exception.AllergyException;
import com.citius.model.Allergy;

public interface AllergyService {
	
	public List<Allergy> getAllergyById(String allergyId) throws AllergyException;
	
	public List<Allergy> getAllergyByType(String allergyType) throws AllergyException ;

	public List<Allergy> getAllergies() throws AllergyException;

	public void enterNewAllergy(Allergy allergy) throws AllergyException;

}
