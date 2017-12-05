<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page session="false" isELIgnored="false"%>
<html>
<head>
<title>Activity Stream</title>

</head>
<body>
	<!-- create a form which will have textboxes for Sender Name and Message content along with a Send 
Submit button. Handle errors like empty fields -->
	<h2>Send Messages..</h2>
	<form name="sendMessage" method="post" action="sendMessage">
		Sender Name: <input type="text" name="sender"> 
		Message: <input type="text" name="message">
		 <input type="submit" value="submit">
	</form>

	<!-- display all existing messages in a tabular structure with Sender Name, Posted Date and Message -->

	<h2>Messages..</h2>
	<table>
		<c:forEach items="${messageList}" var="message">
			<tr>
				<td>Message ID: <c:out value="${message.messageId}" /></td>
				<td>Sender Name: <c:out value="${message.sender}" /></td>
				<td>Posted Date: <c:out value="${message.postedDate}" /></td>
				<td>Message: <c:out value="${message.message}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>