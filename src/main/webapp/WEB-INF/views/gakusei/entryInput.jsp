<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Home</title>
<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>

<script>
  $(function() {


	  //最終学歴のカテゴリ選択時に動く処理
	  $('#category').change(function () =>{

			param={
				category:$('#category').val()
			}

			 $.ajax({
		          type: "get", // method = "GET"
		          url: "/rest/universities", // GET送信先のURL
		          data: param, // JSONデータ本体
		          contentType: 'application/json', // リクエストの Content-Type
		          dataType: "json", // レスポンスをJSONとしてパースする
		          success: function (json_data) { // 200 OK時

					console.log(json_data);
		          	//レスポンス取得時に結果をPulldownへ反映
					$('#school > option').remove();
		          	json_data.forEach( (university)=>{
		          		//取得した結果を元にPullDownの値を追加する
						$('#school').append($('<option>').html(university).val(university));
					});

		          }
			 });

	  });

  });
</script>


<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>

<body>
	<h1>あなたの事を少し教えて下さい。 (step 2/3)</h1>



	<form:form action="/entryInputNext" modelAttribute="entryInputForm">

		<table>
			<tr>
				<td>氏名</td>
				<td><form:input path="name" placeholder="全角で入力下さい" /></td>
			</tr>
			<tr>
				<td>最終学歴</td>
				<td>区分
					<form:select path="category" multiple="false" name="category">
						<form:option value="-" label="--Please Select" />
						<form:option value="国立" label="国立" />
						<form:option value="私立" label="私立" />
						<form:option value="公立" label="公立" />
					</form:select>
					学校
					<form:select path="school">
						<form:option value="-" label="(区分を先に選択してください)" />
					</form:select>

					</td>
			</tr>
			<tr>
				<td>開発経験有無</td>
				<td><form:radiobutton path="dev" label="経験あり" value="True" /><br>
					<form:radiobutton path="dev" label="経験なし" value="False" /><br>
				</td>
			</tr>
			<tr>
				<td>弊社とのマッチングポイント</td>
				<td><form:textarea path="machingPoint" rows="7" cols="100"
						placeholder="思いのたけをどうぞ！" /></td>
			</tr>


		</table>
		<br>
		<input type="submit" value=" 次へ進む ">

	</form:form>


</body>
</html>

