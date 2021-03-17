package com.revature.pojo;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private Person parent = null;
	
	private List<Person> children = new ArrayList<>();
	
	private String name = "";
	
	private String spouse = "";

	public Person() {
		super();
	}
	
	public Person getParent() {
		return parent;
	}

	public void setParent(Person parent) {
		this.parent = parent;
	}

	public List<Person> getChildren() {
		return children;
	}

	public void setChildren(List<Person> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSpouse() {
		return spouse;
	}

	public void setSpouse(String spouse) {
		this.spouse = spouse;
	}
	
//	@Override
//	public String toString() {
//		return  "";
//	}

}
