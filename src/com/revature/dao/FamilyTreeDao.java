package com.revature.dao;

import com.revature.pojo.FamilyTree;

public interface FamilyTreeDao {
	
	public FamilyTree getTree();
	
	public void persistTree();

}
