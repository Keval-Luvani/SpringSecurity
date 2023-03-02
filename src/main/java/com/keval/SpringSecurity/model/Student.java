package com.keval.SpringSecurity.model;

public class Student {
	private int id;
	private String name;
	private int score;
	private static int count=0;
	public Student() {
		super();
	}
	
	public Student(String name, int score) {
		super();
		this.id = ++count;
		this.name = name;
		this.score = score;
	}
	
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
