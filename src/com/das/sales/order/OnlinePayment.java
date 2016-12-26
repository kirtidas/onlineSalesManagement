package com.das.sales.order;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OnlinePayment extends Payment {
	
	@Column(name="CREDIT_CARD")
	private String creditCard;
		@Column(name="CREDIT_CARD_TYPE_ID")
	private int cerditCardTypeId;
		@Column(name="CARD_EXP_MO")
	private String cardExpMo;
		@Column(name="CARD_EXP_YR")
	private String cardExpYr;
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public int getCerditCardTypeId() {
		return cerditCardTypeId;
	}
	public void setCerditCardTypeId(int cerditCardTypeId) {
		this.cerditCardTypeId = cerditCardTypeId;
	}
	public String getCardExpMo() {
		return cardExpMo;
	}
	public void setCardExpMo(String cardExpMo) {
		this.cardExpMo = cardExpMo;
	}
	public String getCardExpYr() {
		return cardExpYr;
	}
	public void setCardExpYr(String cardExpYr) {
		this.cardExpYr = cardExpYr;
	}
}
