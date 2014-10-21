package com.work.taskbonus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Tringle {

	private int a;
	private int b;
	private int c;

	public Tringle(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

}

public class Main {

	public static ArrayList<Integer> read_file(String filename) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			Scanner scanner = new Scanner(new File(filename));

			while (true) {

				int value = scanner.nextInt();
				list.add(value);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return list;
		}
	}

	private static void terminate() {
		System.out.println("IMPOSSIBLE\r\n");
		System.exit(1);
	}

	private static void compute_tringle(ArrayList<Integer> list) {
		if (list.size() < 16) {
			terminate();
		}

		ArrayList<Tringle> tringles = new ArrayList<Tringle>();
		for (int i = 0; i < 6; i++) {

			int index = i * 3;
			int tringle_value1 = list.get(index);
			int tringle_value2 = list.get(index + 1);
			int tringle_value3 = list.get(index + 2);
			Tringle t = new Tringle(tringle_value1, tringle_value2,
					tringle_value3);
			tringles.add(t);
		}
		for (int i = 0; i < tringles.size(); i++) {
			Tringle now = tringles.get(i);
			Tringle next = null;

			if (!(i == tringles.size() - 1)) {
				next = tringles.get(i + 1);
			}
			// Tringle next = tringles.get(i + 1);
			if (i == tringles.size() - 1) {
				Tringle last = tringles.get(0);
				if (now.getA() == last.getA() || now.getA() == last.getB()
						|| now.getB() == last.getA()
						|| now.getB() == last.getB()) {

				} else {
					terminate();
					break;
				}

			} else {
				if (now.getA() == next.getA() || now.getA() == next.getB()
						|| now.getB() == next.getA()
						|| now.getB() == next.getB()) {

				} else {
					terminate();
					break;
				}
			}

		}
		System.out.println("you got it !\n\r");

		int score = 0;
		for (int x = 0; x < tringles.size(); x++) {
			score += tringles.get(x).getC();
		}
		System.out.println(score);
	}

	public static void main(String[] args) {

		ArrayList<Integer> integers = read_file("/home/youngershen/dev/projects/java-homework-2014-10-19/doc/TestData/test05.dat");
		for (int i = 0; i < integers.size(); i++) {
			System.out.println(integers.get(i));
		}
		compute_tringle(integers);
	}
}
