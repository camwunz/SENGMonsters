package com.seng.monster;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* Window for the main menu giving the user many options for their next action as well as showing their current monsters.
*
* @author  Cameron Wu
* @version 1.0
*/
public class MenuWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @param args, n/a
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Player p = new Player(1, 10);
					p.setName("Cameron");
					p.addGold(9999);
					p.addItem(new Monster(3));
					
					MenuWindow window = new MenuWindow(p);
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
	public MenuWindow(Player p) {
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
				ColumnSpec.decode("max(145dlu;default)"),
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
				ColumnSpec.decode("max(57dlu;default)"),},
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
				RowSpec.decode("max(43dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(43dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(43dlu;default)"),
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
		
		JLabel dayLabel = new JLabel("Day " + p.getDays() + "/" + p.getTotalDays() + " Current Gold: " + p.getGold());
		dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dayLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(dayLabel, "6, 4, 33, 1");
		
		JLabel playerMonster1 = new JLabel("");
		frame.getContentPane().add(playerMonster1, "8, 10");
		
		JButton inventoryButton = new JButton("View Inventory");
		inventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InventoryViewWindow(p);
				frame.dispose();
			}
		});
		frame.getContentPane().add(inventoryButton, "38, 10, 1, 2");
		
		JLabel playerMonster2 = new JLabel("");
		frame.getContentPane().add(playerMonster2, "8, 14");
		
		JButton battleButton = new JButton("View Battles");
		battleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BattleChoiceWindow(p);
				frame.dispose();
			}
		});
		frame.getContentPane().add(battleButton, "38, 14, 1, 2");
		
		JLabel playerMonster3 = new JLabel("");
		frame.getContentPane().add(playerMonster3, "8, 18");
		
		JButton shopButton = new JButton("View Shop");
		shopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShopfrontWindow(p);
				frame.dispose();
			}
		});
		frame.getContentPane().add(shopButton, "38, 18, 1, 2");
		
		JLabel playerMonster4 = new JLabel("");
		frame.getContentPane().add(playerMonster4, "8, 22");
		
		JButton sleepButton = new JButton("Go To Sleep");
		sleepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (p.getDays() < p.getTotalDays())
				{
					new SleepWindow(p);
					frame.dispose();
				}
				else
				{
					new FinishWindow(p);
					frame.dispose();
				}
			}
		});
		frame.getContentPane().add(sleepButton, "20, 32, 11, 1");
		
		List<JLabel> labels = List.of(playerMonster1, playerMonster2, playerMonster3, playerMonster4);
		checkVisibility(labels, p.getMonsters());
	}
	
	/**
	 * Checks Visibility of labels for the users monsters
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
				labels.get(i).setText(monsters.get(i).getDetails(true));
				healthBorder.changeBorder(labels.get(i), monsters.get(i));
				
			}
		}
	}
}
