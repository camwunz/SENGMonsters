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
	 * The items in the monster shop for each day
	 */
	private ArrayList<ArrayList<Monster>> shopMonsters = new ArrayList<ArrayList<Monster>>();
	/**
	 * The items in the item shop for each day
	 */
	private ArrayList<ArrayList<Item>> shopItems = new ArrayList<ArrayList<Item>>();
	/**
	 * The opponents for each day
	 */
	private ArrayList<ArrayList<OpposingPlayer>> dailyOpponents = new ArrayList<ArrayList<OpposingPlayer>>();
	
	

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
		day_count = 1;
		for (int i = 0; i < total_days; i++)
		{
			ArrayList<OpposingPlayer> newOpponents = new ArrayList<OpposingPlayer>();
			ArrayList<Monster> dailyMonsters = new ArrayList<Monster>();
			ArrayList<Item> dailyItems = new ArrayList<Item>();
			for (int j = 0; j < 4; j++)
			{
				newOpponents.add(new OpposingPlayer(i+1));
				dailyMonsters.add(new Monster());
				dailyItems.add(new Item());
			}
			dailyOpponents.add(newOpponents);
			shopMonsters.add(dailyMonsters);
			shopItems.add(dailyItems);
		}
		
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
	 * Gets the monster shop's items
	 * @return today's monsters in the shop
	 */
	public ArrayList<Monster> getDailyMonsters()
	{
		return shopMonsters.get(getDays()-1);
	}
	/**
	 * Gets the item shop's items
	 * @return today's item in the shop
	 */
	public ArrayList<Item> getDailyItem()
	{
		return shopItems.get(getDays()-1);
	}
	/**
	 * Gets the daily opponents
	 * @return today's 4 opponents
	 */
	public ArrayList<OpposingPlayer> getOpponents()
	{
		return dailyOpponents.get(getDays()-1);
	}
	/**
	 * Removes an opponent from today's opponents once they have battled them
	 * @param index of the opponent
	 */
	public void removeOpponent(int index)
	{
		dailyOpponents.get(getDays()-1).remove(index);
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
	public void addGold(Integer amount) {
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
	public void addDay() {
		day_count += 1;
	}
	/**
	 * Gets current day
	 * @return the current day of the game
	 */
	public int getDays()
	{
		return day_count;
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
	public void addItem(Item item) 
	{
		gold -= item.getPrice();
		getItems().add(item);
	}
	
	/**
	 * Add monster into user's party
	 * @param monster the new monster
	 * @return if the monster could be adding depending on the price of the monster
	 */
	public void addItem(Monster monster) 
	{
		gold -= monster.getPrice();
		addMonsterToList(monster);
	}
	/**
	 * Removes an monster from today's shop
	 * Note the overloading to make it work with both BaseItem types (Item/Monster)
	 * @param monster to remove
	 */
	public void removeFromShop(Monster m)
	{
		getDailyMonsters().remove(m);
	}
	/**
	 * Removes an item from today's shop
	 * @param item to remove
	 */
	public void removeFromShop(Item i)
	{
		getDailyItem().remove(i);
	}
	
	
	/**
	 * Remove a monster from the users party
	 * @param monster the monster to be removed
	 * @return if the monster got removed
	 */
	public void removeMonster(Monster monster) 
	{
		gold -= monster.getSellback();	
	}
	
	/**
	 * Remove an item from the user's inventory
	 * @param item the item to be removed
	 */
	public void removeItem(BaseItem item) {
		if (item instanceof Monster)
		{
			getMonsters().remove(item);
		}
		else 
		{
			items.remove(item);
		}
		gold += item.getSellback();
	}
	


}
