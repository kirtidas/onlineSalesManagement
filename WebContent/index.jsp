<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.Query" %>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="com.das.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.das.Brand" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Das Hardware Ltd</title>
</head>
<body>
    <% 		SessionFactory factory = new Configuration().configure
    	    ("com/das/hibernate/config/hibernate.cfg.xml").buildSessionFactory();
    		Session hqlsession=factory.openSession();
    		hqlsession.beginTransaction();
    		Query query = hqlsession.createQuery("from Product");
    		List<Product> list = query.list();
    		Iterator<Product> itr = list.iterator();
    		
   			Query brandQuery = hqlsession.createQuery("from Brand");
    		List<Brand> brandList = brandQuery.list();
    		Iterator<Brand> brandItr = brandList.iterator();
       %> 
	      <form action="ShopServlet" method="post">
		Product:<br><input list="material"  name="Product"><br>
		<datalist id="material">
		<% while(itr.hasNext()){ 
			Product prd = (Product)itr.next();%>
			<%= "<option value=" +prd.getProductName() +">"+prd.getProductName() 
					+ "</option>" %>
		<% } %>

		</datalist>
		Brand:<br><input list="brandlist"  name="Brand"><br>
		<datalist id="brandlist">
		<% while(brandItr.hasNext()){ 
			Brand brnd = (Brand)brandItr.next();%>
			<%= "<option value=" +brnd.getBrandName() +">"+brnd.getBrandName() 
					+ "</option>" %>
		<% } %>

		</datalist>
		OrderDate:<br> <input type="date" name="OrderDate"><br>
		TransactionStatus:<br> 
		<input type="radio" name="TransactionStatus"value="true" checked> True<br> 
		<input type="radio" name="TransactionStatus" value="false"> False<br> 
		FulFilled:<br>
		<input type="radio" name="FulFilled" value="true" checked> True<br>
		<input type="radio" name="FulFilled" value="false"> False<br>
		Paid:<br> 
		<input type="radio" name="Paid" value="true" checked>True <br>
		 <input type="radio" name="Paid" value="false">False<br> 
		Price:<br> <input type="text" name="Price"><br>
		Quantity:<br> <input type="text" name="Quantity"><br>
		Total:<br> <input type="text" name="Total"><br>
		Size:<br> <input type="text" name="Size"><br> 
		Color:<br><input type="text" name="Color"><br>
		ShipDate:<br> <input type="date" name="ShipDate"><br>
	    BillDate:<br> <input type="date" name="BillDate"><br>
	    Discount:<br> <input type="text" name="Discount"><br>
			 <input type="submit" value="submit" />
	</form>
</body>
</html>