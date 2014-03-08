package com.roadtrip.bg.dto;

import java.io.Serializable;

public class BuyerTotal implements Serializable {

	private static final long serialVersionUID = 7201795627603759960L;

	private String id;

	private String buyer;

	private String total;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
}
