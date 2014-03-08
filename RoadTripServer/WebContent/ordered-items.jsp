<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/jsp/header.inc.jsp"></jsp:include>

	<div class="bs-callout bs-callout-info">
		<h4>View the delivered items for selected order</h4>
		<p>
			Select order and all of its items will appear in the table below. If you can't process item using the mobile application, you can pred the "Process" button.
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

	<table id="ordered-items" class="table table-bordered table-striped sortable">
		<thead>
			<tr>
				<th>#</th>
				<th>Buyer</th>
				<th>Barcode</th>
				<th>Name</th>
				<th>Color</th>
				<th>Size</th>
				<th>Link</th>
				<th>Price</th>
				<th>Shipping</th>
				<th>Taxes</th>
				<th>Total</th>
				<th>Processed</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>

</div>

<jsp:include page="/WEB-INF/jsp/footer.inc.jsp"></jsp:include>