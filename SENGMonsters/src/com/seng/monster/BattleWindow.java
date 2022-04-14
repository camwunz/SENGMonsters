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

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class BattleWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleWindow window = new BattleWindow(new OpposingPlayer(0), null, 0);
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
	public BattleWindow(OpposingPlayer chosenEnemy, Player p, int turn) {
		initialize(chosenEnemy, p, turn);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(OpposingPlayer chosenEnemy, Player p, int turn) {
		Battle battle = new Battle(p, chosenEnemy);
		ArrayList<String> damagePrompts =  battle.nextTurn(p, chosenEnemy);
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(111dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(120dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(96dlu;default)"),},
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
				RowSpec.decode("max(23dlu;default)"),
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
		
		JLabel TurnCounter = new JLabel("Turn " + turn);
		TurnCounter.setHorizontalAlignment(SwingConstants.CENTER);
		TurnCounter.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(TurnCounter, "14, 4");
		
		JLabel PlayerName = new JLabel(p.getName() + "'s Team");
		PlayerName.setFont(new Font("Tahoma", Font.BOLD, 17));
		PlayerName.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(PlayerName, "6, 10, fill, fill");
		
		JLabel EnemyName = new JLabel(chosenEnemy.getName() + "'s Team");
		EnemyName.setHorizontalAlignment(SwingConstants.LEFT);
		EnemyName.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.getContentPane().add(EnemyName, "24, 10");
		
		JLabel PlayerMonster1 = new JLabel(p.getMonsters().get(0).getBattleDetails());
		PlayerMonster1.setHorizontalAlignment(SwingConstants.LEFT);
		PlayerMonster1.setFont(new Font("Verdana", Font.PLAIN, 14));
		changeBorder(PlayerMonster1, p.getMonsters().get(0));
		frame.getContentPane().add(PlayerMonster1, "6, 14");
		
		JLabel BattleText1 = new JLabel("<html>" + damagePrompts.get(0) + "</html>");
		BattleText1.setHorizontalAlignment(JLabel.CENTER);
		BattleText1.setFont(new Font("Verdana", Font.PLAIN, 18));
		frame.getContentPane().add(BattleText1, "14, 9, 3, 7");
		
		JLabel BattleText2 = new JLabel("<html>" + damagePrompts.get(1) + "</html>");
		BattleText2.setHorizontalAlignment(JLabel.CENTER);
		BattleText2.setFont(new Font("Verdana", Font.PLAIN, 18));
		frame.getContentPane().add(BattleText2, "14, 18, 3, 8");
		
		JLabel EnemyMonster1 = new JLabel(chosenEnemy.getMonsters().get(0).getBattleDetails());
		EnemyMonster1.setHorizontalAlignment(SwingConstants.LEFT);
		EnemyMonster1.setFont(new Font("Verdana", Font.PLAIN, 14));
		changeBorder(EnemyMonster1, chosenEnemy.getMonsters().get(0));
		frame.getContentPane().add(EnemyMonster1, "24, 14");
		
		JLabel PlayerMonster2 = new JLabel("");
		PlayerMonster2.setHorizontalAlignment(SwingConstants.LEFT);
		PlayerMonster2.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(PlayerMonster2, "6, 18");
		
		JLabel EnemyMonster2 = new JLabel("");
		EnemyMonster2.setHorizontalAlignment(SwingConstants.LEFT);
		EnemyMonster2.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(EnemyMonster2, "24, 18");
		
		JLabel PlayerMonster3 = new JLabel("");
		PlayerMonster3.setHorizontalAlignment(SwingConstants.LEFT);
		PlayerMonster3.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(PlayerMonster3, "6, 22");
		
		JLabel EnemyMonster3 = new JLabel("");
		EnemyMonster3.setHorizontalAlignment(SwingConstants.LEFT);
		EnemyMonster3.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(EnemyMonster3, "24, 22");
		
		JLabel PlayerMonster4 = new JLabel("");
		PlayerMonster4.setHorizontalAlignment(SwingConstants.LEFT);
		PlayerMonster4.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(PlayerMonster4, "6, 26");
		
		JLabel EnemyMonster4 = new JLabel("");
		EnemyMonster4.setHorizontalAlignment(SwingConstants.LEFT);
		EnemyMonster4.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(EnemyMonster4, "24, 26");
		
		JButton NextTurnButton = new JButton("Next Turn");
		NextTurnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> damagePrompts = battle.nextTurn(p, chosenEnemy);
				BattleText1.setText("<html>" + damagePrompts.get(0) + "</html>");
				BattleText2.setText("<html>" + damagePrompts.get(1) + "</html>");
				PlayerMonster1.setText(p.getMonsters().get(0).getBattleDetails());
				changeBorder(PlayerMonster1, p.getMonsters().get(0));
				
				EnemyMonster1.setText(chosenEnemy.getMonsters().get(0).getBattleDetails());
				changeBorder(EnemyMonster1, chosenEnemy.getMonsters().get(0));

				if (damagePrompts.get(2).equals("0")) {
					if (p.getMonsters().size() >= 2) {
						changeBorder(PlayerMonster2, p.getMonsters().get(1));
						PlayerMonster2.setText(p.getMonsters().get(1).getBattleDetails());
					}
					
					
					if (chosenEnemy.getMonsters().size() >= 2) {
						changeBorder(EnemyMonster2, chosenEnemy.getMonsters().get(1));
						EnemyMonster2.setText(chosenEnemy.getMonsters().get(1).getBattleDetails());
					}
					
					if (p.getMonsters().size() >= 3) {
						changeBorder(PlayerMonster3, p.getMonsters().get(2));
						PlayerMonster3.setText(p.getMonsters().get(2).getBattleDetails());
					}
					
					
					if (chosenEnemy.getMonsters().size() >= 3) {
						changeBorder(EnemyMonster3, chosenEnemy.getMonsters().get(2));
						EnemyMonster3.setText(chosenEnemy.getMonsters().get(2).getBattleDetails());
					}
					
					if (p.getMonsters().size() >= 4) {
						changeBorder(PlayerMonster4, p.getMonsters().get(3));
						PlayerMonster4.setText(p.getMonsters().get(3).getBattleDetails());
					}
					
					if (chosenEnemy.getMonsters().size() >= 4) {
						changeBorder(EnemyMonster4, chosenEnemy.getMonsters().get(3));
						EnemyMonster4.setText(chosenEnemy.getMonsters().get(3).getBattleDetails());
					
					}
				}
				else if (damagePrompts.get(2).equals("1"))
				{
					new BattleFinishWindow(p, chosenEnemy, 1);
					frame.dispose();
				}
				else if (damagePrompts.get(2).equals("2"))
				{
					new BattleFinishWindow(p, chosenEnemy, 2);
					frame.dispose();
				}
			}
		});
		frame.getContentPane().add(NextTurnButton, "14, 30");
		
		if (p.getMonsters().size() >= 2) {
			changeBorder(PlayerMonster2, p.getMonsters().get(1));
			PlayerMonster2.setText(p.getMonsters().get(1).getBattleDetails());
		}
		
		
		if (chosenEnemy.getMonsters().size() >= 2) {
			changeBorder(EnemyMonster2, chosenEnemy.getMonsters().get(1));
			EnemyMonster2.setText(chosenEnemy.getMonsters().get(1).getBattleDetails());
		}
		
		if (p.getMonsters().size() >= 3) {
			changeBorder(PlayerMonster3, p.getMonsters().get(2));
			PlayerMonster3.setText(p.getMonsters().get(2).getBattleDetails());
		}
		
		
		if (chosenEnemy.getMonsters().size() >= 3) {
			changeBorder(EnemyMonster3, chosenEnemy.getMonsters().get(2));
			EnemyMonster3.setText(chosenEnemy.getMonsters().get(2).getBattleDetails());
		}
		
		if (p.getMonsters().size() >= 4) {
			changeBorder(PlayerMonster4, p.getMonsters().get(3));
			PlayerMonster4.setText(p.getMonsters().get(3).getBattleDetails());
		}
		
		if (chosenEnemy.getMonsters().size() >= 4) {
			changeBorder(EnemyMonster4, chosenEnemy.getMonsters().get(3));
			EnemyMonster4.setText(chosenEnemy.getMonsters().get(3).getBattleDetails());
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
