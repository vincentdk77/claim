package com.sinosoft.claim.ui.view.formbean;

import org.apache.struts.action.ActionForm;

import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.dto.domain.PrplregisthisDto;
import com.sinosoft.workbench.claim.dto.domain.PrpLregistDto;

public class PrplPayForm extends ActionForm{
    private PrplpayDto prplpay=new PrplpayDto();
    private PrpLpaymainDto prplpaymain = new PrpLpaymainDto();
    private PrpLregistDto prplregist = new PrpLregistDto();

    public PrplpayDto getPrplpay() {
        return prplpay;
    }

    public void setPrplpay(PrplpayDto prplpay) {
        this.prplpay = prplpay;
    }

	public PrpLpaymainDto getPrplpaymain() {
		return prplpaymain;
	}

	public void setPrplpaymain(PrpLpaymainDto prplpaymain) {
		this.prplpaymain = prplpaymain;
	}

	public PrpLregistDto getPrplregist() {
		return prplregist;
	}

	public void setPrplregist(PrpLregistDto prplregist) {
		this.prplregist = prplregist;
	}
    
}
