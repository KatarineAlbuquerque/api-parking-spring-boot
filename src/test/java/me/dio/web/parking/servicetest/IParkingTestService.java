package me.dio.web.parking.servicetest;

import java.util.List;

import me.dio.web.parking.modeltest.ParkingTest;

public interface IParkingTestService {

	public ParkingTest create();
	
	public ParkingTest update();
	
	public void delete();
	
	public ParkingTest getById();
	
	public List<ParkingTest> getAll();
	
	public ParkingTest calculateAccount();
}
