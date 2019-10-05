package com.revature.Grading.ui;

import java.util.Scanner;

import com.revature.Grading.dao.AdminRegisterDAO;
import com.revature.Grading.services.UserOperations;
import com.revature.Grading.dao.UserDAO;
import com.revature.Grading.model.Details;

public class Login {
	static Scanner scn = new Scanner(System.in);
	public static void main(String args[]) throws Exception {

		WelcomePage();

	}
	public static int checkNumber() {
        boolean result = false;
        int choice = 0;
        while(result!=true) {
            try {
                String s =scn.next();
                choice= Integer.parseInt(s);
                result = true;
                break;
            }catch(Exception e) {
                System.out.println("Invalid Option....!");
                System.out.println("Enter your Option :");
            }
            
        }
        return choice;
    }

	public static void WelcomePage() throws Exception, ClassNotFoundException
 
	{
		System.out.println("--------------------------------");
		System.out.println("Press 1 for ADMIN REGISTERATION"
				            + "2 for ADMIN LOGIN"
				            + "3 for STUDENT LOGIN"
				            + "4 for Logout");
		System.out.println("--------------------------------");	

		    boolean quit = false;
			do {
				System.out.println("Enter The Option:");
				int Choice = checkNumber();
				if(Choice==1||Choice==2||Choice==3||Choice==4){
				switch (Choice)
				{
				case 1:
					
					System.out.println("Enter your Name");
					String a_name = scn.next();
					System.out.println("Create a Password");
			        String pass1 = scn.next();
			        AdminRegisterDAO.adminregister(a_name, pass1);
			        System.out.println("Registration Successful");
					
					break;
					
				case 2:

					System.out.println("Enter The Admin Name ");
					String uname = scn.next();
					System.out.println("Enter the Password");
					String pass = scn.next();

					if ((uname == "a_name") && (pass == "pass1"))						

					{
						System.out.println("Choose 1 for Entering Student's Details or 2 for Viewing the Student's Details");
						int a = scn.nextInt();
						if(a==1)
						{
						System.out.println("_____________________________");
						System.out.println("ENTER THE STUDENT INFORMATION");
						System.out.println("_____________________________");

						System.out.println("Enter Student name:");
						String s_name = scn.next();
						
						System.out.println("Enter Maths Mark:");
						int mat = scn.nextInt();

						System.out.println("Enter Physics Mark:");
						int phy = scn.nextInt();

						System.out.println("Enter Chemistry Mark:");
						int che = scn.nextInt();

						System.out.println("Enter Botany Mark:");
						int bot = scn.nextInt();

						System.out.println("Enter Zoology Mark:");
						int zoo = scn.nextInt();

						int total = mat + phy + che + bot + zoo;
			  		    double avg = (double) (total / 5);

						System.out.println("Total Marks:" + total);
						System.out.println("Average:" + avg);
						String grade = getGrade(total);

							System.out.println("GRADE: " + grade);
							
							//RegisterDAO.register(s_name,mat, phy, che, bot, zoo, total, avg, grade);

						
						}
				
					else if(a==2)		
					{						
						UserOperations.function();						

					}
					else{
						
						System.out.println("INVALID ENTRY ");
					}
					}
					else
					{
						System.out.println("Please Enter the Correct Option");
					}

					break;

				case 3:

					System.out.println("**********");
					System.out.println("Login");
					System.out.println("**********");

					System.out.println("Student_Name");
					String s_name = scn.next();

					System.out.println("Enter the Register_Number");
					int reg_no = scn.nextInt();

					Details det = new Details();

					det = UserDAO.login(s_name, reg_no);

					if (det != null) {
						System.out.println("Login Successfull");

						UserOperations.function();

					} else
						System.out.println("Incorrect STUDENT_NAME AND REGISTER_Number");

					break;

				case 4:
                    System.out.println("Thank You");
					quit = true;			      
					break;
                
			
				}
				}
				
				else
					System.out.println("Incorrect Option........Enter the correct option");
			} while (quit==false);
		}
	public static String getGrade(int total) {
		String grade;
		
			if (total > 470 && total <= 500) {
				grade = "A";

			} else if (total > 430 && total <= 470) {
				grade = "B";

			} else if (total > 390 && total <= 430) {
				grade = "C";

			} else {
				grade = "U";
			}
		return grade;
	} 
}
	
	


