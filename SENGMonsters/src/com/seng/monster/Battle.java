package com.seng.monster;

import java.util.spi.LocaleServiceProvider;

public class Battle {

	Player user;
	OpposingPlayer enemy;
	
	public Battle(Player p, OpposingPlayer q)
	{
		user = p;
		enemy = q;
		startBattle();
	}
	
	private void startBattle()
	{
		System.out.println("\nStarting Battle " + user.getName() + " vs " + enemy.getName());
		
		int i = 1;
		while (battleDone() == 0)
		{
			System.out.println("Turn " + i);
			boolean fainted = attack(user, enemy);
			if (!fainted)
			{
				attack(enemy, user);
			}
			i++;
			System.out.println("\n");
		}
		
		int loser = battleDone();
		
		
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
