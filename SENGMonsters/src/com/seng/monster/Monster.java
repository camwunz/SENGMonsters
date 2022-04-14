package com.seng.monster;
import java.util.Random;

public class Monster extends BaseItem{
	
	/**
	 * Maximum health of the monster
	 */
	int maxHealth = 0;
	/**
	 * Attacking damage of monster
	 */
	int damage = 0;
	/**
	 * Healing amount of monster
	 */
	int healAmount = 0;
	/**
	 * Current health of monster
	 */
	int currentHealth = maxHealth;
	/**
	 * Names to choose from
	 */
	String[] namePool = {"Salamaslash","Hyetar","Parrow","Dolphair","Chillboon","Starraffe","Dewossum","Fieritar","Walruse","Brawnkey"};
	

	/**
	 * Constructor
	 * Makes stats for monster
	 */
	public Monster() {
		super();
		Random rand = new Random(); 
		setPrice(rand.nextInt(21) + 30);
		setSellback((int)getPrice()/2);
		createStats();
		setName(namePool[rand.nextInt(10)]);
		setDescription(createDescription());

	}
	
	/**
	 * Gets monster's health
	 * @return health of monster
	 */
	public int getHealth()
	{
		return maxHealth;
	}
	
	/**
	 * Gets monsters current health
	 * @return the current health of monster
	 */
	public int getCurrentHealth()
	{
		return currentHealth;
	}
	
	/**
	 * Gets the attacking damage of the monster
	 * @return the attacking damage of the monster
	 */
	public int getDamage()
	{
		return damage;
	}
	
	/**
	 * Applies an attack of size damage to the monster
	 * @param damage the amount of the damage
	 * @return whether or not the monster has fainted
	 */
	public Boolean takeAttack(int damage)
	{
		currentHealth -= damage;
		if (currentHealth < 0)
		{
			currentHealth = 0;
			return true;
		}
		return false;
	}
	/**
	 * Creates random stats for the monster
	 */
	private void createStats()
	{
		Random rand = new Random(); 
		maxHealth = rand.nextInt(41) + 80;
		currentHealth = maxHealth;
		healAmount = rand.nextInt((int)maxHealth/3);
		damage = rand.nextInt(31) + 20;
	}
	
	/**
	 * Modifies the monster's stats based on the current day ratio
	 * @param day the day to change by
	 */
	public void modifyStats(int day)
	{
		healAmount = (int) ((healAmount * (day+3))/10);
		currentHealth = (int) ((currentHealth * (day+3))/10);
		maxHealth = (int) ((maxHealth * (day+3))/10);
		damage = (int) ((damage * (day+3))/10);
	}
	
	/**
	 * returns the description of the monster
	 */
	public String toString()
	{
		return getDescription();
	}

	/**
	 * creates description using the stats and adjectives to describe the stats
	 * @return the full string description
	 */
	private String createDescription()
	{
		String priceFlag = getName() + " is ";
		if (getPrice() < 35)
		{
			priceFlag = "a cheap";
		}
		else if (getPrice() < 42)
		{
			priceFlag = "a standard priced";
		}
		else
		{
			priceFlag = "an expensive";
		}
		
		String damageFlag = "";
		
		if (damage < 30)
		{
			damageFlag = "weak";
		}
		else if (damage < 40)
		{
			damageFlag = "";
		}
		else 
		{
			damageFlag = "hard-hitting";
		}
		
		String healthFlag = "";
		
		if (maxHealth < 95)
		{
			healthFlag = "light";
		}
		else if (maxHealth < 105)
		{
			healthFlag = "healthy";
		}
		else 
		{
			healthFlag = "bulky";
		}
		
		if (damageFlag == "")
		{
			return priceFlag + " " + healthFlag + " " + getName();
		}
		return priceFlag + " " + damageFlag + " " + healthFlag + " " + getName();
		
	}
	
	/**
	 * Gets the monsters details
	 * @return the string of the details
	 */
	public String getDetails()
	{
		String output = "";
		output += "Name: " + getName() + "\n";
		output += "Current Health: " + getCurrentHealth() + "\n";
		output += "Max Health: " + getHealth() + "\n";
		output += "Attack: " + getDamage();
		return output;
		
	}
	
	public String getBattleDetails()
	{
		String output = "<html>";
		output += getName() + "<br />";
		output += "Damage: " + getDamage() + "<br />";
		output += "Current Health: " + getCurrentHealth() + "<html>";
		return output;
	}
	
	public String getDetailsShopSellbackHTML()
	{
		String output = "<html>" + getName() + "<br />";
		output += "Damage: " + getDamage() + "<br />";
		output += "Max Health: " + getHealth() + "<br />";
		output += "Selling Price: " + getSellback() + "<html>";
		return output;
	}
	/**
	 * Uses an item on the monster
	 * @param change the amount to change it
	 * @param var the stat to change
	 */
	public void useItem(int change, String var)
	{
		if (var == "Current Health")
		{
			currentHealth += change;
		}
		else if (var == "Heal Amount")
		{
			healAmount += change;
		}
		else if (var == "Max Health")
		{
			maxHealth += change;
		}
		else if (var == "Damage")
		{
			damage += change;
		}
	}

	/**
	 * Level up the monster
	 * Increase its stats by 1.3x
	 */
	public void levelUp() {
		
		currentHealth = (int) (currentHealth * 1.3);
		healAmount = (int) (healAmount * 1.3);
		maxHealth = (int) (maxHealth * 1.3);
		damage = (int) (damage * 1.3);
	}

	@Override
	public String getDetailsSellbackHTML() {
		String output = "<html>" + getName() + "<br />";
		output += "Damage: " + getDamage() + "<br />";
		output += "Max Health: " + getHealth() + "<br />";
		output += "Selling Price: " + getSellback() + "<html>";
		return output;
	}

	@Override
	public String getDetailsPriceHTML() {
		String output = "<html>" + getName() + "<br />";
		output += "Damage: " + getDamage() + "<br />";
		output += "Max Health: " + getHealth() + "<br />";
		output += "Price: " + getPrice() + "<html>";
		return output;
	}
}
