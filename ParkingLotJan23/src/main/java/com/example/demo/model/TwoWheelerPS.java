package com.example.demo.model;

import lombok.ToString;

@ToString
public class TwoWheelerPS extends ParkingSpot {

	@Override
	public double getPrice() {
		return 20.0;
	}
	
}
