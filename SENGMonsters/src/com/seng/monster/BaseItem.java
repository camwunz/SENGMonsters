package com.seng.monster;

public class BaseItem {
	private int price;
	private int sellbackPrice;
	private String description;
	private String name;
	
	public BaseItem()
	{
		price = 0;
		sellbackPrice = 0;
		description = "";
		name = "";
	}
	
	/**
	 * @return
	 */
	public int getPrice() 
	{
		return price;
	}
	
	/**
	 * @param newPrice
	 */
	public void setPrice(int newPrice) 
	{
		price = newPrice;
	}
	
	/**
	 * @return
	 */
	public int getSellback() 
	{
		return sellbackPrice;
	}
	
	/**
	 * @param newSellbackPrice
	 */
	public void setSellback(int newSellbackPrice) 
	{
		sellbackPrice = newSellbackPrice;
	}
	
	/**
	 * @return
	 */
	public String getDescription()
	{
		return description;
	}
	
	/**
	 * @param newDescription
	 */
	public void setDescription(String newDescription)
	{
		description = newDescription;
	}
	
	/**
	 * @return
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * @param newName
	 */
	public void setName(String newName)
	{
		name = newName;
	}

}
