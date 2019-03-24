package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpDpersonFeeCodeRisk-人伤费用险种对照表的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpDpersonFeeCodeRiskDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性费用代码 */
    private String feeCode = "";
    /** 属性所属类别 */
    private String feeCategory = "";
    /** 属性强制保险优先级 */
    private int priority = 0;
    /** 属性有效状态位 */
    private int validStatus = 0;
    /** 属性有效日期 */
    private DateTime validDate = new DateTime();

    /**
     *  默认构造方法,构造一个默认的PrpDpersonFeeCodeRiskDtoBase对象
     */
    public PrpDpersonFeeCodeRiskDtoBase(){
    }

    /**
     * 设置属性险种代码
     * @param riskCode 待设置的属性险种代码的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种代码
     * @return 属性险种代码的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性费用代码
     * @param feeCode 待设置的属性费用代码的值
     */
    public void setFeeCode(String feeCode){
        this.feeCode = StringUtils.rightTrim(feeCode);
    }

    /**
     * 获取属性费用代码
     * @return 属性费用代码的值
     */
    public String getFeeCode(){
        return feeCode;
    }

    /**
     * 设置属性所属类别
     * @param feeCategory 待设置的属性所属类别的值
     */
    public void setFeeCategory(String feeCategory){
        this.feeCategory = StringUtils.rightTrim(feeCategory);
    }

    /**
     * 获取属性所属类别
     * @return 属性所属类别的值
     */
    public String getFeeCategory(){
        return feeCategory;
    }

    /**
     * 设置属性强制保险优先级
     * @param priority 待设置的属性强制保险优先级的值
     */
    public void setPriority(int priority){
        this.priority = priority;
    }

    /**
     * 获取属性强制保险优先级
     * @return 属性强制保险优先级的值
     */
    public int getPriority(){
        return priority;
    }

    /**
     * 设置属性有效状态位
     * @param validStatus 待设置的属性有效状态位的值
     */
    public void setValidStatus(int validStatus){
        this.validStatus = validStatus;
    }

    /**
     * 获取属性有效状态位
     * @return 属性有效状态位的值
     */
    public int getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性有效日期
     * @param validDate 待设置的属性有效日期的值
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * 获取属性有效日期
     * @return 属性有效日期的值
     */
    public DateTime getValidDate(){
        return validDate;
    }
}
