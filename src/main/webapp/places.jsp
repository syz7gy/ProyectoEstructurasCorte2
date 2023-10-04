<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<link rel="stylesheet" href="styles/placestyle.css">
<title>Places</title>
</head>
<body>
	<div class="wrapper">
		<form action=""></form>
		<h1>In what recent place were you in?</h1>
		<br> <input type="checkbox" class="rounded-checkbox" id="bank" name="places" value="Bank">
		<label for="bank">Bank</label><br> <input type="checkbox" class="rounded-checkbox"
			id="mall" name="places" value="Mall"> <label for="mall">Mall</label><br>
		<input type="checkbox" class="rounded-checkbox" id="cinema" name="places" value="Cinema">
		<label for="cinema">Cinema</label><br> <input type="checkbox" class="rounded-checkbox"
			id="university" name="places" value="University"> <label
			for="university">University</label><br> <input type="checkbox" class="rounded-checkbox"
			id="market" name="places" value="Market"> <label for="market">Market</label><br>
		<input type="checkbox" class="rounded-checkbox" id="clothesshop" name="places"
			value="Clothes shop"> <label for="clothesshop">Clothes
			shop</label><br> <input type="checkbox" class="rounded-checkbox" id="restaurant" name="places"
			value="Restaurant"> <label for="restaurant">Restaurant</label><br>
		<input type="checkbox" class="rounded-checkbox" id="library" name="places" value="Library">
		<label for="library">Library</label><br> <br>
		<button type="submit" class="btn">Add</button>
	</div>
	
	

</body>
</html>