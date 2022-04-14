package com.seng.monster;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;

public class ShopMonsterWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopMonsterWindow window = new ShopMonsterWindow(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param p 
	 */
	public ShopMonsterWindow(Player p) {
		initialize(p);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Player p) {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(34dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(32dlu;default)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(13dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel NameLabel = new JLabel("Your Monsters");
		NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(NameLabel, "8, 10");
		
		ArrayList<Monster> MonsterListPlayer = p.getMonsters();
		int MonsterListSize = MonsterListPlayer.size();
		JLabel PlayerMonster1 = new JLabel("");
		frame.getContentPane().add(PlayerMonster1, "8, 14");
		changeLabel(PlayerMonster1, 0, MonsterListPlayer);
		
		JButton MonsterSell1 = new JButton("Sell");
		MonsterSell1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellMonster(p, 0);
			}
		});
		frame.getContentPane().add(MonsterSell1, "10, 14");
		hideButton(MonsterSell1, 0, MonsterListSize);
		
		JLabel PlayerMonster2 = new JLabel("");
		frame.getContentPane().add(PlayerMonster2, "8, 18");
		changeLabel(PlayerMonster2, 1, MonsterListPlayer);
		
		JButton MonsterSell2 = new JButton("Sell");
		MonsterSell2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellMonster(p, 1);
			}
		});
		frame.getContentPane().add(MonsterSell2, "10, 18");
		hideButton(MonsterSell2, 1, MonsterListSize);
		
		JLabel PlayerMonster3 = new JLabel("");
		frame.getContentPane().add(PlayerMonster3, "8, 22");
		changeLabel(PlayerMonster3, 2, MonsterListPlayer);
		
		JButton MonsterSell3 = new JButton("Sell");
		MonsterSell3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellMonster(p, 2);
			}
		});
		frame.getContentPane().add(MonsterSell3, "10, 22");
		hideButton(MonsterSell3, 2, MonsterListSize);
		
		JLabel PlayerMonster4 = new JLabel("");
		frame.getContentPane().add(PlayerMonster4, "8, 26");
		changeLabel(PlayerMonster4, 3, MonsterListPlayer);
		
		JButton MonsterSell4 = new JButton("Sell");
		MonsterSell4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellMonster(p, 3);
			}
		});
		frame.getContentPane().add(MonsterSell4, "10, 26");
		hideButton(MonsterSell4, 3, MonsterListSize);
	}
	
	private void hideButton(JButton button, int index, int size)
	{
		if (index >= size || size == 1)
		{
			button.setVisible(false);
		}
	}
	
	private void sellMonster(Player p, int index)
	{
		p.removeMonster(p.getMonsters().get(index));
		new ShopMonsterWindow(p);
		frame.dispose();
	}
	
	private void changeLabel(JLabel label, int index, ArrayList<Monster> MonsterList)
	{
		if (index < MonsterList.size())
		{
			changeBorder(label, MonsterList.get(index));
			label.setText(MonsterList.get(index).getDetailsShopSellbackHTML());
		}
	}
	
	private void changeBorder (JLabel label, Monster m)
	{
		Border redBorder = BorderFactory.createLineBorder(Color.RED, 5);
		Border greenBorder = BorderFactory.createLineBorder(Color.GREEN, 5);
		if (m.getCurrentHealth() <= 0)
		{
			label.setBorder(redBorder);
		}
		else {
			label.setBorder(greenBorder);
		}
	}

}
