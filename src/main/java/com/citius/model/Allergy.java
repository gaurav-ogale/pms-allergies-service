package com.citius.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="allergies")
public class Allergy {
	
	@Id
	@Column(name="allergy_id")
	private String allergyId;
	
	@Column(name="allergy_type")
	private String allergyType;
	
	@Column(name="allergy_name")
	private String allergyName;
	
	@Column(name="allergy_allergen_source")
	private String allergyAllergenSource;
	
	@Column(name="allergy_isoforms_partial_sequences_allergen")
	private String allergyIsoforms;
	
	@Column(name="allergy_allerginicity")
	private String allergyAllerginicity;

	public String getAllergyId() {
		return allergyId;
	}

	public void setAllergyId(String allergyId) {
		this.allergyId = allergyId;
	}

	public String getAllergyType() {
		return allergyType;
	}

	public void setAllergyType(String allergyType) {
		this.allergyType = allergyType;
	}

	public String getAllergyName() {
		return allergyName;
	}

	public void setAllergyName(String allergyName) {
		this.allergyName = allergyName;
	}

	public String getAllergyAllergenSource() {
		return allergyAllergenSource;
	}

	public void setAllergyAllergenSource(String allergyAllergenSource) {
		this.allergyAllergenSource = allergyAllergenSource;
	}

	public String getAllergyIsoforms() {
		return allergyIsoforms;
	}

	public void setAllergyIsoforms(String allergyIsoforms) {
		this.allergyIsoforms = allergyIsoforms;
	}

	public String getAllergyAllerginicity() {
		return allergyAllerginicity;
	}

	public void setAllergyAllerginicity(String allergyAllerginicity) {
		this.allergyAllerginicity = allergyAllerginicity;
	}
	
}
