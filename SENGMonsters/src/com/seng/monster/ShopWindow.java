package com.seng.monster;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.im.InputMethodHighlight;
import java.util.ArrayList;
import java.util.List;

import javax.management.modelmbean.RequiredModelMBean;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		itemBuy1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(p, 0, PlayerItems, ShopItems);
			}
		});
		frame.getContentPane().add(itemBuy1, "34, 14");
		
		JLabel shopItem1 = new JLabel("");
		frame.getContentPane().add(shopItem1, "36, 14");
		
		JLabel playerItem2 = new JLabel("");
		frame.getContentPane().add(playerItem2, "8, 18");
		
		JButton itemSell2 = new JButton("Sell");
		itemSell2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellItem(p, 1, PlayerItems, ShopItems);
			}
		});
		frame.getContentPane().add(itemSell2, "10, 18");
		
		JButton itemBuy2 = new JButton("Buy");
		itemBuy2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(p, 1, PlayerItems, ShopItems);
			}
		});
		frame.getContentPane().add(itemBuy2, "34, 18");
		
		JLabel shopItem2 = new JLabel("");
		frame.getContentPane().add(shopItem2, "36, 18");
		
		JLabel playerItem3 = new JLabel("");
		frame.getContentPane().add(playerItem3, "8, 22");
		
		JButton itemSell3 = new JButton("Sell");
		itemSell3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellItem(p, 2, PlayerItems, ShopItems);
			}
		});
		frame.getContentPane().add(itemSell3, "10, 22");
		
		JButton itemBuy3 = new JButton("Buy");
		itemBuy3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(p, 2, PlayerItems, ShopItems);
			}
		});
		frame.getContentPane().add(itemBuy3, "34, 22");
		
		JLabel shopItem3 = new JLabel("");
		frame.getContentPane().add(shopItem3, "36, 22");
		
		JLabel playerItem4 = new JLabel("");
		frame.getContentPane().add(playerItem4, "8, 26");
		
		JButton itemSell4 = new JButton("Sell");
		itemSell4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellItem(p, 3, PlayerItems, ShopItems);
			}
		});
		frame.getContentPane().add(itemSell4, "10, 26");
		
		JButton itemBuy4 = new JButton("Buy");
		itemBuy4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(p, 3, PlayerItems, ShopItems);
			}
		});
		frame.getContentPane().add(itemBuy4, "34, 26");
		
		JLabel shopItem4 = new JLabel("");
		frame.getContentPane().add(shopItem4, "36, 26");
		
		List<JLabel> sellLabels = List.of(playerItem1, playerItem2, playerItem3, playerItem4);
		List<JButton> sellButtons = List.of(itemSell1, itemSell2, itemSell3, itemSell4);
		checkVisibility(PlayerItems, sellLabels, sellButtons, true);
		
		List<JLabel> buyLabels = List.of(shopItem1, shopItem2, shopItem3, shopItem4);
		List<JButton> buyButtons = List.of(itemBuy1, itemBuy2, itemBuy3, itemBuy4);
		checkVisibility(ShopItems, buyLabels, buyButtons, false);
		
		
	}
	
	private void checkVisibility(ArrayList<? extends BaseItem> items, List<JLabel> labels, List<JButton> buttons, boolean selling)
	{
		int listSize = items.size();
		for (int i = 0; i < 4; i++)
		{
			if (i >= listSize)
			{
				labels.get(i).setVisible(false);
				buttons.get(i).setVisible(false);
			}
			else 
			{
				changeBorder(labels.get(i), items.get(i));
				if (selling)
				{
					labels.get(i).setText(items.get(i).getDetailsSellbackHTML());
				}
				else 
				{
					labels.get(i).setText(items.get(i).getDetailsPriceHTML());
				}
				
			}
		}
	}
	
	private void hideButton(JButton button, int index, int size)
	{
		if (index >= size || size == 1)
		{
			button.setVisible(false);
		}
	}
	
	private void buyItem(Player p, int index, ArrayList<? extends BaseItem> items, ArrayList<? extends BaseItem> shopItems)
	{
		if (items.size() >= 4)
		{
			if (items.get(0) instanceof Monster)
			{
				JOptionPane.showMessageDialog(frame, "You cannot have more than 4 monsters");
			}
			else
			{
				JOptionPane.showMessageDialog(frame, "You cannot have more than 4 items");
			}
		}
		else
		{
			if (shopItems.get(index).getPrice() > p.getGold())
			{
				JOptionPane.showMessageDialog(frame, "You cannot afford that product");
			}
			else 
			{
				if (shopItems.get(index) instanceof Monster)
				{
					p.addItem((Monster) shopItems.get(index));
					p.removeFromShop((Monster) shopItems.get(index));
					new ShopWindow(p, items, p.getDailyMonsters(p.getDays()));
					
				}
				else
				{
					p.addItem((Item) shopItems.get(index));
					p.removeFromShop((Item) shopItems.get(index));
					new ShopWindow(p, items, p.getDailyItem(p.getDays()));
				}
			}
			
		}
	}
	private void sellItem(Player p, int index, ArrayList<? extends BaseItem> items, ArrayList<? extends BaseItem> shopItems)
	{
		if (items.get(index) instanceof Monster)
		{
			p.removeItem(items.get(index));
			new ShopWindow(p, p.getMonsters(), shopItems);
		}
		else 
		{
			p.removeItem(items.get(index));
			new ShopWindow(p, p.getItems(), shopItems);
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
