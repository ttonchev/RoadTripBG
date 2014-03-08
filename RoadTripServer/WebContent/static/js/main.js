/**
 * Loading pages in Ajax with HTML5 pushState.
 */

$(document).ready(function() {
	if (window.history && history.pushState) {
		historyedited = false;
		$(window).bind('popstate', function(e) {
			if (historyedited) {
				loadPage(location.pathname + location.search);
			}
		});
		doPager();
	}
});

function doPager() {
	$(".navbar-nav li").click(function(e) {
		e.preventDefault();
		$(".navbar-nav li").removeClass("active");
		$(this).addClass("active");
		$('#main').html("<div id='loading'>Loading...</div>");
		loadPage($(this).find("a").attr('href'));
		history.pushState(null, null, $(this).find("a").attr('href'));
		historyedited = true;
	});
}

function loadPage(link) {
	$.ajax({
		url : link,
		processData : true,
		dataType : 'html',
		success : function(data) {
			var content = $(data).find("#sub_main");
			var title = $(data).filter('title');
			var headings = $(data).find('hgroup:first');
			
			$('title').text(title.text());
			$('hgroup:first').html(headings.html());
			
			if (this.url == "/SDServer/ordered-items.jsp") {
				OrderItems.loadOrderedItems(content);
			} else if (this.url == "/SDServer/orders.jsp") {
				Orders.loadOrders(content);
			} else if (this.url == "/SDServer/buyers.jsp") {
				Buyers.loadBuyers(content);
			} else {
				$('#main').fadeOut('200', function() {
					$(this).html(content.html()).fadeIn('200');
				});
			}
		}
	});
}

OrderItems = {

	ORDERS_URL : "/SDServer/SD/WebService/orders",
	ITEMS_URL  : "/SDServer/SD/WebService/items/",
	FOUND_URL  : "/SDServer/SD/WebService/found/",
		
	loadOrderedItems : function(content) {
		$.getJSON(OrderItems.ORDERS_URL, function(json) {
			var orders = "";
			$.each(json, function(key, value) {
				orders += '<option value="' + value.id + '">Order #' + value.number + ": " + value.date + '</option>';
			});
			$(content).find(".orders").html(orders);
			
			$('#main').fadeOut('200', function() {
				$(this).html(content.html()).fadeIn('200');
				$(".orders").on("change", function (event) {
					OrderItems.loadItems($(event.target).val());
				});
				$(".orders").trigger("change");
			});
		});
	},
	
	loadItems : function(id) {
		$.getJSON(OrderItems.ITEMS_URL + id, function (itemsJSON) {
			var items = "";
			$.each(itemsJSON, function(key, value) {
				items += "<tr><td>" + value.id + "</td>"
				+ "<td>" + value.buyerName + "</td>"
				+ "<td>" + value.barcode + "</td>"
				+ "<td>" + value.name + "</td>"
				+ "<td>" + value.color + "</td>"
				+ "<td>" + value.size + "</td>"
				+ "<td><a href='" + value.sdURL + "' target='_blank'>URL</a></td>"
				+ "<td>" + value.itemPriceBGN + "</td>"
				+ "<td>" + value.shippingPriceBGN + "</td>"
				+ "<td>" + value.taxesPriceBGN + "</td>"
				+ "<td>" + value.price + "</td>";
				if (value.active == "0") {
					items += "<td>Yes</td>";
				} else {
					items += '<td><button data-id="' + value.id + '" type="button" class="btn btn-primary process">Process</button></td>';
				}
				items += "</tr>";
			});
			$("#ordered-items tbody").html(items);
			$(".process").on("click", function(event) {
				var itemId = $(event.target).data("id");
				$.getJSON(OrderItems.FOUND_URL + itemId + "/0", function(foundJSON) {
					if (typeof foundJSON.status != "undefined" && foundJSON.status == "ok") {
						$(event.target).parent().html("Yes");
					}
				});
			});
			$.bootstrapSortable(false);
		});
	}
};

Orders = {

	ORDERS_URL : "/SDServer/SD/WebService/orders",

	loadOrders : function(content) {
		$.getJSON(OrderItems.ORDERS_URL, function(json) {
			var orders = "";
			$.each(json, function(key, value) {
				orders += "<tr><td>" + value.id + "</td>"
					+ "<td>" + value.number + "</td>"
					+ "<td>" + value.date	+ "</td>"
					+ "<td>" + value.subtotalAmount + "</td>"
					+ "<td>" + value.shippingAmount + "</td>" 
					+ "<td>" + value.totalAmount + "</td>"
					+ "<td>" + value.totalAmountBGN + "</td>"
					+ "<td>" + value.currency + "</td>"
					+ "<td><a href='" + value.trackingURL + "' target='_blank'>URL</a></td></tr>";
			});
			$(content).find("#orders-table tbody").html(orders);

			$('#main').fadeOut('200', function() {
				$(this).html(content.html()).fadeIn('200');
				$.bootstrapSortable(false);
			});
		});
	}
};

Buyers = {
	
	ORDERS_URL : "/SDServer/SD/WebService/orders",
	TOTALS_URL  : "/SDServer/SD/WebService/totals/",
	BUYER_ITEMS_URL : "/SDServer/SD/WebService/items/",
	
	loadBuyers : function(content) {
		$.getJSON(Buyers.ORDERS_URL, function(json) {
			var orders = "";
			$.each(json, function(key, value) {
				orders += '<option value="' + value.id + '">Order #' + value.number + ": " + value.date + '</option>';
			});
			$(content).find(".orders").html(orders);
			
			$('#main').fadeOut('200', function() {
				$(this).html(content.html()).fadeIn('200');
				$(".orders").on("change", function (event) {
					Buyers.loadBuyerItems($(event.target).val());
				});
				$(".orders").trigger("change");
			});
		});
	},
	
	loadBuyerItems : function(orderId) {
		$.getJSON(Buyers.TOTALS_URL + orderId, function (totalsJSON) {
			var totals = "";
			$.each(totalsJSON, function(key, value) {
				totals += "<tr><td>" + value.id + "</td>"
					+ "<td>" + value.buyer + "</td>"
					+ "<td>" + value.total + "</td>"
					+ '<td><button data-id="' + value.id + '" type="button" class="btn btn-primary show-items">Show</button></td></tr>';
			});
			$("#total-details").hide();
			$("#totals-table tbody").html(totals);
			$.bootstrapSortable(false);
			$(".show-items").on("click", function(event) {
				var buyerId = $(event.target).data("id");
				$(".show-items").removeClass('active');
				$(event.target).addClass('active');
				$.getJSON(Buyers.BUYER_ITEMS_URL + orderId + "/" + buyerId, function(itemsJSON) {
					var items = "";
					$.each(itemsJSON, function(key, value) {
						items += "<tr><td>" + value.barcode + "</td>"
							+ "<td>" + value.name + "</td>"
							+ "<td>" + value.color	+ "</td>"
							+ "<td>" + value.size + "</td>"
							+ "<td><a href='" + value.sdURL + "' target='_blank'>URL</a></td>" 
							+ "<td>" + value.itemPriceBGN + "</td>"
							+ "<td>" + value.shippingPriceBGN + "</td>"
							+ "<td>" + value.taxesPriceBGN + "</td>"
							+ "<td>" + value.price + "</td></tr>";
					});
					$("#buyer-items-table tbody").html(items);
					$.bootstrapSortable(false);
					$("#total-details").show();
				});
			});
		});
	}
};
