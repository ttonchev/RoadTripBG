package com.roadtrip.bg.dto;

import java.io.Serializable;

public class Order implements Serializable {

	private static final long serialVersionUID = -557601584920720797L;

	private String id;

	private String number;

	private String date;

	private String subtotalAmount;

	private String shippingAmount;

	private String totalAmount;

	private String totalAmountBGN;

	private String currency;

	private String trackingURL;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSubtotalAmount() {
		return subtotalAmount;
	}

	public void setSubtotalAmount(String subtotalAmount) {
		this.subtotalAmount = subtotalAmount;
	}

	public String getShippingAmount() {
		return shippingAmount;
	}

	public void setShippingAmount(String shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTotalAmountBGN() {
		return totalAmountBGN;
	}

	public void setTotalAmountBGN(String totalAmountBGN) {
		this.totalAmountBGN = totalAmountBGN;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getTrackingURL() {
		return trackingURL;
	}

	public void setTrackingURL(String trackingURL) {
		this.trackingURL = trackingURL;
	}

}
