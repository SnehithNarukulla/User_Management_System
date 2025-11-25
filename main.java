package com.user.main;

import java.util.Scanner;

import com.user.DAO.UserDAO;
import com.user.service.UserService;

public class main{
	public static void main(String[] args) {
		UserService userservice=new UserService();
//		userservice.userRegistration();
//		userservice.updatePasswordByEmailID();
//		userservice.updateMobileNumberByEmail();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter \n 1.For User Registration" +"\n 2.To Update User Details" +"\n 3.To Delete User Details" +"\n 4.To Select User Details");
		switch (sc.nextInt()) {
		case 1:
			System.out.println("User Registration");
			userservice.userRegistration();
			break;
		case 2:
			System.out.println("Update Details");
			System.out.println("Enter \n 1.To update password"+"\n 2.To update mobile number");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("update password");
				userservice.updatePasswordByEmailID();
				break;
			case 2:
				System.out.println("update mobile number");
				userservice.updateMobileNumberByEmail();
				break;
			default:
				System.out.println("enter valid choice to update");
				break;
			}
		case 3:
			System.out.println("delete user Details");
			userservice.deleteUserDetails();
			break;
		case 4:
			System.out.println("select user details");
			userservice.selectUserDetails();
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
	}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              