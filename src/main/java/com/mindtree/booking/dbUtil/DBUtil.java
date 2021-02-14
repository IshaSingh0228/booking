package com.mindtree.booking.dbUtil;
import java.sql.*;

import com.mindtree.booking.exception.daoException.DatbaseConnectionFailedException;

public class DBUtil {
	private final String URL = "jdbc:mysql://localhost:3306/booking";
	private final String USERNAME = "root";
	private final String PASSWORD = "isha";

	// ----------get connection to db-------------
	public Connection getConnection() throws DatbaseConnectionFailedException  {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			throw new DatbaseConnectionFailedException("Database connection error", e);
		}
		return con;
	}

	// -------------close connection---------------
	public void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	// -----------------close resultset-------------
	public void closeConnection(ResultSet con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	// ----------------close statement----------------
	public void closeConnection(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
