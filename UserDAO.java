package com.user.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.user.DTO.user_Details;
import com.user.service.UserService;

public class UserDAO {
	private static final String check_email_already_exists="select * from user_management where User_email=?";
	private static final String check_mobile_number_already_exists="select * from user_management where User_mobile=?";
	private static final String check_password_already_exists="select * from user_management where User_password=?";
	private static final String url="jdbc:mysql://localhost:3306/m_16_advance_java?user=root&password=root";
	private static final String updatepassword="update user_management set User_password=? where User_email=?";
	private static final String updatemobile="update user_management set User_mobile=? where User_email=?";
	private static final String delete="delete from user_management where User_email=? and User_password=?";
	private static final String select="select * from user_management";
	private static final String insert="insert into user_management(User_name, User_email, User_mobile, User_password, User_address, User_gender) values(?,?,?,?,?,?)";
	public boolean chechEmailAlreadyExists(String email)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(check_email_already_exists);
			preparedStatement.setString(1, email);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkMobileNumberAlreadyExists(long mobile)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(check_mobile_number_already_exists);
			preparedStatement.setLong(1, mobile);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkPasswordAlreadyExists(String password)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(check_password_already_exists);
			preparedStatement.setString(1, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean insertUserDetails(user_Details userdetails)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			preparedStatement.setString(1, userdetails.getName());
			preparedStatement.setString(2, userdetails.getEmail());
			preparedStatement.setLong(3, userdetails.getMobile());
			preparedStatement.setString(4, userdetails.getPassword());
			preparedStatement.setString(5, userdetails.getAddress());
			preparedStatement.setString(6, userdetails.getGender());
			int result=preparedStatement.executeUpdate();
			if(result>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean updatePasswordByUserEmail(String password,String email)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(updatepassword);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, email);
			int result=preparedStatement.executeUpdate();
			if (result>0) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean updatemobileByUserEmail(long mobile,String email)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(updatemobile);
			preparedStatement.setLong(1, mobile);
			preparedStatement.setString(2, email);
			int result=preparedStatement.executeUpdate();
			if (result>0) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteUserDetailsByEmail(String email,String password)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(delete);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			int result=preparedStatement.executeUpdate();
			if (result>0) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean selectUserDetails()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(select);
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("User ID:"+resultSet.getInt("User_ID"));
				System.out.println("UserName:"+resultSet.getString("User_name"));
				System.out.println("User Email Id:"+resultSet.getString("User_email"));
				String num=String.valueOf(resultSet.getLong("User_mobile"));
				String no="";
				for(int i=0;i<=num.length()-1;i++)
				{
					if(i==0||i==1||i==7||i==8||i==9)
					{
						no+=num.charAt(i);
					}
					else {
						no+="*";
					}
				}
				System.out.println("User Mobile Number:"+no);
				
				System.out.println("User Address:"+resultSet.getString("User_address"));
				System.out.println("User Gender:"+resultSet.getString("User_gender"));
				System.out.println("****____****_____****____****");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
