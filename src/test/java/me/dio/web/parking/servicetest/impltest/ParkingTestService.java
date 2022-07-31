package me.dio.web.parking.servicetest.impltest;

import java.util.List;

import org.springframework.stereotype.Service;

import me.dio.web.parking.modeltest.ParkingMapping;
import me.dio.web.parking.modeltest.ParkingTest;
import me.dio.web.parking.servicetest.IParkingTestService;

@Service
public class ParkingTestService implements IParkingTestService {

	@Override
	public ParkingTest create() {			
		ParkingTest parking = ParkingMapping.getCreate();		
		return parking;
	}

	@Override
	public ParkingTest update() {		
		ParkingTest parking = ParkingMapping.getUpdate();			
		return parking;
	}

	@Override
	public void delete() {		
		ParkingMapping.getDelete();	
	}

	@Override
	public ParkingTest getById() {
		ParkingTest parking = ParkingMapping.getSearch();
		return parking;
	}

	@Override
	public List<ParkingTest> getAll() {		
		List<ParkingTest> parkings = ParkingMapping.getSearchs();			
		return parkings;		
	}

	@Override
	public ParkingTest calculateAccount() {
		ParkingTest parking = ParkingMapping.getAccouts();
		return parking;
	}
}
