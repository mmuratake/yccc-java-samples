package edu.yccc.java.samples.slack;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

/**
 * Mami Muratake 
 * April 18 2018
 * Project #3: Slack Integration  
 * 
 */

public class SlackUI {

	private JFrame frame;
	private JTextField textFieldMessage;
	private JTextField textFieldName;
	private JTextField textFieldChannel;
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
				channel = textFieldChannel.getText();
				userName = textFieldName.getText();
				message = textFieldMessage.getText();
				if(textFieldChannel.getText().isEmpty() || textFieldName.getText().isEmpty() || textFieldMessage.getText().isEmpty())
				{
					System.out.println("There is a parameter you have not filled in. Please be sure to include all components before continuing.");
				}
				else
				{
					ss.sendMessage(channel, userName, message);
					textFieldMessage.setText("");
					System.out.println("Your message was successfully sent!");
				}
			}
		});
		btnSendMessage.setBounds(295, 227, 129, 23);
		frame.getContentPane().add(btnSendMessage);
		
		JLabel lblChannel = new JLabel("Input the channel you would like to post to.");
		lblChannel.setBounds(21, 11, 276, 23);
		frame.getContentPane().add(lblChannel);
		
		JLabel lblUserName = new JLabel("Input your user name.");
		lblUserName.setBounds(21, 72, 209, 23);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblMessage = new JLabel("Input the message you would like to send.");
		lblMessage.setBounds(21, 134, 382, 23);
		frame.getContentPane().add(lblMessage);
		
		textFieldMessage = new JTextField();
		textFieldMessage.setBounds(21, 156, 382, 48);
		frame.getContentPane().add(textFieldMessage);
		textFieldMessage.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(200, 73, 122, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldChannel = new JTextField();
		textFieldChannel.setBounds(274, 12, 129, 20);
		frame.getContentPane().add(textFieldChannel);
		textFieldChannel.setColumns(10);
	}
}
