import dtos.EntranceGate;
import dtos.ExitGate;
import dtos.ParkingSpotManager;
import dtos.TicketManager;
import lombok.extern.slf4j.Slf4j;
import models.ParkingSpot;
import models.Vehicle;
import models.VehicleType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ParkingSpotManager parkingSpotManager = new ParkingSpotManager();
        TicketManager ticketManager = new TicketManager();
        EntranceGate entranceGate = new EntranceGate(parkingSpotManager, ticketManager);
        ExitGate exitGate = new ExitGate(parkingSpotManager, ticketManager);

        List<String> ticketList = new ArrayList<>();
        List<Vehicle> vehicles = Arrays.asList(
                new Vehicle("WB08P-8782", VehicleType.TWO_WHEELER),
                new Vehicle("WB08P-3334", VehicleType.TWO_WHEELER),
                new Vehicle("WB08P-4322", VehicleType.TWO_WHEELER),
                new Vehicle("WB08P-7653", VehicleType.TWO_WHEELER),
                new Vehicle("WB08P-2546", VehicleType.TWO_WHEELER),

                new Vehicle("WB08P-7689", VehicleType.FOUR_WHEELER),
                new Vehicle("WB08P-9854", VehicleType.FOUR_WHEELER),
                new Vehicle("WB08P-5745", VehicleType.FOUR_WHEELER),
                new Vehicle("WB08P-5746", VehicleType.FOUR_WHEELER)
        );
        for (Vehicle vehicle : vehicles) {
            ParkingSpot parkingSpot = entranceGate.findParkingSpot(vehicle.getVehicleType());
            if (parkingSpot == null) {
                System.out.println("No spot found for vehicle: " + vehicle);
            } else {
                System.out.println("Found spot for vehicle: " + vehicle);
                String ticketId = entranceGate.parkVehicle(vehicle, parkingSpot);
                ticketList.add(ticketId);
            }
        }
        System.out.println("______________________________________________________________________");

        System.out.println("Total charge: " + exitGate.removeVehicle(ticketList.get(1)));
        System.out.println("Total charge: " + exitGate.removeVehicle(ticketList.get(3)));
        System.out.println("Total charge: " + exitGate.removeVehicle(ticketList.get(5)));

        Vehicle vehicle = new Vehicle("WB08P-1111", VehicleType.TWO_WHEELER);

        ParkingSpot parkingSpot = entranceGate.findParkingSpot(vehicle.getVehicleType());
        System.out.println("Found spot: " + parkingSpot + " for vehicle: " + vehicle);
    }
}
