package com.sinosoft.NXCaseUp.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CASEMAININFO�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CasemaininfoDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����COMCODE */
    private String comcode = "";
    /** ����POLICYNO */
    private String policyno = "";
    /** ����CASENO */
    private String caseno = "";
    /** ����CLAIMNO */
    private String claimno = "";
    /** ����UNDERWRITEENDDATE */
    private DateTime underwriteenddate = new DateTime();
    /** ����ENDCASEDATE */
    private DateTime endcasedate = new DateTime();
    /** ����ASUMPAID */
    private double asumpaid = 0D;
    /** ����ASUMFEE */
    private double asumfee = 0D;
    /** ����CASEMONEY */
    private double casemoney = 0D;
    /** ����CASEMONEYFEE */
    private double casemoneyfee = 0D;
    /** ����PRESUMPAID */
    private double presumpaid = 0D;
    /** ����PRESUMFEE */
    private double presumfee = 0D;
    /** ����DAMAGEINSURED */
    private long damageinsured = 0L;
    /** ����LOSSESNUMBER */
    private double lossesnumber = 0D;
    /** ����LOSSESUNITCODE */
    private String lossesunitcode = "";
    /** ����REOPENEDTYPE */
    private String reopenedtype = "";
    /** ����TIMES */
    private int times = 0;
    /** ����AFFECTEDAREA */
    private double affectedarea = 0D;
    /** ����LOSSAREA */
    private double lossarea = 0D;
    /** ����LAWSUITFLAG */
    private String lawsuitflag = "";
    /** ����FARMERCOUNT */
    private long farmercount = 0L;
    /** ����CLAIMCODE */
    private String claimcode = "";
    /** ����DAMAGEDAREA */
    private double damagedarea = 0D;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CasemaininfoDtoBase����
     */
    public CasemaininfoDtoBase(){
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
     * ��������CASENO
     * @param caseno �����õ�����CASENO��ֵ
     */
    public void setCaseno(String caseno){
        this.caseno = StringUtils.rightTrim(caseno);
    }

    /**
     * ��ȡ����CASENO
     * @return ����CASENO��ֵ
     */
    public String getCaseno(){
        return caseno;
    }

    /**
     * ��������CLAIMNO
     * @param claimno �����õ�����CLAIMNO��ֵ
     */
    public void setClaimno(String claimno){
        this.claimno = StringUtils.rightTrim(claimno);
    }

    /**
     * ��ȡ����CLAIMNO
     * @return ����CLAIMNO��ֵ
     */
    public String getClaimno(){
        return claimno;
    }

    /**
     * ��������UNDERWRITEENDDATE
     * @param underwriteenddate �����õ�����UNDERWRITEENDDATE��ֵ
     */
    public void setUnderwriteenddate(DateTime underwriteenddate){
        this.underwriteenddate = underwriteenddate;
    }

    /**
     * ��ȡ����UNDERWRITEENDDATE
     * @return ����UNDERWRITEENDDATE��ֵ
     */
    public DateTime getUnderwriteenddate(){
        return underwriteenddate;
    }

    /**
     * ��������ENDCASEDATE
     * @param endcasedate �����õ�����ENDCASEDATE��ֵ
     */
    public void setEndcasedate(DateTime endcasedate){
        this.endcasedate = endcasedate;
    }

    /**
     * ��ȡ����ENDCASEDATE
     * @return ����ENDCASEDATE��ֵ
     */
    public DateTime getEndcasedate(){
        return endcasedate;
    }

    /**
     * ��������ASUMPAID
     * @param asumpaid �����õ�����ASUMPAID��ֵ
     */
    public void setAsumpaid(double asumpaid){
        this.asumpaid = asumpaid;
    }

    /**
     * ��ȡ����ASUMPAID
     * @return ����ASUMPAID��ֵ
     */
    public double getAsumpaid(){
        return asumpaid;
    }

    /**
     * ��������ASUMFEE
     * @param asumfee �����õ�����ASUMFEE��ֵ
     */
    public void setAsumfee(double asumfee){
        this.asumfee = asumfee;
    }

    /**
     * ��ȡ����ASUMFEE
     * @return ����ASUMFEE��ֵ
     */
    public double getAsumfee(){
        return asumfee;
    }

    /**
     * ��������CASEMONEY
     * @param casemoney �����õ�����CASEMONEY��ֵ
     */
    public void setCasemoney(double casemoney){
        this.casemoney = casemoney;
    }

    /**
     * ��ȡ����CASEMONEY
     * @return ����CASEMONEY��ֵ
     */
    public double getCasemoney(){
        return casemoney;
    }

    /**
     * ��������CASEMONEYFEE
     * @param casemoneyfee �����õ�����CASEMONEYFEE��ֵ
     */
    public void setCasemoneyfee(double casemoneyfee){
        this.casemoneyfee = casemoneyfee;
    }

    /**
     * ��ȡ����CASEMONEYFEE
     * @return ����CASEMONEYFEE��ֵ
     */
    public double getCasemoneyfee(){
        return casemoneyfee;
    }

    /**
     * ��������PRESUMPAID
     * @param presumpaid �����õ�����PRESUMPAID��ֵ
     */
    public void setPresumpaid(double presumpaid){
        this.presumpaid = presumpaid;
    }

    /**
     * ��ȡ����PRESUMPAID
     * @return ����PRESUMPAID��ֵ
     */
    public double getPresumpaid(){
        return presumpaid;
    }

    /**
     * ��������PRESUMFEE
     * @param presumfee �����õ�����PRESUMFEE��ֵ
     */
    public void setPresumfee(double presumfee){
        this.presumfee = presumfee;
    }

    /**
     * ��ȡ����PRESUMFEE
     * @return ����PRESUMFEE��ֵ
     */
    public double getPresumfee(){
        return presumfee;
    }

    /**
     * ��������DAMAGEINSURED
     * @param damageinsured �����õ�����DAMAGEINSURED��ֵ
     */
    public void setDamageinsured(long damageinsured){
        this.damageinsured = damageinsured;
    }

    /**
     * ��ȡ����DAMAGEINSURED
     * @return ����DAMAGEINSURED��ֵ
     */
    public long getDamageinsured(){
        return damageinsured;
    }

    /**
     * ��������LOSSESNUMBER
     * @param lossesnumber �����õ�����LOSSESNUMBER��ֵ
     */
    public void setLossesnumber(double lossesnumber){
        this.lossesnumber = lossesnumber;
    }

    /**
     * ��ȡ����LOSSESNUMBER
     * @return ����LOSSESNUMBER��ֵ
     */
    public double getLossesnumber(){
        return lossesnumber;
    }

    /**
     * ��������LOSSESUNITCODE
     * @param lossesunitcode �����õ�����LOSSESUNITCODE��ֵ
     */
    public void setLossesunitcode(String lossesunitcode){
        this.lossesunitcode = StringUtils.rightTrim(lossesunitcode);
    }

    /**
     * ��ȡ����LOSSESUNITCODE
     * @return ����LOSSESUNITCODE��ֵ
     */
    public String getLossesunitcode(){
        return lossesunitcode;
    }

    /**
     * ��������REOPENEDTYPE
     * @param reopenedtype �����õ�����REOPENEDTYPE��ֵ
     */
    public void setReopenedtype(String reopenedtype){
        this.reopenedtype = StringUtils.rightTrim(reopenedtype);
    }

    /**
     * ��ȡ����REOPENEDTYPE
     * @return ����REOPENEDTYPE��ֵ
     */
    public String getReopenedtype(){
        return reopenedtype;
    }

    /**
     * ��������TIMES
     * @param times �����õ�����TIMES��ֵ
     */
    public void setTimes(int times){
        this.times = times;
    }

    /**
     * ��ȡ����TIMES
     * @return ����TIMES��ֵ
     */
    public int getTimes(){
        return times;
    }

    /**
     * ��������AFFECTEDAREA
     * @param affectedarea �����õ�����AFFECTEDAREA��ֵ
     */
    public void setAffectedarea(double affectedarea){
        this.affectedarea = affectedarea;
    }

    /**
     * ��ȡ����AFFECTEDAREA
     * @return ����AFFECTEDAREA��ֵ
     */
    public double getAffectedarea(){
        return affectedarea;
    }

    /**
     * ��������LOSSAREA
     * @param lossarea �����õ�����LOSSAREA��ֵ
     */
    public void setLossarea(double lossarea){
        this.lossarea = lossarea;
    }

    /**
     * ��ȡ����LOSSAREA
     * @return ����LOSSAREA��ֵ
     */
    public double getLossarea(){
        return lossarea;
    }

    /**
     * ��������LAWSUITFLAG
     * @param lawsuitflag �����õ�����LAWSUITFLAG��ֵ
     */
    public void setLawsuitflag(String lawsuitflag){
        this.lawsuitflag = StringUtils.rightTrim(lawsuitflag);
    }

    /**
     * ��ȡ����LAWSUITFLAG
     * @return ����LAWSUITFLAG��ֵ
     */
    public String getLawsuitflag(){
        return lawsuitflag;
    }

    /**
     * ��������FARMERCOUNT
     * @param farmercount �����õ�����FARMERCOUNT��ֵ
     */
    public void setFarmercount(long farmercount){
        this.farmercount = farmercount;
    }

    /**
     * ��ȡ����FARMERCOUNT
     * @return ����FARMERCOUNT��ֵ
     */
    public long getFarmercount(){
        return farmercount;
    }

    /**
     * ��������CLAIMCODE
     * @param claimcode �����õ�����CLAIMCODE��ֵ
     */
    public void setClaimcode(String claimcode){
        this.claimcode = StringUtils.rightTrim(claimcode);
    }

    /**
     * ��ȡ����CLAIMCODE
     * @return ����CLAIMCODE��ֵ
     */
    public String getClaimcode(){
        return claimcode;
    }

    /**
     * ��������DAMAGEDAREA
     * @param damagedarea �����õ�����DAMAGEDAREA��ֵ
     */
    public void setDamagedarea(double damagedarea){
        this.damagedarea = damagedarea;
    }

    /**
     * ��ȡ����DAMAGEDAREA
     * @return ����DAMAGEDAREA��ֵ
     */
    public double getDamagedarea(){
        return damagedarea;
    }
}
