package com.das.users;
import javax.persistence.Embeddable;
import javax.persistence.Column;
@Embeddable
public class Address {
	
	@Column(name="STATE_NAME")
	private String state;
	@Column(name="COUNTRY_NAME")
	private String country;
	@Column(name="CITY_NAME")
	private String city;
	@Column(name="POSTAL_CODE")
	private int postalCode;
	@Column(name="ADDRESS_LINE1")
	private String addressLine1;
	@Column(name="ADDRESS_LINE2")
	private String addressLine2;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLin2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
}
