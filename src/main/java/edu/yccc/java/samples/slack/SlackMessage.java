package edu.yccc.java.samples.slack;

/**
 * Mami Muratake 
 * April 18 2018
 * Project #3: Slack Integration  
 * 
 */

public class SlackMessage {
	
	// If someone wanted to add a different type of slack message, for example one that also takes a url (in addition to a message), 
	// they can extend Slack Message and add that feature. That url-included slack message will have all the features of a normal 
	// slack message in addition to the new one. This is called inheritance.
	
	String channel;
	String userName;
	String message;
	
	public String getChannel()
	{
		return channel;
	}
	public void setChannel(String channel) 
	{
		this.channel = channel;
	}
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message) 
	{
		this.message = message;
	}
	
	

}
