package com.roadtrip.bg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.roadtrip.bg.dto.BuyerObject;
import com.roadtrip.bg.dto.BuyerTotal;
import com.roadtrip.bg.dto.Order;
import com.roadtrip.bg.dto.SiteItem;

public class Project {

	public ArrayList<BuyerObject> getBuyers(Connection connection,
			String barCodeLong) throws Exception {
		String barCode = "";
		if (barCodeLong.length() == 13) {
			barCode = barCodeLong.substring(1, 12);
		} else {
			barCode = barCodeLong;
		}
		ArrayList<BuyerObject> buyers = new ArrayList<BuyerObject>();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT b.id, b.name, MIN(ti.id) as item_id, i.name as item_name, (ti.item_price_bgn + ti.shipping_price_bgn + ti.taxes_price_bgn) as item_unit_price "
							+ "FROM sportsdirect.order_details od "
							+ "JOIN sportsdirect.items i ON (od.item_id = i.id) "
							+ "JOIN sportsdirect.buyers b ON (od.buyer_id = b.id) "
							+ "JOIN sportsdirect.transfer_items ti ON (od.id = ti.order_detail_id) "
							+ "WHERE ti.is_active = 1 AND i.barcode = "
							+ barCode
							+ " AND od.order_id = (SELECT MAX(id) FROM sportsdirect.orders) "
							+ "GROUP BY b.name");

			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				PreparedStatement ps2 = connection
						.prepareStatement("SELECT b.id, b.name, MIN(ti.id) as item_id, i.name as item_name, (ti.item_price_bgn + ti.shipping_price_bgn + ti.taxes_price_bgn) as item_unit_price "
								+ "FROM sportsdirect.order_details od "
								+ "JOIN sportsdirect.items i ON (od.item_id = i.id) "
								+ "JOIN sportsdirect.buyers b ON (od.buyer_id = b.id) "
								+ "JOIN sportsdirect.transfer_items ti ON (od.id = ti.order_detail_id) "
								+ "WHERE i.barcode = "
								+ barCode
								+ " AND od.order_id = (SELECT MAX(id) FROM sportsdirect.orders) "
								+ "GROUP BY b.name");
				rs = ps2.executeQuery();
				while (rs.next()) {
					BuyerObject buyer = new BuyerObject();
					buyer.setId(rs.getString("id"));
					buyer.setName(rs.getString("name"));
					buyer.setItemId(rs.getString("item_id"));
					buyer.setItemName(rs.getString("item_name"));
					buyer.setUnitPrice(rs.getString("item_unit_price"));
					buyers.add(buyer);
				}
			} else {
				do {
					BuyerObject buyer = new BuyerObject();
					buyer.setId(rs.getString("id"));
					buyer.setName(rs.getString("name"));
					buyer.setItemId(rs.getString("item_id"));
					buyer.setItemName(rs.getString("item_name"));
					buyer.setUnitPrice(rs.getString("item_unit_price"));
					buyers.add(buyer);
				} while (rs.next());
			}

			return buyers;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<SiteItem> listOrderItems(Connection connection, String orderId) {
		List<SiteItem> items = new ArrayList<SiteItem>();
		try {
			String query = "SELECT b.name as buyer, t.item_price_bgn, t.shipping_price_bgn , t.taxes_price_bgn, t.item_price_bgn + t.shipping_price_bgn + t.taxes_price_bgn as price, i.barcode, i.name, i.size, i.url, i.color, t.id, t.is_active"
					+ " FROM `order_details` d"
					+ " JOIN `transfer_items` t ON (d.id = t.order_detail_id)"
					+ " JOIN `buyers` b ON (b.id = d.buyer_id)"
					+ " JOIN `items` i ON (i.id=d.item_id)"
					+ " WHERE d.order_id = " + orderId;

			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SiteItem item = new SiteItem();
				item.setId(rs.getString("id"));
				item.setBuyerName(rs.getString("buyer"));
				item.setBarcode(rs.getString("barcode"));
				item.setName(rs.getString("name"));
				item.setColor(rs.getString("color"));
				item.setSize(rs.getString("size"));
				item.setSdURL(rs.getString("url"));
				item.setItemPriceBGN(rs.getString("item_price_bgn"));
				item.setShippingPriceBGN(rs.getString("shipping_price_bgn"));
				item.setTaxesPriceBGN(rs.getString("taxes_price_bgn"));
				item.setPrice(rs.getString("price"));
				item.setActive(rs.getString("is_active"));
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return items;
	}
	
	public List<BuyerTotal> listBuyerTotals(Connection connection, String orderId) {
		List<BuyerTotal> totals = new ArrayList<BuyerTotal>();
		try {
			String query = "SELECT b.id, b.name, SUM(t.item_price_bgn + t.shipping_price_bgn + t.taxes_price_bgn) as money"
					+ " FROM `order_details` d"
					+ " JOIN `transfer_items` t ON (d.id = t.order_detail_id)"
					+ " JOIN `buyers` b ON (b.id = d.buyer_id)"
					+ " WHERE d.order_id = " + orderId
					+ " GROUP BY b.name";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BuyerTotal total = new BuyerTotal();
				total.setId(rs.getString("id"));
				total.setBuyer(rs.getString("name"));
				total.setTotal(rs.getString("money"));
				totals.add(total);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totals;
	}
	
	public List<Order> listOrders(Connection connection) {
		List<Order> orders = new ArrayList<Order>();
		try {
			String query = "SELECT id, number, DATE(timestamp) as time, exchange_currency, subtotal_amount, shipping_amount, total_amount, bgn_amount, tracking_url FROM `orders`";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getString("id"));
				order.setNumber(rs.getString("number"));
				order.setDate(rs.getString("time"));
				order.setCurrency(rs.getString("exchange_currency"));
				order.setSubtotalAmount(rs.getString("subtotal_amount"));
				order.setShippingAmount(rs.getString("shipping_amount"));
				order.setTotalAmount(rs.getString("total_amount"));
				order.setTotalAmountBGN(rs.getString("bgn_amount"));
				order.setTrackingURL(rs.getString("tracking_url"));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orders;
	}
	
	public List<SiteItem> listBuyerItems(Connection connection, String orderId, String buyerId) {
		List<SiteItem> items = new ArrayList<SiteItem>();
		try {
			String query = "SELECT i.barcode, i.name, i.color, i.size, i.url, t.item_price_bgn, t.shipping_price_bgn, t.taxes_price_bgn, t.item_price_bgn + t.shipping_price_bgn + t.taxes_price_bgn as price"
					+ " FROM `order_details` d"
					+ " JOIN `transfer_items` t ON (d.id = t.order_detail_id)"
					+ " JOIN `buyers` b ON (b.id = d.buyer_id)"
					+ " JOIN `items` i ON (i.id = d.item_id)"
					+ " WHERE d.order_id = " + orderId + " and b.id = " + buyerId;

			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SiteItem item = new SiteItem();
				item.setBarcode(rs.getString("barcode"));
				item.setName(rs.getString("name"));
				item.setColor(rs.getString("color"));
				item.setSize(rs.getString("size"));
				item.setSdURL(rs.getString("url"));
				item.setItemPriceBGN(rs.getString("item_price_bgn"));
				item.setShippingPriceBGN(rs.getString("shipping_price_bgn"));
				item.setTaxesPriceBGN(rs.getString("taxes_price_bgn"));
				item.setPrice(rs.getString("price"));
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return items;
	}

	public String getLastOrderId(Connection connection) throws Exception {
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT MAX(number) as id FROM sportsdirect.orders");
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getString("id");
		} catch (Exception e) {
			throw e;
		}
	}

	public void markFoundItem(Connection connection, String itemId, String imei)
			throws Exception {
		try {
			connection.setAutoCommit(false);
			PreparedStatement ps = connection
					.prepareStatement("UPDATE sportsdirect.transfer_items ti"
							+ " SET ti.is_active = 0, ti.processor_imei = "
							+ imei + " WHERE ti.id = " + itemId + "; ");
			ps.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public List<String> listAllCities(Connection connection) {
		
			try {
				connection.setAutoCommit(false);
				PreparedStatement ps = connection.prepareStatement("Select * from cities");
				ResultSet rs = ps.executeQuery();
				List<String> result = new ArrayList<String>();
				while (rs.next()) {
					result.add(rs.getString(2));
				}
				return result;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	return null;
	}
}
