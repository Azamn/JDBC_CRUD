package jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class watchDemo {
	 	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		// Object creation
		watchDemo wd = new watchDemo();
		
		Scanner sc = new Scanner(System.in);
		
		int ch;
		do {
			System.out.println("Enter Your Choice :");
			System.out.println("1. Insert The Data :");
			System.out.println("2. Display The Records :");
			System.out.println("3. Update the records :");
			System.out.println("4. Delete The record :");
			System.out.println("5. Exit");
			
			ch = sc.nextInt();
			
			switch(ch) {
			case 1:
				wd.insertData();
				break;
				
			case 2:
				wd.displayData();
				break;
			case 3:
				wd.updateData();
				break;
			case 4:
				wd.deleteData();
				break;
			case 5:
				System.out.println("Thank you for visiting us..!");
				break;
				
			default:
				break;
			}
			
		}while(ch!= 5);
		
	}
	
	public Connection getConnect() throws SQLException {
		try {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/watches","admin","admin");
		return con;
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}

	private void deleteData() {
		// TODO Auto-generated method stub
		
	}

	private void updateData() {
		// TODO Auto-generated method stub
		
	}

	private void displayData() {
		// TODO Auto-generated method stub
		
	}

	private void insertData() {
		// TODO Auto-generated method stub
		watch w = new watch();
		System.out.println("Enter watch name : ");
		String wname = sc.next();
		w.setWatch_name(wname);
		
		System.out.println("Enter watch Brand : ");
		String wbrand = sc.next();
		w.setBrand(wbrand);
		
		System.out.println("Enter watch Price : ");
		Double wprice = sc.nextDouble();
		w.setPrice(wprice);
		
		try {
			Connection con = getConnect();
			String query = "insert into watch (watch_name,watch_brand,watch_price)values(?,?,?)";
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(query);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
