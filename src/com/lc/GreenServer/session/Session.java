/**
 * 
 */
package com.lc.GreenServer.session;

import java.util.HashMap;
import java.util.Map;

import javax.web.HttpSession.HttpSession;

/**   
 * @ClassName:  Session   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 罗城 
 * @date:   2019年3月28日 下午1:23:21      
 */
public class Session implements HttpSession{
	
	private Map<String, Object> SessionMap;
	
	
	/**   
	 * @Title:  Session   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:    
	 * @throws   
	 */
	public Session() {
		this.SessionMap=new HashMap<String, Object>();
	}

	/* (non-Javadoc)
	 * @see javax.web.HttpSession.HttpSession#setAttribue(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setAttribue(String name, Object value) {
		
		synchronized (this) {
			this.SessionMap.put(name, value);	
		}
		
	}

	/* (non-Javadoc)
	 * @see javax.web.HttpSession.HttpSession#getOAttribute(java.lang.String)
	 */
	@Override
	public Object getAttribute(String name) {
		
		return this.SessionMap.get(name);
	}

	/* (non-Javadoc)
	 * @see javax.web.HttpSession.HttpSession#RemoveAttribute(java.lang.String)
	 */
	@Override
	public void RemoveAttribute(String name) {
		synchronized (this) {
			this.SessionMap.remove(name);
			
		}
		
	}

	/* (non-Javadoc)
	 * @see javax.web.HttpSession.HttpSession#setExpired(int)
	 */
	@Override
	public void setExpired(int second) {
		
		
	}

}
