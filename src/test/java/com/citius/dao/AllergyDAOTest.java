package com.citius.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
import com.citius.repository.AllergyRepo;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AllergyDAOTest {
	
	public static final String DUMMY_SOURCE = "Bos taurus";
	public static final String DUMMY_ID = "A100-T4";
	public static final String DUMMY_NAME = "Dog";
	public static final String DUMMY_TYPE = "Animal";
	public static final String DUMMY_ISOFORM = "Gallus Gal";
	public static final String DUMMY_ALLEN = "IgE but no biological test";
	
	@Mock
	AllergyDAO allergyDAO;
	
	@Mock
	AllergyRepo allergyRepo;
	
	@Test
	public void getByType_HappyCase() throws AllergyException {
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

		when(allergyDAO.getAllergyByType(any())).thenReturn(list);
		resultList= allergyDAO.getAllergyByType("animal");
		assertEquals(resultList, list);
	}
	
	@Test(expected = AllergyException.class)
	public void getByType_catchException() throws AllergyException {
		
		when(allergyDAO.getAllergyByType(any())).thenThrow(new AllergyException("Exception"));
		allergyDAO.getAllergyByType("animal");
		verify(allergyRepo, times(1));
		
	}

}
