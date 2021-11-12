package views;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class customerUpdate {

	private JFrame frmUpdateCustomerRecord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerUpdate window = new customerUpdate();
					window.frmUpdateCustomerRecord.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public customerUpdate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdateCustomerRecord = new JFrame();
		frmUpdateCustomerRecord.setTitle("Update Customer Record");
		frmUpdateCustomerRecord.setBounds(100, 100, 947, 549);
		frmUpdateCustomerRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
