package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是HERDSETTLELIST的数据传输对象基类<br>
 */
public class HerdsettlelistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性SETTLELISTCODE */
    private String settlelistcode = "";
    /** 属性EARLABEL */
    private String earlabel = "";
    /** 属性FCODE */
    private String fcode = "";
    /** 属性FNAME */
    private String fname = "";
    /** 属性FIDCARD */
    private String fidcard = "";
    /** 属性BREEDINGAREACODE */
    private String breedingareacode = "";
    /** 属性BREEDINGAREANAME */
    private String breedingareaname = "";
    /** 属性BANKNAME */
    private String bankname = "";
    /** 属性BANKACCOUNT */
    private String bankaccount = "";
    /** 属性DAMAGETIME */
    private String damagetime = "";
    /** 属性REPORTTIME */
    private String reporttime = "";
    /** 属性DEADREASON */
    private String deadreason = "";
    /** 属性DEADNUMBER */
    private int deadnumber = 0;
    /** 属性CULLNUMBER */
    private int cullnumber = 0;
    /** 属性SETTLEAMOUNT */
    private int settleamount = 0;
    /** 属性OPCODE */
    private String opcode = "";
    /** 属性OPTIME */
    private DateTime optime = new DateTime();
    /** 属性VALIDITY */
    private String validity = "";
    /** 属性REMARK */
    private String remark = "";
    /** 属性INSURELISTCODE */
    private String insurelistcode = "";
    /** 属性KINDCODE */
    private String kindcode = "";
    /** 属性SERIALNO */
    private int serialno = 0;

    /**
     *  默认构造方法,构造一个默认的HerdsettlelistDtoBase对象
     */
    public HerdsettlelistDtoBase(){
    }

    /**
     * 设置属性SETTLELISTCODE
     * @param settlelistcode 待设置的属性SETTLELISTCODE的值
     */
    public void setSettlelistcode(String settlelistcode){
        this.settlelistcode = StringUtils.rightTrim(settlelistcode);
    }

    /**
     * 获取属性SETTLELISTCODE
     * @return 属性SETTLELISTCODE的值
     */
    public String getSettlelistcode(){
        return settlelistcode;
    }

    /**
     * 设置属性EARLABEL
     * @param earlabel 待设置的属性EARLABEL的值
     */
    public void setEarlabel(String earlabel){
        this.earlabel = StringUtils.rightTrim(earlabel);
    }

    /**
     * 获取属性EARLABEL
     * @return 属性EARLABEL的值
     */
    public String getEarlabel(){
        return earlabel;
    }

    /**
     * 设置属性FCODE
     * @param fcode 待设置的属性FCODE的值
     */
    public void setFcode(String fcode){
        this.fcode = StringUtils.rightTrim(fcode);
    }

    /**
     * 获取属性FCODE
     * @return 属性FCODE的值
     */
    public String getFcode(){
        return fcode;
    }

    /**
     * 设置属性FNAME
     * @param fname 待设置的属性FNAME的值
     */
    public void setFname(String fname){
        this.fname = StringUtils.rightTrim(fname);
    }

    /**
     * 获取属性FNAME
     * @return 属性FNAME的值
     */
    public String getFname(){
        return fname;
    }

    /**
     * 设置属性FIDCARD
     * @param fidcard 待设置的属性FIDCARD的值
     */
    public void setFidcard(String fidcard){
        this.fidcard = StringUtils.rightTrim(fidcard);
    }

    /**
     * 获取属性FIDCARD
     * @return 属性FIDCARD的值
     */
    public String getFidcard(){
        return fidcard;
    }

    /**
     * 设置属性BREEDINGAREACODE
     * @param breedingareacode 待设置的属性BREEDINGAREACODE的值
     */
    public void setBreedingareacode(String breedingareacode){
        this.breedingareacode = StringUtils.rightTrim(breedingareacode);
    }

    /**
     * 获取属性BREEDINGAREACODE
     * @return 属性BREEDINGAREACODE的值
     */
    public String getBreedingareacode(){
        return breedingareacode;
    }

    /**
     * 设置属性BREEDINGAREANAME
     * @param breedingareaname 待设置的属性BREEDINGAREANAME的值
     */
    public void setBreedingareaname(String breedingareaname){
        this.breedingareaname = StringUtils.rightTrim(breedingareaname);
    }

    /**
     * 获取属性BREEDINGAREANAME
     * @return 属性BREEDINGAREANAME的值
     */
    public String getBreedingareaname(){
        return breedingareaname;
    }

    /**
     * 设置属性BANKNAME
     * @param bankname 待设置的属性BANKNAME的值
     */
    public void setBankname(String bankname){
        this.bankname = StringUtils.rightTrim(bankname);
    }

    /**
     * 获取属性BANKNAME
     * @return 属性BANKNAME的值
     */
    public String getBankname(){
        return bankname;
    }

    /**
     * 设置属性BANKACCOUNT
     * @param bankaccount 待设置的属性BANKACCOUNT的值
     */
    public void setBankaccount(String bankaccount){
        this.bankaccount = StringUtils.rightTrim(bankaccount);
    }

    /**
     * 获取属性BANKACCOUNT
     * @return 属性BANKACCOUNT的值
     */
    public String getBankaccount(){
        return bankaccount;
    }

    /**
     * 设置属性DAMAGETIME
     * @param damagetime 待设置的属性DAMAGETIME的值
     */
    public void setDamagetime(String damagetime){
        this.damagetime = StringUtils.rightTrim(damagetime);
    }

    /**
     * 获取属性DAMAGETIME
     * @return 属性DAMAGETIME的值
     */
    public String getDamagetime(){
        return damagetime;
    }

    /**
     * 设置属性REPORTTIME
     * @param reporttime 待设置的属性REPORTTIME的值
     */
    public void setReporttime(String reporttime){
        this.reporttime = StringUtils.rightTrim(reporttime);
    }

    /**
     * 获取属性REPORTTIME
     * @return 属性REPORTTIME的值
     */
    public String getReporttime(){
        return reporttime;
    }

    /**
     * 设置属性DEADREASON
     * @param deadreason 待设置的属性DEADREASON的值
     */
    public void setDeadreason(String deadreason){
        this.deadreason = StringUtils.rightTrim(deadreason);
    }

    /**
     * 获取属性DEADREASON
     * @return 属性DEADREASON的值
     */
    public String getDeadreason(){
        return deadreason;
    }

    /**
     * 设置属性DEADNUMBER
     * @param deadnumber 待设置的属性DEADNUMBER的值
     */
    public void setDeadnumber(int deadnumber){
        this.deadnumber = deadnumber;
    }

    /**
     * 获取属性DEADNUMBER
     * @return 属性DEADNUMBER的值
     */
    public int getDeadnumber(){
        return deadnumber;
    }

    /**
     * 设置属性CULLNUMBER
     * @param cullnumber 待设置的属性CULLNUMBER的值
     */
    public void setCullnumber(int cullnumber){
        this.cullnumber = cullnumber;
    }

    /**
     * 获取属性CULLNUMBER
     * @return 属性CULLNUMBER的值
     */
    public int getCullnumber(){
        return cullnumber;
    }

    /**
     * 设置属性SETTLEAMOUNT
     * @param settleamount 待设置的属性SETTLEAMOUNT的值
     */
    public void setSettleamount(int settleamount){
        this.settleamount = settleamount;
    }

    /**
     * 获取属性SETTLEAMOUNT
     * @return 属性SETTLEAMOUNT的值
     */
    public int getSettleamount(){
        return settleamount;
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
     * 设置属性INSURELISTCODE
     * @param insurelistcode 待设置的属性INSURELISTCODE的值
     */
    public void setInsurelistcode(String insurelistcode){
        this.insurelistcode = StringUtils.rightTrim(insurelistcode);
    }

    /**
     * 获取属性INSURELISTCODE
     * @return 属性INSURELISTCODE的值
     */
    public String getInsurelistcode(){
        return insurelistcode;
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
     * 设置属性SERIALNO
     * @param serialno 待设置的属性SERIALNO的值
     */
    public void setSerialno(int serialno){
        this.serialno = serialno;
    }

    /**
     * 获取属性SERIALNO
     * @return 属性SERIALNO的值
     */
    public int getSerialno(){
        return serialno;
    }
}
