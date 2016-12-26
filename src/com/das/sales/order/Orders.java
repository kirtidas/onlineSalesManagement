package com.das.sales.order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.das.Brand;
import com.das.Product;
import com.das.users.Customer;
import com.das.users.Supplier;

@Entity
public class Orders implements IOrder {
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	@ManyToMany
	private Collection<Brand> brand=new ArrayList<Brand>();
	@ManyToMany(mappedBy="orders")
	private Collection<Customer> customer=new ArrayList<Customer>();
	private String orderNumber;
	private Date orderDate;
	private float salesTax;
	private Enum transactionStatus;
	private String errLoc,errMsg;
	private boolean fulFilled,paid;
	@ManyToMany
	private Collection<Payment> payment=new ArrayList<Payment>();
	@ManyToMany(mappedBy="currentOrder")
	private Collection<Supplier> supplier=new ArrayList<Supplier>();
	@ManyToMany(mappedBy="currentOrders")
	private Collection<Product> product=new ArrayList<Product>();
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Collection<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(Collection<Customer> customer) {
		this.customer = customer;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public float getSalesTax() {
		return salesTax;
	}
	public void setSalesTax(float salesTax) {
		this.salesTax = salesTax;
	}
	public Enum getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(Enum transactionStatus) {
		this.transactionStatus = transactionStatus;
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
	public Collection<Payment> getPayment() {
		return payment;
	}
	public void setPayment(Collection<Payment> payment) {
		this.payment = payment;
	}
	public Collection<Supplier> getSupplier() {
		return supplier;
	}
	public void setSupplier(Collection<Supplier> supplier) {
		this.supplier = supplier;
	}
	public Collection<Product> getProduct() {
		return product;
	}
	public void setProduct(Collection<Product> product) {
		this.product = product;
	}
	public Collection<Brand> getBrand() {
		return brand;
	}
	public void setBrand(Collection<Brand> brand) {
		this.brand = brand;
	}
	}


