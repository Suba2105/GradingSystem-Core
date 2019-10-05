package com.revature.Grading.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.revature.Grading.model.Details;
import com.revature.Grading.util.ConnectionUtil;

public class SubWiseRank {
//static Scanner scn = new Scanner(System.in);
	public static List<Details> findByGrade(String subject) throws ClassNotFoundException, Exception {
		

		System.out.println("---------");
		System.out.println("1.Maths");
		System.out.println("2.Physics");
		System.out.println("3.Chemistry");
		System.out.println("4.Botany");
		System.out.println("5.Zoology");
		System.out.println("----------");
		boolean quit = true;
		List<Details> list=new ArrayList<Details>();
		//do {

			System.out.println("Enter Your Choice: ");
		//	int Choice = scn.nextInt();
			switch (subject) {

			case "Maths": {
				
				Connection con = ConnectionUtil.getConnection();

				System.out.print("Maths      ");
				System.out.print("Register_Number          ");
				System.out.print("Grade        ");
				System.out.println("Student_Name    ");

				String sql1 = "select Student_Name,Maths,Register_Number,Grade from Admin order by Maths desc";
				PreparedStatement pst1 = con.prepareStatement(sql1);
				ResultSet rs1 = pst1.executeQuery();
				while (rs1.next()) {
					int mat = rs1.getInt("Maths");
					int reg_no = rs1.getInt("Register_Number");
					String grade = rs1.getString("Grade");
					String s_name = rs1.getString("Student_Name");
					
					Details det = new Details();
					det.setSubjectName(subject);
					det.setStudent_Name(s_name);
					det.setMaths(mat);
					det.setRegister_Number(reg_no);
					det.setGrade(grade);
					
					list.add(det);				
				//return list;
				}
				break;

			}
			
			case "Physics":

			{
				//List<Details> list=new ArrayList<Details>();
				Connection con = ConnectionUtil.getConnection();

				System.out.print("Physics    ");
				System.out.print("Register_Number       ");
				System.out.print("Grade    ");
				System.out.println("Student_Name    ");

				String sql1 = "select Student_Name,Physics,Register_Number,Grade from Admin order by Physics desc";
				PreparedStatement pst1 = con.prepareStatement(sql1);
				ResultSet rs1 = pst1.executeQuery();
				while (rs1.next()) {

					int phy = rs1.getInt("Physics");
					int reg_no = rs1.getInt("Register_Number");
					String grade = rs1.getString("Grade");
					String s_name = rs1.getString("Student_Name");

					Details det = new Details();
					det.setSubjectName(subject);
					det.setStudent_Name(s_name);
					det.setPhysics(phy);
					det.setRegister_Number(reg_no);
					det.setGrade(grade);
					
					list.add(det);
				
				//return list;
				}
				break;
			}

			case "Chemistry":
			{
				//List<Details> list=new ArrayList<Details>();
				Connection con = ConnectionUtil.getConnection();

				System.out.print("Che    ");
				System.out.print("Register_Number       ");
				System.out.print("Grade    ");
				System.out.println("Student_Name    ");

				String sql1 = "select Student_Name,Chemistry,Register_Number,Grade from Admin order by Chemistry desc";
				PreparedStatement pst1 = con.prepareStatement(sql1);

				ResultSet rs1 = pst1.executeQuery();
				while (rs1.next())

				{

					int che = rs1.getInt("Chemistry");
					int reg_no = rs1.getInt("Register_Number");
					String grade = rs1.getString("Grade");
					String s_name = rs1.getString("Student_Name");

					Details det = new Details();
					det.setSubjectName(subject);
					det.setStudent_Name(s_name);
					det.setChemistry(che);
					det.setRegister_Number(reg_no);
					det.setGrade(grade);
					
					list.add(det);		
				
				//return list;
				}
				break;
			}

			case "Botany":
			{
				//List<Details> list=new ArrayList<Details>();
				Connection con = ConnectionUtil.getConnection();

				System.out.print("Botany     ");
				System.out.print("Register_Number        ");
				System.out.print("Grade       ");
				System.out.println("Student_Name    ");

				String sql1 = "select Student_Name,Botany,Register_Number,Grade from Admin order by Botany desc";
				PreparedStatement pst1 = con.prepareStatement(sql1);

				ResultSet rs1 = pst1.executeQuery();
				while (rs1.next())

				{

					int bot = rs1.getInt("Botany");
					int reg_no = rs1.getInt("Register_Number");
					String grade = rs1.getString("Grade");
					String s_name = rs1.getString("Student_Name");

					Details det = new Details();
					det.setSubjectName(subject);
					det.setStudent_Name(s_name);
					det.setBotany(bot);
					det.setRegister_Number(reg_no);
					det.setGrade(grade);
					
					list.add(det);
				
			//	return list;
				}
				break;
			}
			
			case "Zoology": 
			{
			//	List<Details> list=new ArrayList<Details>();
				Connection con = ConnectionUtil.getConnection();

				System.out.print("Zoology    ");
				System.out.print("Register_Number    ");
				System.out.print("Grade    ");
				System.out.println("Student_Name    ");

				String sql1 = "select Student_Name,Zoology,Register_Number,Grade from admin order by Zoology desc";
				PreparedStatement pst1 = con.prepareStatement(sql1);

				ResultSet rs1 = pst1.executeQuery();
				while (rs1.next())

				{

					int zoo = rs1.getInt("Zoology");
					int reg_no = rs1.getInt("Register_Number");
					String grade = rs1.getString("Grade");
					String s_name = rs1.getString("Student_Name");

					Details det = new Details();
					det.setSubjectName(subject);
					det.setStudent_Name(s_name);
					det.setZoology(zoo);
					det.setRegister_Number(reg_no);
					det.setGrade(grade);
					
					list.add(det);
				
				//return list;
				}
				break;
			}

			case "quit": {
				quit = true;

				break;

			}

			}

	//	} while (!quit);
		return list;
		
	}

}
