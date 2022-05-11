package com.seng.monster;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* Prompts the user to choose their name, length of the game and difficulty
*
* @author  Cameron Wu
* @version 1.0
*/
public class NameChoiceWindow {

	private JFrame frame;
	private JTextField nameField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 * @param args, n/a
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NameChoiceWindow window = new NameChoiceWindow();
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
	public NameChoiceWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
				ColumnSpec.decode("max(18dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(64dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(162dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(0dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(25dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(23dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(27dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(27dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(24dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel welcomeLabel = new JLabel("Welcome to Monster Fighter!");
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(welcomeLabel, "1, 4, 20, 1");
		
		JLabel nameLabel = new JLabel("Name:");
		frame.getContentPane().add(nameLabel, "14, 10");
		
		nameField = new JTextField();
		nameField.setColumns(10);
		frame.getContentPane().add(nameField, "18, 10, fill, default");
		
		JLabel daysLabel = new JLabel("Game Length (days):");
		frame.getContentPane().add(daysLabel, "14, 14");
		
		JSlider daysSlider = new JSlider();
		daysSlider.setMajorTickSpacing(1);
		daysSlider.setValue(10);
		daysSlider.setMinorTickSpacing(1);
		daysSlider.setSnapToTicks(true);
		daysSlider.setMinimum(5);
		daysSlider.setMaximum(15);
		daysSlider.setPaintTicks(true);
		daysSlider.setPaintLabels(true);
		
		frame.getContentPane().add(daysSlider, "18, 14");
		
		JLabel difficultyLabel = new JLabel("Difficulty:");
		frame.getContentPane().add(difficultyLabel, "14, 18");
		
		JRadioButton easyButton = new JRadioButton("Easy (You move first)");
		buttonGroup.add(easyButton);
		frame.getContentPane().add(easyButton, "18, 18");
		
		JRadioButton mediumButton = new JRadioButton("Medium (Random move order)");
		buttonGroup.add(mediumButton);
		frame.getContentPane().add(mediumButton, "18, 20");
		
		JRadioButton hardButton = new JRadioButton("Hard (Opponent moves first)");
		buttonGroup.add(hardButton);
		frame.getContentPane().add(hardButton, "18, 22");
		
		JButton nextButton = new JButton("Next Page");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				int nameLength = name.length();
				int days = daysSlider.getValue();
				if (!name.matches("^[a-zA-Z]*$") || nameLength < 3 || nameLength > 15)
				{
					JOptionPane.showMessageDialog(frame, "Invalid name input, please only have letters & between 3 - 15 characters long");
					return;
				}
				int difficulty;
				if (easyButton.isSelected())
				{
					difficulty = 0;
				}
				else if (mediumButton.isSelected())
				{
					difficulty = 1;
				}
				else if (hardButton.isSelected())
				{
					difficulty = 2;
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Please enter a difficulty");
					return;
				}
				Player p = new Player(difficulty, days);
				p.setName(name);
				new MonsterChoiceWindow(p);
				frame.dispose();
				
			}
		});
		frame.getContentPane().add(nextButton, "18, 26");
	}

}
