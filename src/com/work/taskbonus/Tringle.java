package com.work.taskbonus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tringle {

	
	public static ArrayList<Integer> read_file(String filename){
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			Scanner scanner = new Scanner(new File (filename));
			
			while(true){
					
				int value = scanner.nextInt();
				list.add(value);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return list;
		}	
	}
	
	private static void terminate(){
		System.out.println("IMPOSSIBLE\r\n");
		System.exit(1);
	}
	
	private static void compute_tringle(ArrayList<Integer> list){
		if(list.size() < 16){
			terminate();
		}
		
		
	}
	
	
	public static void main(String[] args){
	
	
	}
}
