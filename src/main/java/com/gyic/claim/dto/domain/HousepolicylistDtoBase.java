package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����HOUSEPOLICYLIST�����ݴ���������<br>
 */
public class HousepolicylistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����INUSRELISTCODE */
    private String inusrelistcode = "";
    /** ����KINDCODE */
    private String kindcode = "";
    /** ����INDEXCODE */
    private String indexcode = "";
    /** ����NAME */
    private String name = "";
    /** ����IDCARD */
    private String idcard = "";
    /** ����ADDRESS */
    private String address = "";
    /** ����AREACODE */
    private String areacode = "";
    /** ����RATE */
    private double rate = 0D;
    /** ����RISKCODE */
    private String riskcode = "";
    /** ����CLASSCODE */
    private String classcode = "";
    /** ����SHORTRATEFLAG */
    private String shortrateflag = "";
    /** ����SHORTRATE */
    private double shortrate = 0D;
    /** ����SUMAMOUNT */
    private double sumamount = 0D;
    /** ����SUMPREMIUM */
    private double sumpremium = 0D;
    /** ����FPREMIUM */
    private double fpremium = 0D;
    /** ����CENTRALPREMIUM */
    private double centralpremium = 0D;
    /** ����PROVINCEPREMIUM */
    private double provincepremium = 0D;
    /** ����CITYPREMIUM */
    private double citypremium = 0D;
    /** ����TOWNPREMIUM */
    private double townpremium = 0D;
    /** ����OTHERPREMIUM */
    private double otherpremium = 0D;
    /** ����STARTDATE */
    private DateTime startdate = new DateTime();
    /** ����ENDDATE */
    private DateTime enddate = new DateTime();
    /** ����OPCODE */
    private String opcode = "";
    /** ����OPTIME */
    private DateTime optime = new DateTime();
    /** ����CALCULATEFLAG */
    private String calculateflag = "";
    /** ����VALIDITY */
    private String validity = "";
    /** ����HUKOUBU */
    private String hukoubu = "";
    /** ����FLOOR */
    private String floor = "";
    /** ����BUILDINGNUMBER */
    private String buildingnumber = "";
    /** ����ZHUANNUMBER */
    private String zhuannumber = "";
    /** ����WANUMBER */
    private String wanumber = "";
    /** ����KITCHENNUMBER */
    private String kitchennumber = "";
    /** ����OTHERNUMBER */
    private String othernumber = "";
    /** ����PHONE */
    private String phone = "";
    /** ����REMARK */
    private String remark = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�HousepolicylistDtoBase����
     */
    public HousepolicylistDtoBase(){
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
     * ��������KINDCODE
     * @param kindcode �����õ�����KINDCODE��ֵ
     */
    public void setKindcode(String kindcode){
        this.kindcode = StringUtils.rightTrim(kindcode);
    }

    /**
     * ��ȡ����KINDCODE
     * @return ����KINDCODE��ֵ
     */
    public String getKindcode(){
        return kindcode;
    }

    /**
     * ��������INDEXCODE
     * @param indexcode �����õ�����INDEXCODE��ֵ
     */
    public void setIndexcode(String indexcode){
        this.indexcode = StringUtils.rightTrim(indexcode);
    }

    /**
     * ��ȡ����INDEXCODE
     * @return ����INDEXCODE��ֵ
     */
    public String getIndexcode(){
        return indexcode;
    }

    /**
     * ��������NAME
     * @param name �����õ�����NAME��ֵ
     */
    public void setName(String name){
        this.name = StringUtils.rightTrim(name);
    }

    /**
     * ��ȡ����NAME
     * @return ����NAME��ֵ
     */
    public String getName(){
        return name;
    }

    /**
     * ��������IDCARD
     * @param idcard �����õ�����IDCARD��ֵ
     */
    public void setIdcard(String idcard){
        this.idcard = StringUtils.rightTrim(idcard);
    }

    /**
     * ��ȡ����IDCARD
     * @return ����IDCARD��ֵ
     */
    public String getIdcard(){
        return idcard;
    }

    /**
     * ��������ADDRESS
     * @param address �����õ�����ADDRESS��ֵ
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * ��ȡ����ADDRESS
     * @return ����ADDRESS��ֵ
     */
    public String getAddress(){
        return address;
    }

    /**
     * ��������AREACODE
     * @param areacode �����õ�����AREACODE��ֵ
     */
    public void setAreacode(String areacode){
        this.areacode = StringUtils.rightTrim(areacode);
    }

    /**
     * ��ȡ����AREACODE
     * @return ����AREACODE��ֵ
     */
    public String getAreacode(){
        return areacode;
    }

    /**
     * ��������RATE
     * @param rate �����õ�����RATE��ֵ
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * ��ȡ����RATE
     * @return ����RATE��ֵ
     */
    public double getRate(){
        return rate;
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
     * ��������SHORTRATEFLAG
     * @param shortrateflag �����õ�����SHORTRATEFLAG��ֵ
     */
    public void setShortrateflag(String shortrateflag){
        this.shortrateflag = StringUtils.rightTrim(shortrateflag);
    }

    /**
     * ��ȡ����SHORTRATEFLAG
     * @return ����SHORTRATEFLAG��ֵ
     */
    public String getShortrateflag(){
        return shortrateflag;
    }

    /**
     * ��������SHORTRATE
     * @param shortrate �����õ�����SHORTRATE��ֵ
     */
    public void setShortrate(double shortrate){
        this.shortrate = shortrate;
    }

    /**
     * ��ȡ����SHORTRATE
     * @return ����SHORTRATE��ֵ
     */
    public double getShortrate(){
        return shortrate;
    }

    /**
     * ��������SUMAMOUNT
     * @param sumamount �����õ�����SUMAMOUNT��ֵ
     */
    public void setSumamount(double sumamount){
        this.sumamount = sumamount;
    }

    /**
     * ��ȡ����SUMAMOUNT
     * @return ����SUMAMOUNT��ֵ
     */
    public double getSumamount(){
        return sumamount;
    }

    /**
     * ��������SUMPREMIUM
     * @param sumpremium �����õ�����SUMPREMIUM��ֵ
     */
    public void setSumpremium(double sumpremium){
        this.sumpremium = sumpremium;
    }

    /**
     * ��ȡ����SUMPREMIUM
     * @return ����SUMPREMIUM��ֵ
     */
    public double getSumpremium(){
        return sumpremium;
    }

    /**
     * ��������FPREMIUM
     * @param fpremium �����õ�����FPREMIUM��ֵ
     */
    public void setFpremium(double fpremium){
        this.fpremium = fpremium;
    }

    /**
     * ��ȡ����FPREMIUM
     * @return ����FPREMIUM��ֵ
     */
    public double getFpremium(){
        return fpremium;
    }

    /**
     * ��������CENTRALPREMIUM
     * @param centralpremium �����õ�����CENTRALPREMIUM��ֵ
     */
    public void setCentralpremium(double centralpremium){
        this.centralpremium = centralpremium;
    }

    /**
     * ��ȡ����CENTRALPREMIUM
     * @return ����CENTRALPREMIUM��ֵ
     */
    public double getCentralpremium(){
        return centralpremium;
    }

    /**
     * ��������PROVINCEPREMIUM
     * @param provincepremium �����õ�����PROVINCEPREMIUM��ֵ
     */
    public void setProvincepremium(double provincepremium){
        this.provincepremium = provincepremium;
    }

    /**
     * ��ȡ����PROVINCEPREMIUM
     * @return ����PROVINCEPREMIUM��ֵ
     */
    public double getProvincepremium(){
        return provincepremium;
    }

    /**
     * ��������CITYPREMIUM
     * @param citypremium �����õ�����CITYPREMIUM��ֵ
     */
    public void setCitypremium(double citypremium){
        this.citypremium = citypremium;
    }

    /**
     * ��ȡ����CITYPREMIUM
     * @return ����CITYPREMIUM��ֵ
     */
    public double getCitypremium(){
        return citypremium;
    }

    /**
     * ��������TOWNPREMIUM
     * @param townpremium �����õ�����TOWNPREMIUM��ֵ
     */
    public void setTownpremium(double townpremium){
        this.townpremium = townpremium;
    }

    /**
     * ��ȡ����TOWNPREMIUM
     * @return ����TOWNPREMIUM��ֵ
     */
    public double getTownpremium(){
        return townpremium;
    }

    /**
     * ��������OTHERPREMIUM
     * @param otherpremium �����õ�����OTHERPREMIUM��ֵ
     */
    public void setOtherpremium(double otherpremium){
        this.otherpremium = otherpremium;
    }

    /**
     * ��ȡ����OTHERPREMIUM
     * @return ����OTHERPREMIUM��ֵ
     */
    public double getOtherpremium(){
        return otherpremium;
    }

    /**
     * ��������STARTDATE
     * @param startdate �����õ�����STARTDATE��ֵ
     */
    public void setStartdate(DateTime startdate){
        this.startdate = startdate;
    }

    /**
     * ��ȡ����STARTDATE
     * @return ����STARTDATE��ֵ
     */
    public DateTime getStartdate(){
        return startdate;
    }

    /**
     * ��������ENDDATE
     * @param enddate �����õ�����ENDDATE��ֵ
     */
    public void setEnddate(DateTime enddate){
        this.enddate = enddate;
    }

    /**
     * ��ȡ����ENDDATE
     * @return ����ENDDATE��ֵ
     */
    public DateTime getEnddate(){
        return enddate;
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
     * ��������OPTIME
     * @param optime �����õ�����OPTIME��ֵ
     */
    public void setOptime(DateTime optime){
        this.optime = optime;
    }

    /**
     * ��ȡ����OPTIME
     * @return ����OPTIME��ֵ
     */
    public DateTime getOptime(){
        return optime;
    }

    /**
     * ��������CALCULATEFLAG
     * @param calculateflag �����õ�����CALCULATEFLAG��ֵ
     */
    public void setCalculateflag(String calculateflag){
        this.calculateflag = StringUtils.rightTrim(calculateflag);
    }

    /**
     * ��ȡ����CALCULATEFLAG
     * @return ����CALCULATEFLAG��ֵ
     */
    public String getCalculateflag(){
        return calculateflag;
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
     * ��������HUKOUBU
     * @param hukoubu �����õ�����HUKOUBU��ֵ
     */
    public void setHukoubu(String hukoubu){
        this.hukoubu = StringUtils.rightTrim(hukoubu);
    }

    /**
     * ��ȡ����HUKOUBU
     * @return ����HUKOUBU��ֵ
     */
    public String getHukoubu(){
        return hukoubu;
    }

    /**
     * ��������FLOOR
     * @param floor �����õ�����FLOOR��ֵ
     */
    public void setFloor(String floor){
        this.floor = StringUtils.rightTrim(floor);
    }

    /**
     * ��ȡ����FLOOR
     * @return ����FLOOR��ֵ
     */
    public String getFloor(){
        return floor;
    }

    /**
     * ��������BUILDINGNUMBER
     * @param buildingnumber �����õ�����BUILDINGNUMBER��ֵ
     */
    public void setBuildingnumber(String buildingnumber){
        this.buildingnumber = StringUtils.rightTrim(buildingnumber);
    }

    /**
     * ��ȡ����BUILDINGNUMBER
     * @return ����BUILDINGNUMBER��ֵ
     */
    public String getBuildingnumber(){
        return buildingnumber;
    }

    /**
     * ��������ZHUANNUMBER
     * @param zhuannumber �����õ�����ZHUANNUMBER��ֵ
     */
    public void setZhuannumber(String zhuannumber){
        this.zhuannumber = StringUtils.rightTrim(zhuannumber);
    }

    /**
     * ��ȡ����ZHUANNUMBER
     * @return ����ZHUANNUMBER��ֵ
     */
    public String getZhuannumber(){
        return zhuannumber;
    }

    /**
     * ��������WANUMBER
     * @param wanumber �����õ�����WANUMBER��ֵ
     */
    public void setWanumber(String wanumber){
        this.wanumber = StringUtils.rightTrim(wanumber);
    }

    /**
     * ��ȡ����WANUMBER
     * @return ����WANUMBER��ֵ
     */
    public String getWanumber(){
        return wanumber;
    }

    /**
     * ��������KITCHENNUMBER
     * @param kitchennumber �����õ�����KITCHENNUMBER��ֵ
     */
    public void setKitchennumber(String kitchennumber){
        this.kitchennumber = StringUtils.rightTrim(kitchennumber);
    }

    /**
     * ��ȡ����KITCHENNUMBER
     * @return ����KITCHENNUMBER��ֵ
     */
    public String getKitchennumber(){
        return kitchennumber;
    }

    /**
     * ��������OTHERNUMBER
     * @param othernumber �����õ�����OTHERNUMBER��ֵ
     */
    public void setOthernumber(String othernumber){
        this.othernumber = StringUtils.rightTrim(othernumber);
    }

    /**
     * ��ȡ����OTHERNUMBER
     * @return ����OTHERNUMBER��ֵ
     */
    public String getOthernumber(){
        return othernumber;
    }

    /**
     * ��������PHONE
     * @param phone �����õ�����PHONE��ֵ
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * ��ȡ����PHONE
     * @return ����PHONE��ֵ
     */
    public String getPhone(){
        return phone;
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
}
