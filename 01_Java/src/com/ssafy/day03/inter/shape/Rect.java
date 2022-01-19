package com.ssafy.day03.inter.shape;

public class Rect implements IShape {

	private double width;
	private double height;
	
	public Rect() {
		
	}
	
	public Rect(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getCircuit() {
		return (width + height) * 2;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}
