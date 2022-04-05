package com.seng.monster;
import java.util.Random;

public class Item extends BaseItem{
	String actionStat = "";
	int actionImprovement = 0;
	
	public Item(String newDescription, String newName, String newActionStat, int newActionImprovement) {
		super(newDescription, newName);
		Random rand = new Random(); 
		setPrice(rand.nextInt(11) + 5);
		setSellback((int)getPrice()/2);
		actionStat = newActionStat;
		actionImprovement = newActionImprovement;
	}
	
	
}
