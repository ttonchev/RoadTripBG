package com.roadtrip.bg.dto;

import java.io.Serializable;

public class SiteItem implements Serializable {

	private static final long serialVersionUID = -403241418810709673L;

	private String id;

	private String active;

	private String buyerName;

	private String barcode;

	private String name;

	private String color;

	private String size;

	private String sdURL;

	private String itemPriceBGN;

	private String shippingPriceBGN;

	private String taxesPriceBGN;

	private String price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSdURL() {
		return sdURL;
	}

	public void setSdURL(String sdURL) {
		this.sdURL = sdURL;
	}

	public String getItemPriceBGN() {
		return itemPriceBGN;
	}

	public void setItemPriceBGN(String itemPriceBGN) {
		this.itemPriceBGN = itemPriceBGN;
	}

	public String getShippingPriceBGN() {
		return shippingPriceBGN;
	}

	public void setShippingPriceBGN(String shippingPriceBGN) {
		this.shippingPriceBGN = shippingPriceBGN;
	}

	public String getTaxesPriceBGN() {
		return taxesPriceBGN;
	}

	public void setTaxesPriceBGN(String taxesPriceBGN) {
		this.taxesPriceBGN = taxesPriceBGN;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
}
