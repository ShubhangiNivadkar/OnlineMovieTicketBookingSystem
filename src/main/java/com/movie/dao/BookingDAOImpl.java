package com.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.movie.pojo.Booking;
import com.movie.util.DBConnectivity;

public class BookingDAOImpl implements BookingDAO {

	Connection con = null;
	PreparedStatement ps = null, ps2 = null;
	ResultSet rs = null;
	String sql = null, sql2 = null;
	Booking b = null;
	List<Booking> blist = null;

	@Override
	public Booking bookMyShow(Booking b) {
		con = DBConnectivity.getConnection();
		sql = "insert into  booking(showId, custEmail, bookingDate, seat, totalBill) values(?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, b.getShowId());
			ps.setString(2, b.getCustEmail());

			DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String bookingDate = LocalDateTime.now().format(pattern);

			ps.setTimestamp(3, Timestamp.valueOf(bookingDate));

			ps.setString(4, b.getSeat());

			/*
			 * double price = new ShowDAOImpl().getShowById(b.getShowId()).getPrice(); int
			 * noOfSeats = b.getSeat().split(",").length;
			 * 
			 * double totalBill = price * noOfSeats;
			 */

			ps.setDouble(5, b.getTotalBill());

			int i = ps.executeUpdate();

			if (i > 0) {
				sql2 = "select * from booking where custEmail=? and bookingDate=?";
				ps2 = con.prepareStatement(sql2);

				ps2.setString(1, b.getCustEmail());
				ps2.setTimestamp(2, Timestamp.valueOf(bookingDate));

				rs = ps2.executeQuery();

				while (rs.next()) {
					b = new Booking();
					b.setBookingId(rs.getInt(1));
					b.setShowId(rs.getInt(2));
					b.setCustEmail(rs.getString(3));
					b.setBookingDate(rs.getTimestamp(4).toLocalDateTime());
					b.setSeat(rs.getString(5));
					b.setTotalBill(rs.getDouble(6));
					b.setS(new ShowDAOImpl().getShowById(rs.getInt(2)));

					return b;
				}
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
		return null;
	}

	@Override
	public boolean cancelBooking(int bookingId) {
		con = DBConnectivity.getConnection();
		sql = "delete from booking where bookingId=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bookingId);

			int i = ps.executeUpdate();

			if (i > 0)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Booking getBookingById(int bookingId) {
		con = DBConnectivity.getConnection();
		sql = "select * from booking where bookingId=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bookingId);

			rs = ps.executeQuery();

			while (rs.next()) {
				b = new Booking();
				b.setBookingId(rs.getInt(1));
				b.setShowId(rs.getInt(2));
				b.setCustEmail(rs.getString(3));
				b.setBookingDate(rs.getTimestamp(4).toLocalDateTime());
				b.setSeat(rs.getString(5));
				b.setTotalBill(rs.getDouble(6));
				b.setS(new ShowDAOImpl().getShowById(rs.getInt(2)));

				return b;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Booking> getMyBookings(String custEmail) {
		con = DBConnectivity.getConnection();
		sql = "select * from booking where custEmail=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, custEmail);

			rs = ps.executeQuery();
			blist = new ArrayList<>();

			while (rs.next()) {
				b = new Booking();
				b.setBookingId(rs.getInt(1));
				b.setShowId(rs.getInt(2));
				b.setCustEmail(rs.getString(3));
				b.setBookingDate(rs.getTimestamp(4).toLocalDateTime());
				b.setSeat(rs.getString(5));
				b.setTotalBill(rs.getDouble(6));
				b.setS(new ShowDAOImpl().getShowById(rs.getInt(2)));

				blist.add(b);
			}

			return blist;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Booking> getAllBookings() {
		con = DBConnectivity.getConnection();
		sql = "select * from booking";

		try {
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			blist = new ArrayList<>();

			while (rs.next()) {
				b = new Booking();
				b.setBookingId(rs.getInt(1));
				b.setShowId(rs.getInt(2));
				b.setCustEmail(rs.getString(3));
				b.setBookingDate(rs.getTimestamp(4).toLocalDateTime());
				b.setSeat(rs.getString(5));
				b.setTotalBill(rs.getDouble(6));
				b.setS(new ShowDAOImpl().getShowById(rs.getInt(2)));

				blist.add(b);
			}
			return blist;
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
		return null;
	}

	public List<String> reservedSeats(int showId) {
		con = DBConnectivity.getConnection();
		sql = "select seat from booking where showId=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, showId);

			rs = ps.executeQuery();
			List<String> bookedSeats = new ArrayList<>();

			while (rs.next()) {
				String s = rs.getString(1);
				String[] arr = s.split(", ");

				for (String seat : arr)
					bookedSeats.add(seat);
			}
			return bookedSeats;

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

		return null;
	}

}
