package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;
import models.Customer;

public class customerAdd {

	private JFrame frmAddCustomer;
	private JTextField fnameTextField;
	private JTextField lnameTextField;
	private JTextField passwordTextField;
	private Customer cust = new Customer();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerAdd window = new customerAdd();
					window.frmAddCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public customerAdd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddCustomer = new JFrame();
		frmAddCustomer.setTitle("Add Customer");
		frmAddCustomer.setBounds(100, 100, 851, 531);
		frmAddCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddCustomer.getContentPane().setLayout(null);
		
		fnameTextField = new JTextField();
		fnameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		fnameTextField.setToolTipText("Eg. John");
		fnameTextField.setBounds(336, 60, 222, 35);
		frmAddCustomer.getContentPane().add(fnameTextField);
		fnameTextField.setColumns(10);
		
		lnameTextField = new JTextField();
		lnameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		lnameTextField.setToolTipText("Eg. Brown");
		lnameTextField.setColumns(10);
		lnameTextField.setBounds(336, 131, 222, 35);
		frmAddCustomer.getContentPane().add(lnameTextField);
		
		passwordTextField = new JTextField();
		passwordTextField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordTextField.setToolTipText("Enter a strong password.");
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(336, 193, 222, 35);
		frmAddCustomer.getContentPane().add(passwordTextField);
		
		JLabel lblNewLabel = new JLabel("Enter first name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(189, 60, 134, 32);
		frmAddCustomer.getContentPane().add(lblNewLabel);
		
		JLabel lblEnterLastName = new JLabel("Enter last name");
		lblEnterLastName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEnterLastName.setBounds(189, 131, 134, 32);
		frmAddCustomer.getContentPane().add(lblEnterLastName);
		
		JLabel lblEnterAPassword = new JLabel("Enter a password");
		lblEnterAPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEnterAPassword.setBounds(189, 196, 147, 32);
		frmAddCustomer.getContentPane().add(lblEnterAPassword);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cust.setFirstname(fnameTextField.getText());
					cust.setLastname(lnameTextField.getText());
					cust.setPassword(passwordTextField.getText());
					cust.create();
				}catch (InputMismatchException ex) {
					ex.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(btnNewButton, "Added Successfully","Action",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setToolTipText("Click to create an account.");
		btnNewButton.setBounds(454, 257, 104, 42);
		frmAddCustomer.getContentPane().add(btnNewButton);
	}
}
