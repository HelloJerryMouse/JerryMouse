/**
 * 
 */
package com.lc.GreenServer.Contianer;

/**   
 * @ClassName:  Contianer   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 罗城 
 * @date:   2019年3月25日 下午2:33:00      
 */
public interface Contianer{
	
	public void remove(String key);
	
	public Object getServlet(String key);

}
