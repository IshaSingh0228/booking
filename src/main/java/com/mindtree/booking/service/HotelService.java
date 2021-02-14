package com.mindtree.booking.service;

import java.util.List;

import com.mindtree.booking.Entity.Hotel;
import com.mindtree.booking.Entity.Room;
import com.mindtree.booking.exception.serviceException.HotelServiceException;

public interface HotelService {
boolean insertHotelInDB(Hotel hotel) throws HotelServiceException;
List<Room> displayHotelBasedOnCity(String city) throws HotelServiceException;
}
