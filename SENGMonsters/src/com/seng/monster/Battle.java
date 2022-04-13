package com.seng.monster;
import java.util.ArrayList;
import java.util.Random;


public class Battle {

	/**
	 * Main player who is fighting the opposing player
	 */
	Player user;
	/**
	 * Opposing player that the user is fighting
	 */
	OpposingPlayer enemy;
	/**
	 * Random seed
	 */
	Random rand = new Random(); 
	BasePlayer attacking = null;
	BasePlayer defending = null;
	
	/**
	 * Constructor
	 * @param p player
	 * @param q opposing player
	 */
	public Battle(Player p, OpposingPlayer q)
	{
		user = p;
		enemy = q;
		
	}
	
	/**
	 * Runs through the battle turn by turn seeing who wins
	 * @return whether the player won the battle
	 */
	
	public ArrayList<String> nextTurn(Player user, OpposingPlayer enemy)
	{
		if (user.getDifficulty() == 0)
		{
			attacking = user;
			defending = enemy;
		}
		else if (user.getDifficulty() == 1)
		{
			int player1 = rand.nextInt(2);
			if (player1 == 0)
			{
				attacking = user;
				defending = enemy;
			}
			else 
			{
				attacking = enemy;
				defending = user;
			}
		}
		else
		{
			attacking = enemy;
			defending = user;
		}
		ArrayList<String> damagePrompts = new ArrayList<String>();
		ArrayList<String> output = attack(attacking, defending);
		String strOutput = output.get(0);
		boolean fainted = output.get(1) == "true";
		damagePrompts.add(strOutput);
		if (!fainted)
		{
			output = attack(defending, attacking);
			damagePrompts.add(output.get(0));
		}
		else {
			damagePrompts.add("");
		}
		
		damagePrompts.add(Integer.toString(battleDone()));
		return damagePrompts;
	}
		
	
	public boolean startBattle()
	{
		System.out.println("\nStarting Battle " + user.getName() + " vs " + enemy.getName());
		
		int i = 1;
		while (battleDone() == 0)
		{
			BasePlayer attacking = null;
			BasePlayer defending = null;
			if (user.getDifficulty() == 0)
			{
				attacking = user;
				defending = enemy;
			}
			else if (user.getDifficulty() == 1)
			{
				int player1 = rand.nextInt(2);
				if (player1 == 0)
				{
					attacking = user;
					defending = enemy;
				}
				else 
				{
					attacking = enemy;
					defending = user;
				}
			}
			else
			{
				attacking = enemy;
				defending = user;
			}
			System.out.println("Turn " + i);
			boolean fainted = attackCLI(attacking, defending);
			if (!fainted)
			{
				attackCLI(defending, attacking);
			}
			
			i++;
			System.out.println("\n");
		}
		
		int loser = battleDone();
		if (loser == 0)
		{
			System.out.println("You lost the battle!");
			System.out.println("Buy some more monsters or items to keep battling!\n");
			return false;
		}
		else 
		{
			System.out.println("You won the battle!");
			System.out.println("Use the " + enemy.getReward() + " gold to buy more monsters or items!\n");
			user.addToScore((int)(enemy.getReward()/2));
			user.setGold(enemy.getReward());
			return true;
		}
		
		
	}
	
	/**
	 * Executes a single attack
	 * @param attacking the attacking player
	 * @param defending the reciving player
	 * @return boolean whether the reciving player's monster has fainted
	 */
	private boolean attackCLI(BasePlayer attacking, BasePlayer defending) {
		
		Monster firstMonster = null;
		for (Monster m : attacking.getMonsters())
		{
			if (m.getCurrentHealth() > 0)
			{
				firstMonster = m;
				break;
			}
		}
		
		Monster firstEnemy = null;
		for (Monster m : defending.getMonsters())
		{
			if (m.getCurrentHealth() > 0)
			{
				firstEnemy = m;
				break;
			}
		}
		
		if (firstEnemy.takeAttack(firstMonster.getDamage()))
		{
			System.out.println(defending.getName() + "'s " + firstEnemy.getName() + " fainted after " + firstMonster.getDamage() + " damage from " + attacking.getName() + "'s " + firstMonster.getName());
			return true;
		
		}
		else {
			System.out.println(attacking.getName() + "'s " + firstMonster.getName() + " did " + firstMonster.getDamage() + " damage to " + defending.getName() + "'s " + firstEnemy.getName() + "!");
			return false;
		}
		
	}
	
	private ArrayList<String> attack(BasePlayer attacking, BasePlayer defending) {
		
		Monster firstMonster = null;
		for (Monster m : attacking.getMonsters())
		{
			if (m.getCurrentHealth() > 0)
			{
				firstMonster = m;
				break;
			}
		}
		
		Monster firstEnemy = null;
		for (Monster m : defending.getMonsters())
		{
			if (m.getCurrentHealth() > 0)
			{
				firstEnemy = m;
				break;
			}
		}
		
		if (firstEnemy.takeAttack(firstMonster.getDamage()))
		{
			ArrayList<String> output = new ArrayList<String>();
			output.add(defending.getName() + "'s " + firstEnemy.getName() + " fainted after " + firstMonster.getDamage() + " damage from " + attacking.getName() + "'s " + firstMonster.getName());
			output.add("true");
			return output;
		
		}
		else {
			ArrayList<String> output = new ArrayList<String>();;
			output.add(attacking.getName() + "'s " + firstMonster.getName() + " did " + firstMonster.getDamage() + " damage to " + defending.getName() + "'s " + firstEnemy.getName() + "!");
			output.add("false");
			return output;
		}
		
	}

	/**
	 * Check if the battle is done and who the winner is 
	 * @return int depending on the result 0 = match still going 1 = player won 2 = opposing player won
	 */
	private int battleDone()
	{
		int total = 0;
		for (Monster m : user.getMonsters())
		{
			total += m.getCurrentHealth();
		}
		
		if (total <= 0)
		{
			return 1;
		}
		
		total = 0;
		
		for (Monster m : enemy.getMonsters())
		{
			total += m.getCurrentHealth();
		}
		
		if (total <= 0)
		{
			return 2;
		}
		
		return 0;
	}
	
}
