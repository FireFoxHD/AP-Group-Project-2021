package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import models.Actions;
import models.Customer;
import models.Order;
import models.Status;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import client.Client;

public class UpdateOrder {

	private JFrame frmUpdateOrder;
	private JTextField OrderIdtextField;
	private JTextField employeeTextField;
	private Client client = null;
	private ArrayList<Order> orders = null;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateOrder window = new UpdateOrder();
					window.frmUpdateOrder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//TODO Look into JLayeredPane https://www.javatpoint.com/java-jlayeredpane
	public UpdateOrder() {
		client = new Client();
		initialize();
	}

	
	
	private void initialize() {
		
		client.sendAction(Actions.READ_ALL_ORDERS);
		orders = (ArrayList<Order>) client.getResponse();
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		for(Order i : orders) {
			client.sendAction(Actions.READ_CUSTOMER);
			client.send(i.getCustomerId());
			Customer customer = (Customer)client.getResponse();
			model.addElement("["+i.getId()+"] - "+customer.getFirstname() +" "+ customer.getLastname());
		}
	
		frmUpdateOrder = new JFrame();
		frmUpdateOrder.setTitle("Update Order");
		frmUpdateOrder.setBounds(100, 100, 639, 396);
		frmUpdateOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUpdateOrder.getContentPane().setLayout(null);
		
		JLabel orderIdLabel = new JLabel("Order ID");
		orderIdLabel.setForeground(SystemColor.textInactiveText);
		orderIdLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		orderIdLabel.setBounds(116, 11, 89, 24);
		frmUpdateOrder.getContentPane().add(orderIdLabel);
		
		OrderIdtextField = new JTextField();
		OrderIdtextField.setBounds(23, 44, 199, 24);
		frmUpdateOrder.getContentPane().add(OrderIdtextField);
		OrderIdtextField.setColumns(10);
		
		JList<String> list = new JList<String>();
		list.setBounds(23, 81, 297, 210);
		list.setModel(model);
		frmUpdateOrder.getContentPane().add(list);
		
		
		JPanel updatePanel = new JPanel();
		updatePanel.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 2));
		updatePanel.setBounds(344, 11, 269, 335);
		frmUpdateOrder.getContentPane().add(updatePanel);
		updatePanel.setLayout(null);
		updatePanel.setVisible(false);
		
		JLabel customerIDLabel_label = new JLabel("Customer ID");
		customerIDLabel_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		customerIDLabel_label.setBounds(94, 11, 80, 14);
		updatePanel.add(customerIDLabel_label);
		
		JLabel employeeIDLabel = new JLabel("Employee ID");
		employeeIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		employeeIDLabel.setBounds(24, 75, 80, 14);
		updatePanel.add(employeeIDLabel);
		
		employeeTextField = new JTextField();
		employeeTextField.setColumns(10);
		employeeTextField.setBounds(24, 100, 130, 20);
		updatePanel.add(employeeTextField);
		
		JLabel dateOfReturnLabel = new JLabel("Date of Return");
		dateOfReturnLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateOfReturnLabel.setBounds(24, 131, 101, 14);
		updatePanel.add(dateOfReturnLabel);
		
		JComboBox<Status> statusComboBox = new JComboBox<Status>();
		statusComboBox.setModel(new DefaultComboBoxModel<Status>(Status.values()));
		statusComboBox.setBounds(24, 212, 121, 20);
		updatePanel.add(statusComboBox);
		
		JLabel statusLabel = new JLabel("Status");
		statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		statusLabel.setBounds(24, 187, 46, 14);
		updatePanel.add(statusLabel);
		
		JComboBox<String> dayComboBox = new JComboBox<>();
		dayComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "21"}));
		dayComboBox.setToolTipText("Day");
		dayComboBox.setBounds(123, 156, 40, 20);
		updatePanel.add(dayComboBox);
		
		JComboBox<String> yearComboBox = new JComboBox<String>();
		yearComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		yearComboBox.setToolTipText("Year");
		yearComboBox.setBounds(173, 156, 60, 20);
		updatePanel.add(yearComboBox);
		
		JComboBox<Month> monthComboBox = new JComboBox<Month>();
		monthComboBox.setModel(new DefaultComboBoxModel<Month>(Month.values()));
		monthComboBox.setToolTipText("Month");
		monthComboBox.setBounds(24, 156, 89, 20);
		updatePanel.add(monthComboBox);
		
		JButton updateOrderButton = new JButton("Update");
		updateOrderButton.setBounds(32, 301, 89, 23);
		updatePanel.add(updateOrderButton);
		
		JLabel customerIdLabel = new JLabel("");
		customerIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		customerIdLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		customerIdLabel.setBounds(69, 28, 130, 28);
		updatePanel.add(customerIdLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 62, 220, 2);
		updatePanel.add(separator);
		
		JButton deleteOrderButton = new JButton("Delete");
		deleteOrderButton.setBounds(155, 301, 89, 23);
		updatePanel.add(deleteOrderButton);
		
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(231, 43, 89, 26);
		frmUpdateOrder.getContentPane().add(searchButton);
		
		JButton btnNewButton = new JButton("View Items Ordered");
		btnNewButton.setBounds(23, 311, 297, 23);
		frmUpdateOrder.getContentPane().add(btnNewButton);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				if(!OrderIdtextField.getText().isEmpty()) {
					Order order = null;
					client.sendAction(Actions.READ_ORDER);
					client.send(OrderIdtextField.getText());
					order = (Order) client.getResponse();;
					if(order != null) {
						updatePanel.setVisible(true);
						customerIdLabel.setText(order.getCustomerId());
						employeeTextField.setText(order.getEmployeeId());
						statusComboBox.setSelectedItem(order.getStatus());
						LocalDate date = order.getDateOfReturn().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
						monthComboBox.setSelectedIndex(date.getMonthValue()-1);
						dayComboBox.setSelectedItem(date.getDayOfMonth());
						yearComboBox.setSelectedItem(date.getDayOfYear());
					}
				}
			}
		});
		
		
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(list.getSelectedValue() != null) {
					String id = list.getSelectedValue().substring(1, 5);
					client.sendAction(Actions.READ_ORDER);
					client.send(id);
					Order order = (Order) client.getResponse();;
					updatePanel.setVisible(true);
					updatePanel.setVisible(true);
					customerIdLabel.setText(order.getCustomerId());
					employeeTextField.setText(order.getEmployeeId());
					statusComboBox.setSelectedItem(order.getStatus());
					
					
					String[] date = order.getDateOfReturn().toString().split("-");
					yearComboBox.setSelectedItem(date[0]);
					monthComboBox.setSelectedIndex(Integer.valueOf(date[1])-1);
					dayComboBox.setSelectedItem(date[2]);
					
				}
			}

		});
		
		updateOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
//					client.sendAction(Actions.UPDATE_ORDER);
//					client.send();
//					client.send(employeeTextField.getText());
//					client.send(statusComboBox.getSelectedItem());
//					int month = monthComboBox.setSelectedIndex(date.getMonthValue()-1);
//					int day = dayComboBox.setSelectedItem(date.getDayOfMonth());
//					int year = yearComboBox.setSelectedItem(date.getDayOfYear());
//					Date dateOfReturn = Date.valueOf(year+"-"+day+"-"+month);
//					client.send(dateOfReturn);

					Boolean isDeleted = (Boolean) client.getResponse();
					
					if(isDeleted) {
						System.out.println("Order deleted");
					}
					
			}
		});
		
		
	}
}
