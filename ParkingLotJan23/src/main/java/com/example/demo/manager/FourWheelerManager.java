package com.example.demo.manager;

import com.example.demo.strategy.HourBasedCost;
import com.example.demo.strategy.NearEntranceElevatorStrategy;

public class FourWheelerManager extends ParkingLotManager {

	public FourWheelerManager() {
		super.spotStrategy = new NearEntranceElevatorStrategy();
		super.costStrategy = new HourBasedCost();
	}

}
