package models;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import strategy.PricingStrategy;

import java.util.UUID;

@Getter
@ToString(callSuper = true)
public class TwoWheelerParkingSpot extends ParkingSpot {

    private final int distanceFromEntrance;

    public TwoWheelerParkingSpot(int distanceFromEntrance) {
        super(UUID.randomUUID().toString(), VehicleType.TWO_WHEELER, PricingStrategy.MINUTE_PRICING_STRATEGY, 1.0);
        this.distanceFromEntrance = distanceFromEntrance;
    }
}
