package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLRETURNVISIT的数据传输对象基类<br>
 */
public class PrplreturnvisitDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性REGISTNO */
    private String businessNo = "";
    /** 属性NODETYPE */
    private String nodetype = "";
    /** 属性SERIALNO */
    private String serialno = "";
    /** 属性VISITNAME */
    private String visitname = "";
    /** 属性CONTACT */
    private String contact = "";
    /** 属性RECORDERNO */
    private String recorderno = "";
    /** 属性SERVICE */
    private String service = "";
    /** 属性EXISTISSUE */
    private String existissue = "";
    /** 属性VISITSUCCESS */
    private String visitsuccess = "";
    /** 属性VISITNOCAUSE */
    private String visitnocause = "";
    /** 属性VISITOPINION */
    private String visitopinion = "";
    /** 属性ENTERINGCODE */
    private String enteringcode = "";
    /** 属性ENTERINGNAME */
    private String enteringname = "";
    /** 属性ENTERINGCOMCODE */
    private String enteringcomcode = "";
    /** 属性ENTERINGTIME */
    private DateTime enteringtime = new DateTime();
    /** 属性CLASSCODE */
    private String classcode = "";
    /** 属性VISITFAIL */
    private String visitfail = "";

    public String getBusinessNo() {
		return businessNo;
	}



	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}



	/**
     *  默认构造方法,构造一个默认的PrplreturnvisitDtoBase对象
     */
    public PrplreturnvisitDtoBase(){
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
     * 设置属性SERIALNO
     * @param serialno 待设置的属性SERIALNO的值
     */
    public void setSerialno(String serialno){
        this.serialno = StringUtils.rightTrim(serialno);
    }

    /**
     * 获取属性SERIALNO
     * @return 属性SERIALNO的值
     */
    public String getSerialno(){
        return serialno;
    }

    /**
     * 设置属性VISITNAME
     * @param visitname 待设置的属性VISITNAME的值
     */
    public void setVisitname(String visitname){
        this.visitname = StringUtils.rightTrim(visitname);
    }

    /**
     * 获取属性VISITNAME
     * @return 属性VISITNAME的值
     */
    public String getVisitname(){
        return visitname;
    }

    /**
     * 设置属性CONTACT
     * @param contact 待设置的属性CONTACT的值
     */
    public void setContact(String contact){
        this.contact = StringUtils.rightTrim(contact);
    }

    /**
     * 获取属性CONTACT
     * @return 属性CONTACT的值
     */
    public String getContact(){
        return contact;
    }

    /**
     * 设置属性RECORDERNO
     * @param recorderno 待设置的属性RECORDERNO的值
     */
    public void setRecorderno(String recorderno){
        this.recorderno = StringUtils.rightTrim(recorderno);
    }

    /**
     * 获取属性RECORDERNO
     * @return 属性RECORDERNO的值
     */
    public String getRecorderno(){
        return recorderno;
    }

    /**
     * 设置属性SERVICE
     * @param service 待设置的属性SERVICE的值
     */
    public void setService(String service){
        this.service = StringUtils.rightTrim(service);
    }

    /**
     * 获取属性SERVICE
     * @return 属性SERVICE的值
     */
    public String getService(){
        return service;
    }

    /**
     * 设置属性EXISTISSUE
     * @param existissue 待设置的属性EXISTISSUE的值
     */
    public void setExistissue(String existissue){
        this.existissue = StringUtils.rightTrim(existissue);
    }

    /**
     * 获取属性EXISTISSUE
     * @return 属性EXISTISSUE的值
     */
    public String getExistissue(){
        return existissue;
    }

    /**
     * 设置属性VISITSUCCESS
     * @param visitsuccess 待设置的属性VISITSUCCESS的值
     */
    public void setVisitsuccess(String visitsuccess){
        this.visitsuccess = StringUtils.rightTrim(visitsuccess);
    }

    /**
     * 获取属性VISITSUCCESS
     * @return 属性VISITSUCCESS的值
     */
    public String getVisitsuccess(){
        return visitsuccess;
    }

    /**
     * 设置属性VISITNOCAUSE
     * @param visitnocause 待设置的属性VISITNOCAUSE的值
     */
    public void setVisitnocause(String visitnocause){
        this.visitnocause = StringUtils.rightTrim(visitnocause);
    }

    /**
     * 获取属性VISITNOCAUSE
     * @return 属性VISITNOCAUSE的值
     */
    public String getVisitnocause(){
        return visitnocause;
    }

    /**
     * 设置属性VISITOPINION
     * @param visitopinion 待设置的属性VISITOPINION的值
     */
    public void setVisitopinion(String visitopinion){
        this.visitopinion = StringUtils.rightTrim(visitopinion);
    }

    /**
     * 获取属性VISITOPINION
     * @return 属性VISITOPINION的值
     */
    public String getVisitopinion(){
        return visitopinion;
    }

    /**
     * 设置属性ENTERINGCODE
     * @param enteringcode 待设置的属性ENTERINGCODE的值
     */
    public void setEnteringcode(String enteringcode){
        this.enteringcode = StringUtils.rightTrim(enteringcode);
    }

    /**
     * 获取属性ENTERINGCODE
     * @return 属性ENTERINGCODE的值
     */
    public String getEnteringcode(){
        return enteringcode;
    }

    /**
     * 设置属性ENTERINGNAME
     * @param enteringname 待设置的属性ENTERINGNAME的值
     */
    public void setEnteringname(String enteringname){
        this.enteringname = StringUtils.rightTrim(enteringname);
    }

    /**
     * 获取属性ENTERINGNAME
     * @return 属性ENTERINGNAME的值
     */
    public String getEnteringname(){
        return enteringname;
    }

    /**
     * 设置属性ENTERINGCOMCODE
     * @param enteringcomcode 待设置的属性ENTERINGCOMCODE的值
     */
    public void setEnteringcomcode(String enteringcomcode){
        this.enteringcomcode = StringUtils.rightTrim(enteringcomcode);
    }

    /**
     * 获取属性ENTERINGCOMCODE
     * @return 属性ENTERINGCOMCODE的值
     */
    public String getEnteringcomcode(){
        return enteringcomcode;
    }

    /**
     * 设置属性ENTERINGTIME
     * @param enteringtime 待设置的属性ENTERINGTIME的值
     */
    public void setEnteringtime(DateTime enteringtime){
        this.enteringtime = enteringtime;
    }

    /**
     * 获取属性ENTERINGTIME
     * @return 属性ENTERINGTIME的值
     */
    public DateTime getEnteringtime(){
        return enteringtime;
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
     * 获取属性Visitfail
     * @return 属性Visitfail的值
     */
	public String getVisitfail() {
		return visitfail;
	}


	/**
     * 设置属性Visitfail
     * @param Visitfail 待设置的属性Visitfail的值
     */
	public void setVisitfail(String visitfail) {
		this.visitfail = StringUtils.rightTrim(visitfail);
	
	}
	
	
    
    
}
