package com.das.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import com.das.Product;
import com.das.sales.order.Orders;
import com.das.sales.order.Payment;
import com.das.transactions.Discount;

@Entity
public class Supplier {
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private int supplierID;
	private String companyName,contactFName,contactLName;
	@ElementCollection
	private Set<ContactDetail> supplierContactDetail=new HashSet<ContactDetail>();
	@ManyToMany
	private Collection<Product> suppliedProducts=new ArrayList<Product>();
	@ManyToMany
	private Collection<Payment> paymentAccepted=new ArrayList<Payment>();
	@ManyToMany
	private Collection<Orders> currentOrder=new ArrayList<Orders>();
	@ElementCollection
	private Set<Discount>discounts=new HashSet<Discount>();
	private Date supplierSience;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactFName() {
		return contactFName;
	}
	public void setContactFName(String contactFName) {
		this.contactFName = contactFName;
	}
	public String getContactLName() {
		return contactLName;
	}
	public void setContactLName(String contactLName) {
		this.contactLName = contactLName;
	}
	public Set<ContactDetail> getSupplierContactDetail() {
		return supplierContactDetail;
	}
	public void setSupplierContactDetail(Set<ContactDetail> supplierContactDetail) {
		this.supplierContactDetail = supplierContactDetail;
	}
	public Collection<Product> getSuppliedProducts() {
		return suppliedProducts;
	}
	public void setSuppliedProducts(Collection<Product> suppliedProducts) {
		this.suppliedProducts = suppliedProducts;
	}
	public Collection<Payment> getPaymentAccepted() {
		return paymentAccepted;
	}
	public void setPaymentAccepted(Collection<Payment> paymentAccepted) {
		this.paymentAccepted = paymentAccepted;
	}
	public Collection<Orders> getCurrentOrder() {
		return currentOrder;
	}
	public void setCurrentOrder(Collection<Orders> currentOrder) {
		this.currentOrder = currentOrder;
	}
	public Set<Discount> getDiscounts() {
		return discounts;
	}
	public void setDiscounts(Set<Discount> discounts) {
		this.discounts = discounts;
	}
	public Date getSupplierSience() {
		return supplierSience;
	}
	public void setSupplierSience(Date supplierSience) {
		this.supplierSience = supplierSience;
	}
}
