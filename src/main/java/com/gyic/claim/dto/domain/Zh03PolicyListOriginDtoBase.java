package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����ZH03PolicyListOrigin�����ݴ���������<br>
 */
public class Zh03PolicyListOriginDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����INUSRELISTCODE */
    private String inusrelistcode = "";
    /** ����INDEXNO */
    private String indexno = "";
    /** ����RISKCODE */
    private String riskcode = "";
    /** ����KINDCODE */
    private String kindcode = "";
    /** ����FAMILYNO */
    private String familyno = "";
    /** ����FAMILYNAME */
    private String familyname = "";
    /** ����FAMILYSEX */
    private String familysex = "";
    /** ����FAMILYFIDCARD */
    private String familyfidcard = "";
    /** ����NAME */
    private String name = "";
    /** ����ADDRESS */
    private String address = "";
    /** ����COUNT */
    private String count = "";
    /** ����UNITAMOUNT */
    private double unitamount = 0D;
    /** ����SUMAMOUNT */
    private double sumamount = 0D;
    /** ����SUMPREMIUM */
    private double sumpremium = 0D;
    /** ����HANDLERCODE */
    private String handlercode = "";
    /** ����INPUTDATE */
    private DateTime inputdate = new DateTime();
    /** ����STARTDATE */
    private DateTime startdate = new DateTime();
    /** ����ENDDATE */
    private DateTime enddate = new DateTime();
    /** ����FLAG */
    private String flag = "";
    /** ����REMARK */
    private String remark = "";
    /** ����ITEMCODE */
    private String itemcode = "";
    /** ����RATE */
    private String rate = "";
    /** ����FAMILYFLAG */
    private String familyflag = "";
    /** ����ExportIndex */
    private String exportIndex = "";
    /** ����PersonNo */
    private String personNo = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�Zh03PolicyListOriginDtoBase����
     */
    public Zh03PolicyListOriginDtoBase(){
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
     * ��������INDEXNO
     * @param indexno �����õ�����INDEXNO��ֵ
     */
    public void setIndexno(String indexno){
        this.indexno = StringUtils.rightTrim(indexno);
    }

    /**
     * ��ȡ����INDEXNO
     * @return ����INDEXNO��ֵ
     */
    public String getIndexno(){
        return indexno;
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
     * ��������FAMILYNO
     * @param familyno �����õ�����FAMILYNO��ֵ
     */
    public void setFamilyno(String familyno){
        this.familyno = StringUtils.rightTrim(familyno);
    }

    /**
     * ��ȡ����FAMILYNO
     * @return ����FAMILYNO��ֵ
     */
    public String getFamilyno(){
        return familyno;
    }

    /**
     * ��������FAMILYNAME
     * @param familyname �����õ�����FAMILYNAME��ֵ
     */
    public void setFamilyname(String familyname){
        this.familyname = StringUtils.rightTrim(familyname);
    }

    /**
     * ��ȡ����FAMILYNAME
     * @return ����FAMILYNAME��ֵ
     */
    public String getFamilyname(){
        return familyname;
    }

    /**
     * ��������FAMILYSEX
     * @param familysex �����õ�����FAMILYSEX��ֵ
     */
    public void setFamilysex(String familysex){
        this.familysex = StringUtils.rightTrim(familysex);
    }

    /**
     * ��ȡ����FAMILYSEX
     * @return ����FAMILYSEX��ֵ
     */
    public String getFamilysex(){
        return familysex;
    }

    /**
     * ��������FAMILYFIDCARD
     * @param familyfidcard �����õ�����FAMILYFIDCARD��ֵ
     */
    public void setFamilyfidcard(String familyfidcard){
        this.familyfidcard = StringUtils.rightTrim(familyfidcard);
    }

    /**
     * ��ȡ����FAMILYFIDCARD
     * @return ����FAMILYFIDCARD��ֵ
     */
    public String getFamilyfidcard(){
        return familyfidcard;
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
     * ��������COUNT
     * @param count �����õ�����COUNT��ֵ
     */
    public void setCount(String count){
        this.count = StringUtils.rightTrim(count);
    }

    /**
     * ��ȡ����COUNT
     * @return ����COUNT��ֵ
     */
    public String getCount(){
        return count;
    }

    /**
     * ��������UNITAMOUNT
     * @param unitamount �����õ�����UNITAMOUNT��ֵ
     */
    public void setUnitamount(double unitamount){
        this.unitamount = unitamount;
    }

    /**
     * ��ȡ����UNITAMOUNT
     * @return ����UNITAMOUNT��ֵ
     */
    public double getUnitamount(){
        return unitamount;
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
     * ��������HANDLERCODE
     * @param handlercode �����õ�����HANDLERCODE��ֵ
     */
    public void setHandlercode(String handlercode){
        this.handlercode = StringUtils.rightTrim(handlercode);
    }

    /**
     * ��ȡ����HANDLERCODE
     * @return ����HANDLERCODE��ֵ
     */
    public String getHandlercode(){
        return handlercode;
    }

    /**
     * ��������INPUTDATE
     * @param inputdate �����õ�����INPUTDATE��ֵ
     */
    public void setInputdate(DateTime inputdate){
        this.inputdate = inputdate;
    }

    /**
     * ��ȡ����INPUTDATE
     * @return ����INPUTDATE��ֵ
     */
    public DateTime getInputdate(){
        return inputdate;
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
     * ��������FLAG
     * @param flag �����õ�����FLAG��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����FLAG
     * @return ����FLAG��ֵ
     */
    public String getFlag(){
        return flag;
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
     * ��������ITEMCODE
     * @param itemcode �����õ�����ITEMCODE��ֵ
     */
    public void setItemcode(String itemcode){
        this.itemcode = StringUtils.rightTrim(itemcode);
    }

    /**
     * ��ȡ����ITEMCODE
     * @return ����ITEMCODE��ֵ
     */
    public String getItemcode(){
        return itemcode;
    }

    /**
     * ��������RATE
     * @param rate �����õ�����RATE��ֵ
     */
    public void setRate(String rate){
        this.rate = StringUtils.rightTrim(rate);
    }

    /**
     * ��ȡ����RATE
     * @return ����RATE��ֵ
     */
    public String getRate(){
        return rate;
    }

    /**
     * ��������FAMILYFLAG
     * @param familyflag �����õ�����FAMILYFLAG��ֵ
     */
    public void setFamilyflag(String familyflag){
        this.familyflag = StringUtils.rightTrim(familyflag);
    }

    /**
     * ��ȡ����FAMILYFLAG
     * @return ����FAMILYFLAG��ֵ
     */
    public String getFamilyflag(){
        return familyflag;
    }

    /**
     * ��������ExportIndex
     * @param exportIndex �����õ�����ExportIndex��ֵ
     */
    public void setExportIndex(String exportIndex){
        this.exportIndex = StringUtils.rightTrim(exportIndex);
    }

    /**
     * ��ȡ����ExportIndex
     * @return ����ExportIndex��ֵ
     */
    public String getExportIndex(){
        return exportIndex;
    }

    /**
     * ��������PersonNo
     * @param personNo �����õ�����PersonNo��ֵ
     */
    public void setPersonNo(String personNo){
        this.personNo = StringUtils.rightTrim(personNo);
    }

    /**
     * ��ȡ����PersonNo
     * @return ����PersonNo��ֵ
     */
    public String getPersonNo(){
        return personNo;
    }
}
