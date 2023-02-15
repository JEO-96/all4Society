package com.example.demo;

public class Student {
	int id;
    String name;
    String studentNo;
    String email;

    public Student(int id, String name, String studentNo, String email) {
        this.id = id;
        this.name = name;
        this.studentNo = studentNo;
        this.email = email;
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

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
