package com.mindtree.booking.dao.daoImpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.booking.Entity.Hotel;
import com.mindtree.booking.Entity.Room;
import com.mindtree.booking.dao.HotelDao;
import com.mindtree.booking.dbUtil.DBUtil;
import com.mindtree.booking.exception.daoException.CityNotFoundException;
import com.mindtree.booking.exception.daoException.DatbaseConnectionFailedException;
import com.mindtree.booking.exception.daoException.HotelDaoException;

public class HotelDaoImpl implements HotelDao {
	private DBUtil dbUtil = new DBUtil();

	public boolean insertHotelInDB(Hotel hotel) throws HotelDaoException {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		try {
			con = dbUtil.getConnection();
			List<Room> roomList=new ArrayList<Room>();
			roomList=hotel.getRoom();
			//int id=hotel.getHostelId();
			String sql = "insert into hotel values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, hotel.getHostelId());
			ps.setString(2,hotel.getCity());
			ps.setString(3, hotel.getName());
			ps.executeUpdate();
			System.out.println("updated");
			for(Room r:roomList) {
			String sql1 = "insert into room values(?,?,?,?)";
			ps1 = con.prepareStatement(sql1);
			ps1.setInt(1, hotel.getHostelId());
			ps1.setInt(2,r.getRoomNo());
			ps1.setString(3,r.getType());
			ps1.setDouble(4,r.getCost());
			int rs=ps1.executeUpdate();
			isInserted = true;
			if (rs == 0) {
				isInserted = false;
			} 
			}		

		} catch (DatbaseConnectionFailedException e) {
			System.out.println(e);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeConnection(con);
			dbUtil.closeConnection(ps);
			dbUtil.closeConnection(ps1);
		}
		
		return isInserted;
	}

	public List<Room> displayAllHotelByCity(String city) throws HotelDaoException {
		//List<Hotel> addHotel = new ArrayList<Hotel>();
		List<Room> addRoom=new ArrayList<Room>();
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		try {
			con = dbUtil.getConnection();
			//
			String sql = "select * from hotel inner join room on room.hotelId=hotel.hotelId where city=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, city);
			rs = ps.executeQuery();
			while (rs.next()) {
				Room room = new Room(rs.getInt("roomNo"), rs.getString("roomType"), rs.getDouble("cost"),rs.getInt("hotelId"));
				addRoom.add(room);
			}
			
			
			//--
		/*
			for(Room r:addRoom) {
			
			String sq="select * from room where hotelId=?";
			ps=con.prepareStatement(sq);
			ps.setInt(1,r.getHotel());
			ResultSet rs1=ps.executeQuery();
			while(rs1.next()==true) {
				Room room = new Room(rs.getInt("roomNo"), rs1.getString("roomType"), rs1.getDouble("cost"),rs1.getInt("hotelId"));
			addRoom.add(room);
			}
			String sq1="select * from hotel where hotelId=?";
			 ps2=con.prepareStatement(sq1);
			 rs2=ps.executeQuery();
			rs2.next();
				Hotel hotel=new Hotel(rs2.getInt("hotelId"),rs2.getString("city"),rs2.getString("hotelName"),addRoom);
				addHotel.add(hotel);
			
			}
			//--*/
			dbUtil.closeConnection(rs2);
			dbUtil.closeConnection(ps2);
			dbUtil.closeConnection(rs);
			dbUtil.closeConnection(ps);
			
		} catch (DatbaseConnectionFailedException e) {
			System.out.println(e);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeConnection(con);
			dbUtil.closeConnection(ps);
			

		}
		if (addRoom.isEmpty() == true) {
			try {
				throw new CityNotFoundException("No city is there");
			} catch (CityNotFoundException e) {
				System.out.println(e);
			}
		}
		return addRoom;

	}

}
