package com.revature.Grading.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.Grading.exception.DBException;
import com.revature.Grading.model.Details;
import com.revature.Grading.util.ConnectionUtil;

public class RegisterDAO {

	static Scanner sc = new Scanner(System.in);

	public static void register(Details d) throws SQLException, ClassNotFoundException,DBException {
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into Admin(Student_Name,Maths,Physics,Chemistry,Botany,Zoology,Total,Average,Grade) values ( ?,?,?,?,?,?,?,?,?)";
			
			
			pst = con.prepareStatement(sql);
			pst.setString(1, d.getStudent_Name());
			pst.setInt(2, d.getMaths());
			pst.setInt(3, d.getPhysics());
			pst.setInt(4, d.getChemistry());
			pst.setInt(5, d.getBotany());
			pst.setInt(6, d.getZoology());
			pst.setInt(7, d.getTotal());
			pst.setDouble(8, d.getAverage());
			pst.setString(9, d.getGrade());

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
