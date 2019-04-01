/**
 * 
 */
package com.lc.GreenServer.DefaultXMLBiuder;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.lc.GreenServer.XMLBiuder.WebXMLBiuder;

/**   
 * @ClassName:  webXMLBiuder   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 罗城 
 * @date:   2019年3月25日 下午2:30:55      
 */
public class DefaultwebXMLBiuder implements WebXMLBiuder{
	private Document document;
	
	/**   
	 * @Title:  DefaultwebXMLBiuder   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)      
	 * @throws   
	 */
	public DefaultwebXMLBiuder() {
		SAXReader saxReader=new SAXReader();
		
		
			try {
				document=saxReader.read(new File("webApp/test/WEB-INF/web.xml"));
			} catch (DocumentException e) {
				
				e.printStackTrace();
			}
			
	}

	/**
	 * @author 握笔白纸
	 * @deprecated(解析所有的Servlet节点得到map集合)
	 * @since 1.0
	 * @version 1.0
	 */
	@Override
	public Map<String, String> getServletMap() {
		//Servlet的Map集合
		Map<String, String> ServletMap=new HashMap<String, String>();
		//获得所有的servlet节点
		List<Element> Servleteles=(List<Element>)document.selectNodes("/web/servlet");
		for (Element element : Servleteles) {
			//获得每个servlet节点下的servlet-name节点
			Element servletNameElent=(Element)element.selectSingleNode("servlet-name");
			//获得servlet节点下的servlet-class节点
			Element servletClassElent=(Element)element.selectSingleNode("servlet-class");
			//servlet-name的文本值作为key，servlet-class的文本值作为value，放进Map
			ServletMap.put(servletNameElent.getText(), servletClassElent.getText());
		}
		return ServletMap;
	}

	/**
	 * @author 握笔白纸
	 * @deprecated(解析所有的Servlet-mapping节点得到map集合)
	 * @since 1.0
	 * @version 1.0
	 */
	@Override
	public Map<String, String> getServletMappingMap() {
		//Servlet的Map集合
	    Map<String, String> ServletMappingMap=new HashMap<String, String>();
		//获得所有的servlet节点
		List<Element> Servleteles=(List<Element>)document.selectNodes("/web/servlet-mapping");
		for (Element element : Servleteles) {
			//获得每个servlet节点下的servlet-name节点
			Element servletNameElent=(Element)element.selectSingleNode("servlet-name");
			//获得servlet节点下的servlet-class节点
			Element urlPatternElent=(Element)element.selectSingleNode("url-pattern");
			//servlet-name的文本值作为key，servlet-class的文本值作为value，放进Map
			ServletMappingMap.put(servletNameElent.getText(), urlPatternElent.getText());
		}
		
		return ServletMappingMap;
	}

}
