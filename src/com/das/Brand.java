/**
 * 
 */
package com.das;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.das.sales.order.Orders;
import com.das.users.Supplier;

/**
 * @author Kirti
 *
 */
@Entity
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int brandId;
	private String brandName;
	@ManyToMany(mappedBy = "brand")
	private Collection<Product> products = new ArrayList<Product>();
	@ManyToMany(mappedBy = "brand")
	private Collection<Orders> orders = new ArrayList<Orders>();

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Collection<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Orders> orders) {
		this.orders = orders;
	}

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	@Override
	public boolean equals(Object obj){
		if(obj !=null && obj instanceof Brand){
			if(((Brand)obj).getBrandName().equalsIgnoreCase(this.getBrandName())){
				return true;
			}
			return false;
		}else if(obj !=null && obj instanceof String){
			if(((String)obj).equalsIgnoreCase(this.getBrandName())){
				return true;
			}
		}
		return false;
	}
}
