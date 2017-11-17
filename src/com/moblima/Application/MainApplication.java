package com.moblima.Application;

import java.util.Scanner;

/**
 * The main application.
 */
public class MainApplication {
	
	private static Scanner sc = new Scanner(System.in);

	/**
	 * The main method to run.
	 */
	public static void main(String[] args){
		
		System.out.println("Are you a user or a staff? (1 for user, 2 for staff)");
		int value;
		while (true){
			value = sc.nextInt();
			if (value!=1 && value!=2)
				System.out.println("Not a valid input! Please enter another input: ");
			else
				break;
		}
		
		if (value==1){
			UserApplication.main();
			System.out.println();
		}
		else{
			StaffApplication.main();
			System.out.println();
		}

		System.out.println("Closing Application...");

		sc.close();
	}
}
