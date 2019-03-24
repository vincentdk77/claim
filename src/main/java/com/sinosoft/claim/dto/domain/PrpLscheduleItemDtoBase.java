package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
 
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLscheduleItem-调度任务标的表(新增）的数据传输对象基类<br>
 * 创建于 2005-06-30 16:57:37.736<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLscheduleItemDtoBase implements Serializable{
    /** 属性调度ID */
    private int scheduleID = 0;
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性ITEMNO */
    private int itemNo = 0;
    /** 属性是否为本保单车辆(1.是2.否) */
    private String insureCarFlag = "";
    /** 属性理赔处理机构 */
    private String claimComCode = "";
    /** 属性是否选择发送 */
    private String selectSend = "";
    /** 属性查勘次数 */
    private int surveyTimes = 0;
    /** 属性查勘地点类型(第一现场) */
    private String surveyType = "";
    /** 属性查勘地址 */
    private String checkSite = "";
    /** 属性出险车牌号码 */
    private String licenseNo = "";
    /** 属性调度对象代码 */
    private String scheduleObjectID = "";
    /** 属性调度对象名称 */
    private String scheduleObjectName = "";
    /** 属性计算机输单日期(保存日期) */
    private DateTime inputDate = new DateTime();
    /** 属性调度信息 */
    private String resultInfo = "";
    /** 属性预约查勘(定损)状态 */
    private String bookFlag = "";
    /** 属性调度处理标志 */
    private String scheduleType = "";
    /** 属性标志 */
    private String flag = "";
    /** 属性下一个节点人的代码 */
    private String nextHandlerCode = "";
    /** 属性下一个节点人的名称 */
    private String nextHandlerName = "";
    /** 属性下一个节点的类型 */
    private String nextNodeNo = "";
    /** 属性调度操作员代码 */
    private String operatorCode = "";
    /** 属性修理厂联系电话 */
    private String factoryPhone = "";
    /** 属性修理厂报损总金额 */
    private double factoryEstimateLoss = 0d;
    /** 属性推荐修理厂代码 */
    private String commendRepairFactoryCode = "";
    /** 属性推荐修理厂名称 */
    private String commendRepairFactoryName = "";
    /** 属性紧急程度 */
    private String exigenceGree = "";
    /** 属性调度当前的状态 */
    private String scheduleStatus = "";
    /** 属性双代处理标志 add by liyanjie 2005-12-10*/
    private String commiItemFlag = "";
    
    /**
     *  默认构造方法,构造一个默认的PrpLscheduleItemDtoBase对象
     */
    public PrpLscheduleItemDtoBase(){
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
     * 设置属性ITEMNO
     * @param itemNo 待设置的属性ITEMNO的值
     */
    public void setItemNo(int itemNo){
        this.itemNo = itemNo;
    }

    /**
     * 获取属性ITEMNO
     * @return 属性ITEMNO的值
     */
    public int getItemNo(){
        return itemNo;
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
     * 设置属性调度对象代码
     * @param scheduleObjectID 待设置的属性调度对象代码的值
     */
    public void setScheduleObjectID(String scheduleObjectID){
        this.scheduleObjectID = StringUtils.rightTrim(scheduleObjectID);
    }

    /**
     * 获取属性调度对象代码
     * @return 属性调度对象代码的值
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
     * @param scheduleType 待设置的属性调度处理标志的值
     */
    public void setScheduleType(String scheduleType){
        this.scheduleType = StringUtils.rightTrim(scheduleType);
    }

    /**
     * 获取属性调度处理标志
     * @return 属性调度处理标志的值
     */
    public String getScheduleType(){
        return scheduleType;
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
     * 设置属性修理厂联系电话
     * @param factoryPhone 待设置的属性修理厂联系电话的值
     */
    public void setFactoryPhone(String factoryPhone){
        this.factoryPhone = StringUtils.rightTrim(factoryPhone);
    }

    /**
     * 获取属性修理厂联系电话
     * @return 属性修理厂联系电话的值
     */
    public String getFactoryPhone(){
        return factoryPhone;
    }

    /**
     * 设置属性修理厂报损总金额
     * @param factoryEstimateLoss 待设置的属性修理厂报损总金额的值
     */
    public void setFactoryEstimateLoss(double factoryEstimateLoss){
        this.factoryEstimateLoss = factoryEstimateLoss;
    }

    /**
     * 获取属性修理厂报损总金额
     * @return 属性修理厂报损总金额的值
     */
    public double getFactoryEstimateLoss(){
        return factoryEstimateLoss;
    }

    /**
     * 设置属性推荐修理厂代码
     * @param commendRepairFactoryCode 待设置的属性推荐修理厂代码的值
     */
    public void setCommendRepairFactoryCode(String commendRepairFactoryCode){
        this.commendRepairFactoryCode = StringUtils.rightTrim(commendRepairFactoryCode);
    }

    /**
     * 获取属性推荐修理厂代码
     * @return 属性推荐修理厂代码的值
     */
    public String getCommendRepairFactoryCode(){
        return commendRepairFactoryCode;
    }

    /**
     * 设置属性推荐修理厂名称
     * @param commendRepairFactoryName 待设置的属性推荐修理厂名称的值
     */
    public void setCommendRepairFactoryName(String commendRepairFactoryName){
        this.commendRepairFactoryName = StringUtils.rightTrim(commendRepairFactoryName);
    }

    /**
     * 获取属性推荐修理厂名称
     * @return 属性推荐修理厂名称的值
     */
    public String getCommendRepairFactoryName(){
        return commendRepairFactoryName;
    }

    /**
     * 设置属性紧急程度
     * @param exigenceGree 待设置的属性紧急程度的值
     */
    public void setExigenceGree(String exigenceGree){
        this.exigenceGree = StringUtils.rightTrim(exigenceGree);
    }

    /**
     * 获取属性紧急程度
     * @return 属性紧急程度的值
     */
    public String getExigenceGree(){
        return exigenceGree;
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
