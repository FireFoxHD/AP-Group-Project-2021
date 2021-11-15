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
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;

import client.Client;
import models.Customer;
import models.Actions;

public class CustomerUpdate extends JFrame{

	
	private JTextField idTextField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField textField;
	private JTextField textField_4;
	
	private Client client = new Client();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerUpdate window = new CustomerUpdate();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerUpdate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Update Customer Record");
		this.setBounds(100, 100, 947, 549);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(49, 49, 100, 35);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(49, 95, 100, 35);
		this.getContentPane().add(lblName);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(49, 141, 100, 35);
		this.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(49, 276, 100, 35);
		this.getContentPane().add(lblNewLabel_3);
		
		idTextField = new JTextField();
		idTextField.setToolTipText("Enter customer ID here");
		idTextField.setBounds(148, 49, 187, 35);
		this.getContentPane().add(idTextField);
		idTextField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Enter customer first name here.");
		textField_1.setColumns(10);
		textField_1.setBounds(148, 95, 187, 35);
		this.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Enter customer last name here.");
		textField_2.setColumns(10);
		textField_2.setBounds(148, 141, 187, 35);
		this.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Enter password here.");
		textField_3.setColumns(10);
		textField_3.setBounds(148, 276, 187, 35);
		this.getContentPane().add(textField_3);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String id = idTextField.getText();
				String fname = textField_1.getText();
				String lname = textField_2.getText();
				String pass = textField_3.getText();
				String email = textField_4.getText();
				String num =textField.getText();
				
				client.sendAction(Actions.CREATE_CUSTOMER);
				client.send(id);
				client.send(fname);
				client.send(lname);
				client.send(email);
				client.send(num);
				client.send(pass);
				
				idTextField.setText("");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				
			}
		});
		btnNewButton.setToolTipText("Creates a record.");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(38, 369, 111, 35);
		this.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = idTextField.getText();
				String fname = textField_1.getText();
				String lname = textField_2.getText();
				//String pass = textField_3.getText();
				String email = textField_4.getText();
				String num =textField.getText();
				
				client.sendAction(Actions.UPDATE_CUSTOMER);
				client.send(id);
				client.send(fname);
				client.send(lname);
				client.send(email);
				client.send(num);
				
				idTextField.setText("");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				
			}
		});
		btnUpdate.setToolTipText("Updates a record.");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(182, 369, 111, 35);
		this.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = idTextField.getText();
				client.sendAction(Actions.DELETE_CUSTOMER);
				client.send(id);
				
				/*client.sendAction(Actions.DELETE_PASSWORD);
				client.send(id);*/
				
				idTextField.setText("");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				
				
			}
		});
		btnDelete.setToolTipText("Deletes a record.");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(316, 369, 111, 35);
		this.getContentPane().add(btnDelete);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(128, 128, 128), 2));
		table.setBounds(439, 49, 450, 262);
		this.getContentPane().add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "First Name", "Last Name", "Email", "Phone Number", null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "First Name", "Last Name", "Email", "Phone Number", "Balance"
			}
		));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(49, 187, 100, 35);
		this.getContentPane().add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setBounds(49, 233, 100, 35);
		this.getContentPane().add(lblPhone);
		
		textField = new JTextField();
		textField.setToolTipText("Enter customer phone number here.");
		textField.setColumns(10);
		textField.setBounds(148, 233, 187, 35);
		this.getContentPane().add(textField);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Enter customer email here.");
		textField_4.setColumns(10);
		textField_4.setBounds(148, 187, 187, 35);
		this.getContentPane().add(textField_4);
	}
}
