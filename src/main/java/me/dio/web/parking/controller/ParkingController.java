package me.dio.web.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.web.parking.model.Parking;
import me.dio.web.parking.model.dto.ParkingCreateDTO;
import me.dio.web.parking.model.dto.ParkingUpdateDTO;
import me.dio.web.parking.service.impl.ParkingService;

@RestController
@RequestMapping(value = "/parking")
@Tag(name = "Parking")
@SecurityRequirement(name="api")
public class ParkingController {

	@Autowired
	private ParkingService parkingService;	
	
	@PostMapping(value = "/save")
	@Operation(summary = "Save Parking", description = "Enter the State, Model, End Date (10-30-2022 12:55) and Account (55.99) to save.")
	public ResponseEntity<Parking> saveParking(@RequestBody ParkingCreateDTO parkingDTO) {	
		Parking parking = parkingService.create(parkingDTO);
		return ResponseEntity.ok().body(parking);
	}
	
	@PutMapping(value = "/update/")
	@Operation(summary = "Update Parking", description = "Do a search of all data and enter the Id, State and Model to update.")
	public ResponseEntity<Parking> updateParking(@RequestBody ParkingUpdateDTO parkingDTO) {
		Parking parking = parkingService.update(parkingDTO);
		return ResponseEntity.ok().body(parking);
	} 
	
	@DeleteMapping(value = "/delete/{id}")
	@Operation(summary = "Delete Parking", description = "Do a search of all data and enter the Id to remove.")
	public ResponseEntity<Parking> deleteParking(@PathVariable Long id) {
		parkingService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/search/{id}")
	@Operation(summary = "Search by Parking ID", description = "Do a search of all data and enter the Id to search.")
	public ResponseEntity<Parking> getIdParking(@PathVariable Long id) {
		Parking parking = parkingService.getById(id);		
		return ResponseEntity.ok(parking);
	}
	
	@GetMapping(value = "/search")
	@Operation(summary = "Search All Parking", description = "Do a search of all saved data.")
	public ResponseEntity<List<Parking>> getAllParkings() {	
		List<Parking> parkings = parkingService.getAll();
		return ResponseEntity.ok(parkings);
	}
	
	@GetMapping(value = "/account/{id}")
	@Operation(summary = "Search Parking Account ID", description = "Finalize and calculate the Parking Bill informing the Id of the saved Item.")
	public ResponseEntity<Parking> getAccountParking(@PathVariable Long id) {
		Parking parking = parkingService.calculateAccounts(id);		
		return ResponseEntity.ok(parking);
	}
}
