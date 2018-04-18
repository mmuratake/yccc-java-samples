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

// What is Maven?
/**
 * Maven is a tool that allows users to be able to build and comprehend Java projects easily. Projects with Maven are built using the project object 
 * model (the POM) and a set of plug-ins that are used by all projects in Maven. Since all projects made with Maven follow the same build conventions,  
 * once you learn how one project builds you can understand all other projects as well. In addition, because Maven hides unnecessary details, 
 * the build process is made easier. It also makes working with dependencies very easy, since it automatically installs all the dependencies 
 * that a project needs (and installs any updates). 
 */

// What is a JAR file?
/**
 * JAR stands for Java Archive, and is a file format that is mostly used to aggregate numerous files that make up an application.
 * It is also good for compressing those files, which makes it much easier to move the file over environments or networks (due to 
 * decreased downloading time). It typically contains .class files, as well as image or audio files and directories. All of these 
 * are collected into one .jar file. It is based off of the .zip file format, and can easily be decompressed to extract the contents.
 */

@Component
public class SlackService implements SlackServiceInterface
{
	
	// This Slack Service sends normal messages.

	private String webHookUrl = "https://hooks.slack.com/services/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";
	private SlackApi api = new SlackApi(webHookUrl);
	
	public void sendMessage(String channel, String userName, String message) 
	{
		api.call(new SlackMessage(channel, userName, message));
	}

	public void informUser() 
	{
		System.out.println("Your message was successfully sent!");
	}

}
