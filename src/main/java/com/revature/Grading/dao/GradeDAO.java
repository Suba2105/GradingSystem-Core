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

public class GradeDAO {

	public static List<Details> findByGrade(String grade1) throws SQLException,DBException {
		Connection con =null;
		PreparedStatement pst=null;
		List<Details> list=new ArrayList<Details>();
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select Student_Name,Maths,Physics,Chemistry,Botany,Zoology,Total,Average,Grade from Admin where Grade=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, grade1);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				String s_name = rs.getString("Student_Name");
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
				System.out.println("---------------------------------");
				System.out.print("STUDENT_NAME           ");
				System.out.println("GRADE                  ");
				System.out.println("---------------------------------");

				String sql1 = "select Student_Name,Maths,Physics,Chemistry,Botany,Zoology,Total,Average,Grade from Admin where Grade=?";
				PreparedStatement pst1 = con.prepareStatement(sql1);

				pst1.setString(1, grade1);
				ResultSet rs1 = pst1.executeQuery();
				while (rs1.next()) {
					String student_name = rs1.getString("Student_Name");
					String grade2 = rs1.getString("Grade");
					
					StudentGrade gra=new StudentGrade();
					gra.setStudent_Name(student_name);
					gra.setGrade(grade2);
					list.add(gra);					
				}
				*/
				//UserOperations.function();
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
