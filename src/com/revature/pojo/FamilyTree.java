package com.revature.pojo;

import org.apache.log4j.Logger;

public class FamilyTree {
	
	Logger log = Logger.getRootLogger();
	
	Person familyTreeRoot = null;

	public FamilyTree() {
		this.familyTreeRoot = new Person();
		this.familyTreeRoot.setName("root");
	}

	public Person addChild(String parentName, String childName) {
		Person child = new Person();
		child.setName(childName);
		
		try {
			Person parent = findChild(parentName, this.familyTreeRoot);
			parent.getChildren().add(child);
			child.setParent(parent);
			return child;
		} catch (Exception e) {
			log.error("Error adding child "+childName+" to parent "+parentName, e);
		}
		return null;
	}
	
	public Person findChild(String name, Person root) throws NullPointerException {
		
		if (root == null) {
			return null;
		}
		
		if (name.equals(familyTreeRoot.getName())) {
			return root;
		}
		
		if (root != null) {
			
			for (Person child : root.getChildren()) {
				
				if (child.getName().equalsIgnoreCase(name)) {
					return child;
				} else {
					Person found = this.findChild(name, child);
					if (found.getName().equalsIgnoreCase(name)) {
						return found;
					}
				}
				
			}
			
		}
		
		
		return null;
	}
	
	public void updateRelationship() {
		
	}
	
	public boolean removeChild(String name) {
		Person parent = findChild(name, familyTreeRoot);
		if (parent != null) {
			for (Person child : parent.getChildren()) {
				if (child.getName().equalsIgnoreCase(name)) {
					parent.getChildren().remove(child);
					return true;
				}
			}
		}
		return false;
	}

	public void printTree(Person root, String depth) {
		System.out.println(depth + root.getName());
		for (Person child : root.getChildren()) {
			printTree(child, depth + depth);
		}
	}
	
	public Person getFamilyTreeRoot() {
		return familyTreeRoot;
	}

	public void setFamilyTreeRoot(Person familyTreeRoot) {
		this.familyTreeRoot = familyTreeRoot;
	}

}
