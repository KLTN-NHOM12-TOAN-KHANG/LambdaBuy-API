package com.example.kltn.SpringAPILambdaBuy.common.request.checkout;

public class CheckoutItemDto {
	private String productName;
	private int quantity;
	private double price;
	private String productId;
	private String userId;
	public CheckoutItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CheckoutItemDto(String productName, int quantity, double price, String productId, String userId) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.productId = productId;
		this.userId = userId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
