package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是HOUSEPOLICYLIST的数据传输对象基类<br>
 */
public class HousepolicylistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性INUSRELISTCODE */
    private String inusrelistcode = "";
    /** 属性KINDCODE */
    private String kindcode = "";
    /** 属性INDEXCODE */
    private String indexcode = "";
    /** 属性NAME */
    private String name = "";
    /** 属性IDCARD */
    private String idcard = "";
    /** 属性ADDRESS */
    private String address = "";
    /** 属性AREACODE */
    private String areacode = "";
    /** 属性RATE */
    private double rate = 0D;
    /** 属性RISKCODE */
    private String riskcode = "";
    /** 属性CLASSCODE */
    private String classcode = "";
    /** 属性SHORTRATEFLAG */
    private String shortrateflag = "";
    /** 属性SHORTRATE */
    private double shortrate = 0D;
    /** 属性SUMAMOUNT */
    private double sumamount = 0D;
    /** 属性SUMPREMIUM */
    private double sumpremium = 0D;
    /** 属性FPREMIUM */
    private double fpremium = 0D;
    /** 属性CENTRALPREMIUM */
    private double centralpremium = 0D;
    /** 属性PROVINCEPREMIUM */
    private double provincepremium = 0D;
    /** 属性CITYPREMIUM */
    private double citypremium = 0D;
    /** 属性TOWNPREMIUM */
    private double townpremium = 0D;
    /** 属性OTHERPREMIUM */
    private double otherpremium = 0D;
    /** 属性STARTDATE */
    private DateTime startdate = new DateTime();
    /** 属性ENDDATE */
    private DateTime enddate = new DateTime();
    /** 属性OPCODE */
    private String opcode = "";
    /** 属性OPTIME */
    private DateTime optime = new DateTime();
    /** 属性CALCULATEFLAG */
    private String calculateflag = "";
    /** 属性VALIDITY */
    private String validity = "";
    /** 属性HUKOUBU */
    private String hukoubu = "";
    /** 属性FLOOR */
    private String floor = "";
    /** 属性BUILDINGNUMBER */
    private String buildingnumber = "";
    /** 属性ZHUANNUMBER */
    private String zhuannumber = "";
    /** 属性WANUMBER */
    private String wanumber = "";
    /** 属性KITCHENNUMBER */
    private String kitchennumber = "";
    /** 属性OTHERNUMBER */
    private String othernumber = "";
    /** 属性PHONE */
    private String phone = "";
    /** 属性REMARK */
    private String remark = "";

    /**
     *  默认构造方法,构造一个默认的HousepolicylistDtoBase对象
     */
    public HousepolicylistDtoBase(){
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
     * 设置属性KINDCODE
     * @param kindcode 待设置的属性KINDCODE的值
     */
    public void setKindcode(String kindcode){
        this.kindcode = StringUtils.rightTrim(kindcode);
    }

    /**
     * 获取属性KINDCODE
     * @return 属性KINDCODE的值
     */
    public String getKindcode(){
        return kindcode;
    }

    /**
     * 设置属性INDEXCODE
     * @param indexcode 待设置的属性INDEXCODE的值
     */
    public void setIndexcode(String indexcode){
        this.indexcode = StringUtils.rightTrim(indexcode);
    }

    /**
     * 获取属性INDEXCODE
     * @return 属性INDEXCODE的值
     */
    public String getIndexcode(){
        return indexcode;
    }

    /**
     * 设置属性NAME
     * @param name 待设置的属性NAME的值
     */
    public void setName(String name){
        this.name = StringUtils.rightTrim(name);
    }

    /**
     * 获取属性NAME
     * @return 属性NAME的值
     */
    public String getName(){
        return name;
    }

    /**
     * 设置属性IDCARD
     * @param idcard 待设置的属性IDCARD的值
     */
    public void setIdcard(String idcard){
        this.idcard = StringUtils.rightTrim(idcard);
    }

    /**
     * 获取属性IDCARD
     * @return 属性IDCARD的值
     */
    public String getIdcard(){
        return idcard;
    }

    /**
     * 设置属性ADDRESS
     * @param address 待设置的属性ADDRESS的值
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * 获取属性ADDRESS
     * @return 属性ADDRESS的值
     */
    public String getAddress(){
        return address;
    }

    /**
     * 设置属性AREACODE
     * @param areacode 待设置的属性AREACODE的值
     */
    public void setAreacode(String areacode){
        this.areacode = StringUtils.rightTrim(areacode);
    }

    /**
     * 获取属性AREACODE
     * @return 属性AREACODE的值
     */
    public String getAreacode(){
        return areacode;
    }

    /**
     * 设置属性RATE
     * @param rate 待设置的属性RATE的值
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * 获取属性RATE
     * @return 属性RATE的值
     */
    public double getRate(){
        return rate;
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
     * 设置属性SHORTRATEFLAG
     * @param shortrateflag 待设置的属性SHORTRATEFLAG的值
     */
    public void setShortrateflag(String shortrateflag){
        this.shortrateflag = StringUtils.rightTrim(shortrateflag);
    }

    /**
     * 获取属性SHORTRATEFLAG
     * @return 属性SHORTRATEFLAG的值
     */
    public String getShortrateflag(){
        return shortrateflag;
    }

    /**
     * 设置属性SHORTRATE
     * @param shortrate 待设置的属性SHORTRATE的值
     */
    public void setShortrate(double shortrate){
        this.shortrate = shortrate;
    }

    /**
     * 获取属性SHORTRATE
     * @return 属性SHORTRATE的值
     */
    public double getShortrate(){
        return shortrate;
    }

    /**
     * 设置属性SUMAMOUNT
     * @param sumamount 待设置的属性SUMAMOUNT的值
     */
    public void setSumamount(double sumamount){
        this.sumamount = sumamount;
    }

    /**
     * 获取属性SUMAMOUNT
     * @return 属性SUMAMOUNT的值
     */
    public double getSumamount(){
        return sumamount;
    }

    /**
     * 设置属性SUMPREMIUM
     * @param sumpremium 待设置的属性SUMPREMIUM的值
     */
    public void setSumpremium(double sumpremium){
        this.sumpremium = sumpremium;
    }

    /**
     * 获取属性SUMPREMIUM
     * @return 属性SUMPREMIUM的值
     */
    public double getSumpremium(){
        return sumpremium;
    }

    /**
     * 设置属性FPREMIUM
     * @param fpremium 待设置的属性FPREMIUM的值
     */
    public void setFpremium(double fpremium){
        this.fpremium = fpremium;
    }

    /**
     * 获取属性FPREMIUM
     * @return 属性FPREMIUM的值
     */
    public double getFpremium(){
        return fpremium;
    }

    /**
     * 设置属性CENTRALPREMIUM
     * @param centralpremium 待设置的属性CENTRALPREMIUM的值
     */
    public void setCentralpremium(double centralpremium){
        this.centralpremium = centralpremium;
    }

    /**
     * 获取属性CENTRALPREMIUM
     * @return 属性CENTRALPREMIUM的值
     */
    public double getCentralpremium(){
        return centralpremium;
    }

    /**
     * 设置属性PROVINCEPREMIUM
     * @param provincepremium 待设置的属性PROVINCEPREMIUM的值
     */
    public void setProvincepremium(double provincepremium){
        this.provincepremium = provincepremium;
    }

    /**
     * 获取属性PROVINCEPREMIUM
     * @return 属性PROVINCEPREMIUM的值
     */
    public double getProvincepremium(){
        return provincepremium;
    }

    /**
     * 设置属性CITYPREMIUM
     * @param citypremium 待设置的属性CITYPREMIUM的值
     */
    public void setCitypremium(double citypremium){
        this.citypremium = citypremium;
    }

    /**
     * 获取属性CITYPREMIUM
     * @return 属性CITYPREMIUM的值
     */
    public double getCitypremium(){
        return citypremium;
    }

    /**
     * 设置属性TOWNPREMIUM
     * @param townpremium 待设置的属性TOWNPREMIUM的值
     */
    public void setTownpremium(double townpremium){
        this.townpremium = townpremium;
    }

    /**
     * 获取属性TOWNPREMIUM
     * @return 属性TOWNPREMIUM的值
     */
    public double getTownpremium(){
        return townpremium;
    }

    /**
     * 设置属性OTHERPREMIUM
     * @param otherpremium 待设置的属性OTHERPREMIUM的值
     */
    public void setOtherpremium(double otherpremium){
        this.otherpremium = otherpremium;
    }

    /**
     * 获取属性OTHERPREMIUM
     * @return 属性OTHERPREMIUM的值
     */
    public double getOtherpremium(){
        return otherpremium;
    }

    /**
     * 设置属性STARTDATE
     * @param startdate 待设置的属性STARTDATE的值
     */
    public void setStartdate(DateTime startdate){
        this.startdate = startdate;
    }

    /**
     * 获取属性STARTDATE
     * @return 属性STARTDATE的值
     */
    public DateTime getStartdate(){
        return startdate;
    }

    /**
     * 设置属性ENDDATE
     * @param enddate 待设置的属性ENDDATE的值
     */
    public void setEnddate(DateTime enddate){
        this.enddate = enddate;
    }

    /**
     * 获取属性ENDDATE
     * @return 属性ENDDATE的值
     */
    public DateTime getEnddate(){
        return enddate;
    }

    /**
     * 设置属性OPCODE
     * @param opcode 待设置的属性OPCODE的值
     */
    public void setOpcode(String opcode){
        this.opcode = StringUtils.rightTrim(opcode);
    }

    /**
     * 获取属性OPCODE
     * @return 属性OPCODE的值
     */
    public String getOpcode(){
        return opcode;
    }

    /**
     * 设置属性OPTIME
     * @param optime 待设置的属性OPTIME的值
     */
    public void setOptime(DateTime optime){
        this.optime = optime;
    }

    /**
     * 获取属性OPTIME
     * @return 属性OPTIME的值
     */
    public DateTime getOptime(){
        return optime;
    }

    /**
     * 设置属性CALCULATEFLAG
     * @param calculateflag 待设置的属性CALCULATEFLAG的值
     */
    public void setCalculateflag(String calculateflag){
        this.calculateflag = StringUtils.rightTrim(calculateflag);
    }

    /**
     * 获取属性CALCULATEFLAG
     * @return 属性CALCULATEFLAG的值
     */
    public String getCalculateflag(){
        return calculateflag;
    }

    /**
     * 设置属性VALIDITY
     * @param validity 待设置的属性VALIDITY的值
     */
    public void setValidity(String validity){
        this.validity = StringUtils.rightTrim(validity);
    }

    /**
     * 获取属性VALIDITY
     * @return 属性VALIDITY的值
     */
    public String getValidity(){
        return validity;
    }

    /**
     * 设置属性HUKOUBU
     * @param hukoubu 待设置的属性HUKOUBU的值
     */
    public void setHukoubu(String hukoubu){
        this.hukoubu = StringUtils.rightTrim(hukoubu);
    }

    /**
     * 获取属性HUKOUBU
     * @return 属性HUKOUBU的值
     */
    public String getHukoubu(){
        return hukoubu;
    }

    /**
     * 设置属性FLOOR
     * @param floor 待设置的属性FLOOR的值
     */
    public void setFloor(String floor){
        this.floor = StringUtils.rightTrim(floor);
    }

    /**
     * 获取属性FLOOR
     * @return 属性FLOOR的值
     */
    public String getFloor(){
        return floor;
    }

    /**
     * 设置属性BUILDINGNUMBER
     * @param buildingnumber 待设置的属性BUILDINGNUMBER的值
     */
    public void setBuildingnumber(String buildingnumber){
        this.buildingnumber = StringUtils.rightTrim(buildingnumber);
    }

    /**
     * 获取属性BUILDINGNUMBER
     * @return 属性BUILDINGNUMBER的值
     */
    public String getBuildingnumber(){
        return buildingnumber;
    }

    /**
     * 设置属性ZHUANNUMBER
     * @param zhuannumber 待设置的属性ZHUANNUMBER的值
     */
    public void setZhuannumber(String zhuannumber){
        this.zhuannumber = StringUtils.rightTrim(zhuannumber);
    }

    /**
     * 获取属性ZHUANNUMBER
     * @return 属性ZHUANNUMBER的值
     */
    public String getZhuannumber(){
        return zhuannumber;
    }

    /**
     * 设置属性WANUMBER
     * @param wanumber 待设置的属性WANUMBER的值
     */
    public void setWanumber(String wanumber){
        this.wanumber = StringUtils.rightTrim(wanumber);
    }

    /**
     * 获取属性WANUMBER
     * @return 属性WANUMBER的值
     */
    public String getWanumber(){
        return wanumber;
    }

    /**
     * 设置属性KITCHENNUMBER
     * @param kitchennumber 待设置的属性KITCHENNUMBER的值
     */
    public void setKitchennumber(String kitchennumber){
        this.kitchennumber = StringUtils.rightTrim(kitchennumber);
    }

    /**
     * 获取属性KITCHENNUMBER
     * @return 属性KITCHENNUMBER的值
     */
    public String getKitchennumber(){
        return kitchennumber;
    }

    /**
     * 设置属性OTHERNUMBER
     * @param othernumber 待设置的属性OTHERNUMBER的值
     */
    public void setOthernumber(String othernumber){
        this.othernumber = StringUtils.rightTrim(othernumber);
    }

    /**
     * 获取属性OTHERNUMBER
     * @return 属性OTHERNUMBER的值
     */
    public String getOthernumber(){
        return othernumber;
    }

    /**
     * 设置属性PHONE
     * @param phone 待设置的属性PHONE的值
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * 获取属性PHONE
     * @return 属性PHONE的值
     */
    public String getPhone(){
        return phone;
    }

    /**
     * 设置属性REMARK
     * @param remark 待设置的属性REMARK的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性REMARK
     * @return 属性REMARK的值
     */
    public String getRemark(){
        return remark;
    }
}
