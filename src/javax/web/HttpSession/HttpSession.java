/**
 * 
 */
package javax.web.HttpSession;

/**   
 * @ClassName:  HttpSession   
 * @Description:TODO(HttpSession模块，用于会话跟踪，保存用户的状态及个人信息)   
 * @author: 罗城 
 * @date:   2019年3月28日 下午1:10:20      
 */
public interface HttpSession {
	/**
	 * 
	 * @Title: setAttribue      
	 * @param name 保存在session数据的key
	 * @param value   保存 在session数据的value      
	 * @since 1.0
	 * @version 1.0
	 */
	void setAttribue(String name,Object value);
	
	/**
	 * 
	 * @Title: getOAttribute   
	 * @Description: TODO(获得根据key得到的值)   
	 * @param name 获取保存在session中的数据的key
	 * @return 返回查询key所对应的value           
	 */
	Object getAttribute(String name);
	
	/**
	 * 
	 * @Title: RemoveAttribute   
	 * @Description: TODO(根据name移除所对应的attrbute)   
	 * @param name   要移除的attribute的key         
	 * @since 1.0
	 * @version 1.0
	 */
	void RemoveAttribute(String name);
	
	
	/**
	 * 
	 * @Title: setExpired   
	 * @Description: TODO(设置session的过期时间)   
	 * @param second 过期时间以秒为单位           
	 * @since 1.0
	 * @version 1.0
	 */
	
	void setExpired(int second);
	

}
