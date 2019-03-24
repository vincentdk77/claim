package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是prpLpayBill的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLpayBillDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性billNo*/
    private String billNo = "";
    /** 属性paymentNo */
    private String paymentNo = "";
    /** 属性registNo */
    private String registNo = "";
    /** 属性compensateNo */
    private String compensateNo = "";
    /** 属性serialNo */
    private int serialNo = 0;
    /** 属性payAmount */
    private double payAmount = 0D;
    /** 属性businessNo */
    private String businessNo = "";

    /**
     *  默认构造方法,构造一个默认的PrpLpayBillDtoBase对象
     */
    public PrpLpayBillDtoBase(){
    }

    
    public String getBillNo() {
		return billNo;
	}


	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}


	/**
     * 设置属性paymentNo
     * @param paymentNo 待设置的属性paymentNo的值
     */
    public void setPaymentNo(String paymentNo){
        this.paymentNo = StringUtils.rightTrim(paymentNo);
    }

    /**
     * 获取属性paymentNo
     * @return 属性paymentNo的值
     */
    public String getPaymentNo(){
        return paymentNo;
    }

    /**
     * 设置属性registNo
     * @param registNo 待设置的属性registNo的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性registNo
     * @return 属性registNo的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性compensateNo
     * @param compensateNo 待设置的属性compensateNo的值
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * 获取属性compensateNo
     * @return 属性compensateNo的值
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * 设置属性serialNo
     * @param serialNo 待设置的属性serialNo的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性serialNo
     * @return 属性serialNo的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性payAmount
     * @param payAmount 待设置的属性payAmount的值
     */
    public void setPayAmount(double payAmount){
        this.payAmount = payAmount;
    }

    /**
     * 获取属性payAmount
     * @return 属性payAmount的值
     */
    public double getPayAmount(){
        return payAmount;
    }


	public String getBusinessNo() {
		return businessNo;
	}


	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
    
}
