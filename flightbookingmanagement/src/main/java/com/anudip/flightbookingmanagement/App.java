package com.anudip.flightbookingmanagement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;
import java.sql.Date;
/**
 * Hello world!
 *
 */
public class App 
{
	
public static void main( String[] args )
   {
    Scanner s=new Scanner(System.in);
    System.out.println("enter detail want to add 1 for flight and"
    			+ " 2 for passenger"
    			+ "3 for booking ticket=");
    int det=s.nextInt();
    if(det == 1)
    {
    	System.out.println("enter operation perform on flight "
    			+ "1 for adding flight"
    			+ "2 for retrieve flight=");
    	int fly=s.nextInt();
    	if(fly==1)
    	{
    	flight();
    	}
    	else if(fly==2)
    	{
    		flightretrieve();
    	}
    	else
    	{
    		booking();
    	}
   	}
    else
    {
    	System.out.println("enter operation perform on passenger "
    			+ "1 for adding passenger"
    			+ "2 for retrieve passenger"
    			+ "3 for update passenger"
    			+ "4 for delete passenger=");
    	int op=s.nextInt();
    	if(op==1)
    	{
    		passenger();
    	}
    	else if (op==2)
    	{
    		passengeretrieve();
    	}
    	else if(op==3)
    	{
    		passengerupdate();
    	}
    	else
    	{
    		passengerdelete();
    	}
    	
    }
    
}



public static void flight()
    {   
	Configuration conf = new Configuration().configure();
	SessionFactory a= conf.buildSessionFactory(); 
	Session session = a.openSession();
   Transaction transaction = session.beginTransaction();
	
     // Create a Flight object
        Scanner s=new Scanner(System.in);
    	Flight a1=new Flight();
    	System.out.println("enter Airline=");
    	String air=s.nextLine();
    	a1.setAirline(air);
    	System.out.println("enter source=");
    	String source=s.nextLine();
    	a1.setSource(source);
    	System.out.println("enter Destination=");
    	String destination=s.nextLine();
    	a1.setDestination(destination);
    	System.out.println("enter DepartureTime=");
    	String DepartureTime=s.nextLine();
    	a1.setDepartureTime(DepartureTime);
    	System.out.println("enter ArrivalTime=");
    	String ArrivalTime=s.nextLine();
    	a1.setArrivalTime(ArrivalTime);
    	System.out.println("enter Duration=");
    	int Duration=s.nextInt();
    	a1.setDuration(Duration);
    	System.out.println("enter Capacity=");
    	int Capacity=s.nextInt();
    	a1.setCapacity(Capacity);
    	
    	session.save(a1);
    	transaction.commit();
    	session.close();
    	a.close();
    
	
    }
public static void flightretrieve()
{
	Configuration conf = new Configuration().configure().addAnnotatedClass(Flight.class);
	SessionFactory a= conf.buildSessionFactory(); 
	Session session = a.openSession();
    Transaction transaction = session.beginTransaction();
// Retrieve all passengers from the database
List<Flight> flight = session.createQuery("FROM Flight", Flight.class).list();

for (Flight fli : flight) 
{
	System.out.println("Flight Id: " + fli.getFlightId());
	System.out.println("flight airline : " + fli.getAirline());
	System.out.println("Source: " + fli.getSource());
	System.out.println("Destination: " + fli.getDestination());
	System.out.println("DepartureTime: " + fli.getDepartureTime());
	System.out.println("ArrivalTime: " + fli.getArrivalTime());
	System.out.println("Duration: " + fli.getDuration());
	System.out.println("Capacity: " + fli.getCapacity());
	System.out.println();
}
transaction.commit();
session.close();
a.close();

}

/*public static void flightupdate()
{
	Configuration conf = new Configuration().configure().addAnnotatedClass(Flight.class);
	SessionFactory a= conf.buildSessionFactory(); 
	Session session = a.openSession();
    Transaction transaction = session.beginTransaction();
	Scanner s2=new Scanner(System.in);
	System.out.println("Enter flight id to retrieve:");
	int i=s2.nextInt();
	
	Flight fli=session.get(Flight.class,i);
	System.out.println("Flight Id: " + fli.getFlightId());
	System.out.println("flight airline : " + fli.getAirline());
	System.out.println("Source: " + fli.getSource());
	System.out.println("Destination: " + fli.getDestination());
	System.out.println("DepartureTime: " + fli.getDepartureTime());
	System.out.println("ArrivalTime: " + fli.getArrivalTime());
	System.out.println("Duration: " + fli.getDuration());
	System.out.println("Capacity: " + fli.getCapacity());
	System.out.println();
	System.out.println("What you want to update=:");
	String up=s2.nextLine();
	
	
	transaction.commit();
	session.close();
	a.close();
}*/


public static void passenger()
    {
    	Passenger passenger1=new Passenger();
    	Configuration conf = new Configuration().configure().addAnnotatedClass(Flight.class);
    	SessionFactory a= conf.buildSessionFactory(); 
    	Session session = a.openSession();
        Transaction transaction = session.beginTransaction();
    	Scanner s1=new Scanner(System.in);
    	
    	System.out.println("Enter passenger name:");
    	String Name = s1.nextLine();
    	passenger1.setName(Name);

    	System.out.println("Enter passenger age:");
    	int Age = s1.nextInt();
    	passenger1.setAge(Age);
    	
    	System.out.println("Enter Flight ID:");
        int flightId = s1.nextInt();
        Flight flight = session.get(Flight.class, flightId);
        passenger1.setFlight(flight);
        
    	session.save(passenger1);
    	transaction.commit();
    	session.close();
    	a.close();	
     } 
      
public static void passengeretrieve()
{
    	Configuration conf = new Configuration().configure().addAnnotatedClass(Flight.class);
    	SessionFactory a= conf.buildSessionFactory(); 
    	Session session = a.openSession();
        Transaction transaction = session.beginTransaction();
	// Retrieve all passengers from the database
	List<Passenger> passengers = session.createQuery("FROM Passenger", Passenger.class).list();

	for (Passenger passenger : passengers) 
	{
		System.out.println("Passenger name: " + passenger.getName());
		System.out.println("Passenger Id: " + passenger.getPassengerId());
		System.out.println("Flight: " + passenger.getFlight());
		System.out.println();
	}
	transaction.commit();
	session.close();
	a.close();
}
 
//Update the retrieved passenger's name

public static void passengerupdate()
    {
    	Configuration conf = new Configuration().configure().addAnnotatedClass(Flight.class);
    	SessionFactory a= conf.buildSessionFactory(); 
    	Session session = a.openSession();
        Transaction transaction = session.beginTransaction();
    	Scanner s2=new Scanner(System.in);
    	System.out.println("Enter passenger id:");
    	int i=s2.nextInt();
    	Passenger retrievedPassenger = session.get(Passenger.class, i);
    	System.out.println("Retrieved passenger: " + retrievedPassenger.getName());
		System.out.println("Enter new name for the passenger:");
		String newname = s2.nextLine();
		retrievedPassenger.setName(newname);
		session.update(retrievedPassenger);
    	transaction.commit();
    	session.close();
    	a.close();

    }
public static void passengerdelete()
{
	Configuration conf = new Configuration().configure().addAnnotatedClass(Flight.class);
	SessionFactory a= conf.buildSessionFactory(); 
	Session session = a.openSession();
    Transaction transaction = session.beginTransaction();
	Scanner s3=new Scanner(System.in);
	System.out.println("Enter passenger id:");
	int i=s3.nextInt();
	Passenger retrievedPassenger = session.get(Passenger.class, i);
	System.out.println("Retrieved passenger: " + retrievedPassenger.getName()+retrievedPassenger.getAge());
	// Delete the passenger from the database
	session.delete(retrievedPassenger);
	transaction.commit();
	session.close();
	a.close();

}

public static void booking()
{
	Configuration conf = new Configuration().configure();
	SessionFactory a= conf.buildSessionFactory(); 
	Session session = a.openSession();
    Transaction transaction = session.beginTransaction();
    try {
        // Create and save a new booking
        Booking booking = new Booking();
        
        // Assuming you have Flight and Passenger objects available
        Scanner s3=new Scanner(System.in);
    	System.out.println("Enter flight id:");
    	int fid=s3.nextInt();
    	Flight flight = session.get(Flight.class, fid);
        booking.setFlight(flight);

        System.out.println("Enter passenger id:");
    	int pid=s3.nextInt();
    	Passenger passenger1 = session.get(Passenger.class, pid);
        booking.setPassenger(passenger1);

        // Set booking details
        booking.setFlight(flight);
        booking.setPassenger(passenger1);
        booking.setBookingDate(new Date(System.currentTimeMillis()));
        booking.setStatus("Confirmed");
       
        booking.setSeatNumber("A1");

        // Save the booking
        session.save(booking);

        // Commit the transaction
        transaction.commit();

        System.out.println("Booking saved successfully!");

        // Retrieve flight ID, source, and departure details
        List<Booking> bookings = session.createQuery("FROM Booking", Booking.class).list();
        for (Booking b : bookings) {
        	System.out.println("Passenger Name: " + b.getPassenger().getName());
        	System.out.println("Passenger Id: " + b.getPassenger().getPassengerId());
        	System.out.println("Flight ID: " + b.getFlight().getFlightId());
            System.out.println("Source: " + b.getFlight().getSource());
            System.out.println("Destination: " + b.getFlight().getDestination());
            System.out.println("Departure: " + b.getFlight().getDepartureTime());
            System.out.println("Arrival: " + b.getFlight().getArrivalTime());
            System.out.println("Booking date: " + b.getBookingDate());
        }
    } catch (Exception e) {
        e.printStackTrace();
        transaction.rollback();
    } finally {
        // Close the session and session factory
        session.close();
        a.close();
    }
}
}

	
