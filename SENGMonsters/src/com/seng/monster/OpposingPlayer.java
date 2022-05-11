package com.seng.monster;

import java.util.Random;

/**
* OpposingPlayer which the Player will battle in the game
* extends parent BasePlayer for modularity
*
* @author  Cameron Wu
* @version 1.0
*/
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
			Monster tempMon = new Monster(day+1);
			tempMon.modifyStats(day);
			reward += tempMon.getHealth()/3.5;
			addMonsterToList(tempMon);
		}
		setName(namePool[rand.nextInt(19)]);
		
		
	}
	
	/**
	 * gets the total health of monsters for difficulty checking
	 * @return sum of monster health
	 */
	private int getTotalHealth()
	{
		int totalHealth = 0;
		for (Monster m: getMonsters())
		{
			totalHealth += m.getHealth();
		}
		
		return totalHealth;
	}
	
	/**
	 * gets the total attacking damage of monsters for difficulty checking
	 * @return sum of monster attacking damage
	 */
	private int getTotalDamage()
	{
		int totalDamage = 0;
		for (Monster m: getMonsters())
		{
			totalDamage += m.getDamage();
		}
		
		return totalDamage;
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
	 * gets the opponent details for choosing
	 * @return string of opponent details
	 */
	public String getPromptHTML()
	{
		String output = "<html>" + getName();
		output += "<br />Monsters: " + getMonsters().size();
		output += "<br />Total Health: " + getTotalHealth();
		output += "<br />Total Attack: " + getTotalDamage();
		output += "<br />Reward: " + getReward() + "<html>";
		return output;
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
