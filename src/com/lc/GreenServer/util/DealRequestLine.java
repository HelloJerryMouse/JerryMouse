/**
 * 
 */
package com.lc.GreenServer.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import com.lc.GreenServer.httphead.HttpHead;

/**   
 * @ClassName:  DealRequestLine   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 罗城 
 * @date:   2019年3月26日 下午5:49:32      
 */
public class DealRequestLine {
	
	//是否请求静态资源
	public static boolean isStatic(String requestLine){
		boolean isStatic=false;
		if (getServletKey(requestLine).contains(".html")){
			isStatic=true;
		}
		return isStatic;
		
	}
	
	//获取POST请求下的参数map集合
	private static Map<String, String> getPostParameter(String paramStr) throws UnsupportedEncodingException{
		Map<String, String> paramMap=null;
		if (paramStr!=null) {
			paramMap=new HashMap<String, String>();
			
		    if (paramStr.contains("&")) {
		    	
				String[] keyAndValue=null;
		
			    String[] params=paramStr.split("&");
			
			    for (int i = 0; i < params.length; i++) {
				    keyAndValue=params[i].split("=");
				    String key =keyAndValue[0];
				    String value=keyAndValue[1];
				    value=URLDecoder.decode(value, "UTF-8");
				    paramMap.put(key, value);
			    }
				
			}else{
				String[] keyAndValue=paramStr.split("=");
			    String key =keyAndValue[0];
			    String value=keyAndValue[1];
			    URLDecoder.decode(value, "UTF-8");
			    paramMap.put(key, value);
				
			}
		}
		
		return paramMap;
		
	}
	
	
	
	
	
	public static  String getServletKey(String requestLine){
		 String key ="";
		 if (requestLine!=null) {
			String URI=requestLine.split(" ")[1];
		    if (requestLine.contains("?")) {
	            URI=URI.substring(0, URI.lastIndexOf("?"));
			
		    }
		    String[] uriStr=URI.split("/");
		    key=uriStr[uriStr.length-1];
		 }
		return key;
	}
	
	//获得静态文件路径
	public static String getStaticPath(String requestLine){
		String staticPath=requestLine.split(" ")[1];
		
		return staticPath;
		
	}
	
	//GET请求下的参数集合
	@SuppressWarnings("deprecation")
	private static  Map<String, String> getGetParameterMap(String requestLine) throws UnsupportedEncodingException{
		Map<String, String> parameterMap=new HashMap<String, String>();
		if (requestLine!=null) {

		   if (requestLine.contains("?")&&requestLine.contains("&")) {
			   
			  String parameterStr=requestLine.split(" ")[1];
			  String parameter=parameterStr.substring(parameterStr.lastIndexOf("?")+1,
					parameterStr.length()-1);
			  String[] params=parameter.split("&");
			  for (int i = 0; i < params.length; i++) {
				  String key=params[i].split("=")[0];
				  String value=null;
				
					value=URLDecoder.decode(params[i].split("=")[1], "UTF-8");
				  
				  parameterMap.put(key, value);
			  }
			
		   }else if(requestLine.contains("?")&&!requestLine.contains("&")){
			   String parameterStr=requestLine.split(" ")[1];
			   
				  String parameter=parameterStr.substring(parameterStr.lastIndexOf("?")+1,
						  parameterStr.length());
				  String[] keyAndValue=parameter.split("=");
				  String key=keyAndValue[0];
				  String value=keyAndValue[1];
				  try {
					  value=URLDecoder.decode(value, "UTF-8");
					  parameterMap.put(key, value);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			   
		   }
		}
		
		return parameterMap;
	}
	
	//根据不同请求类型返回参数集合
	public static  Map<String, String> getParameterMap(HttpHead head){
		Map<String, String> paramMap=null;
		try {
		if ("GET".equals(head.getRequestMethod())) {
			
				paramMap=getGetParameterMap(head.getURI());
			
		}else if ("POST".equals(head.getRequestMethod())) {
			paramMap=getPostParameter(head.getParam());
		}
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		return paramMap;
		
	}

}
