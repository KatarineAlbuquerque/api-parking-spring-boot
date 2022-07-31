package me.dio.web.parking;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import me.dio.web.parking.modeltest.ParkingMapping;
import me.dio.web.parking.modeltest.ParkingTest;

@ExtendWith(SpringExtension.class)
class ParkingApplicationTests {
			
	@Test
	void WhenCreatingGetResponse() {		
		ParkingTest parking = ParkingMapping.getCreate();
		Assertions.assertThat(parking).isNotNull();
	}
	
	@Test
	void WhenUpdateGetResponse() {		
		ParkingTest parking = ParkingMapping.getUpdate();
		Assertions.assertThat(parking).isNotNull();
	}
	
	@Test
	void WhenSearchIdGetAnswer() {
		ParkingTest parking = ParkingMapping.getSearch();
		Assertions.assertThat(parking).isNotNull();
	}
	
	@Test
	void WhenSearchAllGetAnswer() {
		List<ParkingTest> parkings = ParkingMapping.getSearchs();
		Assertions.assertThat(parkings).isNotNull();
	}
	
	@Test
	void WhenAccountGetAnswer() {
		ParkingTest parking = ParkingMapping.getAccouts();
		Assertions.assertThat(parking).isNotNull();
	}
}
