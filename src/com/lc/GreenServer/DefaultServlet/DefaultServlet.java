/**
 * 
 */
package com.lc.GreenServer.DefaultServlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.web.HttpRequest.HttpRequest;
import javax.web.HttpResponse.HttpResponse;
import javax.web.Servlet.Servlet;

import com.lc.test.entry.Student;

/**   
 * @ClassName:  DefaultServlet   
 * @Description:TODO(GreenServer默认的Servlet，用于静态资源请求的处理)   
 * @author: 罗城 
 * @date:   2019年3月27日 下午12:20:42
 * @since 1.0
 * @version 1.0      
 */
public class DefaultServlet implements Servlet{
	
	//请求的静态资源的位置
	private String URI;
	
	/**DefaultServlet的构造器
	 * @param:   URI 请求的静态资源的位置    
	 */
	public DefaultServlet(String URI) {
		this.URI=URI;
		
	}

	/* (non-Javadoc)
	 * @see javax.web.Servlet.Servlet#Service(javax.web.HttpRequest.HttpRequest, javax.web.HttpResponse.HttpResponse)
	 *
	 */
	@Override
	public void Service(HttpRequest request, HttpResponse response) {
		sendStaticFile(request,response);		
	}
	
	//检测文件是否存在，如果不存在则调用发送not-found页面，如果有则发送该静态资源
	private void sendStaticFile(HttpRequest request, HttpResponse response){
		PrintWriter printWriter=null;
		File file=new File("webApp"+this.URI);
		try {
			printWriter=response.getPrintWriet();
			if (file.exists()) {
			
				sendFile(printWriter,"webApp"+this.URI);
			}
			else{
				sendFile(printWriter,"ErrorPage/error.html");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//发送静态文件
	private void sendFile(PrintWriter printWriter,String path){
			FileInputStream fileInputStream=null;
			BufferedReader br=null;
			InputStreamReader ire=null;
			String line;
			try {
				fileInputStream=new FileInputStream(
						new File(path));
				 ire=new InputStreamReader(fileInputStream);
				br=new BufferedReader(ire);
				line = br.readLine();
				StringBuilder builder=new StringBuilder();
				while (line!=null) {
					builder.append(line);
					line=br.readLine();
				}
				
				printWriter.print(builder.toString());
				printWriter.flush();
			} catch (IOException e) {
				
				e.printStackTrace();
			}finally{
				printWriter.close();
					try {
						if (br!=null) {
						br.close();
						}
						if (ire!=null) {
							ire.close();
						}
						if (fileInputStream!=null) {
							fileInputStream.close();
						}
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				
			}
			
			
			
	}
	

}
