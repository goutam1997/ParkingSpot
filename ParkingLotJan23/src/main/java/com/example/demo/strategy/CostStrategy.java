package com.example.demo.strategy;

import com.example.demo.model.ParkingSpot;

public interface CostStrategy {
	double computeCost(ParkingSpot parkingSpot, long entryTime, long exitTime);
}
