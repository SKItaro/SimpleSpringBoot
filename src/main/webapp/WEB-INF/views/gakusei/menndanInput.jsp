<!-- home.jsp -->
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Home</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script>
  $(function() {
	  $('#reqdate1').datepicker({
		    dateFormat: 'yy年mm月dd日'
	  });
	  $('#reqdate2').datepicker({
		    dateFormat: 'yy年mm月dd日'
	  });

  });
</script>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


<body>
	<h1>面談の希望日程をお聞かせ下さい (step 1/3)</h1>

	<form:form action="/menndanInputNext" modelAttribute="mendanForm" autocomplete="off">


	<!--  <form action="/menndanInputNext" method="post">  -->

		<div>
			希望日程①：
			<form:input id='reqdate1' path ="reqdate1" placeholder="日付けを選択してください" />
			<form:input id='reqtime1' path ="reqtime1" placeholder="時刻(00:00) " />
		</div>

		<div>
			希望日程②：
			<form:input id='reqdate2' path ="reqdate2" placeholder="日付けを選択してください" />
			<form:input id='reqtime2' path ="reqtime2" placeholder="時刻(00:00) " />
		</div>

		<br> <input type="submit" value=" 次へ進む ">

	<!--  </form> -->
	</form:form>



</body>
</html>

