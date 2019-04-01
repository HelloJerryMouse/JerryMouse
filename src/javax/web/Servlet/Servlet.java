/**
 * 
 */
package javax.web.Servlet;

import javax.web.HttpRequest.HttpRequest;
import javax.web.HttpResponse.HttpResponse;

/**   
 * @ClassName:  Servlet   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 罗城 
 * @date:   2019年3月25日 下午2:43:47      
 */
public interface Servlet {
	
	void Service(HttpRequest request,HttpResponse response);

}
