/**
 * 
 */
package com.lc.GreenServer.DefaultContianer;

import java.util.Map;

import com.lc.GreenServer.Contianer.Contianer;

/**   
 * @ClassName:  DefaultContianer   
 * @Description:TODO(������һ�仰��������������)   
 * @author: �޳� 
 * @date:   2019��3��25�� ����2:33:58      
 */
public class DefaultContianer implements Contianer{
	
	private final Map<String,Object> ServletContianer;
	
	public DefaultContianer(Map<String,Object> ServletContianer) {
		this.ServletContianer=ServletContianer;
	}

	/* (non-Javadoc)
	 * @see com.lc.GreenServer.Contianer.Contianer#remove(java.lang.String)
	 */
	@Override
	public void remove(String key) {
		
		this.ServletContianer.remove(key);

	}

	/* (non-Javadoc)
	 * @see com.lc.GreenServer.Contianer.Contianer#getServlet()
	 */
	@Override
	public Object getServlet(String key) {
		
		return this.ServletContianer.get(key);
	}

}
