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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;



public class ShopWindow 
{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ShopWindow window = new ShopWindow(null, null, null, "");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param player
	 * @param list of monsters OR items from player
	 * @param list of monsters OR items for shop
	 * @param the type (monster/item)
	 */
	public ShopWindow(Player p, ArrayList<? extends BaseItem> playerItems, ArrayList<? extends BaseItem> shopItems, String type) 
	{
		initialize(p, playerItems, shopItems, type);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param player
	 * @param list of monsters OR items from player
	 * @param list of monsters OR items for shop
	 * @param the type (monster/item)
	 */
	private void initialize(Player p, ArrayList<? extends BaseItem> playerItems, ArrayList<? extends BaseItem> shopItems, String type) 
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
				ColumnSpec.decode("max(34dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(32dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(59dlu;default)"),
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel goldLabel = new JLabel("Current Gold: " + p.getGold());
		goldLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		goldLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(goldLabel, "12, 4, 15, 1");
		
		JLabel nameLabel = new JLabel("");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(nameLabel, "8, 6");
		
		JLabel shopLabel = new JLabel("");
		shopLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(shopLabel, "30, 6");
		
		
		if (type.equals("monster"))
		{
			nameLabel.setText("Your Monsters");
			shopLabel.setText("New Monsters");
			
			if (shopItems.size() <= 0)
			{
				shopLabel.setText("<html>No monsters available for today</html>");
			}
		}
		else 
		{
			nameLabel.setText("Your Items");
			shopLabel.setText("New Items");
			if (shopItems.size() <= 0)
			{
				shopLabel.setText("<html>No items available for today</html>");
			}
		}
		if (playerItems.size() <= 0)
		{
			nameLabel.setText("You have no " + type + "s");
		}
		
		JLabel playerItem1 = new JLabel("");
		frame.getContentPane().add(playerItem1, "8, 10");
		changeLabel(playerItem1, 0, playerItems);
		
		JButton itemSell1 = new JButton("Sell");
		itemSell1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellItem(p, 0, playerItems, shopItems);
			}
		});
		frame.getContentPane().add(itemSell1, "10, 10");
		if (nameLabel.getText().equals("Your Items"))
		{
			itemSell1.setVisible(true);
		}
		
		JButton itemBuy1 = new JButton("Buy");
		itemBuy1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(p, 0, playerItems, shopItems);
			}
		});
		frame.getContentPane().add(itemBuy1, "28, 10");
		
		JLabel shopItem1 = new JLabel("");
		frame.getContentPane().add(shopItem1, "30, 10");
		
		JLabel playerItem2 = new JLabel("");
		frame.getContentPane().add(playerItem2, "8, 14");
		
		JButton itemSell2 = new JButton("Sell");
		itemSell2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellItem(p, 1, playerItems, shopItems);
			}
		});
		frame.getContentPane().add(itemSell2, "10, 14");
		
		JButton itemBuy2 = new JButton("Buy");
		itemBuy2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(p, 1, playerItems, shopItems);
			}
		});
		frame.getContentPane().add(itemBuy2, "28, 14");
		
		JLabel shopItem2 = new JLabel("");
		frame.getContentPane().add(shopItem2, "30, 14");
		
		JLabel playerItem3 = new JLabel("");
		frame.getContentPane().add(playerItem3, "8, 18");
		
		JButton itemSell3 = new JButton("Sell");
		itemSell3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellItem(p, 2, playerItems, shopItems);
			}
		});
		frame.getContentPane().add(itemSell3, "10, 18");
		
		JButton itemBuy3 = new JButton("Buy");
		itemBuy3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(p, 2, playerItems, shopItems);
			}
		});
		frame.getContentPane().add(itemBuy3, "28, 18");
		
		JLabel shopItem3 = new JLabel("");
		frame.getContentPane().add(shopItem3, "30, 18");
		
		JLabel playerItem4 = new JLabel("");
		frame.getContentPane().add(playerItem4, "8, 22");
		
		JButton itemSell4 = new JButton("Sell");
		itemSell4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellItem(p, 3, playerItems, shopItems);
			}
		});
		frame.getContentPane().add(itemSell4, "10, 22");
		
		JButton itemBuy4 = new JButton("Buy");
		itemBuy4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(p, 3, playerItems, shopItems);
			}
		});
		frame.getContentPane().add(itemBuy4, "28, 22");
		
		JLabel shopItem4 = new JLabel("");
		frame.getContentPane().add(shopItem4, "30, 22");
		
		List<JLabel> sellLabels = List.of(playerItem1, playerItem2, playerItem3, playerItem4);
		List<JButton> sellButtons = List.of(itemSell1, itemSell2, itemSell3, itemSell4);
		checkVisibility(playerItems, sellLabels, sellButtons, true);
		
		List<JLabel> buyLabels = List.of(shopItem1, shopItem2, shopItem3, shopItem4);
		List<JButton> buyButtons = List.of(itemBuy1, itemBuy2, itemBuy3, itemBuy4);
		checkVisibility(shopItems, buyLabels, buyButtons, false);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new MenuWindow(p);
				frame.dispose();
			}
		});
		frame.getContentPane().add(exitButton, "12, 24, 11, 1");
		
		
		
	}
	
	/**
	 * Checks the visibility and text of all shop buttons and labels
	 * @param the list of items
	 * @param the list of JLabels
	 * @param the list of JButtons
	 * @param if these labels and buttons are selling or not
	 */
	private void checkVisibility(ArrayList<? extends BaseItem> items, List<JLabel> labels, List<JButton> buttons, boolean selling)
	{
		int listSize = items.size();
		for (int i = 0; i < 4; i++)
		{
			if (listSize == 1 && i == 0 && items.get(i) instanceof Monster && selling)
			{
				buttons.get(i).setVisible(false);
			}
			
			if (i >= listSize)
			{
				
				labels.get(i).setVisible(false);
				buttons.get(i).setVisible(false);
			}
			else 
			{
				healthBorder.changeBorder(labels.get(i), items.get(i));
				if (selling)
				{
					labels.get(i).setText(items.get(i).getDetailsSellback(true));
				}
				else 
				{
					labels.get(i).setText(items.get(i).getDetailsPrice(true));
				}
				
			}
		}
	}
	
	/**
	 * Checks and then maybe purchase an item if possible
	 * @param the player
	 * @param the index of item
	 * @param the list of player items
	 * @param the list of items to purchase from
	 */
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
					new ShopWindow(p, items, p.getDailyMonsters(), "monster");
					frame.dispose();
					
				}
				else
				{
					p.addItem((Item) shopItems.get(index));
					p.removeFromShop((Item) shopItems.get(index));
					new ShopWindow(p, items, p.getDailyItem(), "item");
					frame.dispose();
				}
			}
			
		}
	}
	
	/**
	 * Checks and then maybe sell an item if possible
	 * @param the player
	 * @param the index of item
	 * @param the list of player items
	 * @param the list of items to purchase from
	 */
	private void sellItem(Player p, int index, ArrayList<? extends BaseItem> items, ArrayList<? extends BaseItem> shopItems)
	{
		if (items.get(index) instanceof Monster)
		{
			p.removeItem(items.get(index));
			new ShopWindow(p, p.getMonsters(), shopItems, "monster");
		}
		else 
		{
			p.removeItem(items.get(index));
			new ShopWindow(p, p.getItems(), shopItems, "item");
		}
		
		frame.dispose();
	}
	
	/**
	 * Updates label text
	 * @param the label to change
	 * @param the index of item
	 * @param the list of items to get details from
	 */
	private void changeLabel(JLabel label, int index, ArrayList<? extends BaseItem> itemList)
	{
		if (index < itemList.size())
		{
			healthBorder.changeBorder(label, itemList.get(index));
			label.setText((itemList.get(index)).getDetailsSellback(true));
		}
	}

}
