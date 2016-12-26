<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.Query" %>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="com.das.sales.order.Orders" %>
<%@ page import="com.das.sales.order.OrderDetail" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.das.Brand" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <% 		SessionFactory factory = new Configuration().configure
    	    ("com/das/hibernate/config/hibernate.cfg.xml").buildSessionFactory();
    		Session hqlsession=factory.openSession();
    		hqlsession.beginTransaction();
    		OrderDetail currentOrder = (OrderDetail)hqlsession.get(OrderDetail.class, 1);
    		
	%>
	<%= "<div><h2>Your ORDER is submitted successfully</h2>"+
		"<h3> Your Order Detail is <h3>"+
		//"<h4> product  =" + currentOrder.getProduct().get(0).getProductName()+"<h4>"+
		"<h4> Order cost  ="+ currentOrder.getPrice() +"<h4>"
		+ "</div>" %>
</body>
</html>