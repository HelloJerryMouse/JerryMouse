/**
 * 
 */
package com.lc.GreenServer.session;

import java.util.HashMap;
import java.util.Map;

import javax.web.HttpSession.HttpSession;

/**   
 * @ClassName:  Session   
 * @Description:TODO(������һ�仰��������������)   
 * @author: �޳� 
 * @date:   2019��3��28�� ����1:23:21      
 */
public class Session implements HttpSession{
	
	private Map<String, Object> SessionMap;
	
	
	/**   
	 * @Title:  Session   
	 * @Description:    TODO(������һ�仰�����������������)   
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
