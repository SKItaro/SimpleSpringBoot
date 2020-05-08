<!-- home.jsp -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<title>Home</title>
<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>

<body>
	<h1>ありがとうございました。</h1>
	<h3>当日を心待ちにしております</h3>


		<table>

			<tr>
				<td>希望日１</td>
				<td>
					<c:out value="${mendanForm.reqdate1} ${mendanForm.reqtime1} " />
				</td>
			</tr>

			<tr>
				<td>希望日２</td>
				<td>
					<c:out value="${mendanForm.reqdate2} ${mendanForm.reqtime2} " />
				</td>
			</tr>

			<tr>
				<td>氏名.</td>
				<td>
					<c:out value="${entryInputForm.name}" />
				</td>
			</tr>
			<tr>
				<td>最終学歴</td>
				<td>
					<c:out value="${entryInputForm.school}" />
				</td>
			</tr>
			<tr>
				<td>開発経験有無</td>
				<td>
					<c:out value="${entryInputForm.dev}" />
				</td>
			</tr>
			<tr>
				<td>弊社とのマッチングポイント</td>
				<td>
					<c:out value="${entryInputForm.machingPoint}" />
				</td>
			</tr>
		</table>




</body>
</html>

