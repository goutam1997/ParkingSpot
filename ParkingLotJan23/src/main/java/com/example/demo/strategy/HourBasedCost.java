package com.example.demo.strategy;

import com.example.demo.model.ParkingSpot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HourBasedCost implements CostStrategy {

	Logger logger = LoggerFactory.getLogger(HourBasedCost.class);
	@Override
	public double computeCost(ParkingSpot parkingSpot, long entryTime, long exitTime) {
		logger.info("HourBasedCost");
		return 4 * 50.0;
	}

}
