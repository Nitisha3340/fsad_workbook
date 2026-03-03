package com.emp;

import java.sql.*;

public class EmpDept {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/nitu";
        String user = "root";
        String pwd  = "Nitisha192004";

        try (Connection con = DriverManager.getConnection(url, user, pwd)) {

            System.out.println("Connection established");

            Statement st = con.createStatement();

            String createDept = "CREATE TABLE IF NOT EXISTS department ("
                    + "dept_id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "dept_name VARCHAR(50),"
                    + "location VARCHAR(50)"
                    + ")";
            st.execute(createDept);
            System.out.println("Department table created");

            String createEmp = "CREATE TABLE IF NOT EXISTS employee ("
                    + "emp_id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "emp_name VARCHAR(50),"
                    + "salary DOUBLE,"
                    + "dept_id INT,"
                    + "FOREIGN KEY (dept_id) REFERENCES department(dept_id)"
                    + ")";
            st.execute(createEmp);
            System.out.println("Employee table created");

          
            int deptId = -1;
            String insertDept = "INSERT INTO department (dept_name, location) VALUES (?, ?)";
            try (PreparedStatement ps = con.prepareStatement(insertDept, PreparedStatement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, "IT");
                ps.setString(2, "Hyderabad");
                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    deptId = rs.getInt(1);
                    System.out.println("Inserted department with ID: " + deptId);
                }
            }

           
            if (deptId != -1) {
                String insertEmp = "INSERT INTO employee (emp_name, salary, dept_id) VALUES (?, ?, ?)";
                try (PreparedStatement ps2 = con.prepareStatement(insertEmp)) {
                    ps2.setString(1, "Ravi");
                    ps2.setDouble(2, 55000.00);
                    ps2.setInt(3, deptId);
                    ps2.executeUpdate();
                    System.out.println("Inserted employee for dept_id: " + deptId);
                }
            }

            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

            
            
					
					
					
					
					
		