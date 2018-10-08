package com.sharekarobar.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sharekarobar.model.ShareHolderModel;
import com.sharekarobar.services.LocationService;
import com.sharekarobar.services.ShareHolderService;

@Controller
public class ShareholderController {
	
	@Autowired
	ShareHolderService shareholderService;
	
	@Autowired
	SessionFactory session;
	
	@Autowired
	LocationService locationService;

	@RequestMapping(value = "/shareholder", method = RequestMethod.GET)
	public ModelAndView getShareholderPanel(HttpSession httpSession, @ModelAttribute("command") ShareHolderModel shareholder, BindingResult result) {
		Map<String, Object> map = new HashMap<>();
		map.put("shareholders", shareholderService.getShareHolder());
		map.put("locations", locationService.getLocation());
		return new ModelAndView("shareholderpage", map);	
	}
	
	@RequestMapping(value="addshareholder", method = RequestMethod.POST)
	public String addShareholder(@ModelAttribute("command") ShareHolderModel shareholder,RedirectAttributes attr, BindingResult result) {
//		Location location = new Location(shareholdersLocation.locationId, shareholdersLocation.state,  shareholdersLocation.zone, shareholdersLocation.city, shareholdersLocation.street);
//		locationService.addLocation(location);
//		ShareHolderModel shareholder = new ShareHolderModel(shareholdersLocation.username, shareholdersLocation.password, shareholdersLocation.shareholderName, location);
		shareholderService.addShareHolder(shareholder);		
		return "redirect:/shareholder";		
	}
	
	
}
