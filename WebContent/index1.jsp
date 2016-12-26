<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri="/struts-tags" prefix="s" %>
<s:form action="test2"> 
<s:textfield name="FulFilled" label="Order FulFilled"></s:textfield>  
<s:textfield name="Paid" label="Order Paid"></s:textfield>  
<s:textfield name="TransactionStatus" label="Order TransactionStatus"></s:textfield>  
<s:textfield name="Price" label="OrderDetail Price"></s:textfield>  
<s:textfield name="Quantity" label="OrderDetail Quantity"></s:textfield>
<s:textfield name="Total" label="OrderDetail Price"></s:textfield>   
<s:textfield name="Size" label="OrderDetail Price"></s:textfield>   
<s:textfield name="Color" label="OrderDetail Color"></s:textfield> 
 <s:textfield name="errLoc" label="OrderDetail errLoc"></s:textfield>
 <s:textfield name="errMsg" label="OrderDetail errMsg"></s:textfield>
<s:submit value="save"></s:submit>  
</s:form>  
</body>
</html>
