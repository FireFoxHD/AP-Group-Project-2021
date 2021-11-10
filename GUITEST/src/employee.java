import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class employee {

	private JFrame frmCustomerLogin;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employee window = new employee();
					window.frmCustomerLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public employee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCustomerLogin = new JFrame();
		frmCustomerLogin.setTitle("Employee Login");
		frmCustomerLogin.setBounds(100, 100, 617, 426);
		frmCustomerLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCustomerLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Staff ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(118, 136, 68, 26);
		frmCustomerLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(118, 172, 114, 34);
		frmCustomerLogin.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setToolTipText("Enter Id here");
		textField.setBounds(219, 130, 197, 36);
		frmCustomerLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Enter password here.");
		textField_1.setBounds(219, 172, 197, 34);
		frmCustomerLogin.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(331, 216, 85, 34);
		frmCustomerLogin.getContentPane().add(btnNewButton);
	}
}
