import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dpbo.dashboardApp.db.DatabaseManager;

class User extends DatabaseManager {
	private int id;
	private String name;
	private String email;
	private Connection connection;

	public User() {
		super();
		connection = super.getConnection();
	}

	public int getId(int id) throws Exception {
		Statement statement = connection.createStatement();
		
		ResultSet s = statement.executeQuery("SELECT id FROM User WHERE id = " + id);

		if (s.next()) {
			return s.getInt("id");
		} else {
			throw new Exception("User not found with id: " + id);
		}
	}

	public String getName(int id) throws Exception {
		Statement statement = connection.createStatement();
		
		ResultSet s = statement.executeQuery("SELECT name FROM User WHERE id = " + id);

		if (s.next()) {
			return s.getString("name");
		} else {
			throw new Exception("User not found with id: " + id);
		}
	}

	public String setName(int id, String name) throws Exception {
		Statement statement = connection.createStatement();
		
		int rowsAffected = statement.executeUpdate("UPDATE User SET name = '" + name + "' WHERE id = " + id);

		if (rowsAffected > 0) {
			return "Name updated successfully.";
		} else {
			throw new Exception("User not found with id: " + id);
		}
	}

	public String getEmail(int id) throws Exception {
		Statement statement = connection.createStatement();
		
		ResultSet s = statement.executeQuery("SELECT email FROM User WHERE id = " + id);

		if (s.next()) {
			return s.getString("email");
		} else {
			throw new Exception("User not found with id: " + id);
		}
	}

	public String setEmail(int id, String email) throws Exception {
		Statement statement = connection.createStatement();
		
		int rowsAffected = statement.executeUpdate("UPDATE User SET email = '" + email + "' WHERE id = " + id);

		if (rowsAffected > 0) {
			return "Email updated successfully.";
		} else {
			throw new Exception("User not found with id: " + id);
		}
	}

}
