/**
 * 
 */
package com.lc.GreenServer.DefaultContianerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.lc.GreenServer.Contianer.Contianer;
import com.lc.GreenServer.DefaultContianer.DefaultContianer;
import com.lc.GreenServer.DefaultXMLBiuder.DefaultwebXMLBiuder;
import com.lc.GreenServer.XMLBiuder.WebXMLBiuder;
import com.lc.GreenServer.contianerFactory.ContianerFactory;

/**   
 * @ClassName:  DefaultContianerFactory   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 罗城 
 * @date:   2019年3月25日 下午2:37:01      
 */
public class DefaultContianerFactory implements ContianerFactory{
	private WebXMLBiuder webXMLBiuder;
	
	
	public DefaultContianerFactory() {
		this.webXMLBiuder=new DefaultwebXMLBiuder();
		
	}
	
	

	/* (non-Javadoc)
	 * @see com.lc.GreenServer.contianerFactory.ContianerFactory#createContianer()
	 */
	@Override
	public Contianer createContianer() {
		
		Map<String, String> servletMap=webXMLBiuder.getServletMap();
		
		try {
			return new DefaultContianer(this.getServletObject(servletMap));
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	private Map<String, Object> getServletObject(Map<String, String> servletMap) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
Set<Entry<String, String>> set=servletMap.entrySet();
		
		Iterator<Entry<String, String>> iterator=set.iterator();
		Map<String, Object> ServletObjects=null;
		while (iterator.hasNext()) {
			Entry<String,String> entry = (Entry<String,String>) iterator
					.next();
			String servlerName=entry.getKey();
			String servletclass=entry.getValue();
			
		    ServletObjects=new HashMap<String, Object>();
		    ServletObjects.put(servlerName, Class.forName(servletclass).newInstance());
				
		}
		return ServletObjects;
		
	}



	/* (non-Javadoc)
	 * @see com.lc.GreenServer.contianerFactory.ContianerFactory#getServletMap(java.util.Map, java.util.Map)
	 */
	@Override
	public Map<String, Map<String, String>> getServletMap(Map<String, String> servletMap,
			Map<String, String> ServletMapping) {
		
		Set<Entry<String, String>> set=servletMap.entrySet();
		
		Iterator<Entry<String, String>> iterator=set.iterator();
		
		Map<String, Map<String, String>> servletMaps=new HashMap<String, Map<String,String>>();
		
		while (iterator.hasNext()) {
			Entry<String,String> entry = (Entry<String,String>) iterator
					.next();
			String servlerName=entry.getKey();
			String servletclass=entry.getValue();
			String urlPattern=ServletMapping.get(servlerName);
			if (urlPattern!=null) {
				Map<String, String> urlAndClassMap=new HashMap<String, String>();
				urlAndClassMap.put(urlPattern, servletclass);
				servletMaps.put(servlerName,urlAndClassMap);
				
			}
		}
		return servletMaps;
		}
		
	}
