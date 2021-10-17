package com.hcl.cs.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Pet {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer petId;
	@NotEmpty(message="name cant be empty")
	private String petName;
	@NotNull(message="please enter Age between 1 and 99")
	@Min(value=1)
	@Max(value=99)
	private Integer petAge;
	@NotEmpty
	private String petPlace;
	private Integer userId;
	public Integer getPetId() {
		return petId;
	}
	public void setPetId(Integer petId) {
		this.petId = petId;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public Integer getPetAge() {
		return petAge;
	}
	public void setPetAge(Integer petAge) {
		this.petAge = petAge;
	}
	public String getPetPlace() {
		return petPlace;
	}
	public void setPetPlace(String petPlace) {
		this.petPlace = petPlace;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Pet(Integer petId, String petName, Integer petAge, String petPlace, Integer userId) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.petAge = petAge;
		this.petPlace = petPlace;
		this.userId = userId;
	}
	public Pet() {
		super();
		
	}
	
	
	
	
	
	

}
