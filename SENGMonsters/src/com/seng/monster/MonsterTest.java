package com.seng.monster;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class MonsterTest {

	Monster tempMonster;
	@BeforeEach
	void setUp() throws Exception {
		tempMonster = new Monster(100, 10, 10); 
	}

	@Test
	void testTakeAttack() {
		int currentHealth = tempMonster.getCurrentHealth();
		tempMonster.takeAttack(10);
		assertEquals(currentHealth-10, tempMonster.getCurrentHealth());
		tempMonster.takeAttack(100000);
		assertEquals(0, tempMonster.getCurrentHealth());
	}


	@Test
	void testUseItem() {
		tempMonster.useItem(10, "Heal Amount");
		assertEquals(20, tempMonster.healAmount);
		tempMonster.useItem(10, "Current Health");
		assertEquals(110, tempMonster.currentHealth);
		tempMonster.useItem(10, "Max Health");
		assertEquals(110, tempMonster.maxHealth);
		tempMonster.useItem(10, "Damage");
		assertEquals(20, tempMonster.damage);
	}

	@Test
	void testLevelUp() {
		int currentH = tempMonster.currentHealth;
		int maxH = tempMonster.maxHealth;
		int damage = tempMonster.damage;
		int healA = tempMonster.healAmount;
		tempMonster.levelUp();
		assertEquals(currentH*1.2, tempMonster.currentHealth);
		assertEquals(maxH*1.2, tempMonster.maxHealth);
		assertEquals(damage*1.2, tempMonster.damage);
		assertEquals(healA*1.2, tempMonster.healAmount);
		
	}

}
