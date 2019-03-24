package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLscheduleMain-调度任务主表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.546<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLscheduleMainDtoBase implements Serializable{
    /** 属性调度ID */
    private int scheduleID = 0;
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性是否为本保单车辆(1.是2.否) */
    private String insureCarFlag = "";
    /** 属性理赔处理机构 */
    private String claimComCode = "";
    /** 属性是否选择发送 */
    private String selectTSend = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性被调度单位代码,可以为修理厂,定损点 */
    private String scheduleDeptCode = "";
    /** 属性被调度单位名称 (新增) */
    private String scheduleDeptName = "";
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性调度员名称 */
    private String operatorName = "";
    /** 属性查勘次数 */
    private int surveyTimes = 0;
    /** 属性查勘地点类型(第一现场) */
    private String surveyType = "";
    /** 属性查勘地址 */
    private String surveyAddress = "";
    /** 属性出险车牌号码 */
    private String licenseNo = "";
    /** 属性计算机输单日期(保存日期) */
    private DateTime inputDate = new DateTime();
    /** 属性小时 */
    private int inputHour = 0;
    /** 属性调度信息 */
    private String resultInfo = "";
    /** 属性处理案件标志 */
    private String transFlag = "";
    /** 属性预约查勘(定损)状态 */
    private String bookFlag = "";
    /** 属性调度处理标志 */
    private String scheduleFlag = "";
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLscheduleMainDtoBase对象
     */
    public PrpLscheduleMainDtoBase(){
    }

    /**
     * 设置属性调度ID
     * @param scheduleID 待设置的属性调度ID的值
     */
    public void setScheduleID(int scheduleID){
        this.scheduleID = scheduleID;
    }

    /**
     * 获取属性调度ID
     * @return 属性调度ID的值
     */
    public int getScheduleID(){
        return scheduleID;
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
     * 设置属性是否为本保单车辆(1.是2.否)
     * @param insureCarFlag 待设置的属性是否为本保单车辆(1.是2.否)的值
     */
    public void setInsureCarFlag(String insureCarFlag){
        this.insureCarFlag = StringUtils.rightTrim(insureCarFlag);
    }

    /**
     * 获取属性是否为本保单车辆(1.是2.否)
     * @return 属性是否为本保单车辆(1.是2.否)的值
     */
    public String getInsureCarFlag(){
        return insureCarFlag;
    }

    /**
     * 设置属性理赔处理机构
     * @param claimComCode 待设置的属性理赔处理机构的值
     */
    public void setClaimComCode(String claimComCode){
        this.claimComCode = StringUtils.rightTrim(claimComCode);
    }

    /**
     * 获取属性理赔处理机构
     * @return 属性理赔处理机构的值
     */
    public String getClaimComCode(){
        return claimComCode;
    }

    /**
     * 设置属性是否选择发送
     * @param selectTSend 待设置的属性是否选择发送的值
     */
    public void setSelectTSend(String selectTSend){
        this.selectTSend = StringUtils.rightTrim(selectTSend);
    }

    /**
     * 获取属性是否选择发送
     * @return 属性是否选择发送的值
     */
    public String getSelectTSend(){
        return selectTSend;
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
     * 设置属性被调度单位代码,可以为修理厂,定损点
     * @param scheduleDeptCode 待设置的属性被调度单位代码,可以为修理厂,定损点的值
     */
    public void setScheduleDeptCode(String scheduleDeptCode){
        this.scheduleDeptCode = StringUtils.rightTrim(scheduleDeptCode);
    }

    /**
     * 获取属性被调度单位代码,可以为修理厂,定损点
     * @return 属性被调度单位代码,可以为修理厂,定损点的值
     */
    public String getScheduleDeptCode(){
        return scheduleDeptCode;
    }

    /**
     * 设置属性被调度单位名称 (新增)
     * @param scheduleDeptName 待设置的属性被调度单位名称 (新增)的值
     */
    public void setScheduleDeptName(String scheduleDeptName){
        this.scheduleDeptName = StringUtils.rightTrim(scheduleDeptName);
    }

    /**
     * 获取属性被调度单位名称 (新增)
     * @return 属性被调度单位名称 (新增)的值
     */
    public String getScheduleDeptName(){
        return scheduleDeptName;
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
     * 设置属性调度员名称
     * @param operatorName 待设置的属性调度员名称的值
     */
    public void setOperatorName(String operatorName){
        this.operatorName = StringUtils.rightTrim(operatorName);
    }

    /**
     * 获取属性调度员名称
     * @return 属性调度员名称的值
     */
    public String getOperatorName(){
        return operatorName;
    }

    /**
     * 设置属性查勘次数
     * @param surveyTimes 待设置的属性查勘次数的值
     */
    public void setSurveyTimes(int surveyTimes){
        this.surveyTimes = surveyTimes;
    }

    /**
     * 获取属性查勘次数
     * @return 属性查勘次数的值
     */
    public int getSurveyTimes(){
        return surveyTimes;
    }

    /**
     * 设置属性查勘地点类型(第一现场)
     * @param surveyType 待设置的属性查勘地点类型(第一现场)的值
     */
    public void setSurveyType(String surveyType){
        this.surveyType = StringUtils.rightTrim(surveyType);
    }

    /**
     * 获取属性查勘地点类型(第一现场)
     * @return 属性查勘地点类型(第一现场)的值
     */
    public String getSurveyType(){
        return surveyType;
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
     * 设置属性出险车牌号码
     * @param licenseNo 待设置的属性出险车牌号码的值
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * 获取属性出险车牌号码
     * @return 属性出险车牌号码的值
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * 设置属性计算机输单日期(保存日期)
     * @param inputDate 待设置的属性计算机输单日期(保存日期)的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性计算机输单日期(保存日期)
     * @return 属性计算机输单日期(保存日期)的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性小时
     * @param inputHour 待设置的属性小时的值
     */
    public void setInputHour(int inputHour){
        this.inputHour = inputHour;
    }

    /**
     * 获取属性小时
     * @return 属性小时的值
     */
    public int getInputHour(){
        return inputHour;
    }

    /**
     * 设置属性调度信息
     * @param resultInfo 待设置的属性调度信息的值
     */
    public void setResultInfo(String resultInfo){
        this.resultInfo = StringUtils.rightTrim(resultInfo);
    }

    /**
     * 获取属性调度信息
     * @return 属性调度信息的值
     */
    public String getResultInfo(){
        return resultInfo;
    }

    /**
     * 设置属性处理案件标志
     * @param transFlag 待设置的属性处理案件标志的值
     */
    public void setTransFlag(String transFlag){
        this.transFlag = StringUtils.rightTrim(transFlag);
    }

    /**
     * 获取属性处理案件标志
     * @return 属性处理案件标志的值
     */
    public String getTransFlag(){
        return transFlag;
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
     * 设置属性调度处理标志
     * @param scheduleFlag 待设置的属性调度处理标志的值
     */
    public void setScheduleFlag(String scheduleFlag){
        this.scheduleFlag = StringUtils.rightTrim(scheduleFlag);
    }

    /**
     * 获取属性调度处理标志
     * @return 属性调度处理标志的值
     */
    public String getScheduleFlag(){
        return scheduleFlag;
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
