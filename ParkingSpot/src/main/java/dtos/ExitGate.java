package dtos;

import lombok.extern.slf4j.Slf4j;
import models.Ticket;

@Slf4j
public class ExitGate {
    private ParkingSpotManager parkingSpotManager;
    private TicketManager ticketManager;

    public ExitGate(ParkingSpotManager parkingSpotManager, TicketManager ticketManager) {
        this.parkingSpotManager = parkingSpotManager;
        this.ticketManager = ticketManager;
    }

    public double removeVehicle(String ticketId){
        Ticket ticket = ticketManager.getByTicketId(ticketId);
        System.out.println("Removing vehicle: {}"+ ticket.getVehicle());
        parkingSpotManager.removeVehicle(ticket.getParkingSpot());
        return ticketManager.calculatePrice(ticket);
    }
}
