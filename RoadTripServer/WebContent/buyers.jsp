<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/jsp/header.inc.jsp"></jsp:include>

	<div class="bs-callout bs-callout-info">
		<h4>History and details for all orders</h4>
		<p>
			Shows total amount, shipping taxes and DHL tracking URL. Click the "Show" button to detailed information for the selected buyer.
		</p>
	</div>
	
	<form class="form-horizontal" role="form">
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-9 control-label">Order number: </label>
			<div class="col-sm-3">
				<select class="form-control orders">
				</select>
			</div>
		</div>
	</form>

	<div class="col-sm-4">
		<table id="totals-table" class="table table-bordered table-striped sortable">
			<thead>
				<tr>
					<th>#</th>
					<th>Buyer</th>
					<th>Total</th>
					<th>Details</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	
	<div class="col-sm-8" id="total-details">
		<table id="buyer-items-table" class="table table-bordered table-striped sortable">
			<thead>
				<tr>
					<th>Barcode</th>
					<th>Item</th>
					<th>Color</th>
					<th>Size</th>
					<th>Link</th>
					<th>Price</th>
					<th>Shipping</th>
					<th>Taxes</th>
					<th>Total</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>

</div>

<jsp:include page="/WEB-INF/jsp/footer.inc.jsp"></jsp:include>