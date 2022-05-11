package com.seng.monster;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
* Tests Battle class
*
* @author  Cameron Wu
* @version 1.0
*/
class BattleTest {

	Player p;
	OpposingPlayer enemy;
	Battle b;
	@BeforeEach
	void setUp() throws Exception {
		p = new Player(0, 10);
		p.addMonsterToList(new Monster(100, 50, 10));
		p.addMonsterToList(new Monster(100, 50, 10));
		enemy = new OpposingPlayer(1);
		enemy.setMonsters(new ArrayList<Monster>());
		enemy.addMonsterToList(new Monster(100, 50, 10));
		enemy.addMonsterToList(new Monster(100, 50, 10));
		b = new Battle(p, enemy);
		
	}

	@Test
	void testNextTurn() {
		b.nextTurn(p, enemy);
		assertEquals(50, p.getMonsters().get(0).getCurrentHealth());
		assertEquals(50, enemy.getMonsters().get(0).getCurrentHealth());
		b.nextTurn(p, enemy);
		assertEquals(50, p.getMonsters().get(0).getCurrentHealth());
		assertEquals(0, enemy.getMonsters().get(0).getCurrentHealth());
		b.nextTurn(p, enemy);
		assertEquals(0, p.getMonsters().get(0).getCurrentHealth());
		assertEquals(50, enemy.getMonsters().get(1).getCurrentHealth());
		b.nextTurn(p, enemy);
		assertEquals(100, p.getMonsters().get(1).getCurrentHealth());
		assertEquals(0, enemy.getMonsters().get(1).getCurrentHealth());
	}


}
