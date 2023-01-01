package com.thisara.controller.dto.meta;

import java.util.List;

/*
 * Copyright the original author.
 * 
 * @author Thisara Alawala
 * @author https://mytechblogs.com
 * @author https://www.youtube.com/channel/UCRJtsC5VYYhmKnEqAGLKc2A
 * @since 2021-05-30
 */
public class GetMetaResponse {

	private String registrationNumber;
	private String chasisNumber;
	private String chasisColor;
	private String status;
	private String engineNumber;
	private String engineCapacity;

	List<MetaArrayDTO> tyres;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(String engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public List<MetaArrayDTO> getTyres() {
		return tyres;
	}

	public void setTyres(List<MetaArrayDTO> tyres) {
		this.tyres = tyres;
	}

	@Override
	public String toString() {
		return "CarDTO [registrationNumber=" + registrationNumber + ", chasisNumber=" + chasisNumber + ", chasisColor="
				+ chasisColor + ", status=" + status + ", engineNumber=" + engineNumber + ", engineCapacity="
				+ engineCapacity + ", tyres=" + tyres + "]";
	}
}
