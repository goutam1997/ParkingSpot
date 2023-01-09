package com.example.demo.manager;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.factory.PSFactory;
import com.example.demo.model.ParkingSpot;
import com.example.demo.model.VehicleType;
import com.example.demo.strategy.CostStrategy;
import com.example.demo.strategy.SpotAssignStrategy;

public class ParkingLotManager {
	List<ParkingSpot> parkinglot = new ArrayList<>();
	SpotAssignStrategy spotStrategy;
	CostStrategy costStrategy;
	
	public ParkingSpot findSpace() {
		return spotStrategy.assignSpotWithStrategy();
	}
	
	public void parkVehicle(ParkingSpot parkingSpot) {
		parkingSpot.setFull(true);
	}
	
	public double computeCost(ParkingSpot parkingSpot, long entryTime, long exitTime) {
		return parkingSpot.getPrice() + costStrategy.computeCost(parkingSpot, entryTime, exitTime);
	}
}
