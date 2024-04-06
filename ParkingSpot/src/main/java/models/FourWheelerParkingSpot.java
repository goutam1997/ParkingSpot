package models;

import lombok.Getter;
import lombok.ToString;
import strategy.PricingStrategy;

import java.util.UUID;

@Getter
@ToString(callSuper = true)
public class FourWheelerParkingSpot extends ParkingSpot {
    private int distanceFromEntranceAndElevator;

    public FourWheelerParkingSpot(int distance) {
        super(UUID.randomUUID().toString(), VehicleType.FOUR_WHEELER, PricingStrategy.HOURLY_PRICING_STRATEGY, 110.0);
        this.distanceFromEntranceAndElevator=distance;
    }
}
