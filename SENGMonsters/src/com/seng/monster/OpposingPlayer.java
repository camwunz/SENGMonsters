package com.seng.monster;

import java.util.Random;

public class OpposingPlayer extends BasePlayer{
	
	/**
	 * Reward for defeating player
	 */
	private int reward;
	/**
	 * Names to choose from
	 */
	String[] namePool = {"Finn", "Miranda", "Cameron", "Sharon", "Nadeen", "Murphy", "Jemima", "Carlen", "Glenn", "Annabel", "Lynn", "Warren", "Natalie", "Raven", "Karilyn", "Lucinda", "Jolee", "Rayleen", "Tobias"};
	/**
	 * Constructor
	 * @param day the day to control difficulty
	 */
	public OpposingPlayer(int day)
	{
		super();
		Random rand = new Random(); 
		int amountMonsters = rand.nextInt(3)+2;
		for (int i = 0; i < amountMonsters; i++)
		{
			Monster tempMon = new Monster();
			tempMon.modifyStats(day);
			reward += tempMon.getHealth()/2;
			addMonsterToList(tempMon);
		}
		setName(namePool[rand.nextInt(19)]);
		
		
	}
	
	/**
	 * gets the reward of the opposing player
	 * @return the reward for defeating
	 */
	public int getReward()
	{
		return reward;
	}
	
	/**
	 * gets the details of the opposing player
	 * @return the details 
	 */
	public String getDetails()
	{
		return getName() + " Reward: " + reward;
	}
}
