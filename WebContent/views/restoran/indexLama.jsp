<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<%
			String email = null;
				Cookie[] cookies = request.getCookies();
				if(cookies !=null)
				{
				for(Cookie cookie : cookies)
				{
				    if(cookie.getName().equals("email")) 
				    	email = cookie.getValue();
				}
				}
				
			if (email != null) {
		%>
		
		<p><%=email%></p>
		<%
			}
		%>
		
		<div class="shopping-cart">

				<div class="column-labels">
					<label class="product-details">Nama Menu</label> 
					<label class="product-price">Harga</label> 
					<label class="product-quantity">Kuantitas</label>
					<label class="product-line-price">Total Harga</label>
				</div>
		</div>
		
</body>
</html>