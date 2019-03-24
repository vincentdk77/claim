package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是EdaComplainMain投诉信息表的数据传输对象基类<br>
 * 创建于 2005-08-20 17:55:58.190<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class EdaComplainMainDtoBase implements Serializable{
    /** 属性投诉登记号 */
    private int acceptNo = 0;
    /** 属性投诉客户代码 */
    private String customerCode = "";
    /** 属性投诉客户类型(1个人/2集体) */
    private String customerType = "";
    /** 属性投诉客户名称 */
    private String customerName = "";
    /** 属性投诉对象（部门代码） */
    private String comCode = "";
    /** 属性投诉对象（部门名称） */
    private String comName = "";
    /** 属性投诉对象（员工代码） */
    private String userCode = "";
    /** 属性投诉对象（员工姓名） */
    private String userName = "";
    /** 属性联系人名称 */
    private String linkerName = "";
    /** 属性通信地址 */
    private String postAddress = "";
    /** 属性邮政编码 */
    private String postCode = "";
    /** 属性电话 */
    private String phoneNumber = "";
    /** 属性移动电话 */
    private String mobile = "";
    /** 属性电子邮件 */
    private String email = "";
    /** 属性接听类型 */
    private String transType = "";
    /** 属性语音文件名称 */
    private String voiceFile = "";
    /** 属性处理部门 */
    private String handleUnit = "";
    /** 属性处理人员代码 */
    private String handlerCode = "";
    /** 属性处理人员名称 */
    private String handlerName = "";
    /** 属性处理日期 */
    private DateTime handleDate = new DateTime();
    /** 属性处理时间 */
    private String handleTime = "";
    /** 属性处理状态 */
    private String handleStatus = "";
    /** 属性接听投诉日期 */
    private DateTime listenDate = new DateTime();
    /** 属性接听投诉时间 */
    private String listenTime = "";
    /** 属性接听座席代码 */
    private String listenAgent = "";
    /** 属性收听状态 */
    private String listenStatus = "";
    /** 属性自动语音整理日期 */
    private DateTime cleanDate = new DateTime();
    /** 属性自动语音整理时间 */
    private String cleanTime = "";
    /** 属性自动语音整理座席代码 */
    private String cleanAgent = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性状态 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的EdaComplainMainDtoBase对象
     */
    public EdaComplainMainDtoBase(){
    }

    /**
     * 设置属性投诉登记号
     * @param acceptNo 待设置的属性投诉登记号的值
     */
    public void setAcceptNo(int acceptNo){
        this.acceptNo = acceptNo;
    }

    /**
     * 获取属性投诉登记号
     * @return 属性投诉登记号的值
     */
    public int getAcceptNo(){
        return acceptNo;
    }

    /**
     * 设置属性投诉客户代码
     * @param customerCode 待设置的属性投诉客户代码的值
     */
    public void setCustomerCode(String customerCode){
        this.customerCode = StringUtils.rightTrim(customerCode);
    }

    /**
     * 获取属性投诉客户代码
     * @return 属性投诉客户代码的值
     */
    public String getCustomerCode(){
        return customerCode;
    }

    /**
     * 设置属性投诉客户类型(1个人/2集体)
     * @param customerType 待设置的属性投诉客户类型(1个人/2集体)的值
     */
    public void setCustomerType(String customerType){
        this.customerType = StringUtils.rightTrim(customerType);
    }

    /**
     * 获取属性投诉客户类型(1个人/2集体)
     * @return 属性投诉客户类型(1个人/2集体)的值
     */
    public String getCustomerType(){
        return customerType;
    }

    /**
     * 设置属性投诉客户名称
     * @param customerName 待设置的属性投诉客户名称的值
     */
    public void setCustomerName(String customerName){
        this.customerName = StringUtils.rightTrim(customerName);
    }

    /**
     * 获取属性投诉客户名称
     * @return 属性投诉客户名称的值
     */
    public String getCustomerName(){
        return customerName;
    }

    /**
     * 设置属性投诉对象（部门代码）
     * @param comCode 待设置的属性投诉对象（部门代码）的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性投诉对象（部门代码）
     * @return 属性投诉对象（部门代码）的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性投诉对象（部门名称）
     * @param comName 待设置的属性投诉对象（部门名称）的值
     */
    public void setComName(String comName){
        this.comName = StringUtils.rightTrim(comName);
    }

    /**
     * 获取属性投诉对象（部门名称）
     * @return 属性投诉对象（部门名称）的值
     */
    public String getComName(){
        return comName;
    }

    /**
     * 设置属性投诉对象（员工代码）
     * @param userCode 待设置的属性投诉对象（员工代码）的值
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * 获取属性投诉对象（员工代码）
     * @return 属性投诉对象（员工代码）的值
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * 设置属性投诉对象（员工姓名）
     * @param userName 待设置的属性投诉对象（员工姓名）的值
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * 获取属性投诉对象（员工姓名）
     * @return 属性投诉对象（员工姓名）的值
     */
    public String getUserName(){
        return userName;
    }

    /**
     * 设置属性联系人名称
     * @param linkerName 待设置的属性联系人名称的值
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * 获取属性联系人名称
     * @return 属性联系人名称的值
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * 设置属性通信地址
     * @param postAddress 待设置的属性通信地址的值
     */
    public void setPostAddress(String postAddress){
        this.postAddress = StringUtils.rightTrim(postAddress);
    }

    /**
     * 获取属性通信地址
     * @return 属性通信地址的值
     */
    public String getPostAddress(){
        return postAddress;
    }

    /**
     * 设置属性邮政编码
     * @param postCode 待设置的属性邮政编码的值
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * 获取属性邮政编码
     * @return 属性邮政编码的值
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * 设置属性电话
     * @param phoneNumber 待设置的属性电话的值
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * 获取属性电话
     * @return 属性电话的值
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * 设置属性移动电话
     * @param mobile 待设置的属性移动电话的值
     */
    public void setMobile(String mobile){
        this.mobile = StringUtils.rightTrim(mobile);
    }

    /**
     * 获取属性移动电话
     * @return 属性移动电话的值
     */
    public String getMobile(){
        return mobile;
    }

    /**
     * 设置属性电子邮件
     * @param email 待设置的属性电子邮件的值
     */
    public void setEmail(String email){
        this.email = StringUtils.rightTrim(email);
    }

    /**
     * 获取属性电子邮件
     * @return 属性电子邮件的值
     */
    public String getEmail(){
        return email;
    }

    /**
     * 设置属性接听类型
     * @param transType 待设置的属性接听类型的值
     */
    public void setTransType(String transType){
        this.transType = StringUtils.rightTrim(transType);
    }

    /**
     * 获取属性接听类型
     * @return 属性接听类型的值
     */
    public String getTransType(){
        return transType;
    }

    /**
     * 设置属性语音文件名称
     * @param voiceFile 待设置的属性语音文件名称的值
     */
    public void setVoiceFile(String voiceFile){
        this.voiceFile = StringUtils.rightTrim(voiceFile);
    }

    /**
     * 获取属性语音文件名称
     * @return 属性语音文件名称的值
     */
    public String getVoiceFile(){
        return voiceFile;
    }

    /**
     * 设置属性处理部门
     * @param handleUnit 待设置的属性处理部门的值
     */
    public void setHandleUnit(String handleUnit){
        this.handleUnit = StringUtils.rightTrim(handleUnit);
    }

    /**
     * 获取属性处理部门
     * @return 属性处理部门的值
     */
    public String getHandleUnit(){
        return handleUnit;
    }

    /**
     * 设置属性处理人员代码
     * @param handlerCode 待设置的属性处理人员代码的值
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * 获取属性处理人员代码
     * @return 属性处理人员代码的值
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * 设置属性处理人员名称
     * @param handlerName 待设置的属性处理人员名称的值
     */
    public void setHandlerName(String handlerName){
        this.handlerName = StringUtils.rightTrim(handlerName);
    }

    /**
     * 获取属性处理人员名称
     * @return 属性处理人员名称的值
     */
    public String getHandlerName(){
        return handlerName;
    }

    /**
     * 设置属性处理日期
     * @param handleDate 待设置的属性处理日期的值
     */
    public void setHandleDate(DateTime handleDate){
        this.handleDate = handleDate;
    }

    /**
     * 获取属性处理日期
     * @return 属性处理日期的值
     */
    public DateTime getHandleDate(){
        return handleDate;
    }

    /**
     * 设置属性处理时间
     * @param handleTime 待设置的属性处理时间的值
     */
    public void setHandleTime(String handleTime){
        this.handleTime = StringUtils.rightTrim(handleTime);
    }

    /**
     * 获取属性处理时间
     * @return 属性处理时间的值
     */
    public String getHandleTime(){
        return handleTime;
    }

    /**
     * 设置属性处理状态
     * @param handleStatus 待设置的属性处理状态的值
     */
    public void setHandleStatus(String handleStatus){
        this.handleStatus = StringUtils.rightTrim(handleStatus);
    }

    /**
     * 获取属性处理状态
     * @return 属性处理状态的值
     */
    public String getHandleStatus(){
        return handleStatus;
    }

    /**
     * 设置属性接听投诉日期
     * @param listenDate 待设置的属性接听投诉日期的值
     */
    public void setListenDate(DateTime listenDate){
        this.listenDate = listenDate;
    }

    /**
     * 获取属性接听投诉日期
     * @return 属性接听投诉日期的值
     */
    public DateTime getListenDate(){
        return listenDate;
    }

    /**
     * 设置属性接听投诉时间
     * @param listenTime 待设置的属性接听投诉时间的值
     */
    public void setListenTime(String listenTime){
        this.listenTime = StringUtils.rightTrim(listenTime);
    }

    /**
     * 获取属性接听投诉时间
     * @return 属性接听投诉时间的值
     */
    public String getListenTime(){
        return listenTime;
    }

    /**
     * 设置属性接听座席代码
     * @param listenAgent 待设置的属性接听座席代码的值
     */
    public void setListenAgent(String listenAgent){
        this.listenAgent = StringUtils.rightTrim(listenAgent);
    }

    /**
     * 获取属性接听座席代码
     * @return 属性接听座席代码的值
     */
    public String getListenAgent(){
        return listenAgent;
    }

    /**
     * 设置属性收听状态
     * @param listenStatus 待设置的属性收听状态的值
     */
    public void setListenStatus(String listenStatus){
        this.listenStatus = StringUtils.rightTrim(listenStatus);
    }

    /**
     * 获取属性收听状态
     * @return 属性收听状态的值
     */
    public String getListenStatus(){
        return listenStatus;
    }

    /**
     * 设置属性自动语音整理日期
     * @param cleanDate 待设置的属性自动语音整理日期的值
     */
    public void setCleanDate(DateTime cleanDate){
        this.cleanDate = cleanDate;
    }

    /**
     * 获取属性自动语音整理日期
     * @return 属性自动语音整理日期的值
     */
    public DateTime getCleanDate(){
        return cleanDate;
    }

    /**
     * 设置属性自动语音整理时间
     * @param cleanTime 待设置的属性自动语音整理时间的值
     */
    public void setCleanTime(String cleanTime){
        this.cleanTime = StringUtils.rightTrim(cleanTime);
    }

    /**
     * 获取属性自动语音整理时间
     * @return 属性自动语音整理时间的值
     */
    public String getCleanTime(){
        return cleanTime;
    }

    /**
     * 设置属性自动语音整理座席代码
     * @param cleanAgent 待设置的属性自动语音整理座席代码的值
     */
    public void setCleanAgent(String cleanAgent){
        this.cleanAgent = StringUtils.rightTrim(cleanAgent);
    }

    /**
     * 获取属性自动语音整理座席代码
     * @return 属性自动语音整理座席代码的值
     */
    public String getCleanAgent(){
        return cleanAgent;
    }

    /**
     * 设置属性备注
     * @param remark 待设置的属性备注的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性备注
     * @return 属性备注的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性状态
     * @param flag 待设置的属性状态的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性状态
     * @return 属性状态的值
     */
    public String getFlag(){
        return flag;
    }
}
