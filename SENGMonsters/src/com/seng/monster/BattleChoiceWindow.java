package com.seng.monster;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class BattleChoiceWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ArrayList<OpposingPlayer> players = new ArrayList<OpposingPlayer>();
				for (int i = 0; i < 4; i++)
				{
					OpposingPlayer tempPlayer = new OpposingPlayer(1);
					players.add(tempPlayer);
				}
				try {
					BattleChoiceWindow window = new BattleChoiceWindow(players, new Player(null, null));
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
	public BattleChoiceWindow(ArrayList<OpposingPlayer> opposingPlayers, Player p) {
		initialize(opposingPlayers, p);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<OpposingPlayer> opposingPlayers, Player p) {
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
		
		JButton BattleChoice1 = new JButton(opposingPlayers.get(0).getPromptHTML());
		BattleChoice1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpposingPlayer chosenEnemy = opposingPlayers.get(0);
				BattleWindow screen = new BattleWindow(chosenEnemy, p);
				frame.dispose();
			}
		});
		frame.getContentPane().add(BattleChoice1, "8, 4, fill, fill");
		
		JButton BattleChoice2 = new JButton(opposingPlayers.get(1).getPromptHTML());
		frame.getContentPane().add(BattleChoice2, "18, 4, fill, fill");
		
		JButton BattleChoice3 = new JButton(opposingPlayers.get(2).getPromptHTML());
		frame.getContentPane().add(BattleChoice3, "8, 10, fill, fill");
		
		JButton BattleChoice4 = new JButton(opposingPlayers.get(3).getPromptHTML());
		frame.getContentPane().add(BattleChoice4, "18, 10, fill, fill");
		
		JButton BattleChoiceExit = new JButton("Exit");
		frame.getContentPane().add(BattleChoiceExit, "9, 12, 8, 1");
	}

}
