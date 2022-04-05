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
	
	private void createStats()
	{
		Random rand = new Random(); 
		maxHealth = rand.nextInt(41) + 80;
		currentHealth = maxHealth;
		healAmount = rand.nextInt((int)maxHealth/3);
		damage = rand.nextInt(31) + 20;
		
		
	}

	private String createDescription()
	{
		String priceFlag = "";
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
		
		return priceFlag + " " + damageFlag + " " + healthFlag + " " + getName();
		
	}
	
}
