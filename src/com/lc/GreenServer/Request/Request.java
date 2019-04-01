/**
 * 
 */
package com.lc.GreenServer.Request;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.web.HttpRequest.HttpRequest;
import javax.web.HttpSession.HttpSession;

import com.lc.GreenServer.GreenServerContext.GreenServerContext;

/**   
 * @ClassName:  Request   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 罗城 
 * @date:   2019年3月25日 下午2:51:26      
 */
public class Request implements HttpRequest{
	
	private Map<String, String> ParameterMap;
	
	private final GreenServerContext context;
	
	/**   
	 * @Title:  Request   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:    
	 * @throws   
	 */
	public Request(Map<String, String> ParameterMap,GreenServerContext context) {
		this.ParameterMap=ParameterMap;
		this.context=context;
	}

	/* (non-Javadoc)
	 * @see javax.web.HttpRequest.HttpRequest#getParameter(java.lang.String)
	 */
	@Override
	public String getParameter(String name) {
		
		return this.ParameterMap.get(name);
	}

	/* (non-Javadoc)
	 * @see javax.web.HttpRequest.HttpRequest#getInputStream()
	 */
	@Override
	public InputStream getInputStream() throws IOException {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.web.HttpRequest.HttpRequest#getParameters()
	 */
	@Override
	public Map<String, String> getParameters() {
		
		return this.ParameterMap;
	}

	/* (non-Javadoc)
	 * @see javax.web.HttpRequest.HttpRequest#getRequestURI()
	 */
	@Override
	public String getRequestURI() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.web.HttpRequest.HttpRequest#getHttpSession()
	 */
	@Override
	public HttpSession getHttpSession() {
		
		return context.getHttpSession();
	}

}
