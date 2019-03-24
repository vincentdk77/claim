package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLreclaim-损余回收信息表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLreclaimDtoBase implements Serializable{
    /** 属性赔案号码 */
    private String claimNo = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性损余回收项目类别 */
    private String itemCode = "";
    /** 属性损余回收项目名称 */
    private String itemName = "";
    /** 属性抵押物名称 */
    private String guarantyName = "";
    /** 属性抵押物处理方式 */
    private String dealWay = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性数量 */
    private int reclaimCount = 0;
    /** 属性损余金额 */
    private double lossFee = 0d;
    /** 属性交易费用 */
    private double bargainFee = 0d;
    /** 属性保全财产名称 */
    private String propProtectName = "";
    /** 属性保全财产费用 */
    private double propProtectFee = 0d;
    /** 属性回收金额 */
    private double reclaimFee = 0d;
    /** 属性回收日期 */
    private DateTime reclaimDate = new DateTime();
    /** 属性摊销方式▲
--** 1:追偿款
--** 2:冲赔款
--** 9:其他 */
    private String amortizeWay = "";
    /** 属性经办人代码 */
    private String handlerCode = "";
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性输入日期 */
    private DateTime inputDate = new DateTime();
    /** 属性处理类型
--** [1]0：赔款前处理抵押物
--**  1：赔款后处理抵押物 */
    private String dealType = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLreclaimDtoBase对象
     */
    public PrpLreclaimDtoBase(){
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
     * 设置属性损余回收项目类别
     * @param itemCode 待设置的属性损余回收项目类别的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性损余回收项目类别
     * @return 属性损余回收项目类别的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性损余回收项目名称
     * @param itemName 待设置的属性损余回收项目名称的值
     */
    public void setItemName(String itemName){
        this.itemName = StringUtils.rightTrim(itemName);
    }

    /**
     * 获取属性损余回收项目名称
     * @return 属性损余回收项目名称的值
     */
    public String getItemName(){
        return itemName;
    }

    /**
     * 设置属性抵押物名称
     * @param guarantyName 待设置的属性抵押物名称的值
     */
    public void setGuarantyName(String guarantyName){
        this.guarantyName = StringUtils.rightTrim(guarantyName);
    }

    /**
     * 获取属性抵押物名称
     * @return 属性抵押物名称的值
     */
    public String getGuarantyName(){
        return guarantyName;
    }

    /**
     * 设置属性抵押物处理方式
     * @param dealWay 待设置的属性抵押物处理方式的值
     */
    public void setDealWay(String dealWay){
        this.dealWay = StringUtils.rightTrim(dealWay);
    }

    /**
     * 获取属性抵押物处理方式
     * @return 属性抵押物处理方式的值
     */
    public String getDealWay(){
        return dealWay;
    }

    /**
     * 设置属性币别
     * @param currency 待设置的属性币别的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别
     * @return 属性币别的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性数量
     * @param reclaimCount 待设置的属性数量的值
     */
    public void setReclaimCount(int reclaimCount){
        this.reclaimCount = reclaimCount;
    }

    /**
     * 获取属性数量
     * @return 属性数量的值
     */
    public int getReclaimCount(){
        return reclaimCount;
    }

    /**
     * 设置属性损余金额
     * @param lossFee 待设置的属性损余金额的值
     */
    public void setLossFee(double lossFee){
        this.lossFee = lossFee;
    }

    /**
     * 获取属性损余金额
     * @return 属性损余金额的值
     */
    public double getLossFee(){
        return lossFee;
    }

    /**
     * 设置属性交易费用
     * @param bargainFee 待设置的属性交易费用的值
     */
    public void setBargainFee(double bargainFee){
        this.bargainFee = bargainFee;
    }

    /**
     * 获取属性交易费用
     * @return 属性交易费用的值
     */
    public double getBargainFee(){
        return bargainFee;
    }

    /**
     * 设置属性保全财产名称
     * @param propProtectName 待设置的属性保全财产名称的值
     */
    public void setPropProtectName(String propProtectName){
        this.propProtectName = StringUtils.rightTrim(propProtectName);
    }

    /**
     * 获取属性保全财产名称
     * @return 属性保全财产名称的值
     */
    public String getPropProtectName(){
        return propProtectName;
    }

    /**
     * 设置属性保全财产费用
     * @param propProtectFee 待设置的属性保全财产费用的值
     */
    public void setPropProtectFee(double propProtectFee){
        this.propProtectFee = propProtectFee;
    }

    /**
     * 获取属性保全财产费用
     * @return 属性保全财产费用的值
     */
    public double getPropProtectFee(){
        return propProtectFee;
    }

    /**
     * 设置属性回收金额
     * @param reclaimFee 待设置的属性回收金额的值
     */
    public void setReclaimFee(double reclaimFee){
        this.reclaimFee = reclaimFee;
    }

    /**
     * 获取属性回收金额
     * @return 属性回收金额的值
     */
    public double getReclaimFee(){
        return reclaimFee;
    }

    /**
     * 设置属性回收日期
     * @param reclaimDate 待设置的属性回收日期的值
     */
    public void setReclaimDate(DateTime reclaimDate){
        this.reclaimDate = reclaimDate;
    }

    /**
     * 获取属性回收日期
     * @return 属性回收日期的值
     */
    public DateTime getReclaimDate(){
        return reclaimDate;
    }

    /**
     * 设置属性摊销方式▲
--** 1:追偿款
--** 2:冲赔款
--** 9:其他
     * @param amortizeWay 待设置的属性摊销方式▲
--** 1:追偿款
--** 2:冲赔款
--** 9:其他的值
     */
    public void setAmortizeWay(String amortizeWay){
        this.amortizeWay = StringUtils.rightTrim(amortizeWay);
    }

    /**
     * 获取属性摊销方式▲
--** 1:追偿款
--** 2:冲赔款
--** 9:其他
     * @return 属性摊销方式▲
--** 1:追偿款
--** 2:冲赔款
--** 9:其他的值
     */
    public String getAmortizeWay(){
        return amortizeWay;
    }

    /**
     * 设置属性经办人代码
     * @param handlerCode 待设置的属性经办人代码的值
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * 获取属性经办人代码
     * @return 属性经办人代码的值
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * 设置属性操作员代码
     * @param operatorCode 待设置的属性操作员代码的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性操作员代码
     * @return 属性操作员代码的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性输入日期
     * @param inputDate 待设置的属性输入日期的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性输入日期
     * @return 属性输入日期的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性处理类型
--** [1]0：赔款前处理抵押物
--**  1：赔款后处理抵押物
     * @param dealType 待设置的属性处理类型
--** [1]0：赔款前处理抵押物
--**  1：赔款后处理抵押物的值
     */
    public void setDealType(String dealType){
        this.dealType = StringUtils.rightTrim(dealType);
    }

    /**
     * 获取属性处理类型
--** [1]0：赔款前处理抵押物
--**  1：赔款后处理抵押物
     * @return 属性处理类型
--** [1]0：赔款前处理抵押物
--**  1：赔款后处理抵押物的值
     */
    public String getDealType(){
        return dealType;
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
