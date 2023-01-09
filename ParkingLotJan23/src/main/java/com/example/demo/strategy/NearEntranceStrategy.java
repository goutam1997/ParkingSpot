package com.example.demo.strategy;

import com.example.demo.model.ParkingSpot;
import com.example.demo.model.TwoWheelerPS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NearEntranceStrategy implements SpotAssignStrategy {
	Logger logger = LoggerFactory.getLogger(NearEntranceStrategy.class);

	@Override
	public ParkingSpot assignSpotWithStrategy() {
		logger.info("NearEntranceStrategy");
		return new TwoWheelerPS();
	}

}
