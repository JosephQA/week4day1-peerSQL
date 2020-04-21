package peeerSQL_Extension;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler {
	Connection conn;
	Statement stmnt;
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/peersql";
	static final String USER = "root";
	static final String PASS = "root";

	DatabaseHandler() {
		try {
			Class.forName(JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmnt = conn.createStatement();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public ResultSet selectCustomer(int custId) {
		ResultSet rs;
		String slctString = "select * from customers where customer_id ="+custId;
		try {
			rs = stmnt.executeQuery(slctString);
			System.out.println(rs);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
		
	}
	public boolean createUser(String name, String pass, String firstname,String lastname ) {
		String comma = " , ";
		String insertString = " INSERT INTO customers VALUES(0,'"+name+"'"+comma+"'"+pass+"'"+comma+"'"+
										firstname+"'"+comma+"'"+lastname+"');";
		try {
			return stmnt.execute(insertString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateUser(int custid, String field, String value ) {
		String updateString = "update customers set "+field+"='"+value+"'"+ "where customer_id ="+custid+";";
		try {
			return stmnt.execute(updateString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteUser(int userid) {
		String deleteString = "delete from users where userID="+userid;
		try {
			stmnt.executeUpdate(deleteString);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
