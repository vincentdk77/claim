package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpptext批改文字信息的数据传输对象基类<br>
 * 创建于 2004-11-22 15:24:13.093<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpPtextDtoBase implements Serializable{
    /** 属性批单号次 */
    private String endorseNo = "";
    /** 属性保险单号次 */
    private String policyNo = "";
    /** 属性批文的行号 */
    private int lineNo = 0;
    /** 属性批文内容 */
    private String endorseText = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpPtextDtoBase对象
     */
    public PrpPtextDtoBase(){
    }

    /**
     * 设置属性批单号次
     * @param endorseNo 待设置的属性批单号次的值
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * 获取属性批单号次
     * @return 属性批单号次的值
     */
    public String getEndorseNo(){
        return endorseNo;
    }

    /**
     * 设置属性保险单号次
     * @param policyNo 待设置的属性保险单号次的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保险单号次
     * @return 属性保险单号次的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性批文的行号
     * @param lineNo 待设置的属性批文的行号的值
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * 获取属性批文的行号
     * @return 属性批文的行号的值
     */
    public int getLineNo(){
        return lineNo;
    }

    /**
     * 设置属性批文内容
     * @param endorseText 待设置的属性批文内容的值
     */
    public void setEndorseText(String endorseText){
        this.endorseText = StringUtils.rightTrim(endorseText);
    }

    /**
     * 获取属性批文内容
     * @return 属性批文内容的值
     */
    public String getEndorseText(){
        return endorseText;
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
