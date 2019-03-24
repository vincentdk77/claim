package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLFISCALpaymain的数据传输对象基类<br>
 */
public class PrplfiscalpaymainDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性支付清单号 */
    private String fiscalno = "";
    /** 属性报案号 */
    private String registno = "";
    /** 属性清单总金额 */
    private double sumamount = 0D;
    /** 属性操作人 */
    private String operatorcode = "";
    /** 属性操作时间 */
    private DateTime inputdate = new DateTime();
    /** 属性操作机构 */
    private String operatorcomcode = "";
    /** 属性标识 */
    private String vflag = "";
    /** 属性状态 */
    private String status = "";
    /** 属性赔款类型*/
    private String paymenttype = "";

    /**
     *  默认构造方法,构造一个默认的PrplfiscalpaymainDtoBase对象
     */
    public PrplfiscalpaymainDtoBase(){
    }

    /**
     * 设置属性支付清单号
     * @param fiscalno 待设置的属性支付清单号的值
     */
    public void setFiscalno(String fiscalno){
        this.fiscalno = StringUtils.rightTrim(fiscalno);
    }

    /**
     * 获取属性支付清单号
     * @return 属性支付清单号的值
     */
    public String getFiscalno(){
        return fiscalno;
    }

    /**
     * 设置属性报案号
     * @param registno 待设置的属性报案号的值
     */
    public void setRegistno(String registno){
        this.registno = StringUtils.rightTrim(registno);
    }

    /**
     * 获取属性报案号
     * @return 属性报案号的值
     */
    public String getRegistno(){
        return registno;
    }

    /**
     * 设置属性清单总金额
     * @param sumamount 待设置的属性清单总金额的值
     */
    public void setSumamount(double sumamount){
        this.sumamount = sumamount;
    }

    /**
     * 获取属性清单总金额
     * @return 属性清单总金额的值
     */
    public double getSumamount(){
        return sumamount;
    }

    /**
     * 设置属性操作人
     * @param operatorcode 待设置的属性操作人的值
     */
    public void setOperatorcode(String operatorcode){
        this.operatorcode = StringUtils.rightTrim(operatorcode);
    }

    /**
     * 获取属性操作人
     * @return 属性操作人的值
     */
    public String getOperatorcode(){
        return operatorcode;
    }

    /**
     * 设置属性操作时间
     * @param inputdate 待设置的属性操作时间的值
     */
    public void setInputdate(DateTime inputdate){
        this.inputdate = inputdate;
    }

    /**
     * 获取属性操作时间
     * @return 属性操作时间的值
     */
    public DateTime getInputdate(){
        return inputdate;
    }

    /**
     * 设置属性操作机构
     * @param operatorcomcode 待设置的属性操作机构的值
     */
    public void setOperatorcomcode(String operatorcomcode){
        this.operatorcomcode = StringUtils.rightTrim(operatorcomcode);
    }

    /**
     * 获取属性操作机构
     * @return 属性操作机构的值
     */
    public String getOperatorcomcode(){
        return operatorcomcode;
    }

    /**
     * 设置属性标识
     * @param vflag 待设置的属性标识的值
     */
    public void setVflag(String vflag){
        this.vflag = StringUtils.rightTrim(vflag);
    }

    /**
     * 获取属性标识
     * @return 属性标识的值
     */
    public String getVflag(){
        return vflag;
    }

    /**
     * 设置属性状态
     * @param status 待设置的属性状态的值
     */
    public void setStatus(String status){
        this.status = StringUtils.rightTrim(status);
    }

    /**
     * 获取属性状态
     * @return 属性状态的值
     */
    public String getStatus(){
        return status;
    }

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
    
    
}
