package com.ssafy.day01.ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class WebServer {

	private static final int PORT = 10001;
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		while(true) {
			try {
				// 클라이언트 요청을 받을 서버 소켓 생성
				serverSocket = new ServerSocket(PORT);
				System.out.println("서버 실행 중... 포트번호는 "+PORT);
				
				//클라이언트 요청 대기
				socket = serverSocket.accept(); //클라이언트 접속할 때까지 대기
				System.out.println("클라이언트 접속 ...");
				
				//데이터 주고받기 위해 File I/O 객체 생성
				br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //서버로부터 전달 받은 내용
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); //클라이언트에서 작성한 내용 서버로 전달
				
				// 클라이언트로부터 요청 받기
				String line = br.readLine();
				if(line!=null) {
					
					//요청받은 내용 분석
					StringTokenizer tokenizer = new StringTokenizer(line);
					String method = tokenizer.nextToken();
					String url = tokenizer.nextToken();
					String ver = tokenizer.nextToken();
					
					//내용 출력해보기
					System.out.println("method: "+method);
					System.out.println("url: "+url);
					System.out.println("ver: "+ver);
					
					if("GET".equals(method)) {
						switch(url) {
						case "/":
							// 응답 헤더 작성
							bw.write("HTTP/1.1 200 OK/r/n"); //200은 현재 응답이 정상 응답이라는 뜻
							bw.write("Server:MyWebServer/r/n");
							bw.write("Content=Type: text/html/r/n");
							bw.write("/r/n");
							
							//응답 Body 작성
							bw.write("<h1>Welcome to MyServer!</h1>");
							bw.flush(); //버퍼에 남아있는 내용 싹 다 보내주기
							break;
									
						}
					}
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					br.close();
					bw.close();
					
					socket.close();
					serverSocket.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
