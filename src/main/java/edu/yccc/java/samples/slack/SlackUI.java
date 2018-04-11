package edu.yccc.java.samples.slack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SlackUI {

	private JFrame frame;
	private JTextField textField;

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
		
		JLabel lblChannel = new JLabel("Please choose which channel you want to post to.");
		lblChannel.setBounds(21, 11, 382, 23);
		frame.getContentPane().add(lblChannel);
		
		JLabel lblUserName = new JLabel("Please input your name.");
		lblUserName.setBounds(21, 72, 193, 23);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblMessage = new JLabel("Please input the message you would like to send.");
		lblMessage.setBounds(21, 134, 382, 23);
		frame.getContentPane().add(lblMessage);
		
		textField = new JTextField();
		textField.setBounds(21, 156, 382, 48);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
