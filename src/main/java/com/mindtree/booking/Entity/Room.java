package com.mindtree.booking.Entity;

public class Room {
private int roomNo;
private String type;
private double cost;
private int hotelId;
public Room() {
	super();
}
public Room(int roomNo, String type, double cost,int hotel) {
	super();
	this.roomNo = roomNo;
	this.type = type;
	this.cost = cost;
	this.hotelId=hotel;
}

public int getHotel() {
	return hotelId;
}
public void setHotel(int hotel) {
	this.hotelId = hotel;
}
public int getRoomNo() {
	return roomNo;
}
public void setRoomNo(int roomNo) {
	this.roomNo = roomNo;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}

}
