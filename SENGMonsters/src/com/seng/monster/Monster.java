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
	public Monster(int day) {
		super();
		Random rand = new Random(); 
		setPrice(rand.nextInt(21) + 30);
		setSellback((int)getPrice()/2);
		createStats();
		modifyStats(day);
		setName(namePool[rand.nextInt(10)]);
		setDescription(createDescription());

	}
	
	/**
	 * Constructor
	 * Allows user to input stats for testing
	 */
	public Monster(int maxH, int damage, int healA)
	{
		super();
		Random rand = new Random(); 
		setPrice(rand.nextInt(21) + 30);
		setSellback((int)getPrice()/2);
		maxHealth = maxH;
		this.damage = damage;
		healAmount = healA;
		currentHealth = maxH;
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
	 * Gets the heal amount of the monster
	 * @return the heal amount
	 */
	public int getHealAmount()
	{
		return healAmount;
	}

	/**
	 * Heals the monster overnight by their heal amount, not exceeding their max health
	 */
	public void heal()
	{
		if ((currentHealth + healAmount) > maxHealth)
		{
			currentHealth = maxHealth;
		}
		else
		{
			currentHealth += healAmount;
		}
	}
	/**
	 * Applies an attack of size damage to the monster
	 * @param damage the amount of the damage
	 * @return whether or not the monster has fainted
	 */
	public Boolean takeAttack(int damage)
	{
		currentHealth -= damage;
		if (currentHealth <= 0)
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
	public String getDetails(boolean html)
	{
		String sep = "\n";
		String start = "";
		if (html)
		{
			start = "<html>";
			sep = "<br />";
		}
		String output = start;
		output += "Name: " + getName() + sep;
		output += "Current Health: " + getCurrentHealth() + sep;
		output += "Max Health: " + getHealth() + sep;
		output += "Attack: " + getDamage() + sep;
		return output;
		
	}
	
	/**
	 * Gets the monsters details for battle (no max health)
	 * @return the string of the details
	 */
	public String getBattleDetails()
	{
		String output = "<html>";
		output += "Name: " + getName() + "<br />";
		output += "Current Health: " + getCurrentHealth() + "<br />";
		output += "Attack: " + getDamage() + "<br />";
		return output;
	}

	/**
	 * Gets the monsters details for selling page of shop
	 * @param if its running through gui and needs html
	 * @return the string of the details with sellback price
	 */
	public String getDetailsSellback(boolean html)
	{
		String sep = "\n";
		String start = "";
		if (html)
		{
			start = "<html>";
			sep = "<br />";
		}
		String output = start + getName() + sep;
		output += "Damage: " + getDamage() + sep;
		output += "Max Health: " + getHealth() + sep;
		output += "Selling Price: " + getSellback() + sep;
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
			if (currentHealth + change > maxHealth)
			{
				currentHealth = maxHealth;
			}
			else
			{
				currentHealth += change;
			}
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
		
		currentHealth = (int) (currentHealth * 1.2);
		healAmount = (int) (healAmount * 1.2);
		maxHealth = (int) (maxHealth * 1.2);
		damage = (int) (damage * 1.2);
	}

	/**
	 * Gets the monsters details for buying page of shop
	 * @param if its running through gui and needs html
	 * @return the string of the details with purchase price
	 */
	public String getDetailsPrice(boolean html) {
		String sep = "\n";
		String start = "";
		if (html)
		{
			start = "<html>";
			sep = "<br />";
		}
		String output = start + getName() + sep;
		output += "Damage: " + getDamage() + sep;
		output += "Max Health: " + getHealth() + sep;
		output += "Price: " + getPrice() + sep;
		return output;
	}
	
	/**
	 * Returns the given monster attribute
	 * @param which stat to return
	 * @return the integer of the attribute
	 */
	public int getStat(String actionStat) {
		if (actionStat.equals("Damage"))
		{
			return getDamage();
		}
		if (actionStat.equals("Max Health"))
		{
			return getHealth();
		}
		if (actionStat.equals("Current Health"))
		{
			return getCurrentHealth();
		}
		if (actionStat.equals("Heal Amount"))
		{
			return healAmount;
		}
		return 0;
	}
}
