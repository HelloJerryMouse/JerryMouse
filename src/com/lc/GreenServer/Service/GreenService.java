/**
 * 
 */
package com.lc.GreenServer.Service;

import java.net.Socket;

/**   
 * @ClassName:  GreenService   
 * @Description:TODO(������һ�仰��������������)   
 * @author: �޳� 
 * @date:   2019��3��25�� ����2:25:11      
 */
public interface GreenService {
	
	void start();
	
	void Service(Socket socket);

	
	
	

}
