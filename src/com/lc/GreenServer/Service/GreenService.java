/**
 * 
 */
package com.lc.GreenServer.Service;

import java.net.Socket;

/**   
 * @ClassName:  GreenService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 罗城 
 * @date:   2019年3月25日 下午2:25:11      
 */
public interface GreenService {
	
	void start();
	
	void Service(Socket socket);

	
	
	

}
