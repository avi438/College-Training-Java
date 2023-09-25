package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
	
class Insert {
	public void insertOperation() throws Exception {

		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info", "root", "12345");
		PreparedStatement stmt = con.prepareStatement("insert into student values(?,?,?)");

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
						System.out.println("Data Inserted Sucessfully");
					}
					else {
						System.out.println("Query Problem");
					}
				
			
	} 
}



class Delete {
	public void deleteOperation() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info", "root", "12345");
		PreparedStatement stmt = con.prepareStatement("delete from student where course=?");

					Scanner sc = new Scanner (System.in);
					
					System.out.println("Please enter Course");
					String course = sc.nextLine();
					
					stmt.setString(1, course);
					
					int i = stmt.executeUpdate();
					
					if(i>0) {
						System.out.println("Data Deleted Sucessfully");
					}
					else {
						System.out.println("Query Problem");
					}	
				
	
			
	} 
}



class Update {
	public void updateOperation() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info", "root", "12345");
		
		PreparedStatement stmt = con.prepareStatement("update student set name=? where id=?");

					Scanner sc = new Scanner (System.in);
					
					System.out.println("Please enter updated name");
					String name = sc.nextLine();
					
					System.out.println("Please enter the student id for updation");
					int id = sc.nextInt();
					
					stmt.setString(1, name);
					stmt.setInt(2, id);
					
					
					int i = stmt.executeUpdate();
					
					if(i>0) {
						System.out.println("Data Updated Sucessfully");
					}
					else {
						System.out.println("Query Problem");
					}		
				
					//con.close();
			
	} 
}



class Search {
	public void searchOperation() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info", "root", "12345");

		PreparedStatement stmt = con.prepareStatement("select * from student where id=?");
		
		System.out.println("-----------------------------------");
		System.out.println("Enter the ID number to Search");
		Scanner sc = new Scanner(System.in);
		int id1=sc.nextInt();
		
		//stmt = setInt(1, id1);
		
		// this class is not working properly  
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
				System.out.printf("%-15s%-20s%5s\n", rs.getString(1), rs.getString(2), rs.getString(3));
		}
		
		else {
			System.out.println("Record not found....!");
			
		}
					
	}

}



class Read {
	public void readOperation() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info", "root", "12345");
		
		PreparedStatement stmt = con.prepareStatement("select * from student");	
					
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()) {
						
						int id1=rs.getInt("id");
						System.out.println("ID : "+id1);
						
						String name1=rs.getString("name");
						System.out.println("Name : "+name1);
						
						String course1=rs.getString("course");
						System.out.println("Course : "+course1);
						
						System.out.println("----------------------------------------------------------");
						
					}
					
				
					//con.close();		
				
	
			
	} 
}




class Menu {
	public void menuOperation() throws Exception {
		System.out.println("                                                            ");
		System.out.println("Choose the number from below option for the operation");
		System.out.println("For Insertion press 1");
		System.out.println("For Deletion press 2");
		System.out.println("For Updation press 3");
		System.out.println("For Searching press 4");
		System.out.println("For Reading the data press 5");
		System.out.println("For Exit press 0");
		
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		if(number>=0 && number<6)  {
			switch(number) {
			
			case(1) : {
				Insert obj4 = new Insert();
				obj4.insertOperation();
				menuOperation();
				break;
			}
			
			case(2) : {
				Delete obj6 = new Delete();
				obj6.deleteOperation();
				menuOperation();
				break;
			}
			
			case(3) : {
				Update obj8 = new Update();
				obj8.updateOperation();
				menuOperation();
				break;
			}
			
			case(4) : {
				Search obj10 = new Search();
				obj10.searchOperation();
				menuOperation();
				break;
			}
			
			case(5) : {
				Read obj12 = new Read();
				obj12.readOperation();
				menuOperation();
				break ;
			}
			
			case(0) : {
				System.out.println("Exited");
				break;
			}
			
			
			}
		}
		else {
			System.out.println("Invalid Number, Please try again");
			menuOperation();
		}
	}
}



public class MenuJdbc {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Menu obj = new Menu();
		obj.menuOperation();
		
		
	}

}

