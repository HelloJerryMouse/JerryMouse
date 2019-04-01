/**
 * 
 */
package javax.web.HttpSession;

/**   
 * @ClassName:  HttpSession   
 * @Description:TODO(HttpSessionģ�飬���ڻỰ���٣������û���״̬��������Ϣ)   
 * @author: �޳� 
 * @date:   2019��3��28�� ����1:10:20      
 */
public interface HttpSession {
	/**
	 * 
	 * @Title: setAttribue      
	 * @param name ������session���ݵ�key
	 * @param value   ���� ��session���ݵ�value      
	 * @since 1.0
	 * @version 1.0
	 */
	void setAttribue(String name,Object value);
	
	/**
	 * 
	 * @Title: getOAttribute   
	 * @Description: TODO(��ø���key�õ���ֵ)   
	 * @param name ��ȡ������session�е����ݵ�key
	 * @return ���ز�ѯkey����Ӧ��value           
	 */
	Object getAttribute(String name);
	
	/**
	 * 
	 * @Title: RemoveAttribute   
	 * @Description: TODO(����name�Ƴ�����Ӧ��attrbute)   
	 * @param name   Ҫ�Ƴ���attribute��key         
	 * @since 1.0
	 * @version 1.0
	 */
	void RemoveAttribute(String name);
	
	
	/**
	 * 
	 * @Title: setExpired   
	 * @Description: TODO(����session�Ĺ���ʱ��)   
	 * @param second ����ʱ������Ϊ��λ           
	 * @since 1.0
	 * @version 1.0
	 */
	
	void setExpired(int second);
	

}
