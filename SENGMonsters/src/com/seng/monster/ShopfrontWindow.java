package com.seng.monster;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* Window for choosing between monster shop and item shop
*
* @author  Cameron Wu
* @version 1.0
*/
public class ShopfrontWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @param args, n/a
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Player p = new Player(1,10);
					p.addGold(9999);
					p.addItem(new Monster(p.getDays()));
					p.addItem(new Monster(p.getDays()));
					p.addItem(new Monster(p.getDays()));
					p.addItem(new Monster(p.getDays()));
					p.addItem(new Item());
					p.addItem(new Item());
					ShopfrontWindow window = new ShopfrontWindow(p);
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
	public ShopfrontWindow(Player p) {
		initialize(p);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param player
	 */
	private void initialize(Player p) 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(19dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(160dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(160dlu;default)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(44dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(115dlu;default)"),}));
		
		JButton monsterShop = new JButton("Monster Shop");
		monsterShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShopWindow(p, p.getMonsters(), p.getDailyMonsters(), "monster");
				frame.dispose();
			}
		});
		monsterShop.setFont(new Font("Verdana", Font.PLAIN, 30));
		frame.getContentPane().add(monsterShop, "8, 10, fill, fill");
		
		JButton itemShop = new JButton("<html>Item Shop </html>");
		itemShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShopWindow(p, p.getItems(), p.getDailyItem(), "item");
				frame.dispose();
			}
		});
		itemShop.setFont(new Font("Tahoma", Font.PLAIN, 30));
		frame.getContentPane().add(itemShop, "16, 10, fill, fill");
	}

}
