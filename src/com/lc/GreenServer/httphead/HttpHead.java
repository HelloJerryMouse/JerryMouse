/**
 * 
 */
package com.lc.GreenServer.httphead;

import java.util.Map;

/**   
 * @ClassName:  HttpHead   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 罗城 
 * @date:   2019年3月28日 下午3:38:04      
 */
public class HttpHead {
	
	private String requestMethod;
	
	private String requestIp;
	
	private String param;
	
	private int requestPort;
	
	private String URI;

	/**
	 * @return the requestMethod
	 */
	public String getRequestMethod() {
		return requestMethod;
	}

	/**
	 * @param requestMethod the requestMethod to set
	 */
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}
	
	

	/**
	 * @return the uRI
	 */
	public String getURI() {
		return URI;
	}

	/**
	 * @param uRI the uRI to set
	 */
	public void setURI(String uRI) {
		URI = uRI;
	}

	/**
	 * @return the requestIp
	 */
	public String getRequestIp() {
		return requestIp;
	}

	/**
	 * @param requestIp the requestIp to set
	 */
	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	/**
	 * @return the param
	 */
	public String getParam() {
		return param;
	}

	/**
	 * @param param the param to set
	 */
	public void setParam(String param) {
		this.param = param;
	}

	/**
	 * @return the requestPort
	 */
	public int getRequestPort() {
		return requestPort;
	}

	/**
	 * @param requestPort the requestPort to set
	 */
	public void setRequestPort(int requestPort) {
		this.requestPort = requestPort;
	}

	public HttpHead(String requestMethod, String requestIp, String param,
			int requestPort,String URI) {
		super();
		this.requestMethod = requestMethod;
		this.requestIp = requestIp;
		this.param = param;
		this.requestPort = requestPort;
		this.URI=URI;
	}
	
	
	
	

}
