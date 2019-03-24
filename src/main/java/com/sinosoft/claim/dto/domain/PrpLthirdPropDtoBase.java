package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLthirdProp-财产损失部位表的数据传输对象基类<br>
 * 创建于 2005-04-12 16:23:32.046<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLthirdPropDtoBase implements Serializable{
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性损失项目序号 */
    private int serialNo = 0;
    /** 属性车牌号码 */
    private String licenseNo = "";
    /** 属性财产损失部位代码 */
    private String lossItemCode = "";
    /** 属性财产损失部位名称 */
    private String lossItemName = "";
    /** 属性损失程序描述 */
    private String lossItemDesc = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLthirdPropDtoBase对象
     */
    public PrpLthirdPropDtoBase(){
    }

    /**
     * 设置属性报案号码
     * @param registNo 待设置的属性报案号码的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号码
     * @return 属性报案号码的值
     */
    public String getRegistNo(){
        return registNo;
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
     * 设置属性损失项目序号
     * @param serialNo 待设置的属性损失项目序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性损失项目序号
     * @return 属性损失项目序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性车牌号码
     * @param licenseNo 待设置的属性车牌号码的值
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * 获取属性车牌号码
     * @return 属性车牌号码的值
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * 设置属性财产损失部位代码
     * @param lossItemCode 待设置的属性财产损失部位代码的值
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * 获取属性财产损失部位代码
     * @return 属性财产损失部位代码的值
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * 设置属性财产损失部位名称
     * @param lossItemName 待设置的属性财产损失部位名称的值
     */
    public void setLossItemName(String lossItemName){
        this.lossItemName = StringUtils.rightTrim(lossItemName);
    }

    /**
     * 获取属性财产损失部位名称
     * @return 属性财产损失部位名称的值
     */
    public String getLossItemName(){
        return lossItemName;
    }

    /**
     * 设置属性损失程序描述
     * @param lossItemDesc 待设置的属性损失程序描述的值
     */
    public void setLossItemDesc(String lossItemDesc){
        this.lossItemDesc = StringUtils.rightTrim(lossItemDesc);
    }

    /**
     * 获取属性损失程序描述
     * @return 属性损失程序描述的值
     */
    public String getLossItemDesc(){
        return lossItemDesc;
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
