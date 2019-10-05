package com.revature.Grading.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.Grading.exception.DBException;
import com.revature.Grading.model.Details;
import com.revature.Grading.util.ConnectionUtil;

public class UserDAO {

	public static Details login(String S_name, int reg_no) throws SQLException,DBException  {
		Details det = null;
		Connection con =null;
		PreparedStatement pst=null;
		try {
			con = ConnectionUtil.getConnection();

           
		String sql = "select Student_Name,Register_Number from Admin where Student_Name=? && Register_Number=?";
			
			pst = con.prepareStatement(sql);

			pst.setString(1, S_name);
			pst.setInt(2, reg_no);
			ResultSet rs = pst.executeQuery();
			


			if (rs.next()) {

				String s_name = rs.getString("Student_Name");
			Integer reg_no1 = rs.getInt("Register_Number");



				det = new Details();

				det.setStudent_Name(s_name);
				det.setRegister_Number(reg_no1);



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
