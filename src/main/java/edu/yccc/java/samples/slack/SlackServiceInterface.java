package edu.yccc.java.samples.slack;

/**
 * Mami Muratake 
 * April 18 2018
 * Project #3: Slack Integration  
 * 
 */

public interface SlackServiceInterface {
	
	// Slack Service Interface allows for different ways for a message to be sent. In the future, if someone wants to send messages 
	// in a slightly different way, the interface will allow for that.
	
	
	// All Slack Services need to have the ability to send messages.
	public void sendMessage(String channel, String userName, String message);
	
	// They should also let the user know the message was sent.
	public void informUser();

}
