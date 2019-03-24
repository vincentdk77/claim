package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpldealinfo的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:06<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLdealinfoDtoBase implements Serializable{
    /** 属性报案号 */
    private String registNo = "";
    /** 属性报案人 */
    private String reportName = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性出险标的明细名称 */
    private String itemName = "";
    /** 属性归属部门 */
    private String comCode = "";
    /** 属性处理日期 */
    private DateTime dealDate = new DateTime();
    /** 属性处理时间 */
    private int dealHour = 0;
    /** 属性报案日期 */
    private DateTime reportDate = new DateTime();
    /** 属性承保公司电话 */
    private String insurePhoneNumber = "";
    /** 属性受理人员 */
    private String acceptName = "";
    /** 属性座席 */
    private String seatNo = "";
    /** 属性定损人员 */
    private String defLossName = "";
    /** 属性定损人员电话 */
    private String checkPhoneNumber = "";
    /** 属性定损出发日期 */
    private DateTime checkStartDate = new DateTime();
    /** 属性定损出发时间 */
    private int checkStartHour = 0;
    /** 属性处理情况 */
    private String dealStatus = "";
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLdealinfoDtoBase对象
     */
    public PrpLdealinfoDtoBase(){
    }

    /**
     * 设置属性报案号
     * @param registNo 待设置的属性报案号的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号
     * @return 属性报案号的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性报案人
     * @param reportName 待设置的属性报案人的值
     */
    public void setReportName(String reportName){
        this.reportName = StringUtils.rightTrim(reportName);
    }

    /**
     * 获取属性报案人
     * @return 属性报案人的值
     */
    public String getReportName(){
        return reportName;
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
     * 设置属性出险标的明细名称
     * @param itemName 待设置的属性出险标的明细名称的值
     */
    public void setItemName(String itemName){
        this.itemName = StringUtils.rightTrim(itemName);
    }

    /**
     * 获取属性出险标的明细名称
     * @return 属性出险标的明细名称的值
     */
    public String getItemName(){
        return itemName;
    }

    /**
     * 设置属性归属部门
     * @param comCode 待设置的属性归属部门的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性归属部门
     * @return 属性归属部门的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性处理日期
     * @param dealDate 待设置的属性处理日期的值
     */
    public void setDealDate(DateTime dealDate){
        this.dealDate = dealDate;
    }

    /**
     * 获取属性处理日期
     * @return 属性处理日期的值
     */
    public DateTime getDealDate(){
        return dealDate;
    }

    /**
     * 设置属性处理时间
     * @param dealHour 待设置的属性处理时间的值
     */
    public void setDealHour(int dealHour){
        this.dealHour = dealHour;
    }

    /**
     * 获取属性处理时间
     * @return 属性处理时间的值
     */
    public int getDealHour(){
        return dealHour;
    }

    /**
     * 设置属性报案日期
     * @param reportDate 待设置的属性报案日期的值
     */
    public void setReportDate(DateTime reportDate){
        this.reportDate = reportDate;
    }

    /**
     * 获取属性报案日期
     * @return 属性报案日期的值
     */
    public DateTime getReportDate(){
        return reportDate;
    }

    /**
     * 设置属性承保公司电话
     * @param insurePhoneNumber 待设置的属性承保公司电话的值
     */
    public void setInsurePhoneNumber(String insurePhoneNumber){
        this.insurePhoneNumber = StringUtils.rightTrim(insurePhoneNumber);
    }

    /**
     * 获取属性承保公司电话
     * @return 属性承保公司电话的值
     */
    public String getInsurePhoneNumber(){
        return insurePhoneNumber;
    }

    /**
     * 设置属性受理人员
     * @param acceptName 待设置的属性受理人员的值
     */
    public void setAcceptName(String acceptName){
        this.acceptName = StringUtils.rightTrim(acceptName);
    }

    /**
     * 获取属性受理人员
     * @return 属性受理人员的值
     */
    public String getAcceptName(){
        return acceptName;
    }

    /**
     * 设置属性座席
     * @param seatNo 待设置的属性座席的值
     */
    public void setSeatNo(String seatNo){
        this.seatNo = StringUtils.rightTrim(seatNo);
    }

    /**
     * 获取属性座席
     * @return 属性座席的值
     */
    public String getSeatNo(){
        return seatNo;
    }

    /**
     * 设置属性定损人员
     * @param defLossName 待设置的属性定损人员的值
     */
    public void setDefLossName(String defLossName){
        this.defLossName = StringUtils.rightTrim(defLossName);
    }

    /**
     * 获取属性定损人员
     * @return 属性定损人员的值
     */
    public String getDefLossName(){
        return defLossName;
    }

    /**
     * 设置属性定损人员电话
     * @param checkPhoneNumber 待设置的属性定损人员电话的值
     */
    public void setCheckPhoneNumber(String checkPhoneNumber){
        this.checkPhoneNumber = StringUtils.rightTrim(checkPhoneNumber);
    }

    /**
     * 获取属性定损人员电话
     * @return 属性定损人员电话的值
     */
    public String getCheckPhoneNumber(){
        return checkPhoneNumber;
    }

    /**
     * 设置属性定损出发日期
     * @param checkStartDate 待设置的属性定损出发日期的值
     */
    public void setCheckStartDate(DateTime checkStartDate){
        this.checkStartDate = checkStartDate;
    }

    /**
     * 获取属性定损出发日期
     * @return 属性定损出发日期的值
     */
    public DateTime getCheckStartDate(){
        return checkStartDate;
    }

    /**
     * 设置属性定损出发时间
     * @param checkStartHour 待设置的属性定损出发时间的值
     */
    public void setCheckStartHour(int checkStartHour){
        this.checkStartHour = checkStartHour;
    }

    /**
     * 获取属性定损出发时间
     * @return 属性定损出发时间的值
     */
    public int getCheckStartHour(){
        return checkStartHour;
    }

    /**
     * 设置属性处理情况
     * @param dealStatus 待设置的属性处理情况的值
     */
    public void setDealStatus(String dealStatus){
        this.dealStatus = StringUtils.rightTrim(dealStatus);
    }

    /**
     * 获取属性处理情况
     * @return 属性处理情况的值
     */
    public String getDealStatus(){
        return dealStatus;
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
