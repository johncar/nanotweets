package com.nanotweets.thread;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import org.apache.log4j.Logger;

public class FacebookWriter implements Runnable {

    Logger log = Logger.getLogger(FacebookWriter.class);

	String text;
	String uuid;
    String userComment;

	public FacebookWriter(String selectedText, String documentUUID, String userComment) {
		this.text = selectedText;
		this.uuid = documentUUID;
        this.userComment = userComment;
	}
	
	@Override
	public void run() {
		
		try {
			
			log.debug("Posting on facebook: " + userComment );

            Facebook facebook = new FacebookFactory().getInstance();

            // more staff to do ..

            facebook.postStatusMessage( userComment );
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
