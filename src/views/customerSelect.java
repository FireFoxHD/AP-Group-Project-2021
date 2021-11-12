package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Customer;

public class customerSelect {

	private JFrame frmSelectCustomer;
	private JTextField idTextField;
	private JTable table;
	private Customer cust = new Customer();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerSelect window = new customerSelect();
					window.frmSelectCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public customerSelect() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSelectCustomer = new JFrame();
		frmSelectCustomer.setTitle("Select Customer");
		frmSelectCustomer.setBounds(100, 100, 942, 554);
		frmSelectCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frmSelectCustomer.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Enter customer ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		
		idTextField = new JTextField();
		panel.add(idTextField);
		idTextField.setColumns(10);
		
		JButton displayButton = new JButton("Display");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cust.readAll();
				JOptionPane.showMessageDialog(displayButton, "Displayed results!","Action",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		displayButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(displayButton);
		
		JScrollPane scrollPane = new JScrollPane();
		frmSelectCustomer.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
