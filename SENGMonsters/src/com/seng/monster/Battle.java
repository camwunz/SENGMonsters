package com.seng.monster;

public class Battle {

	Player user;
	OpposingPlayer enemy;
	
	public Battle(Player p, OpposingPlayer q)
	{
		user = p;
		enemy = q;
		startBattle(p,q);
	}
	
	private void startBattle(Player p, OpposingPlayer q)
	{
		System.out.println("Starting Battle " + p.getName() + " vs " + q.getName());
	}
}
