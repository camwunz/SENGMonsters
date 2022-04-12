package com.seng.monster;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class BattleWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleWindow window = new BattleWindow(null, null);
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
	public BattleWindow(OpposingPlayer chosenEnemy, Player p) {
		initialize(chosenEnemy, p);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(OpposingPlayer chosenEnemy, Player p) {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
