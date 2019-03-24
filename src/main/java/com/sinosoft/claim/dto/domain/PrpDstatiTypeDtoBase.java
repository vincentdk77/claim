package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdstatitype险种统计分类表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDstatiTypeDtoBase implements Serializable{
    /** 属性险种 */
    private String riskCode = "";
    /** 属性险别 */
    private String kindCode = "";
    /** 属性统计类型 */
    private String belongType = "";
    /** 属性生效日期 */
    private DateTime validDate = new DateTime();
    /** 属性预留标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDstatiTypeDtoBase对象
     */
    public PrpDstatiTypeDtoBase(){
    }

    /**
     * 设置属性险种
     * @param riskCode 待设置的属性险种的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种
     * @return 属性险种的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性险别
     * @param kindCode 待设置的属性险别的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性险别
     * @return 属性险别的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性统计类型
     * @param belongType 待设置的属性统计类型的值
     */
    public void setBelongType(String belongType){
        this.belongType = StringUtils.rightTrim(belongType);
    }

    /**
     * 获取属性统计类型
     * @return 属性统计类型的值
     */
    public String getBelongType(){
        return belongType;
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
     * 设置属性预留标志
     * @param flag 待设置的属性预留标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性预留标志
     * @return 属性预留标志的值
     */
    public String getFlag(){
        return flag;
    }
}
