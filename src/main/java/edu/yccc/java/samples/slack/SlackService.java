package edu.yccc.java.samples.slack;

import org.springframework.stereotype.Component;

import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;

/**
 * First pass integration with slack. 
 * 
 */

@Component
public class SlackService 
{
	// #integration webhook url.  Create your own channel and add the webhook app.  Then update this with your value.
	private String webHookUrl = "https://hooks.slack.com/services/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";
	private SlackApi api = new SlackApi(webHookUrl);
	
	public void sendMessage(String channel, String userName, String message) 
	{
		api.call(new SlackMessage(channel, userName, message));
	}

}
