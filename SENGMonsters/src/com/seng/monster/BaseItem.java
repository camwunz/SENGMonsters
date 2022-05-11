package com.seng.monster;

/**
* abstract BaseItem which implements the BaseItemInterface to
* allow the Monster and Item classes to have different implementations
* of the getDetails() functions for the shop. Overall more modularity
* is achieved by having this parent class
*
* @author  Cameron Wu
* @version 1.0
*/
public abstract class BaseItem implements BaseItemInterface{
	/**
	 * Price of item
	 */
	private int price;
	/**
	 * Sellback price of item
	 */
	private int sellbackPrice;
	/**
	 * Description of item
	 */
	private String description;
	/**
	 * Name of item
	 */
	private String name;
	/**
	 * Constructor
	 */
	public BaseItem()
	{
		price = 0;
		sellbackPrice = 0;
		description = "";
		name = "";
	}

	/**
	 * Gets item's price
	 * @return price of item
	 */
	public int getPrice() 
	{
		return price;
	}

	/**
	 * Sets the item's price
	 * @param newPrice new price
	 */
	public void setPrice(int newPrice) 
	{
		price = newPrice;
	}

	/**
	 * Gets the item's sellback price
	 * @return the sellback price of the item
	 */
	public int getSellback() 
	{
		return sellbackPrice;
	}
	

	/**
	 * Sets the new sellback price
	 * @param newSellbackPrice the new sellback price
	 */
	public void setSellback(int newSellbackPrice) 
	{
		sellbackPrice = newSellbackPrice;
	}
	

	/**
	 * Gets the item's description
	 * @return description of item
	 */
	public String getDescription()
	{
		return description;
	}
	

	/**
	 * Sets the item's description
	 * @param newDescription the new description
	 */
	public void setDescription(String newDescription)
	{
		description = newDescription;
	}
	

	/**
	 * Gets the item's name
	 * @return the name of item
	 */
	public String getName()
	{
		return name;
	}
	

	/**
	 * Sets the item's name
	 * @param newName new name of item
	 */
	public void setName(String newName)
	{
		name = newName;
	}

}
