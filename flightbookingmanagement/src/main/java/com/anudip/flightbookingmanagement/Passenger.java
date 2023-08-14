package com.anudip.flightbookingmanagement;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
    
public class Passenger {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    int passengerId;

	    String name;
	    int age;

	    @ManyToOne
	    @JoinColumn(name = "flight_id")
	    private Flight flight;

	    // Constructors, getters, and setters

	    public int getPassengerId() {
	        return passengerId;
	    }

	    public void setPassengerId(int passengerId) {
	        this.passengerId = passengerId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    public Flight getFlight() {
	        return flight;
	    }

	    public void setFlight(Flight flight) {
	        this.flight = flight;
	    }

		@Override
		public String toString() {
			return "Passenger [passengerId=" + passengerId + ", name=" + name + ", age=" + age + ", flight=" + flight
					+ "]";
		}

		
	}
	
