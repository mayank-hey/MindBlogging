package edu.web.bo;

import java.util.ArrayList;

import com.github.sendgrid.SendGrid;

public class SendGridClient {
	
	
	
	public static void sendSponsorshipInvitaion(ArrayList<User> users, User needy){
		for(User user : users){
			SendGrid sendgrid = new SendGrid("mindblogging", "ncsu2313");
			sendgrid.addTo(user.getEmail());
			sendgrid.addToName(user.getUserName());
			sendgrid.setFrom("mindblogging.bymail.in");
			sendgrid.setFromName("Mind Blogging");
			sendgrid.setSubject("You are awesome! and " + needy.getUserName() + " needs you!");
			sendgrid.setHtml("Hi " + user.getUserName() + " ! <br> You have done a great job and your uplifting spirit is commendable" +
					". There are our other users like \"" + needy.getUserName() + "\" who need your help. Why not try helping them " +
							"out with something you have gone through. Let's change some lives. <br>Best, <br> MindBlogging Team <br>");
			sendgrid.send();
		}
	}
	
	public static void main(String args[]){
		ArrayList<User> users = new ArrayList<User>();
		User gaurav = new User();
		gaurav.setEmail("gauravhalbe@gmail.com");
		gaurav.setUserName("Gaurav");
		User mayank = new User();
		mayank.setEmail("mayank.hey@gmail.com");
		mayank.setUserName("Mayank");
		User rohan = new User();
		rohan.setEmail("rohansabnis@gmail.com");
		rohan.setUserName("Rohan");
		users.add(gaurav);
		users.add(rohan);
		
		sendSponsorshipInvitaion(users,mayank);
	}
}
