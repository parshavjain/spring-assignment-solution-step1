<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page session="false" isELIgnored="false"%>
<html>
<head>
<title>Activity Stream</title>
<style>
table, table tr, table tr td, table tr th  {
	border: 5px solid black;
	-moz-border: 10px solid black;
	-webkit-border: 10px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<!-- create a form which will have textboxes for Sender Name and Message content along with a Send 
Submit button. Handle errors like empty fields -->
	<center><h2>Send Messages..</h2></center>
	<form name="sendMessage" method="post" action="sendMessage">
		<center>Sender Name: <input type="text" name="sender"> 
		Message:     <input type="text" name="message"> </center>
			<br>
		<center><input type="submit"value="submit" ></center>
	</form>

	<!-- display all existing messages in a tabular structure with Sender Name, Posted Date and Message -->

<br><br><br><br>
	<center><h2>Messages..</h2></center>
	<center><table>
		<tr>
			<th>Sender Name</th>
			<th>Message</th>
		</tr>
		<c:forEach items="${messageList}" var="message">
			<tr>
				<td><c:out value="${message.sender}" /></td>
				<td><c:out value="${message.message}" /></td>
			</tr>
		</c:forEach>
	</table></center>
</body>
</html>