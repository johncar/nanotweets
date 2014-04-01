package com.nanotweets.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import utils.JsonEncoder;

import com.crocodoc.Crocodoc;
import com.crocodoc.CrocodocException;
import com.nanotweets.Settings;
import com.nanotweets.crocodoc.CrocodocDownload;
import com.nanotweets.crocodoc.CrocodocSession;
import com.nanotweets.message.JsonResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

public class DocumentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7254461811912924374L;
	
	static String apiToken = "SuXIxvypN7JgrqMOAnU0EKec";
	static String[] uploadedDocuments;
	

	static Logger log;	
	static Properties config;
	
	static {
		// Debug file 
		DOMConfigurator.configure( Thread.currentThread().getContextClassLoader().getResource("log4j.xml"));
		log = Logger.getLogger(DocumentServlet.class);
		
		// Crocodoc init
		Crocodoc.setApiToken(apiToken);
		
		uploadedDocuments = new String[]{
				"105d28c5-cc09-47e9-8450-11261a9ff4e2","b3dc1a3a-3927-465e-a607-7f03305e11a5",
				"51d7b808-f0ac-4202-a468-b5b71a684a16","d343542f-2b69-41a2-b5c5-e7a1b9e25c1c",
				"54e9f075-a1f7-4af9-9ad2-4a302748088e","ee556a9d-225a-42fd-bca8-5d869f7d56dc",
				"7b5da70f-cf3f-42a3-9e92-c46a56e4bc1c","d44bfcfb-22bd-4c2c-b411-b1c602737823",
				"e1dcc112-e220-4a77-9384-bcddc1bd1be6","8d415bdd-886b-43f6-9892-46739b3bd9f1",
				"a0659614-2cd9-456b-b707-ab6825e23f2e","346a60fa-8dca-4418-a69d-013d6aca3f30",
				"546bc026-e50a-424c-967c-dbfe498e0882","68031661-fea2-49c0-bf77-3fbad4713a8c",
				"ad243d73-92ad-48e0-91fc-e182fa2bf4d7","3eea244e-c4aa-43ca-a145-3f50acb82f51"};
//				"0ef225cd-e534-4be7-87cd-76676a63b8cc","1e2918cc-7a2c-4afc-b817-c3b6123e01a9",
//				"2cff5669-2396-4341-a28e-0c64124d215f","d8477b6b-8295-4c21-b235-3aaecda55acd",
//				"e6616bce-53ca-451c-aa10-1a175da35cb6","d3a88897-b1a1-4b38-ad61-4081973d4e23",
//				"1c92d9aa-92c6-4e32-8fe3-8621a6b52689","61384e24-6e61-4bd4-8992-f61ad3af7ac2",
//				"401d62e5-721d-4da5-870e-60308f8cccf5","c2ab9445-c161-46ea-bb67-efdef907fa02",
//				"084c1e8d-a3bb-447d-80cb-2a39b7e90457","9691503a-8545-4719-84bb-5aeec445724a",
//				"95f42ba8-78ee-45f3-ab27-427737f2d37f","9a5bd12b-5213-4aee-a1fe-d950531b2790",
//				"d3b289fa-53e1-446b-9b15-8a43b62f4624","bdb14c0a-4e0a-4471-9240-442778f2dfd5"};
//		
		
		//uploadedDocuments = new ArrayList<String>();
		//uploadedDocuments.add("ca294c2d-0586-41f0-8126-2f089f7a14e9");
		//uploadedDocuments.add("3a776d08-9cf3-4746-8cc8-a45873c999e0");
		//uploadedDocuments.add("09a2c7e9-fff6-4731-9581-93750cf8f078");

	}
	
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        
    	String action = req.getParameter("action");

    	if ( Settings.SERVICE_GET_THUMBNAILS.equalsIgnoreCase(action) ) {   		
    		executeGetThumbnails( req, resp );

    	} else if ( Settings.SERVICE_LIST.equalsIgnoreCase(action) ) {   		
    		executeList( req, resp );

    	} else if ( Settings.SERVICE_CREATE_SESSION.equalsIgnoreCase(action) ) {   		
    		executeCreateSession( req, resp );

    	} else {
    		JsonResponse r = new JsonResponse();
    		r.setCode( Settings.RESPONSE_CODE_PARAM_NOT_VALID );
			r.setMessage( "action " + action + " not recognized" );
			JsonEncoder.encode(resp, r);
    	} 
    	
    }


	private void executeCreateSession( HttpServletRequest servletRequest, HttpServletResponse servletResponse ) {
		
		JsonResponse r = new JsonResponse();
		
		String uuid = servletRequest.getParameter( Settings.PARAM_UUID );
		
		if ( StringUtils.isEmpty(uuid) ) { 
			r.setCode( Settings.RESPONSE_CODE_PARAM_NOT_VALID );
			r.setMessage( Settings.PARAM_UUID + " parameter is missing" );
			
		} else { // Create a session for document with uuid provided
			
			String sessionKey = null;
			Map<String,Object> params = new LinkedHashMap<String, Object>();
			
			try {
				
				Map<String, Object> userParams = new HashMap<String, Object>();
		        userParams.put("id", 1);
		        userParams.put("name", "Alex Crocodile");

		        params.put("isEditable", true);
		        params.put("user", userParams);
		        params.put("filter", "all");
		        params.put("isDownloadable", true);
		        params.put("isCopyprotected", false);
		        params.put("isDemo", false);
				
				sessionKey = CrocodocSession.create(uuid, params);
				r.setCode(Settings.RESPONSE_CODE_OK);
			    r.setData(sessionKey);
			    
			} catch (CrocodocException e) {	        	
				r.setCode( Settings.RESPONSE_CODE_QUERY_EXEC_FAILURE );
				r.setMessage( e.getMessage() );
				
			} 
			
		}
		JsonEncoder.encode(servletResponse, r);
	}


	private void executeList(HttpServletRequest servletRequest, HttpServletResponse servletResponse ) {
		JsonResponse r = new JsonResponse();
		
		r.setCode( Settings.RESPONSE_CODE_OK );
		r.setMessage( Settings.RESPONSE_MSG_OK );
		r.setData(uploadedDocuments);
			
		JsonEncoder.encode(servletResponse, r);
	}


	private void executeGetThumbnails(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		JsonResponse r = new JsonResponse();
		
		String uuid = servletRequest.getParameter( Settings.PARAM_UUID );
		
		if ( StringUtils.isEmpty(uuid) ) { // Select  thumbnails of documents already uploaded 
			r.setCode( Settings.RESPONSE_CODE_PARAM_NOT_VALID );
			r.setMessage( Settings.PARAM_UUID + " parameter is missing" );
			
		} else { // Get the document's thumbnail
			
			 try {
		            HttpEntity fileContent = CrocodocDownload.thumbnail(uuid, "300x300");
		            //String filename = "/tmp/" + uuid + ".png";
		            //FileOutputStream stream = null;

		            //stream = new FileOutputStream(filename);
	                fileContent.writeTo( servletResponse.getOutputStream() );

//		            if (stream != null) {
//		                try {
//		                    stream.close();
//		                } catch (IOException e) {}
//		            }
	                
	                servletResponse.setContentType("image/png");
	                
	                return;
		            
		        } catch (CrocodocException e) {	        	
		        	r.setCode( Settings.RESPONSE_CODE_QUERY_EXEC_FAILURE );
		        	r.setMessage( e.getMessage() );
		        	
		        } catch (FileNotFoundException e) {
		        	r.setCode( Settings.RESPONSE_CODE_IO_ERROR );
		        	r.setMessage( "Thumbnail for " + uuid + ". " + e.getMessage() );
		        	
				} catch (IOException e) {
					r.setCode( Settings.RESPONSE_CODE_IO_ERROR );
		        	r.setMessage( "Thumbnail for " + uuid + ". " + e.getMessage() );
				}
			
		}
		
		JsonEncoder.encode(servletResponse, r);
		
	}




    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		doGet(req,resp);
    }
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		String mydata = "Bla blablablabkabl�alkj <z:go ids=\"GO:0043037\" onto=\"biological_process\">translation</z:go> piospodjlksjdlka sadkjh asd <z:chebi ids=\"GO:0043037\" onto=\"biological_process\">translation</z:chebi>";
		Pattern pattern = Pattern.compile("<z:(.*?)</z:(.*?)>");
		Matcher matcher = pattern.matcher(mydata);
		while (matcher.find())
		{
		    System.out.println(matcher.group());
		}

		
	}

}
