package com.anudip.flightbookingmanagement;

import javax.persistence.*;
@Entity
@Table(name="Flight")
public class Flight {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int flightId;
    String airline;
    String source;
    String destination;
    String departureTime;
    String arrivalTime;
    int duration;
    int capacity;    
    
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Object getAirline() {
		// TODO Auto-generated method stub
		return airline;
	}

	public Object getSource() {
		// TODO Auto-generated method stub
		return source;
	}

	public Object getDestination() {
		// TODO Auto-generated method stub
		return destination;
	}

	public int getFlightId() {
		return flightId;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public int getDuration() {
		return duration;
	}

	public int getCapacity() {
		return capacity;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", airline=" + airline + ", source=" + source + ", destination="
				+ destination + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", duration="
				+ duration + ", capacity=" + capacity + "]";
	}

	
}	

