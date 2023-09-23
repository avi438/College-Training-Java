package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.DriverManager;
public class InsertData_Jdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection com = 	DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info", "root", "12345");

			PreparedStatement stmt = com.prepareStatement("insert into student values(?,?,?)");
			
			Scanner sc = new Scanner (System.in);
      
			System.out.println("Please enter Name");
			String name = sc.nextLine();
			
			System.out.println("Please enter Course");
			String course = sc.nextLine();
			
			System.out.println("Please enter Id");
			int id = sc.nextInt();
			
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, course);
			
			int i = stmt.executeUpdate();
			
			if(i>0) {
				System.out.println("Data Saved Sucessfully");
			}
			else {
				System.out.println("Query Problem");
			}
		}
		
		catch (Exception e)
		{}
		
	}

}
