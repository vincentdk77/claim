package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpCreditAssure风险预警确认函号表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCreditAssureDtoBase implements Serializable{
    /** 属性风险预警确认函号 */
    private String confirmNo = "";
    /** 属性风险预警号 */
    private String investigateNo = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCreditAssureDtoBase对象
     */
    public PrpCreditAssureDtoBase(){
    }

    /**
     * 设置属性风险预警确认函号
     * @param confirmNo 待设置的属性风险预警确认函号的值
     */
    public void setConfirmNo(String confirmNo){
        this.confirmNo = StringUtils.rightTrim(confirmNo);
    }

    /**
     * 获取属性风险预警确认函号
     * @return 属性风险预警确认函号的值
     */
    public String getConfirmNo(){
        return confirmNo;
    }

    /**
     * 设置属性风险预警号
     * @param investigateNo 待设置的属性风险预警号的值
     */
    public void setInvestigateNo(String investigateNo){
        this.investigateNo = StringUtils.rightTrim(investigateNo);
    }

    /**
     * 获取属性风险预警号
     * @return 属性风险预警号的值
     */
    public String getInvestigateNo(){
        return investigateNo;
    }

    /**
     * 设置属性标志位
     * @param flag 待设置的属性标志位的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志位
     * @return 属性标志位的值
     */
    public String getFlag(){
        return flag;
    }
}
