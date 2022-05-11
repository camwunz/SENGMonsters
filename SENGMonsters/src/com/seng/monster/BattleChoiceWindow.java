package com.seng.monster;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

/**
* Window for the user to choose from 4 or less battles each day
*
* @author  Cameron Wu
* @version 1.0
*/
public class BattleChoiceWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @param args, n/a
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Player p = new Player(1, 10);
				p.setName("Cameron");
				p.addGold(99999);
				p.addItem(new Monster(p.getDays()));
				p.addItem(new Monster(p.getDays()));
				p.addItem(new Monster(p.getDays()));
				p.addItem(new Monster(p.getDays()));
				try {
					BattleChoiceWindow window = new BattleChoiceWindow(p);
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
	 */
	public BattleChoiceWindow(Player p) {
		initialize(p);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param the player
	 */
	private void initialize(Player p) {
		ArrayList<OpposingPlayer> opposingPlayers = p.getOpponents();
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
		
		
		JButton battleChoice1 = new JButton("");
		battleChoice1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseBattle(0, opposingPlayers, p);
			}
		});
		frame.getContentPane().add(battleChoice1, "8, 4, fill, fill");
		
		JButton battleChoice2 = new JButton("");
		battleChoice2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseBattle(1, opposingPlayers, p);
			}
		});
		frame.getContentPane().add(battleChoice2, "18, 4, fill, fill");
		
		JButton battleChoice3 = new JButton("");
		battleChoice3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseBattle(2, opposingPlayers, p);
			}
		});
		frame.getContentPane().add(battleChoice3, "8, 10, fill, fill");
		
		
		JLabel exitLabel = new JLabel("");
		exitLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		exitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(exitLabel, "8, 6, 11, 1");
		if (opposingPlayers.size() < 1)
		{
			exitLabel.setText("No more opponents for today!");
		}
		
		
		JButton battleChoice4 = new JButton("");
		battleChoice4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseBattle(3, opposingPlayers, p);
			}
		});
		frame.getContentPane().add(battleChoice4, "18, 10, fill, fill");
		
		JButton battleChoiceExit = new JButton("Exit");
		battleChoiceExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuWindow(p);
				frame.dispose();
			}
		});
		frame.getContentPane().add(battleChoiceExit, "9, 12, 8, 1");
		
		List<JButton> battleButtons = List.of(battleChoice1, battleChoice2, battleChoice3, battleChoice4);
		checkVisibility(battleButtons, opposingPlayers);
	}
	
	/**
	 * Closes the window and opens a window with the chosen battle
	 * @param the index of the opponent
	 * @param the list of opposing players
	 * @param the player
	 */
	private void chooseBattle(int index, ArrayList<OpposingPlayer> players, Player p)
	{
		OpposingPlayer chosenEnemy = players.get(index);
		p.removeOpponent(index);
		new BattleWindow(chosenEnemy, p);
		frame.dispose();
	}
	
	/**
	 * Checks the visibility and text of all choice buttons
	 * @param the list of JButtons
	 * @param the list of opposing players
	 */
	private void checkVisibility(List<JButton> battleButtons, ArrayList<OpposingPlayer> opposingPlayers)
	{
		int size = opposingPlayers.size();
		for (int i = 0; i < 4; i++)
		{
			if (i < size)
			{
				battleButtons.get(i).setText(opposingPlayers.get(i).getPromptHTML());
			}
			else
			{
				battleButtons.get(i).setVisible(false);
			}
		}
	}

}
