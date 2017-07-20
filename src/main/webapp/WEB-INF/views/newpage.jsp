<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WordGame</title>
</head>
<body>
	<h1></h1>
	<br />
	<form action="/wordgame/wordgame" method="get">
		Enter Word : <br /> <input type="text" name="word"> <br>
		<input type="submit" value="Submit"> ${list}
	</form>
</body>
</html>