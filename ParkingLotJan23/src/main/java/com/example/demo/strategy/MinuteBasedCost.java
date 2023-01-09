package com.example.demo.strategy;

import com.example.demo.model.ParkingSpot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinuteBasedCost implements CostStrategy {
	Logger logger = LoggerFactory.getLogger(MinuteBasedCost.class);

	@Override
	public double computeCost(ParkingSpot parkingSpot, long entryTime, long exitTime) {
		logger.info("MinuteBasedCost");
		return 3 * 30.0;
	}

}
