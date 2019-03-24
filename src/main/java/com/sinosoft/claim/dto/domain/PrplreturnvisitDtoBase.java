package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLRETURNVISIT�����ݴ���������<br>
 */
public class PrplreturnvisitDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����REGISTNO */
    private String businessNo = "";
    /** ����NODETYPE */
    private String nodetype = "";
    /** ����SERIALNO */
    private String serialno = "";
    /** ����VISITNAME */
    private String visitname = "";
    /** ����CONTACT */
    private String contact = "";
    /** ����RECORDERNO */
    private String recorderno = "";
    /** ����SERVICE */
    private String service = "";
    /** ����EXISTISSUE */
    private String existissue = "";
    /** ����VISITSUCCESS */
    private String visitsuccess = "";
    /** ����VISITNOCAUSE */
    private String visitnocause = "";
    /** ����VISITOPINION */
    private String visitopinion = "";
    /** ����ENTERINGCODE */
    private String enteringcode = "";
    /** ����ENTERINGNAME */
    private String enteringname = "";
    /** ����ENTERINGCOMCODE */
    private String enteringcomcode = "";
    /** ����ENTERINGTIME */
    private DateTime enteringtime = new DateTime();
    /** ����CLASSCODE */
    private String classcode = "";
    /** ����VISITFAIL */
    private String visitfail = "";

    public String getBusinessNo() {
		return businessNo;
	}



	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}



	/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplreturnvisitDtoBase����
     */
    public PrplreturnvisitDtoBase(){
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
     * ��������SERIALNO
     * @param serialno �����õ�����SERIALNO��ֵ
     */
    public void setSerialno(String serialno){
        this.serialno = StringUtils.rightTrim(serialno);
    }

    /**
     * ��ȡ����SERIALNO
     * @return ����SERIALNO��ֵ
     */
    public String getSerialno(){
        return serialno;
    }

    /**
     * ��������VISITNAME
     * @param visitname �����õ�����VISITNAME��ֵ
     */
    public void setVisitname(String visitname){
        this.visitname = StringUtils.rightTrim(visitname);
    }

    /**
     * ��ȡ����VISITNAME
     * @return ����VISITNAME��ֵ
     */
    public String getVisitname(){
        return visitname;
    }

    /**
     * ��������CONTACT
     * @param contact �����õ�����CONTACT��ֵ
     */
    public void setContact(String contact){
        this.contact = StringUtils.rightTrim(contact);
    }

    /**
     * ��ȡ����CONTACT
     * @return ����CONTACT��ֵ
     */
    public String getContact(){
        return contact;
    }

    /**
     * ��������RECORDERNO
     * @param recorderno �����õ�����RECORDERNO��ֵ
     */
    public void setRecorderno(String recorderno){
        this.recorderno = StringUtils.rightTrim(recorderno);
    }

    /**
     * ��ȡ����RECORDERNO
     * @return ����RECORDERNO��ֵ
     */
    public String getRecorderno(){
        return recorderno;
    }

    /**
     * ��������SERVICE
     * @param service �����õ�����SERVICE��ֵ
     */
    public void setService(String service){
        this.service = StringUtils.rightTrim(service);
    }

    /**
     * ��ȡ����SERVICE
     * @return ����SERVICE��ֵ
     */
    public String getService(){
        return service;
    }

    /**
     * ��������EXISTISSUE
     * @param existissue �����õ�����EXISTISSUE��ֵ
     */
    public void setExistissue(String existissue){
        this.existissue = StringUtils.rightTrim(existissue);
    }

    /**
     * ��ȡ����EXISTISSUE
     * @return ����EXISTISSUE��ֵ
     */
    public String getExistissue(){
        return existissue;
    }

    /**
     * ��������VISITSUCCESS
     * @param visitsuccess �����õ�����VISITSUCCESS��ֵ
     */
    public void setVisitsuccess(String visitsuccess){
        this.visitsuccess = StringUtils.rightTrim(visitsuccess);
    }

    /**
     * ��ȡ����VISITSUCCESS
     * @return ����VISITSUCCESS��ֵ
     */
    public String getVisitsuccess(){
        return visitsuccess;
    }

    /**
     * ��������VISITNOCAUSE
     * @param visitnocause �����õ�����VISITNOCAUSE��ֵ
     */
    public void setVisitnocause(String visitnocause){
        this.visitnocause = StringUtils.rightTrim(visitnocause);
    }

    /**
     * ��ȡ����VISITNOCAUSE
     * @return ����VISITNOCAUSE��ֵ
     */
    public String getVisitnocause(){
        return visitnocause;
    }

    /**
     * ��������VISITOPINION
     * @param visitopinion �����õ�����VISITOPINION��ֵ
     */
    public void setVisitopinion(String visitopinion){
        this.visitopinion = StringUtils.rightTrim(visitopinion);
    }

    /**
     * ��ȡ����VISITOPINION
     * @return ����VISITOPINION��ֵ
     */
    public String getVisitopinion(){
        return visitopinion;
    }

    /**
     * ��������ENTERINGCODE
     * @param enteringcode �����õ�����ENTERINGCODE��ֵ
     */
    public void setEnteringcode(String enteringcode){
        this.enteringcode = StringUtils.rightTrim(enteringcode);
    }

    /**
     * ��ȡ����ENTERINGCODE
     * @return ����ENTERINGCODE��ֵ
     */
    public String getEnteringcode(){
        return enteringcode;
    }

    /**
     * ��������ENTERINGNAME
     * @param enteringname �����õ�����ENTERINGNAME��ֵ
     */
    public void setEnteringname(String enteringname){
        this.enteringname = StringUtils.rightTrim(enteringname);
    }

    /**
     * ��ȡ����ENTERINGNAME
     * @return ����ENTERINGNAME��ֵ
     */
    public String getEnteringname(){
        return enteringname;
    }

    /**
     * ��������ENTERINGCOMCODE
     * @param enteringcomcode �����õ�����ENTERINGCOMCODE��ֵ
     */
    public void setEnteringcomcode(String enteringcomcode){
        this.enteringcomcode = StringUtils.rightTrim(enteringcomcode);
    }

    /**
     * ��ȡ����ENTERINGCOMCODE
     * @return ����ENTERINGCOMCODE��ֵ
     */
    public String getEnteringcomcode(){
        return enteringcomcode;
    }

    /**
     * ��������ENTERINGTIME
     * @param enteringtime �����õ�����ENTERINGTIME��ֵ
     */
    public void setEnteringtime(DateTime enteringtime){
        this.enteringtime = enteringtime;
    }

    /**
     * ��ȡ����ENTERINGTIME
     * @return ����ENTERINGTIME��ֵ
     */
    public DateTime getEnteringtime(){
        return enteringtime;
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
     * ��ȡ����Visitfail
     * @return ����Visitfail��ֵ
     */
	public String getVisitfail() {
		return visitfail;
	}


	/**
     * ��������Visitfail
     * @param Visitfail �����õ�����Visitfail��ֵ
     */
	public void setVisitfail(String visitfail) {
		this.visitfail = StringUtils.rightTrim(visitfail);
	
	}
	
	
    
    
}
