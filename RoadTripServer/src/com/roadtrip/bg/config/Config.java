package com.roadtrip.bg.config;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Config {

	public final static String SITE_NAME = "SDOrders";
	public final static String TITLE_SITE = "SDOrders Site";
	public final static String META_DESCRIPTION = "Welcome on my site";
	public final static String META_KEYWORDS = "sd, orders, software, java, jsp";

	public final static String SITE_URL = "/RoadTripServer/";
	public final static String TPL_URL = "/RoadTripServer/tpl/base/";
	public final static String STATIC_URL = "/RoadTripServer/static/";

	public final static String CONTACT_EMAIL = "boriss.minev@gmail.com";

	public static String getYear() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		return dateFormat.format(date);
	}

}
