package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdratecond费率条件表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrateCondDtoBase implements Serializable{
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性启用日期 */
    private DateTime validDate = new DateTime();
    /** 属性费率期数 */
    private int ratePeriod = 0;
    /** 属性条件代码 */
    private String condCode = "";
    /** 属性条件名称 */
    private String condName = "";
    /** 属性条件取值下限 */
    private double lowerValue = 0d;
    /** 属性条件取值上限 */
    private double upperValue = 0d;
    /** 属性取值代码 */
    private String valueCode = "";
    /** 属性取值名称 */
    private String valueName = "";
    /** 属性起始位置 */
    private int startpos = 0;
    /** 属性终止位置 */
    private int endpos = 0;
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDrateCondDtoBase对象
     */
    public PrpDrateCondDtoBase(){
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
     * 设置属性启用日期
     * @param validDate 待设置的属性启用日期的值
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * 获取属性启用日期
     * @return 属性启用日期的值
     */
    public DateTime getValidDate(){
        return validDate;
    }

    /**
     * 设置属性费率期数
     * @param ratePeriod 待设置的属性费率期数的值
     */
    public void setRatePeriod(int ratePeriod){
        this.ratePeriod = ratePeriod;
    }

    /**
     * 获取属性费率期数
     * @return 属性费率期数的值
     */
    public int getRatePeriod(){
        return ratePeriod;
    }

    /**
     * 设置属性条件代码
     * @param condCode 待设置的属性条件代码的值
     */
    public void setCondCode(String condCode){
        this.condCode = StringUtils.rightTrim(condCode);
    }

    /**
     * 获取属性条件代码
     * @return 属性条件代码的值
     */
    public String getCondCode(){
        return condCode;
    }

    /**
     * 设置属性条件名称
     * @param condName 待设置的属性条件名称的值
     */
    public void setCondName(String condName){
        this.condName = StringUtils.rightTrim(condName);
    }

    /**
     * 获取属性条件名称
     * @return 属性条件名称的值
     */
    public String getCondName(){
        return condName;
    }

    /**
     * 设置属性条件取值下限
     * @param lowerValue 待设置的属性条件取值下限的值
     */
    public void setLowerValue(double lowerValue){
        this.lowerValue = lowerValue;
    }

    /**
     * 获取属性条件取值下限
     * @return 属性条件取值下限的值
     */
    public double getLowerValue(){
        return lowerValue;
    }

    /**
     * 设置属性条件取值上限
     * @param upperValue 待设置的属性条件取值上限的值
     */
    public void setUpperValue(double upperValue){
        this.upperValue = upperValue;
    }

    /**
     * 获取属性条件取值上限
     * @return 属性条件取值上限的值
     */
    public double getUpperValue(){
        return upperValue;
    }

    /**
     * 设置属性取值代码
     * @param valueCode 待设置的属性取值代码的值
     */
    public void setValueCode(String valueCode){
        this.valueCode = StringUtils.rightTrim(valueCode);
    }

    /**
     * 获取属性取值代码
     * @return 属性取值代码的值
     */
    public String getValueCode(){
        return valueCode;
    }

    /**
     * 设置属性取值名称
     * @param valueName 待设置的属性取值名称的值
     */
    public void setValueName(String valueName){
        this.valueName = StringUtils.rightTrim(valueName);
    }

    /**
     * 获取属性取值名称
     * @return 属性取值名称的值
     */
    public String getValueName(){
        return valueName;
    }

    /**
     * 设置属性起始位置
     * @param startpos 待设置的属性起始位置的值
     */
    public void setStartpos(int startpos){
        this.startpos = startpos;
    }

    /**
     * 获取属性起始位置
     * @return 属性起始位置的值
     */
    public int getStartpos(){
        return startpos;
    }

    /**
     * 设置属性终止位置
     * @param endpos 待设置的属性终止位置的值
     */
    public void setEndpos(int endpos){
        this.endpos = endpos;
    }

    /**
     * 获取属性终止位置
     * @return 属性终止位置的值
     */
    public int getEndpos(){
        return endpos;
    }

    /**
     * 设置属性标志
     * @param flag 待设置的属性标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志
     * @return 属性标志的值
     */
    public String getFlag(){
        return flag;
    }
}
