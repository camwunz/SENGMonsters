package com.seng.monster;
import java.util.ArrayList;

public class Player extends BasePlayer{
	
	private Integer gold;
	private ArrayList<Item> items;
	private Integer difficulty;
	private Integer days_left;
	private Integer total_days;

	
	
	public Player(Integer gold_amount, ArrayList<Item> items_list, Integer difficulty_amount, Integer days_amount){
		gold  = gold_amount;
		items = items_list;
		difficulty = difficulty_amount;
		days_left = days_amount;
	}
	
	
	
	public Integer getGold() {
		return gold;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public Integer getDifficulty() {
		return difficulty;
	}
	
	public Integer getDays() {
		return days_left;
	}
	
	
	public void setGold(Integer amount) {
		gold += amount;
	}
	
	public void setDifficulty(Integer number) {
		difficulty = number;
	}
	
	public void setDaysLeft() {
		days_left -= 1;
	}
	
	public void setTotalDays(Integer amount) {
		total_days = amount;
	}
	
	
	public Boolean addItem(Item item) {
		
		if(items.contains(item)) {
			return false;
		} else {
			
			if(item.getPrice() > gold) {
				return false;
			} else {
				gold -= item.getPrice();
				items.add(item);
				return true;
			}
		}
	}
	
	public Boolean addMonster(Monster monster) {
		
		if(monsters.contains(monster)) {
			return false;
		} else {
			
			if(monster.getPrice() > gold) {
				return false;
			} else {
				gold -= monster.getPrice();
				monsters.add(monster);
				return true;
			}
		}
	}
	
	
	public void removeMonster(Monster monster) {
		monsters.remove(monster);
		gold -= monster.getPrice()/2;
	}
	
	public void removeItem(Monster monster) {
		monsters.remove(monster);
	}

}
