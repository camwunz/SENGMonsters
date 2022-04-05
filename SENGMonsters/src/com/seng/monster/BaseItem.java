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
