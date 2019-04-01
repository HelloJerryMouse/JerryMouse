/**
 * 
 */
package com.lc.GreenServer.GreenServerContext;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.web.HttpSession.HttpSession;

import com.lc.GreenServer.Contianer.Contianer;
import com.lc.GreenServer.DefaultContianerFactory.DefaultContianerFactory;
import com.lc.GreenServer.DefaultXMLBiuder.DefaultServerXMLBiuder;
import com.lc.GreenServer.XMLBiuder.ServerXMLBiuder;
import com.lc.GreenServer.session.Session;

/**   
 * @ClassName:  GreenServerContext   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 罗城 
 * @date:   2019年3月25日 下午2:37:54      
 */
public class GreenServerContext {
	
	private Socket socket;
	
	private InetAddress address;
	
	private ServerSocket serverSocket;
	
	private ServerXMLBiuder serverXMLBiuder;
	
	private Contianer contianer;
	
	private HttpSession httpSession;
	
	public GreenServerContext() {
		
		serverXMLBiuder=new DefaultServerXMLBiuder();
		
		httpSession=new Session();
		
		contianer=new DefaultContianerFactory().createContianer();
	}
	
	public int getServerPort(){
		
		return this.serverXMLBiuder.getServerPort();
	}
	

	/**
	 * @return the socket
	 */
	public Socket getSocket() {
		return socket;
	}

	/**
	 * @param socket the socket to set
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	/**
	 * @return the serverSocket
	 * @throws IOException 
	 */
	public ServerSocket createServerSocket() throws IOException {
		serverSocket=new ServerSocket(getServerPort(), 50, InetAddress.getByName("127.0.0.1"));
	    this.serverSocket=serverSocket;
	    
		return this.serverSocket;
	}
	
	public Contianer getContianer(){
		
		return this.contianer;
	}
	
	public HttpSession getHttpSession(){
		
		return this.httpSession;
	}

	
	

}
