package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JTextPane;

public class customerDelete {

	private JFrame frmDeleteCustomer;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerDelete window = new customerDelete();
					window.frmDeleteCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public customerDelete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDeleteCustomer = new JFrame();
		frmDeleteCustomer.setTitle("Delete Customer");
		frmDeleteCustomer.setBounds(100, 100, 911, 552);
		frmDeleteCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDeleteCustomer.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("Enter last name");
		textField.setBounds(280, 178, 186, 34);
		frmDeleteCustomer.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton searchButn = new JButton("Search");
		searchButn.setFont(new Font("Tahoma", Font.BOLD, 16));
		searchButn.setBounds(466, 178, 120, 34);
		frmDeleteCustomer.getContentPane().add(searchButn);
		
		JTextPane textPane = new JTextPane();
		textPane.setToolTipText("Record will be shown here");
		textPane.setBounds(280, 222, 306, 56);
		frmDeleteCustomer.getContentPane().add(textPane);
		
		JButton deleteButton = new JButton("Delete Record");
		deleteButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		deleteButton.setToolTipText("Delete the displayed record");
		deleteButton.setBounds(439, 315, 147, 34);
		frmDeleteCustomer.getContentPane().add(deleteButton);
	}
}
