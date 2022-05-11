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

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* Window for showing the user inventory and giving them the option to use item
*
* @author  Cameron Wu
* @version 1.0
*/
public class InventoryViewWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @param args, n/a
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryViewWindow window = new InventoryViewWindow(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param p, the player
	 */
	public InventoryViewWindow(Player p) {
		initialize(p);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param the player
	 */
	private void initialize(Player p) {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
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
				ColumnSpec.decode("max(50dlu;default)"),},
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
		
		JLabel inventoryLabel = new JLabel("Inventory");
		inventoryLabel.setHorizontalAlignment(SwingConstants.LEFT);
		inventoryLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.getContentPane().add(inventoryLabel, "10, 6, 19, 1");
		
		if (p.getItems().size() <= 0)
		{
			inventoryLabel.setText("You have no items!");
		}
		JLabel itemLabel1 = new JLabel("");
		frame.getContentPane().add(itemLabel1, "10, 12");
		
		JButton useButton1 = new JButton("Use");
		useButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UseItemWindow(p, p.getItems().get(0));
				frame.dispose();
			}
		});
		frame.getContentPane().add(useButton1, "14, 12");
		
		JLabel itemLabel2 = new JLabel("");
		frame.getContentPane().add(itemLabel2, "10, 16");
		
		JButton useButton2 = new JButton("Use");
		useButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UseItemWindow(p, p.getItems().get(1));
				frame.dispose();
			}
		});
		frame.getContentPane().add(useButton2, "14, 16");
		
		JLabel itemLabel3 = new JLabel("");
		frame.getContentPane().add(itemLabel3, "10, 20");
		
		JButton useButton3 = new JButton("Use");
		useButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UseItemWindow(p, p.getItems().get(2));
				frame.dispose();
			}
		});
		frame.getContentPane().add(useButton3, "14, 20");
		
		JLabel itemLabel4 = new JLabel("");
		frame.getContentPane().add(itemLabel4, "10, 24");
		
		JButton useButton4 = new JButton("Use");
		useButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UseItemWindow(p, p.getItems().get(3));
				frame.dispose();
			}
		});
		frame.getContentPane().add(useButton4, "14, 24");
		
		List<JLabel> labels = List.of(itemLabel1, itemLabel2, itemLabel3, itemLabel4);
		List<JButton> buttons = List.of(useButton1, useButton2, useButton3, useButton4);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuWindow(p);
				frame.dispose();
			}
		});
		frame.getContentPane().add(exitButton, "10, 28");
		setNames(p.getItems(), labels, buttons);
	}

	/**
	 * Checks visibility and updates text for the labels and buttons
	 * @param items
	 * @param the labels 
	 * @param the buttons
	 */
	private void setNames(ArrayList<Item> items, List<JLabel> labels, List<JButton> buttons)
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
				healthBorder.changeBorder(labels.get(i), items.get(i));
				labels.get(i).setText(items.get(i).getDetails(true));
			}
		}
	}
}
