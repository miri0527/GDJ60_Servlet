package com.iu.home.product;

public class ProductOptionDTO {
	private Long option_num;
	private Long product_num;
	private String option_name;
	private Long option_price;
	private Long option_stock;
	
	public Long getOption_num() {
		return option_num;
	}
	public void setOption_num(Long option_num) {
		this.option_num = option_num;
	}
	public Long getProduct_num() {
		return product_num;
	}
	public void setProduct_num(Long num) {
		this.product_num = num;
	}
	public String getOption_name() {
		return option_name;
	}
	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}
	public Long getOption_price() {
		return option_price;
	}
	public void setOption_price(Long option_price) {
		this.option_price = option_price;
	}
	public Long getOption_stock() {
		return option_stock;
	}
	public void setOption_stock(Long option_stock) {
		this.option_stock = option_stock;
	}
	
	
	
}
