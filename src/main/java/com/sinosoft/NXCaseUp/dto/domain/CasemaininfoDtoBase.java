package com.sinosoft.NXCaseUp.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CASEMAININFO的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CasemaininfoDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性COMCODE */
    private String comcode = "";
    /** 属性POLICYNO */
    private String policyno = "";
    /** 属性CASENO */
    private String caseno = "";
    /** 属性CLAIMNO */
    private String claimno = "";
    /** 属性UNDERWRITEENDDATE */
    private DateTime underwriteenddate = new DateTime();
    /** 属性ENDCASEDATE */
    private DateTime endcasedate = new DateTime();
    /** 属性ASUMPAID */
    private double asumpaid = 0D;
    /** 属性ASUMFEE */
    private double asumfee = 0D;
    /** 属性CASEMONEY */
    private double casemoney = 0D;
    /** 属性CASEMONEYFEE */
    private double casemoneyfee = 0D;
    /** 属性PRESUMPAID */
    private double presumpaid = 0D;
    /** 属性PRESUMFEE */
    private double presumfee = 0D;
    /** 属性DAMAGEINSURED */
    private long damageinsured = 0L;
    /** 属性LOSSESNUMBER */
    private double lossesnumber = 0D;
    /** 属性LOSSESUNITCODE */
    private String lossesunitcode = "";
    /** 属性REOPENEDTYPE */
    private String reopenedtype = "";
    /** 属性TIMES */
    private int times = 0;
    /** 属性AFFECTEDAREA */
    private double affectedarea = 0D;
    /** 属性LOSSAREA */
    private double lossarea = 0D;
    /** 属性LAWSUITFLAG */
    private String lawsuitflag = "";
    /** 属性FARMERCOUNT */
    private long farmercount = 0L;
    /** 属性CLAIMCODE */
    private String claimcode = "";
    /** 属性DAMAGEDAREA */
    private double damagedarea = 0D;

    /**
     *  默认构造方法,构造一个默认的CasemaininfoDtoBase对象
     */
    public CasemaininfoDtoBase(){
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
     * 设置属性CASENO
     * @param caseno 待设置的属性CASENO的值
     */
    public void setCaseno(String caseno){
        this.caseno = StringUtils.rightTrim(caseno);
    }

    /**
     * 获取属性CASENO
     * @return 属性CASENO的值
     */
    public String getCaseno(){
        return caseno;
    }

    /**
     * 设置属性CLAIMNO
     * @param claimno 待设置的属性CLAIMNO的值
     */
    public void setClaimno(String claimno){
        this.claimno = StringUtils.rightTrim(claimno);
    }

    /**
     * 获取属性CLAIMNO
     * @return 属性CLAIMNO的值
     */
    public String getClaimno(){
        return claimno;
    }

    /**
     * 设置属性UNDERWRITEENDDATE
     * @param underwriteenddate 待设置的属性UNDERWRITEENDDATE的值
     */
    public void setUnderwriteenddate(DateTime underwriteenddate){
        this.underwriteenddate = underwriteenddate;
    }

    /**
     * 获取属性UNDERWRITEENDDATE
     * @return 属性UNDERWRITEENDDATE的值
     */
    public DateTime getUnderwriteenddate(){
        return underwriteenddate;
    }

    /**
     * 设置属性ENDCASEDATE
     * @param endcasedate 待设置的属性ENDCASEDATE的值
     */
    public void setEndcasedate(DateTime endcasedate){
        this.endcasedate = endcasedate;
    }

    /**
     * 获取属性ENDCASEDATE
     * @return 属性ENDCASEDATE的值
     */
    public DateTime getEndcasedate(){
        return endcasedate;
    }

    /**
     * 设置属性ASUMPAID
     * @param asumpaid 待设置的属性ASUMPAID的值
     */
    public void setAsumpaid(double asumpaid){
        this.asumpaid = asumpaid;
    }

    /**
     * 获取属性ASUMPAID
     * @return 属性ASUMPAID的值
     */
    public double getAsumpaid(){
        return asumpaid;
    }

    /**
     * 设置属性ASUMFEE
     * @param asumfee 待设置的属性ASUMFEE的值
     */
    public void setAsumfee(double asumfee){
        this.asumfee = asumfee;
    }

    /**
     * 获取属性ASUMFEE
     * @return 属性ASUMFEE的值
     */
    public double getAsumfee(){
        return asumfee;
    }

    /**
     * 设置属性CASEMONEY
     * @param casemoney 待设置的属性CASEMONEY的值
     */
    public void setCasemoney(double casemoney){
        this.casemoney = casemoney;
    }

    /**
     * 获取属性CASEMONEY
     * @return 属性CASEMONEY的值
     */
    public double getCasemoney(){
        return casemoney;
    }

    /**
     * 设置属性CASEMONEYFEE
     * @param casemoneyfee 待设置的属性CASEMONEYFEE的值
     */
    public void setCasemoneyfee(double casemoneyfee){
        this.casemoneyfee = casemoneyfee;
    }

    /**
     * 获取属性CASEMONEYFEE
     * @return 属性CASEMONEYFEE的值
     */
    public double getCasemoneyfee(){
        return casemoneyfee;
    }

    /**
     * 设置属性PRESUMPAID
     * @param presumpaid 待设置的属性PRESUMPAID的值
     */
    public void setPresumpaid(double presumpaid){
        this.presumpaid = presumpaid;
    }

    /**
     * 获取属性PRESUMPAID
     * @return 属性PRESUMPAID的值
     */
    public double getPresumpaid(){
        return presumpaid;
    }

    /**
     * 设置属性PRESUMFEE
     * @param presumfee 待设置的属性PRESUMFEE的值
     */
    public void setPresumfee(double presumfee){
        this.presumfee = presumfee;
    }

    /**
     * 获取属性PRESUMFEE
     * @return 属性PRESUMFEE的值
     */
    public double getPresumfee(){
        return presumfee;
    }

    /**
     * 设置属性DAMAGEINSURED
     * @param damageinsured 待设置的属性DAMAGEINSURED的值
     */
    public void setDamageinsured(long damageinsured){
        this.damageinsured = damageinsured;
    }

    /**
     * 获取属性DAMAGEINSURED
     * @return 属性DAMAGEINSURED的值
     */
    public long getDamageinsured(){
        return damageinsured;
    }

    /**
     * 设置属性LOSSESNUMBER
     * @param lossesnumber 待设置的属性LOSSESNUMBER的值
     */
    public void setLossesnumber(double lossesnumber){
        this.lossesnumber = lossesnumber;
    }

    /**
     * 获取属性LOSSESNUMBER
     * @return 属性LOSSESNUMBER的值
     */
    public double getLossesnumber(){
        return lossesnumber;
    }

    /**
     * 设置属性LOSSESUNITCODE
     * @param lossesunitcode 待设置的属性LOSSESUNITCODE的值
     */
    public void setLossesunitcode(String lossesunitcode){
        this.lossesunitcode = StringUtils.rightTrim(lossesunitcode);
    }

    /**
     * 获取属性LOSSESUNITCODE
     * @return 属性LOSSESUNITCODE的值
     */
    public String getLossesunitcode(){
        return lossesunitcode;
    }

    /**
     * 设置属性REOPENEDTYPE
     * @param reopenedtype 待设置的属性REOPENEDTYPE的值
     */
    public void setReopenedtype(String reopenedtype){
        this.reopenedtype = StringUtils.rightTrim(reopenedtype);
    }

    /**
     * 获取属性REOPENEDTYPE
     * @return 属性REOPENEDTYPE的值
     */
    public String getReopenedtype(){
        return reopenedtype;
    }

    /**
     * 设置属性TIMES
     * @param times 待设置的属性TIMES的值
     */
    public void setTimes(int times){
        this.times = times;
    }

    /**
     * 获取属性TIMES
     * @return 属性TIMES的值
     */
    public int getTimes(){
        return times;
    }

    /**
     * 设置属性AFFECTEDAREA
     * @param affectedarea 待设置的属性AFFECTEDAREA的值
     */
    public void setAffectedarea(double affectedarea){
        this.affectedarea = affectedarea;
    }

    /**
     * 获取属性AFFECTEDAREA
     * @return 属性AFFECTEDAREA的值
     */
    public double getAffectedarea(){
        return affectedarea;
    }

    /**
     * 设置属性LOSSAREA
     * @param lossarea 待设置的属性LOSSAREA的值
     */
    public void setLossarea(double lossarea){
        this.lossarea = lossarea;
    }

    /**
     * 获取属性LOSSAREA
     * @return 属性LOSSAREA的值
     */
    public double getLossarea(){
        return lossarea;
    }

    /**
     * 设置属性LAWSUITFLAG
     * @param lawsuitflag 待设置的属性LAWSUITFLAG的值
     */
    public void setLawsuitflag(String lawsuitflag){
        this.lawsuitflag = StringUtils.rightTrim(lawsuitflag);
    }

    /**
     * 获取属性LAWSUITFLAG
     * @return 属性LAWSUITFLAG的值
     */
    public String getLawsuitflag(){
        return lawsuitflag;
    }

    /**
     * 设置属性FARMERCOUNT
     * @param farmercount 待设置的属性FARMERCOUNT的值
     */
    public void setFarmercount(long farmercount){
        this.farmercount = farmercount;
    }

    /**
     * 获取属性FARMERCOUNT
     * @return 属性FARMERCOUNT的值
     */
    public long getFarmercount(){
        return farmercount;
    }

    /**
     * 设置属性CLAIMCODE
     * @param claimcode 待设置的属性CLAIMCODE的值
     */
    public void setClaimcode(String claimcode){
        this.claimcode = StringUtils.rightTrim(claimcode);
    }

    /**
     * 获取属性CLAIMCODE
     * @return 属性CLAIMCODE的值
     */
    public String getClaimcode(){
        return claimcode;
    }

    /**
     * 设置属性DAMAGEDAREA
     * @param damagedarea 待设置的属性DAMAGEDAREA的值
     */
    public void setDamagedarea(double damagedarea){
        this.damagedarea = damagedarea;
    }

    /**
     * 获取属性DAMAGEDAREA
     * @return 属性DAMAGEDAREA的值
     */
    public double getDamagedarea(){
        return damagedarea;
    }
}
