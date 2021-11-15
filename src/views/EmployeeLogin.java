package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import client.Client;
import models.Actions;
import models.Customer;

import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class EmployeeLogin {

	private JTextField idField;
	private JPasswordField passwordField;
	private Client client = null;
	private static final Logger logger = LogManager.getLogger(EmployeeLogin.class);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeLogin window = new EmployeeLogin();
					//window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
		});
	}

	public EmployeeLogin(Client client) {
		this.client = client;
		initialize();
	}
	
	public EmployeeLogin() {
		//this.client = new Client();
		initialize();
	}
	
	private void initialize() {
		
		JFrame frame = new JFrame();
		
		frame.setTitle("Employee Login");
		frame.setBounds(100, 100, 617, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel welcomeLabel = new JLabel("Welcome");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		welcomeLabel.setBounds(184, 26, 232, 55);
		frame.getContentPane().add(welcomeLabel);
		
		JLabel idLabel = new JLabel("Staff ID");
		idLabel.setForeground(SystemColor.textInactiveText);
		idLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		idLabel.setBounds(118, 136, 68, 26);
		frame.getContentPane().add(idLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(SystemColor.textInactiveText);
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordLabel.setBounds(118, 172, 114, 34);
		frame.getContentPane().add(passwordLabel);
		
		idField = new JTextField();
		idField.setToolTipText("Enter ID");
		idField.setBounds(219, 130, 197, 36);
		frame.getContentPane().add(idField);
		idField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter password");
		passwordField.setBounds(219, 172, 197, 34);
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		JLabel invalidLabel = new JLabel();
		invalidLabel.setHorizontalAlignment(SwingConstants.CENTER);
		invalidLabel.setBounds(219, 273, 197, 34);
		frame.getContentPane().add(invalidLabel);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = idField.getText();
				String password = new String(passwordField.getPassword());  
				
				if(!(id.isEmpty() || password.isEmpty())) { //switch to isblank
					client.sendAction(Actions.LOGIN);
					List<String> params = new ArrayList<String>();
					params.add(id);
					params.add(password);
					client.sendMultiple(params);
					Boolean isValid = (Boolean) client.getResponse();
					
					if(isValid) {
						JOptionPane.showMessageDialog(null, "Login Sucessful", "Action", JOptionPane.INFORMATION_MESSAGE);
						logger.info("Employee "+id+" has logged in");
						frame.dispose();
						CustomerUpdate cu = new CustomerUpdate(client);
					}else{
						invalidLabel.setText("Invalid Credentials");
					}
					
				}

				idField.setText("");
				passwordField.setText("");
			}
		});
		loginButton.setBounds(219, 218, 197, 34);
		frame.getContentPane().add(loginButton);
		frame.setVisible(true);
		
		
		
		
	}
}
