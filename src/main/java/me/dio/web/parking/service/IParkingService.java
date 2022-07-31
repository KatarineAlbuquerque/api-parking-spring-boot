package me.dio.web.parking.service;

import java.util.List;

import me.dio.web.parking.model.Parking;
import me.dio.web.parking.model.dto.ParkingCreateDTO;
import me.dio.web.parking.model.dto.ParkingUpdateDTO;

public interface IParkingService {

	public Parking create(ParkingCreateDTO parkingDTO);
	
	public Parking update(ParkingUpdateDTO parkingDTO);
	
	public void delete(Long id);
	
	public Parking getById(Long id);
	
	public List<Parking> getAll();
	
	public Parking calculateAccounts(Long id);
}
