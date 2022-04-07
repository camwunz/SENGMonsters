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
				actionStat = "damage";
				setDescription("Increases damage by " + actionImprovement);
				break;
			case "Lopet Berry":
				actionStat = "maxHealth";
				setDescription("Increases max health by " + actionImprovement);
				break;
			case "Wanga Berry":
				actionStat = "currentHealth";
				setDescription("Increases current health by " + actionImprovement);
				break;
			case "Aimpo Berry":
				actionStat = "healAmount";
				setDescription("Increases heal amount by " + actionImprovement);
				break;
			case "Mystery Berry":
				String[] actionList = {"damage", "maxHealth", "currentHealth", "healAmount"};
				actionStat = actionList[rand.nextInt(4)];
				setDescription("Increases a random variable by " + actionImprovement);
				break;
		}
		
	}
	
	/**
	 * Gets the item's details
	 * @return the name, description and price
	 */
	public String getDetails()
	{
		return getName() + ": " + getDescription() + ". Price: " + getPrice();
	}
	
	/**
	 * Gets the items dettails including its sellback price
	 * @return the full details with sellback price
	 */
	public String getDetailsSellback()
	{
		return getName() + ": " + getDescription() + ". Sellback Price: " + getDetailsSellback();
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
	 * Gets the amount the stat is changing by
	 * @return the improvement amount
	 */
	public int getActionImprovement()
	{
		return actionImprovement;
	}
	
}
