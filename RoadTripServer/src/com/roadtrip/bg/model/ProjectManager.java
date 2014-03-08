package com.roadtrip.bg.model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.roadtrip.bg.dao.Database;
import com.roadtrip.bg.dao.Project;
import com.roadtrip.bg.dto.BuyerObject;
import com.roadtrip.bg.dto.BuyerTotal;
import com.roadtrip.bg.dto.Order;
import com.roadtrip.bg.dto.SiteItem;

public class ProjectManager {

	public ArrayList<BuyerObject> getBuyers(String code) throws Exception {
		ArrayList<BuyerObject> feeds = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnection();
			Project project = new Project();
			feeds = project.getBuyers(connection, code);

		} catch (Exception e) {
			throw e;
		}
		return feeds;
	}
	
	public List<SiteItem> listOrderItems(String orderId) throws Exception {
		List<SiteItem> items = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnection();
			Project project = new Project();
			items = project.listOrderItems(connection, orderId);

		} catch (Exception e) {
			throw e;
		}
		return items;
	}
	
	public List<BuyerTotal> listBuyerTotals(String orderId) throws Exception {
		List<BuyerTotal> totals = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnection();
			Project project = new Project();
			totals = project.listBuyerTotals(connection, orderId);

		} catch (Exception e) {
			throw e;
		}
		return totals;
	}
	
	public List<Order> listOrders() throws Exception {
		List<Order> orders = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnection();
			Project project = new Project();
			orders = project.listOrders(connection);

		} catch (Exception e) {
			throw e;
		}
		return orders;
	}
	
	public List<SiteItem> listBuyerItems(String orderId, String buyerId) throws Exception {
		List<SiteItem> items = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnection();
			Project project = new Project();
			items = project.listBuyerItems(connection, orderId, buyerId);

		} catch (Exception e) {
			throw e;
		}
		return items;
	}
	
	public String getLastOrderId() throws Exception {
		String orderId;
		try {
			Database database = new Database();
			Connection connection = database.getConnection();
			Project project = new Project();
			orderId = project.getLastOrderId(connection);

		} catch (Exception e) {
			throw e;
		}
		return orderId;
	}
	
	public void markFoundItem(String itemId, String imei) throws Exception {
		try {
			Database database = new Database();
			Connection connection = database.getConnection();
			Project project = new Project();
			project.markFoundItem(connection, itemId, imei);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public List<String> getAllCities() throws Exception {
		Database database = new Database();
		Connection conn = database.getConnection();
		Project project = new Project();
		List<String> cities = project.listAllCities(conn);
		return cities;
	}
}
