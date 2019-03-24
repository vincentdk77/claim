package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLscheduleNew-新案件调度提示表(新增)的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.687<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLscheduleNewDtoBase implements Serializable{
    /** 属性报案受理号 */
    private String registNo = "";
    /** 属性座席员ID */
    private String operatorCode = "";
    /** 属性出险车牌号码 */
    private String lostLicenseNo = "";
    /** 属性查勘车牌号码(用于预约) */
    private String surveyLicenseNo = "";
    /** 属性已查勘次数 */
    private int surveyNo = 0;
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性车主姓名 */
    private String contactName = "";
    /** 属性联系电话 */
    private String phoneNumber = "";
    /** 属性出险原因代码 */
    private String damageCode = "";
    /** 属性出险原因说明 */
    private String damageName = "";
    /** 属性事故类型代码(车险) */
    private String damageTypeCode = "";
    /** 属性事故类型说明 */
    private String damageTypeName = "";
    /** 属性出险区域代码 */
    private String damageAreaCode = "";
    /** 属性出险区域名称 */
    private String damageAreaName = "";
    /** 属性出险地点分类 */
    private String damageAddressType = "";
    /** 属性地址编码 */
    private String addressCode = "";
    /** 属性出险地点 */
    private String damageAddress = "";
    /** 属性出险地点邮政编码 */
    private String damageAreaPostCode = "";
    /** 属性出险情况 */
    private String accidentDetail = "";
    /** 属性查勘地点类型 */
    private String surveyType = "";
    /** 属性金银牌客户标志 */
    private String signcustType = "";
    /** 属性被保险人(单位)名称 */
    private String customerName = "";
    /** 属性查勘地址 */
    private String surveyAddress = "";
    /** 属性报案途径 */
    private String reportWay = "";
    /** 属性承保险类 (DAA) */
    private String riskCode = "";
    /** 属性承保支公司 */
    private String insureComCode = "";
    /** 属性调度时间 */
    private DateTime surveyDate = new DateTime();
    /** 属性调度信息 */
    private String scheduleInfo = "";
    /** 属性预约查勘(定损)状态 */
    private String bookFlag = "";
    /** 属性是否被调度使用 */
    private String scheduleFlag = "";
    /** 属性险种代码（投保）串 */
    private String allKindCode = "";
    /** 属性Flag */
    private String flag = "";
    /** 属性操作时间 */
    private String operateDate = "";

    /**
     *  默认构造方法,构造一个默认的PrpLscheduleNewDtoBase对象
     */
    public PrpLscheduleNewDtoBase(){
    }

    /**
     * 设置属性报案受理号
     * @param registNo 待设置的属性报案受理号的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案受理号
     * @return 属性报案受理号的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性座席员ID
     * @param operatorCode 待设置的属性座席员ID的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性座席员ID
     * @return 属性座席员ID的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性出险车牌号码
     * @param lostLicenseNo 待设置的属性出险车牌号码的值
     */
    public void setLostLicenseNo(String lostLicenseNo){
        this.lostLicenseNo = StringUtils.rightTrim(lostLicenseNo);
    }

    /**
     * 获取属性出险车牌号码
     * @return 属性出险车牌号码的值
     */
    public String getLostLicenseNo(){
        return lostLicenseNo;
    }

    /**
     * 设置属性查勘车牌号码(用于预约)
     * @param surveyLicenseNo 待设置的属性查勘车牌号码(用于预约)的值
     */
    public void setSurveyLicenseNo(String surveyLicenseNo){
        this.surveyLicenseNo = StringUtils.rightTrim(surveyLicenseNo);
    }

    /**
     * 获取属性查勘车牌号码(用于预约)
     * @return 属性查勘车牌号码(用于预约)的值
     */
    public String getSurveyLicenseNo(){
        return surveyLicenseNo;
    }

    /**
     * 设置属性已查勘次数
     * @param surveyNo 待设置的属性已查勘次数的值
     */
    public void setSurveyNo(int surveyNo){
        this.surveyNo = surveyNo;
    }

    /**
     * 获取属性已查勘次数
     * @return 属性已查勘次数的值
     */
    public int getSurveyNo(){
        return surveyNo;
    }

    /**
     * 设置属性保单号
     * @param policyNo 待设置的属性保单号的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号
     * @return 属性保单号的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性车主姓名
     * @param contactName 待设置的属性车主姓名的值
     */
    public void setContactName(String contactName){
        this.contactName = StringUtils.rightTrim(contactName);
    }

    /**
     * 获取属性车主姓名
     * @return 属性车主姓名的值
     */
    public String getContactName(){
        return contactName;
    }

    /**
     * 设置属性联系电话
     * @param phoneNumber 待设置的属性联系电话的值
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * 获取属性联系电话
     * @return 属性联系电话的值
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * 设置属性出险原因代码
     * @param damageCode 待设置的属性出险原因代码的值
     */
    public void setDamageCode(String damageCode){
        this.damageCode = StringUtils.rightTrim(damageCode);
    }

    /**
     * 获取属性出险原因代码
     * @return 属性出险原因代码的值
     */
    public String getDamageCode(){
        return damageCode;
    }

    /**
     * 设置属性出险原因说明
     * @param damageName 待设置的属性出险原因说明的值
     */
    public void setDamageName(String damageName){
        this.damageName = StringUtils.rightTrim(damageName);
    }

    /**
     * 获取属性出险原因说明
     * @return 属性出险原因说明的值
     */
    public String getDamageName(){
        return damageName;
    }

    /**
     * 设置属性事故类型代码(车险)
     * @param damageTypeCode 待设置的属性事故类型代码(车险)的值
     */
    public void setDamageTypeCode(String damageTypeCode){
        this.damageTypeCode = StringUtils.rightTrim(damageTypeCode);
    }

    /**
     * 获取属性事故类型代码(车险)
     * @return 属性事故类型代码(车险)的值
     */
    public String getDamageTypeCode(){
        return damageTypeCode;
    }

    /**
     * 设置属性事故类型说明
     * @param damageTypeName 待设置的属性事故类型说明的值
     */
    public void setDamageTypeName(String damageTypeName){
        this.damageTypeName = StringUtils.rightTrim(damageTypeName);
    }

    /**
     * 获取属性事故类型说明
     * @return 属性事故类型说明的值
     */
    public String getDamageTypeName(){
        return damageTypeName;
    }

    /**
     * 设置属性出险区域代码
     * @param damageAreaCode 待设置的属性出险区域代码的值
     */
    public void setDamageAreaCode(String damageAreaCode){
        this.damageAreaCode = StringUtils.rightTrim(damageAreaCode);
    }

    /**
     * 获取属性出险区域代码
     * @return 属性出险区域代码的值
     */
    public String getDamageAreaCode(){
        return damageAreaCode;
    }

    /**
     * 设置属性出险区域名称
     * @param damageAreaName 待设置的属性出险区域名称的值
     */
    public void setDamageAreaName(String damageAreaName){
        this.damageAreaName = StringUtils.rightTrim(damageAreaName);
    }

    /**
     * 获取属性出险区域名称
     * @return 属性出险区域名称的值
     */
    public String getDamageAreaName(){
        return damageAreaName;
    }

    /**
     * 设置属性出险地点分类
     * @param damageAddressType 待设置的属性出险地点分类的值
     */
    public void setDamageAddressType(String damageAddressType){
        this.damageAddressType = StringUtils.rightTrim(damageAddressType);
    }

    /**
     * 获取属性出险地点分类
     * @return 属性出险地点分类的值
     */
    public String getDamageAddressType(){
        return damageAddressType;
    }

    /**
     * 设置属性地址编码
     * @param addressCode 待设置的属性地址编码的值
     */
    public void setAddressCode(String addressCode){
        this.addressCode = StringUtils.rightTrim(addressCode);
    }

    /**
     * 获取属性地址编码
     * @return 属性地址编码的值
     */
    public String getAddressCode(){
        return addressCode;
    }

    /**
     * 设置属性出险地点
     * @param damageAddress 待设置的属性出险地点的值
     */
    public void setDamageAddress(String damageAddress){
        this.damageAddress = StringUtils.rightTrim(damageAddress);
    }

    /**
     * 获取属性出险地点
     * @return 属性出险地点的值
     */
    public String getDamageAddress(){
        return damageAddress;
    }

    /**
     * 设置属性出险地点邮政编码
     * @param damageAreaPostCode 待设置的属性出险地点邮政编码的值
     */
    public void setDamageAreaPostCode(String damageAreaPostCode){
        this.damageAreaPostCode = StringUtils.rightTrim(damageAreaPostCode);
    }

    /**
     * 获取属性出险地点邮政编码
     * @return 属性出险地点邮政编码的值
     */
    public String getDamageAreaPostCode(){
        return damageAreaPostCode;
    }

    /**
     * 设置属性出险情况
     * @param accidentDetail 待设置的属性出险情况的值
     */
    public void setAccidentDetail(String accidentDetail){
        this.accidentDetail = StringUtils.rightTrim(accidentDetail);
    }

    /**
     * 获取属性出险情况
     * @return 属性出险情况的值
     */
    public String getAccidentDetail(){
        return accidentDetail;
    }

    /**
     * 设置属性查勘地点类型
     * @param surveyType 待设置的属性查勘地点类型的值
     */
    public void setSurveyType(String surveyType){
        this.surveyType = StringUtils.rightTrim(surveyType);
    }

    /**
     * 获取属性查勘地点类型
     * @return 属性查勘地点类型的值
     */
    public String getSurveyType(){
        return surveyType;
    }

    /**
     * 设置属性金银牌客户标志
     * @param signcustType 待设置的属性金银牌客户标志的值
     */
    public void setSigncustType(String signcustType){
        this.signcustType = StringUtils.rightTrim(signcustType);
    }

    /**
     * 获取属性金银牌客户标志
     * @return 属性金银牌客户标志的值
     */
    public String getSigncustType(){
        return signcustType;
    }

    /**
     * 设置属性被保险人(单位)名称
     * @param customerName 待设置的属性被保险人(单位)名称的值
     */
    public void setCustomerName(String customerName){
        this.customerName = StringUtils.rightTrim(customerName);
    }

    /**
     * 获取属性被保险人(单位)名称
     * @return 属性被保险人(单位)名称的值
     */
    public String getCustomerName(){
        return customerName;
    }

    /**
     * 设置属性查勘地址
     * @param surveyAddress 待设置的属性查勘地址的值
     */
    public void setSurveyAddress(String surveyAddress){
        this.surveyAddress = StringUtils.rightTrim(surveyAddress);
    }

    /**
     * 获取属性查勘地址
     * @return 属性查勘地址的值
     */
    public String getSurveyAddress(){
        return surveyAddress;
    }

    /**
     * 设置属性报案途径
     * @param reportWay 待设置的属性报案途径的值
     */
    public void setReportWay(String reportWay){
        this.reportWay = StringUtils.rightTrim(reportWay);
    }

    /**
     * 获取属性报案途径
     * @return 属性报案途径的值
     */
    public String getReportWay(){
        return reportWay;
    }

    /**
     * 设置属性承保险类 (DAA)
     * @param riskCode 待设置的属性承保险类 (DAA)的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性承保险类 (DAA)
     * @return 属性承保险类 (DAA)的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性承保支公司
     * @param insureComCode 待设置的属性承保支公司的值
     */
    public void setInsureComCode(String insureComCode){
        this.insureComCode = StringUtils.rightTrim(insureComCode);
    }

    /**
     * 获取属性承保支公司
     * @return 属性承保支公司的值
     */
    public String getInsureComCode(){
        return insureComCode;
    }

    /**
     * 设置属性调度时间
     * @param surveyDate 待设置的属性调度时间的值
     */
    public void setSurveyDate(DateTime surveyDate){
        this.surveyDate = surveyDate;
    }

    /**
     * 获取属性调度时间
     * @return 属性调度时间的值
     */
    public DateTime getSurveyDate(){
        return surveyDate;
    }

    /**
     * 设置属性调度信息
     * @param scheduleInfo 待设置的属性调度信息的值
     */
    public void setScheduleInfo(String scheduleInfo){
        this.scheduleInfo = StringUtils.rightTrim(scheduleInfo);
    }

    /**
     * 获取属性调度信息
     * @return 属性调度信息的值
     */
    public String getScheduleInfo(){
        return scheduleInfo;
    }

    /**
     * 设置属性预约查勘(定损)状态
     * @param bookFlag 待设置的属性预约查勘(定损)状态的值
     */
    public void setBookFlag(String bookFlag){
        this.bookFlag = StringUtils.rightTrim(bookFlag);
    }

    /**
     * 获取属性预约查勘(定损)状态
     * @return 属性预约查勘(定损)状态的值
     */
    public String getBookFlag(){
        return bookFlag;
    }

    /**
     * 设置属性是否被调度使用
     * @param scheduleFlag 待设置的属性是否被调度使用的值
     */
    public void setScheduleFlag(String scheduleFlag){
        this.scheduleFlag = StringUtils.rightTrim(scheduleFlag);
    }

    /**
     * 获取属性是否被调度使用
     * @return 属性是否被调度使用的值
     */
    public String getScheduleFlag(){
        return scheduleFlag;
    }

    /**
     * 设置属性险种代码（投保）串
     * @param allKindCode 待设置的属性险种代码（投保）串的值
     */
    public void setAllKindCode(String allKindCode){
        this.allKindCode = StringUtils.rightTrim(allKindCode);
    }

    /**
     * 获取属性险种代码（投保）串
     * @return 属性险种代码（投保）串的值
     */
    public String getAllKindCode(){
        return allKindCode;
    }

    /**
     * 设置属性Flag
     * @param flag 待设置的属性Flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性Flag
     * @return 属性Flag的值
     */
    public String getFlag(){
        return flag;
    }

    /**
     * 设置属性操作时间
     * @param operateDate 待设置的属性操作时间的值
     */
    public void setOperateDate(String operateDate){
        this.operateDate = StringUtils.rightTrim(operateDate);
    }

    /**
     * 获取属性操作时间
     * @return 属性操作时间的值
     */
    public String getOperateDate(){
        return operateDate;
    }
}
