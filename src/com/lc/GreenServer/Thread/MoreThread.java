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
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 罗城 
 * @date:   2019年3月25日 下午4:00:11      
 */
public class MoreThread implements Runnable{
	private Socket socket;
	
	private final GreenServerContext context;
	
	
	/**   
	 * @Title:  MoreThread   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
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
	
	//请求到具体的Servlet去处理
	private void RequestToServlet(HttpHead head){
		//获得Servlet的名称
		String key=DealRequestLine.getServletKey(head.getURI());
		//获得URI中的参数，返回一个参数map
		Map<String, String> ParamMap=DealRequestLine.getParameterMap(head);
		if (key!=null&&!key.contains(".")&&key!="") {
		   Servlet servlet =(Servlet)context.getContianer().getServlet(key);
		   if (servlet==null) {
			servlet=new DefaultServlet("ErrorPage/error.html");
		}
		   //执行Servlet的Service方法
		   servlet.Service(new Request(ParamMap,context), new Response(socket, context));
		}
	}
	
	//请求到默认的Servlet处理，一般为静态资源的处理
	private void RequestStatic(HttpHead head){
		String staticPath=DealRequestLine.getStaticPath(head.getURI());
		DefaultServlet defaultServlet=new DefaultServlet(staticPath);
		defaultServlet.Service(new Request(null,context), new Response(socket, context));
	}

}
