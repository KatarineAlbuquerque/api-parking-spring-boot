package me.dio.web.parking.service.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import me.dio.web.parking.model.Parking;

public class CalculateAccounts {
	
	public static final int ONE_HOUR = 60;
	public static final double TWENTY_FOUR_HOURS = ONE_HOUR * 24;
	public static final double HOUR_VALUE = 5.00;
	public static final double ADDITIONAL_PER_HOUR = 2.00;
	public static final double DAY_VALUE = 20.00;
		
	public static Double getAccount(Parking parking) {
		return getAccount(parking.getAccount(), parking.getEntryDate(), parking.getEndDate());
	} 

	public static Double getAccount(Double account, LocalDateTime entryDate, LocalDateTime endDate) {
		
		long minutes = entryDate.until(endDate, ChronoUnit.MINUTES);
		account = 0.0;
		
		if(minutes <= ONE_HOUR) {
			return HOUR_VALUE;
		}
		if(minutes <= TWENTY_FOUR_HOURS) {
			account = HOUR_VALUE;
			int hours = (int) (minutes/ONE_HOUR);
			for(int i=0; i < hours; i++) {
				account+= ADDITIONAL_PER_HOUR;
			}
			return account;
		}
		
		int days = (int) (minutes/TWENTY_FOUR_HOURS);
		for(int i = 0; i < days; i++) {
			account += DAY_VALUE;
		}
		return account;
	}

}
