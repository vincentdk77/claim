package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLPENDTRACK�����ݴ���������<br>
 */
public class PrplpendtrackDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ���� ������ */
    private String registno = "";
    /** ���� ��� */
    private String logno = "";
    /** ���� ��Ӧ�����������鿱�����˲鿱����֤) */
    private String nodetype = "";
    /** ���� ���ٷ�ʽ��0-�Զ�/1-�ֶ��� */
    private String tracktype = "";
    /** ���� �Ƿ���(0-δ����1-�Ѵ��� */
    private String validstatus = "";
    /** ���� �б����� */
    private String comcode = "";
    /** ����ISSUCCESS �Ƿ���ٳɹ���0-���ɹ���1-�ɹ���*/
    private String issuccess = "";
    /** ����REASONSELECT ���ɹ�ԭ��(prpdcode����)*/
    private String reasonselect = "";
    /** ����REASONTEXT �ֶ���д��ԭ��*/
    private String reasontext = "";
    /** ����CUSTOMERNAME �ͻ�����*/
    private String customername = "";
    /** ����CUSTOMERNO �ͻ����*/
    private String customerNo = "";
    /** ����CUSTOMERTEL �ͻ��绰*/
    private String customertel = "";
    /** ����ACCIDENT �¹��������*/
    private String accident = "";
    /** ����ACCIDENTSELECT �¹��������������*/
    private String accidentselect = "";
    /** ����COMPENSATION ���⳥���*/
    private String compensation = "";
    /** ����TRACK ����˵��*/
    private String track = "";
    /** ����AUTOMATICCYCLE �Զ���������*/
    private String automaticcycle = "";
    /** ����NEXTPROMPT �´θ�����ʾ*/
    private String nextprompt = "";
    /** ����OPERATORNAME �ط���Ա*/
    private String operatorname = "";
    /** ����OPERATORCODE �ط���Ա����*/
    private String operatorcode = "";
    /** ����SUBMITTIME ���ʱ��*/
    private String submittime = "";
    /** ����NEXTTIME ��Чʱ��*/
    private String nexttime = "";
    /** ����FLOWINTIME ���ʱ��*/
    private String flowintime = "";
    /** ����nodeStatus �ڵ��ʶ*/
    private String nodeStatus = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplpendtrackDtoBase����
     */
    public PrplpendtrackDtoBase(){
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
     * ��������LOGNO
     * @param logno �����õ�����LOGNO��ֵ
     */
    public void setLogno(String logno){
        this.logno = StringUtils.rightTrim(logno);
    }

    /**
     * ��ȡ����LOGNO
     * @return ����LOGNO��ֵ
     */
    public String getLogno(){
        return logno;
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
     * ��������TRACKTYPE
     * @param tracktype �����õ�����TRACKTYPE��ֵ
     */
    public void setTracktype(String tracktype){
        this.tracktype = StringUtils.rightTrim(tracktype);
    }

    /**
     * ��ȡ����TRACKTYPE
     * @return ����TRACKTYPE��ֵ
     */
    public String getTracktype(){
        return tracktype;
    }

    /**
     * ��������VALIDSTATUS
     * @param validstatus �����õ�����VALIDSTATUS��ֵ
     */
    public void setValidstatus(String validstatus){
        this.validstatus = StringUtils.rightTrim(validstatus);
    }

    /**
     * ��ȡ����VALIDSTATUS
     * @return ����VALIDSTATUS��ֵ
     */
    public String getValidstatus(){
        return validstatus;
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
     * ��������ISSUCCESS
     * @param issuccess �����õ�����ISSUCCESS��ֵ
     */
    public void setIssuccess(String issuccess){
        this.issuccess = StringUtils.rightTrim(issuccess);
    }

    /**
     * ��ȡ����ISSUCCESS
     * @return ����ISSUCCESS��ֵ
     */
    public String getIssuccess(){
        return issuccess;
    }

    /**
     * ��������REASONSELECT
     * @param reasonselect �����õ�����REASONSELECT��ֵ
     */
    public void setReasonselect(String reasonselect){
        this.reasonselect = StringUtils.rightTrim(reasonselect);
    }

    /**
     * ��ȡ����REASONSELECT
     * @return ����REASONSELECT��ֵ
     */
    public String getReasonselect(){
        return reasonselect;
    }

    /**
     * ��������REASONTEXT
     * @param reasontext �����õ�����REASONTEXT��ֵ
     */
    public void setReasontext(String reasontext){
        this.reasontext = StringUtils.rightTrim(reasontext);
    }

    /**
     * ��ȡ����REASONTEXT
     * @return ����REASONTEXT��ֵ
     */
    public String getReasontext(){
        return reasontext;
    }

    /**
     * ��������CUSTOMERNAME
     * @param customername �����õ�����CUSTOMERNAME��ֵ
     */
    public void setCustomername(String customername){
        this.customername = StringUtils.rightTrim(customername);
    }

    /**
     * ��ȡ����CUSTOMERNAME
     * @return ����CUSTOMERNAME��ֵ
     */
    public String getCustomername(){
        return customername;
    }

    /**
     * ��������CUSTOMERTEL
     * @param customertel �����õ�����CUSTOMERTEL��ֵ
     */
    public void setCustomertel(String customertel){
        this.customertel = StringUtils.rightTrim(customertel);
    }

    /**
     * ��ȡ����CUSTOMERTEL
     * @return ����CUSTOMERTEL��ֵ
     */
    public String getCustomertel(){
        return customertel;
    }

    /**
     * ��������ACCIDENT
     * @param accident �����õ�����ACCIDENT��ֵ
     */
    public void setAccident(String accident){
        this.accident = StringUtils.rightTrim(accident);
    }

    /**
     * ��ȡ����ACCIDENT
     * @return ����ACCIDENT��ֵ
     */
    public String getAccident(){
        return accident;
    }

    /**
     * ��������ACCIDENTSELECT
     * @param accidentselect �����õ�����ACCIDENTSELECT��ֵ
     */
    public void setAccidentselect(String accidentselect){
        this.accidentselect = StringUtils.rightTrim(accidentselect);
    }

    /**
     * ��ȡ����ACCIDENTSELECT
     * @return ����ACCIDENTSELECT��ֵ
     */
    public String getAccidentselect(){
        return accidentselect;
    }

    /**
     * ��������COMPENSATION
     * @param compensation �����õ�����COMPENSATION��ֵ
     */
    public void setCompensation(String compensation){
        this.compensation = StringUtils.rightTrim(compensation);
    }

    /**
     * ��ȡ����COMPENSATION
     * @return ����COMPENSATION��ֵ
     */
    public String getCompensation(){
        return compensation;
    }

    /**
     * ��������TRACK
     * @param track �����õ�����TRACK��ֵ
     */
    public void setTrack(String track){
        this.track = StringUtils.rightTrim(track);
    }

    /**
     * ��ȡ����TRACK
     * @return ����TRACK��ֵ
     */
    public String getTrack(){
        return track;
    }

    /**
     * ��������AUTOMATICCYCLE
     * @param automaticcycle �����õ�����AUTOMATICCYCLE��ֵ
     */
    public void setAutomaticcycle(String automaticcycle){
        this.automaticcycle = StringUtils.rightTrim(automaticcycle);
    }

    /**
     * ��ȡ����AUTOMATICCYCLE
     * @return ����AUTOMATICCYCLE��ֵ
     */
    public String getAutomaticcycle(){
        return automaticcycle;
    }

    /**
     * ��������NEXTPROMPT
     * @param nextprompt �����õ�����NEXTPROMPT��ֵ
     */
    public void setNextprompt(String nextprompt){
        this.nextprompt = StringUtils.rightTrim(nextprompt);
    }

    /**
     * ��ȡ����NEXTPROMPT
     * @return ����NEXTPROMPT��ֵ
     */
    public String getNextprompt(){
        return nextprompt;
    }

    /**
     * ��������OPERATORNAME
     * @param operatorname �����õ�����OPERATORNAME��ֵ
     */
    public void setOperatorname(String operatorname){
        this.operatorname = StringUtils.rightTrim(operatorname);
    }

    /**
     * ��ȡ����OPERATORNAME
     * @return ����OPERATORNAME��ֵ
     */
    public String getOperatorname(){
        return operatorname;
    }

    /**
     * ��������OPERATORCODE
     * @param operatorcode �����õ�����OPERATORCODE��ֵ
     */
    public void setOperatorcode(String operatorcode){
        this.operatorcode = StringUtils.rightTrim(operatorcode);
    }

    /**
     * ��ȡ����OPERATORCODE
     * @return ����OPERATORCODE��ֵ
     */
    public String getOperatorcode(){
        return operatorcode;
    }

    /**
     * ��������SUBMITTIME
     * @param submittime �����õ�����SUBMITTIME��ֵ
     */
    public void setSubmittime(String submittime){
        this.submittime = StringUtils.rightTrim(submittime);
    }

    /**
     * ��ȡ����SUBMITTIME
     * @return ����SUBMITTIME��ֵ
     */
    public String getSubmittime(){
        return submittime;
    }

    /**
     * ��������NEXTTIME
     * @param nexttime �����õ�����NEXTTIME��ֵ
     */
    public void setNexttime(String nexttime){
        this.nexttime = StringUtils.rightTrim(nexttime);
    }

    /**
     * ��ȡ����NEXTTIME
     * @return ����NEXTTIME��ֵ
     */
    public String getNexttime(){
        return nexttime;
    }

    /**
     * ��������FLOWINTIME
     * @param flowintime �����õ�����FLOWINTIME��ֵ
     */
    public void setFlowintime(String flowintime){
        this.flowintime = StringUtils.rightTrim(flowintime);
    }

    /**
     * ��ȡ����FLOWINTIME
     * @return ����FLOWINTIME��ֵ
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
