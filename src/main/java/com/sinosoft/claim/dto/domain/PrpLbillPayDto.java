package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * 这是prpLbillPay的数据传输对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLbillPayDto extends PrpLbillPayDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String claimNo = "";
    private String compensateNo = "";
    private String policyNo = "";
    private String routeNum = "";
    private String fkSerialNo = "";
    private String payAmounts = "";
    private String vflag = "";
    private String payReMark = "";
    
    /**
     *  默认构造方法,构造一个默认的PrpLbillPayDto对象
     */
    public PrpLbillPayDto(){
    }
    
    
	public String getCompensateNo() {
		return compensateNo;
	}
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}


	public String getPolicyNo() {
		return policyNo;
	}


	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}


	public String getRouteNum() {
		return routeNum;
	}


	public void setRouteNum(String routeNum) {
		this.routeNum = routeNum;
	}


	public String getFkSerialNo() {
		return fkSerialNo;
	}


	public void setFkSerialNo(String fkSerialNo) {
		this.fkSerialNo = fkSerialNo;
	}


	public String getPayAmounts() {
		return payAmounts;
	}


	public void setPayAmounts(String payAmounts) {
		this.payAmounts = payAmounts;
	}


	public String getClaimNo() {
		return claimNo;
	}


	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}


	public String getVflag() {
		return vflag;
	}


	public void setVflag(String vflag) {
		this.vflag = vflag;
	}


	public String getPayReMark() {
		return payReMark;
	}


	public void setPayReMark(String payReMark) {
		this.payReMark = payReMark;
	}

}
