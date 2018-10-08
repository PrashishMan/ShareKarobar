package com.sharekarobar.model;

public class TotalShareHoldersPurchase {
	
//	@Transient
//	@Autowired
//	ShareService shareService;
		
	private String shareHolder;
	private int investment;
	public TotalShareHoldersPurchase(String shareHolder, int investment) 
	{
		
		this.shareHolder = shareHolder;
		this.investment = investment;
		
	}
	
	public TotalShareHoldersPurchase(){}
	
	public String getShareHolder() {
		return shareHolder;
	}
	public void setShareHolder(String shareHolder) {
		this.shareHolder = shareHolder;
	}
	public int getInvestment() {
		return investment;
	}
	public void setInvestment(int investment) {
		this.investment = investment;
	}
//	
//	@Transient
//	public int getPercent(){
//		int totalShare = shareService.getTotalShare();
//		return (investment/totalShare) * 100 ;
//	}
//	
	

}
