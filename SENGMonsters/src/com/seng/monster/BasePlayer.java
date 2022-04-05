package com.seng.monster;
import java.util.ArrayList;


public class BasePlayer {

	private String name;
	protected ArrayList<Monster> monsters;
	
	public BasePlayer() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Monster> getMonsters() {
		return monsters;
	}
	
	public void setName(String name_value) {
		name = name_value;
	}
	
}
