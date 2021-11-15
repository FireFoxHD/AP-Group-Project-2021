package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import client.Client;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen {

	private JFrame frame;
	private Client client = new Client();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
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
	public MainScreen() {
		client = new Client();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIntro = new JLabel("Grizzly Entertainment");
		lblIntro.setFont(new Font("Magneto", Font.BOLD | Font.ITALIC, 50));
		lblIntro.setBounds(25, 11, 629, 63);
		frame.getContentPane().add(lblIntro);
		
		JButton btnNewButton = new JButton("Employee Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				EmployeeLogin eml = new EmployeeLogin(client);
				eml.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(233, 85, 197, 52);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCustomerLogin = new JButton("Customer Login");
		btnCustomerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CustomerLogin cl = new CustomerLogin(client);
				cl.setVisible(true);
			}
		});
		btnCustomerLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCustomerLogin.setBounds(233, 148, 197, 52);
		frame.getContentPane().add(btnCustomerLogin);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdminLogin.setBounds(233, 211, 197, 52);
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				EmployeeLogin eml = new EmployeeLogin(client);
				eml.setVisible(true);
			}
		});
		frame.getContentPane().add(btnAdminLogin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(272, 274, 124, 52);
		frame.getContentPane().add(btnExit);
	}
}
