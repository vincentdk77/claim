package com.sinosoft.claim.ui.view.formbean;

import org.apache.struts.action.ActionForm;

import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.dto.domain.PrplfiscalpaydetailDto;
import com.sinosoft.claim.dto.domain.PrplfiscalpaymainDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.dto.domain.PrplregisthisDto;
import com.sinosoft.workbench.claim.dto.domain.PrpLregistDto;

public class PrplFiscalPayForm extends ActionForm{
    private PrplfiscalpaymainDto prplfiscalpaymainDto=new PrplfiscalpaymainDto();
    private PrplfiscalpaydetailDto prplfiscalpaydetailDto = new PrplfiscalpaydetailDto();
    private PrpLregistDto prplregist = new PrpLregistDto();

	public PrplfiscalpaymainDto getPrplfiscalpaymainDto() {
		return prplfiscalpaymainDto;
	}

	public void setPrplfiscalpaymainDto(PrplfiscalpaymainDto prplfiscalpaymainDto) {
		this.prplfiscalpaymainDto = prplfiscalpaymainDto;
	}

	public PrplfiscalpaydetailDto getPrplfiscalpaydetailDto() {
		return prplfiscalpaydetailDto;
	}

	public void setPrplfiscalpaydetailDto(
			PrplfiscalpaydetailDto prplfiscalpaydetailDto) {
		this.prplfiscalpaydetailDto = prplfiscalpaydetailDto;
	}

	public PrpLregistDto getPrplregist() {
		return prplregist;
	}

	public void setPrplregist(PrpLregistDto prplregist) {
		this.prplregist = prplregist;
	}
    
}
