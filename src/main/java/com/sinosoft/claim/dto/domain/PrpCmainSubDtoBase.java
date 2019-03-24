package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.utility.string.Date;

/**
 * 这是prpcmainsub保单隶属表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCmainSubDtoBase implements Serializable{
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性主保单号码 */
    private String mainPolicyNo = "";
    /** 属性批单号码 */
    private String endorseNo = "";
    /** 属性标志字段 */
    private String flag = "";
    /**属性起保日期 */
    private DateTime  startDate =new DateTime();
    /**属性终保日期 */
    private DateTime endDate = new DateTime();
    /**
     *  默认构造方法,构造一个默认的PrpCmainSubDtoBase对象
     */
    public PrpCmainSubDtoBase(){
    }

    /**
     * 设置属性保单号码
     * @param policyNo 待设置的属性保单号码的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号码
     * @return 属性保单号码的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性主保单号码
     * @param mainPolicyNo 待设置的属性主保单号码的值
     */
    public void setMainPolicyNo(String mainPolicyNo){
        this.mainPolicyNo = StringUtils.rightTrim(mainPolicyNo);
    }

    /**
     * 获取属性主保单号码
     * @return 属性主保单号码的值
     */
    public String getMainPolicyNo(){
        return mainPolicyNo;
    }

    /**
     * 设置属性批单号码
     * @param endorseNo 待设置的属性批单号码的值
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * 获取属性批单号码
     * @return 属性批单号码的值
     */
    public String getEndorseNo(){
        return endorseNo;
    }

    /**
     * 设置属性标志字段
     * @param flag 待设置的属性标志字段的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志字段
     * @return 属性标志字段的值
     */
    public String getFlag(){
        return flag;
    }

	/**
	 * @return the startDate
	 */
	public DateTime getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public DateTime getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}

	    
    
}
