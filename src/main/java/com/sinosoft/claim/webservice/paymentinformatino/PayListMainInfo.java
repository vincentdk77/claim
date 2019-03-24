package com.sinosoft.claim.webservice.paymentinformatino;

import java.io.Serializable;
import com.sinosoft.claim.webservice.dto.PaymentListInfo;

/**
 * 支付信息回访（主信息）
 * @author Administrator
 *
 */

public class PayListMainInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private PaymentInfoBackList[] paymentInfoBackList;
	
	public PayListMainInfo(){
		
	}

	public PaymentInfoBackList[] getPaymentInfoBackList() {
		return paymentInfoBackList;
	}

	public void setPaymentInfoBackList(PaymentInfoBackList[] paymentInfoBackList) {
		this.paymentInfoBackList = paymentInfoBackList;
	}
	
	
}
