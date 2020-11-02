package com.payment.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.payment.Service.CommenService;
import com.payment.model.Account;
import com.payment.model.Login;


@Controller
public class LoginController {
	
	@Autowired
	CommenService ser;
	
	
	@RequestMapping(value = "/login")
	public ModelAndView getlogin() {
		
	
		ModelAndView mv = new ModelAndView("login.jsp");
		
		return mv;
	}
	@RequestMapping(value = "/logout")
	public ModelAndView getlogout(HttpSession ses) {
		
		ses.invalidate();
	
		ModelAndView mv = new ModelAndView("login.jsp");	
		return mv;
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ModelAndView postlogin(Login l,HttpSession ses) {
		ModelAndView mv = new ModelAndView();
		
		try {
			
	

		
		if(ser.authenticate(l).equals(null)) {
			System.out.println("--not validate");
			mv.setViewName("login");
			mv.addObject("msg", "invalied Login");
		}
		else {
			System.out.println("--validate");
			
			
			Login log = ser.authenticate(l);
			
			System.out.println("logid--"+log.getAid());
			Account a= ser.findByid(log.getAid());
			
			System.out.println("--->"+a.toString());
			
			
			
			ses.setAttribute("id", l.getAid());
			mv.setViewName("account.jsp");
			mv.addObject("id", a.getId());
			mv.addObject("name", a.getFirstname());
			mv.addObject("amount", a.getAmount());
			ses.setAttribute("id", a.getId());
			
		}
		
		} catch (Exception e) {
			System.out.println("exxxxx");
			mv.setViewName("login.jsp");
			mv.addObject("msg", "invalied Login");
		}
		
		return mv;
	}
	


}
