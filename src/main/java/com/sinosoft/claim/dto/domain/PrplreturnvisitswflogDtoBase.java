package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLRETURNVISITSWFLOG的数据传输对象基类<br>
 */
public class PrplreturnvisitswflogDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性BUSINESSNO */
    private String businessno = "";
    /** 属性NODETYPE */
    private String nodetype = "";
    /** 属性REGISTNO */
    private String registno = "";
    /** 属性POLICYNO */
    private String policyno = "";
    /** 属性COMCODE */
    private String comcode = "";
    /** 属性COMCODENAME */
    private String comcodename = "";
    /** 属性INSUREDNAME */
    private String insuredname = "";
    /** 属性REPORTDATE */
    private DateTime reportdate = new DateTime();
    /** 属性CEASEDATE */
    private DateTime ceasedate = new DateTime();
    /** 属性LICENSENO */
    private String licenseno = "";
    /** 属性HANDLERCODE */
    private String handlercode = "";
    /** 属性HANDLERNAME */
    private String handlername = "";
    /** 属性HANDLERCOMCODE */
    private String handlercomcode = "";
    /** 属性FLOWINTOTIME */
    private DateTime flowintotime = new DateTime();
    /** 属性CEASETIME */
    private DateTime ceasetime = new DateTime();
    /** 属性CLASSCODE */
    private String classcode = "";
    /** 属性STATE */
    private String state = "";
    /**险种*/
    private String riskCode = "";
    
    /**
     *  默认构造方法,构造一个默认的PrplreturnvisitswflogDtoBase对象
     */
    public PrplreturnvisitswflogDtoBase(){
    }

    /**
     * 设置属性BUSINESSNO
     * @param businessno 待设置的属性BUSINESSNO的值
     */
    public void setBusinessno(String businessno){
        this.businessno = StringUtils.rightTrim(businessno);
    }

    /**
     * 获取属性BUSINESSNO
     * @return 属性BUSINESSNO的值
     */
    public String getBusinessno(){
        return businessno;
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
     * 设置属性POLICYNO
     * @param policyno 待设置的属性POLICYNO的值
     */
    public void setPolicyno(String policyno){
        this.policyno = StringUtils.rightTrim(policyno);
    }

    /**
     * 获取属性POLICYNO
     * @return 属性POLICYNO的值
     */
    public String getPolicyno(){
        return policyno;
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
     * 设置属性COMCODENAME
     * @param comcodename 待设置的属性COMCODENAME的值
     */
    public void setComcodename(String comcodename){
        this.comcodename = StringUtils.rightTrim(comcodename);
    }

    /**
     * 获取属性COMCODENAME
     * @return 属性COMCODENAME的值
     */
    public String getComcodename(){
        return comcodename;
    }

    /**
     * 设置属性INSUREDNAME
     * @param insuredname 待设置的属性INSUREDNAME的值
     */
    public void setInsuredname(String insuredname){
        this.insuredname = StringUtils.rightTrim(insuredname);
    }

    /**
     * 获取属性INSUREDNAME
     * @return 属性INSUREDNAME的值
     */
    public String getInsuredname(){
        return insuredname;
    }

    /**
     * 设置属性REPORTDATE
     * @param ateportdereportdateportdateate 待设置的属性REPORTDATE的值
     */
    public void setReportdate(DateTime reportdate){
        this.reportdate = reportdate;
    }

    /**
     * 获取属性REPORTDATE
     * @return 属性REPORTDATE的值
     */
    public DateTime getReportdate(){
        return reportdate;
    }

    /**
     * 设置属性CEASEDATE
     * @param ceasedate 待设置的属性CEASEDATE的值
     */
    public void setCeasedate(DateTime ceasedate){
        this.ceasedate = ceasedate;
    }

    /**
     * 获取属性CEASEDATE
     * @return 属性CEASEDATE的值
     */
    public DateTime getCeasedate(){
        return ceasedate;
    }

    /**
     * 设置属性LICENSENO
     * @param licenseno 待设置的属性LICENSENO的值
     */
    public void setLicenseno(String licenseno){
        this.licenseno = StringUtils.rightTrim(licenseno);
    }

    /**
     * 获取属性LICENSENO
     * @return 属性LICENSENO的值
     */
    public String getLicenseno(){
        return licenseno;
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
     * 设置属性FLOWINTOTIME
     * @param flowintotime 待设置的属性FLOWINTOTIME的值
     */
    public void setFlowintotime(DateTime flowintotime){
        this.flowintotime = flowintotime;
    }

    /**
     * 获取属性FLOWINTOTIME
     * @return 属性FLOWINTOTIME的值
     */
    public DateTime getFlowintotime(){
        return flowintotime;
    }

    /**
     * 设置属性CEASETIME
     * @param ceasetime 待设置的属性CEASETIME的值
     */
    public void setCeasetime(DateTime ceasetime){
        this.ceasetime = ceasetime;
    }

    /**
     * 获取属性CEASETIME
     * @return 属性CEASETIME的值
     */
    public DateTime getCeasetime(){
        return ceasetime;
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

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
    
}
