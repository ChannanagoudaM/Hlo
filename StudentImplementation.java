package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.Statement;

public class StudentImplementation implements StudentInterface {
	Scanner sc = new Scanner(System.in);

	public void saveStudent() {
		int count=0;
		System.out.println("enter student name");
		String name = sc.next();
		System.out.println("enter student id");
		int id = sc.nextInt();
		System.out.println("enter student age");
		int age = sc.nextInt();
		System.out.println("enter student marks");
		double marks = sc.nextDouble();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectstudent", "root",
						"root");
				PreparedStatement p = c.prepareStatement("insert into student values(?,?,?,?)");
				p.setInt(1, id);
				p.setString(2, name);
				p.setInt(3, age);
				p.setDouble(4, marks);
				count++;
				p.execute();
				System.out.println("updated");
				c.close();
				p.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectstudent", "root",
						"root");
				PreparedStatement p = c.prepareStatement("delete from student where idstudent=?");
				System.out.println("enter student id you want to delete");
				int id = sc.nextInt();
				p.setInt(1, id);
				p.execute();
				System.out.println("updated");
				c.close();
				p.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void updateStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectstudent", "root",
						"root");
				PreparedStatement p = c.prepareStatement("update student set studentMarks=? where idstudent=?");
				System.out.println("enter id to uppdate");
				int id = sc.nextInt();
				System.out.println("enter student marks");
				double marks = sc.nextDouble();
				p.setDouble(1, marks);
				p.setInt(2, id);
				p.execute();
				System.out.println("updated");
				c.close();
				p.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getAllStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectstudent", "root",
						"root");
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery("select * from student");
				while (rs.next()) {
					String str = rs.getInt(1) + "," + rs.getString(2) + "," + rs.getInt(3) + "," + rs.getDouble(4);
					System.out.println(str);
				}
				c.close();
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
