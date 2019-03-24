package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpcrenewal续保信息表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCrenewalDtoBase implements Serializable{
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性原保单号码 */
    private String oldPolicyNo = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCrenewalDtoBase对象
     */
    public PrpCrenewalDtoBase(){
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
     * 设置属性原保单号码
     * @param oldPolicyNo 待设置的属性原保单号码的值
     */
    public void setOldPolicyNo(String oldPolicyNo){
        this.oldPolicyNo = StringUtils.rightTrim(oldPolicyNo);
    }

    /**
     * 获取属性原保单号码
     * @return 属性原保单号码的值
     */
    public String getOldPolicyNo(){
        return oldPolicyNo;
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
}
