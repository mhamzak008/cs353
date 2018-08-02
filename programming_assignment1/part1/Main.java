// import java.sql.*;

// public class Main {

// 	public static void main(String[] args) 
// 	{
// 		Connection conn = null;
// 		Statement stmt = null;
// 		try {
// 			// Import the driver
// 			Class.forName("org.mariadb.jdbc.Driver");

// 			// Open a connection
// 			System.out.println("Connecting to the database...");
// 			conn = DriverManager.getConnection(
//                     "jdbc:mariadb://dijkstra.ug.bcc.bilkent.edu.tr/hamza_khan", "hamza.khan", "zcjg1jln");
// 			System.out.println("Connection successfull!");

// 			// Executing queries
// 			stmt = conn.createStatement();
			
// 			// Dropping Previous Tables
// 			System.out.println("Dropping apply, student, and company tables");
// 			stmt.executeUpdate("DROP TABLE IF EXISTS apply;");
// 			stmt.executeUpdate("DROP TABLE IF EXISTS student;");
// 			stmt.executeUpdate("DROP TABLE IF EXISTS company;");
			
// 			// Creating Tables
// 			System.out.println("Creating tables in the database...");			
// 			String sql;
			
// 			sql = "CREATE TABLE student"
// 					+ "(sid CHAR(12),"
// 					+ "sname VARCHAR(50),"
// 					+ "bdate DATE,"
// 					+ "address VARCHAR(50),"
// 					+ "scity VARCHAR(20),"
// 					+ "year CHAR(20),"
// 					+ "gpa FLOAT,"
// 					+ "nationality VARCHAR(20),"
// 					+ "PRIMARY KEY (sid)) ENGINE=innodb;";
// 			stmt.executeUpdate(sql);
// 			System.out.println("Created table student in the database");
			
// 			sql = "CREATE TABLE company"
// 					+ "(cid CHAR(8),"
// 					+ "cname VARCHAR(20),"
// 					+ "quota INT,"
// 					+ "PRIMARY KEY (cid)) ENGINE=innodb;";
// 			stmt.executeUpdate(sql);
// 			System.out.println("Created table company in the database");
			
// 			sql = "CREATE TABLE apply"
// 					+ "(sid CHAR(12),"
// 					+ "cid CHAR(8),"
// 					+ "PRIMARY KEY (cid, sid)) ENGINE=innodb;";
// 			stmt.executeUpdate(sql);
// 			System.out.println("Created table apply in the database");
			
// 			// Adding Foreign Keys to apply table
// 			stmt.executeUpdate("ALTER TABLE apply ADD CONSTRAINT FOREIGN KEY (sid) REFERENCES student(sid);");
// 			stmt.executeUpdate("ALTER TABLE apply ADD CONSTRAINT FOREIGN KEY (cid) REFERENCES company(cid);");
// 			System.out.println("Foreign Keys Added");
			
// 			// Table population
// 			String row = "INSERT INTO student (sid,sname,bdate,address,scity,year,gpa,nationality) VALUES"
// 							+ " ('21000001','Ayse','1995-05-10','Tunali','Ankara','senior','2.75','TC'); ";
// 			stmt.executeUpdate(row);
			
// 			row = "INSERT INTO student (sid,sname,bdate,address,scity,year,gpa,nationality) VALUES" 
// 				+ " ('21000002','Ali','1997-09-12','Nisantasi','Istanbul','junior','3.44','TC'); ";
// 			stmt.executeUpdate(row);
			
// 			row = "INSERT INTO student (sid,sname,bdate,address,scity,year,gpa,nationality) VALUES" 
// 				+ " ('21000003','Veli','1998-10-25','Nisantasi','Istanbul','freshman','2.36','TC'); "; 
// 			stmt.executeUpdate(row);

// 			row = "INSERT INTO student (sid,sname,bdate,address,scity,year,gpa,nationality) VALUES"
// 				+ " ('21000004','John','1999-01-15','Windy','Chicago','freshman','2.55','US'); ";										    
// 			stmt.executeUpdate(row);
			
// 			System.out.println("student table populated");

// 			row = "INSERT INTO company (cid,cname,quota) VALUES"
// 				+ " ('C101','tubitak','2');";
// 			stmt.executeUpdate(row);

// 			row = "INSERT INTO company (cid,cname,quota) VALUES"
// 					+ " ('C102','aselsan','5');";
// 			stmt.executeUpdate(row);
			
// 			row = "INSERT INTO company (cid,cname,quota) VALUES"
// 					+ " ('C103','havelsan','3');";
// 			stmt.executeUpdate(row);
			
// 			row = "INSERT INTO company (cid,cname,quota) VALUES"
// 					+ " ('C104','microsoft','5');";
// 			stmt.executeUpdate(row);
			
// 			row = "INSERT INTO company (cid,cname,quota) VALUES"
// 					+ " ('C105','merkez bankasi','3');";
// 			stmt.executeUpdate(row);
			
// 			row = "INSERT INTO company (cid,cname,quota) VALUES"
// 					+ " ('C106','tai','4');";
// 			stmt.executeUpdate(row);
			
// 			row = "INSERT INTO company (cid,cname,quota) VALUES"
// 					+ " ('C107','milsoft','2');";
// 			stmt.executeUpdate(row);
			
// 			System.out.println("company table populated");
			
// 			row = "INSERT INTO apply (sid,cid) VALUES"
// 					+ " ('21000001','C101');";
// 			stmt.executeUpdate(row);
			
// 			row = "INSERT INTO apply (sid,cid) VALUES"
// 					+ " ('21000001','C102');";
// 			stmt.executeUpdate(row);
			
// 			row = "INSERT INTO apply (sid,cid) VALUES"
// 					+ " ('21000001','C103');";
// 			stmt.executeUpdate(row);
			
// 			row = "INSERT INTO apply (sid,cid) VALUES"
// 					+ " ('21000002','C101');";
// 			stmt.executeUpdate(row);
			
// 			row = "INSERT INTO apply (sid,cid) VALUES"
// 					+ " ('21000002','C105');";
// 			stmt.executeUpdate(row);
			
// 			row = "INSERT INTO apply (sid,cid) VALUES"
// 					+ " ('21000003','C104');";
// 			stmt.executeUpdate(row);
			
// 			row = "INSERT INTO apply (sid,cid) VALUES"
// 					+ " ('21000003','C105');";
// 			stmt.executeUpdate(row);
			
// 			row = "INSERT INTO apply (sid,cid) VALUES"
// 					+ " ('21000004','C107');";
// 			stmt.executeUpdate(row);
			
// 			System.out.println("apply table populated");
			
// 			// Print student table entries
// 			System.out.println("Printing Student Table: ");
// 			ResultSet rs = stmt.executeQuery("select * from student");
// 			while (rs.next())
// 			{
// 				System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getString(4)
// 								+ " | " + rs.getString(5) + " | " + rs.getString(6) + " | " + rs.getString(7) + " | " + rs.getString(8) );
// 			}
			
// 		} catch (SQLException se) {
// 			//Handle errors for JDBC
// 			se.printStackTrace();
// 		} catch (Exception e) {
// 			//Handle errors for Class.forName
// 			e.printStackTrace();
// 		} finally {
// 			//finally block used to close resources
// 			try {
// 				if (stmt != null) {
// 					conn.close();
// 				}
// 			} catch (SQLException se) {
// 			}// do nothing
// 			try {
// 				if (conn != null) {
// 					conn.close();
// 					System.out.println("Connection Closed!");
// 				}
// 			} catch (SQLException se) {
// 				se.printStackTrace();
// 			}//end finally try
// 		}//end try
// 		System.out.println("Goodbye!");	
// 	}
// }
