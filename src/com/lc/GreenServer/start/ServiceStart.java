/**
 * 
 */
package com.lc.GreenServer.start;

import com.lc.GreenServer.DefaultService.DefaultGreenService;
import com.lc.GreenServer.Service.GreenService;

/**   
 * @ClassName:  ServiceStart   
 * @Description:TODO(������һ�仰��������������)   
 * @author: �޳� 
 * @date:   2019��3��25�� ����2:59:51      
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
