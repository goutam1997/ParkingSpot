package com.example.demo.strategy;

import com.example.demo.model.FourWheelerPS;
import com.example.demo.model.ParkingSpot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NearEntranceElevatorStrategy implements SpotAssignStrategy {
	Logger logger = LoggerFactory.getLogger(NearEntranceElevatorStrategy.class);

	@Override
	public ParkingSpot assignSpotWithStrategy() {
		logger.info("NearEntranceElevatorStrategy");
		return new FourWheelerPS();
	}

}
