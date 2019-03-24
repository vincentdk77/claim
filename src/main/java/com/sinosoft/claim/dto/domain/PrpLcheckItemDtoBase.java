package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLcheckItem-查勘任务标的表（新增）的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.703<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcheckItemDtoBase implements Serializable{
    /** 属性调度ID */
    private int scheduleID = 0;
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性标的序号 */
    private int itemNo = 0;
    /** 属性是否为本保单车辆 */
    private String insureCarFlag = "";
    /** 属性理赔处理机构 */
    private String claimComCode = "";
    /** 属性是否选择发送 */
    private String selectSend = "";
    /** 属性查勘次数 */
    private int surveyTimes = 0;
    /** 属性查勘地点类型 */
    private String surveyType = "";
    /** 属性查勘地址 */
    private String checkSite = "";
    /** 属性出险车牌号码 */
    private String licenseNo = "";
    /** 属性调度对象编码 */
    private String scheduleObjectID = "";
    /** 属性调度对象名称 */
    private String scheduleObjectName = "";
    /** 属性计算机输单日期 */
    private DateTime inputDate = new DateTime();
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性查勘录入操作员代码 */
    private String checkOperatorCode = "";
    /** 属性调度信息 */
    private String resultInfo = "";
    /** 属性预约查勘 */
    private String bookFlag = "";
    /** 属性调度类型 */
    private String scheduleType = "";
    /** 属性查勘状态 */
    private String checkFlag = "";
    /** 属性查勘任务处理信息 */
    private String checkInfo = "";
    /** 属性状态标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLcheckItemDtoBase对象
     */
    public PrpLcheckItemDtoBase(){
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
     * 设置属性标的序号
     * @param itemNo 待设置的属性标的序号的值
     */
    public void setItemNo(int itemNo){
        this.itemNo = itemNo;
    }

    /**
     * 获取属性标的序号
     * @return 属性标的序号的值
     */
    public int getItemNo(){
        return itemNo;
    }

    /**
     * 设置属性是否为本保单车辆
     * @param insureCarFlag 待设置的属性是否为本保单车辆的值
     */
    public void setInsureCarFlag(String insureCarFlag){
        this.insureCarFlag = StringUtils.rightTrim(insureCarFlag);
    }

    /**
     * 获取属性是否为本保单车辆
     * @return 属性是否为本保单车辆的值
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
     * @param selectSend 待设置的属性是否选择发送的值
     */
    public void setSelectSend(String selectSend){
        this.selectSend = StringUtils.rightTrim(selectSend);
    }

    /**
     * 获取属性是否选择发送
     * @return 属性是否选择发送的值
     */
    public String getSelectSend(){
        return selectSend;
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
     * 设置属性查勘地址
     * @param checkSite 待设置的属性查勘地址的值
     */
    public void setCheckSite(String checkSite){
        this.checkSite = StringUtils.rightTrim(checkSite);
    }

    /**
     * 获取属性查勘地址
     * @return 属性查勘地址的值
     */
    public String getCheckSite(){
        return checkSite;
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
     * 设置属性调度对象编码
     * @param scheduleObjectID 待设置的属性调度对象编码的值
     */
    public void setScheduleObjectID(String scheduleObjectID){
        this.scheduleObjectID = StringUtils.rightTrim(scheduleObjectID);
    }

    /**
     * 获取属性调度对象编码
     * @return 属性调度对象编码的值
     */
    public String getScheduleObjectID(){
        return scheduleObjectID;
    }

    /**
     * 设置属性调度对象名称
     * @param scheduleObjectName 待设置的属性调度对象名称的值
     */
    public void setScheduleObjectName(String scheduleObjectName){
        this.scheduleObjectName = StringUtils.rightTrim(scheduleObjectName);
    }

    /**
     * 获取属性调度对象名称
     * @return 属性调度对象名称的值
     */
    public String getScheduleObjectName(){
        return scheduleObjectName;
    }

    /**
     * 设置属性计算机输单日期
     * @param inputDate 待设置的属性计算机输单日期的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性计算机输单日期
     * @return 属性计算机输单日期的值
     */
    public DateTime getInputDate(){
        return inputDate;
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
     * 设置属性查勘录入操作员代码
     * @param checkOperatorCode 待设置的属性查勘录入操作员代码的值
     */
    public void setCheckOperatorCode(String checkOperatorCode){
        this.checkOperatorCode = StringUtils.rightTrim(checkOperatorCode);
    }

    /**
     * 获取属性查勘录入操作员代码
     * @return 属性查勘录入操作员代码的值
     */
    public String getCheckOperatorCode(){
        return checkOperatorCode;
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
     * 设置属性预约查勘
     * @param bookFlag 待设置的属性预约查勘的值
     */
    public void setBookFlag(String bookFlag){
        this.bookFlag = StringUtils.rightTrim(bookFlag);
    }

    /**
     * 获取属性预约查勘
     * @return 属性预约查勘的值
     */
    public String getBookFlag(){
        return bookFlag;
    }

    /**
     * 设置属性调度类型
     * @param scheduleType 待设置的属性调度类型的值
     */
    public void setScheduleType(String scheduleType){
        this.scheduleType = StringUtils.rightTrim(scheduleType);
    }

    /**
     * 获取属性调度类型
     * @return 属性调度类型的值
     */
    public String getScheduleType(){
        return scheduleType;
    }

    /**
     * 设置属性查勘状态
     * @param checkFlag 待设置的属性查勘状态的值
     */
    public void setCheckFlag(String checkFlag){
        this.checkFlag = StringUtils.rightTrim(checkFlag);
    }

    /**
     * 获取属性查勘状态
     * @return 属性查勘状态的值
     */
    public String getCheckFlag(){
        return checkFlag;
    }

    /**
     * 设置属性查勘任务处理信息
     * @param checkInfo 待设置的属性查勘任务处理信息的值
     */
    public void setCheckInfo(String checkInfo){
        this.checkInfo = StringUtils.rightTrim(checkInfo);
    }

    /**
     * 获取属性查勘任务处理信息
     * @return 属性查勘任务处理信息的值
     */
    public String getCheckInfo(){
        return checkInfo;
    }

    /**
     * 设置属性状态标志
     * @param flag 待设置的属性状态标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性状态标志
     * @return 属性状态标志的值
     */
    public String getFlag(){
        return flag;
    }
}
