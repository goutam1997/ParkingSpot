package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class ParkingSpot {
	int id;
	boolean isFull;
	public abstract double getPrice();
}
