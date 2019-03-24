package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是NYXENDORHEAD的数据传输对象基类<br>
 */
public class NyxendorheadDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性INUSRELISTCODE */
    private String inusrelistcode = "";
    /** 属性ENDORSENO */
    private String endorseno = "";
    /** 属性POLICYNO */
    private String policyno = "";
    /** 属性RISKCODE */
    private String riskcode = "";
    /** 属性LISTFLAG */
    private String listflag = "";
    /** 属性ENDORFLAG */
    private String endorflag = "";

    /**
     *  默认构造方法,构造一个默认的NyxendorheadDtoBase对象
     */
    public NyxendorheadDtoBase(){
    }

    /**
     * 设置属性INUSRELISTCODE
     * @param inusrelistcode 待设置的属性INUSRELISTCODE的值
     */
    public void setInusrelistcode(String inusrelistcode){
        this.inusrelistcode = StringUtils.rightTrim(inusrelistcode);
    }

    /**
     * 获取属性INUSRELISTCODE
     * @return 属性INUSRELISTCODE的值
     */
    public String getInusrelistcode(){
        return inusrelistcode;
    }

    /**
     * 设置属性ENDORSENO
     * @param endorseno 待设置的属性ENDORSENO的值
     */
    public void setEndorseno(String endorseno){
        this.endorseno = StringUtils.rightTrim(endorseno);
    }

    /**
     * 获取属性ENDORSENO
     * @return 属性ENDORSENO的值
     */
    public String getEndorseno(){
        return endorseno;
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
     * 设置属性RISKCODE
     * @param riskcode 待设置的属性RISKCODE的值
     */
    public void setRiskcode(String riskcode){
        this.riskcode = StringUtils.rightTrim(riskcode);
    }

    /**
     * 获取属性RISKCODE
     * @return 属性RISKCODE的值
     */
    public String getRiskcode(){
        return riskcode;
    }

    /**
     * 设置属性LISTFLAG
     * @param listflag 待设置的属性LISTFLAG的值
     */
    public void setListflag(String listflag){
        this.listflag = StringUtils.rightTrim(listflag);
    }

    /**
     * 获取属性LISTFLAG
     * @return 属性LISTFLAG的值
     */
    public String getListflag(){
        return listflag;
    }

    /**
     * 设置属性ENDORFLAG
     * @param endorflag 待设置的属性ENDORFLAG的值
     */
    public void setEndorflag(String endorflag){
        this.endorflag = StringUtils.rightTrim(endorflag);
    }

    /**
     * 获取属性ENDORFLAG
     * @return 属性ENDORFLAG的值
     */
    public String getEndorflag(){
        return endorflag;
    }
}
