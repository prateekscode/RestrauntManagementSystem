package com.prateeks.dao;

import java.sql.*;

import com.prateeks.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean isValidUser(String username, String password) {
		String query = "SELECT * FROM users WHERE username = ? AND password = ?";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();

			System.out.println("Query running");

			return resultSet.next();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addUser(User user) {
		String query = "INSERT into users (username, email, password, dob, mobile, type) VALUES(?, ?, ?, ?, ?, ?)";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getDob());
			preparedStatement.setString(5, user.getMobile());
			preparedStatement.setString(6, user.getType());

			int rows = preparedStatement.executeUpdate();
			System.out.println("User Added");
			return rows > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String getUserType(String username, String password) {
		String userType = null;
		String query = "SELECT type from users WHERE username=? AND password=?";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					userType = resultSet.getString("type");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace(); // Handle or log the exception appropriately
		}

		return userType;
	}

}
