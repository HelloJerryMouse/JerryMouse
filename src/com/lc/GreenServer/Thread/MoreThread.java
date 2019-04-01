/**
 * 
 */
package com.lc.GreenServer.Thread;

import java.net.Socket;






import java.util.Map;

import javax.web.Servlet.Servlet;

import com.lc.GreenServer.DefaultServlet.DefaultServlet;
import com.lc.GreenServer.GreenServerContext.GreenServerContext;
import com.lc.GreenServer.Request.Request;
import com.lc.GreenServer.Response.Response;
import com.lc.GreenServer.httphead.HttpHead;
import com.lc.GreenServer.util.DealRequestLine;
import com.lc.GreenServer.util.SocketUitl;

/**   
 * @ClassName:  MoreThread   
 * @Description:TODO(������һ�仰��������������)   
 * @author: �޳� 
 * @date:   2019��3��25�� ����4:00:11      
 */
public class MoreThread implements Runnable{
	private Socket socket;
	
	private final GreenServerContext context;
	
	
	/**   
	 * @Title:  MoreThread   
	 * @Description:    TODO(������һ�仰�����������������)   
	 * @param:    
	 * @throws   
	 */
	public MoreThread(Socket socket,GreenServerContext context) {
		this.context=context;
		this.socket=socket;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		HttpHead httpHead=SocketUitl.getRequestContent(socket);
		if (httpHead!=null) {	
		if (DealRequestLine.isStatic(httpHead.getURI())) {
			RequestStatic(httpHead);
		}else{
		    RequestToServlet(httpHead);	
		}
		}
		
	}
	
	//���󵽾����Servletȥ����
	private void RequestToServlet(HttpHead head){
		//���Servlet������
		String key=DealRequestLine.getServletKey(head.getURI());
		//���URI�еĲ���������һ������map
		Map<String, String> ParamMap=DealRequestLine.getParameterMap(head);
		if (key!=null&&!key.contains(".")&&key!="") {
		   Servlet servlet =(Servlet)context.getContianer().getServlet(key);
		   if (servlet==null) {
			servlet=new DefaultServlet("ErrorPage/error.html");
		}
		   //ִ��Servlet��Service����
		   servlet.Service(new Request(ParamMap,context), new Response(socket, context));
		}
	}
	
	//����Ĭ�ϵ�Servlet����һ��Ϊ��̬��Դ�Ĵ���
	private void RequestStatic(HttpHead head){
		String staticPath=DealRequestLine.getStaticPath(head.getURI());
		DefaultServlet defaultServlet=new DefaultServlet(staticPath);
		defaultServlet.Service(new Request(null,context), new Response(socket, context));
	}

}
