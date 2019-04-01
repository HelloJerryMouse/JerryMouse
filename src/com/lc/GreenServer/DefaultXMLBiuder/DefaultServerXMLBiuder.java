/**
 * 
 */
package com.lc.GreenServer.DefaultXMLBiuder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.lc.GreenServer.XMLBiuder.ServerXMLBiuder;

/**   
 * @ClassName:  DefaultServerXMLBiuder   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 罗城 
 * @date:   2019年3月25日 下午2:32:08      
 */
public class DefaultServerXMLBiuder implements ServerXMLBiuder{
	
	private String serverXMLPath="conf/server.xml";
	
	private Document document;
	
	/**   
	 * @Title:  DefaultServerXMLBiuder   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:    
	 * @throws   
	 */
	public DefaultServerXMLBiuder() {
		SAXReader saxReader=new SAXReader();
		try {
			document=saxReader.read(new FileInputStream(serverXMLPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
	
	 

	/* (non-Javadoc)
	 * @see com.lc.GreenServer.XMLBiuder.ServerXMLBiuder#getServerPort()
	 */
	@Override
	public int getServerPort() {
		Element  PortElement=(Element)document.selectSingleNode("/server/server-port");
		int port=Integer.parseInt(PortElement.getText());
		return port;
	}
	
	public static void main(String[] args) {
		new DefaultServerXMLBiuder().getServerPort();
	}

}
