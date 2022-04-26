package com.seng.monster;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

	Player p;
	@BeforeEach
	void setUp() throws Exception {
		p = new Player(1, 10);
	}


	@Test
	void testRemoveOpponent() {
		OpposingPlayer playerToRemove = p.getOpponents().get(1);
		ArrayList<OpposingPlayer> checkList = new ArrayList<OpposingPlayer>();
		for (OpposingPlayer o : p.getOpponents())
		{
			if (!o.equals(playerToRemove))
			{
				checkList.add(o);
			}
		}
		
		p.removeOpponent(1);
		assertEquals(checkList, p.getOpponents());
	}


	@Test
	void testAddItemItem() {
		ArrayList<Item> checkItems = new ArrayList<Item>();
		Item testItem = new Item();
		p.addItem(testItem);
		checkItems.add(testItem);
		assertEquals(checkItems, p.getItems());
		assertEquals(100-testItem.getPrice(), p.getGold());
	}

	@Test
	void testAddItemMonster() {
		ArrayList<Monster> checkMonsters = new ArrayList<Monster>();
		Monster testMonster = new Monster();
		p.addItem(testMonster);
		checkMonsters.add(testMonster);
		assertEquals(checkMonsters, p.getMonsters());
		assertEquals(100-testMonster.getPrice(), p.getGold());
	}

	@Test
	void testRemoveFromShopItem() {
		ArrayList<Item> testList = new ArrayList<Item>();
		Item removedItem = p.getDailyItem().get(0);
		for (Item i : p.getDailyItem())
		{
			if (!i.equals(removedItem))
			{
				testList.add(i);
			}
		}
		p.removeFromShop(removedItem);
		assertEquals(testList, p.getDailyItem());
		
	}

}
