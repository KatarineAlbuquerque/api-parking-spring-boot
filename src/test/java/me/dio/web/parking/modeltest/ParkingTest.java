package me.dio.web.parking.modeltest;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ParkingTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	private String state;
		
	private String model;
		
	@JsonFormat(pattern="dd-MM-yyyy HH:m")
	private LocalDateTime entryDate;	
		
	@JsonFormat(pattern="dd-MM-yyyy HH:m")
	private LocalDateTime endDate;
		
	private Double account;
		
	public ParkingTest() {
			
	}	
		
	public ParkingTest(Long id, String state, String model) {
		this.id = id;
		this.state = state;
		this.model = model;
	}
		
	public ParkingTest(String state, String model, LocalDateTime entryDate, LocalDateTime endDate, Double account) {
		this.state = state;
		this.model = model;
		this.entryDate = entryDate;
		this.endDate = endDate;
		this.account = account;
	}

	public ParkingTest(Long id, String state, String model, LocalDateTime entryDate, LocalDateTime endDate,
				Double account) {
		this.id = id;
		this.state = state;
		this.model = model;
		this.entryDate = entryDate;
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
