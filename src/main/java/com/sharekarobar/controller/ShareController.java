package com.sharekarobar.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sharekarobar.model.ShareModel;
import com.sharekarobar.services.ShareHoldersPurchaseService;
import com.sharekarobar.services.ShareService;

@Controller
public class ShareController {

	@Autowired
	ShareService shareService;
	
	@Autowired
	ShareHoldersPurchaseService purchaseService;

	@RequestMapping(value = "/share", method = RequestMethod.GET)
	public ModelAndView getSharePage(HttpSession httpSession, @ModelAttribute("command") ShareModel shareModel,
			BindingResult result) {
		if (httpSession.getAttribute("user") != null) {
			ModelAndView model = new ModelAndView("sharepage");
			if (shareService.getShare() != null) {
				model.addObject("shareList", shareService.getShare());
				return model;
			} else {
				return new ModelAndView("redirect:/");
			}
		} else {
			return new ModelAndView("redirect:/");
		}
	}

	@RequestMapping(value = "issueshare", method = RequestMethod.POST)
	public String issueShare(HttpSession httpSession, @ModelAttribute("command") ShareModel shareModel,
			BindingResult result, RedirectAttributes redirAttr) {
		if (shareService.getTotalShare() <= 0 || shareService.getTotalShare() == purchaseService.getTotalAmount()) {
			shareService.addShare(shareModel);
		}else {
			redirAttr.addFlashAttribute("message", "Shares must be completely sold before issuing a new one");
		}
		return "redirect:/share";
	}
}
