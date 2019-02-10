<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript" src="/resources/index.js"></script>

<!-- CSS Starts here -->
<style>
#outerdiv {
	border: 2px solid green;
	margin-top: 2px;
}

#innerdiv {
	border: 2px solid red;
	margin: 3px 3px 3px 3px;
}

#innerdiv p {
	border: 2px solid black;
	text-align: center;
}
</style>

</head>
<body>
	<form action="home" method="post">
		<input type="text" id="username" name="username"> <br> <input
			type="button" value="Check" id="check" /> <input type="submit"
			value="Submit" />
	</form>

	<br />
	<br />
	<input type="text" id="">
	
	<table id="resturantsTbl">
		<tr>
			<th>ID</th>
			<th>Name</th>
		</tr>
	</table>
	<button id="getResturants">Get Resturant</button>
	<div id="innerdiv">
		<p>This is a paragraph</p>
	</div>
	<div id="left">Left</div>
	<div id="center">center</div>
	<div id="right">right</div>


</body>
</html>
