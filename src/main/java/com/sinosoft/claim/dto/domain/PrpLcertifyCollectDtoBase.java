package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLcertifyCollect－单证收集的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLcertifyCollectDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性业务号码 */
    private String businessNo = "";
    /** 属性标的代码 */
    private String lossItemCode = "";
    /** 属性标的名称 */
    private String lossItemName = "";
    /** 属性单证份数 */
    private int picCount = 0;
    /** 属性单证开始收集日期 */
    private DateTime startDate = new DateTime();
    /** 属性单证开始收集小时 */
    private String startHour = "";
    /** 属性单证结束收集日期 */
    private DateTime endDate = new DateTime();
    /** 属性单证结束收集小时 */
    private String endHour = "";
    /** 属性操作员 */
    private String operatorCode = "";
    /** 属性收集标志 */
    private String collectFlag = "";
    /** 属性主车收集标志 */
    private String cltInsureCarFlag = "";
    /** 属性三者车收集标志 */
    private String cltThirdCarFlag = "";
    /** 属性人伤收集标志 */
    private String cltPersonFlag = "";
    /** 属性物损收集标志 */
    private String cltPropFlag = "";
    /** 属性盗抢收集标志 */
    private String cltCarLossFlag = "";
    /** 属性全损收集标志 */
    private String cltAllLossFlag = "";
    /** 属性存放事故类型 */
    private String caseFlag = "";
    /** 属性案件处理意见 */
    private String content = "";
    /** 属性标志位 */
    private String flag = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性年 */
    private String uploadYear = "";
    /** 属性强制保险收集标志 */
    private String compelFlag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLcertifyCollectDtoBase对象
     */
    public PrpLcertifyCollectDtoBase(){
    }

    /**
     * 设置属性业务号码
     * @param businessNo 待设置的属性业务号码的值
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * 获取属性业务号码
     * @return 属性业务号码的值
     */
    public String getBusinessNo(){
        return businessNo;
    }

    /**
     * 设置属性标的代码
     * @param lossItemCode 待设置的属性标的代码的值
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * 获取属性标的代码
     * @return 属性标的代码的值
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * 设置属性标的名称
     * @param lossItemName 待设置的属性标的名称的值
     */
    public void setLossItemName(String lossItemName){
        this.lossItemName = StringUtils.rightTrim(lossItemName);
    }

    /**
     * 获取属性标的名称
     * @return 属性标的名称的值
     */
    public String getLossItemName(){
        return lossItemName;
    }

    /**
     * 设置属性单证份数
     * @param picCount 待设置的属性单证份数的值
     */
    public void setPicCount(int picCount){
        this.picCount = picCount;
    }

    /**
     * 获取属性单证份数
     * @return 属性单证份数的值
     */
    public int getPicCount(){
        return picCount;
    }

    /**
     * 设置属性单证开始收集日期
     * @param startDate 待设置的属性单证开始收集日期的值
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * 获取属性单证开始收集日期
     * @return 属性单证开始收集日期的值
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * 设置属性单证开始收集小时
     * @param startHour 待设置的属性单证开始收集小时的值
     */
    public void setStartHour(String startHour){
        this.startHour = StringUtils.rightTrim(startHour);
    }

    /**
     * 获取属性单证开始收集小时
     * @return 属性单证开始收集小时的值
     */
    public String getStartHour(){
        return startHour;
    }

    /**
     * 设置属性单证结束收集日期
     * @param endDate 待设置的属性单证结束收集日期的值
     */
    public void setEndDate(DateTime endDate){
        this.endDate = endDate;
    }

    /**
     * 获取属性单证结束收集日期
     * @return 属性单证结束收集日期的值
     */
    public DateTime getEndDate(){
        return endDate;
    }

    /**
     * 设置属性单证结束收集小时
     * @param endHour 待设置的属性单证结束收集小时的值
     */
    public void setEndHour(String endHour){
        this.endHour = StringUtils.rightTrim(endHour);
    }

    /**
     * 获取属性单证结束收集小时
     * @return 属性单证结束收集小时的值
     */
    public String getEndHour(){
        return endHour;
    }

    /**
     * 设置属性操作员
     * @param operatorCode 待设置的属性操作员的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性操作员
     * @return 属性操作员的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性收集标志
     * @param collectFlag 待设置的属性收集标志的值
     */
    public void setCollectFlag(String collectFlag){
        this.collectFlag = StringUtils.rightTrim(collectFlag);
    }

    /**
     * 获取属性收集标志
     * @return 属性收集标志的值
     */
    public String getCollectFlag(){
        return collectFlag;
    }

    /**
     * 设置属性主车收集标志
     * @param cltInsureCarFlag 待设置的属性主车收集标志的值
     */
    public void setCltInsureCarFlag(String cltInsureCarFlag){
        this.cltInsureCarFlag = StringUtils.rightTrim(cltInsureCarFlag);
    }

    /**
     * 获取属性主车收集标志
     * @return 属性主车收集标志的值
     */
    public String getCltInsureCarFlag(){
        return cltInsureCarFlag;
    }

    /**
     * 设置属性三者车收集标志
     * @param cltThirdCarFlag 待设置的属性三者车收集标志的值
     */
    public void setCltThirdCarFlag(String cltThirdCarFlag){
        this.cltThirdCarFlag = StringUtils.rightTrim(cltThirdCarFlag);
    }

    /**
     * 获取属性三者车收集标志
     * @return 属性三者车收集标志的值
     */
    public String getCltThirdCarFlag(){
        return cltThirdCarFlag;
    }

    /**
     * 设置属性人伤收集标志
     * @param cltPersonFlag 待设置的属性人伤收集标志的值
     */
    public void setCltPersonFlag(String cltPersonFlag){
        this.cltPersonFlag = StringUtils.rightTrim(cltPersonFlag);
    }

    /**
     * 获取属性人伤收集标志
     * @return 属性人伤收集标志的值
     */
    public String getCltPersonFlag(){
        return cltPersonFlag;
    }

    /**
     * 设置属性物损收集标志
     * @param cltPropFlag 待设置的属性物损收集标志的值
     */
    public void setCltPropFlag(String cltPropFlag){
        this.cltPropFlag = StringUtils.rightTrim(cltPropFlag);
    }

    /**
     * 获取属性物损收集标志
     * @return 属性物损收集标志的值
     */
    public String getCltPropFlag(){
        return cltPropFlag;
    }

    /**
     * 设置属性盗抢收集标志
     * @param cltCarLossFlag 待设置的属性盗抢收集标志的值
     */
    public void setCltCarLossFlag(String cltCarLossFlag){
        this.cltCarLossFlag = StringUtils.rightTrim(cltCarLossFlag);
    }

    /**
     * 获取属性盗抢收集标志
     * @return 属性盗抢收集标志的值
     */
    public String getCltCarLossFlag(){
        return cltCarLossFlag;
    }

    /**
     * 设置属性全损收集标志
     * @param cltAllLossFlag 待设置的属性全损收集标志的值
     */
    public void setCltAllLossFlag(String cltAllLossFlag){
        this.cltAllLossFlag = StringUtils.rightTrim(cltAllLossFlag);
    }

    /**
     * 获取属性全损收集标志
     * @return 属性全损收集标志的值
     */
    public String getCltAllLossFlag(){
        return cltAllLossFlag;
    }

    /**
     * 设置属性存放事故类型
     * @param caseFlag 待设置的属性存放事故类型的值
     */
    public void setCaseFlag(String caseFlag){
        this.caseFlag = StringUtils.rightTrim(caseFlag);
    }

    /**
     * 获取属性存放事故类型
     * @return 属性存放事故类型的值
     */
    public String getCaseFlag(){
        return caseFlag;
    }

    /**
     * 设置属性案件处理意见
     * @param content 待设置的属性案件处理意见的值
     */
    public void setContent(String content){
        this.content = StringUtils.rightTrim(content);
    }

    /**
     * 获取属性案件处理意见
     * @return 属性案件处理意见的值
     */
    public String getContent(){
        return content;
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
     * 设置属性年
     * @param uploadYear 待设置的属性年的值
     */
    public void setUploadYear(String uploadYear){
        this.uploadYear = StringUtils.rightTrim(uploadYear);
    }

    /**
     * 获取属性年
     * @return 属性年的值
     */
    public String getUploadYear(){
        return uploadYear;
    }

    /**
     * 设置属性强制保险收集标志
     * @param compelFlag 待设置的属性强制保险收集标志的值
     */
    public void setCompelFlag(String compelFlag){
        this.compelFlag = StringUtils.rightTrim(compelFlag);
    }

    /**
     * 获取属性强制保险收集标志
     * @return 属性强制保险收集标志的值
     */
    public String getCompelFlag(){
        return compelFlag;
    }
}
