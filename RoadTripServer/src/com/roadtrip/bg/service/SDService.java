package com.roadtrip.bg.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.roadtrip.bg.dto.BuyerObject;
import com.roadtrip.bg.dto.BuyerTotal;
import com.roadtrip.bg.dto.City;
import com.roadtrip.bg.dto.Order;
import com.roadtrip.bg.dto.SiteItem;
import com.roadtrip.bg.model.ProjectManager;

@Path("/")
public class SDService {

	@GET
	@Path("/buyers/{code}")
	@Produces("application/json")
	public String buyers(@PathParam(value = "code") String code) {
		String buyers = null;
		try {
			ArrayList<BuyerObject> items = null;
			ProjectManager projectManager = new ProjectManager();
			items = projectManager.getBuyers(code);
			Gson gson = new Gson();
			System.out.println(gson.toJson(items));
			buyers = gson.toJson(items);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return buyers;
	}
	
	@GET
	@Path("/items/{orderId}")
	@Produces("application/json")
	public String items(@PathParam(value = "orderId") String orderId) {
		String itemsString = null;
		try {
			List<SiteItem> items = null;
			ProjectManager projectManager = new ProjectManager();
			items = projectManager.listOrderItems(orderId);
			Gson gson = new Gson();
			System.out.println(gson.toJson(items));
			itemsString = gson.toJson(items);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemsString;
	}
	
	@GET
	@Path("/totals/{orderId}")
	@Produces("application/json")
	public String totals(@PathParam(value = "orderId") String orderId) {
		String totalsJSON = null;
		try {
			List<BuyerTotal> totals = null;
			ProjectManager projectManager = new ProjectManager();
			totals = projectManager.listBuyerTotals(orderId);
			Gson gson = new Gson();
			System.out.println(gson.toJson(totals));
			totalsJSON = gson.toJson(totals);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalsJSON;
	}
	
	@GET
	@Path("/orders")
	@Produces("application/json")
	public String orders() {
		String ordersJSON = null;
		try {
			List<Order> orders = null;
			ProjectManager projectManager = new ProjectManager();
			orders = projectManager.listOrders();
			Gson gson = new Gson();
			System.out.println(gson.toJson(orders));
			ordersJSON = gson.toJson(orders);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordersJSON;
	}
	
	@GET
	@Path("/items/{orderId}/{buyerId}")
	@Produces("application/json")
	public String items(@PathParam(value = "orderId") String orderId, @PathParam(value = "buyerId") String buyerId) {
		String itemsString = null;
		try {
			List<SiteItem> items = null;
			ProjectManager projectManager = new ProjectManager();
			items = projectManager.listBuyerItems(orderId, buyerId);
			Gson gson = new Gson();
			System.out.println(gson.toJson(items));
			itemsString = gson.toJson(items);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemsString;
	}
	
	@GET
	@Path("/order")
	@Produces("application/json")
	public String lastOrderId() {
		String ok = "{\"id\":";
		try {
			ProjectManager projectManager = new ProjectManager();
			String orderId = projectManager.getLastOrderId();
			ok += "\"" + orderId  + "\"}";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}
	
	@GET
	@Path("/found/{itemId}/{imei}")
	@Produces("application/json")
	public String found(@PathParam(value = "itemId") String itemId, @PathParam(value = "imei") String imei) {
		String ok = "{\"status\":\"ok\"}";
		try {
			ProjectManager projectManager = new ProjectManager();
			projectManager.markFoundItem(itemId, imei);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}
	
	@GET
	@Path("/city")
	@Produces("application/json")
	public String getAllCities(){
		ProjectManager projectManager = new ProjectManager();
		
		String ordersJSON = null;
		List<City> cities;
		try {
			cities = projectManager.getAllCities();
			Gson gson = new Gson();
			System.out.println(gson.toJson(cities));
			ordersJSON = gson.toJson(cities);
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordersJSON;
	}
}
