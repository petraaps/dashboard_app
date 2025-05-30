package dpbo.dashboardApp.models;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import dpbo.dashboardApp.db.DatabaseManager;

public class Project extends DatabaseManager {
	private Connection connection;

	public Project() {
		super();
		try {
			this.connection = super.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getId(int id) throws Exception {
		Statement statement = connection.createStatement();
		
		ResultSet s = statement.executeQuery("SELECT id FROM Project WHERE id = " + id);
		if (s.next()) {
			return s.getInt("id");
		} else {
			throw new Exception("Project not found with id: " + id);
		}
	}

	public String getName(int id) throws Exception {
		Statement statement = connection.createStatement();
		
		ResultSet s = statement.executeQuery("SELECT name FROM Project WHERE id = " + id);
		if (s.next()) {
			return s.getString("name");
		} else {
			throw new Exception("Project not found with id: " + id);
		}
	}

	public String setName(int id, String name) throws Exception {
		Statement statement = connection.createStatement();
		
		int rowsAffected = statement.executeUpdate("UPDATE Project SET name = '" + name + "' WHERE id = " + id);
		if (rowsAffected > 0) {
			return "Name updated successfully.";
		} else {
			throw new Exception("Project not found with id: " + id);
		}
	}
}
