package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLPENDTRACK的数据传输对象基类<br>
 */
public class PrplpendtrackDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性 报案号 */
    private String registno = "";
    /** 属性 序号 */
    private String logno = "";
    /** 属性 对应结点名（车物查勘、人伤查勘、单证) */
    private String nodetype = "";
    /** 属性 跟踪方式（0-自动/1-手动） */
    private String tracktype = "";
    /** 属性 是否处理(0-未处理，1-已处理） */
    private String validstatus = "";
    /** 属性 承保机构 */
    private String comcode = "";
    /** 属性ISSUCCESS 是否跟踪成功（0-不成功，1-成功）*/
    private String issuccess = "";
    /** 属性REASONSELECT 不成功原因(prpdcode配置)*/
    private String reasonselect = "";
    /** 属性REASONTEXT 手动填写的原因*/
    private String reasontext = "";
    /** 属性CUSTOMERNAME 客户姓名*/
    private String customername = "";
    /** 属性CUSTOMERNO 客户序号*/
    private String customerNo = "";
    /** 属性CUSTOMERTEL 客户电话*/
    private String customertel = "";
    /** 属性ACCIDENT 事故责任情况*/
    private String accident = "";
    /** 属性ACCIDENTSELECT 事故责任情况下拉项*/
    private String accidentselect = "";
    /** 属性COMPENSATION 损害赔偿情况*/
    private String compensation = "";
    /** 属性TRACK 跟踪说明*/
    private String track = "";
    /** 属性AUTOMATICCYCLE 自动跟踪周期*/
    private String automaticcycle = "";
    /** 属性NEXTPROMPT 下次跟踪提示*/
    private String nextprompt = "";
    /** 属性OPERATORNAME 回访人员*/
    private String operatorname = "";
    /** 属性OPERATORCODE 回访人员代码*/
    private String operatorcode = "";
    /** 属性SUBMITTIME 完成时间*/
    private String submittime = "";
    /** 属性NEXTTIME 生效时间*/
    private String nexttime = "";
    /** 属性FLOWINTIME 入库时间*/
    private String flowintime = "";
    /** 属性nodeStatus 节点标识*/
    private String nodeStatus = "";

    /**
     *  默认构造方法,构造一个默认的PrplpendtrackDtoBase对象
     */
    public PrplpendtrackDtoBase(){
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
     * 设置属性LOGNO
     * @param logno 待设置的属性LOGNO的值
     */
    public void setLogno(String logno){
        this.logno = StringUtils.rightTrim(logno);
    }

    /**
     * 获取属性LOGNO
     * @return 属性LOGNO的值
     */
    public String getLogno(){
        return logno;
    }

    /**
     * 设置属性NODETYPE
     * @param nodetype 待设置的属性NODETYPE的值
     */
    public void setNodetype(String nodetype){
        this.nodetype = StringUtils.rightTrim(nodetype);
    }

    /**
     * 获取属性NODETYPE
     * @return 属性NODETYPE的值
     */
    public String getNodetype(){
        return nodetype;
    }

    /**
     * 设置属性TRACKTYPE
     * @param tracktype 待设置的属性TRACKTYPE的值
     */
    public void setTracktype(String tracktype){
        this.tracktype = StringUtils.rightTrim(tracktype);
    }

    /**
     * 获取属性TRACKTYPE
     * @return 属性TRACKTYPE的值
     */
    public String getTracktype(){
        return tracktype;
    }

    /**
     * 设置属性VALIDSTATUS
     * @param validstatus 待设置的属性VALIDSTATUS的值
     */
    public void setValidstatus(String validstatus){
        this.validstatus = StringUtils.rightTrim(validstatus);
    }

    /**
     * 获取属性VALIDSTATUS
     * @return 属性VALIDSTATUS的值
     */
    public String getValidstatus(){
        return validstatus;
    }

    /**
     * 设置属性COMCODE
     * @param comcode 待设置的属性COMCODE的值
     */
    public void setComcode(String comcode){
        this.comcode = StringUtils.rightTrim(comcode);
    }

    /**
     * 获取属性COMCODE
     * @return 属性COMCODE的值
     */
    public String getComcode(){
        return comcode;
    }

    /**
     * 设置属性ISSUCCESS
     * @param issuccess 待设置的属性ISSUCCESS的值
     */
    public void setIssuccess(String issuccess){
        this.issuccess = StringUtils.rightTrim(issuccess);
    }

    /**
     * 获取属性ISSUCCESS
     * @return 属性ISSUCCESS的值
     */
    public String getIssuccess(){
        return issuccess;
    }

    /**
     * 设置属性REASONSELECT
     * @param reasonselect 待设置的属性REASONSELECT的值
     */
    public void setReasonselect(String reasonselect){
        this.reasonselect = StringUtils.rightTrim(reasonselect);
    }

    /**
     * 获取属性REASONSELECT
     * @return 属性REASONSELECT的值
     */
    public String getReasonselect(){
        return reasonselect;
    }

    /**
     * 设置属性REASONTEXT
     * @param reasontext 待设置的属性REASONTEXT的值
     */
    public void setReasontext(String reasontext){
        this.reasontext = StringUtils.rightTrim(reasontext);
    }

    /**
     * 获取属性REASONTEXT
     * @return 属性REASONTEXT的值
     */
    public String getReasontext(){
        return reasontext;
    }

    /**
     * 设置属性CUSTOMERNAME
     * @param customername 待设置的属性CUSTOMERNAME的值
     */
    public void setCustomername(String customername){
        this.customername = StringUtils.rightTrim(customername);
    }

    /**
     * 获取属性CUSTOMERNAME
     * @return 属性CUSTOMERNAME的值
     */
    public String getCustomername(){
        return customername;
    }

    /**
     * 设置属性CUSTOMERTEL
     * @param customertel 待设置的属性CUSTOMERTEL的值
     */
    public void setCustomertel(String customertel){
        this.customertel = StringUtils.rightTrim(customertel);
    }

    /**
     * 获取属性CUSTOMERTEL
     * @return 属性CUSTOMERTEL的值
     */
    public String getCustomertel(){
        return customertel;
    }

    /**
     * 设置属性ACCIDENT
     * @param accident 待设置的属性ACCIDENT的值
     */
    public void setAccident(String accident){
        this.accident = StringUtils.rightTrim(accident);
    }

    /**
     * 获取属性ACCIDENT
     * @return 属性ACCIDENT的值
     */
    public String getAccident(){
        return accident;
    }

    /**
     * 设置属性ACCIDENTSELECT
     * @param accidentselect 待设置的属性ACCIDENTSELECT的值
     */
    public void setAccidentselect(String accidentselect){
        this.accidentselect = StringUtils.rightTrim(accidentselect);
    }

    /**
     * 获取属性ACCIDENTSELECT
     * @return 属性ACCIDENTSELECT的值
     */
    public String getAccidentselect(){
        return accidentselect;
    }

    /**
     * 设置属性COMPENSATION
     * @param compensation 待设置的属性COMPENSATION的值
     */
    public void setCompensation(String compensation){
        this.compensation = StringUtils.rightTrim(compensation);
    }

    /**
     * 获取属性COMPENSATION
     * @return 属性COMPENSATION的值
     */
    public String getCompensation(){
        return compensation;
    }

    /**
     * 设置属性TRACK
     * @param track 待设置的属性TRACK的值
     */
    public void setTrack(String track){
        this.track = StringUtils.rightTrim(track);
    }

    /**
     * 获取属性TRACK
     * @return 属性TRACK的值
     */
    public String getTrack(){
        return track;
    }

    /**
     * 设置属性AUTOMATICCYCLE
     * @param automaticcycle 待设置的属性AUTOMATICCYCLE的值
     */
    public void setAutomaticcycle(String automaticcycle){
        this.automaticcycle = StringUtils.rightTrim(automaticcycle);
    }

    /**
     * 获取属性AUTOMATICCYCLE
     * @return 属性AUTOMATICCYCLE的值
     */
    public String getAutomaticcycle(){
        return automaticcycle;
    }

    /**
     * 设置属性NEXTPROMPT
     * @param nextprompt 待设置的属性NEXTPROMPT的值
     */
    public void setNextprompt(String nextprompt){
        this.nextprompt = StringUtils.rightTrim(nextprompt);
    }

    /**
     * 获取属性NEXTPROMPT
     * @return 属性NEXTPROMPT的值
     */
    public String getNextprompt(){
        return nextprompt;
    }

    /**
     * 设置属性OPERATORNAME
     * @param operatorname 待设置的属性OPERATORNAME的值
     */
    public void setOperatorname(String operatorname){
        this.operatorname = StringUtils.rightTrim(operatorname);
    }

    /**
     * 获取属性OPERATORNAME
     * @return 属性OPERATORNAME的值
     */
    public String getOperatorname(){
        return operatorname;
    }

    /**
     * 设置属性OPERATORCODE
     * @param operatorcode 待设置的属性OPERATORCODE的值
     */
    public void setOperatorcode(String operatorcode){
        this.operatorcode = StringUtils.rightTrim(operatorcode);
    }

    /**
     * 获取属性OPERATORCODE
     * @return 属性OPERATORCODE的值
     */
    public String getOperatorcode(){
        return operatorcode;
    }

    /**
     * 设置属性SUBMITTIME
     * @param submittime 待设置的属性SUBMITTIME的值
     */
    public void setSubmittime(String submittime){
        this.submittime = StringUtils.rightTrim(submittime);
    }

    /**
     * 获取属性SUBMITTIME
     * @return 属性SUBMITTIME的值
     */
    public String getSubmittime(){
        return submittime;
    }

    /**
     * 设置属性NEXTTIME
     * @param nexttime 待设置的属性NEXTTIME的值
     */
    public void setNexttime(String nexttime){
        this.nexttime = StringUtils.rightTrim(nexttime);
    }

    /**
     * 获取属性NEXTTIME
     * @return 属性NEXTTIME的值
     */
    public String getNexttime(){
        return nexttime;
    }

    /**
     * 设置属性FLOWINTIME
     * @param flowintime 待设置的属性FLOWINTIME的值
     */
    public void setFlowintime(String flowintime){
        this.flowintime = StringUtils.rightTrim(flowintime);
    }

    /**
     * 获取属性FLOWINTIME
     * @return 属性FLOWINTIME的值
     */
    public String getFlowintime(){
        return flowintime;
    }

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getNodeStatus() {
		return nodeStatus;
	}

	public void setNodeStatus(String nodeStatus) {
		this.nodeStatus = nodeStatus;
	}
}
