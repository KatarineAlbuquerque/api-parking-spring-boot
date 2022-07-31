package me.dio.web.parking.model.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Create")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParkingCreateDTO {
	
	@JsonIgnore
	private Long id;
	
	private String state;
	
	private String model;
	
	@JsonIgnore
	private LocalDateTime entryDate;
	
	@JsonIgnore
	private LocalDateTime endDate;
		
	@JsonIgnore
	private Double account;
	
	public ParkingCreateDTO() {
		
	}
	
	public ParkingCreateDTO(Long id, String state, String model) {
		this.id = id;
		this.state = state;
		this.model = model;
	}

	public ParkingCreateDTO(String state, String model, LocalDateTime endDate, Double account) {
		this.state = state;
		this.model = model;
		this.endDate = endDate;
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public LocalDateTime getEntryDate() {
		return entryDate;
	}
	
	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Double getAccount() {
		return account;
	}

	public void setAccount(Double account) {
		this.account = account;
	}	
}
