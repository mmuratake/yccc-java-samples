package edu.yccc.java.samples.slack;

public abstract class SlackGeneralMessage implements SlackMessage {
		
	public String getChannel() 
	{
		return "#general";
	}

}
