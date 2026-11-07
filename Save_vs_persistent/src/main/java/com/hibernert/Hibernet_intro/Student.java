package com.hibernert.Hibernet_intro;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	private int prn;
	private String name;
	private int marks;
	@Override
	public String toString() {
		return "Student [prn=" + prn + ", name=" + name + ", marks=" + marks + "]";
	}
	public Student(int prn, String name, int marks) {
		super();
		this.prn = prn;
		this.name = name;
		this.marks = marks;
	}
	
	 public int getPrn() {
		return prn;
	}
	public void setPrn(int prn) {
		this.prn = prn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Student() {
	    }
	
	
	
	
	
	

}
