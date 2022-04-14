package com.seng.monster;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import java.awt.Font;
import java.awt.PrintGraphics;

public class BattleChoiceWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Player p = new Player(1, 10);
				p.setName("Cameron");
				p.setGold(99999);
				p.addMonster(new Monster());
				p.addMonster(new Monster());
				p.addMonster(new Monster());
				p.addMonster(new Monster());
				int day = p.getDays();
				ArrayList <OpposingPlayer> players = p.getOpponents(day);
				try {
					BattleChoiceWindow window = new BattleChoiceWindow(players, p, day);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BattleChoiceWindow(ArrayList<OpposingPlayer> opposingPlayers, Player p, int day) {
		initialize(opposingPlayers, p, day);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<OpposingPlayer> opposingPlayers, Player p, int day) {
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
				ColumnSpec.decode("max(150dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(20dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(150dlu;default)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(100dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(100dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(38dlu;default)"),}));
		
		
		JButton BattleChoice1 = new JButton("");
		if (opposingPlayers.size() > 0)
		{
			BattleChoice1.setText(opposingPlayers.get(0).getPromptHTML());
			BattleChoice1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					OpposingPlayer chosenEnemy = opposingPlayers.get(0);
					p.removeOpponent(day, 0);
					new BattleWindow(chosenEnemy, p, 1);
					frame.dispose();
				}
			});
		}
		else {
			BattleChoice1.setVisible(false);
		}
		frame.getContentPane().add(BattleChoice1, "8, 4, fill, fill");
		
		JButton BattleChoice2 = new JButton("");
		if (opposingPlayers.size() > 1)
		{
			
			BattleChoice2.setText(opposingPlayers.get(1).getPromptHTML());
			BattleChoice2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					OpposingPlayer chosenEnemy = opposingPlayers.get(1);
					p.removeOpponent(day, 1);
					new BattleWindow(chosenEnemy, p, 1);
					frame.dispose();
				}
			});
		}
		else 
		{
			BattleChoice2.setVisible(false);
		}
		frame.getContentPane().add(BattleChoice2, "18, 4, fill, fill");
		
		JButton BattleChoice3 = new JButton("");
		if (opposingPlayers.size() > 2)
		{
			
			BattleChoice3.setText(opposingPlayers.get(2).getPromptHTML());
			BattleChoice3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					OpposingPlayer chosenEnemy = opposingPlayers.get(2);
					p.removeOpponent(day, 2);
					new BattleWindow(chosenEnemy, p, 1);
					frame.dispose();
				}
			});
		}
		else {
			BattleChoice3.setVisible(false);
		}
		
		frame.getContentPane().add(BattleChoice3, "8, 10, fill, fill");
		
		
		JLabel ExitLabel = new JLabel("");
		ExitLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		ExitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(ExitLabel, "8, 6, 11, 1");
		if (opposingPlayers.size() < 1)
		{
			ExitLabel.setText("No more opponents for today!");
		}
		
		
		JButton BattleChoice4 = new JButton("");
		if (opposingPlayers.size() > 3)
		{
			
			BattleChoice4.setText(opposingPlayers.get(3).getPromptHTML());
			BattleChoice4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					OpposingPlayer chosenEnemy = opposingPlayers.get(3);
					p.removeOpponent(day, 3);
					new BattleWindow(chosenEnemy, p, 1);
					frame.dispose();
				}
			});
		}
		else
		{
			BattleChoice4.setVisible(false);
		}
		frame.getContentPane().add(BattleChoice4, "18, 10, fill, fill");
		
		JButton BattleChoiceExit = new JButton("Exit");
		BattleChoiceExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuWindow(p);
			}
		});
		frame.getContentPane().add(BattleChoiceExit, "9, 12, 8, 1");
	}

}
