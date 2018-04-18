package edu.yccc.java.samples.slack;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

/**
 * Mami Muratake 
 * April 18 2018
 * Project #3: Slack Integration  
 * 
 */

public class SlackUI {

	private JFrame frame;
	JTextField textFieldMessage;
	JTextField textFieldName;
	JTextField textFieldChannel;
	
	// Determines whether the message to be sent is an urgent one or a normal one. Typically it's normal.
	Boolean urgent = false;

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
				SlackMessage sm = new SlackMessage();
				sm.setChannel(textFieldChannel.getText());
				sm.setUserName(textFieldName.getText());
				sm.setMessage(textFieldMessage.getText());
				
				// Make sure that the user included all the components of a message.
				if(sm.getChannel().equals("") || sm.getUserName().equals("") || sm.getMessage().equals(""))
				{
					System.out.println("There is a parameter you have not filled in. Please be sure to include all components before continuing.");
				}
				
				// If they haven't checked the urgent button.
				else if(urgent == false)
				{
					SlackService ss = new SlackService();
					ss.sendMessage(sm.getChannel(), sm.getUserName(), sm.getMessage());
					
					// Clear the text field so the user won't have to, let them know their message was sent.
					textFieldMessage.setText("");
					ss.informUser();
				}
				// If they have checked the urgent button.
				else if(urgent == true)
				{
					UrgentSlackService uss = new UrgentSlackService();
					uss.sendMessage(sm.getChannel(), sm.getUserName(), sm.getMessage());
					
					// Clear the text field so the user won't have to, let them know their message was sent.
					textFieldMessage.setText("");
					uss.informUser();
				}
			}
		});
		btnSendMessage.setBounds(295, 227, 129, 23);
		frame.getContentPane().add(btnSendMessage);
		
		JLabel lblChannel = new JLabel("Input the channel you would like to post to.");
		lblChannel.setBounds(21, 22, 276, 23);
		frame.getContentPane().add(lblChannel);
		
		JLabel lblUserName = new JLabel("Input your user name.");
		lblUserName.setBounds(21, 72, 209, 23);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblMessage = new JLabel("Input the message you would like to send.");
		lblMessage.setBounds(21, 127, 382, 23);
		frame.getContentPane().add(lblMessage);
		
		textFieldMessage = new JTextField();
		textFieldMessage.setBounds(21, 148, 382, 48);
		frame.getContentPane().add(textFieldMessage);
		textFieldMessage.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(278, 73, 99, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldChannel = new JTextField();
		textFieldChannel.setBounds(278, 23, 99, 20);
		frame.getContentPane().add(textFieldChannel);
		textFieldChannel.setColumns(10);
		
		JCheckBox checkUrgent = new JCheckBox("Tag as Urgent");
		checkUrgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(checkUrgent.isSelected())
				{
					urgent = true;
				}
				else if(!checkUrgent.isSelected())
				{
					urgent = false;
				}
			}
		});
		checkUrgent.setBounds(21, 202, 120, 23);
		frame.getContentPane().add(checkUrgent);
	}
}
