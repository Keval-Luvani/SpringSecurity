package com.keval.SpringSecurity.model;

public class Teacher {
	private int id;
	private String name;
	private String subject;
	private static int count=0;
	public Teacher() {
		super();
	}

	public Teacher(String name, String subject) {
		super();
		this.id = ++count;
		this.name = name;
		this.subject = subject;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
