package com.das.users;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContactDetail {
	@Column(name="PHONE_NO")
	private int phoneNo;
	@Column(name="FAX_NO")
	private String faxNo;
	@Column(name="URL")
	private String url;
	@Column(name="EMAIL")
	private String email;
	@Column(name="LOGO_IMAGE")
	private String logo_Image;
	/**
	 * @return the phoneNo
	 */
	public int getPhoneNo() {
		return phoneNo;
	}
	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	/**
	 * @return the faxNo
	 */
	public String getFaxNo() {
		return faxNo;
	}
	/**
	 * @param faxNo the faxNo to set
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the logo_Image
	 */
	public String getLogo_Image() {
		return logo_Image;
	}
	/**
	 * @param logo_Image the logo_Image to set
	 */
	public void setLogo_Image(String logo_Image) {
		this.logo_Image = logo_Image;
	}
}
