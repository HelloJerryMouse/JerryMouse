/**
 * 
 */
package com.lc.GreenServer.DefaultServlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.web.HttpRequest.HttpRequest;
import javax.web.HttpResponse.HttpResponse;
import javax.web.Servlet.Servlet;

import com.lc.test.entry.Student;

/**   
 * @ClassName:  DefaultServlet   
 * @Description:TODO(GreenServerĬ�ϵ�Servlet�����ھ�̬��Դ����Ĵ���)   
 * @author: �޳� 
 * @date:   2019��3��27�� ����12:20:42
 * @since 1.0
 * @version 1.0      
 */
public class DefaultServlet implements Servlet{
	
	//����ľ�̬��Դ��λ��
	private String URI;
	
	/**DefaultServlet�Ĺ�����
	 * @param:   URI ����ľ�̬��Դ��λ��    
	 */
	public DefaultServlet(String URI) {
		this.URI=URI;
		
	}

	/* (non-Javadoc)
	 * @see javax.web.Servlet.Servlet#Service(javax.web.HttpRequest.HttpRequest, javax.web.HttpResponse.HttpResponse)
	 *
	 */
	@Override
	public void Service(HttpRequest request, HttpResponse response) {
		sendStaticFile(request,response);		
	}
	
	//����ļ��Ƿ���ڣ��������������÷���not-foundҳ�棬��������͸þ�̬��Դ
	private void sendStaticFile(HttpRequest request, HttpResponse response){
		PrintWriter printWriter=null;
		File file=new File("webApp"+this.URI);
		try {
			printWriter=response.getPrintWriet();
			if (file.exists()) {
			
				sendFile(printWriter,"webApp"+this.URI);
			}
			else{
				sendFile(printWriter,"ErrorPage/error.html");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//���;�̬�ļ�
	private void sendFile(PrintWriter printWriter,String path){
			FileInputStream fileInputStream=null;
			BufferedReader br=null;
			InputStreamReader ire=null;
			String line;
			try {
				fileInputStream=new FileInputStream(
						new File(path));
				 ire=new InputStreamReader(fileInputStream);
				br=new BufferedReader(ire);
				line = br.readLine();
				StringBuilder builder=new StringBuilder();
				while (line!=null) {
					builder.append(line);
					line=br.readLine();
				}
				
				printWriter.print(builder.toString());
				printWriter.flush();
			} catch (IOException e) {
				
				e.printStackTrace();
			}finally{
				printWriter.close();
					try {
						if (br!=null) {
						br.close();
						}
						if (ire!=null) {
							ire.close();
						}
						if (fileInputStream!=null) {
							fileInputStream.close();
						}
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				
			}
			
			
			
	}
	

}
