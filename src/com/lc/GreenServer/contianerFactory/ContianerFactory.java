/**
 * 
 */
package com.lc.GreenServer.contianerFactory;

import java.util.Map;

import com.lc.GreenServer.Contianer.Contianer;

/**   
 * @ClassName:  ContianerFactory   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 罗城 
 * @date:   2019年3月25日 下午2:35:57      
 */
public interface ContianerFactory {
	
	public Contianer createContianer();
	
    public Map<String, Map<String, String>> getServletMap(Map<String, String> servletMap,
    		Map<String, String> ServletMapping);

	
	

}
