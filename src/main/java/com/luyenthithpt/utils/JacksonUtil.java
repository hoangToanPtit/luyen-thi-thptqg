package com.luyenthithpt.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {
	private String jsonString;
	
	public JacksonUtil(String jsonString) {
		this.jsonString = jsonString;
	}
	
	//convert to ModelClass DTO
	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(jsonString, tClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	public Map<String, String> jsonToMap(){
//		Map<String,String> map = new HashMap<String, String>();
//		ObjectMapper objectMapper = new ObjectMapper();
//		try {
//			map = objectMapper.readValue(jsonString, HashMap.class);
//			return null;
//		} catch (JsonParseException e) {
//			e.printStackTrace(); return null;
//		} catch (JsonMappingException e) {
//			e.printStackTrace(); return null;
//		} catch (IOException e) {
//			e.printStackTrace(); return null;
//		}
//	}
	
	public static JacksonUtil of (BufferedReader reader) {
		StringBuilder sb = new StringBuilder();
		try {
			String line;
		    while ((line = reader.readLine()) != null) {
		        sb.append(line);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new JacksonUtil(sb.toString());
	}
	
	public String getJsonString() {
		return jsonString;
	}
}
