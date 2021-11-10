import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class addItemScreen {

	private JFrame frmAddItemScreen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addItemScreen window = new addItemScreen();
					window.frmAddItemScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addItemScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddItemScreen = new JFrame();
		frmAddItemScreen.setTitle("Add Item Screen");
		frmAddItemScreen.setBounds(100, 100, 918, 569);
		frmAddItemScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddItemScreen.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Lighting", "Sounds", "Recreation"}));
		comboBox.setBounds(405, 89, 202, 38);
		frmAddItemScreen.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_1.setBounds(405, 224, 40, 38);
		frmAddItemScreen.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Select Quantity");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(274, 224, 127, 38);
		frmAddItemScreen.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item Category");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(274, 89, 127, 38);
		frmAddItemScreen.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Item Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(274, 155, 127, 38);
		frmAddItemScreen.getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(405, 157, 202, 38);
		frmAddItemScreen.getContentPane().add(comboBox_2);
		
		JButton btnNewButton = new JButton("Add Item");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(405, 371, 127, 54);
		frmAddItemScreen.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Availability");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(274, 290, 127, 38);
		frmAddItemScreen.getContentPane().add(lblNewLabel_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(405, 290, 202, 38);
		frmAddItemScreen.getContentPane().add(textArea);
	}

}
