/**
 * 
 */
package com.lc.GreenServer.contianerFactory;

import java.util.Map;

import com.lc.GreenServer.Contianer.Contianer;

/**   
 * @ClassName:  ContianerFactory   
 * @Description:TODO(������һ�仰��������������)   
 * @author: �޳� 
 * @date:   2019��3��25�� ����2:35:57      
 */
public interface ContianerFactory {
	
	public Contianer createContianer();
	
    public Map<String, Map<String, String>> getServletMap(Map<String, String> servletMap,
    		Map<String, String> ServletMapping);

	
	

}
