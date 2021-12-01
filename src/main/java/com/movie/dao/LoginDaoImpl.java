package com.movie.dao;

import java.sql.*;

import com.movie.util.DBConnectivity;

public class LoginDaoImpl implements LoginDAO {
	Connection con = null;
	PreparedStatement ps = null;
	String sql = null;
	ResultSet rs = null;

	@Override
	public boolean checkAdmin(String username, String password) {
		con = DBConnectivity.getConnection();
		sql = "Select * from admin where adEmail=? and adPassword=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean checkCustomer(String username, String password) {
		con = DBConnectivity.getConnection();
		sql = "Select * from customer where email=? and password=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				con.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean changeAdminPassword(String username, String oldPassword, String newPassword) {

		return false;
	}

	@Override
	public boolean changeCustomerPassword(String username, String oldPassword, String newPassword) {

		return false;
	}

}
