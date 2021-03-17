package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.revature.pojo.FamilyTree;
import com.revature.util.ConnectionFactoryPostgres;

public class FamilyTreeDaoPostgres implements FamilyTreeDao {
	
	private Logger log = Logger.getRootLogger();
	
	Connection conn = ConnectionFactoryPostgres.getConnection();

	@Override
	public FamilyTree getTree() {
		
		log.trace("FamilyTreeDaoPostgres.getTree method called");
		
		String sql = "select * from tree";
		
		FamilyTree tree = null;
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				tree = new FamilyTree();
				tree.addChild(rs.getString("parent_name"), rs.getString("child_name"));
			}
		} catch (SQLException e) {
			log.error("Failure to connect to DB", e);
		}
		
		return tree;
	}

	@Override
	public void persistTree() {
		// TODO Auto-generated method stub

	}

}
