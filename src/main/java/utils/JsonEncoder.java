package utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.nanotweets.Settings;
import com.nanotweets.message.JsonResponse;

public class JsonEncoder {
	public static void encode(HttpServletResponse servletResponse, JsonResponse r) {
		
		Gson gson = new Gson();
		
		try {
		
			servletResponse.setCharacterEncoding("UTF-8");
			servletResponse.setContentType("application/json");
			
			// convert java object to JSON format,
			// and returned as JSON formatted string
			String json = gson.toJson(r);
		
			// try to encode entities (accented letters) properly
			try {
				json = new String(json.getBytes(), "UTF-8");
				
			} catch (UnsupportedEncodingException e) {
				; // do nothing
			}
			servletResponse.getWriter().write( json );
			
		} catch (IOException e) {
			
			// it has been not possible to encode JSON object
			try {
				servletResponse.getWriter().write( 
						"{'code': " + Settings.RESPONSE_CODE_TECHNICAL_ERROR + ", 'message': " + Settings.RESPONSE_MSG_TECHNICAL_ERROR + " }" );
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			//Alarm.raise(Alarm.CODE_SERVICE_FAILURE, "jsonEncoder", e);
		}

	}
	
	public static String encode (HttpServletResponse servletResponse, Object obj) {
		Gson gson = new Gson();
		
		servletResponse.setContentType("application/json");
		// convert java object to JSON format,
		// and returned as JSON formatted string
		String json = gson.toJson(obj);
		
		try {
			servletResponse.getWriter().write( json );
			
		} catch (IOException e) {
			servletResponse.setStatus( HttpServletResponse.SC_SERVICE_UNAVAILABLE );
			//Alarm.raise(Alarm.CODE_SERVICE_FAILURE, "jsonEncoder", e);
		}
		
		return json;
	}

	
	@SuppressWarnings("unchecked")
	public static Object decode( String json, @SuppressWarnings("rawtypes") Class type ) {
		return ( new Gson() ).fromJson( json, type );
	}
	
	
	
	
}
