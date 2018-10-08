package com.sharekarobar.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sharekarobar.model.MonthlyProfit;
import com.sharekarobar.model.ShareHolderModel;
import com.sharekarobar.model.TransactionModel;
import com.sharekarobar.services.ShareHolderService;
import com.sharekarobar.services.ShareHoldersPurchaseService;
import com.sharekarobar.services.TransactionService;

@RestController
public class RestContoller {

	@Autowired
	TransactionService transactionService;

	@Autowired
	ShareHolderService shareholderService;
	
	@Autowired
	ShareHoldersPurchaseService purchaseService;

	@RequestMapping(value = "getTransactionJSON")
	public List<TransactionModel> getTransaction() {
		return transactionService.getTransaction();

	}

	@RequestMapping(value = "JSONLogin/{username}/{password}")
	public ShareHolderModel jsonLogin(@PathVariable("username") String username, @PathVariable("password") String password) {
		ShareHolderModel shareholder = (ShareHolderModel) shareholderService.getShareHolder(username);
		if (shareholder != null) {
			if (shareholder.getPassword().equals(password)) {
				int sharePurchase = purchaseService.getShareholdersPurchase(username);
				int totalShare = purchaseService.getTotalAmount();
				shareholder.setPurchaseAmount(sharePurchase);
				shareholder.setTotalShare(totalShare);
				return shareholder;
			}

			else {
				return null;
			}
		}
		else {
			return null;
		}

	}
	
	@RequestMapping(value = "getJSONMonthlyProfit")
	public List<MonthlyProfit> getMonthlyProfitJSON() {
		List<MonthlyProfit> monthlyProfits = new ArrayList<MonthlyProfit>();
		for (int i = 1; i <= 12; i++) {
			MonthlyProfit monthlyProfit = transactionService.getMonthlyProfit(i);
			monthlyProfits.add(monthlyProfit);
		}
		return monthlyProfits;
	}
	
	
	@RequestMapping(value = "getJSONMonthlyTransaction/{month}", method = RequestMethod.GET)
	public List<TransactionModel> getMonthlyTransactionJSON(@PathVariable("month") int month){
		return transactionService.getMonthlyTransaction(month);	
	}

}
