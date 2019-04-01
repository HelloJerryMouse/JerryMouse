/**
 * 
 */
package com.lc.GreenServer.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import com.lc.GreenServer.httphead.HttpHead;

/**   
 * @ClassName:  SocketUitl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 罗城 
 * @date:   2019年3月25日 下午3:26:41      
 */
public class SocketUitl {
	
	//根据不同的请求类型，返回Httphead对象
	public static HttpHead getRequestContent(Socket socket){
		
		InputStream in=null;
		InputStreamReader re=null;
		BufferedReader bre=null;
		String requestContent=null;
		HttpHead httpHead=null;
		try {
			in=socket.getInputStream();
			re=new InputStreamReader(in,"utf-8");
			bre=new BufferedReader(re); 
			char[] buffer=new char[1024];
			bre.read(buffer);
			requestContent=new String(buffer);
			String reqLine=requestContent.split("\n")[0];
			if (reqLine.contains("GET")) {
				httpHead=getGETRequstLine(requestContent, socket);
			}else if (reqLine.contains("POST")){
				httpHead=getPOSTRequestContent(requestContent, socket);
			}else{
				socket.close();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return httpHead;
		
		
	}
	
	//获得GET请求的HttpHead对象
	private static HttpHead getGETRequstLine(String reqContent,Socket socket){
		HttpHead head=null;
		if (reqContent.contains("httpHead.getURI()")) {
			try {
				socket.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}else{
			String requestLine=reqContent.split("\n")[0];
			head=new HttpHead(requestLine.split(" ")[0], socket.getInetAddress().getHostAddress(),
					null, socket.getPort(), requestLine);
		}
			
		return head;
		
	}
	
	//获得POST请求的HttpHead对象
	private static HttpHead getPOSTRequestContent(String reqContent,Socket socket){
			String param=reqContent.split("\n")[reqContent.split("\n").length-1].split(new String(new char[1]))[0];
			String ip=socket.getInetAddress().getHostAddress();
			int port=socket.getPort();
			String requestMethod=reqContent.split("\n")[0].split(" ")[0];
			String URI=reqContent.split("\n")[0];
			HttpHead head=new HttpHead(requestMethod, ip, param, port,URI);

		return head;
		
	}
	

}
