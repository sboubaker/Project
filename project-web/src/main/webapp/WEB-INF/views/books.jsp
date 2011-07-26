<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
<head>
<title>Books</title>
</head>
<body>
	<h1>Our Books</h1>
	<table>
		<tbody>
			<c:forEach var="book" items="${books}">
				<tr>
					<td><c:out value="${book.name}" />
					</td>
					<td><c:out value="${book.edition}" />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
