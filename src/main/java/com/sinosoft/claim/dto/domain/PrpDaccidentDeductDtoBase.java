package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpDaccidentDeduct-事故责任免赔率的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpDaccidentDeductDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性赔偿责任代码 */
    private String indemnityDuty = "";
    /** 属性风险水平 */
    private String dangerLevel = "";
    /** 属性免赔率 */
    private double deductibleRate = 0D;
    /** 属性有效状态位 */
    private String validStatus = "";
    /** 属性生效日期 */
    private DateTime validDate = new DateTime();
    /** 属性期数 */
    private String deductPeriod = "";

    /**
     *  默认构造方法,构造一个默认的PrpDaccidentDeductDtoBase对象
     */
    public PrpDaccidentDeductDtoBase(){
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
     * 设置属性险别代码
     * @param kindCode 待设置的属性险别代码的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性险别代码
     * @return 属性险别代码的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性赔偿责任代码
     * @param indemnityDuty 待设置的属性赔偿责任代码的值
     */
    public void setIndemnityDuty(String indemnityDuty){
        this.indemnityDuty = StringUtils.rightTrim(indemnityDuty);
    }

    /**
     * 获取属性赔偿责任代码
     * @return 属性赔偿责任代码的值
     */
    public String getIndemnityDuty(){
        return indemnityDuty;
    }

    /**
     * 设置属性风险水平
     * @param dangerLevel 待设置的属性风险水平的值
     */
    public void setDangerLevel(String dangerLevel){
        this.dangerLevel = StringUtils.rightTrim(dangerLevel);
    }

    /**
     * 获取属性风险水平
     * @return 属性风险水平的值
     */
    public String getDangerLevel(){
        return dangerLevel;
    }

    /**
     * 设置属性免赔率
     * @param deductibleRate 待设置的属性免赔率的值
     */
    public void setDeductibleRate(double deductibleRate){
        this.deductibleRate = deductibleRate;
    }

    /**
     * 获取属性免赔率
     * @return 属性免赔率的值
     */
    public double getDeductibleRate(){
        return deductibleRate;
    }

    /**
     * 设置属性有效状态位
     * @param validStatus 待设置的属性有效状态位的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性有效状态位
     * @return 属性有效状态位的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性生效日期
     * @param validDate 待设置的属性生效日期的值
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * 获取属性生效日期
     * @return 属性生效日期的值
     */
    public DateTime getValidDate(){
        return validDate;
    }

    /**
     * 设置属性期数
     * @param deductPeriod 待设置的属性期数的值
     */
    public void setDeductPeriod(String deductPeriod){
        this.deductPeriod = StringUtils.rightTrim(deductPeriod);
    }

    /**
     * 获取属性期数
     * @return 属性期数的值
     */
    public String getDeductPeriod(){
        return deductPeriod;
    }
}
