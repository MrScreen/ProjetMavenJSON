package com.monapp.model;

public class Car {
	private int id;
	private String immat;
	private String model;
	private String color;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImmat() {
		return immat;
	}

	public void setImmat(String immat) {
		this.immat = immat;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	public Car()
	{
		
	}

	public Car(int id, String immat, String model, String color) {
		
		this.id = id;
		this.immat = immat;
		this.model = model;
		this.color = color;
	}
	
	
}
