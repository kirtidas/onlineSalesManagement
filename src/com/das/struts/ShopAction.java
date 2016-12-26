package com.das.struts;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.das.Product;
import com.das.sales.order.OrderDetail;
import com.das.sales.order.Orders;
import com.das.sales.order.Payment;
import com.opensymphony.xwork2.ActionSupport; 
public class ShopAction extends  ActionSupport{
	
	private String transactionStatus;
	private boolean fulFilled;
	private boolean paid;
	private float price;
	private int quantity;
	private int total;
	private int size;
	private String color,errLoc,errMsg;
	private float salesTax;
	
		public String execute(){  
		SessionFactory factory = new Configuration().configure
			    ("com/das/hibernate/config/hibernate.cfg.xml").buildSessionFactory();
				Session session=factory.openSession();
				session.beginTransaction();
				Orders orders=new Orders();

				orders.setTransactionStatus(null);
				//orders.setFulFilled(this.fulFilled);
				orders.setPaid(this.paid);
				orders.setErrLoc(this.errLoc);
				orders.setErrMsg(this.errMsg);
				//orders.getPayment().add((Payment)session.get(Payment.class, 15));
				System.out.println("errLoc");
				OrderDetail od=new OrderDetail();
				od.setPrice(this.price);
				od.setQuantity(this.quantity);
				od.setTotal(this.total);
				od.setSize(this.size);
				od.setColor(this.color);
				od.getProduct().add((Product)session.get(Product.class,15));

				session.save(orders);
				session.save(od);
				session.getTransaction().commit();
				session.close();
	           return SUCCESS;  
}

		public String getTransactionStatus() {
			return transactionStatus;
		}

		public void setTransactionStatus(String transactionStatus) {
			this.transactionStatus = transactionStatus;
		}

		public boolean isFulFilled() {
			return fulFilled;
		}

		public void setFulFilled(boolean fulFilled) {
			this.fulFilled = fulFilled;
		}

		public boolean isPaid() {
			return paid;
		}

		public void setPaid(boolean paid) {
			this.paid = paid;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getErrLoc() {
			return errLoc;
		}

		public void setErrLoc(String errLoc) {
			this.errLoc = errLoc;
		}

		public String getErrMsg() {
			return errMsg;
		}

		public void setErrMsg(String errMsg) {
			this.errMsg = errMsg;
		}

		public float getSalesTax() {
			return salesTax;
		}

		public void setSalesTax(float salesTax) {
			this.salesTax = salesTax;
		}
	
}
