package com.sinosoft.claim.webservice;

import java.io.Serializable;
import com.sinosoft.claim.webservice.ResidentAppRegistInforList;



public class ResidentAppRegistInfor implements Serializable{
	private static final long serialVersionUID = 1L;
	private ResidentAppRegistInforList[] residentAppRegistInforList;
    public ResidentAppRegistInfor(){
		
	}
	public ResidentAppRegistInforList[] getResidentAppRegistInforList() {
		return residentAppRegistInforList;
	}
	public void setResidentAppRegistInforList(ResidentAppRegistInforList[] residentAppRegistInforList) {
		this.residentAppRegistInforList = residentAppRegistInforList;
	}

}
