package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.time.Month;
import javax.swing.JSeparator;

public class MakeOrder {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakeOrder window = new MakeOrder();
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
	public MakeOrder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 740, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add Item to Order");
		btnNewButton.setBounds(105, 514, 134, 29);
		frame.getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBounds(36, 184, 300, 301);
		frame.getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("Select an Item");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(123, 144, 151, 29);
		frame.getContentPane().add(lblNewLabel);
		
		table_1 = new JTable();
		table_1.setBounds(384, 293, 300, 192);
		frame.getContentPane().add(table_1);
		
		JButton btnCompleteOrder = new JButton("Complete Order");
		btnCompleteOrder.setBounds(469, 517, 134, 29);
		frame.getContentPane().add(btnCompleteOrder);
		
		textField = new JTextField();
		textField.setBounds(484, 150, 110, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("Date of Return");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(383, 237, 101, 14);
		frame.getContentPane().add(label_1);
		
		JComboBox<Month> comboBox_3 = new JComboBox<Month>();
		comboBox_3.setToolTipText("Month");
		comboBox_3.setBounds(385, 262, 89, 20);
		frame.getContentPane().add(comboBox_3);
		
		JComboBox<String> comboBox_4 = new JComboBox<String>();
		comboBox_4.setToolTipText("Day");
		comboBox_4.setBounds(484, 262, 40, 20);
		frame.getContentPane().add(comboBox_4);
		
		JComboBox<String> comboBox_5 = new JComboBox<String>();
		comboBox_5.setToolTipText("Year");
		comboBox_5.setBounds(534, 262, 60, 20);
		frame.getContentPane().add(comboBox_5);
		
		JLabel lblDateOfRental = new JLabel("Date of Rental");
		lblDateOfRental.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateOfRental.setBounds(384, 183, 101, 14);
		frame.getContentPane().add(lblDateOfRental);
		
		JComboBox<Month> comboBox = new JComboBox<Month>();
		comboBox.setToolTipText("Month");
		comboBox.setBounds(385, 206, 89, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setToolTipText("Day");
		comboBox_1.setBounds(484, 206, 40, 20);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setToolTipText("Year");
		comboBox_2.setBounds(534, 206, 60, 20);
		frame.getContentPane().add(comboBox_2);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmployeeId.setBounds(384, 152, 101, 14);
		frame.getContentPane().add(lblEmployeeId);
		
		JLabel lblNewLabel_1 = new JLabel("Order ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(70, 15, 111, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCustomerId.setBounds(35, 62, 158, 34);
		frame.getContentPane().add(lblCustomerId);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(36, 113, 654, 2);
		frame.getContentPane().add(separator);
	}
}
