package views;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import client.Client;
import models.Actions;

import javax.swing.JButton;

public class CustomerLogin extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField txtIdHere;
	private JTextField textField_1;
	private Client client;
	private Client client = new Client();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerLogin window = new CustomerLogin(new Client());
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CustomerLogin(Client client) {
		this.client = client;
		initialize();
	}

	private void initialize() {
		
		this.setTitle("Customer Login");
		this.setBounds(100, 100, 617, 426);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(72, 136, 114, 26);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(72, 169, 114, 34);
		this.getContentPane().add(lblNewLabel_1);
		
		txtIdHere = new JTextField();
		txtIdHere.setToolTipText("Enter ID here");
		txtIdHere.setBounds(219, 130, 197, 36);
		this.getContentPane().add(txtIdHere);
		txtIdHere.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setToolTipText("Enter Password here.");
		textField_1.setBounds(219, 172, 197, 34);
		this.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel invalidLabel = new JLabel();
		invalidLabel.setHorizontalAlignment(SwingConstants.CENTER);
		invalidLabel.setBounds(219, 273, 197, 34);
		this.getContentPane().add(invalidLabel);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				String id = txtIdHere.getText();
				String password = textField_1.getText();  
				
				if(!(id.isEmpty() || password.isEmpty())) { //switch to isblank
					client.sendAction(Actions.LOGIN);
					List<String> params = new ArrayList<String>();
					params.add(id);
					params.add(password);
					client.sendMultiple(params);
					Boolean isValid = (Boolean) client.getResponse();
					
					if(isValid) {
						System.out.println("Password Valid");
						JOptionPane.showMessageDialog(null, "Login Sucessful", "Action", JOptionPane.INFORMATION_MESSAGE);
					}else{
						invalidLabel.setText("Invalid Credentials");
					}
					
				}

				txtIdHere.setText("");
				textField_1.setText("");
			}	
		});
		btnNewButton.setBounds(331, 216, 85, 34);
		this.getContentPane().add(btnNewButton);
		
		
		}
}
