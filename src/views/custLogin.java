package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class custLogin extends JFrame {

	private JPanel contentPane;
	private JTextField idTextField;
	private JTextField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					custLogin frame = new custLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public custLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(143, 110, 114, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(143, 143, 114, 34);
		contentPane.add(lblNewLabel_1);
		
		idTextField = new JTextField();
		idTextField.setToolTipText("Enter ID here");
		idTextField.setColumns(10);
		idTextField.setBounds(290, 104, 197, 36);
		contentPane.add(idTextField);
		
		passwordTextField = new JTextField();
		passwordTextField.setToolTipText("Enter Password here.");
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(290, 146, 197, 34);
		contentPane.add(passwordTextField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton, "Login sucessful", "Action", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setBounds(402, 190, 85, 34);
		contentPane.add(btnNewButton);
		
		JLabel welcomeLabel = new JLabel("Welcome");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		welcomeLabel.setBounds(209, 11, 232, 55);
		contentPane.add(welcomeLabel);
	}

}
