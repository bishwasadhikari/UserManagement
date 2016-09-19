<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript"
	src="<c:url value="/resources/js/custom.js" />"></script>
</head>
<body>
	<div id="container" class="col-md-6 col-sm-8">
		<h3 align="center">Add User</h3>
		<form:form modelAttribute="user">
			<c:if test="${!empty user.fName}">
				<div class="form-group row">
					<form:label path="id" class="col-xs-2 col-form-label">
						<spring:message text="ID: " />
					</form:label>
					<div class="col-xs-8">
						<form:input class="form-control" path="id" readonly="true"
							disabled="true" value="${id}" />
						<form:hidden path="id" />
					</div>
				</div>
			</c:if>
			<div class="form-group row">
				<form:label path="fName" class="col-xs-2 col-form-label">
					<spring:message text="First Name: " />
				</form:label>
				<div class="col-xs-8">
					<form:input class="form-control" path="fName" value="${fName}" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="lName" class="col-xs-2 col-form-label">
					<spring:message text="Last Name: " />
				</form:label>
				<div class="col-xs-8">
					<form:input class="form-control" path="lName" value="${lName}" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="phone" class="col-xs-2 col-form-label">
					<spring:message text="Phone: " />
				</form:label>
				<div class="col-xs-8">
					<form:input class="form-control" path="phone" value="${phone}" />
				</div>
			</div>
			<c:if test="${!empty user.fName}">

				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-pencil"></span> Update User
				</button>
				&nbsp;&nbsp; &nbsp;				
				<button type="submit" value="Cancel" name="_cancel"
					class="btn btn-warning">Cancel</button>
			</c:if>
			<c:if test="${empty user.fName}">

				<button type="submit" class="btn btn-success">
					<span class="glyphicon glyphicon-eye-open"></span> Add User
				</button>
			</c:if>
		</form:form>
	</div>

</body>
</html>