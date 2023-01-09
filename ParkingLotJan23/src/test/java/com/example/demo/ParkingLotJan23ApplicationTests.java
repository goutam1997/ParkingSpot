package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.strategy.MinuteBasedCost;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.gate.EntranceGate;
import com.example.demo.gate.ExitGate;
import com.example.demo.model.Ticket;
import com.example.demo.model.Vehicle;
import com.example.demo.model.VehicleType;

@SpringBootTest
class ParkingLotJan23ApplicationTests {
	Logger logger = LoggerFactory.getLogger(ParkingLotJan23ApplicationTests.class);

	@Test
	void testWorkflow() {
		Vehicle vehicle = new Vehicle("WB 23.2", VehicleType.TWO_WHEELER);
		
		Ticket ticket = new EntranceGate().workflow(vehicle);
		logger.info("Ticket : " + ticket);
		
		assertEquals(110.0, new ExitGate().getTotalCost(ticket));
		
		Vehicle fourWVehicle = new Vehicle("WB 23.4", VehicleType.FOUR_WHEELER);
		
		Ticket fourWTicket = new EntranceGate().workflow(fourWVehicle);
		logger.info("Ticket : " + fourWTicket);
		
		assertEquals(250.0, new ExitGate().getTotalCost(fourWTicket));		
	}

}
