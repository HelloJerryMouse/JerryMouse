/**
 * 
 */
package javax.web.HttpResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**   
 * @ClassName:  HttpResponse   
 * @Description:TODO(������һ�仰��������������)   
 * @author: �޳� 
 * @date:   2019��3��25�� ����2:42:21      
 */
public interface HttpResponse {
	
	 PrintWriter getPrintWriet() throws IOException;
	 
	 OutputStream getOutputStream() throws IOException;
	 
	 void setHeader(String name,String value);

}
