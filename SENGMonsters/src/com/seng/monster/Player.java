package com.seng.monster;
import java.util.ArrayList;

public class Player extends BasePlayer{
	
	/**
	 * The amount of gold the player has
	 */
	private Integer gold;
	/**
	 * The list of user's items
	 */
	private ArrayList<Item> items = new ArrayList<Item>();
	/**
	 * The difficulty of the game
	 */
	private Integer difficulty;
	/**
	 * Count of the days
	 */
	private Integer day_count = 0;
	/**
	 * Total length of the game
	 */
	private Integer total_days;
	/**
	 * Running total of user's score
	 */
	private Integer score;

	
	

	/**
	 * Constructor 
	 * @param difficulty_amount the difficulty of player
	 * @param days_amount the days of the game
	 */
	public Player(Integer difficulty_amount, Integer days_amount){
		super();
		score = 0;
		gold  = 100;
		difficulty = difficulty_amount;
		total_days = days_amount;
	}

	/**
	 * Gets the user's score
	 * @return score of user
	 */
	public Integer getScore()
	{
		return score;
	}
	

	/**
	 * Add to the user's score
	 * @param i the amount to add
	 */
	public void addToScore(int i)
	{
		score += i;
	}

	/**
	 * Gets the user's gold
	 * @return the gold of user
	 */
	public Integer getGold() {
		return gold;
	}
	
	/**
	 * Gets the user's items
	 * @return the items of the user
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
	
	/**
	 * Gets the difficulty
	 * @return the difficulty of the game
	 */
	public Integer getDifficulty() {
		return difficulty;
	}
	
	/**
	 * Gets the days
	 * @return the total days of the game
	 */
	public Integer getTotalDays() {
		return total_days;
	}
	
	
	/**
	 * Increase the users gold
	 * @param amount amount to add to the player's balance
	 */
	public void setGold(Integer amount) {
		gold += amount;
	}
	
	/**
	 * Sets the difficulty of the game
	 * @param number the new difficulty
	 */
	public void setDifficulty(Integer number) {
		difficulty = number;
	}
	
	/**
	 * Increases day count by one
	 */
	public void setDaysLeft() {
		day_count += 1;
	}
	
	/**
	 * Sets the total days
	 * @param amount the new amount of total days
	 */
	public void setTotalDays(Integer amount) {
		total_days = amount;
	}
	
	
	/**
	 * Adds item to users inventory
	 * @param item the new item
	 * @return if the item could be adding depending on the price of the item
	 */
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
	
	/**
	 * Add monster into user's party
	 * @param monster the new monster
	 * @return if the monster could be adding depending on the price of the monster
	 */
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
	
	
	/**
	 * Remove a monster from the users party
	 * @param monster the monster to be removed
	 * @return if the monster got removed
	 */
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
	
	/**
	 * Remove an item from the user's inventory
	 * @param item the item to be removed
	 */
	public void removeItem(Item item) {
		items.remove(item);
		gold -= item.getSellback();
	}
	
	// TODO store all of the shop details and opponent details 

}
