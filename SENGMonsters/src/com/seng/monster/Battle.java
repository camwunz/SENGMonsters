package com.seng.monster;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Random;

public class Battle {

	Player user;
	OpposingPlayer enemy;
	Random rand = new Random(); 
	
	public Battle(Player p, OpposingPlayer q)
	{
		user = p;
		enemy = q;
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
			boolean fainted = attack(attacking, defending);
			if (!fainted)
			{
				attack(defending, attacking);
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
	
	private boolean attack(BasePlayer attacking, BasePlayer defending) {
		
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
