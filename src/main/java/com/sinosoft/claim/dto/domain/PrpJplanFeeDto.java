package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * 这是应收应付费信息表的数据传输对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpJplanFeeDto extends PrpJplanFeeDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性收付日期*/
    private DateTime payRefDate = new DateTime();
    /** 属性收付金额 */
    private double payRefFee = 0D;
    /**
     *  默认构造方法,构造一个默认的PrpJplanFeeDto对象
     */
    public PrpJplanFeeDto(){
    }
	public DateTime getPayRefDate() {
		return payRefDate;
	}
	public void setPayRefDate(DateTime payRefDate) {
		this.payRefDate = payRefDate;
	}
	public double getPayRefFee() {
		return payRefFee;
	}
	public void setPayRefFee(double payRefFee) {
		this.payRefFee = payRefFee;
	}
    
}
