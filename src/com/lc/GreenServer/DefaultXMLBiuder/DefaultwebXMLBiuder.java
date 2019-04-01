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
 * @Description:TODO(������һ�仰��������������)   
 * @author: �޳� 
 * @date:   2019��3��25�� ����2:30:55      
 */
public class DefaultwebXMLBiuder implements WebXMLBiuder{
	private Document document;
	
	/**   
	 * @Title:  DefaultwebXMLBiuder   
	 * @Description:    TODO(������һ�仰�����������������)      
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
	 * @author �ձʰ�ֽ
	 * @deprecated(�������е�Servlet�ڵ�õ�map����)
	 * @since 1.0
	 * @version 1.0
	 */
	@Override
	public Map<String, String> getServletMap() {
		//Servlet��Map����
		Map<String, String> ServletMap=new HashMap<String, String>();
		//������е�servlet�ڵ�
		List<Element> Servleteles=(List<Element>)document.selectNodes("/web/servlet");
		for (Element element : Servleteles) {
			//���ÿ��servlet�ڵ��µ�servlet-name�ڵ�
			Element servletNameElent=(Element)element.selectSingleNode("servlet-name");
			//���servlet�ڵ��µ�servlet-class�ڵ�
			Element servletClassElent=(Element)element.selectSingleNode("servlet-class");
			//servlet-name���ı�ֵ��Ϊkey��servlet-class���ı�ֵ��Ϊvalue���Ž�Map
			ServletMap.put(servletNameElent.getText(), servletClassElent.getText());
		}
		return ServletMap;
	}

	/**
	 * @author �ձʰ�ֽ
	 * @deprecated(�������е�Servlet-mapping�ڵ�õ�map����)
	 * @since 1.0
	 * @version 1.0
	 */
	@Override
	public Map<String, String> getServletMappingMap() {
		//Servlet��Map����
	    Map<String, String> ServletMappingMap=new HashMap<String, String>();
		//������е�servlet�ڵ�
		List<Element> Servleteles=(List<Element>)document.selectNodes("/web/servlet-mapping");
		for (Element element : Servleteles) {
			//���ÿ��servlet�ڵ��µ�servlet-name�ڵ�
			Element servletNameElent=(Element)element.selectSingleNode("servlet-name");
			//���servlet�ڵ��µ�servlet-class�ڵ�
			Element urlPatternElent=(Element)element.selectSingleNode("url-pattern");
			//servlet-name���ı�ֵ��Ϊkey��servlet-class���ı�ֵ��Ϊvalue���Ž�Map
			ServletMappingMap.put(servletNameElent.getText(), urlPatternElent.getText());
		}
		
		return ServletMappingMap;
	}

}
