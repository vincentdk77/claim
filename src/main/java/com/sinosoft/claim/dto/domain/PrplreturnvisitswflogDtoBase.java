package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLRETURNVISITSWFLOG�����ݴ���������<br>
 */
public class PrplreturnvisitswflogDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����BUSINESSNO */
    private String businessno = "";
    /** ����NODETYPE */
    private String nodetype = "";
    /** ����REGISTNO */
    private String registno = "";
    /** ����POLICYNO */
    private String policyno = "";
    /** ����COMCODE */
    private String comcode = "";
    /** ����COMCODENAME */
    private String comcodename = "";
    /** ����INSUREDNAME */
    private String insuredname = "";
    /** ����REPORTDATE */
    private DateTime reportdate = new DateTime();
    /** ����CEASEDATE */
    private DateTime ceasedate = new DateTime();
    /** ����LICENSENO */
    private String licenseno = "";
    /** ����HANDLERCODE */
    private String handlercode = "";
    /** ����HANDLERNAME */
    private String handlername = "";
    /** ����HANDLERCOMCODE */
    private String handlercomcode = "";
    /** ����FLOWINTOTIME */
    private DateTime flowintotime = new DateTime();
    /** ����CEASETIME */
    private DateTime ceasetime = new DateTime();
    /** ����CLASSCODE */
    private String classcode = "";
    /** ����STATE */
    private String state = "";
    /**����*/
    private String riskCode = "";
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplreturnvisitswflogDtoBase����
     */
    public PrplreturnvisitswflogDtoBase(){
    }

    /**
     * ��������BUSINESSNO
     * @param businessno �����õ�����BUSINESSNO��ֵ
     */
    public void setBusinessno(String businessno){
        this.businessno = StringUtils.rightTrim(businessno);
    }

    /**
     * ��ȡ����BUSINESSNO
     * @return ����BUSINESSNO��ֵ
     */
    public String getBusinessno(){
        return businessno;
    }

    /**
     * ��������NODETYPE
     * @param nodetype �����õ�����NODETYPE��ֵ
     */
    public void setNodetype(String nodetype){
        this.nodetype = StringUtils.rightTrim(nodetype);
    }

    /**
     * ��ȡ����NODETYPE
     * @return ����NODETYPE��ֵ
     */
    public String getNodetype(){
        return nodetype;
    }

    /**
     * ��������REGISTNO
     * @param registno �����õ�����REGISTNO��ֵ
     */
    public void setRegistno(String registno){
        this.registno = StringUtils.rightTrim(registno);
    }

    /**
     * ��ȡ����REGISTNO
     * @return ����REGISTNO��ֵ
     */
    public String getRegistno(){
        return registno;
    }

    /**
     * ��������POLICYNO
     * @param policyno �����õ�����POLICYNO��ֵ
     */
    public void setPolicyno(String policyno){
        this.policyno = StringUtils.rightTrim(policyno);
    }

    /**
     * ��ȡ����POLICYNO
     * @return ����POLICYNO��ֵ
     */
    public String getPolicyno(){
        return policyno;
    }

    /**
     * ��������COMCODE
     * @param comcode �����õ�����COMCODE��ֵ
     */
    public void setComcode(String comcode){
        this.comcode = StringUtils.rightTrim(comcode);
    }

    /**
     * ��ȡ����COMCODE
     * @return ����COMCODE��ֵ
     */
    public String getComcode(){
        return comcode;
    }

    /**
     * ��������COMCODENAME
     * @param comcodename �����õ�����COMCODENAME��ֵ
     */
    public void setComcodename(String comcodename){
        this.comcodename = StringUtils.rightTrim(comcodename);
    }

    /**
     * ��ȡ����COMCODENAME
     * @return ����COMCODENAME��ֵ
     */
    public String getComcodename(){
        return comcodename;
    }

    /**
     * ��������INSUREDNAME
     * @param insuredname �����õ�����INSUREDNAME��ֵ
     */
    public void setInsuredname(String insuredname){
        this.insuredname = StringUtils.rightTrim(insuredname);
    }

    /**
     * ��ȡ����INSUREDNAME
     * @return ����INSUREDNAME��ֵ
     */
    public String getInsuredname(){
        return insuredname;
    }

    /**
     * ��������REPORTDATE
     * @param ateportdereportdateportdateate �����õ�����REPORTDATE��ֵ
     */
    public void setReportdate(DateTime reportdate){
        this.reportdate = reportdate;
    }

    /**
     * ��ȡ����REPORTDATE
     * @return ����REPORTDATE��ֵ
     */
    public DateTime getReportdate(){
        return reportdate;
    }

    /**
     * ��������CEASEDATE
     * @param ceasedate �����õ�����CEASEDATE��ֵ
     */
    public void setCeasedate(DateTime ceasedate){
        this.ceasedate = ceasedate;
    }

    /**
     * ��ȡ����CEASEDATE
     * @return ����CEASEDATE��ֵ
     */
    public DateTime getCeasedate(){
        return ceasedate;
    }

    /**
     * ��������LICENSENO
     * @param licenseno �����õ�����LICENSENO��ֵ
     */
    public void setLicenseno(String licenseno){
        this.licenseno = StringUtils.rightTrim(licenseno);
    }

    /**
     * ��ȡ����LICENSENO
     * @return ����LICENSENO��ֵ
     */
    public String getLicenseno(){
        return licenseno;
    }

    /**
     * ��������HANDLERCODE
     * @param handlercode �����õ�����HANDLERCODE��ֵ
     */
    public void setHandlercode(String handlercode){
        this.handlercode = StringUtils.rightTrim(handlercode);
    }

    /**
     * ��ȡ����HANDLERCODE
     * @return ����HANDLERCODE��ֵ
     */
    public String getHandlercode(){
        return handlercode;
    }

    /**
     * ��������HANDLERNAME
     * @param handlername �����õ�����HANDLERNAME��ֵ
     */
    public void setHandlername(String handlername){
        this.handlername = StringUtils.rightTrim(handlername);
    }

    /**
     * ��ȡ����HANDLERNAME
     * @return ����HANDLERNAME��ֵ
     */
    public String getHandlername(){
        return handlername;
    }

    /**
     * ��������HANDLERCOMCODE
     * @param handlercomcode �����õ�����HANDLERCOMCODE��ֵ
     */
    public void setHandlercomcode(String handlercomcode){
        this.handlercomcode = StringUtils.rightTrim(handlercomcode);
    }

    /**
     * ��ȡ����HANDLERCOMCODE
     * @return ����HANDLERCOMCODE��ֵ
     */
    public String getHandlercomcode(){
        return handlercomcode;
    }

    /**
     * ��������FLOWINTOTIME
     * @param flowintotime �����õ�����FLOWINTOTIME��ֵ
     */
    public void setFlowintotime(DateTime flowintotime){
        this.flowintotime = flowintotime;
    }

    /**
     * ��ȡ����FLOWINTOTIME
     * @return ����FLOWINTOTIME��ֵ
     */
    public DateTime getFlowintotime(){
        return flowintotime;
    }

    /**
     * ��������CEASETIME
     * @param ceasetime �����õ�����CEASETIME��ֵ
     */
    public void setCeasetime(DateTime ceasetime){
        this.ceasetime = ceasetime;
    }

    /**
     * ��ȡ����CEASETIME
     * @return ����CEASETIME��ֵ
     */
    public DateTime getCeasetime(){
        return ceasetime;
    }

    /**
     * ��������CLASSCODE
     * @param classcode �����õ�����CLASSCODE��ֵ
     */
    public void setClasscode(String classcode){
        this.classcode = StringUtils.rightTrim(classcode);
    }

    /**
     * ��ȡ����CLASSCODE
     * @return ����CLASSCODE��ֵ
     */
    public String getClasscode(){
        return classcode;
    }

    /**
     * ��������STATE
     * @param state �����õ�����STATE��ֵ
     */
    public void setState(String state){
        this.state = StringUtils.rightTrim(state);
    }

    /**
     * ��ȡ����STATE
     * @return ����STATE��ֵ
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
