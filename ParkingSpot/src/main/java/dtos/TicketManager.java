package dtos;

import lombok.extern.slf4j.Slf4j;
import models.ParkingSpot;
import models.Ticket;
import models.Vehicle;
import models.VehicleType;
import strategy.PricingStrategy;

import java.util.*;

@Slf4j
public class TicketManager {
    private Map<String, Ticket> tickets;

    public TicketManager() {
        this.tickets = new HashMap<>();
    }

    public String generateTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        if (VehicleType.TWO_WHEELER == vehicle.getVehicleType()) {
            cal.add(Calendar.MINUTE, -20);
        } else {
            cal.add(Calendar.HOUR, -2);
        }
        Ticket ticket = Ticket.builder()
                .id(UUID.randomUUID().toString())
                .vehicle(vehicle)
                .parkingSpot(parkingSpot)
                .entryTime(cal.getTime())
                .build();
        System.out.println("Ticket generated: {}" + ticket);
        tickets.put(ticket.getId(), ticket);
        return ticket.getId();
    }

    public Ticket getByTicketId(String ticketId) {
        return tickets.get(ticketId);
    }

    public double calculatePrice(Ticket ticket) {
        long difference_In_Time = new Date().getTime() - ticket.getEntryTime().getTime();
        PricingStrategy pricingStrategy = ticket.getParkingSpot().getPricingStrategy();
        double totalCharge;

        if (PricingStrategy.MINUTE_PRICING_STRATEGY == pricingStrategy) {
            long difference_In_Minutes = (difference_In_Time / (1000 * 60)) % 60;
            System.out.println("Diff in min: " + difference_In_Minutes);
            totalCharge = ticket.getParkingSpot().getChargePerUnitTime() * difference_In_Minutes;
        } else {
            long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)) % 24;
            System.out.println("Diff in hour: " + difference_In_Hours);
            totalCharge = ticket.getParkingSpot().getChargePerUnitTime() * difference_In_Hours;
        }
        return totalCharge;
    }
}
