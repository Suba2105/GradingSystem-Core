package com.revature.Grading.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.Grading.exception.DBException;
import com.revature.Grading.model.Details;
import com.revature.Grading.util.ConnectionUtil;

public class TopBottomDAO  {

	public static List<Details> findByGrade() throws SQLException,DBException {
	
		
		List<Details> list=new ArrayList<Details>();
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select Student_Name,Register_Number,Maths,Physics,Chemistry,Botany,Zoology,Total,Average,Grade from Admin ";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {

				String s_name = rs.getString("Student_Name");
				Integer reg_no = rs.getInt("Register_Number");
				Integer mat = rs.getInt("Maths");
				Integer phy = rs.getInt("Physics");
				Integer che = rs.getInt("Chemistry");
				Integer bot = rs.getInt("Botany");
				Integer zoo = rs.getInt("Zoology");
				Integer total = rs.getInt("Total");
				Double avg = rs.getDouble("Average");
				String grade = rs.getString("Grade");

				Details det = new Details();

				det.setStudent_Name(s_name);
				det.setRegister_Number(reg_no);
				det.setMaths(mat);
				det.setPhysics(phy);
				det.setChemistry(che);
				det.setBotany(bot);
				det.setZoology(zoo);
				det.setTotal(total);
				det.setAverage(avg);
				det.setGrade(grade);
				
				list.add(det);	
				
                /*

				System.out.print("GRADE         ");
				System.out.println("STUDENT_NAME             ");

				String sql1 = "select Student_Name,Register_Number,Maths,Physics,Chemistry,Botany,Zoology,Total,Average,Grade from Admin order by Total desc ";
				PreparedStatement pst1 = con.prepareStatement(sql1);

				ResultSet rs1 = pst1.executeQuery();
				while (rs1.next()) {

					String Grade = rs1.getString("Grade");
					String Sname = rs1.getString("Student_Name");
					int regno1 = rs1.getInt("Register_Number");

					System.out.println(regno1 + "                           " + Grade + "                   " + Sname);
				}
				UserOperations.function();
				*/
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Unable to select");
		}finally {
			con.close();
			pst.close();
			
		}
		return list;

	}
}
