package com.seng.monster;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
				FormSpecs.DEFAULT_COLSPEC,},
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
		
		JLabel PlayerName = new JLabel("Your Monsters");
		PlayerName.setHorizontalAlignment(SwingConstants.LEFT);
		PlayerName.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.getContentPane().add(PlayerName, "8, 8");
		
		JLabel PlayerMonster1 = new JLabel(p.getMonsters().get(0).getBattleDetails());
		PlayerMonster1.setHorizontalAlignment(SwingConstants.LEFT);
		PlayerMonster1.setFont(new Font("Verdana", Font.PLAIN, 14));
		changeBorder(PlayerMonster1, p.getMonsters().get(0));
		frame.getContentPane().add(PlayerMonster1, "8, 12");
		
		JLabel PlayerMonster2 = new JLabel("");
		PlayerMonster2.setHorizontalAlignment(SwingConstants.LEFT);
		PlayerMonster2.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(PlayerMonster2, "8, 16");
		
		JLabel PlayerMonster3 = new JLabel("");
		PlayerMonster3.setHorizontalAlignment(SwingConstants.LEFT);
		PlayerMonster3.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(PlayerMonster3, "8, 20");
		
		JLabel PlayerMonster4 = new JLabel("");
		PlayerMonster4.setHorizontalAlignment(SwingConstants.LEFT);
		PlayerMonster4.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(PlayerMonster4, "8, 24");
		
		

		
		if (p.getMonsters().size() >= 2) {
			changeBorder(PlayerMonster2, p.getMonsters().get(1));
			PlayerMonster2.setText(p.getMonsters().get(1).getBattleDetails());
		}
		
		if (p.getMonsters().size() >= 3) {
			changeBorder(PlayerMonster3, p.getMonsters().get(2));
			PlayerMonster3.setText(p.getMonsters().get(2).getBattleDetails());
		}
		
		if (p.getMonsters().size() >= 4) {
			changeBorder(PlayerMonster4, p.getMonsters().get(3));
			PlayerMonster4.setText(p.getMonsters().get(3).getBattleDetails());
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
