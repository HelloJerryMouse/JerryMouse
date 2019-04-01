/**
 * 
 */
package javax.web.HttpRequest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.web.HttpSession.HttpSession;

/**   
 * @ClassName:  HttpRequest   
 * @Description:TODO(������һ�仰��������������)   
 * @author: �޳� 
 * @date:   2019��3��25�� ����2:41:31      
 */
public interface HttpRequest {
	
	String getParameter(String name);
	
	Map<String, String> getParameters();
	
	InputStream getInputStream() throws IOException;
	
	String getRequestURI();
	
	HttpSession getHttpSession();
	
	
	

}
