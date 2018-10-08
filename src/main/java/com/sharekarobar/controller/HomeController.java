package com.sharekarobar.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sharekarobar.model.MonthlyProfit;
import com.sharekarobar.model.OrganizationModel;
import com.sharekarobar.services.OrganizationService;
import com.sharekarobar.services.ShareHolderService;
import com.sharekarobar.services.ShareHoldersPurchaseService;
import com.sharekarobar.services.ShareService;
import com.sharekarobar.services.TransactionService;

@Controller
public class HomeController {
	@Autowired
	OrganizationService organizationService;

	@Autowired
	ShareHoldersPurchaseService shareholderPurchaseService;

	@Autowired
	ShareHolderService shareHolderService;

	@Autowired
	ShareService shareService;

	@Autowired
	TransactionService transactionService;

	@RequestMapping("/")
	public ModelAndView getHomePage(HttpSession httpSession) {
		if (httpSession.getAttribute("user") != null) {
			ModelAndView homeModel = new ModelAndView("home");
			System.out.print("Here");
			OrganizationModel orgModel = organizationService
					.getOrganizationInfo(httpSession.getAttribute("user").toString());
			homeModel.addObject("organizationModel", orgModel);
			
			
			List<MonthlyProfit> monthlyProfits = new ArrayList<MonthlyProfit>();
			for (int i = 1; i <= 12; i++) {
				MonthlyProfit monthlyProfit = transactionService.getMonthlyProfit(i);
				monthlyProfits.add(monthlyProfit);
			}

			homeModel.addObject("shareHoldersTotal", shareholderPurchaseService
					.getShareholdersTotalPurchase());
			homeModel.addObject("monthlyProfits", monthlyProfits);
			homeModel.addObject("shareService", shareService);
			return homeModel;
		} else {
			ModelAndView model = new ModelAndView("redirect:/login");
			return model;
		}
	}
	
	@RequestMapping(value = "editContent")
	public ModelAndView editContent(HttpSession httpSession, @ModelAttribute("command") OrganizationModel organizationModel, BindingResult bindingResult) {
		if(httpSession.getAttribute("user") == null) {
			return new ModelAndView("redirect:/");
		}
		else {
			organizationModel = organizationService.getOrganizationInfo(httpSession.getAttribute("user").toString());
			ModelAndView model = new ModelAndView("editOrganization");
			model.addObject("organizationModel", organizationModel);
			return model;
		}
	}
	
	@RequestMapping(value = "updateOrganization")
	public String updateContent(HttpSession httpSession, @ModelAttribute("command") OrganizationModel organizationModel, BindingResult bindingResult) {
			organizationService.updateOrganization(organizationModel);
			return "redirect:/";
	}

}
