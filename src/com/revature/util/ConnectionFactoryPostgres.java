package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionFactoryPostgres {

	Logger log = Logger.getRootLogger();
	
	public static String URL;

	public static String USERNAME;

	public static String PASSWORD;
	
	public static String DB_NAME;
	
	private static ConnectionFactoryPostgres connectionFactory = null;

	private ConnectionFactoryPostgres() {

		DB_NAME = System.getenv("FAM_TREE_DB_NAME");

		URL = "jdbc:postgresql://" + System.getenv("FAM_TREE_DB_URL") + ":5432/" + DB_NAME + "?currentSchema=" + System.getenv("FAM_TREE_SCHEMA");

		USERNAME = System.getenv("FAM_TREE_DB_USERNAME");

		PASSWORD = System.getenv("FAM_TREE_DB_PASSWORD");
	}

	public Connection createConnection() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load Driver");
		}

		log.info("URL : " + URL);

		try {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			log.error("Failed to connect to DB", e);
		}
		return null;
	}
	
	public static synchronized Connection getConnection() {
		
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactoryPostgres();
		}

		return connectionFactory.createConnection();

	}

}
