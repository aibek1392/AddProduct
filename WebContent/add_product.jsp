<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Form</title>
</head>
<body>
<div style="text-align: center;">
	<div>
			<button><a href="index.jsp"> Search product by ID</a></button>
		</div>
	<h1>Product Form</h1>
	<b style="width: 50%;border: 1px solid black">Please enter the following details to add a product</b>
	<br>
	<br>
	<form style="text-align: center;  display: inline-block;
    display: -moz-inline-box;
    *display: inline; 
    zoom: 1;
    margin-left: 2%;
    width: 32%;
    margin-left: 0;
    text-align: center;" action="addproduct" method="post">
		 Product Name: <input placeholder="enter product name" style="margin-left: 0" type="text" name="name" required="required"> <br>
		Product Price: <input placeholder="enter product price" style="margin-left: 5.5pt" type="text"  name="price" pattern=[0-9]{1,10}(.[0-9]{1,2})?$ title="Max 10 digits, and maximum 2 decimal places allowed" required="required"><br>
	 Product Category: <input placeholder="Electroinics, Furniture etc." style="margin-right: 13pt" type="text" name="category" required="required"> <br>
		<input style="padding: 5pt;margin: 5pt; background-color:red; border-radius: 10px" type="submit" value="Add Product">
	</form>
	</div>
</body>
</html>