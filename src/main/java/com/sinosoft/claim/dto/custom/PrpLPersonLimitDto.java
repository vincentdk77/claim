package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpLPersonLimit人员险种对照表的数据传输对象基类<br>
 * 创建于 2005-11-15 <br>
 * @author qinyongli
 */
public class PrpLPersonLimitDto implements Serializable{
    /** 属性人员代码*/
    private String userCode = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLPersonLimitDto对象
     */
    public PrpLPersonLimitDto(){
    }

    /**
     * 设置属性人员代码
     * @param userCode 待设置的属性人员代码
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * 获取属性人员代码
     * @return 属性人员代码
     */
    public String getUserCode(){
        return userCode;
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
