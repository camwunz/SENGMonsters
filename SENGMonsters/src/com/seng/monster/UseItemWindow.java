package com.seng.monster;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.List;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UseItemWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UseItemWindow window = new UseItemWindow(null, null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param the player
	 * @param the item of choice
	 */
	public UseItemWindow(Player p, Item i) {
		initialize(p, i);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param the player
	 * @param the item of choice
	 */
	private void initialize(Player p, Item i) {
		frame = new JFrame();
		frame.setBounds(100, 100, 750,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(63dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(22dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(63dlu;default)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(34dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(34dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel titleLabel = new JLabel("Which Monster?");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.getContentPane().add(titleLabel, "16, 4, 15, 1");
		
		JLabel monsterInfo1 = new JLabel("");
		frame.getContentPane().add(monsterInfo1, "10, 10, 1, 3");
		
		JLabel monsterChange1 = new JLabel("");
		frame.getContentPane().add(monsterChange1, "14, 10");
		
		JLabel monsterInfo2 = new JLabel("");
		frame.getContentPane().add(monsterInfo2, "26, 10, 1, 3");
		
		JLabel monsterChange2 = new JLabel("");
		frame.getContentPane().add(monsterChange2, "30, 10");
		
		JButton useButton1 = new JButton("Use");
		useButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finish(i, p.getMonsters().get(0), p);
			}
		});
		frame.getContentPane().add(useButton1, "14, 12");
		
		JButton useButton2 = new JButton("Use");
		useButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finish(i, p.getMonsters().get(1), p);
			}
		});
		frame.getContentPane().add(useButton2, "30, 12");
		
		JLabel monsterInfo3 = new JLabel("");
		frame.getContentPane().add(monsterInfo3, "10, 18, 1, 3");
		
		JLabel monsterChange3 = new JLabel("");
		frame.getContentPane().add(monsterChange3, "14, 18");
		
		JLabel monsterInfo4 = new JLabel("");
		frame.getContentPane().add(monsterInfo4, "26, 18, 1, 3");
		
		JLabel monsterChange4 = new JLabel("");
		frame.getContentPane().add(monsterChange4, "30, 18");
		
		JButton useButton3 = new JButton("Use");
		useButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finish(i, p.getMonsters().get(2), p);
			}
		});
		frame.getContentPane().add(useButton3, "14, 20");
		
		JButton useButton4 = new JButton("Use");
		useButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finish(i, p.getMonsters().get(3), p);
			}
		});
		frame.getContentPane().add(useButton4, "30, 20");
		
		List<JLabel> changeLabels = List.of(monsterChange1, monsterChange2, monsterChange3, monsterChange4);
		List<JLabel> infoLabels = List.of(monsterInfo1, monsterInfo2, monsterInfo3, monsterInfo4);
		List<JButton> buttons = List.of(useButton1, useButton2, useButton3, useButton4);
		
		updateItemComponents(p.getMonsters(), infoLabels, changeLabels, buttons, i);
	}
	
	/**
	 * use the item and go back to menu
	 * @param the item of choice
	 * @param the monster that the item is being used on
	 * @param the player 
	 */
	private void finish (Item i, Monster m, Player p)
	{
		m.useItem(i.getActionImprovement(), i.getActionStat());
		p.removeItem(i);
		new MenuWindow(p);
		frame.dispose();
	}

	/**
	 * checks visibility of all the components
	 * @param the list of player monsters
	 * @param the infoLabels
	 * @param the changeLabels
	 * @param the buttons for using the item
	 * @param the used item
	 */
	private void updateItemComponents(ArrayList<Monster> monsters, List<JLabel> infoLabels, List<JLabel> changeLabels, List<JButton> buttons, Item usedItem)
	{
		int listSize = monsters.size();
		for (int i = 0; i < 4; i++)
		{
			
			if (i >= listSize)
			{
				
				infoLabels.get(i).setVisible(false);
				changeLabels.get(i).setVisible(false);
				buttons.get(i).setVisible(false);
			}
			else 
			{
				healthBorder.changeBorder(infoLabels.get(i), monsters.get(i));
				infoLabels.get(i).setText(monsters.get(i).getDetails(true));
				if (usedItem.getName().equals("Mystery Berry"))
				{
					changeLabels.get(i).setText("? +" + usedItem.getActionImprovement());
				}
				else
				{
					String changeText = usedItem.getActionStat();
					int currentStat = monsters.get(i).getStat(usedItem.getActionStat());
					int newStat = currentStat + usedItem.getActionImprovement();
					if (changeText.equals("Current Health") && newStat > monsters.get(i).getHealth())
					{
						newStat = monsters.get(i).getHealth();
					}
					changeText += " " + Integer.toString(currentStat);
					changeText += " -> " + Integer.toString(newStat);
					changeLabels.get(i).setText(changeText);
				}
			}
		}
	}
}
