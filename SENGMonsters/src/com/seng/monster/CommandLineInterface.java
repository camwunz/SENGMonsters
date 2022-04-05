package com.seng.monster;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandLineInterface {
	
	static Scanner scanner = new Scanner(System.in);
	public static void main(String argv[])
	{
		String tempName = getName();
		int tempDays = getDays();
	}
	
	
	private static String getName()
	{
		String tempName = "";
		System.out.println("Enter your name:");
		tempName = scanner.nextLine();
		if ((tempName.length() >= 3) && (tempName.length() <= 15))
		{
			if (tempName.matches("^[a-zA-Z]*$"))
			{
				return tempName;
			}
		}
		System.out.println("Sorry invalid username");
		System.out.println("It must be between length 3 & 15 and must not contain numbers or special characters");
		return getName();
	}
	
	private static int getDays()
	{
		int tempDays = 0;
		System.out.println("Enter how many days you would like to play: ");
		try {
			tempDays = scanner.nextInt();
		} catch (InputMismatchException e)
		{
			System.out.println("Sorry invalid input, please enter a number");
			return getDays();
		}
		
		if ((tempDays >= 5) && (tempDays <= 15))
		{
			return tempDays;
		}
		else
		{
			System.out.println("Sorry invalid input, please enter a number between 5 & 15");
			return getDays();
		}
	}
}
