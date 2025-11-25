package com.user.service;

import java.util.List;
import java.util.Scanner;

import com.user.DAO.UserDAO;
import com.user.DTO.user_Details;
import com.user.exception.userDataInvalidException;

public class UserService {
	UserDAO userDAO=new UserDAO();
	public void userRegistration() {
		
		user_Details userdetails=new user_Details();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter user name:");
		String name=sc.next();
		System.out.println("Enter user Email ID:");
		String email=sc.next();
		if (email.contains("@gmail.com")) {
			if(!userDAO.chechEmailAlreadyExists(email))
			{
				
			}
			else
			{
				throw new userDataInvalidException("Email Already Exists");
			}
		}
		else
		{
			throw new userDataInvalidException("invalid email Id");
		}
		System.out.println("Enter user Mobile Number:");
		long mobile=sc.nextLong();
		if (mobile>=6000000000l&&mobile<=9999999999l) {
			if(!userDAO.checkMobileNumberAlreadyExists(mobile))
			{
				
			}
			else
			{
				throw new userDataInvalidException("Mobile Number Already Exists");
			}
		}
		else
		{
			throw new userDataInvalidException("invalid Mobile Number");
		}
		System.out.println("Enter user Password:");
		String password=sc.next();
		if (password.length()==4) {
			if (!userDAO.checkPasswordAlreadyExists(password)) {
				
			} else {
				throw new userDataInvalidException("Password Already Exists");
			}
		}
		else
		{
			throw new userDataInvalidException("invalid password");
		}
		System.out.println("Enter user Address:");
		String address=sc.next();
		System.out.println("Enter user Gender:");
		String gender=sc.next();
		userdetails.setName(name);
		userdetails.setEmail(email);
		userdetails.setMobile(mobile);
		userdetails.setPassword(password);
		userdetails.setAddress(address);
		userdetails.setGender(gender);
		if (userDAO.insertUserDetails(userdetails)) {
			System.out.println(name+" data is inserted");
		} else {
			System.out.println("Data not inserted 500 ERROR");
		}
	}
	public void updatePasswordByEmailID()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the current password");
		String cpassword=sc.next();
		System.out.println("enter the new password");
		String newpassword=sc.next();
		if(!newpassword.equalsIgnoreCase(cpassword))
		{
			System.out.println("enter the email Id");
			String emailString=sc.next();
			if(userDAO.checkPasswordAlreadyExists(newpassword))
			{
				throw new userDataInvalidException("Password Already Existed");
			}
			else
			{
				if(userDAO.updatePasswordByUserEmail(newpassword, emailString))
				{
					System.out.println("Password updated");
				}
				else
				{
					System.out.println("password not updated");
				}
			}
		}
	}
	public void updateMobileNumberByEmail()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your current mobile number");
		long cmobile=sc.nextLong();
		System.out.println("Enter your new mobile number");
		long newmobile=sc.nextLong();
		if(newmobile!=cmobile)
		{
			System.out.println("Enter your email ID");
			String email=sc.next();
			if(userDAO.checkMobileNumberAlreadyExists(newmobile))
			{
				throw new userDataInvalidException("Mobile number already exists");
			}
			else
			{
				if(userDAO.updatemobileByUserEmail(newmobile, email))
				{
					System.out.println("Mobile number updated");
				}
				else
				{
					System.out.println("Mobile number not updated");
				}
			}
		}
	}
	public void deleteUserDetails()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Email");
		String email=sc.next();
		if(userDAO.chechEmailAlreadyExists(email))//&&
		{
			System.out.println("Enter Your password");
			String password=sc.next();
			if (userDAO.checkPasswordAlreadyExists(password)) {
				System.out.println("confirm to delete the data permanently \n 1.yes"+" \n 2.no");
				switch (sc.nextInt()) {
				case 1:
					userDAO.deleteUserDetailsByEmail(email, password);
					System.out.println("successfully deleted");
					break;
				case 2:
					System.out.println("Not Deleted");
					break;
				default:
					System.out.println("enter valid choice");
					break;
				}
				
			} else {
				throw new userDataInvalidException("enter valid password");
			}
		}
		else {
			throw new userDataInvalidException("enter valid email");
		}
//		userDAO.deleteUserDetailsByEmail(email,password);
	}
	public void selectUserDetails()
	{
		userDAO.selectUserDetails();
		
		
	}
}
