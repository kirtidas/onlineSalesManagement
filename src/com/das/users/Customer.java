package com.das.users;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.das.sales.order.OnlinePayment;
import com.das.sales.order.Orders;
import com.das.sales.order.Payment;
@Entity
public class Customer extends User {

	private String firstName,lastName;
	private Date customerSience;
	@ElementCollection
	private Set<Address> shippingAddress=new HashSet<Address>();
	@ElementCollection
	private Set<Address> billingAddress=new HashSet<Address>();
	@ManyToMany(cascade = {CascadeType.ALL})
	private Collection<Payment> paymentMethod=new ArrayList<Payment>();
	@ManyToMany
	private Collection<Orders> orders=new ArrayList<Orders>();

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the customerSience
	 */
	public Date getCustomerSience() {
		return customerSience;
	}
	/**
	 * @param customerSience the customerSience to set
	 */
	public void setCustomerSience(Date customerSience) {
		this.customerSience = customerSience;
	}
/*	*//**
	 * @return the supplierContactDetail
	 *//*
	public Set<ContactDetail> getSupplierContactDetail() {
		return supplierContactDetail;
	}
	*//**
	 * @param supplierContactDetail the supplierContactDetail to set
	 *//*
	public void setSupplierContactDetail(Set<ContactDetail> supplierContactDetail) {
		this.supplierContactDetail = supplierContactDetail;
	}*/
	/**
	 * @return the shippingAddress
	 */
	public Set<Address> getShippingAddress() {
		return shippingAddress;
	}
	/**
	 * @param shippingAddress the shippingAddress to set
	 */
	public void setShippingAddress(Set<Address> shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	/**
	 * @return the billingAddress
	 */
	public Set<Address> getBillingAddress() {
		return billingAddress;
	}
	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(Set<Address> billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Collection<Payment> getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(Collection<Payment> paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Collection<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Collection<Orders> orders) {
		this.orders = orders;
	}
	
	
	}
	

