package dpbo.dashboardApp.models;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import dpbo.dashboardApp.db.DatabaseManager;

public class Revision extends DatabaseManager {
	private Connection connection;

	public Revision() {
		super();
		try {
			this.connection = super.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getId(int id) throws Exception {
		Statement statement = connection.createStatement();
	
		ResultSet s = statement.executeQuery("SELECT id FROM Revision WHERE id = " + id);
		if (s.next()) {
			return s.getInt("id");
		} else {
			throw new Exception("Revision not found with id: " + id);
		}
	}

	public String getContent(int id) throws Exception {
		Statement statement = connection.createStatement();
		
		ResultSet s = statement.executeQuery("SELECT content FROM Revision WHERE id = " + id);
		if (s.next()) {
			return s.getString("content");
		} else {
			throw new Exception("Revision not found with id: " + id);
		}
	}

	public String setContent(int id, String content) throws Exception {
		Statement statement = connection.createStatement();
		
		int rowsAffected = statement.executeUpdate("UPDATE Revision SET content = '" + content + "' WHERE id = " + id);
		if (rowsAffected > 0) {
			return "Content updated successfully.";
		} else {
			throw new Exception("Revision not found with id: " + id);
		}
	}

}
