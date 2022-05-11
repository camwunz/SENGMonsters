package com.seng.monster;

/**
* Interface which allows Monsters and Items to have their own implementations
*
* @author  Cameron Wu
* @version 1.0
*/
public interface BaseItemInterface {
	
	/**
	 * gets the details for the selling page of shop
	 * @param html, if its for the gui and requires html
	 * @return the item or monster details
	 */
	String getDetailsSellback(boolean html);
	/**
	 * gets the details for the buying page of shop
	 * @param html, if its for the gui and requires html
	 * @return the item or monster details
	 */
	String getDetailsPrice(boolean html);
	/**
	 * gets the current health of the monster or item
	 * @return the item or monster current health
	 */
	int getCurrentHealth();

}
