package com.seng.monster;

public class BaseItem {
	private int price = 0;
	private int sellbackPrice = 0;
	private String description = "";
	private String name = "";
	
	public BaseItem(String newDescription, String newName)
	{
		description = newDescription;
		name = newName;
	}
	
	public int getPrice() 
	{
		return price;
	}
	
	public void setPrice(int newPrice) 
	{
		price = newPrice;
	}
	
	public int getSellback() 
	{
		return sellbackPrice;
	}
	
	public void setSellback(int newSellbackPrice) 
	{
		sellbackPrice = newSellbackPrice;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String newDescription)
	{
		description = newDescription;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String newName)
	{
		name = newName;
	}

}
