`<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">

		<h2>Insurance Policy Details...</h2>
		<form:form action="search" modelAttribute="search" method="POST">

			<table>

				<tr>
					<td>Plan Name :</td>
					<td><form:select path="planName">
							<form:option value="">-select-</form:option>
							<form:options items="${names}"></form:options>
						</form:select></td>

				</tr>
				<tr>
					<td>Plan Status:</td>
					<td><form:select path="planStatus">
							<form:option value="">-select-</form:option>
							<form:options items="${status}"></form:options>
						</form:select></td>
				</tr>
				<tr>
					<td>Gender :</td>
					<td><form:select path="gender">
							<form:option value="">-select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Fe-Male">Fe-Male</form:option>
						</form:select></td>
				</tr>


				<tr>
					<td>start Date:</td>
					<td><form:input type="date" path="planStartDate"
							class="datepicker" /></td>
				</tr>
				<tr>
					<td>End Date:</td>
					<td><form:input type="date" path="planEndDate"
							class="datepicker" /></td>
				</tr>
				<tr>
					<td><a href="/" class="btn btn-secondary">Reset</a> <input
						type="submit" value="search" class="btn btn-primary" /></td>
				</tr>
			</table>
		</form:form>

		<hr />

		<table class="table table-striped table=hover">
			<thead>
				<tr>
					<th>coustmer_Id</th>
					<th>coustmer_Name</th>
					<th>gender</th>
					<th>plan_Name</th>
					<th>plan_Status</th>
					<th>plan_start_date</th>
					<th>plan_end_date</th>
					<th>benefit_Amount</th>
					<th>Denial_Reason</th>
					<th>terminated_date</th>
					<th>terminated_Reason</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${plans}" var="plan">
					<tr>
						<td>${plan.coustmerId}</td>
						<td>${plan.coustmerName }</td>
						<td>${plan.gender }</td>
						<td>${plan.planName }</td>
						<td>${plan.planStatus }</td>
						<td>${plan.planStartDate }</td>
						<td>${plan.planEndDate }</td>
						<td>${plan.benefitAmount }</td>
						<td>${plan.denialReason }</td>
						<td>${plan.terminatedDate }</td>
						<td>${plan.terminatedReason }</td>
					</tr>
				</c:forEach>
				<tr>
					<c:if test="${empty plans}">
						<td colspan="11" style="text-align: center">No Records Found
						</td>
					</c:if>
				</tr>
			</tbody>
		</table>

		<hr />
		Export : <a href="/excel">Excel</a> <a href="/pdf">Pdf</a>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>