package com.revature.Grading.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import com.revature.Grading.exception.DBException;
import com.revature.Grading.util.ConnectionUtil;

public class AdminRegisterDAO {

		static Scanner sc = new Scanner(System.in);

		public static void adminregister(String a_name,String pass1) throws SQLException, ClassNotFoundException,DBException {
			Connection con=null;
			PreparedStatement pst=null;
			try {
				con = ConnectionUtil.getConnection();
				String sql = "insert into Register(Admin_Name,Password) values ( ?,?)";
				pst = con.prepareStatement(sql);
				pst.setString(1, a_name);
				pst.setString(2, pass1);

				int rows = pst.executeUpdate();
				System.out.println("Number Of Rows Inserted    " + rows);
			} catch (Exception e) {
				e.printStackTrace();
				throw new DBException("Unable to register");
			}finally {
				con.close();
				pst.close();
			}

		}

		
	}



