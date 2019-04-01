/**
 * 
 */
package com.lc.GreenServer.start;

import com.lc.GreenServer.DefaultService.DefaultGreenService;
import com.lc.GreenServer.Service.GreenService;

/**   
 * @ClassName:  ServiceStart   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 罗城 
 * @date:   2019年3月25日 下午2:59:51      
 */
public class ServiceStart {
	
	
	
	private void init(){
		
		
	}
	
	public static void start(){
		GreenService service=new DefaultGreenService();
		service.start();	
	}
	
	public static void main(String[] args) {
		
		start();
		
	}
	
	

}
