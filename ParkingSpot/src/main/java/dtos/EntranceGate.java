package dtos;

import lombok.extern.slf4j.Slf4j;
import models.ParkingSpot;
import models.Vehicle;
import models.VehicleType;

import java.util.Date;
import java.util.UUID;

@Slf4j
public class EntranceGate {
    private final ParkingSpotManager parkingSpotManager;
    private final TicketManager ticketManager;

    public EntranceGate(ParkingSpotManager parkingSpotManager, TicketManager ticketManager) {
        this.parkingSpotManager = parkingSpotManager;
        this.ticketManager = ticketManager;
    }

    public ParkingSpot findParkingSpot(VehicleType vehicleType){
        return parkingSpotManager.findSpace(vehicleType);
    }

    public String parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot){
        parkingSpotManager.parkVehicle(parkingSpot);
        return ticketManager.generateTicket(vehicle, parkingSpot);
    }
}
