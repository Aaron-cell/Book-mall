package com.book.portal.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.common.pojo.BookResult;
import com.book.common.utils.MailUtils;
import com.book.common.utils.Md5;
import com.book.pojo.TbUser;
import com.book.portal.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * 用户登录
	 * @Title: login
	 * @Function: TODO
	 * @Param: @param request
	 * @Param: @param response
	 * @Param: @return
	 * @Param: @throws ServletException
	 * @Param: @throws IOException
	 * @return: String
	 * @throws:
	 */
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	@ResponseBody
	public BookResult login(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//获取账号密码验证码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String veriCode = request.getParameter("code");
		password = Md5.MD5(password);
		
		String code=(String) request.getSession().getAttribute("randomcode_key");
		if(!code.equals(veriCode)){
			return BookResult.build(403, "验证码错误");
		}
		
		//调用userService完成获取user
		TbUser user = userService.login(username);
		if(user!=null) {
			if(user.getStatus()==0) {
				return BookResult.build(403, "请先激活");
			}else if(user.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("nickname", user.getNickname());
				session.setAttribute("user", user);
				return BookResult.build(200, "登录成功");
			}
		}
		return BookResult.build(403, "账号密码错误");
	}
	/**
	 * 查看用户名是否可用
	 * @Title: checkUsername
	 * @Function: TODO
	 * @Param: @param username
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	@RequestMapping(value="/check/username",method=RequestMethod.POST)
	@ResponseBody
	public BookResult checkUsername(String username) {
		BookResult result = userService.checkUsername(username);	
		return result;
	}
	
	/**
	 * 验证用户
	 * @Title: checkNickname
	 * @Function: TODO
	 * @Param: @param nickname
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	@RequestMapping(value="/check/nickname",method=RequestMethod.POST)
	@ResponseBody
	public BookResult checkNickname(String nickname) {
		BookResult result = userService.checkNickname(nickname);	
		return result;
	}
	/**
	 * 用户注册
	 * @Title: regist
	 * @Function: TODO
	 * @Param: @param request
	 * @Param: @param response
	 * @Param: @param user
	 * @Param: @return
	 * @Param: @throws ServletException
	 * @Param: @throws IOException
	 * @return: BookResult
	 * @throws:
	 */
	@RequestMapping(value="/user/register",method=RequestMethod.POST)
	@ResponseBody
	public BookResult regist(HttpServletRequest request, HttpServletResponse response,TbUser user)
			throws ServletException, IOException {
		user.setStatus((byte) 0);
		user.setPassword(Md5.MD5(user.getPassword()));
		String email = user.getEmail();
		System.out.println(user.getUsername());
		userService.regist(user);
		
		String emailMsg = 
				"恭喜"+user.getNickname()+"，成为蔦屋書城的会员！<a href='http://localhost:8081/user/active?code="+Md5.JM(user.getUsername())+" '>点此激活</a>";
		System.out.println(emailMsg);
		try {
			MailUtils.sendMail(email, emailMsg);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return BookResult.ok();	
	}
	/**
	 * 用户激活
	 * @Title: activeUser
	 * @Function: TODO
	 * @Param: @param code
	 * @Param: @return
	 * @return: String
	 * @throws:
	 */
	@RequestMapping("/user/active")
	@ResponseBody
	public BookResult activeUser(String code) {
		String username=Md5.JM(code);
		
		System.out.println(username);
		TbUser user = userService.login(username);
		
		user.setStatus((byte)1);
		userService.updateUserStatus(user);
		return BookResult.ok();
	}
	
	@RequestMapping("/login")
	public String login(String redictURL,Model model) {
		System.out.println(redictURL);
		if(redictURL!=null && !"".equals(redictURL)) {
			model.addAttribute("redictURL", redictURL);
		}
		return "login";
	}
	/**
	 * 注销 "redirect:/"重定向   "forward:/" 请求转发
	 * @Title: logout
	 * @Function: TODO
	 * @Param: @param request
	 * @Param: @return
	 * @return: String
	 * @throws:
	 */
	@RequestMapping("/user/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("nickname");
		return "redirect:/";
	}
	
	/**
	 * 修改个人信息
	 * @Title: update
	 * @Function: TODO
	 * @Param: @param request
	 * @Param: @param response
	 * @Param: @return
	 * @return: String
	 * @throws:
	 */
	@RequestMapping(value="/user/update",method=RequestMethod.POST)
	public String update(HttpServletRequest request, HttpServletResponse response) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
	
		TbUser user2=(TbUser)request.getSession().getAttribute("user");
		Long id=user2.getId();
		TbUser user=new TbUser();
		user.setId(id);
		user.setEmail(email);
		user.setUsername(username);
		user.setPhone(phone);
		user.setPassword(Md5.MD5(password));
		userService.update(user);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		return "redirect:/";
	}
	
}
