package com.das.transactions;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Discount {
@Column(name="DISCOUNT_TYPE")
private Enum discountType;
@Column(name="DISCOUNT_AMOUNT")
private float discountAmount;
@Column(name="START_DATE")
private Date startDate;
@Column(name="END_DATE")
private Date endDate;
/**
 * @return the discountType
 */
public Enum getDiscountType() {
	return discountType;
}
/**
 * @param discountType the discountType to set
 */
public void setDiscountType(Enum discountType) {
	this.discountType = discountType;
}
/**
 * @return the discountAmount
 */
public float getDiscountAmount() {
	return discountAmount;
}
/**
 * @param discountAmount the discountAmount to set
 */
public void setDiscountAmount(float discountAmount) {
	this.discountAmount = discountAmount;
}
/**
 * @return the startDate
 */
public Date getStartDate() {
	return startDate;
}
/**
 * @param startDate the startDate to set
 */
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
/**
 * @return the endDate
 */
public Date getEndDate() {
	return endDate;
}
/**
 * @param endDate the endDate to set
 */
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
}
