package me.dio.web.parking.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.web.parking.exception.IdNullException;
import me.dio.web.parking.model.Parking;
import me.dio.web.parking.model.dto.ParkingCreateDTO;
import me.dio.web.parking.model.dto.ParkingDTOMapping;
import me.dio.web.parking.model.dto.ParkingUpdateDTO;
import me.dio.web.parking.repository.ParkingRepository;
import me.dio.web.parking.service.IParkingService;
import me.dio.web.parking.service.util.CalculateAccounts;


@Service
public class ParkingService implements IParkingService {
		
	@Autowired
	private ParkingRepository parkingRepository;
		
	@Override
	public Parking create(ParkingCreateDTO parkingDTO) {			
		Parking parking = ParkingDTOMapping.getParkingCreateDTO(parkingDTO);		
		return parkingRepository.save(parking);
	}

	@Override
	public Parking update(ParkingUpdateDTO parkingDTO) {		
		Parking parking = ParkingDTOMapping.getParkingUpdateDTO(parkingDTO);			
		return parkingRepository.saveAndFlush(parking);
	}

	@Override
	public void delete(Long id) {		
		Parking parking = parkingRepository.findById(id).orElseGet(() -> {
			throw new IdNullException();
		});
		parkingRepository.delete(parking);		
	}

	@Override
	public Parking getById(Long id) {
		Parking parking = parkingRepository.findById(id).orElseGet(() -> {
			throw new IdNullException();
		});
		return parking;
	}

	@Override
	public List<Parking> getAll() {		
		List<Parking> parkings = parkingRepository.findAll();			
		return parkings;		
	}

	@Override
	public Parking calculateAccounts(Long id) {
		Parking parking = getById(id);
		parking.setEndDate(LocalDateTime.now());
		parking.setAccount(CalculateAccounts.getAccount(parking));
		parkingRepository.save(parking);
		return parking;
	}		
}
