package com.seng.monster;

import java.util.Random;

public class OpposingPlayer extends BasePlayer{
	
	private int reward;
	String[] namePool = {"Finn", "Miranda", "Cameron", "Sharon", "Nadeen", "Murphy", "Jemima", "Carlen", "Glenn", "Annabel", "Lynn", "Warren", "Natalie", "Raven", "Karilyn", "Lucinda", "Jolee", "Rayleen", "Tobias"};
	public OpposingPlayer()
	{
		super();
		Random rand = new Random(); 
		int amountMonsters = rand.nextInt(3)+2;
		for (int i = 0; i < amountMonsters; i++)
		{
			Monster tempMon = new Monster();
			reward += tempMon.getHealth()/2;
			addMonsterToList(tempMon);
		}
		setName(namePool[rand.nextInt(20)]);
		
	}
	
	public int getReward()
	{
		return reward;
	}
}
