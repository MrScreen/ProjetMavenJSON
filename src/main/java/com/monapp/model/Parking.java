package com.monapp.model;


import java.util.ArrayList;
import java.util.List;

public class Parking  {
	

	private int id;
	private String name;
	private List<Car> cars = new ArrayList<>();
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	public Parking()
	{
		
	}
	public Parking(int id, String name, List<Car> cars) {
		
		this.id = id;
		this.name = name;
		this.cars = cars;
	}
	public Parking(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void addCar(Car c) {
		this.cars.add(c);
	}
}