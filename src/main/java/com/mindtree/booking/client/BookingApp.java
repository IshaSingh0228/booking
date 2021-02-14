package com.mindtree.booking.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.booking.Entity.Hotel;
import com.mindtree.booking.Entity.Room;
import com.mindtree.booking.exception.serviceException.HotelServiceException;
import com.mindtree.booking.service.HotelService;
import com.mindtree.booking.service.serviceImpl.HotelServiceImpl;

public class BookingApp 
{
	 private static Scanner sc=new Scanner(System.in);
	 private static HotelService hotelService=new HotelServiceImpl();
    public static void main( String[] args )
    {
     do {
      System.out.print("1.Create hotel\n"
      		+ "2.Display room based on city\n"
      		+ "3.Exit\n");
      System.out.println("enter your option");
      int choice=sc.nextInt();
      switch(choice) {
      case 1:boolean isInserted=false;
    		  Hotel hotel=getCreateHostel();
    		  try {
  				isInserted = hotelService.insertHotelInDB(hotel);
  			} catch (HotelServiceException e) {
  				System.out.println(e);
  			}
  			if (isInserted) {
  				System.out.println("Inserted into db successfully");
  			} else
  				System.out.println("Something went wrong...");
    	  break;
      case 2:List<Room> hotelCity=new ArrayList<Room>();
      sc.nextLine();
      System.out.println("Enter the city");
      String city=sc.nextLine();
      try {
			hotelCity = hotelService.displayHotelBasedOnCity(city);
		} catch (HotelServiceException e) {
			e.printStackTrace();
		}
		displayHotel(hotelCity);
    	  break;
      case 3:return;
      default:System.out.println("invalid option!");
      }
      
     }while(true);  
    }
	private static void displayHotel(List<Room> hotelCity) {
		// TODO Auto-generated method stub
		System.out.println("hotelNo\t"+"roomNo\t"+"type\t"+"cost");
			for(Room r:hotelCity) {
				System.out.println(r.getHotel()+"\t"+r.getRoomNo()+"\t "+r.getType()+"\t"+r.getCost());
			}
			System.out.println();
		}
	
	private static Hotel getCreateHostel() {
		System.out.print("Enter hotel id");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("enter city");
		String city=sc.nextLine();
		sc.nextLine();
		System.out.println("enter name");
		String name=sc.nextLine();
		System.out.println("Enter total no.room of rooms");
		int noRoom=sc.nextInt();
		List<Room> room=new ArrayList<Room>();
		for(int i=1;i<=noRoom;i++) {
		System.out.println("enter roomNo for room "+i);
		int roomNo=sc.nextInt();
		sc.nextLine();
		System.out.println("enter type");
		String type=sc.nextLine();
		System.out.println("enter cost");
		double cost=sc.nextDouble();
		Room newRoom=new Room(roomNo,type,cost,id);
		room.add(newRoom);
		}
		Hotel hotel=new Hotel(id,city,name,room);
		return hotel;
	}
	
}
