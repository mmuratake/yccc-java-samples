package edu.yccc.java.samples.slack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class SlackUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	String channel;
	String userName;
	String message;

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
				SlackService ss = new SlackService();
				channel = textField_2.getText();
				userName = textField_1.getText();
				message = textField.getText();
				if(textField_2.equals(null) || textField_1.equals(null) || textField.equals(null))
				{
					System.out.println("There is a parameter you have not filled in. Please be sure to include all components before continuing.");
				}
				else
				{
					ss.sendMessage(channel, userName, message);
				}
			}
		});
		btnSendMessage.setBounds(295, 227, 129, 23);
		frame.getContentPane().add(btnSendMessage);
		
		JLabel lblChannel = new JLabel("Please choose which channel you want to post to.");
		lblChannel.setBounds(21, 11, 276, 23);
		frame.getContentPane().add(lblChannel);
		
		JLabel lblUserName = new JLabel("Please input your user name.");
		lblUserName.setBounds(21, 72, 209, 23);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblMessage = new JLabel("Please input the message you would like to send.");
		lblMessage.setBounds(21, 134, 382, 23);
		frame.getContentPane().add(lblMessage);
		
		textField = new JTextField();
		textField.setBounds(21, 156, 382, 48);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 73, 122, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(274, 12, 129, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
	}
}
