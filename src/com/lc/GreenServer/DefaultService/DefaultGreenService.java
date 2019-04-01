/**
 * 
 */
package com.lc.GreenServer.DefaultService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.lc.GreenServer.GreenServerContext.GreenServerContext;
import com.lc.GreenServer.Service.GreenService;
import com.lc.GreenServer.Thread.MoreThread;

/**   
 * @ClassName:  DefaultGreenService   
 * @Description:TODO(GreenService�������ķ�����)   
 * @author: �޳� 
 * @date:   2019��3��25�� ����2:22:36 
 * @since 1.0
 * @version 1.0     
 */
public class DefaultGreenService implements GreenService{
	
	private final GreenServerContext context=new GreenServerContext();
	
	private ServerSocket serverSocket;
	
	private Socket clienSock=null;
	
	/**   
	 * @Title:  DefaultGreenService   
	 * @Description:    TODO(������һ�仰�����������������)   
	 * @param:    
	 * @throws   
	 */
	public DefaultGreenService() {
		
		try {
			this.serverSocket=this.context.createServerSocket();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	/* (non-Javadoc)
	 * @see com.lc.GreenServer.Service.GreenService#start(com.lc.GreenServer.GreenServerContext.GreenServerContext)
	 */
	@Override
	public void start(){
	    try {
			
			while(true){
				clienSock=serverSocket.accept();
				Service(clienSock);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	/* (non-Javadoc)
	 * @see com.lc.GreenServer.Service.GreenService#Service()
	 */
	@Override
	public void Service(Socket socket) {
		
		Thread thread=new Thread(new MoreThread(socket,context));
		thread.start();
	}
	
	

}
