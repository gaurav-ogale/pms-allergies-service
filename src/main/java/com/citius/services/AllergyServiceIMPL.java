package com.citius.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citius.dao.AllergyDAO;
import com.citius.exception.AllergyException;
import com.citius.model.Allergy;

@Service
public class AllergyServiceIMPL implements AllergyService {

	@Autowired
	private AllergyDAO allergyDAO;

	@Override
	public List<Allergy> getAllergyById(String allergyId) throws AllergyException {
		// TODO Auto-generated method stub
		List<Allergy> list = new ArrayList<>();
		try {
			list = allergyDAO.getAllergyById(allergyId);
			System.out.println("service" + list.isEmpty());

		}

		catch(Exception ex) {
			throw new AllergyException(ex.getMessage());
		}
		return list;
	}

	@Override
	public List<Allergy> getAllergyByType(String allergyType) throws AllergyException {
		// TODO Auto-generated method stub
		List<Allergy> list = new ArrayList<>();
		try {
			list = allergyDAO.getAllergyByType(allergyType);
			System.out.println("service" + list.isEmpty());
		}
		catch(Exception ex) {
			throw new AllergyException(ex.getMessage());
		}
		return list;
	}

	@Override
	public List<Allergy> getAllergies() throws AllergyException{
		// TODO Auto-generated method stub
		List<Allergy> list = new ArrayList<>();
		try {
			list = allergyDAO.getAllergies();
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new AllergyException(e.getMessage());
		}
		return list;
	}

	@Override
	public void enterNewAllergy(Allergy allergy) throws AllergyException {
		try {
			allergyDAO.enterNewAllergy(allergy);
		}
		catch (Exception e) {
			throw new AllergyException(e.getMessage());
		}

	}

}
