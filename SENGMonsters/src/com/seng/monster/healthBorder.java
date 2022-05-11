package com.seng.monster;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
* Class to set the border of labels if the health of a monster is 0
* Items are default green
*
* @author  Cameron Wu
* @version 1.0
*/
public class healthBorder {
	/**
	 * Changes the border based on the item's health
	 * @param label, the label
	 * @param i, the item to check the health of (items are always positive)
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
