package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLcheckLoss-查勘事故估损金额表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.531<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcheckLossDtoBase implements Serializable{
    /** 属性出险登记号 */
    private String registNo = "";
    /** 属性赔案号码 */
    private String claimNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性关联理赔车辆序号  (三者金额为汇总还是针对每辆车) */
    private int referSerialNo = 0;
    /** 属性险别编码--** 车损险
--** 三者险
--** 其他附加险 */
    private String kindCode = "";
    /** 属性金额类型
--** 车损部分：
--** 1. 标的损失
--** 2. 施救费
--** 3. 吊车
--** 4. 拖车
--** 5. 其他
--** 三者部分
--** 1. 车辆
--** 2. 人员
--** 3. 财产 */
    private String lossFeeType = "";
    /** 属性损失金额 */
    private double lossFee = 0d;
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLcheckLossDtoBase对象
     */
    public PrpLcheckLossDtoBase(){
    }

    /**
     * 设置属性出险登记号
     * @param registNo 待设置的属性出险登记号的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性出险登记号
     * @return 属性出险登记号的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性赔案号码
     * @param claimNo 待设置的属性赔案号码的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号码
     * @return 属性赔案号码的值
     */
    public String getClaimNo(){
        return claimNo;
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
     * 设置属性序号
     * @param serialNo 待设置的属性序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号
     * @return 属性序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性关联理赔车辆序号  (三者金额为汇总还是针对每辆车)
     * @param referSerialNo 待设置的属性关联理赔车辆序号  (三者金额为汇总还是针对每辆车)的值
     */
    public void setReferSerialNo(int referSerialNo){
        this.referSerialNo = referSerialNo;
    }

    /**
     * 获取属性关联理赔车辆序号  (三者金额为汇总还是针对每辆车)
     * @return 属性关联理赔车辆序号  (三者金额为汇总还是针对每辆车)的值
     */
    public int getReferSerialNo(){
        return referSerialNo;
    }

    /**
     * 设置属性险别编码--** 车损险
--** 三者险
--** 其他附加险
     * @param kindCode 待设置的属性险别编码--** 车损险
--** 三者险
--** 其他附加险的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性险别编码--** 车损险
--** 三者险
--** 其他附加险
     * @return 属性险别编码--** 车损险
--** 三者险
--** 其他附加险的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性金额类型
--** 车损部分：
--** 1. 标的损失
--** 2. 施救费
--** 3. 吊车
--** 4. 拖车
--** 5. 其他
--** 三者部分
--** 1. 车辆
--** 2. 人员
--** 3. 财产
     * @param lossFeeType 待设置的属性金额类型
--** 车损部分：
--** 1. 标的损失
--** 2. 施救费
--** 3. 吊车
--** 4. 拖车
--** 5. 其他
--** 三者部分
--** 1. 车辆
--** 2. 人员
--** 3. 财产的值
     */
    public void setLossFeeType(String lossFeeType){
        this.lossFeeType = StringUtils.rightTrim(lossFeeType);
    }

    /**
     * 获取属性金额类型
--** 车损部分：
--** 1. 标的损失
--** 2. 施救费
--** 3. 吊车
--** 4. 拖车
--** 5. 其他
--** 三者部分
--** 1. 车辆
--** 2. 人员
--** 3. 财产
     * @return 属性金额类型
--** 车损部分：
--** 1. 标的损失
--** 2. 施救费
--** 3. 吊车
--** 4. 拖车
--** 5. 其他
--** 三者部分
--** 1. 车辆
--** 2. 人员
--** 3. 财产的值
     */
    public String getLossFeeType(){
        return lossFeeType;
    }

    /**
     * 设置属性损失金额
     * @param lossFee 待设置的属性损失金额的值
     */
    public void setLossFee(double lossFee){
        this.lossFee = lossFee;
    }

    /**
     * 获取属性损失金额
     * @return 属性损失金额的值
     */
    public double getLossFee(){
        return lossFee;
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
