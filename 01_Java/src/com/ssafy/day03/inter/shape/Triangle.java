package com.ssafy.day03.inter.shape;

public class Triangle implements IShape {

	private double base;
	private double height;
	
	public Triangle() {
		
	}
	
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		return base * height / 2;
	}

	@Override
	public double getCircuit() {
		return Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2)) + base + height;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
}
