package com.das.transactions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class ProdCategory {
@Column(name="CATEGORY_ID")
private int categoryId;
@Column(name="CATEGORY_NAME")
private String categoryName;
@Column(name="DESCRIPTION")
@Lob
private String description;
@Column(name="IMAGE")
private String image;
/**
 * @return the categoryId
 */
public int getCategoryId() {
	return categoryId;
}
/**
 * @param categoryId the categoryId to set
 */
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
/**
 * @return the categoryName
 */
public String getCategoryName() {
	return categoryName;
}
/**
 * @param categoryName the categoryName to set
 */
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
/**
 * @return the description
 */
public String getDescription() {
	return description;
}
/**
 * @param description the description to set
 */
public void setDescription(String description) {
	this.description = description;
}
/**
 * @return the image
 */
public String getImage() {
	return image;
}
/**
 * @param image the image to set
 */
public void setImage(String image) {
	this.image = image;
}
}
