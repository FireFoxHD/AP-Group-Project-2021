package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;

public class customerUpdate {

	private JFrame frmUpdateCustomerRecord;
	private JTextField idTextField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerUpdate window = new customerUpdate();
					window.frmUpdateCustomerRecord.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public customerUpdate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdateCustomerRecord = new JFrame();
		frmUpdateCustomerRecord.setTitle("Update Customer Record");
		frmUpdateCustomerRecord.setBounds(100, 100, 947, 549);
		frmUpdateCustomerRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUpdateCustomerRecord.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(82, 103, 100, 35);
		frmUpdateCustomerRecord.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(82, 156, 100, 35);
		frmUpdateCustomerRecord.getContentPane().add(lblName);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(82, 215, 100, 35);
		frmUpdateCustomerRecord.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(82, 269, 100, 35);
		frmUpdateCustomerRecord.getContentPane().add(lblNewLabel_3);
		
		idTextField = new JTextField();
		idTextField.setToolTipText("Enter customer ID here");
		idTextField.setBounds(192, 103, 136, 35);
		frmUpdateCustomerRecord.getContentPane().add(idTextField);
		idTextField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Enter customer first name here.");
		textField_1.setColumns(10);
		textField_1.setBounds(192, 156, 136, 35);
		frmUpdateCustomerRecord.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Enter customer last name here.");
		textField_2.setColumns(10);
		textField_2.setBounds(192, 215, 136, 35);
		frmUpdateCustomerRecord.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Enter password here.");
		textField_3.setColumns(10);
		textField_3.setBounds(192, 271, 136, 35);
		frmUpdateCustomerRecord.getContentPane().add(textField_3);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setToolTipText("Creates a record.");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(38, 369, 111, 35);
		frmUpdateCustomerRecord.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setToolTipText("Updates a record.");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(179, 369, 111, 35);
		frmUpdateCustomerRecord.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setToolTipText("Deletes a record.");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(316, 369, 111, 35);
		frmUpdateCustomerRecord.getContentPane().add(btnDelete);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(821, 103, 17, 201);
		frmUpdateCustomerRecord.getContentPane().add(scrollBar);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setFont(new Font("Tahoma", Font.BOLD, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Customer Id", "First Name", "Last Name", "Balance"
			}
		));
		table.setBounds(821, 307, -394, -203);
		frmUpdateCustomerRecord.getContentPane().add(table);
		
		JButton btnViewAll = new JButton("View All");
		btnViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewAll.setToolTipText("Displays all records.");
		btnViewAll.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewAll.setBounds(727, 369, 111, 35);
		frmUpdateCustomerRecord.getContentPane().add(btnViewAll);
	}
}
