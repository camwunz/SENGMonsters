package com.seng.monster;
import java.util.ArrayList;

public class Player extends BasePlayer{
	
	private Integer gold;
	private ArrayList<Item> items = new ArrayList<Item>();
	private Integer difficulty;
	private Integer day_count = 0;
	private Integer total_days;
	private Integer score;

	
	
	/**
	 * @param difficulty_amount
	 * @param days_amount
	 */
	public Player(Integer difficulty_amount, Integer days_amount){
		super();
		score = 0;
		gold  = 100;
		difficulty = difficulty_amount;
		total_days = days_amount;
	}
	
	/**
	 * @return
	 */
	public Integer getScore()
	{
		return score;
	}
	
	/**
	 * @param i
	 */
	public void addToScore(int i)
	{
		score += i;
	}
	
	
	/**
	 * @return
	 */
	public Integer getGold() {
		return gold;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public Integer getDifficulty() {
		return difficulty;
	}
	
	public Integer getTotalDays() {
		return total_days;
	}
	
	
	public void setGold(Integer amount) {
		gold += amount;
	}
	
	public void setDifficulty(Integer number) {
		difficulty = number;
	}
	
	public void setDaysLeft() {
		day_count += 1;
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
		
		if(containsMonster(monster)) {
			return false;
		} else {
			
			if(monster.getPrice() > gold) {
				return false;
			} else {
				gold -= monster.getPrice();
				addMonsterToList(monster);
				return true;
			}
		}
	}
	
	
	public boolean removeMonster(Monster monster) {
		if (containsMonster(monster))
		{
			removeMonsterFromList(monster);
			gold -= monster.getSellback();
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void removeItem(Item item) {
		items.remove(item);
		gold -= item.getSellback();
	}

}
