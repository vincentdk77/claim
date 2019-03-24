package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLcheckItemLog-查勘任务信息处理日志表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.875<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcheckItemLogDtoBase implements Serializable{
    /** 属性调度ID */
    private int scheduleID = 0;
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性标的序号 */
    private double itemNo = 0d;
    /** 属性处理序号 */
    private int serialNo = 0;
    /** 属性处理时间 */
    private DateTime inputDate = new DateTime();
    /** 属性查勘状态 */
    private String checkFlag = "";
    /** 属性处理信息(由处理片语代码带出，或则直接写) */
    private String checkInfo = "";
    /** 属性处理状况 */
    private String dealFlag = "";
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性操作员名称 */
    private String operatorName = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLcheckItemLogDtoBase对象
     */
    public PrpLcheckItemLogDtoBase(){
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
    public void setItemNo(double itemNo){
        this.itemNo = itemNo;
    }

    /**
     * 获取属性标的序号
     * @return 属性标的序号的值
     */
    public double getItemNo(){
        return itemNo;
    }

    /**
     * 设置属性处理序号
     * @param serialNo 待设置的属性处理序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性处理序号
     * @return 属性处理序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性处理时间
     * @param inputDate 待设置的属性处理时间的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性处理时间
     * @return 属性处理时间的值
     */
    public DateTime getInputDate(){
        return inputDate;
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
     * 设置属性处理信息(由处理片语代码带出，或则直接写)
     * @param checkInfo 待设置的属性处理信息(由处理片语代码带出，或则直接写)的值
     */
    public void setCheckInfo(String checkInfo){
        this.checkInfo = StringUtils.rightTrim(checkInfo);
    }

    /**
     * 获取属性处理信息(由处理片语代码带出，或则直接写)
     * @return 属性处理信息(由处理片语代码带出，或则直接写)的值
     */
    public String getCheckInfo(){
        return checkInfo;
    }

    /**
     * 设置属性处理状况
     * @param dealFlag 待设置的属性处理状况的值
     */
    public void setDealFlag(String dealFlag){
        this.dealFlag = StringUtils.rightTrim(dealFlag);
    }

    /**
     * 获取属性处理状况
     * @return 属性处理状况的值
     */
    public String getDealFlag(){
        return dealFlag;
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
     * 设置属性操作员名称
     * @param operatorName 待设置的属性操作员名称的值
     */
    public void setOperatorName(String operatorName){
        this.operatorName = StringUtils.rightTrim(operatorName);
    }

    /**
     * 获取属性操作员名称
     * @return 属性操作员名称的值
     */
    public String getOperatorName(){
        return operatorName;
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
