package com.seng.monster;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class healthBorder {
	/**
	 * Changes the border based on the item's health
	 * @param the label
	 * @param the item to check the health of (items are always positive)
	 */
	public static void changeBorder (JLabel label, BaseItem i)
	{
		Border redBorder = BorderFactory.createLineBorder(Color.RED, 5);
		Border greenBorder = BorderFactory.createLineBorder(Color.GREEN, 5);
		if (i.getCurrentHealth() <= 0)
		{
			label.setBorder(redBorder);
		}
		else {
			label.setBorder(greenBorder);
		}
	}
}
