package com.itzcn.dao;

public class Student {
	
	private int id ;//id
	private String name;//�û���
	private String pass;//����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Student(String name,String pass) {
		this.name = name;
		this.pass = pass;
	}
	public Student() {//Ĭ�Ϲ��췽��
		
	}
}
