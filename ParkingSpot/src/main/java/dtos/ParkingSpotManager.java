package dtos;

import models.FourWheelerParkingSpot;
import models.ParkingSpot;
import models.TwoWheelerParkingSpot;
import models.VehicleType;

import java.util.*;

public class ParkingSpotManager {
    private final Queue<TwoWheelerParkingSpot> twoWheelerParkingSpots = new PriorityQueue<>(
            Comparator.comparingInt(TwoWheelerParkingSpot::getDistanceFromEntrance));
    private final Queue<FourWheelerParkingSpot> fourWheelerParkingSpots = new PriorityQueue<>(
            Comparator.comparingInt(FourWheelerParkingSpot::getDistanceFromEntranceAndElevator));

    Map<String, TwoWheelerParkingSpot> filledTwoWheelerSpots = new HashMap<>();
    Map<String, FourWheelerParkingSpot> filledFourWheelerSpots = new HashMap<>();

    public ParkingSpotManager() {
        twoWheelerParkingSpots.addAll(Arrays.asList(
                new TwoWheelerParkingSpot(1),
                new TwoWheelerParkingSpot(3),
                new TwoWheelerParkingSpot(5),
                new TwoWheelerParkingSpot(7)
        ));
        fourWheelerParkingSpots.addAll(Arrays.asList(
                new FourWheelerParkingSpot(21),
                new FourWheelerParkingSpot(25),
                new FourWheelerParkingSpot(29)
        ));
    }

    public ParkingSpot findSpace(VehicleType vehicleType) {
        ParkingSpot parkingSpot = null;
        switch (vehicleType) {
            case TWO_WHEELER -> {
                parkingSpot = twoWheelerParkingSpots.peek();
            }
            case FOUR_WHEELER -> {
                parkingSpot = fourWheelerParkingSpots.peek();
            }
        }

        return parkingSpot;
    }

    public void parkVehicle(ParkingSpot parkingSpot) {
        switch (parkingSpot.getVehicleType()) {
            case TWO_WHEELER -> {
                twoWheelerParkingSpots.remove(parkingSpot);
                filledTwoWheelerSpots.put(parkingSpot.getId(), (TwoWheelerParkingSpot) parkingSpot);
            }
            case FOUR_WHEELER -> {
                fourWheelerParkingSpots.remove(parkingSpot);
                filledFourWheelerSpots.put(parkingSpot.getId(), (FourWheelerParkingSpot) parkingSpot);
            }
        }
        parkingSpot.setEmpty(false);
    }

    public void removeVehicle(ParkingSpot parkingSpot) {
        switch (parkingSpot.getVehicleType()) {
            case TWO_WHEELER -> {
                twoWheelerParkingSpots.add((TwoWheelerParkingSpot) parkingSpot);
                filledTwoWheelerSpots.remove(parkingSpot.getId());
            }
            case FOUR_WHEELER -> {
                fourWheelerParkingSpots.add((FourWheelerParkingSpot) parkingSpot);
                filledFourWheelerSpots.remove(parkingSpot.getId());
            }
        }
        parkingSpot.setEmpty(true);
        System.out.println("Freed spot: "+parkingSpot);
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
    }

    public void removeParkingSpot(ParkingSpot parkingSpot) {
    }
}
