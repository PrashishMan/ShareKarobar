package com.sharekarobar.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sharekarobar.model.OrganizationModel;
import com.sharekarobar.services.OrganizationService;

@Controller
public class LoginController {
	
	@Autowired
	OrganizationService organizationService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(HttpSession httpSession, RedirectAttributes redirectAttribute) {
		if(httpSession.getAttribute("user") == null) {
				OrganizationModel organizationModel = new OrganizationModel();
				ModelAndView model = new ModelAndView("login/login");
				model.addObject("message", httpSession.getAttribute("user"));
				model.addObject("organizationModel", organizationModel);
				return model;			
			
		}else {
			redirectAttribute.addFlashAttribute("message", "Logged In");
			ModelAndView model = new ModelAndView("redirect:/");
			return model;
			
		}
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView processLogin(@Valid OrganizationModel organizationModel, BindingResult bindingResult, HttpSession httpSession, RedirectAttributes redirectAttribute) {
		
		ModelAndView model = new ModelAndView("login/login");
		if(bindingResult.hasErrors()) {
			redirectAttribute.addFlashAttribute("message", "Cannot login!!");
			return model;
			
		}else {
			OrganizationModel orgModel = organizationService.getOrganizationInfo(organizationModel.getAdminUsername());

			if(orgModel != null) {
				String password = orgModel.getAdminPassword();
				if(organizationModel.getAdminPassword().equals(password)) {
						httpSession.setAttribute("user", organizationModel.getAdminUsername());
						redirectAttribute.addFlashAttribute("message", "login Success!!");
						return new ModelAndView("redirect:/");
					
				}else {
					model.addObject("organizationModel", organizationModel);
					model.addObject("message", "Invalid Passwprd") ;
					return model;
					}
				
			}else {
				model.addObject("organizationModel", organizationModel);
				model.addObject("message", "invalid Username");
				return model;
				
			}
		}
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession httpSession) {
		if(httpSession.getAttribute("user") != null) {
			httpSession.setAttribute("user", null);			
		}
		return new ModelAndView("redirect:/login");
		
	}

}
