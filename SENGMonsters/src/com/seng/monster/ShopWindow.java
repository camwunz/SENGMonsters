package com.seng.monster;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.im.InputMethodHighlight;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;

public class ShopWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopWindow window = new ShopWindow(null, null, null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param p 
	 */
	public ShopWindow(Player p, ArrayList<? extends BaseItem> PlayerItems, ArrayList<? extends BaseItem> ShopItems) {
		initialize(p, PlayerItems, ShopItems);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Player p, ArrayList<? extends BaseItem> PlayerItems, ArrayList<? extends BaseItem> ShopItems) {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(34dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(32dlu;default)"),
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
				RowSpec.decode("max(13dlu;default)"),
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
		
		JLabel nameLabel = new JLabel("");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(nameLabel, "8, 10");
		
		if (PlayerItems.size() <= 0)
		{
			nameLabel.setText("You have no items");
		}
		else if (PlayerItems.get(0) instanceof Monster)
		{
			nameLabel.setText("Your Monsters");
		}
		else 
		{
			nameLabel.setText("Your Items");
		}
		
		
		int ItemListSize = PlayerItems.size();
		
		JLabel shopLabel = new JLabel("");
		shopLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(shopLabel, "36, 10");
		JLabel playerItem1 = new JLabel("");
		frame.getContentPane().add(playerItem1, "8, 14");
		changeLabel(playerItem1, 0, PlayerItems);
		
		JButton itemSell1 = new JButton("Sell");
		itemSell1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellItem(p, 0, PlayerItems, ShopItems);
			}
		});
		frame.getContentPane().add(itemSell1, "10, 14");
		hideButton(itemSell1, 0, ItemListSize);
		if (nameLabel.getText().equals("Your Items"))
		{
			itemSell1.setVisible(true);
		}
		
		JButton itemBuy1 = new JButton("Buy");
		frame.getContentPane().add(itemBuy1, "34, 14");
		
		JLabel shopItem1 = new JLabel("");
		frame.getContentPane().add(shopItem1, "36, 14");
		
		JLabel playerItem2 = new JLabel("");
		frame.getContentPane().add(playerItem2, "8, 18");
		changeLabel(playerItem2, 1, PlayerItems);
		
		JButton itemSell2 = new JButton("Sell");
		itemSell2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellItem(p, 1, PlayerItems, ShopItems);
			}
		});
		frame.getContentPane().add(itemSell2, "10, 18");
		hideButton(itemSell2, 1, ItemListSize);
		
		JButton itemBuy2 = new JButton("Buy");
		frame.getContentPane().add(itemBuy2, "34, 18");
		
		JLabel shopItem2 = new JLabel("");
		frame.getContentPane().add(shopItem2, "36, 18");
		
		JLabel playerItem3 = new JLabel("");
		frame.getContentPane().add(playerItem3, "8, 22");
		changeLabel(playerItem3, 2, PlayerItems);
		
		JButton itemSell3 = new JButton("Sell");
		itemSell3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellItem(p, 2, PlayerItems, ShopItems);
			}
		});
		frame.getContentPane().add(itemSell3, "10, 22");
		hideButton(itemSell3, 2, ItemListSize);
		
		JButton itemBuy3 = new JButton("Buy");
		frame.getContentPane().add(itemBuy3, "34, 22");
		
		JLabel shopItem3 = new JLabel("");
		frame.getContentPane().add(shopItem3, "36, 22");
		
		JLabel playerItem4 = new JLabel("");
		frame.getContentPane().add(playerItem4, "8, 26");
		changeLabel(playerItem4, 3, PlayerItems);
		
		JButton itemSell4 = new JButton("Sell");
		itemSell4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellItem(p, 3, PlayerItems, ShopItems);
			}
		});
		frame.getContentPane().add(itemSell4, "10, 26");
		hideButton(itemSell4, 3, ItemListSize);
		
		JButton itemBuy4 = new JButton("Buy");
		frame.getContentPane().add(itemBuy4, "34, 26");
		
		JLabel shopItem4 = new JLabel("");
		frame.getContentPane().add(shopItem4, "36, 26");
	}
	
	private void hideButton(JButton button, int index, int size)
	{
		if (index >= size || size == 1)
		{
			button.setVisible(false);
		}
	}
	
	private void sellItem(Player p, int index, ArrayList<? extends BaseItem> Items, ArrayList<? extends BaseItem> ShopItems)
	{
		if (Items.get(index) instanceof Monster)
		{
			p.removeItem(Items.get(index));
			new ShopWindow(p, p.getMonsters(), ShopItems);
		}
		else 
		{
			p.removeItem(Items.get(index));
			new ShopWindow(p, p.getItems(), ShopItems);
		}
		
		frame.dispose();
	}
	
	private void changeLabel(JLabel label, int index, ArrayList<? extends BaseItem> ItemList)
	{
		if (index < ItemList.size())
		{
			changeBorder(label, ItemList.get(index));
			label.setText((ItemList.get(index)).getDetailsSellbackHTML());
			label.setText((ItemList.get(index)).getDetailsSellbackHTML());
		}
	}
	
	private void changeBorder (JLabel label, BaseItem i)
	{
		Border redBorder = BorderFactory.createLineBorder(Color.RED, 5);
		Border greenBorder = BorderFactory.createLineBorder(Color.GREEN, 5);
		if (i.getCurrentHealth() <= 0)
		{
			label.setBorder(redBorder);
		}
		else {
			label.setBorder(greenBorder);
		}
	}

}
