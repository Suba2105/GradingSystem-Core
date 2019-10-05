package com.revature.Grading.services;

import java.util.List;
import java.util.Scanner;
import com.revature.Grading.model.Details;
import com.revature.Grading.ui.Login;
import com.revature.Grading.dao.GradeDAO;

public class UserOperations {
	static Scanner scn = new Scanner(System.in);

	public static void function() throws  Exception
	{

		System.out.println("1.Top to bottom Result");

		System.out.println("2.Grade Wise Result");

		System.out.println("3.Subject Wise Result"); 
		
		System.out.println("4.Exit"); 


		boolean quit = false;
		do {

			System.out.println("Enter The Choice: ");
			int Choice = scn.nextInt();
			if(Choice==1||Choice==2||Choice==3||Choice==4) {
			switch (Choice) {

			case 1: {
				System.out.println("Top to Bottom");

				List<Details> list = GradeDAO.findByGrade(null);
				for (Details details : list) {
					
					System.out.println(details);
				}
				break;

			}
			case 2:

			{
				System.out.println("Grade Wise");

				System.out.println("Enter the grade");
				String grade2 = scn.next();

				List<Details> list = GradeDAO.findByGrade(grade2);
				for (Details details : list) {
					
					System.out.println(details);
				}

				break;
			}

			case 3: {
				System.out.println("Subject Wise");

				System.out.println("Enter the subject");
				String subject = scn.next();

				List<Details> list = SubWiseRank.findByGrade(subject);
				for (Details details : list) {
					
					System.out.println(details);
				}

				break;

			}				

			case 4:
                System.out.println("Thank You");
				quit = true;
				Login.WelcomePage();
				break;
				
			default:
				System.out.println("Invalid");

			}
			}
			else
				System.out.println("Incorrect Choice");
		} while (quit==false);

	}

}
