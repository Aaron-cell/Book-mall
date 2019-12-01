package com.book.portal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.book.pojo.TbUser;

public class LoginInterceptor implements HandlerInterceptor {
	/*
	 * 在handler执行之前处理
	 * 返回值决定handler是否执行。true执行 false表示不执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String nickname = (String) session.getAttribute("nickname");
		if(nickname==null || "null".equals(nickname)) {
			response.sendRedirect("/login?redictURL="+request.getRequestURI());
			return false;
		}
		//重置session时间
		session.setAttribute("nickname", nickname);
		return true;
	}
	
	/*
	 * 在handler处理之后 返回model之前处理
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * 在所有完成之后处理
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
