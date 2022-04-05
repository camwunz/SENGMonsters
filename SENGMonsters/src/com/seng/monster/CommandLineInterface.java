package com.seng.monster;
import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandLineInterface {
	
	static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])
	{
		String tempName = getName();
		int tempDays = getIntBounds("Enter how many days you would like to play: [5-15]", 5, 15);
		Monster tempMonster = getStartingMonster();  
		nameMonster(tempMonster);
		int tempDiff;
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
	
	private static Monster getStartingMonster()
	{
		System.out.println("Which Monster would you like? [1-5]");
		ArrayList<Monster> monsterChoices = new ArrayList<Monster>();
		for (int i = 0; i < 5; i++)
		{
			Monster tempMon = new Monster();
			monsterChoices.add(tempMon);
			System.out.println((i+1) + ") " + tempMon);
		}
		int monID = getIntBounds("Which Monster would you like? [1-5]", 1, 5);
		return monsterChoices.get(monID-1);
		
	}
	
	private static int getIntBounds(String s, int lower, int upper)
	{
		String temp = "";
		System.out.println(s);
		temp = scanner.nextLine();
		if (temp.matches("-?[0-9]+"))
		{
			int tempInt = Integer.parseInt(temp);
			if ((tempInt >= lower) && (tempInt <= upper))
			{
				return tempInt;
			}
			else
			{
				System.out.println("Sorry invalid input, please enter a number between 1 & 5");
				return getIntBounds(s, lower, upper);
			}
		}
		else {
			System.out.println("Sorry invalid input, please enter a number");
			return getIntBounds(s, lower, upper);
		}
	}
	
	private static void nameMonster(Monster m)
	{
		System.out.println("What is its name?");
		String temp = scanner.nextLine();
		if (temp.length() <= 2)
		{
			System.out.println("Sorry, invalid input.");
			nameMonster(m);
		}
		else {
			m.setName(temp);;
		}
	}
}
