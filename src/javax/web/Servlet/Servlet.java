/**
 * 
 */
package javax.web.Servlet;

import javax.web.HttpRequest.HttpRequest;
import javax.web.HttpResponse.HttpResponse;

/**   
 * @ClassName:  Servlet   
 * @Description:TODO(������һ�仰��������������)   
 * @author: �޳� 
 * @date:   2019��3��25�� ����2:43:47      
 */
public interface Servlet {
	
	void Service(HttpRequest request,HttpResponse response);

}
