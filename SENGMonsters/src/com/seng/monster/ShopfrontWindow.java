package com.seng.monster;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopfrontWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Player p = new Player(1,10);
					p.setGold(9999);
					p.addMonster(new Monster());
					p.addMonster(new Monster());
					p.addMonster(new Monster());
					p.addMonster(new Monster());
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
	 */
	public ShopfrontWindow(Player p) {
		initialize(p);
	}

	/**
	 * Initialize the contents of the frame.
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
		
		JButton MonsterShop = new JButton("Monster Shop");
		MonsterShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShopWindow(p, p.getMonsters(), p.getDailyMonsters(p.getDays()));
				frame.dispose();
			}
		});
		MonsterShop.setFont(new Font("Verdana", Font.PLAIN, 30));
		frame.getContentPane().add(MonsterShop, "8, 10, fill, fill");
		
		JButton ItemShop = new JButton("<html>Item Shop </html>");
		ItemShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShopWindow(p, p.getItems(), p.getDailyItem(p.getDays()));
			}
		});
		ItemShop.setFont(new Font("Tahoma", Font.PLAIN, 30));
		frame.getContentPane().add(ItemShop, "16, 10, fill, fill");
	}

}
