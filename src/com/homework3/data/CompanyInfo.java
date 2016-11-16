package com.homework3.data;

import java.util.Date;

public class CompanyInfo {
	
	private String name;
	private String exchange;
	private String symbol;
	private String industry;
	private double price;
	private Date addedOn;
	public CompanyInfo(){
		
	}
	public CompanyInfo(String name, String exchange, String symbol, String industry, double price, Date addedOn) {
		super();
		this.name = name;
		this.exchange = exchange;
		this.symbol = symbol;
		this.industry = industry;
		this.price = price;
		this.addedOn = addedOn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getAddedOn() {
		return addedOn;
	}
	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}
	
	

}
