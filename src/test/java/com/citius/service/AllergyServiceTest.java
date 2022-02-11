package com.citius.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.citius.exception.AllergyException;
import com.citius.model.Allergy;
import com.citius.services.AllergyService;



@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AllergyServiceTest {
	
	public static final String DUMMY_SOURCE = "Bos taurus";
	public static final String DUMMY_ID = "A100-T4";
	public static final String DUMMY_NAME = "Dog";
	public static final String DUMMY_TYPE = "Animal";
	public static final String DUMMY_ISOFORM = "Gallus Gal";
	public static final String DUMMY_ALLEN = "IgE but no biological test";
	
	@Mock
	AllergyService allergyService;
	
	@Test
	public void getById_happyCase() throws AllergyException {
		
		Allergy all = new Allergy();
		all.setAllergyAllergenSource(DUMMY_SOURCE);
		all.setAllergyId(DUMMY_ID);
		all.setAllergyName(DUMMY_NAME);
		all.setAllergyType(DUMMY_TYPE);
		all.setAllergyIsoforms(DUMMY_ISOFORM);
		all.setAllergyAllerginicity(DUMMY_ALLEN);
		
		List<Allergy> list = new ArrayList<>();
		list.add(all);
		
		List<Allergy> resultList = new ArrayList<>();

		when(allergyService.getAllergyById(any())).thenReturn(list);
		resultList= allergyService.getAllergyById("");
		assertEquals(resultList, list);
		
	}
	
	@Test(expected = AllergyException.class)
	public void getById_Exception() throws AllergyException {
		
		when(allergyService.getAllergyById(any())).thenThrow(new AllergyException("Exception"));
		allergyService.getAllergyById("");
		
	}

}
