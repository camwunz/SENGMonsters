package com.seng.monster;


import java.util.Random;


import java.util.ArrayList;

public class Sleep {
	
	static Random rand = new Random();
	/**
	 * Gets outcomes of the night using random seeds
	 * @param the player
	 */
	public static ArrayList<String> getOutcomes(Player p)
	{
		
		ArrayList<String> outcomes = new ArrayList<String>();
		if (p.getMonsters().size() > 1)
		{
			Monster removedMonster = null;
			for (Monster m : p.getMonsters())
			{
				int nextInt = rand.nextInt(100);
				if (m.getCurrentHealth() <= 0 && nextInt <= 10)
				{
					removedMonster = m;
					break;
				}
				else if (nextInt <= 5)
				{
					removedMonster = m;
					break;
				}
				
			}
			
			if (removedMonster != null)
			{
				outcomes.add(removedMonster.getName() + " left your party!");
				p.getMonsters().remove(removedMonster);
			}
		}
		
		for (Monster m: p.getMonsters())
		{
			int nextInt = rand.nextInt(100);
			if (m.getCurrentHealth() <= 0 && nextInt <= 10)
			{
				outcomes.add(m.getName() + " leveled up!");
				m.levelUp();
			}
			else if (nextInt <= 20)
			{
				outcomes.add(m.getName() + " leveled up!");
				m.levelUp();
			}
		}
		
		int freeSlots = 4 - p.getMonsters().size();
		int nextInt = rand.nextInt(100);
		if (nextInt < (freeSlots*8))
		{
			Monster newMonster = new Monster(p.getDays());
			outcomes.add(newMonster.getName() + " joined your party!");
			p.addItem(newMonster);
		}
		
		for (Monster m: p.getMonsters())
		{
			m.heal();
		}
	
		p.addDay();
		return outcomes;
		
	}
}
