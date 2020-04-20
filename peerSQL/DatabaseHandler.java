package peerSQL;
import java.sql.*;

public class DatabaseHandler {
Connection conn;
Statement stmnt;
static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost:3306/gamedb";
static final String USER = "root";
static final String PASS = "root";

	DatabaseHandler(){
		try {
			Class.forName(JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(DB_URL, USER,PASS);
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
	public boolean createCustomer(String name, int age, String email, String postcode,
								String adress, String password, String city ) {
		String comma = " , ";
		String insertString = " INSERT INTO customers VALUES(0,'"+name+"'"+comma+age+comma+"'"+email+"'"+comma+"'"+
										postcode+"'"+comma+"'"+adress+"'"+comma+"'"+password+"'"+comma+"'"+city+"');";
		try {
			return stmnt.execute(insertString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateCustomer(int custid, String field, String value ) {
		String updateString = "update customers set "+field+"='"+value+"'"+ "where customer_id ="+custid+";";
		try {
			return stmnt.execute(updateString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteCustomer(int custid) {
		String deleteString = "delete from customers where customer_id="+custid;
		try {
			return stmnt.execute(deleteString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
