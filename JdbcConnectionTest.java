package database;
import java.sql.Connection;
import java.sql.DriverManager;
public class JdbcConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection com = 	DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info", "root", "12345");
      //IP ADDRESS, PORT NUMBER, DATABASE NAME, USERNAME, PASSWORD

		if(com!=null) {
				System.out.println("Connection Success");
			}
			else {
				System.out.println("Connection Failed");
			}

    }
    catch(Exception e)
      {}
  }
