package com.mindtree.booking.service.serviceImpl;

import java.util.List;

import com.mindtree.booking.Entity.Hotel;
import com.mindtree.booking.Entity.Room;
import com.mindtree.booking.dao.HotelDao;
import com.mindtree.booking.dao.daoImpl.HotelDaoImpl;
import com.mindtree.booking.exception.daoException.HotelDaoException;
import com.mindtree.booking.exception.serviceException.HotelServiceException;
import com.mindtree.booking.service.HotelService;


public class HotelServiceImpl implements HotelService {
	private static HotelDao hotelDao = new  HotelDaoImpl();
	public boolean insertHotelInDB(Hotel hotel) throws HotelServiceException {
	
		try {
			return hotelDao.insertHotelInDB(hotel);
		} catch (HotelDaoException e) {
			throw new HotelServiceException("Something went wrong in db", e);
		}
	}

	public List<Room> displayHotelBasedOnCity(String city) throws HotelServiceException {
		try {
			return hotelDao.displayAllHotelByCity(city);
		}catch(HotelDaoException e) {
			throw new HotelServiceException(e);
		}
	}
	

}
