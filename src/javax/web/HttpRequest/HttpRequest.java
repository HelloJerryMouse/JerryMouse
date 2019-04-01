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
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 罗城 
 * @date:   2019年3月25日 下午2:41:31      
 */
public interface HttpRequest {
	
	String getParameter(String name);
	
	Map<String, String> getParameters();
	
	InputStream getInputStream() throws IOException;
	
	String getRequestURI();
	
	HttpSession getHttpSession();
	
	
	

}
