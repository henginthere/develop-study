package com.ssafy.day03.inter.shape;

public class TestShape {

	public static void main(String[] args) {
		IShape[] shapes = new IShape[3];
		
		shapes[0] = new Circle(6);
		shapes[1] = new Rect(7, 8);
		shapes[2] = new Triangle(4, 5);
		
		for (IShape shape:shapes) {
//			if (shape instanceof Circle) {
//				System.out.println("*****원*****");
//			}
//			else if (shape instanceof Rect) {
//				System.out.println("*****사각형*****");
//			}
//			else if (shape instanceof Triangle) {
//				System.out.println("*****삼각형*****");
//			}
			System.out.println(shape.getClass().getSimpleName());
			System.out.println("넓이 : " + shape.getArea());
			System.out.println("둘레 : " + shape.getCircuit());
			System.out.println();
		}
	}

}
