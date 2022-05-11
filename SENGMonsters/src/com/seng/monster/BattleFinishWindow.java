package com.seng.monster;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

/**
* Shows the user the outcome at the end of the battle
*
* @author  Cameron Wu
* @version 1.0
*/
public class BattleFinishWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @param args, n/a
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
	 * @param p, the player
	 * @param chosenPlayer, the chosen opponent
	 * @param winner, int based on who won
	 */
	public BattleFinishWindow(Player p, OpposingPlayer chosenPlayer, int winner) {
		initialize(p, chosenPlayer, winner);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param the player
	 * @param the chosen opponent
	 * @param winner 
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
		
		JLabel playerName = new JLabel(p.getName() + "'s Team");
		playerName.setHorizontalAlignment(SwingConstants.LEFT);
		playerName.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.getContentPane().add(playerName, "10, 10");
		
		JLabel playerMonster1 = new JLabel("");
		playerMonster1.setHorizontalAlignment(SwingConstants.LEFT);
		playerMonster1.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(playerMonster1, "10, 14");
		
		JLabel winnerLabel = new JLabel("");
		winnerLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		frame.getContentPane().add(winnerLabel, "30, 14, fill, fill");
		
		JLabel playerMonster2 = new JLabel("");
		playerMonster2.setHorizontalAlignment(SwingConstants.LEFT);
		playerMonster2.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(playerMonster2, "10, 18");
		
		JLabel playerMonster3 = new JLabel("");
		playerMonster3.setHorizontalAlignment(SwingConstants.LEFT);
		playerMonster3.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(playerMonster3, "10, 22");
		
		JLabel playerMonster4 = new JLabel("");
		playerMonster4.setHorizontalAlignment(SwingConstants.LEFT);
		playerMonster4.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(playerMonster4, "10, 26");
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuWindow(p);
				frame.dispose();
			}
		});
		frame.getContentPane().add(exitButton, "30, 26, fill, fill");
		
		List<JLabel> labels = List.of(playerMonster1, playerMonster2, playerMonster3, playerMonster4);
		updateText(labels, p.getMonsters());
		
		if (winner == 2)
		{
			winnerLabel.setText("You won the battle and won " + chosenPlayer.getReward() + " gold!");
			p.addGold(chosenPlayer.getReward());
			p.addToScore((int)(chosenPlayer.getReward()/2));
		}
		else {
			winnerLabel.setText("You lost the battle!");
		}
	}
	
	/**
	 * Checks Visibility of labels for the users monsters
	 * @param the list of JLabels
	 * @param the lsit of monsters
	 */
	private void updateText(List<JLabel> labels, ArrayList<Monster> monsters)
	{
		int size = monsters.size();
		for (int i = 0; i < 4; i++)
		{
			if (i < size)
			{
				healthBorder.changeBorder(labels.get(i), monsters.get(i));
				labels.get(i).setText(monsters.get(i).getDetails(true));
			}
			else
			{
				labels.get(i).setVisible(false);
			}
		}
	}
}
