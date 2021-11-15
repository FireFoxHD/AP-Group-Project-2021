package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import client.Client;
import models.Actions;
import models.Customer;
import models.Item;
import models.Order;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import javax.swing.DefaultComboBoxModel;

public class MakeOrder {

	private JFrame frame;
	private JTextField employeeField;
	private Client client = null;
	private ArrayList<Item> items = null;
	private JTable table, selectedTable;
	private JTextField customerField;
	private Random rand = new Random(System.currentTimeMillis());  
	private String orderId;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakeOrder window = new MakeOrder();
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
	public MakeOrder() {
		client = new Client();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//random 10 digit number
		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		orderId = String.valueOf(number);
		
		client.sendAction(Actions.READ_ALL_ITEMS);
		items = (ArrayList<Item>) client.getResponse();
		
		
		String col[] = {"ID", "Name","Category", "Cost", "Stock"};
		String selectedCol[] = {"ID","Name","Category", "Cost","Amt"};
		DefaultTableModel tableModel_2 = new DefaultTableModel(selectedCol, 0);
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		for(Item i : items){
			if(i.getNumInStock() > 0) {
				String id = i.getId();
				String name = i.getName();
				String category = i.getCategory();
				double cost = i.getCost();
				int numInStock = i.getNumInStock();
				
				Object[] data = {id, name, category, cost, numInStock};
				tableModel.addRow(data);
			}
		}

			  
		
		frame = new JFrame();
		frame.setBounds(100, 100, 740, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton addItemButton = new JButton("Add Item to Order");
		addItemButton.setBounds(140, 517, 134, 29);
		frame.getContentPane().add(addItemButton);
		
		
		JLabel lblNewLabel = new JLabel("Select an Item");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(123, 144, 151, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCompleteOrder = new JButton("Complete Order");
		btnCompleteOrder.setBounds(469, 517, 134, 29);
		frame.getContentPane().add(btnCompleteOrder);
		
		employeeField = new JTextField();
		employeeField.setBounds(484, 150, 110, 20);
		frame.getContentPane().add(employeeField);
		employeeField.setColumns(10);
		
		JLabel label_1 = new JLabel("Date of Return");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(383, 237, 101, 14);
		frame.getContentPane().add(label_1);
		
		JComboBox<Month> monthComboBox_return = new JComboBox<Month>();
		monthComboBox_return.setModel(new DefaultComboBoxModel<Month>(Month.values()));
		monthComboBox_return.setToolTipText("Month");
		monthComboBox_return.setBounds(385, 262, 89, 20);
		frame.getContentPane().add(monthComboBox_return);
		
		JComboBox<String> dayComboBox_return = new JComboBox<String>();
		dayComboBox_return.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayComboBox_return.setToolTipText("Day");
		dayComboBox_return.setBounds(484, 262, 40, 20);
		frame.getContentPane().add(dayComboBox_return);
		
		JComboBox<String> yearComboBox_return = new JComboBox<String>();
		yearComboBox_return.setModel(new DefaultComboBoxModel<String>(new String[] {"2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		yearComboBox_return.setToolTipText("Year");
		yearComboBox_return.setBounds(534, 262, 60, 20);
		frame.getContentPane().add(yearComboBox_return);
		
		JLabel lblDateOfRental = new JLabel("Date of Rental");
		lblDateOfRental.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateOfRental.setBounds(384, 183, 101, 14);
		frame.getContentPane().add(lblDateOfRental);
		
		JComboBox<Month> monthComboBox_rental = new JComboBox<Month>();
		monthComboBox_rental.setModel(new DefaultComboBoxModel<Month>(Month.values()));
		monthComboBox_rental.setToolTipText("Month");
		monthComboBox_rental.setBounds(385, 206, 89, 20);
		frame.getContentPane().add(monthComboBox_rental);
		
		JComboBox<String> dayComboBox_rental = new JComboBox<String>();
		dayComboBox_rental.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayComboBox_rental.setToolTipText("Day");
		dayComboBox_rental.setBounds(484, 206, 40, 20);
		frame.getContentPane().add(dayComboBox_rental);
		
		JComboBox<String> yearComboBox_rental = new JComboBox<String>();
		yearComboBox_rental.setModel(new DefaultComboBoxModel<String>(new String[] {"2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		yearComboBox_rental.setToolTipText("Year");
		yearComboBox_rental.setBounds(534, 206, 60, 20);
		frame.getContentPane().add(yearComboBox_rental);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmployeeId.setBounds(384, 152, 101, 14);
		frame.getContentPane().add(lblEmployeeId);
		
		JLabel OrderLabel = new JLabel("Order ID: " + orderId );
		OrderLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		OrderLabel.setBounds(35, 11, 280, 36);
		frame.getContentPane().add(OrderLabel);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCustomerId.setBounds(35, 62, 158, 34);
		frame.getContentPane().add(lblCustomerId);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(36, 113, 654, 2);
		frame.getContentPane().add(separator);
		
		
		
		table = new JTable(tableModel);
		selectedTable = new JTable(tableModel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 184, 300, 301);
		scrollPane.add(table);
		scrollPane.setViewportView(table);
		frame.getContentPane().add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(371, 293, 300, 192);
		scrollPane_1.add(selectedTable);
		scrollPane_1.setViewportView(selectedTable);
		frame.getContentPane().add(scrollPane_1);
		
		customerField = new JTextField();
		customerField.setBounds(188, 72, 171, 20);
		frame.getContentPane().add(customerField);
		customerField.setColumns(10);
		
		addItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				int column = 0;
				int row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, column).toString();
				client.sendAction(Actions.READ_ITEM);
				client.send(value);
				Item item = (Item) client.getResponse();
				
				Object[] data = {item.getId(), item.getName(), item.getCategory(), item.getCost()};
				tableModel_2.addRow(data);
			}
		});
		
		
		btnCompleteOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				int row = table.getSelectedRow();
				String custId = customerField.getText();
				String empId = employeeField.getText();
				String dateStr = "";
				Date dateOfRental = null;
				Date dateOfReturn = null;
				
				int rows = table.getRowCount();
				for(int i = 0; i < rows; i++) {
					String value = table.getModel().getValueAt(i, 0).toString();
					String quantity = table.getModel().getValueAt(i, 4).toString();
					
					client.sendAction(Actions.READ_ITEM);
					client.send(value);
					Item item = (Item) client.getResponse();
					
					int ordered = Integer.valueOf(quantity);
					if(ordered > item.getNumInStock() && !custId.isEmpty() &&!empId.isEmpty() && dateOfRental != null && dateOfReturn != null) {
						System.out.println("Invalid order");
						return;
					}
					
					custId = customerField.getText();
					empId = employeeField.getText();
					
					
					int month = monthComboBox_rental.getSelectedIndex()+1;
					int day = Integer.valueOf((String) dayComboBox_rental.getSelectedItem());
				    int year = Integer.valueOf((String) yearComboBox_rental.getSelectedItem());
				    dateStr = year+"-"+month+"-"+day;
				    System.out.println("dateOfRental: "+ dateStr);
				    dateOfRental = Date.valueOf(dateStr);
				    
				    month = monthComboBox_return.getSelectedIndex()+1;
				    day = Integer.valueOf((String) dayComboBox_return.getSelectedItem());
				    year = Integer.valueOf((String) yearComboBox_return.getSelectedItem());
				    dateStr = year+"-"+month+"-"+day;
				    System.out.println("dateOfReturn: "+ dateStr);
					dateOfReturn = Date.valueOf(year+"-"+month+"-"+day);
					
					client.sendAction(Actions.CREATE_ORDER);
					client.send(orderId);
					client.send(custId);
					client.send(empId);
					client.send(dateOfRental);
					client.send(dateOfReturn);
					Boolean isCreated = (Boolean) client.getResponse();
					
					client.sendAction(Actions.ADD_ITEM_TO_ORDER);
					client.send(orderId);
					client.send(value);
					client.send(quantity);
					Boolean isAdded = (Boolean) client.getResponse();
					
					client.sendAction(Actions.UPDATE_STOCK);
					client.send(value);
					client.send(quantity);
					client.send(ordered-item.getNumInStock());
					Boolean isUpdated = (Boolean) client.getResponse();
					
					if(isCreated && isAdded && isUpdated) {
						System.out.println("Order Complete");
					}else {
						System.out.println("Order Failed");
					}
					return;
				}
				
			}
		});
		
	}
}
