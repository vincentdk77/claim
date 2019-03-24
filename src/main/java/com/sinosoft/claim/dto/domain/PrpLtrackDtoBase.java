package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpltrack的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:06<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLtrackDtoBase implements Serializable{
    /** 属性报案号 */
    private String registNo = "";
    /** 属性单证代码 */
    private String docCode = "";
    /** 属性单证名称 */
    private String docName = "";
    /** 属性状态 */
    private int status = 0;
    /** 属性送件人 */
    private String sendorName = "";
    /** 属性送件时间 */
    private DateTime sendDate = new DateTime();
    /** 属性收件人 */
    private String acceptName = "";
    /** 属性收件时间 */
    private DateTime acceptDate = new DateTime();
    /** 属性移交核赔部人员 */
    private String checkName = "";
    /** 属性移交核赔部时间 */
    private DateTime checkDate = new DateTime();
    /** 属性核赔返回时间 */
    private DateTime returnDate = new DateTime();
    /** 属性归档号 */
    private String dossierMark = "";
    /** 属性是否结案 */
    private String endCase = "";
    /** 属性标记 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLtrackDtoBase对象
     */
    public PrpLtrackDtoBase(){
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
     * 设置属性单证代码
     * @param docCode 待设置的属性单证代码的值
     */
    public void setDocCode(String docCode){
        this.docCode = StringUtils.rightTrim(docCode);
    }

    /**
     * 获取属性单证代码
     * @return 属性单证代码的值
     */
    public String getDocCode(){
        return docCode;
    }

    /**
     * 设置属性单证名称
     * @param docName 待设置的属性单证名称的值
     */
    public void setDocName(String docName){
        this.docName = StringUtils.rightTrim(docName);
    }

    /**
     * 获取属性单证名称
     * @return 属性单证名称的值
     */
    public String getDocName(){
        return docName;
    }

    /**
     * 设置属性状态
     * @param status 待设置的属性状态的值
     */
    public void setStatus(int status){
        this.status = status;
    }

    /**
     * 获取属性状态
     * @return 属性状态的值
     */
    public int getStatus(){
        return status;
    }

    /**
     * 设置属性送件人
     * @param sendorName 待设置的属性送件人的值
     */
    public void setSendorName(String sendorName){
        this.sendorName = StringUtils.rightTrim(sendorName);
    }

    /**
     * 获取属性送件人
     * @return 属性送件人的值
     */
    public String getSendorName(){
        return sendorName;
    }

    /**
     * 设置属性送件时间
     * @param sendDate 待设置的属性送件时间的值
     */
    public void setSendDate(DateTime sendDate){
        this.sendDate = sendDate;
    }

    /**
     * 获取属性送件时间
     * @return 属性送件时间的值
     */
    public DateTime getSendDate(){
        return sendDate;
    }

    /**
     * 设置属性收件人
     * @param acceptName 待设置的属性收件人的值
     */
    public void setAcceptName(String acceptName){
        this.acceptName = StringUtils.rightTrim(acceptName);
    }

    /**
     * 获取属性收件人
     * @return 属性收件人的值
     */
    public String getAcceptName(){
        return acceptName;
    }

    /**
     * 设置属性收件时间
     * @param acceptDate 待设置的属性收件时间的值
     */
    public void setAcceptDate(DateTime acceptDate){
        this.acceptDate = acceptDate;
    }

    /**
     * 获取属性收件时间
     * @return 属性收件时间的值
     */
    public DateTime getAcceptDate(){
        return acceptDate;
    }

    /**
     * 设置属性移交核赔部人员
     * @param checkName 待设置的属性移交核赔部人员的值
     */
    public void setCheckName(String checkName){
        this.checkName = StringUtils.rightTrim(checkName);
    }

    /**
     * 获取属性移交核赔部人员
     * @return 属性移交核赔部人员的值
     */
    public String getCheckName(){
        return checkName;
    }

    /**
     * 设置属性移交核赔部时间
     * @param checkDate 待设置的属性移交核赔部时间的值
     */
    public void setCheckDate(DateTime checkDate){
        this.checkDate = checkDate;
    }

    /**
     * 获取属性移交核赔部时间
     * @return 属性移交核赔部时间的值
     */
    public DateTime getCheckDate(){
        return checkDate;
    }

    /**
     * 设置属性核赔返回时间
     * @param returnDate 待设置的属性核赔返回时间的值
     */
    public void setReturnDate(DateTime returnDate){
        this.returnDate = returnDate;
    }

    /**
     * 获取属性核赔返回时间
     * @return 属性核赔返回时间的值
     */
    public DateTime getReturnDate(){
        return returnDate;
    }

    /**
     * 设置属性归档号
     * @param dossierMark 待设置的属性归档号的值
     */
    public void setDossierMark(String dossierMark){
        this.dossierMark = StringUtils.rightTrim(dossierMark);
    }

    /**
     * 获取属性归档号
     * @return 属性归档号的值
     */
    public String getDossierMark(){
        return dossierMark;
    }

    /**
     * 设置属性是否结案
     * @param endCase 待设置的属性是否结案的值
     */
    public void setEndCase(String endCase){
        this.endCase = StringUtils.rightTrim(endCase);
    }

    /**
     * 获取属性是否结案
     * @return 属性是否结案的值
     */
    public String getEndCase(){
        return endCase;
    }

    /**
     * 设置属性标记
     * @param flag 待设置的属性标记的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标记
     * @return 属性标记的值
     */
    public String getFlag(){
        return flag;
    }
}
