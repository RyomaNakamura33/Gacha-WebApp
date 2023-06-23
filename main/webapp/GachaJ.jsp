<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="entity.Character" %>
<%@ page import="servlet.GachaServ" %>
<%
List<Character> Resultlist = (List<Character>) request.getAttribute("Result");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="gacha.css">
	<title>ガチャ</title>
	<style>
		body {
			background-color: #f2f2f2;
			font-family: Arial, sans-serif;
			margin: 0;
			padding: 0;
		}
		.container {
			width: 80%;
			margin: 0 auto;
			padding: 20px;
			background-color: #fff;
			box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
		}
		h1 {
			font-size: 28px;
			font-weight: bold;
			text-align: center;
			margin-bottom: 20px;
		}
		table {
			width: 100%;
			border-collapse: collapse;
			margin-bottom: 20px;
		}
		th, td {
			padding: 10px;
			text-align: center;
			border-bottom: 1px solid #ccc;
		}
		.confetti {
			/* Add your confetti styles here */
		}
		form {
			text-align: center;
		}
		button {
			font-size: 16px;
			padding: 10px 20px;
			border: none;
			background-color: #4285f4;
			color: #fff;
			border-radius: 4px;
			cursor: pointer;
			margin-right: 10px;
		}
	</style>
</head>
<body>
	<div class="container">
		<h1>ガチャ</h1>
		<div class="confetti"></div>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>レアリティ</th>
					<th>名前</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (Resultlist != null) {
					for (Character c : Resultlist) {
				%>
				<tr>
					<td><%=c.getId().toInt()%></td>
					<td><%=c.getRarity().toString()%></td>
					<td><%=c.getname().toString()%><br>
				</tr>
				<%
					}
				}
				%>
			</tbody>
		</table>
		<form action="/GachaWeb/GachaServ" method="POST">
			<button type="submit" name="Action" value="1">単発</button>
			<button type="submit" name="Action" value="10">10連</button>
		</form>
	</div>
</body>
</html>


