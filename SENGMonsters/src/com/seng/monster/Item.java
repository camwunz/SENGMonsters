package com.seng.monster;
import java.util.Random;

public class Item extends BaseItem{
	String actionStat = "";
	int actionImprovement = 0;
	String[] berries = {"Cheppa", "Lopet", "Wanga", "Mystery", "Aimpo"};
	Random rand = new Random(); 
	
	public Item() {
		super();
		setPrice(rand.nextInt(11) + 5);
		setSellback((int)getPrice()/2);
		createItem();
	}
	
	private void createItem()
	{
		String berryName = berries[rand.nextInt(5)];
		setName(berryName);
		actionImprovement = rand.nextInt(16) + 5;
		switch(berryName)
		{
			case "Cheppa":
				actionStat = "damage";
				setDescription("Increases damage by " + actionImprovement);
				break;
			case "Lopet":
				actionStat = "maxHealth";
				setDescription("Increases max health by " + actionImprovement);
				break;
			case "Wanga":
				actionStat = "currentHealth";
				setDescription("Increases current health by " + actionImprovement);
				break;
			case "Aimpo":
				actionStat = "healAmount";
				setDescription("Increases heal amount by " + actionImprovement);
				break;
			case "Mystery":
				String[] actionList = {"damage", "maxHealth", "currentHealth", "healAmount"};
				actionStat = actionList[rand.nextInt(4)];
				setDescription("Increases a random variable by " + actionImprovement);
				break;
		}
		
	}
	
	public String getDetails()
	{
		return getName() + ": " + getDescription() + ". Price: " + getPrice();
	}
	
	public String getDetailsSellback()
	{
		return getName() + ": " + getDescription() + ". Sellback Price: " + getDetailsSellback();
	}
	
	public String getActionStat()
	{
		return actionStat;
	}
	
	public int getActionImprovement()
	{
		return actionImprovement;
	}
	
}
