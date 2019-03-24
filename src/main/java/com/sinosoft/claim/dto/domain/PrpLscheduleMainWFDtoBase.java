package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/** 
 * 这是PrpLscheduleMainWF的数据传输对象基类<br>
 * 创建于 2005-06-30 16:57:38.747<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLscheduleMainWFDtoBase implements Serializable{
    /** 属性调度ID */
    private int scheduleID = 0;
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性已查勘次数 */
    private int surveyNo = 0;
    /** 属性理赔处理机构 */
    private String claimComCode = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性调度操作员代码 */
    private String operatorCode = "";
    /** 属性计算机输单日期 */
    private DateTime inputDate = new DateTime();
    /** 属性小时 */
    private int inputHour = 0;
    /** 属性调度区域 */
    private int scheduleArea = 0;
    /** 属性允许多级调度 */
    private String scheduleMoreFlag = "";
    /** 属性调度处理情况 */
    private String scheduleFlag = "";
    /** 属性调度对象编码 */
    private String scheduleObjectID = "";
    /** 属性调度对象名称 */
    private String scheduleObjectName = "";
    /** 属性调度类型 */
    private String scheduleType = "";
    /** 属性处理日期 */
    private DateTime checkInputDate = new DateTime();
    /** 属性查勘录入操作员代码 */
    private String checkOperatorCode = "";
    /** 属性查勘状态 */
    private String checkFlag = "";
    /** 属性处理信息 */
    private String checkInfo = "";
    /** 属性备用状态 */
    private String flag = "";
    /** 属性查勘地址 */
    private String checkSite = "";
    /** 属性下一个节点人的代码 */
    private String nextHandlerCode = "";
    /** 属性下一个节点人的名称 */
    private String nextHandlerName = "";
    /** 属性下一个节点的类型 */
    private String nextNodeNo = "";
    /** 属性分钟 */
    private int inputMinute = 0;
    /** 属性调度当前的状态 */
    private String scheduleStatus = "";
    /** 属性双代处理标志 */
    private String commiItemFlag = "";

    
    /**
     *  默认构造方法,构造一个默认的PrpLscheduleMainWFDtoBase对象
     */
    public PrpLscheduleMainWFDtoBase(){
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
     * 设置属性调度操作员代码
     * @param operatorCode 待设置的属性调度操作员代码的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性调度操作员代码
     * @return 属性调度操作员代码的值
     */
    public String getOperatorCode(){
        return operatorCode;
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
     * 设置属性调度区域
     * @param scheduleArea 待设置的属性调度区域的值
     */
    public void setScheduleArea(int scheduleArea){
        this.scheduleArea = scheduleArea;
    }

    /**
     * 获取属性调度区域
     * @return 属性调度区域的值
     */
    public int getScheduleArea(){
        return scheduleArea;
    }

    /**
     * 设置属性允许多级调度
     * @param scheduleMoreFlag 待设置的属性允许多级调度的值
     */
    public void setScheduleMoreFlag(String scheduleMoreFlag){
        this.scheduleMoreFlag = StringUtils.rightTrim(scheduleMoreFlag);
    }

    /**
     * 获取属性允许多级调度
     * @return 属性允许多级调度的值
     */
    public String getScheduleMoreFlag(){
        return scheduleMoreFlag;
    }

    /**
     * 设置属性调度处理情况
     * @param scheduleFlag 待设置的属性调度处理情况的值
     */
    public void setScheduleFlag(String scheduleFlag){
        this.scheduleFlag = StringUtils.rightTrim(scheduleFlag);
    }

    /**
     * 获取属性调度处理情况
     * @return 属性调度处理情况的值
     */
    public String getScheduleFlag(){
        return scheduleFlag;
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
     * 设置属性处理日期
     * @param checkInputDate 待设置的属性处理日期的值
     */
    public void setCheckInputDate(DateTime checkInputDate){
        this.checkInputDate = checkInputDate;
    }

    /**
     * 获取属性处理日期
     * @return 属性处理日期的值
     */
    public DateTime getCheckInputDate(){
        return checkInputDate;
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
     * 设置属性处理信息
     * @param checkInfo 待设置的属性处理信息的值
     */
    public void setCheckInfo(String checkInfo){
        this.checkInfo = StringUtils.rightTrim(checkInfo);
    }

    /**
     * 获取属性处理信息
     * @return 属性处理信息的值
     */
    public String getCheckInfo(){
        return checkInfo;
    }

    /**
     * 设置属性备用状态
     * @param flag 待设置的属性备用状态的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性备用状态
     * @return 属性备用状态的值
     */
    public String getFlag(){
        return flag;
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
     * 设置属性下一个节点人的代码
     * @param nextHandlerCode 待设置的属性下一个节点人的代码的值
     */
    public void setNextHandlerCode(String nextHandlerCode){
        this.nextHandlerCode = StringUtils.rightTrim(nextHandlerCode);
    }

    /**
     * 获取属性下一个节点人的代码
     * @return 属性下一个节点人的代码的值
     */
    public String getNextHandlerCode(){
        return nextHandlerCode;
    }

    /**
     * 设置属性下一个节点人的名称
     * @param nextHandlerName 待设置的属性下一个节点人的名称的值
     */
    public void setNextHandlerName(String nextHandlerName){
        this.nextHandlerName = StringUtils.rightTrim(nextHandlerName);
    }

    /**
     * 获取属性下一个节点人的名称
     * @return 属性下一个节点人的名称的值
     */
    public String getNextHandlerName(){
        return nextHandlerName;
    }

    /**
     * 设置属性下一个节点的类型
     * @param nextNodeNo 待设置的属性下一个节点的类型的值
     */
    public void setNextNodeNo(String nextNodeNo){
        this.nextNodeNo = StringUtils.rightTrim(nextNodeNo);
    }

    /**
     * 获取属性下一个节点的类型
     * @return 属性下一个节点的类型的值
     */
    public String getNextNodeNo(){
        return nextNodeNo;
    }

    /**
     * 设置属性分钟
     * @param inputMinute 待设置的属性分钟的值
     */
    public void setInputMinute(int inputMinute){
        this.inputMinute = inputMinute;
    }

    /**
     * 获取属性分钟
     * @return 属性分钟的值
     */
    public int getInputMinute(){
        return inputMinute;
    }

    /**
     * 设置属性调度当前的状态
     * @param scheduleStatus 待设置的属性调度当前的状态的值
     */
    public void setScheduleStatus(String scheduleStatus){
        this.scheduleStatus = StringUtils.rightTrim(scheduleStatus);
    }

    /**
     * 获取属性调度当前的状态
     * @return 属性调度当前的状态的值
     */
    public String getScheduleStatus(){
        return scheduleStatus;
    }
    
    /**
     * 设置属性双代处理标志
     * @param commiItemFlag 待设置的属性双代处理标志的值
     */
    public void setCommiItemFlag(String commiItemFlag){
        this.commiItemFlag = StringUtils.rightTrim(commiItemFlag);
    }

    /**
     * 获取属性双代处理标志
     * @return 属性双代处理标志的值
     */
    public String getCommiItemFlag(){
        return commiItemFlag;
    }
    
}
