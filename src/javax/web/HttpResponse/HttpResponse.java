/**
 * 
 */
package javax.web.HttpResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**   
 * @ClassName:  HttpResponse   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 罗城 
 * @date:   2019年3月25日 下午2:42:21      
 */
public interface HttpResponse {
	
	 PrintWriter getPrintWriet() throws IOException;
	 
	 OutputStream getOutputStream() throws IOException;
	 
	 void setHeader(String name,String value);

}
