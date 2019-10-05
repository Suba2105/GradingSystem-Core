package com.revature.Grading.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.Grading.exception.DBException;
import com.revature.Grading.model.Details;
import com.revature.Grading.util.ConnectionUtil;

public class AdminLoginDAO {

	public static Details login(String uname, String pass) throws SQLException,DBException {
		Connection con =null;
		PreparedStatement pst=null;
		Details det=null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select * from Register where Admin_Name=? and Password=?";
			pst = con.prepareStatement(sql);
			pst.setString(1,uname);
			pst.setString(2,pass);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String uname1 = rs.getString("Admin_Name");
				String pass1 = rs.getString("Password");
				det = new Details();
				det.setAdmin_Name(uname1);
				det.setPassword(pass1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Unable to select");
		}finally {
			con.close();
			pst.close();
		}
		return det;
		}
}

