package com.seng.monster;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* Window for choosing the first monster at the start of the game
*
* @author  Cameron Wu
* @version 1.0
*/
public class MonsterChoiceWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @param args, n/a
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonsterChoiceWindow window = new MonsterChoiceWindow(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param p, player
	 */
	public MonsterChoiceWindow(Player p) {
		initialize(p);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param player
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
				ColumnSpec.decode("max(40dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(133dlu;default)"),
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
				ColumnSpec.decode("max(133dlu;default)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(23dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(100dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(100dlu;default)"),}));
		
		JLabel label = new JLabel("Choose a Monster:");
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(label, "8, 4, 15, 1");
		
		ArrayList<Monster> monsters = new ArrayList<Monster>();
		for (int i = 0; i < 4; i++)
		{
			monsters.add(new Monster(p.getDays()));
		}
		JButton monsterButton1 = new JButton(monsters.get(0).getDetails(true));
		monsterButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.addMonsterToList(monsters.get(0));
				new MenuWindow(p);
				frame.dispose();
			}
		});
		frame.getContentPane().add(monsterButton1, "8, 8, fill, fill");
		
		JButton monsterButton2 = new JButton(monsters.get(1).getDetails(true));
		monsterButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.addMonsterToList(monsters.get(1));
				new MenuWindow(p);
				frame.dispose();
			}
		});
		frame.getContentPane().add(monsterButton2, "22, 8, default, fill");
		
		JButton monsterButton3 = new JButton(monsters.get(2).getDetails(true));
		monsterButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.addMonsterToList(monsters.get(2));
				new MenuWindow(p);
				frame.dispose();
			}
		});
		frame.getContentPane().add(monsterButton3, "8, 16, fill, fill");
		
		JButton monsterButton4 = new JButton(monsters.get(3).getDetails(true));
		monsterButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.addMonsterToList(monsters.get(3));
				new MenuWindow(p);
				frame.dispose();
			}
		});
		frame.getContentPane().add(monsterButton4, "22, 16, default, fill");
	}

}
