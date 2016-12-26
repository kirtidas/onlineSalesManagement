package com.das.sales.order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import com.das.users.Address;
import com.das.users.Customer;
import com.das.users.Supplier;
import com.das.users.User;

@Entity
public class Payment implements IPayment 
{
@Id@GeneratedValue(strategy=GenerationType.AUTO)
private int paymentId;
private float paymentAmount;
private boolean isProcessed;
@ElementCollection
private Set<Address> userAddress=new HashSet<Address>();
@Transient//@ManyToMany(mappedBy="paymentAccepted")
private Collection<Supplier> supplier=new ArrayList();
@ManyToMany(mappedBy="payment")
private Collection<Orders> order=new ArrayList();
@ManyToMany(mappedBy="paymentMethod")
private Collection<Customer> customer=new ArrayList();
/**
 * @return the paymentId
 */
public int getPaymentId() {
	return paymentId;
}
/**
 * @param paymentId the paymentId to set
 */
public void setPaymentId(int paymentId) {
	this.paymentId = paymentId;
}
/**
 * @return the paymentAmount
 */
public float getPaymentAmount() {
	return paymentAmount;
}
/**
 * @param paymentAmount the paymentAmount to set
 */
public void setPaymentAmount(float paymentAmount) {
	this.paymentAmount = paymentAmount;
}
/**
 * @return the isProcessed
 */
public boolean isProcessed() {
	return isProcessed;
}
/**
 * @param isProcessed the isProcessed to set
 */
public void setProcessed(boolean isProcessed) {
	this.isProcessed = isProcessed;
}
public Collection<Supplier> getSupplier() {
	return supplier;
}
public void setSupplier(Collection<Supplier> supplier) {
	this.supplier = supplier;
}
public Collection<Orders> getOrder() {
	return order;
}
public void setOrder(Collection<Orders> order) {
	this.order = order;
}
public Collection<Customer> getCustomer() {
	return customer;
}
public void setCustomer(Collection<Customer> customer) {
	this.customer = customer;
}
public Set<Address> getUserAddress() {
	return userAddress;
}
public void setUserAddress(Set<Address> userAddress) {
	this.userAddress = userAddress;
}


}
