package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class EmpLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpLogin frame = new EmpLogin();
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
	public EmpLogin() {
		setTitle("Employee Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcomeLabel = new JLabel("Welcome");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		welcomeLabel.setBounds(190, 11, 232, 55);
		contentPane.add(welcomeLabel);
		
		JLabel idLabel = new JLabel("Staff ID");
		idLabel.setForeground(SystemColor.textInactiveText);
		idLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		idLabel.setBounds(134, 114, 68, 26);
		contentPane.add(idLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(SystemColor.textInactiveText);
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordLabel.setBounds(134, 150, 114, 34);
		contentPane.add(passwordLabel);
		
		textField = new JTextField();
		textField.setToolTipText("Enter ID");
		textField.setColumns(10);
		textField.setBounds(235, 108, 197, 36);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter password");
		passwordField.setColumns(10);
		passwordField.setBounds(235, 150, 197, 34);
		contentPane.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(235, 196, 197, 34);
		contentPane.add(loginButton);
	}

}
