package com.payment.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.payment.Service.CommenService;
import com.payment.model.Account;
import com.payment.model.Login;
import com.payment.model.Payee;

@Controller
public class HomeController {

	@Autowired
	CommenService ser;

	@RequestMapping(value = "/addaccount")
	public ModelAndView getuser(Login l) {
		ModelAndView mv = new ModelAndView("admin.jsp");

		return mv;
	}
	@RequestMapping(value = "/profile")
	public ModelAndView profile(HttpSession ses) {
		ModelAndView mv = new ModelAndView("profile.jsp");
		
		long id = (long) ses.getAttribute("id");
		Account a = ser.findByid(id);
		
		mv.addObject("obj", a);
		
		return mv;
	}

	@RequestMapping(value = "/addaccount", method = RequestMethod.POST)
	public ModelAndView adduser(Login l, Account a) {
		ModelAndView mv = new ModelAndView("admin.jsp");
		ser.newaccount(a, l);
		return mv;
	}
	
	@RequestMapping(value = "/accounts",produces="application/json")
	@ResponseBody
	public Account getaccounts(HttpSession ses,String mobile) throws Exception {
		
		System.out.println(mobile+"--");
		
		try {
			
			return ser.findBymobile(mobile);
		} catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping(value = "/addpayee", method = RequestMethod.POST)
	public ModelAndView addpayee(HttpSession ses,@RequestParam("id")long id,@RequestParam("toid")long toid) {
		
		Account a = ser.findByid(toid);
		
		Payee p = new Payee();
		p.setFromid(id);
		p.setToid(toid);
		p.setFullname(a.getFirstname()+" "+a.getLastname());
		
		ser.addPayee(p);
		
		ModelAndView mv = new ModelAndView("account.jsp");
	
		return mv;
	}
	//transfer
	@RequestMapping(value = "/transfer")
	public ModelAndView transfer(HttpSession ses,@RequestParam("id")long id) {
		
		System.out.println("ses-->"+id);
		
		List<Payee> li = ser.ListPayee(id);
		
		for(Payee p : li) {
			System.out.println(p.toString());
		}
		
		ModelAndView mv = new ModelAndView("transfer.jsp");
		mv.addObject("payee", li);

		return mv;
	}
	//moneytransfer
	@RequestMapping(value = "/moneytransfer", method = RequestMethod.POST)
	public ModelAndView moneytransfer(HttpSession ses,@RequestParam("amount")int amt,@RequestParam("toid")long toid ) {
		
		System.out.println(toid+"----");
		
		long fromid = (long) ses.getAttribute("id");

		ser.MoneyProcess(amt, fromid, toid);
	

		return transfer(ses,fromid);
	}
	
	
	 

}
