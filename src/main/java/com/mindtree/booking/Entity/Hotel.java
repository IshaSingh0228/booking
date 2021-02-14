package com.mindtree.booking.Entity;
import java.util.ArrayList;
import java.util.List;
public class Hotel {
private int hostelId;
private String city;
private String name;
private List<Room> room;
public Hotel() {
	super();
}
public Hotel(int hostelId, String city, String name,List<Room> room) {
	super();
	this.hostelId = hostelId;
	this.city = city;
	this.name = name;
	this.room=room;
}
public List<Room> getRoom() {
	List<Room> r=new ArrayList<Room>();
	r=this.room;
	return r;
}
public void setRoom(List<Room> room) {
	List<Room> r=new ArrayList<Room>();
	r=room;
	this.room = r;
}
public int getHostelId() {
	return hostelId;
}
public void setHostelId(int hostelId) {
	this.hostelId = hostelId;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


}
