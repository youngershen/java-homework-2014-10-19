package com.work.task12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class TestToyCar {

	private static BufferedReader input_buffer = new BufferedReader(
			new InputStreamReader(System.in));

	public static double compute_car_info(ToyCar car, String model,
			String colour, String odometer, String number_of_trips,
			ArrayList<Double> trip_list) {

		double iodometer = Double.parseDouble(odometer);
		int inumber_of_trips = Integer.parseInt(number_of_trips);
		Iterator<Double> iter = trip_list.iterator();
		double darray[] = new double[trip_list.size()];
		int index = 0;
		while (iter.hasNext()) {
			double value = iter.next();
			iodometer += value;
			darray[index] = value;
			index++;
		}
		iodometer %= 1000.0;

		double distance_per_trip = iodometer
				/ Integer.parseInt(number_of_trips);

		for (int i = 0; i < darray.length; i++) {
			for (int n = i; n < darray.length; n++) {
				if (darray[n] < darray[i]) {
					darray[i] = darray[i] + darray[n];
					darray[n] = darray[i] - darray[n];
					darray[i] = darray[i] - darray[n];
				}
			}
		}

		for (int m = 0; m < darray.length; m++) {

			System.out.println(darray[m]);
		}
		double difference_between_two_consecutive_trips = darray[darray.length - 1]
				- darray[0];

		car.setColour(colour);
		car.setDistance_per_trip(distance_per_trip);
		car.setModel(model);
		car.setOdometer(iodometer);
		car.setTrips(Integer.parseInt(number_of_trips));

		return difference_between_two_consecutive_trips;
	}

	private static ArrayList<Double> valid_trip_distance(
			ArrayList<String> buffer) {

		Iterator<String> iter = buffer.iterator();
		ArrayList<Double> ret = new ArrayList<Double>();

		while (iter.hasNext()) {
			try {
				double distance = Double.parseDouble(iter.next());
				ret.add(distance);
			} catch (Exception e) {
				System.out
						.println("distance of trips must be integer number !");
				System.exit(2);
			}
		}

		return ret;
	}

	private static void print_car_info(ToyCar car, double distance) {
		System.out.println("Model : " + car.getModel());
		System.out.println("Colour :" + car.getColour());
		System.out.println("Odometer :" + car.getOdometer());
		System.out.println("Trips : " + car.getTrips());
		System.out.println("Distance per trip : " + car.getDistance_per_trip());
		System.out.println("Maximum difference between two consecutive trips:"
				+ distance);

	}

	private static boolean valid_data(String model, String colour,
			String odometer, String number_of_trips) {

		int odometer_ = 0;
		int number_of_trips_ = 0;
		try {

			odometer_ = Integer.parseInt(odometer);
			number_of_trips_ = Integer.parseInt(number_of_trips);

		} catch (NumberFormatException e) {

			return false;
		}
		if (odometer_ < 0) {
			return false;
		}
		if (number_of_trips_ < 0) {
			return false;
		}

		return true;
	}

	private static void input_trips() {

	}

	public static void input_control() {

		ToyCar car;
		try {

			System.out.print("Enter model:");
			String model = input_buffer.readLine();
			System.out.print("Enter colour:");
			String colour = input_buffer.readLine();
			System.out.print("Enter odometer value:");
			String odometer = input_buffer.readLine();
			System.out.print("Enter number of trips:");
			String number_of_trips = input_buffer.readLine();

			boolean ret = valid_data(model, colour, odometer, number_of_trips);
			ArrayList<String> trip_distance = new ArrayList<String>();
			if (ret) {
				int trips = Integer.parseInt(number_of_trips);
				for (int i = 0; i < trips; i++) {
					System.out.print("Distance for trip " + i + ":");
					trip_distance.add(input_buffer.readLine());
				}
				ArrayList<Double> dot = valid_trip_distance(trip_distance);

				car = new ToyCar();
				double dbtc = compute_car_info(car, model, colour, odometer,
						number_of_trips, dot);
				print_car_info(car, dbtc);
			}

		} catch (IOException e) {
			System.out.println("something went wrong");
			System.exit(1);
		}
	}

	public static void main(String[] args) {

		input_control();
	}
}
