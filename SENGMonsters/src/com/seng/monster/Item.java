package com.seng.monster;
import java.util.Random;



public class Item extends BaseItem{
	/**
	 * Stat for which the item changes
	 */
	String actionStat = "";
	/**
	 * Amount to improve a stat by
	 */
	int actionImprovement = 0;
	/**
	 * Names to choose from
	 */
	String[] berries = {"Cheppa Berry", "Lopet Berry", "Wanga Berry", "Mystery Berry", "Aimpo Berry"};
	/**
	 * Random seed
	 */
	Random rand = new Random(); 
	
	/**
	 * Constructor
	 * Sets details of the item
	 */
	public Item() {
		super();
		setPrice(rand.nextInt(11) + 5);
		setSellback((int)getPrice()/2);
		createItem();
	}
	
	/**
	 * Creates the new item
	 * Picks from random list for which stat to change
	 * and randomly generates how much to change it by
	 */
	private void createItem()
	{
		String berryName = berries[rand.nextInt(5)];
		setName(berryName);
		actionImprovement = rand.nextInt(16) + 7;
		switch(berryName)
		{
			case "Cheppa Berry":
				actionStat = "Damage";
				setDescription("Increases damage by " + actionImprovement);
				break;
			case "Lopet Berry":
				actionStat = "Max Health";
				setDescription("Increases max health by " + actionImprovement);
				break;
			case "Wanga Berry":
				actionStat = "Current Health";
				setDescription("Increases current health by " + actionImprovement);
				break;
			case "Aimpo Berry":
				actionStat = "Heal Amount";
				setDescription("Increases heal amount by " + actionImprovement);
				break;
			case "Mystery Berry":
				String[] actionList = {"Damage", "Max Health", "Current Health", "Heal Amount"};
				actionStat = actionList[rand.nextInt(4)];
				setDescription("Increases a random variable by " + actionImprovement);
				setPrice((int) (getPrice()/(1.2)));
				break;
		}
		
	}
	
	/**
	 * Gets the item's details
	 * @return the name, description and price
	 */
	public String getDetails(boolean html)
	{
		if (html)
		{
			String output = "<html>";
			output += "Name: " + getName() + "<br />";
			output += "Stat: " + getActionStatHidden() + "<br />";
			output += "Stat increase: " + getActionImprovement() + "<br />";
			return output;
		}
		return getName() + ": " + getDescription() + ". Price: " + getPrice();
	}
	

	/**
	 * Gets the stat that the item is changing
	 * @return the changing stat
	 */
	public String getActionStat()
	{
		return actionStat;
	}
	
	/**
	 * Gets the stat that the item is changing for the user to read, but hide mystery berries
	 * @return the changing stat (or ?)
	 */
	public String getActionStatHidden()
	{
		if (getName().equals("Mystery Berry"))
		{
			return "?";
		}
		return getActionStat();
	}
	
	/**
	 * Gets the amount the stat is changing by
	 * @return the improvement amount
	 */
	public int getActionImprovement()
	{
		return actionImprovement;
	}

	/**
	 * Gets the items details for the selling page of the shop
	 * @param if needs html for the gui
	 * @return the item's details with sellback price
	 */
	public String getDetailsSellback(boolean html) {
		String sep = "\n";
		String start = "";
		if (html)
		{
			start = "<html>";
			sep = "<br />";
		}
		String output = start;
		output += "Name: " + getName() + sep;
		output += "Stat: " + getActionStatHidden() + sep;
		output += "Stat increase: " + getActionImprovement() + sep;
		output += "Selling Price: " + getSellback() + sep;
		return output;
		
	}
	
	/**
	 * Gets the items details for the buying page of the shop
	 * @param if needs html for the gui
	 * @return the item's details with purchase price
	 */

	public String getDetailsPrice(boolean html) {
		String sep = "\n";
		String start = "";
		if (html)
		{
			start = "<html>";
			sep = "<br />";
		}
		String output = start;
		output += "Name: " + getName() + sep;
		output += "Stat: " + getActionStatHidden() + sep;
		output += "Stat increase: " + getActionImprovement() + sep;
		output += "Price: " + getPrice() + sep;
		return output;
		
	}
	
	/**
	 * Allows healthBorder to work with Items and baseItemInterface (defaults at 1)
	 * @return 1 (default for items)
	 */
	public int getCurrentHealth()
	{
		return 1;
	}
	
}
