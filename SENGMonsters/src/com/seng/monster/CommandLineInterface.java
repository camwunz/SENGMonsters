package com.seng.monster;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CommandLineInterface {
	
	/**
	 * Scanner for getting input
	 */
	static Scanner scanner = new Scanner(System.in);
	
	
	/**
	 * Sets up the user data and runs the main loop
	 * @param args
	 */
	public static void main(String args[])
	{
		String tempName = getName();
		int tempDays = getIntBounds("Enter how many days you would like to play: [5-15]", 5, 15);
		Monster tempMonster = getStartingMonster();  
		nameMonster(tempMonster);
		int tempDiff = getDifficulty();
		Player player = new Player(tempDiff, tempDays);
		player.setName(tempName);
		player.addMonster(tempMonster);
		player.setGold(tempMonster.getPrice());
		mainLoop(player);
	}
	
	
	/**
	 * Gets a valid name from the user with only alpha characters and between 5 - 15 letters
	 * @return String name of the user
	 */
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
	
	/**
	 * Presents the user with 5 starting monster options and validates their input to choose one
	 * @return Monster the monster of the user's choice
	 */
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
	
	/**
	 * Presents the user with string s and validates the user input such that the integer selected is lower <= x <= upper
	 * @param s the string to prompt the user with  
	 * @param lower lower bound of the integer range
	 * @param upper upper bound of the integer range
	 * @return int the selected integer from the user
	 */
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
	
	/**
	 * Prompts the user to name their monster and changes the monster's name to that validated input 
	 * @param m the monster whose name is being changed
	 */
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
	
	/**
	 * Gets a valid difficulty from the user
	 * @return int the difficulty ranging from 0-2
	 */
	private static int getDifficulty()
	{
		return getIntBounds("What difficulty would you like? [0-2]", 0, 2);
	}
	
	/**
	 * the main loop or "Menu" of the program
	 * @param p the Player with the details selected earlier
	 */
	private static void mainLoop(Player p)
	{
		for (int i = 1; i <= p.getTotalDays(); i++)
		{
			while (true)
			{
				int outcome = printOptions(i, p);
				
				// View Team
				if (outcome == 1)
				{
					printMonsters(p);
				}
				// View Inventory
				else if (outcome == 2)
				{
					inventory(p);
				}
				// View Battles
				else if (outcome == 3)
				{
					boolean win = battleChoice(p, i);
					if (!win && p.getGold() < 12)
					{
						System.out.println("Game over!");
						System.out.println("You don't have any alive monsters or gold to buy more!");
						System.out.println("Score: " + p.getScore());
						return;
					}
					
				}
				// View Shop
				else if (outcome == 4)
				{
					shop(p);
				}
				// Go to sleep
				else 
				{
					Random rand = new Random();
					System.out.println("End of day " + i);
					for (Monster m : p.getMonsters())
					{
						int new_rand = rand.nextInt(100);
						if (m.getCurrentHealth() == 0)
						{
							if (new_rand <= 10)
							{
								System.out.println(m.getName() + "leveled up!");
								m.levelUp();
							}
						}
						else 
						{
							if (new_rand <= 20)
							{
								System.out.println(m.getName() + " leveled up!");
								m.levelUp();
							}
						}
					}
					if (p.getMonsters().size() > 1)
					{
						ArrayList<Monster> updatedMonsters = new ArrayList<Monster>();
						for (Monster m : p.getMonsters())
						{
							int new_rand = rand.nextInt(100);
							if (m.getCurrentHealth() == 0)
							{
								if (new_rand <= 10)
								{
									System.out.println(m.getName() + " left overnight!");
								}
								else {
									updatedMonsters.add(m);
								}
							}
							else 
							{
								if (new_rand <= 5)
								{
									System.out.println(m.getName() + " left overnight!");
								}
								else {
									updatedMonsters.add(m);
								}
							}
						}
						p.setMonsters(updatedMonsters);
					}
					
					if (p.getMonsters().size() < 4)
					{
						int factor = (4 - p.getMonsters().size())*10;
						if (rand.nextInt(100) <= factor)
						{
							Monster tempMon = new Monster();
							p.addMonster(tempMon);
							System.out.println(tempMon.getName() + " joined your party overnight!");
						}
					}
					break;
				}
			}
		}
		System.out.println("Game Over!");
		System.out.println("You survived all " + p.getTotalDays() + " days");
		System.out.println("Score: " + p.getScore());
	}
	
	/**
	 * Presents the user with input and does one of 4 options depends on whether they want to buy/sell monsters/items or exit
	 * @param p
	 */
	private static void shop(Player p) {
		
		while (true)
		{
			System.out.println("Welcome to the Shop! You have " + p.getGold() + " gold.");
			
			int outcome = getIntBounds("Would you like to shop for monsters (0), items (1), sell monsters (3), sell items (4) or leave (5)?", 0, 5);
			// exit
			if (outcome == 5)
			{
				break;
			}
			// buy new monsters
			if (outcome == 0)
			{
				if (p.getMonsters().size() >= 4)
				{
					System.out.println("You cannot buy new monsters as your party is full.");
				}
				System.out.println("Here are 4 new monsters: ");
				ArrayList<Monster> monsters = new ArrayList<Monster>();
				for (int i = 0; i < 4; i++)
				{
					System.out.println((i+1) + ") ");
					monsters.add(new Monster());
					System.out.println(monsters.get(i).printDetails());
					System.out.println("Price: " + monsters.get(i).getPrice() + "\n");
				}
				System.out.println("5) Exit");
				
				int monsterPicker = getIntBounds("What would you like? [1-5]", 1, 5);
				if (monsterPicker == 5)
				{
					break;
				}
				monsterPicker = monsterPicker-1;
				boolean attempt = p.addMonster(monsters.get(monsterPicker));
				if (!attempt)
				{
					System.out.println("Sorry you do not have enough money to buy that monster");
					break;
				} 
				else {
					System.out.println(monsters.get(monsterPicker).getName() + " has been bought");
					break;
				}
			}
			// buy items
			if (outcome == 1)
			{
				System.out.println("Here are 4 new items: ");
				ArrayList<Item> items = new ArrayList<Item>();
				for (int i = 0; i < 4; i++)
				{
					System.out.println((i+1) + ") ");
					items.add(new Item());
					System.out.println(items.get(i).getDetails());
				}
				System.out.println("5) Exit");
				
				int itemPicker = getIntBounds("What would you like? [1-5]", 1, 5);
				if (itemPicker == 5)
				{
					break;	
				}
				itemPicker--;
				boolean attempt = p.addItem(items.get(itemPicker));
				if (!attempt)
				{
					System.out.println("Sorry you do not have enough money to buy that item");
					break;
				} 
				else {
					System.out.println(items.get(itemPicker).getName() + " has been bought");
					break;
				}
			}
			// sell monsters
			if (outcome == 3)
			{
				
				if (p.getMonsters().size() == 1)
				{
					System.out.println("Not enough monsters to sell");
					break;
				}
				System.out.println("Here are your monsters: ");
				int i = 0;
				for (Monster m : p.getMonsters())
				{
					System.out.println((i+1) + ") ");
					System.out.println("Sellback price: " + m.getSellback() + "\n");
					i++;
				}
				System.out.println((i+1) + ") Exit");
				int monsterPicker = getIntBounds("What would you like? [1-" + (i+1) + "]", 1, i+2);
				if (monsterPicker == i+2)
				{
					break;
				}
				System.out.println("Sold " + p.getMonsters().get(monsterPicker-1).getName());
				p.removeMonster(p.getMonsters().get(monsterPicker-1));
				break;
			}
			// sell items
			if (outcome == 4)
			{
				System.out.println("Here are your items: ");
				int i = 0;
				for (Item j : p.getItems())
				{
					System.out.println((i+1) + ") ");
					System.out.println(j.getDetailsSellback());
					i++;
				}
				System.out.println((i+1) + ") Exit");
				int itemPicker = getIntBounds("What would you like? [1-" + (i+1) + "]", 1, i+2);
				if (itemPicker == i+2)
				{
					break;
				}
				System.out.println("Sold " + p.getItems().get(itemPicker-1).getName());
				p.removeItem(p.getItems().get(itemPicker-1));
				break;
				
			}
			
		}
		
	}


	/**
	 * Prints the options that the user can have for the main menu
	 * @param i the day
	 * @param p the player
	 * @return the valid integer outcome
	 */
	private static int printOptions(int i, Player p)
	{
		System.out.println("Current Gold: " + p.getGold() + " Day " + i + "/" + p.getTotalDays());
		System.out.println("Please choose an option: [1-5]");
		System.out.println("1) View Team");
		System.out.println("2) View Inventory");
		System.out.println("3) View Battles");
		System.out.println("4) Visit Shop");
		System.out.println("5) Go to Sleep");
		return getIntBounds("Please choose an option: [1-5]", 1, 5);
	}
	
	/**
	 * Prints the players's monsters
	 * @param p the player 
	 */
	private static void printMonsters(Player p)
	{
		System.out.println("-------------------Monsters-------------------\n");
		for (Monster m: p.getMonsters())
		{
			System.out.println(m.printDetails());
			System.out.println("\n");
		}
		System.out.println("----------------------------------------------");
	}
	
	/**
	 * Prints out the player's inventory and they may use an item on a monster
	 * @param p the player
	 */
	private static void inventory(Player p)
	{
		for (int j = 1; j <= p.getItems().size(); j++)
		{
			System.out.println(j + ") " + p.getItems().get(j-1).getDetails());
		}
		int temp = 0;
		if (p.getItems().size() != 0)
		{
			
			temp = getIntBounds("Would you like to use an item? (yes=0/no=1)", 0, 1);
			if (temp == 0)
			{
				int itemCount = p.getItems().size();
				int itemIndex = getIntBounds("Which item? [1-" + itemCount + "]", 1, itemCount);
				int monsterCount = p.getMonsters().size();
				int i = 0;
				for (Monster m: p.getMonsters())
				{
					System.out.println((i+1) + ") ");
					System.out.println(m.printDetails());
				}
				int monsterIndex = getIntBounds("Which monster? [1-" + monsterCount + "]", 1, monsterCount);
				useItem(itemIndex-1, monsterIndex-1, p);
			}
		}
		else
		{
			System.out.println("\nInventory is empty\n");
		}
	}
	
	/**
	 * Uses an item on a monster
	 * @param itemIndex the index on the item in the player's items list
	 * @param monsterIndex the index of the monster in the player's monster list
	 * @param p the player
	 */
	private static void useItem(int itemIndex, int monsterIndex, Player p)
	{
		Item item = p.getItems().get(itemIndex);
		p.getMonsters().get(monsterIndex).useItem(item.getActionImprovement(), item.getActionStat());
		System.out.println(item.getName() + " has been used on " + p.getMonsters().get(monsterIndex).getName() + "\n");
	}
	
	/**
	 * Presents the user with a choice of battles, then does the battle
	 * @param p the player
	 * @param day the day to control difficulty
	 * @return boolean on if the player won the battle
	 */
	private static boolean battleChoice(Player p, int day)
	{
		ArrayList<OpposingPlayer> players = new ArrayList<OpposingPlayer>();
		for (int i = 0; i < 4; i++)
		{
			OpposingPlayer tempPlayer = new OpposingPlayer(day);
			players.add(tempPlayer);
			System.out.println((i+1) + ") " + tempPlayer.getDetails());
		}
		int playerIndex = getIntBounds("Which battle would you like? [1-4]", 1, 4);
		Battle battle = new Battle(p, players.get(playerIndex-1));
		boolean win = battle.startBattle();
		return win;
		
	}
}
