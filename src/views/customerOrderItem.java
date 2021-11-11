package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class customerOrderItem {

	private JFrame frmCustomerOrderItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerOrderItem window = new customerOrderItem();
					window.frmCustomerOrderItem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public customerOrderItem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCustomerOrderItem = new JFrame();
		frmCustomerOrderItem.setTitle("Customer Order Item");
		frmCustomerOrderItem.setBounds(100, 100, 912, 561);
		frmCustomerOrderItem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCustomerOrderItem.getContentPane().setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Speaker", "Bounce-About", "Lights", "Trampoline", "Popcorn Machine"}));
		comboBox.setBounds(295, 79, 311, 32);
		frmCustomerOrderItem.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//add submit code
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(403, 380, 122, 51);
		frmCustomerOrderItem.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Select an Item");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(157, 70, 128, 51);
		frmCustomerOrderItem.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(343, 163, 240, 46);
		frmCustomerOrderItem.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Item 2");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(343, 235, 240, 46);
		frmCustomerOrderItem.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Item 3");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(343, 297, 240, 46);
		frmCustomerOrderItem.getContentPane().add(lblNewLabel_1_2);
	}
}
