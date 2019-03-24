package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class PrpLpreChargeDto extends PrpLpreChargeDtoBase implements Serializable{

	public PrpLpreChargeDto() {
		
	}
	
	private ArrayList prpLpreChargeList;

	public ArrayList getPrpLpreChargeList() {
		return prpLpreChargeList;
	}

	public void setPrpLpreChargeList(ArrayList prpLpreChargeList) {
		this.prpLpreChargeList = prpLpreChargeList;
	}

}
