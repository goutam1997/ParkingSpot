package com.example.demo.manager;

import com.example.demo.strategy.MinuteBasedCost;
import com.example.demo.strategy.NearEntranceStrategy;

public class TwoWheelerManager extends ParkingLotManager {

	public TwoWheelerManager() {
		super.spotStrategy = new NearEntranceStrategy();
		super.costStrategy = new MinuteBasedCost();
	}
}
