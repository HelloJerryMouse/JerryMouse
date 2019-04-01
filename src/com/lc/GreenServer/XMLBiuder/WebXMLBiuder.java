/**
 * 
 */
package com.lc.GreenServer.XMLBiuder;

import java.util.Map;

/**   
 * @ClassName:  WebXMLBiuder   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 罗城 
 * @date:   2019年3月25日 下午2:25:56      
 */
public interface WebXMLBiuder {
	
	public Map<String, String> getServletMap();
	
	public Map<String, String> getServletMappingMap();

}
