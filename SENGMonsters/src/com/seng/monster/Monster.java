package com.seng.monster;
import java.util.Random;

public class Monster extends BaseItem{
	
	int maxHealth = 0;
	int damage = 0;
	int healAmount = 0;
	int currentHealth = maxHealth;
	String[] namePool = {"Salamaslash","Hyetar","Parrow","Dolphair","Chillboon","Starraffe","Dewossum","Fieritar","Walruse","Brawnkey"};
	

	public Monster() {
		super();
		Random rand = new Random(); 
		setPrice(rand.nextInt(21) + 30);
		setSellback((int)getPrice()/2);
		createStats();
		setName(namePool[rand.nextInt(10)]);
		setDescription(createDescription());

	}
	
	public int getHealth()
	{
		return maxHealth;
	}
	
	public int getCurrentHealth()
	{
		return currentHealth;
	}
	
	public int getDamage()
	{
		return damage;
	}
	
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
	private void createStats()
	{
		Random rand = new Random(); 
		maxHealth = rand.nextInt(41) + 80;
		currentHealth = maxHealth;
		healAmount = rand.nextInt((int)maxHealth/3);
		damage = rand.nextInt(31) + 20;
		
		
	}
	
	public void modifyStats(int day)
	{
		healAmount = (int) ((healAmount * (day+3))/10);
		currentHealth = (int) ((currentHealth * (day+3))/10);
		maxHealth = (int) ((maxHealth * (day+3))/10);
		damage = (int) ((damage * (day+3))/10);
	}
	
	public String toString()
	{
		return getDescription();
	}

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
	
	public String printDetails()
	{
		String output = "";
		output += "Name: " + getName() + "\n";
		output += "Current Health: " + getCurrentHealth() + "\n";
		output += "Attack: " + getDamage() + "\n";
		return output;
		
	}
	
	public String printDetailsPrice()
	{
		String output = "";
		output += "Name: " + getName() + "\n";
		output += "Max Health: " + getCurrentHealth() + "\n";
		output += "Attack: " + getDamage() + "\n";
		output += "Price: " + getPrice() + "\n";
		return output;
		
	}
	
	public String printDetailsSellback()
	{
		String output = "";
		output += "Name: " + getName() + "\n";
		output += "Max Health: " + getCurrentHealth() + "\n";
		output += "Attack: " + getDamage() + "\n";
		output += "Sellback price: " + getSellback() + "\n";
		return output;
		
	}
	
	public void useItem(int change, String var)
	{
		if (var == "currentHealth")
		{
			currentHealth += change;
		}
		else if (var == "healAmount")
		{
			healAmount += change;
		}
		else if (var == "maxHealth")
		{
			maxHealth += change;
		}
		else if (var == "damage")
		{
			damage += change;
		}
	}

	public void levelUp() {
		
		currentHealth = (int) (currentHealth * 1.3);
		healAmount = (int) (healAmount * 1.3);
		maxHealth = (int) (maxHealth * 1.3);
		damage = (int) (damage * 1.3);
	}
}
