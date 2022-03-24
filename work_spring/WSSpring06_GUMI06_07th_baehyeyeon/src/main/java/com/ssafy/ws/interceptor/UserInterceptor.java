package com.ssafy.ws.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class UserInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Cookie[] cookies = request.getCookies();
		String userId = null;
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("loginId")) {
				userId = cookie.getValue();
				System.out.println("쿠키 정보 출력: "+cookie.getName()+" : "+userId);
				break;
			}
		}
				if(request.getRequestURI().startsWith("ws/api/board") && userId == null) { //로그인 정보가 없는데 board에 접근을 할 경우
					response.sendError(HttpStatus.UNAUTHORIZED.value());
					return false;
				}
		return true;
	}
}
