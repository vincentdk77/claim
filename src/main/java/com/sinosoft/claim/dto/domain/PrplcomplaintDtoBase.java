package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLCOMPLAINT的数据传输对象基类<br>
 */
public class PrplcomplaintDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性COMPLAINTNO 投诉编号*/
    private String complaintno = "";
    /** 属性COMPLAINTDATE 投诉时间*/
    private DateTime complaintdate = new DateTime();
    /** 属性COMPLAINTTYPE 投诉大类*/
    private String complainttype = "";
    /** 属性BYCOMPLAINTCOMCODE 被投诉机构*/
    private String bycomplaintcomcode = "";
    /** 属性BYCOMPLAINTCODE 被投诉人*/
    private String bycomplaintcode = "";
    /** 属性COMPLAINTNAME 投诉人姓名*/
    private String complaintname = "";
    /** 属性CALLNO 来电号码*/
    private String callno = "";
    /** 属性TELEPHONE 其他联系电话*/
    private String telephone = "";
    /** 属性COMPLAINTCAUSE 投诉原因*/
    private String complaintcause = "";
    /** 属性DETAILEDCAUSE 投诉详细原因*/
    private String detailedcause = "";
    /** 属性WHETHERCOMPLAINT 是否有效投诉*/
    private String whethercomplaint = "";
    /** 属性WHETHERTRACK 是否需要跟踪*/
    private String whethertrack = "";
    /** 属性REGISTNO 报案号码*/
    private String registno = "";
    /** 属性RECORDINGNO 录音流水号*/
    private String recordingno = "";
    /** 属性HANDLERCODE 投诉处理人ID*/
    private String handlercode = "";
    /** 属性HANDLERNAME 投诉理人员*/
    private String handlername = "";
    /** 属性HANDLERCOMCODE 处理结构ID*/
    private String handlercomcode = "";
    /** 属性COMPLAINTINFO 投诉信息*/
    private String complaintinfo = "";
    /** 属性COMPLAINTOPINION 处理意见*/
    private String complaintopinion = "";
    /** 属性TRANSACTORNAME 处理人员*/
    private String transactorname = "";
    /** 属性TRANSACTORCODE 处理人ID*/
    private String transactorcode = "";
    /** 属性HANDLERDATE 投诉提交时间*/
    private DateTime handlerdate = new DateTime();
    /** 属性TRANSACTORDATE 处理提交时间*/
    private DateTime transactordate = new DateTime();
    /** 属性CLASSCODE 险类*/
    private String classcode = "";
    /** 属性STATE 状态 (3待处理，4处理提交)*/
    private String state = "";

    /**
     *  默认构造方法,构造一个默认的PrplcomplaintDtoBase对象
     */
    public PrplcomplaintDtoBase(){
    }

    /**
     * 设置属性COMPLAINTNO
     * @param complaintno 待设置的属性COMPLAINTNO的值
     */
    public void setComplaintno(String complaintno){
        this.complaintno = StringUtils.rightTrim(complaintno);
    }

    /**
     * 获取属性COMPLAINTNO
     * @return 属性COMPLAINTNO的值
     */
    public String getComplaintno(){
        return complaintno;
    }

    /**
     * 设置属性COMPLAINTDATE
     * @param complaintdate 待设置的属性COMPLAINTDATE的值
     */
    public void setComplaintdate(DateTime complaintdate){
        this.complaintdate = complaintdate;
    }

    /**
     * 获取属性COMPLAINTDATE
     * @return 属性COMPLAINTDATE的值
     */
    public DateTime getComplaintdate(){
        return complaintdate;
    }

    /**
     * 设置属性COMPLAINTTYPE
     * @param complainttype 待设置的属性COMPLAINTTYPE的值
     */
    public void setComplainttype(String complainttype){
        this.complainttype = StringUtils.rightTrim(complainttype);
    }

    /**
     * 获取属性COMPLAINTTYPE
     * @return 属性COMPLAINTTYPE的值
     */
    public String getComplainttype(){
        return complainttype;
    }

    /**
     * 设置属性BYCOMPLAINTCOMCODE
     * @param bycomplaintcomcode 待设置的属性BYCOMPLAINTCOMCODE的值
     */
    public void setBycomplaintcomcode(String bycomplaintcomcode){
        this.bycomplaintcomcode = StringUtils.rightTrim(bycomplaintcomcode);
    }

    /**
     * 获取属性BYCOMPLAINTCOMCODE
     * @return 属性BYCOMPLAINTCOMCODE的值
     */
    public String getBycomplaintcomcode(){
        return bycomplaintcomcode;
    }

    /**
     * 设置属性BYCOMPLAINTCODE
     * @param bycomplaintcode 待设置的属性BYCOMPLAINTCODE的值
     */
    public void setBycomplaintcode(String bycomplaintcode){
        this.bycomplaintcode = StringUtils.rightTrim(bycomplaintcode);
    }

    /**
     * 获取属性BYCOMPLAINTCODE
     * @return 属性BYCOMPLAINTCODE的值
     */
    public String getBycomplaintcode(){
        return bycomplaintcode;
    }

    /**
     * 设置属性COMPLAINTNAME
     * @param complaintname 待设置的属性COMPLAINTNAME的值
     */
    public void setComplaintname(String complaintname){
        this.complaintname = StringUtils.rightTrim(complaintname);
    }

    /**
     * 获取属性COMPLAINTNAME
     * @return 属性COMPLAINTNAME的值
     */
    public String getComplaintname(){
        return complaintname;
    }

    /**
     * 设置属性CALLNO
     * @param callno 待设置的属性CALLNO的值
     */
    public void setCallno(String callno){
        this.callno = StringUtils.rightTrim(callno);
    }

    /**
     * 获取属性CALLNO
     * @return 属性CALLNO的值
     */
    public String getCallno(){
        return callno;
    }

    /**
     * 设置属性TELEPHONE
     * @param telephone 待设置的属性TELEPHONE的值
     */
    public void setTelephone(String telephone){
        this.telephone = StringUtils.rightTrim(telephone);
    }

    /**
     * 获取属性TELEPHONE
     * @return 属性TELEPHONE的值
     */
    public String getTelephone(){
        return telephone;
    }

    /**
     * 设置属性COMPLAINTCAUSE
     * @param complaintcause 待设置的属性COMPLAINTCAUSE的值
     */
    public void setComplaintcause(String complaintcause){
        this.complaintcause = StringUtils.rightTrim(complaintcause);
    }

    /**
     * 获取属性COMPLAINTCAUSE
     * @return 属性COMPLAINTCAUSE的值
     */
    public String getComplaintcause(){
        return complaintcause;
    }

    /**
     * 设置属性DETAILEDCAUSE
     * @param detailedcause 待设置的属性DETAILEDCAUSE的值
     */
    public void setDetailedcause(String detailedcause){
        this.detailedcause = StringUtils.rightTrim(detailedcause);
    }

    /**
     * 获取属性DETAILEDCAUSE
     * @return 属性DETAILEDCAUSE的值
     */
    public String getDetailedcause(){
        return detailedcause;
    }

    /**
     * 设置属性WHETHERCOMPLAINT
     * @param whethercomplaint 待设置的属性WHETHERCOMPLAINT的值
     */
    public void setWhethercomplaint(String whethercomplaint){
        this.whethercomplaint = StringUtils.rightTrim(whethercomplaint);
    }

    /**
     * 获取属性WHETHERCOMPLAINT
     * @return 属性WHETHERCOMPLAINT的值
     */
    public String getWhethercomplaint(){
        return whethercomplaint;
    }

    /**
     * 设置属性WHETHERTRACK
     * @param whethertrack 待设置的属性WHETHERTRACK的值
     */
    public void setWhethertrack(String whethertrack){
        this.whethertrack = StringUtils.rightTrim(whethertrack);
    }

    /**
     * 获取属性WHETHERTRACK
     * @return 属性WHETHERTRACK的值
     */
    public String getWhethertrack(){
        return whethertrack;
    }

    /**
     * 设置属性REGISTNO
     * @param registno 待设置的属性REGISTNO的值
     */
    public void setRegistno(String registno){
        this.registno = StringUtils.rightTrim(registno);
    }

    /**
     * 获取属性REGISTNO
     * @return 属性REGISTNO的值
     */
    public String getRegistno(){
        return registno;
    }

    /**
     * 设置属性RECORDINGNO
     * @param recordingno 待设置的属性RECORDINGNO的值
     */
    public void setRecordingno(String recordingno){
        this.recordingno = StringUtils.rightTrim(recordingno);
    }

    /**
     * 获取属性RECORDINGNO
     * @return 属性RECORDINGNO的值
     */
    public String getRecordingno(){
        return recordingno;
    }

    /**
     * 设置属性HANDLERCODE
     * @param handlercode 待设置的属性HANDLERCODE的值
     */
    public void setHandlercode(String handlercode){
        this.handlercode = StringUtils.rightTrim(handlercode);
    }

    /**
     * 获取属性HANDLERCODE
     * @return 属性HANDLERCODE的值
     */
    public String getHandlercode(){
        return handlercode;
    }

    /**
     * 设置属性HANDLERNAME
     * @param handlername 待设置的属性HANDLERNAME的值
     */
    public void setHandlername(String handlername){
        this.handlername = StringUtils.rightTrim(handlername);
    }

    /**
     * 获取属性HANDLERNAME
     * @return 属性HANDLERNAME的值
     */
    public String getHandlername(){
        return handlername;
    }

    /**
     * 设置属性HANDLERCOMCODE
     * @param handlercomcode 待设置的属性HANDLERCOMCODE的值
     */
    public void setHandlercomcode(String handlercomcode){
        this.handlercomcode = StringUtils.rightTrim(handlercomcode);
    }

    /**
     * 获取属性HANDLERCOMCODE
     * @return 属性HANDLERCOMCODE的值
     */
    public String getHandlercomcode(){
        return handlercomcode;
    }

    /**
     * 设置属性COMPLAINTINFO
     * @param complaintinfo 待设置的属性COMPLAINTINFO的值
     */
    public void setComplaintinfo(String complaintinfo){
        this.complaintinfo = StringUtils.rightTrim(complaintinfo);
    }

    /**
     * 获取属性COMPLAINTINFO
     * @return 属性COMPLAINTINFO的值
     */
    public String getComplaintinfo(){
        return complaintinfo;
    }

    /**
     * 设置属性COMPLAINTOPINION
     * @param complaintopinion 待设置的属性COMPLAINTOPINION的值
     */
    public void setComplaintopinion(String complaintopinion){
        this.complaintopinion = StringUtils.rightTrim(complaintopinion);
    }

    /**
     * 获取属性COMPLAINTOPINION
     * @return 属性COMPLAINTOPINION的值
     */
    public String getComplaintopinion(){
        return complaintopinion;
    }

    /**
     * 设置属性TRANSACTORNAME
     * @param transactorname 待设置的属性TRANSACTORNAME的值
     */
    public void setTransactorname(String transactorname){
        this.transactorname = StringUtils.rightTrim(transactorname);
    }

    /**
     * 获取属性TRANSACTORNAME
     * @return 属性TRANSACTORNAME的值
     */
    public String getTransactorname(){
        return transactorname;
    }

    /**
     * 设置属性TRANSACTORCODE
     * @param transactorcode 待设置的属性TRANSACTORCODE的值
     */
    public void setTransactorcode(String transactorcode){
        this.transactorcode = StringUtils.rightTrim(transactorcode);
    }

    /**
     * 获取属性TRANSACTORCODE
     * @return 属性TRANSACTORCODE的值
     */
    public String getTransactorcode(){
        return transactorcode;
    }

    /**
     * 设置属性HANDLERDATE
     * @param handlerdate 待设置的属性HANDLERDATE的值
     */
    public void setHandlerdate(DateTime handlerdate){
        this.handlerdate = handlerdate;
    }

    /**
     * 获取属性HANDLERDATE
     * @return 属性HANDLERDATE的值
     */
    public DateTime getHandlerdate(){
        return handlerdate;
    }

    /**
     * 设置属性TRANSACTORDATE
     * @param transactordate 待设置的属性TRANSACTORDATE的值
     */
    public void setTransactordate(DateTime transactordate){
        this.transactordate = transactordate;
    }

    /**
     * 获取属性TRANSACTORDATE
     * @return 属性TRANSACTORDATE的值
     */
    public DateTime getTransactordate(){
        return transactordate;
    }

    /**
     * 设置属性CLASSCODE
     * @param classcode 待设置的属性CLASSCODE的值
     */
    public void setClasscode(String classcode){
        this.classcode = StringUtils.rightTrim(classcode);
    }

    /**
     * 获取属性CLASSCODE
     * @return 属性CLASSCODE的值
     */
    public String getClasscode(){
        return classcode;
    }

    /**
     * 设置属性STATE
     * @param state 待设置的属性STATE的值
     */
    public void setState(String state){
        this.state = StringUtils.rightTrim(state);
    }

    /**
     * 获取属性STATE
     * @return 属性STATE的值
     */
    public String getState(){
        return state;
    }
}
