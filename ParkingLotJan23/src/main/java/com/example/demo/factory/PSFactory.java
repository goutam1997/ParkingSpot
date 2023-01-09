package com.example.demo.factory;

import com.example.demo.manager.*;
import com.example.demo.model.VehicleType;
import com.example.demo.strategy.CostStrategy;
import com.example.demo.strategy.HourBasedCost;
import com.example.demo.strategy.MinuteBasedCost;

public class PSFactory {
	public ParkingLotManager getParkingLotManager(VehicleType vt) {
		if(VehicleType.TWO_WHEELER.equals(vt)) {
			return new TwoWheelerManager();
		} else {
			return new FourWheelerManager();
		}
	}
}
