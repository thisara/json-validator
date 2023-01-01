package com.thisara.controller.dto.meta;


import java.util.List;

import javax.validation.constraints.NotNull;

/*
 * Copyright the original author.
 * 
 * @author Thisara Alawala
 * @author https://mytechblogs.com
 * @author https://www.youtube.com/channel/UCRJtsC5VYYhmKnEqAGLKc2A
 * @since 2021-05-30
 */
public class PostMetaDTO {
	
	@NotNull private String registrationNumber;
	@NotNull private String chasisNumber;
	@NotNull private String chasisColor;
	@NotNull private String number;
	@NotNull private Double capacity;
	@NotNull private List<MetaArrayDTO> tyreData;
	@NotNull private UserDTO user;
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getChasisNumber() {
		return chasisNumber;
	}
	public void setChasisNumber(String chasisNumber) {
		this.chasisNumber = chasisNumber;
	}
	public String getChasisColor() {
		return chasisColor;
	}
	public void setChasisColor(String chasisColor) {
		this.chasisColor = chasisColor;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Double getCapacity() {
		return capacity;
	}
	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}
	public List<MetaArrayDTO> getTyreData() {
		return tyreData;
	}
	public void setTyreData(List<MetaArrayDTO> tyreData) {
		this.tyreData = tyreData;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "PostCarDTO [registrationNumber=" + registrationNumber + ", chasisNumber=" + chasisNumber
				+ ", chasisColor=" + chasisColor + ", number=" + number + ", capacity=" + capacity + ", tyreData="
				+ tyreData + ", user=" + user + "]";
	}
		
}
