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

import com.sharekarobar.model.PurchaseModel;
import com.sharekarobar.services.ShareHolderService;
import com.sharekarobar.services.ShareHoldersPurchaseService;
import com.sharekarobar.services.ShareService;

@Controller
public class ShareHoldersPurchaseController {

	@Autowired
	ShareHoldersPurchaseService purchaseService;

	@Autowired
	ShareHolderService shareholderService;

	@Autowired
	ShareService shareService;

	@RequestMapping(value = "shareholderpurchase", method = RequestMethod.GET)
	public ModelAndView getShareholdersPurchase(HttpSession httpSession,
			@ModelAttribute("command") PurchaseModel purchaseModel, BindingResult result) {
		if (httpSession.getAttribute("user") != null) {
			ModelAndView model = new ModelAndView("shareholderspurchase");
			int remainingShares = shareService.getTotalShare() - purchaseService.getTotalAmount();
			model.addObject("remainingShares", remainingShares);
			model.addObject("shareholders", shareholderService.getShareHolder());
			model.addObject("shares", shareService.getShare());
			model.addObject("share", shareService.getShare());
			model.addObject("purchaseList", purchaseService.getPurchase());

			return model;

		} else {
			return new ModelAndView("redirect:/");
		}
	}

	@RequestMapping(value = "addPurchase", method = RequestMethod.POST)
	public String addPurchase(@ModelAttribute("command") PurchaseModel purchaseModel, BindingResult bindingResult,
			RedirectAttributes redirattr) {
		if (bindingResult.hasErrors()) {
			redirattr.addFlashAttribute("message", "Invalid field entry");
		}
		if (purchaseModel.getPurchaseAmount() != 0 && purchaseModel.getPurchaseKey().getUsername() != null) {
			if ((shareService.getTotalShare() - purchaseService.getTotalAmount()) >= purchaseModel
					.getPurchaseAmount()) {
				purchaseModel.purchaseKey.setIssueID(shareService.getShare(shareService.getLatestIssueId()));
				redirattr.addFlashAttribute("message", "Olla");
				purchaseService.addPurchase(purchaseModel);
			} else {
				redirattr.addFlashAttribute("message", "Sorry the request shareamount is not available");
			}
		}
		else {
			redirattr.addFlashAttribute("message", "Please enter all the fields correctly");
		}
		return "redirect:/shareholderpurchase";

	}

}
