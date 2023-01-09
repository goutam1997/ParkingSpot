package com.example.demo.gate;

import com.example.demo.factory.PSFactory;
import com.example.demo.manager.ParkingLotManager;
import com.example.demo.model.ParkingSpot;
import com.example.demo.model.Ticket;
import com.example.demo.model.Vehicle;

public class EntranceGate {
	private ParkingLotManager parkingLotManager;
	PSFactory factory = new PSFactory();
	Ticket ticket = new Ticket();
	
	public Ticket workflow(Vehicle vehicle) {
		parkingLotManager = factory.getParkingLotManager(vehicle.getVehicleType());
		ParkingSpot parkingSpot = parkingLotManager.findSpace();
		parkingLotManager.parkVehicle(parkingSpot);
		return generateTicket(parkingSpot, vehicle);
	}

	private Ticket generateTicket(ParkingSpot parkingSpot, Vehicle vehicle) {
		ticket.setParkingSpot(parkingSpot);
		ticket.setVehicle(vehicle);
		ticket.setEntryTime(System.currentTimeMillis());
		return ticket;
	}
	
	
}
