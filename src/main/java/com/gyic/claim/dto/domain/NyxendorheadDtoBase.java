package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXENDORHEAD�����ݴ���������<br>
 */
public class NyxendorheadDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����INUSRELISTCODE */
    private String inusrelistcode = "";
    /** ����ENDORSENO */
    private String endorseno = "";
    /** ����POLICYNO */
    private String policyno = "";
    /** ����RISKCODE */
    private String riskcode = "";
    /** ����LISTFLAG */
    private String listflag = "";
    /** ����ENDORFLAG */
    private String endorflag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�NyxendorheadDtoBase����
     */
    public NyxendorheadDtoBase(){
    }

    /**
     * ��������INUSRELISTCODE
     * @param inusrelistcode �����õ�����INUSRELISTCODE��ֵ
     */
    public void setInusrelistcode(String inusrelistcode){
        this.inusrelistcode = StringUtils.rightTrim(inusrelistcode);
    }

    /**
     * ��ȡ����INUSRELISTCODE
     * @return ����INUSRELISTCODE��ֵ
     */
    public String getInusrelistcode(){
        return inusrelistcode;
    }

    /**
     * ��������ENDORSENO
     * @param endorseno �����õ�����ENDORSENO��ֵ
     */
    public void setEndorseno(String endorseno){
        this.endorseno = StringUtils.rightTrim(endorseno);
    }

    /**
     * ��ȡ����ENDORSENO
     * @return ����ENDORSENO��ֵ
     */
    public String getEndorseno(){
        return endorseno;
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
     * ��������RISKCODE
     * @param riskcode �����õ�����RISKCODE��ֵ
     */
    public void setRiskcode(String riskcode){
        this.riskcode = StringUtils.rightTrim(riskcode);
    }

    /**
     * ��ȡ����RISKCODE
     * @return ����RISKCODE��ֵ
     */
    public String getRiskcode(){
        return riskcode;
    }

    /**
     * ��������LISTFLAG
     * @param listflag �����õ�����LISTFLAG��ֵ
     */
    public void setListflag(String listflag){
        this.listflag = StringUtils.rightTrim(listflag);
    }

    /**
     * ��ȡ����LISTFLAG
     * @return ����LISTFLAG��ֵ
     */
    public String getListflag(){
        return listflag;
    }

    /**
     * ��������ENDORFLAG
     * @param endorflag �����õ�����ENDORFLAG��ֵ
     */
    public void setEndorflag(String endorflag){
        this.endorflag = StringUtils.rightTrim(endorflag);
    }

    /**
     * ��ȡ����ENDORFLAG
     * @return ����ENDORFLAG��ֵ
     */
    public String getEndorflag(){
        return endorflag;
    }
}
