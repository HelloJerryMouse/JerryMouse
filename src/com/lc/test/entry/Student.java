/**
 * 
 */
package com.lc.test.entry;

/**   
 * @ClassName:  Student   
 * @Description:TODO(������һ�仰��������������)   
 * @author: �޳� 
 * @date:   2019��3��26�� ����9:08:52      
 */
public class Student {
	private String name;
	
	private int age;
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [" + (name != null ? "name=" + name + ", " : "")
				+ "age=" + age + "]";
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	
	

}
