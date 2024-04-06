package models;

import lombok.Builder;
import lombok.Data;
import models.ParkingSpot;
import models.Vehicle;

import java.time.Instant;
import java.util.Date;

@Builder
@Data
public class Ticket {
    private String id;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private Date entryTime;
}
