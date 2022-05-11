package com.seng.monster;
import java.util.ArrayList;

/**
* BasePlayer which lets Player and OpposingPlayer share
* multiple functions to increase modularity
*
* @author  Cameron Wu
* @version 1.0
*/
public class BasePlayer {

	/**
	 * Name of player
	 */
	private String name;
	/**
	 * List of players's monsters
	 */
	private ArrayList<Monster> monsters = new ArrayList<Monster>();;
	
	/**
	 * Constructor
	 * Sets name as default
	 */
	public BasePlayer() {
		name = "";
	}
	
	/**
	 * Gets user's name
	 * @return name of user
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets user's monsters
	 * @return monsters of user
	 */
	public ArrayList<Monster> getMonsters() {
		return monsters;
	}
	
	/**
	 * Sets the list of user's monsters
	 * @param new_monsters the new monsters to change to
	 */
	public void setMonsters(ArrayList<Monster> new_monsters)
	{
		monsters = new_monsters;
	}
	
	/**
	 * Check if monster is in user's monster list
	 * @param m the monster to check for
	 * @return boolean if the monster is in the list
	 */
	public boolean containsMonster(Monster m)
	{
		return monsters.contains(m);
	}
	
	/**
	 * Removes monster from user's list
	 * @param m the monster to be removed
	 */
	public void removeMonsterFromList(Monster m)
	{
		monsters.remove(m);
	}
	
	/**
	 * Adds monster to user's list
	 * @param m the new monster
	 */
	public void addMonsterToList(Monster m)
	{
		monsters.add(m);
	}
	
	/**
	 * Sets the name of the player
	 * @param name_value the new name
	 */
	public void setName(String name_value) {
		name = name_value;
	}
	
}
