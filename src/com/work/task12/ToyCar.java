package com.work.task12;

public class ToyCar {

	private String model;
	private String colour;
	private int trips;
	private double distance_per_trip;
	private double odometer;

	public ToyCar(String model, String colour, int trips, double dpt,
			double odometer) {
		this.model = model;
		this.colour = colour;
		this.trips = trips;
		this.distance_per_trip = dpt;
		this.odometer = odometer;
	}

	public ToyCar() {
		this.model = "No model";
		this.colour = "block";
		this.trips = 0;
		this.distance_per_trip = 0.0;
		this.odometer = 999.9;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getTrips() {
		return trips;
	}

	public void setTrips(int trips) {
		this.trips = trips;
	}

	public double getDistance_per_trip() {
		return distance_per_trip;
	}

	public void setDistance_per_trip(double distance_per_trip) {
		this.distance_per_trip = distance_per_trip;
	}

	public double getOdometer() {
		return odometer;
	}

	public void setOdometer(double odometer) {
		this.odometer = odometer;
	}

}
