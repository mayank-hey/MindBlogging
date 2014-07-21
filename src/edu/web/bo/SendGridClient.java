package edu.web.bo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.github.sendgrid.SendGrid;

import edu.web.util.FileUtility;

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
	
	public static void sendInvitation(){
		String API_CALL = "to=mayank.hey%40gmail.com&toname=Mayank&from=mindblogging.bymail.in&fromname=Mind%20Blogging&subject=You%20are%20awesome!%20and%20someone%20needs%20your%20Help%20&html=Hi%20Mayank!%20%3Cbr%3E%20You%20have%20done%20a%20great%20job%20and%20your%20uplifting%20spirit%20is%20commendable.%20There%20are%20our%20other%20users%20like%20rsabnis%20who%20need%20your%20help.%20Why%20not%20try%20helping%20them%20out%20with%20something%20you%20have%20gone%20through.%20Let%27s%20change%20some%20lives.%20%3Cbr%3E%20Best%2C%20%3Cbr%3E%20MindBlogging%20Team%20%3Cbr%3E&api_user=mindblogging&api_key=ncsu2313";
		
		    URL url;
		    HttpURLConnection connection = null;
		    try {
		      // create connection
		      url = new URL("http://sendgrid.com/api/mail.send.json");
		      connection = (HttpURLConnection) url.openConnection();
		      connection.setRequestMethod("POST");
		      connection.setRequestProperty("Content-Type",
		      				"application/x-www-form-urlencoded");
		      //connection.setRequestProperty("X-Mashape-Authorization",
			//	YOUR_MASHAPE_KEY);
		      connection.setUseCaches (false);
		      connection.setDoInput(true);
		      connection.setDoOutput(true);

		      // send request
		      DataOutputStream wr = new DataOutputStream (
		                  connection.getOutputStream ());
		      wr.writeBytes(API_CALL);
		      wr.flush();
		      wr.close();

		      // get Response
		      InputStream is = connection.getInputStream();
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		      String line;
		      StringBuffer response = new StringBuffer();
		      while((line = rd.readLine()) != null) {
		        response.append(line);
		        response.append('\r');
		      }
		      rd.close();
		     // return response.toString();

		    } catch (Exception e) {

		      e.printStackTrace();
		     // return null;

		    } finally {

		      if(connection != null) {
		        connection.disconnect();
		      }
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
	
	public static void send_email(){
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
