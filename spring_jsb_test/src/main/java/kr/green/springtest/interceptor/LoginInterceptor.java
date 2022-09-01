package kr.green.springtest.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.springtest.service.MemberService;
import kr.green.springtest.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	MemberService memberService;
	
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
	    ModelMap modelMap = modelAndView.getModelMap();
	    MemberVO user = (MemberVO)modelMap.get("user");
	    //MemberVO user = (MemberVO)modelAndView.getModelMap().get("user"); --> 위에 코드 두 줄 한 줄로 쓴 것

	    if(user != null) {
	        HttpSession session = request.getSession();
	        session.setAttribute("user", user);
	        //request.getSession().setAttribute("user", user); --> 위에 코드 두 줄 한 줄로 쓴 것
	        if(user.isAutoLogin()) {
	        	Cookie loginCookie = new Cookie("loginCookie", session.getId());
	        	loginCookie.setPath("/");
	        	int second = 60 * 60 * 24 * 7; //7일을 초로 환산
	        	loginCookie.setMaxAge(second);//쿠키 유지시간
	        	response.addCookie(loginCookie);
	        	//DB에 저장(아이디, 세션 아이디, 만료시간)
	        	Date session_limit = new Date(System.currentTimeMillis() + second * 1000);
	        	memberService.updateMemberSession(user.getMe_id(), session.getId(), session_limit); 
	        }
	    }
	}
}
