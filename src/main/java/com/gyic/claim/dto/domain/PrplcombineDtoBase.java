package com.gyic.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.sysframework.common.util.StringUtils;


public class PrplcombineDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String policyno = "";
    
    private String registno = "";
   
    private String combineno = "";
    
    private double estimateloss = 0D;

    private ArrayList prplcombineDtoList;
    
    public PrplcombineDtoBase(){
    }

    
    public void setPolicyno(String policyno){
        this.policyno = StringUtils.rightTrim(policyno);
    }

    
    public String getPolicyno(){
        return policyno;
    }

   
    public void setRegistno(String registno){
        this.registno = StringUtils.rightTrim(registno);
    }

    
    public String getRegistno(){
        return registno;
    }

    
    public void setCombineno(String combineno){
        this.combineno = StringUtils.rightTrim(combineno);
    }

    
    public String getCombineno(){
        return combineno;
    }


	public ArrayList getPrplcombineDtoList() {
		return prplcombineDtoList;
	}


	public void setPrplcombineDtoList(ArrayList prplcombineDtoList) {
		this.prplcombineDtoList = prplcombineDtoList;
	}


	public double getEstimateloss() {
		return estimateloss;
	}


	public void setEstimateloss(double estimateloss) {
		this.estimateloss = estimateloss;
	}
}
