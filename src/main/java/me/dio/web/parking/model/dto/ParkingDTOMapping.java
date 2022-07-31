package me.dio.web.parking.model.dto;


import java.time.LocalDateTime;

import me.dio.web.parking.exception.DataNegativeException;
import me.dio.web.parking.exception.DataNullException;
import me.dio.web.parking.model.Parking;

public class ParkingDTOMapping {
	
	public static Parking getParkingCreateDTO(ParkingCreateDTO parkingDTO) {
					
		String state = parkingDTO.getState();
		String model = parkingDTO.getModel();		
		LocalDateTime entryDate = LocalDateTime.now();
		LocalDateTime endDate = parkingDTO.getEndDate();
		parkingDTO.setAccount(0.0);
		Double account = parkingDTO.getAccount();
		
		Parking parking = new Parking(state, model, entryDate, endDate, account);		
		
		validateCreateData(parkingDTO);
		
		parking.getState();
		parking.getModel();
		parking.getEntryDate();
		parking.getEndDate();
		parking.getAccount();
		
		return parking;		
	}	

	public static Parking getParkingUpdateDTO(ParkingUpdateDTO parkingDTO) {
		
		Long id = parkingDTO.getId();		
		String state = parkingDTO.getState();
		String model = parkingDTO.getModel();		
		LocalDateTime entryDate = LocalDateTime.now();
		LocalDateTime endDate = parkingDTO.getEndDate();
		parkingDTO.setAccount(0.0);
		Double account = parkingDTO.getAccount();
		
		Parking parking = new Parking(id, state, model, entryDate, endDate, account);		
		
		validateUpdateData(parkingDTO);
		
		parking.getState();
		parking.getModel();
		parking.getEntryDate();
		parking.getEndDate();
		parking.getAccount();
			
		return parking;	
	}	
	
	private static void validateCreateData(ParkingCreateDTO parking) {
		if(parking.getState() == null || parking.getModel() == null) {
			throw new DataNullException();
		}
		if(parking.getAccount() < 0) {
			throw new DataNegativeException();
		}
	}	
	
	private static void validateUpdateData(ParkingUpdateDTO parking) {
		if(parking.getId() == null || parking.getState() == null || parking.getModel() == null) {
			throw new DataNullException();
		}
		if(parking.getAccount() < 0) {
			throw new DataNegativeException();
		}
	} 
}