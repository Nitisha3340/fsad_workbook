package com.klu;
import java.sql.*;

public class JDBCCreate {

	public static void main(String[] args) {
		 String url="jdbc:mysql://localhost:3306/nitu";
		 String user="root";
		 String pwd="Nitisha192004";
		 try {
			 Connection con=DriverManager.getConnection(url,user,pwd);
			 System.out.println("Connection Established");
			 String query="create table if not exists Student ("+ "id int primary key auto_increment," + "name varchar(20)"+")";
			 Statement st=con.createStatement();
			 st.execute(query);
			 System.out.println("Table created");
			 con.close();
		 }
		 catch(Exception e){
			 e.printStackTrace();
			 
		 }

	}

}
