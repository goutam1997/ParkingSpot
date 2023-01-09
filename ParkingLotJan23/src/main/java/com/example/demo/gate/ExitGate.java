package com.example.demo.gate;

import com.example.demo.factory.PSFactory;
import com.example.demo.manager.ParkingLotManager;
import com.example.demo.model.Ticket;
import com.example.demo.strategy.CostStrategy;

public class ExitGate {
	private ParkingLotManager parkingLotManager;
	Ticket ticket;
	PSFactory factory=new PSFactory();
	
	public double getTotalCost(Ticket ticket) {
		parkingLotManager = factory.getParkingLotManager(ticket.getVehicle().getVehicleType());
		return parkingLotManager.computeCost(ticket.getParkingSpot(), ticket.getEntryTime(), 
				System.currentTimeMillis() + 100);
	}
}
