package com.sharekarobar.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sharekarobar.model.MonthlyProfit;
import com.sharekarobar.model.TransactionModel;
import com.sharekarobar.services.TransactionService;


@Controller
public class TrasnactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping(value="transaction", method = RequestMethod.GET)
	public ModelAndView getTransactionPage(HttpSession httpSession, @ModelAttribute("command") TransactionModel transactionModel, BindingResult bindingResult) {
		if(httpSession.getAttribute("user") != null) {
			
			Map<String, Object> model = new HashMap<>();
			model.put("transactionList", transactionService.getTransaction());
			model.put("job", "1");
			model.put("profits", "Apple");
			return new ModelAndView("transactionpage", model);
		}else {
			return new ModelAndView("redirect:/");
		}
		
	}
	
	@RequestMapping(value = "addtransaction", method = RequestMethod.POST)
	public String issueShare(HttpSession httpSession, @ModelAttribute("command") TransactionModel transactionModel,
			BindingResult result, RedirectAttributes redirAttr) {
		transactionService.addTransaction(transactionModel);
		return "redirect:/transaction";
	}
	
	@RequestMapping(value = "viewMonthlyTransaction", method = RequestMethod.GET)
	public ModelAndView getMonthlyTransaction(HttpSession httpSession, @ModelAttribute("command") MonthlyProfit month, BindingResult bindingResult) {
		
			ModelAndView model = new ModelAndView("transactionpage");
			model.addObject("total", transactionService.getMonthlyProfit(month.getMonth()));
			model.addObject("transactionList", transactionService.getMonthlyTransaction(month.getMonth()));
			return model;
		
		
	}
	
	

}
