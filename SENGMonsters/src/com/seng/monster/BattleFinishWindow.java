package com.seng.monster;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class BattleFinishWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleFinishWindow window = new BattleFinishWindow(null, null, 1);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param winner 
	 */
	public BattleFinishWindow(Player p, OpposingPlayer chosenPlayer, int winner) {
		initialize(p, chosenPlayer, winner);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Player p, OpposingPlayer chosenPlayer, int winner) {
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel PlayerName = new JLabel(p.getName() + "'s Team");
		PlayerName.setHorizontalAlignment(SwingConstants.LEFT);
		PlayerName.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.getContentPane().add(PlayerName, "10, 10");
		
		JLabel PlayerMonster1 = new JLabel(p.getMonsters().get(0).getBattleDetails());
		PlayerMonster1.setHorizontalAlignment(SwingConstants.LEFT);
		PlayerMonster1.setFont(new Font("Verdana", Font.PLAIN, 14));
		changeBorder(PlayerMonster1, p.getMonsters().get(0));
		frame.getContentPane().add(PlayerMonster1, "10, 14");
		
		JLabel WinnerLabel = new JLabel("New label");
		WinnerLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		frame.getContentPane().add(WinnerLabel, "30, 14, fill, fill");
		
		JLabel PlayerMonster2 = new JLabel("");
		PlayerMonster2.setHorizontalAlignment(SwingConstants.LEFT);
		PlayerMonster2.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(PlayerMonster2, "10, 18");
		
		JLabel PlayerMonster3 = new JLabel("");
		PlayerMonster3.setHorizontalAlignment(SwingConstants.LEFT);
		PlayerMonster3.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(PlayerMonster3, "10, 22");
		
		JLabel PlayerMonster4 = new JLabel("");
		PlayerMonster4.setHorizontalAlignment(SwingConstants.LEFT);
		PlayerMonster4.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(PlayerMonster4, "10, 26");
		
		JButton ExitButton = new JButton("Exit");
		frame.getContentPane().add(ExitButton, "30, 26, fill, fill");
		
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
		
		if (winner == 2)
		{
			WinnerLabel.setText("You won the battle!");
		}
		else {
			WinnerLabel.setText("You lost the battle!");
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
