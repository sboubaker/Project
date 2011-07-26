<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
<head>
<title>Users</title>
</head>
<body>
	<h1>New Book</h1>
	<form:form action="book.htm" method="post" modelAttribute="emptybook">
		<fieldset class="fieldcontainer">
			<legend>New Book</legend>

			<div class="block">
				<div class="field">
					<form:label for="name" path="name">Name:</form:label>
					<form:errors path="name" cssClass="error" />
					<br />
					<form:input path="name" />
				</div>

				<div class="field vertical">
					<form:label for="edition" path="edition">Edition:</form:label>
					<form:errors path="edition" cssClass="error" />
					<br />
					<form:input path="edition" />
				</div>
			</div>
			<div class="field vertical">
				<input type="submit" value="Create new Book">
			</div>

		</fieldset>
	</form:form>
</body>
</html>
