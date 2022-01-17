package com.ssafy.ws01.step3;

import java.util.Scanner;

public class GameTest {

	
	//1 가위 2 주먹 3 보
	public static void main(String[] args) {
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("번호를 입력하세요. ");
		int num = sc.nextInt();
		String temp;
		int com=0;
		int person=0;
		int winPer=0,winCom=0,same=0;
		if(num==1) {
			for(int i=0;i<5;i++) {
				
				com = (int) (Math.random() * 3) +1 ;
				System.out.println(com);
				System.out.print("가위바위보 중 하나 입력: ");
				temp=sc.next();
				//System.out.println(temp);
				switch(temp){
                case "가위":
                    person = 1;
                    break;
                case "바위":
                    person = 2;
                    break;
                case "보":
                    person = 3;
                    break;
            }

				System.out.println(person);
				if(com==person) {
					System.out.println("비겼습니다!!!");
					same++;
				}
				else if((com==1&&person==2)||(com==2&&person==3)||(com==3&&person==1)) {
					System.out.println("이겼습니다!!!");
					winPer++;
				}
				else {
					System.out.println("졌습니다!!!");
					winCom++;
				}
				
			if(winPer==3) {
				System.out.println("### 내가 이김!!!");	
				break;
			}
			if(winCom==3) {
				System.out.println("### 컴퓨터 승!!!");
				break;
			}
			if(same==3||(winPer==2&&winCom==2)) {
				System.out.println("### 무승부, 게임 끝!!");
				break;
			}
			
		}
			
		}
		if(num==2) {
			for(int i=0;i<3;i++) {
			
			com = (int) (Math.random() * 3) +1 ;
			//System.out.println(com);
			System.out.print("가위바위보 중 하나 입력: ");
			temp=sc.next();
			//System.out.println(temp);
			switch(temp){
            case "가위":
                person = 1;
                break;
            case "바위":
                person = 2;
                break;
            case "보":
                person = 3;
                break;
        }

			//System.out.println(person);
			if(com==person) {
				System.out.println("비겼습니다!!!");
				same++;
			}
			else if((com==1&&person==2)||(com==2&&person==3)||(com==3&&person==1)) {
				System.out.println("이겼습니다!!!");
				winPer++;
			}
			else {
				System.out.println("졌습니다!!!");
				winCom++;
			}
		if(winPer==2) {
			System.out.println("### 내가 이김!!!");	
			break;
		}
		if(winCom==2) {
			System.out.println("### 컴퓨터 승!!!");
			break;
		}
		if(same==2) {
			System.out.println("### 무승부, 게임 끝!!");
			break;
		}
		
		}
			}
	
		if(num==3) {
				
				com = (int) (Math.random() * 3) +1 ;
				//System.out.println(com);
				System.out.print("가위바위보 중 하나 입력: ");
				temp=sc.next();
				//System.out.println(temp);
				switch(temp){
	            case "가위":
	                person = 1;
	                break;
	            case "바위":
	                person = 2;
	                break;
	            case "보":
	                person = 3;
	                break;
	        }

				//System.out.println(person);
				if(com==person) {
					System.out.println("비겼습니다!!!");
					System.out.println("### 무승부, 게임 끝!!");
				}
				else if((com==1&&person==2)||(com==2&&person==3)||(com==3&&person==1)) {
					System.out.println("이겼습니다!!!");
					System.out.println("### 내가 이김!!!");
				}
				else {
					System.out.println("졌습니다!!!");
					System.out.println("### 컴퓨터 승!!!");

				}
			
		}
		sc.close();
	}

}

