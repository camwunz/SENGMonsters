package com.seng.monster;
import java.util.Random;

import org.ietf.jgss.Oid;

public class Monster extends BaseItem{
	
	int maxHealth = 0;
	int damage = 0;
	int healAmount = 0;
	int currentHealth = maxHealth;
	String[] namePool = {"Salamaslash","Hyetar","Parrow","Dolphair","Chillboon","Starraffe","Dewossum","Fieritar","Walruse","Brawnkey"};
	

	public Monster(String newDescription, String newName) {
		super(newDescription, newName);
		Random rand = new Random(); 
		setPrice(rand.nextInt(21) + 30);
		setSellback((int)getPrice()/2);
		createStats();
		setName(namePool[rand.nextInt(10)]);
		setDescription(createDescription())

	}
	
	private void createStats()
	{
		Random rand = new Random(); 
		maxHealth = rand.nextInt(41) + 80;
		currentHealth = maxHealth;
		damage = rand.nextInt(31) + 20;
		
		
	}

	private String createDescription()
	{
		String priceFlag = "";
		if (getPrice() < 35)
		{
			priceFlag = "cheap";
		}
		else if (getPrice() < 42)
		{
			priceFlag = "standard priced";
		}
		else
		{
			priceFlag = "expensive";
		}
		return null;
		
	}
	
}
