package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * 这是PrpLclaimBillManager的数据传输对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLclaimBillManagerDto extends PrpLclaimBillManagerDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /**
     *  默认构造方法,构造一个默认的PrpLclaimBillManagerDto对象
     */
    public PrpLclaimBillManagerDto(){
    }
    
    private String claimNo = "";
    
    private double havPaid = 0d;
    
    private String fkSerialNo = "";
    
    private String payAmounts = "";
    
    private String payWay = "";
    
    private String payReason = "";
    
    private String payPurpose = "";
    
    private String paymentNo = "";
    
    private String vflag = "";
    
    private String payKey = "";
    
    private String selectFlag = "";
    
    private String underWriteEndDate = "";
    
    private String payReMark = "";
    
	public double getHavPaid() {
		return havPaid;
	}

	public void setHavPaid(double havPaid) {
		this.havPaid = havPaid;
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

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getPayReason() {
		return payReason;
	}

	public void setPayReason(String payReason) {
		this.payReason = payReason;
	}

	public String getPayPurpose() {
		return payPurpose;
	}

	public void setPayPurpose(String payPurpose) {
		this.payPurpose = payPurpose;
	}

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}

	public String getVflag() {
		return vflag;
	}

	public void setVflag(String vflag) {
		this.vflag = vflag;
	}

	public String getPayKey() {
		return payKey;
	}

	public void setPayKey(String payKey) {
		this.payKey = payKey;
	}

	public String getSelectFlag() {
		return selectFlag;
	}

	public void setSelectFlag(String selectFlag) {
		this.selectFlag = selectFlag;
	}

	public String getUnderWriteEndDate() {
		return underWriteEndDate;
	}

	public void setUnderWriteEndDate(String underWriteEndDate) {
		this.underWriteEndDate = underWriteEndDate;
	}

	public String getPayReMark() {
		return payReMark;
	}

	public void setPayReMark(String payReMark) {
		this.payReMark = payReMark;
	}
	
}
