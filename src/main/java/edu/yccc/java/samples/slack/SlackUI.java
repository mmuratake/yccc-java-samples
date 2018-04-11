package edu.yccc.java.samples.slack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SlackUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SlackUI window = new SlackUI();
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
	public SlackUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSendMessage = new JButton("Send Message");
		btnSendMessage.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
			}
		});
		btnSendMessage.setBounds(323, 227, 101, 23);
		frame.getContentPane().add(btnSendMessage);
		
		JButton btnSendRandomMessage = new JButton("Send Random Message");
		btnSendRandomMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				// TestSlackService tss = new TestSlackService();
				// tss.testSendMessage();
			}
		});
		btnSendRandomMessage.setBounds(10, 227, 158, 23);
		frame.getContentPane().add(btnSendRandomMessage);
	}

}
