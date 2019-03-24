package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLbackVisit--回访信息主表的数据传输对象基类<br>
 * 创建于 2005-03-25 20:44:41.906<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLbackVisitDtoBase implements Serializable{
    /** 属性客户回访记录ID */
    private int backVisitID = 0;
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性业务类型 */
    private String backVisitType = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性车牌号码 */
    private String licenseNo = "";
    /** 属性被保险人代码 */
    private String insuredCode = "";
    /** 属性被保险人名称 */
    private String insuredName = "";
    /** 属性客户类型 */
    private String customType = "";
    /** 属性联系电话 */
    private String phone = "";
    /** 属性传真 */
    private String fax = "";
    /** 属性邮政编码 */
    private String postCode = "";
    /** 属性电子邮件 */
    private String email = "";
    /** 属性联系人 */
    private String linkerName = "";
    /** 属性联系地址 */
    private String address = "";
    /** 属性处理人员代码 */
    private String handlerCode = "";
    /** 属性处理人员名称 */
    private String handlerName = "";
    /** 属性处理部门 */
    private String handleDept = "";
    /** 属性回访时间 */
    private String backVisitTime = "";
    /** 属性客户满意度 */
    private String customOpinion = "";
    /** 属性转接部门 */
    private String deliverDepart = "";
    /** 属性转接时间 */
    private String deliverTime = "";
    /** 属性转接经办人 */
    private String deliverPerson = "";
    /** 属性反馈时间 */
    private String deliverBackTime = "";
    /** 属性答复客户时间 */
    private String backCustomTime = "";
    /** 属性催办标志 */
    private String hurryFlag = "";
    /** 属性回访状态 */
    private String status = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLbackVisitDtoBase对象
     */
    public PrpLbackVisitDtoBase(){
    }

    /**
     * 设置属性客户回访记录ID
     * @param backVisitID 待设置的属性客户回访记录ID的值
     */
    public void setBackVisitID(int backVisitID){
        this.backVisitID = backVisitID;
    }

    /**
     * 获取属性客户回访记录ID
     * @return 属性客户回访记录ID的值
     */
    public int getBackVisitID(){
        return backVisitID;
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
     * 设置属性业务类型
     * @param backVisitType 待设置的属性业务类型的值
     */
    public void setBackVisitType(String backVisitType){
        this.backVisitType = StringUtils.rightTrim(backVisitType);
    }

    /**
     * 获取属性业务类型
     * @return 属性业务类型的值
     */
    public String getBackVisitType(){
        return backVisitType;
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
     * 设置属性车牌号码
     * @param licenseNo 待设置的属性车牌号码的值
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * 获取属性车牌号码
     * @return 属性车牌号码的值
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * 设置属性被保险人代码
     * @param insuredCode 待设置的属性被保险人代码的值
     */
    public void setInsuredCode(String insuredCode){
        this.insuredCode = StringUtils.rightTrim(insuredCode);
    }

    /**
     * 获取属性被保险人代码
     * @return 属性被保险人代码的值
     */
    public String getInsuredCode(){
        return insuredCode;
    }

    /**
     * 设置属性被保险人名称
     * @param insuredName 待设置的属性被保险人名称的值
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * 获取属性被保险人名称
     * @return 属性被保险人名称的值
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * 设置属性客户类型
     * @param customType 待设置的属性客户类型的值
     */
    public void setCustomType(String customType){
        this.customType = StringUtils.rightTrim(customType);
    }

    /**
     * 获取属性客户类型
     * @return 属性客户类型的值
     */
    public String getCustomType(){
        return customType;
    }

    /**
     * 设置属性联系电话
     * @param phone 待设置的属性联系电话的值
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * 获取属性联系电话
     * @return 属性联系电话的值
     */
    public String getPhone(){
        return phone;
    }

    /**
     * 设置属性传真
     * @param fax 待设置的属性传真的值
     */
    public void setFax(String fax){
        this.fax = StringUtils.rightTrim(fax);
    }

    /**
     * 获取属性传真
     * @return 属性传真的值
     */
    public String getFax(){
        return fax;
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
     * 设置属性联系人
     * @param linkerName 待设置的属性联系人的值
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * 获取属性联系人
     * @return 属性联系人的值
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * 设置属性联系地址
     * @param address 待设置的属性联系地址的值
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * 获取属性联系地址
     * @return 属性联系地址的值
     */
    public String getAddress(){
        return address;
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
     * 设置属性处理部门
     * @param handleDept 待设置的属性处理部门的值
     */
    public void setHandleDept(String handleDept){
        this.handleDept = StringUtils.rightTrim(handleDept);
    }

    /**
     * 获取属性处理部门
     * @return 属性处理部门的值
     */
    public String getHandleDept(){
        return handleDept;
    }

    /**
     * 设置属性回访时间
     * @param backVisitTime 待设置的属性回访时间的值
     */
    public void setBackVisitTime(String backVisitTime){
        this.backVisitTime = StringUtils.rightTrim(backVisitTime);
    }

    /**
     * 获取属性回访时间
     * @return 属性回访时间的值
     */
    public String getBackVisitTime(){
        return backVisitTime;
    }

    /**
     * 设置属性客户满意度
     * @param customOpinion 待设置的属性客户满意度的值
     */
    public void setCustomOpinion(String customOpinion){
        this.customOpinion = StringUtils.rightTrim(customOpinion);
    }

    /**
     * 获取属性客户满意度
     * @return 属性客户满意度的值
     */
    public String getCustomOpinion(){
        return customOpinion;
    }

    /**
     * 设置属性转接部门
     * @param deliverDepart 待设置的属性转接部门的值
     */
    public void setDeliverDepart(String deliverDepart){
        this.deliverDepart = StringUtils.rightTrim(deliverDepart);
    }

    /**
     * 获取属性转接部门
     * @return 属性转接部门的值
     */
    public String getDeliverDepart(){
        return deliverDepart;
    }

    /**
     * 设置属性转接时间
     * @param deliverTime 待设置的属性转接时间的值
     */
    public void setDeliverTime(String deliverTime){
        this.deliverTime = StringUtils.rightTrim(deliverTime);
    }

    /**
     * 获取属性转接时间
     * @return 属性转接时间的值
     */
    public String getDeliverTime(){
        return deliverTime;
    }

    /**
     * 设置属性转接经办人
     * @param deliverPerson 待设置的属性转接经办人的值
     */
    public void setDeliverPerson(String deliverPerson){
        this.deliverPerson = StringUtils.rightTrim(deliverPerson);
    }

    /**
     * 获取属性转接经办人
     * @return 属性转接经办人的值
     */
    public String getDeliverPerson(){
        return deliverPerson;
    }

    /**
     * 设置属性反馈时间
     * @param deliverBackTime 待设置的属性反馈时间的值
     */
    public void setDeliverBackTime(String deliverBackTime){
        this.deliverBackTime = StringUtils.rightTrim(deliverBackTime);
    }

    /**
     * 获取属性反馈时间
     * @return 属性反馈时间的值
     */
    public String getDeliverBackTime(){
        return deliverBackTime;
    }

    /**
     * 设置属性答复客户时间
     * @param backCustomTime 待设置的属性答复客户时间的值
     */
    public void setBackCustomTime(String backCustomTime){
        this.backCustomTime = StringUtils.rightTrim(backCustomTime);
    }

    /**
     * 获取属性答复客户时间
     * @return 属性答复客户时间的值
     */
    public String getBackCustomTime(){
        return backCustomTime;
    }

    /**
     * 设置属性催办标志
     * @param hurryFlag 待设置的属性催办标志的值
     */
    public void setHurryFlag(String hurryFlag){
        this.hurryFlag = StringUtils.rightTrim(hurryFlag);
    }

    /**
     * 获取属性催办标志
     * @return 属性催办标志的值
     */
    public String getHurryFlag(){
        return hurryFlag;
    }

    /**
     * 设置属性回访状态
     * @param status 待设置的属性回访状态的值
     */
    public void setStatus(String status){
        this.status = StringUtils.rightTrim(status);
    }

    /**
     * 获取属性回访状态
     * @return 属性回访状态的值
     */
    public String getStatus(){
        return status;
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
