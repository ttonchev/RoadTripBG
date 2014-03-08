<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String title = "Help Me";

request.setAttribute("pageTitle", title);
request.setAttribute("pageHeading", title);
%>

<jsp:include page="/WEB-INF/jsp/header.inc.jsp"></jsp:include>

	<div class="bs-callout bs-callout-info">
		<h4>History and details for all orders</h4>
		<p>
			Shows total amount, shipping taxes and DHL tracking URL.
		</p>
	</div>

	<table id="orders-table" class="table table-bordered table-striped sortable">
		<thead>
			<tr>
				<th>#</th>
				<th>Number</th>
				<th>Date</th>
				<th>Sub-total amount</th>
				<th>Shipping amount</th>
				<th>Total amount</th>
				<th>Total amount BGN</th>
				<th>Currency</th>
				<th>Tracking URL</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>

</div>

<jsp:include page="/WEB-INF/jsp/footer.inc.jsp"></jsp:include>
