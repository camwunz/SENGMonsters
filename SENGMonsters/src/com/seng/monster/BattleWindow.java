package com.seng.monster;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

/**
* Window for showing the health of user and opposing player
* each turn of the battle, as well as the outcome for each turn
*
* @author  Cameron Wu
* @version 1.0
*/
public class BattleWindow {

	private JFrame frame;
	private int turn;

	/**
	 * Launch the application.
	 * @param args, n/a
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleWindow window = new BattleWindow(new OpposingPlayer(0), null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param chosenEnemy, the chosen opponent
	 * @param p, the player
	 */
	public BattleWindow(OpposingPlayer chosenEnemy, Player p) {
		initialize(chosenEnemy, p);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param the chosen opponent
	 * @param the player
	 */
	private void initialize(OpposingPlayer chosenEnemy, Player p) {
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
		
		turn = 1;
		JLabel turnCounter = new JLabel("Turn " + turn);
		turnCounter.setHorizontalAlignment(SwingConstants.CENTER);
		turnCounter.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(turnCounter, "14, 4");
		
		JLabel playerName = new JLabel(p.getName() + "'s Team");
		playerName.setFont(new Font("Tahoma", Font.BOLD, 17));
		playerName.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(playerName, "6, 10, fill, fill");
		
		JLabel enemyName = new JLabel(chosenEnemy.getName() + "'s Team");
		enemyName.setHorizontalAlignment(SwingConstants.LEFT);
		enemyName.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.getContentPane().add(enemyName, "24, 10");
		
		JLabel playerMonster1 = new JLabel("");
		playerMonster1.setHorizontalAlignment(SwingConstants.LEFT);
		playerMonster1.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(playerMonster1, "6, 14");
		
		JLabel battleText1 = new JLabel("<html>" + damagePrompts.get(0) + "</html>");
		battleText1.setHorizontalAlignment(JLabel.CENTER);
		battleText1.setFont(new Font("Verdana", Font.PLAIN, 18));
		frame.getContentPane().add(battleText1, "14, 9, 3, 7");
		
		JLabel battleText2 = new JLabel("<html>" + damagePrompts.get(1) + "</html>");
		battleText2.setHorizontalAlignment(JLabel.CENTER);
		battleText2.setFont(new Font("Verdana", Font.PLAIN, 18));
		frame.getContentPane().add(battleText2, "14, 18, 3, 8");
		
		JLabel enemyMonster1 = new JLabel("");
		enemyMonster1.setHorizontalAlignment(SwingConstants.LEFT);
		enemyMonster1.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(enemyMonster1, "24, 14");
		
		JLabel playerMonster2 = new JLabel("");
		playerMonster2.setHorizontalAlignment(SwingConstants.LEFT);
		playerMonster2.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(playerMonster2, "6, 18");
		
		JLabel enemyMonster2 = new JLabel("");
		enemyMonster2.setHorizontalAlignment(SwingConstants.LEFT);
		enemyMonster2.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(enemyMonster2, "24, 18");
		
		JLabel playerMonster3 = new JLabel("");
		playerMonster3.setHorizontalAlignment(SwingConstants.LEFT);
		playerMonster3.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(playerMonster3, "6, 22");
		
		JLabel enemyMonster3 = new JLabel("");
		enemyMonster3.setHorizontalAlignment(SwingConstants.LEFT);
		enemyMonster3.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(enemyMonster3, "24, 22");
		
		JLabel playerMonster4 = new JLabel("");
		playerMonster4.setHorizontalAlignment(SwingConstants.LEFT);
		playerMonster4.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(playerMonster4, "6, 26");
		
		JLabel enemyMonster4 = new JLabel("");
		enemyMonster4.setHorizontalAlignment(SwingConstants.LEFT);
		enemyMonster4.setFont(new Font("Verdana", Font.PLAIN, 14));
		frame.getContentPane().add(enemyMonster4, "24, 26");
		
		List<JLabel> playerLabels = List.of(playerMonster1, playerMonster2, playerMonster3, playerMonster4);
		List<JLabel> opponentLabels = List.of(enemyMonster1, enemyMonster2, enemyMonster3, enemyMonster4);
		checkVisibility(playerLabels, p.getMonsters());
		checkVisibility(opponentLabels, chosenEnemy.getMonsters());
		
		JButton NextTurnButton = new JButton("Next Turn");
		NextTurnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> damagePrompts = battle.nextTurn(p, chosenEnemy);
				turn++;
				
				turnCounter.setText("Turn " + turn);
				battleText1.setText("<html>" + damagePrompts.get(0) + "</html>");
				battleText2.setText("<html>" + damagePrompts.get(1) + "</html>");
				
				if (damagePrompts.get(2).equals("0")) 
				{
					checkVisibility(playerLabels, p.getMonsters());
					checkVisibility(opponentLabels, chosenEnemy.getMonsters());
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
		
		
		
		
	}
	
	/**
	 * Checks Visibility of labels for the users and opponent monsters
	 * @param the list of JLabels
	 * @param the list of monsters
	 */
	private void checkVisibility(List<JLabel> labels, ArrayList<Monster> monsters)
	{
		int listSize = monsters.size();
		for (int i = 0; i < 4; i++)
		{
			if (i >= listSize)
			{
				labels.get(i).setVisible(false);
			}
			else 
			{
				labels.get(i).setText(monsters.get(i).getBattleDetails());
				healthBorder.changeBorder(labels.get(i), monsters.get(i));
				
			}
		}
	}
	
}
