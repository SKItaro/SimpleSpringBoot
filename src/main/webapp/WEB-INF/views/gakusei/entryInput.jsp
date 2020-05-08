<%@ page contentType="text/html; charset=UTF-8"%>
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
	<h1>あなたの事を少し教えて下さい。 (step 2/3)</h1>



	<form:form action="/entryInputNext" modelAttribute="entryInputForm">

		<table>
			<tr>
				<td>氏名</td>
				<td>
					<form:input path="name" placeholder="全角で入力下さい" />
				</td>
			</tr>
			<tr>
				<td>最終学歴</td>
				<td>
					<form:input path="school" placeholder="学校・学部" />
				</td>
			</tr>
			<tr>
				<td>開発経験有無</td>
				<td>
				 	<form:radiobutton path="dev" label="経験あり" value="True" /><br>
					<form:radiobutton path="dev" label="経験なし" value="False" /><br>
				</td>
			</tr>
			<tr>
				<td>弊社とのマッチングポイント</td>
				<td>
				    <form:textarea path="machingPoint" rows="7" cols="100" placeholder="思いのたけをどうぞ！" />
				</td>
			</tr>


		</table>
		<br> <input type="submit" value=" 次へ進む ">

	</form:form>


</body>
</html>

