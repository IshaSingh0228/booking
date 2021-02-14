package com.mindtree.booking.dao;

import java.util.List;

import com.mindtree.booking.Entity.Hotel;
import com.mindtree.booking.Entity.Room;
import com.mindtree.booking.exception.daoException.HotelDaoException;

public interface HotelDao {
boolean insertHotelInDB(Hotel hotel) throws HotelDaoException;
List<Room> displayAllHotelByCity(String city) throws HotelDaoException;
}
