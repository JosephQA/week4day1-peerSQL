package peerSQL;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Runner {
	public static void main(String[] args) {
		DatabaseHandler dbh = new DatabaseHandler();
		ResultSet rs1 = dbh.selectCustomer(1);
		try {
			rs1.next();
			System.out.println("ID: " + rs1.getInt(1) + " Name: " + rs1.getString(2) + " city: " + rs1.getString(8));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(dbh.createCustomer("nameo2", 12, "email@eamilnfqkfbsfk", "ww22", "adress fifty 5",
				"passsword", "Detroit"));
		System.out.println(dbh.updateCustomer(2,"cust_email", "newnew@new.new"));
		 System.out.println(dbh.deleteCustomer(8));
	}
}
