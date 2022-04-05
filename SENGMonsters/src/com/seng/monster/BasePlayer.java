package com.seng.monster;
import java.util.ArrayList;


public class BasePlayer {

	private String name;
	private ArrayList<Monster> monsters;
	
	public BasePlayer() {
		name = "";
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Monster> getMonsters() {
		return monsters;
	}
	
	public boolean containsMonster(Monster m)
	{
		return monsters.contains(m);
	}
	
	public void removeMonsterFromList(Monster m)
	{
		monsters.remove(m);
	}
	
	public void addMonsterToList(Monster m)
	{
		monsters.add(m);
	}
	
	public void setName(String name_value) {
		name = name_value;
	}
	
}
