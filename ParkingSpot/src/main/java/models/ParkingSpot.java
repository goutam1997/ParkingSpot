package models;

import lombok.Data;
import strategy.PricingStrategy;

@Data
public class ParkingSpot {
    private String id;
    private PricingStrategy pricingStrategy;
    private VehicleType vehicleType;
    private boolean isEmpty;
    private double chargePerUnitTime;

    public ParkingSpot(String id, VehicleType vehicleType, PricingStrategy pricingStrategy, double chargePerUnitTime) {
        this.id = id;
        this.vehicleType=vehicleType;
        this.pricingStrategy = pricingStrategy;
        this.isEmpty=true;
        this.chargePerUnitTime = chargePerUnitTime;
    }
}
