<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<title>Home</title>
<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>

<body>
	<h1>予約されてる内容を表示します</h1>


	<table>
		<tr>
			<th>予約番号</th>
			<th>希望日１</th>
			<th>希望日２</th>
			<th>氏名.</th>
			<th>最終学歴</th>
			<th>開発経験有無</th>
			<th>弊社とのマッチングポイント</th>
		</tr>

		<c:forEach var="reserve" items="${queryResult}">

			<tr>

				<td><c:out value="${reserve.receptionNo} " /></td>

				<td><c:out value="${reserve.requestDate1} " /></td>

				<td><c:out value="${reserve.requestDate2} " /></td>

				<td><c:out value="${reserve.name}" /></td>

				<td><c:out value="${reserve.school}" /></td>

				<td><c:out value="${reserve.dev}" /></td>

				<td><c:out value="${reserve.machingPoint}" /></td>


			</tr>

		</c:forEach>

	</table>



</body>
</html>

