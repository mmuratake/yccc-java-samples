package edu.yccc.java.samples.slack;

import org.springframework.stereotype.Component;

import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;

/**
 * Mami Muratake 
 * April 18 2018
 * Project #3: Slack Integration  
 * 
 */

@Component
public class UrgentSlackService implements SlackServiceInterface{
	
	// This will send messages that are tagged as urgent. Messages tagged as urgent will have an "URGENT" message in front.
	
	private String webHookUrl = "https://hooks.slack.com/services/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";
	private SlackApi api = new SlackApi(webHookUrl);

	public void sendMessage(String channel, String userName, String message) 
	{
		api.call(new SlackMessage(channel, userName, "URGENT: " + message));
	}

}
