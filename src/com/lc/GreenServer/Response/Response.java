/**
 * 
 */
package com.lc.GreenServer.Response;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.web.HttpResponse.HttpResponse;

import com.lc.GreenServer.GreenServerContext.GreenServerContext;

/**   
 * @ClassName:  Response   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 罗城 
 * @date:   2019年3月25日 下午2:52:47      
 */
public class Response implements HttpResponse{
	
	private final GreenServerContext context;
	private Socket socket;
	
	private String header="HTTP/1.1 200 OK\n Content-type:text/html;charset=utf-8\n\n";
	
	/**   
	 * @Title:  Response   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:    
	 * @throws   
	 */
	public Response(Socket socket,GreenServerContext context) {
		this.socket=socket;
		this.context=context;
		
	}

	/* (non-Javadoc)
	 * @see javax.web.HttpResponse.HttpResponse#getPrintWriet()
	 */
	@Override
	public PrintWriter getPrintWriet() throws IOException {
		OutputStreamWriter outr=new OutputStreamWriter(this.socket.getOutputStream());
		PrintWriter printWriter=new PrintWriter(outr);
		printWriter.print(this.header);
		
		return printWriter;
		
	}

	/* (non-Javadoc)
	 * @see javax.web.HttpResponse.HttpResponse#getOutputStream()
	 */
	@Override
	public OutputStream getOutputStream() throws IOException {
		
		return this.socket.getOutputStream();
	}
	

	/* (non-Javadoc)
	 * @see javax.web.HttpResponse.HttpResponse#setHeader(java.lang.String, java.lang.String)
	 */
	@Override
	public void setHeader(String name, String value) {
		this.header=name+","+value;
		
	}

}
