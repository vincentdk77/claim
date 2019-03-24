package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����SETTLEMAINLIST�����ݴ���������<br>
 */
public class SettlemainlistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����SETTLELISTCODE */
    private String settlelistcode = "";
    /** ����FAREACODE */
    private String fareacode = "";
    /** ����INUSRELISTCODE */
    private String inusrelistcode = "";
    /** ����REPORTCODE */
    private String reportcode = "";
    /** ����REGISTERCODE */
    private String registercode = "";
    /** ����COMPENSATENO */
    private String compensateno = "";
    /** ����POLICYNO */
    private String policyno = "";
    /** ����CLASSCODE */
    private String classcode = "";
    /** ����RISKCODE */
    private String riskcode = "";
    /** ����VALIDITY */
    private String validity = "";
    /** ����REMARK */
    private String remark = "";
    /** ����UPDATECODE */
    private String updatecode = "";
    /** ����UPDATEDATE */
    private DateTime updatedate = new DateTime();
    /** ����OPCODE */
    private String opcode = "";
    /** ����DAMAGETIME */
    private DateTime damagetime = new DateTime();

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�SettlemainlistDtoBase����
     */
    public SettlemainlistDtoBase(){
    }

    /**
     * ��������SETTLELISTCODE
     * @param settlelistcode �����õ�����SETTLELISTCODE��ֵ
     */
    public void setSettlelistcode(String settlelistcode){
        this.settlelistcode = StringUtils.rightTrim(settlelistcode);
    }

    /**
     * ��ȡ����SETTLELISTCODE
     * @return ����SETTLELISTCODE��ֵ
     */
    public String getSettlelistcode(){
        return settlelistcode;
    }

    /**
     * ��������FAREACODE
     * @param fareacode �����õ�����FAREACODE��ֵ
     */
    public void setFareacode(String fareacode){
        this.fareacode = StringUtils.rightTrim(fareacode);
    }

    /**
     * ��ȡ����FAREACODE
     * @return ����FAREACODE��ֵ
     */
    public String getFareacode(){
        return fareacode;
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
     * ��������REPORTCODE
     * @param reportcode �����õ�����REPORTCODE��ֵ
     */
    public void setReportcode(String reportcode){
        this.reportcode = StringUtils.rightTrim(reportcode);
    }

    /**
     * ��ȡ����REPORTCODE
     * @return ����REPORTCODE��ֵ
     */
    public String getReportcode(){
        return reportcode;
    }

    /**
     * ��������REGISTERCODE
     * @param registercode �����õ�����REGISTERCODE��ֵ
     */
    public void setRegistercode(String registercode){
        this.registercode = StringUtils.rightTrim(registercode);
    }

    /**
     * ��ȡ����REGISTERCODE
     * @return ����REGISTERCODE��ֵ
     */
    public String getRegistercode(){
        return registercode;
    }

    /**
     * ��������COMPENSATENO
     * @param compensateno �����õ�����COMPENSATENO��ֵ
     */
    public void setCompensateno(String compensateno){
        this.compensateno = StringUtils.rightTrim(compensateno);
    }

    /**
     * ��ȡ����COMPENSATENO
     * @return ����COMPENSATENO��ֵ
     */
    public String getCompensateno(){
        return compensateno;
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
     * ��������VALIDITY
     * @param validity �����õ�����VALIDITY��ֵ
     */
    public void setValidity(String validity){
        this.validity = StringUtils.rightTrim(validity);
    }

    /**
     * ��ȡ����VALIDITY
     * @return ����VALIDITY��ֵ
     */
    public String getValidity(){
        return validity;
    }

    /**
     * ��������REMARK
     * @param remark �����õ�����REMARK��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ����REMARK
     * @return ����REMARK��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * ��������UPDATECODE
     * @param updatecode �����õ�����UPDATECODE��ֵ
     */
    public void setUpdatecode(String updatecode){
        this.updatecode = StringUtils.rightTrim(updatecode);
    }

    /**
     * ��ȡ����UPDATECODE
     * @return ����UPDATECODE��ֵ
     */
    public String getUpdatecode(){
        return updatecode;
    }

    /**
     * ��������UPDATEDATE
     * @param updatedate �����õ�����UPDATEDATE��ֵ
     */
    public void setUpdatedate(DateTime updatedate){
        this.updatedate = updatedate;
    }

    /**
     * ��ȡ����UPDATEDATE
     * @return ����UPDATEDATE��ֵ
     */
    public DateTime getUpdatedate(){
        return updatedate;
    }

    /**
     * ��������OPCODE
     * @param opcode �����õ�����OPCODE��ֵ
     */
    public void setOpcode(String opcode){
        this.opcode = StringUtils.rightTrim(opcode);
    }

    /**
     * ��ȡ����OPCODE
     * @return ����OPCODE��ֵ
     */
    public String getOpcode(){
        return opcode;
    }

    /**
     * ��������DAMAGETIME
     * @param damagetime �����õ�����DAMAGETIME��ֵ
     */
    public void setDamagetime(DateTime damagetime){
        this.damagetime = damagetime;
    }

    /**
     * ��ȡ����DAMAGETIME
     * @return ����DAMAGETIME��ֵ
     */
    public DateTime getDamagetime(){
        return damagetime;
    }
}
