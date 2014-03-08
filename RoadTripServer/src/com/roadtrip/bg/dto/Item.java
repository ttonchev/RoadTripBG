package com.roadtrip.bg.dto;

import java.io.Serializable;


/**
 * 
 * @author bmi
 * Used by the mobile clients
 */
public class Item implements Serializable {

	private static final long serialVersionUID = 975575397109123651L;
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
