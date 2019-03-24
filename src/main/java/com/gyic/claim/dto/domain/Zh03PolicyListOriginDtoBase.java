package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是ZH03PolicyListOrigin的数据传输对象基类<br>
 */
public class Zh03PolicyListOriginDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性INUSRELISTCODE */
    private String inusrelistcode = "";
    /** 属性INDEXNO */
    private String indexno = "";
    /** 属性RISKCODE */
    private String riskcode = "";
    /** 属性KINDCODE */
    private String kindcode = "";
    /** 属性FAMILYNO */
    private String familyno = "";
    /** 属性FAMILYNAME */
    private String familyname = "";
    /** 属性FAMILYSEX */
    private String familysex = "";
    /** 属性FAMILYFIDCARD */
    private String familyfidcard = "";
    /** 属性NAME */
    private String name = "";
    /** 属性ADDRESS */
    private String address = "";
    /** 属性COUNT */
    private String count = "";
    /** 属性UNITAMOUNT */
    private double unitamount = 0D;
    /** 属性SUMAMOUNT */
    private double sumamount = 0D;
    /** 属性SUMPREMIUM */
    private double sumpremium = 0D;
    /** 属性HANDLERCODE */
    private String handlercode = "";
    /** 属性INPUTDATE */
    private DateTime inputdate = new DateTime();
    /** 属性STARTDATE */
    private DateTime startdate = new DateTime();
    /** 属性ENDDATE */
    private DateTime enddate = new DateTime();
    /** 属性FLAG */
    private String flag = "";
    /** 属性REMARK */
    private String remark = "";
    /** 属性ITEMCODE */
    private String itemcode = "";
    /** 属性RATE */
    private String rate = "";
    /** 属性FAMILYFLAG */
    private String familyflag = "";
    /** 属性ExportIndex */
    private String exportIndex = "";
    /** 属性PersonNo */
    private String personNo = "";

    /**
     *  默认构造方法,构造一个默认的Zh03PolicyListOriginDtoBase对象
     */
    public Zh03PolicyListOriginDtoBase(){
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
     * 设置属性INDEXNO
     * @param indexno 待设置的属性INDEXNO的值
     */
    public void setIndexno(String indexno){
        this.indexno = StringUtils.rightTrim(indexno);
    }

    /**
     * 获取属性INDEXNO
     * @return 属性INDEXNO的值
     */
    public String getIndexno(){
        return indexno;
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
     * 设置属性FAMILYNO
     * @param familyno 待设置的属性FAMILYNO的值
     */
    public void setFamilyno(String familyno){
        this.familyno = StringUtils.rightTrim(familyno);
    }

    /**
     * 获取属性FAMILYNO
     * @return 属性FAMILYNO的值
     */
    public String getFamilyno(){
        return familyno;
    }

    /**
     * 设置属性FAMILYNAME
     * @param familyname 待设置的属性FAMILYNAME的值
     */
    public void setFamilyname(String familyname){
        this.familyname = StringUtils.rightTrim(familyname);
    }

    /**
     * 获取属性FAMILYNAME
     * @return 属性FAMILYNAME的值
     */
    public String getFamilyname(){
        return familyname;
    }

    /**
     * 设置属性FAMILYSEX
     * @param familysex 待设置的属性FAMILYSEX的值
     */
    public void setFamilysex(String familysex){
        this.familysex = StringUtils.rightTrim(familysex);
    }

    /**
     * 获取属性FAMILYSEX
     * @return 属性FAMILYSEX的值
     */
    public String getFamilysex(){
        return familysex;
    }

    /**
     * 设置属性FAMILYFIDCARD
     * @param familyfidcard 待设置的属性FAMILYFIDCARD的值
     */
    public void setFamilyfidcard(String familyfidcard){
        this.familyfidcard = StringUtils.rightTrim(familyfidcard);
    }

    /**
     * 获取属性FAMILYFIDCARD
     * @return 属性FAMILYFIDCARD的值
     */
    public String getFamilyfidcard(){
        return familyfidcard;
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
     * 设置属性COUNT
     * @param count 待设置的属性COUNT的值
     */
    public void setCount(String count){
        this.count = StringUtils.rightTrim(count);
    }

    /**
     * 获取属性COUNT
     * @return 属性COUNT的值
     */
    public String getCount(){
        return count;
    }

    /**
     * 设置属性UNITAMOUNT
     * @param unitamount 待设置的属性UNITAMOUNT的值
     */
    public void setUnitamount(double unitamount){
        this.unitamount = unitamount;
    }

    /**
     * 获取属性UNITAMOUNT
     * @return 属性UNITAMOUNT的值
     */
    public double getUnitamount(){
        return unitamount;
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
     * 设置属性HANDLERCODE
     * @param handlercode 待设置的属性HANDLERCODE的值
     */
    public void setHandlercode(String handlercode){
        this.handlercode = StringUtils.rightTrim(handlercode);
    }

    /**
     * 获取属性HANDLERCODE
     * @return 属性HANDLERCODE的值
     */
    public String getHandlercode(){
        return handlercode;
    }

    /**
     * 设置属性INPUTDATE
     * @param inputdate 待设置的属性INPUTDATE的值
     */
    public void setInputdate(DateTime inputdate){
        this.inputdate = inputdate;
    }

    /**
     * 获取属性INPUTDATE
     * @return 属性INPUTDATE的值
     */
    public DateTime getInputdate(){
        return inputdate;
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
     * 设置属性FLAG
     * @param flag 待设置的属性FLAG的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性FLAG
     * @return 属性FLAG的值
     */
    public String getFlag(){
        return flag;
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

    /**
     * 设置属性ITEMCODE
     * @param itemcode 待设置的属性ITEMCODE的值
     */
    public void setItemcode(String itemcode){
        this.itemcode = StringUtils.rightTrim(itemcode);
    }

    /**
     * 获取属性ITEMCODE
     * @return 属性ITEMCODE的值
     */
    public String getItemcode(){
        return itemcode;
    }

    /**
     * 设置属性RATE
     * @param rate 待设置的属性RATE的值
     */
    public void setRate(String rate){
        this.rate = StringUtils.rightTrim(rate);
    }

    /**
     * 获取属性RATE
     * @return 属性RATE的值
     */
    public String getRate(){
        return rate;
    }

    /**
     * 设置属性FAMILYFLAG
     * @param familyflag 待设置的属性FAMILYFLAG的值
     */
    public void setFamilyflag(String familyflag){
        this.familyflag = StringUtils.rightTrim(familyflag);
    }

    /**
     * 获取属性FAMILYFLAG
     * @return 属性FAMILYFLAG的值
     */
    public String getFamilyflag(){
        return familyflag;
    }

    /**
     * 设置属性ExportIndex
     * @param exportIndex 待设置的属性ExportIndex的值
     */
    public void setExportIndex(String exportIndex){
        this.exportIndex = StringUtils.rightTrim(exportIndex);
    }

    /**
     * 获取属性ExportIndex
     * @return 属性ExportIndex的值
     */
    public String getExportIndex(){
        return exportIndex;
    }

    /**
     * 设置属性PersonNo
     * @param personNo 待设置的属性PersonNo的值
     */
    public void setPersonNo(String personNo){
        this.personNo = StringUtils.rightTrim(personNo);
    }

    /**
     * 获取属性PersonNo
     * @return 属性PersonNo的值
     */
    public String getPersonNo(){
        return personNo;
    }
}
