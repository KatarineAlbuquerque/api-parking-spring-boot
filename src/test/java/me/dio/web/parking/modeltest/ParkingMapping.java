package me.dio.web.parking.modeltest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import me.dio.web.parking.exception.DataNegativeException;
import me.dio.web.parking.exception.DataNullException;
import me.dio.web.parking.servicetest.utiltest.CalculateTestAccount;

public class ParkingMapping {

public static List<ParkingTest> parkings = new ArrayList<>();
	
	public static ParkingTest getCreate() {		
		ParkingTest parking = new ParkingTest("SP", "Fiat", LocalDateTime.now(), LocalDateTime.now(),0.0);	
		validateCreateData(parking);		
		return parking;
	}	

	public static ParkingTest getUpdate() {		
		ParkingTest parking = new ParkingTest(1L, "SP", "Gol", LocalDateTime.now(), LocalDateTime.now(),0.0);	
		validateUpdateData(parking);		
		return parking;
	}
	
	public static ParkingTest getSearch() {
		ParkingTest parking = new ParkingTest(1L, "RJ", "Fusca", LocalDateTime.now(), LocalDateTime.now(),0.0);
		parkings.add(parking);
		parking = parkings.get(0);
		return parking;
	}	
	
	public static List<ParkingTest> getSearchs() {
		ParkingTest parking = new ParkingTest(1L,"RJ", "Fusca", LocalDateTime.now(), LocalDateTime.now(),0.0);
		parkings.add(parking);
		return parkings;
	}

	@SuppressWarnings("unlikely-arg-type")
	public static ParkingTest getDelete() {
		ParkingTest parking = new ParkingTest(1L, "RJ", "Fusca", LocalDateTime.now(), LocalDateTime.now(),0.0);	
		parkings.remove(parking.getId());
		parking.getId();
		return parking;
	}
	
	public static ParkingTest getAccouts() {
		ParkingTest parking = new ParkingTest(1L, "RJ", "Fusca", LocalDateTime.now(), LocalDateTime.MAX,0.0);
		parking.setAccount(CalculateTestAccount.getAccount(parking));
		return parking;
	}
	
	private static void validateCreateData(ParkingTest parking) {
		if(parking.getState() == null || parking.getModel() == null) {
			throw new DataNullException();
		}
		if(parking.getAccount() < 0) {
			throw new DataNegativeException();
		}
	}	
	
	private static void validateUpdateData(ParkingTest parking) {
		if(parking.getState() == null || parking.getModel() == null) {
			throw new DataNullException();
		}
	}
}
