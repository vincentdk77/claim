package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����HERDSETTLELIST�����ݴ���������<br>
 */
public class HerdsettlelistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����SETTLELISTCODE */
    private String settlelistcode = "";
    /** ����EARLABEL */
    private String earlabel = "";
    /** ����FCODE */
    private String fcode = "";
    /** ����FNAME */
    private String fname = "";
    /** ����FIDCARD */
    private String fidcard = "";
    /** ����BREEDINGAREACODE */
    private String breedingareacode = "";
    /** ����BREEDINGAREANAME */
    private String breedingareaname = "";
    /** ����BANKNAME */
    private String bankname = "";
    /** ����BANKACCOUNT */
    private String bankaccount = "";
    /** ����DAMAGETIME */
    private String damagetime = "";
    /** ����REPORTTIME */
    private String reporttime = "";
    /** ����DEADREASON */
    private String deadreason = "";
    /** ����DEADNUMBER */
    private int deadnumber = 0;
    /** ����CULLNUMBER */
    private int cullnumber = 0;
    /** ����SETTLEAMOUNT */
    private int settleamount = 0;
    /** ����OPCODE */
    private String opcode = "";
    /** ����OPTIME */
    private DateTime optime = new DateTime();
    /** ����VALIDITY */
    private String validity = "";
    /** ����REMARK */
    private String remark = "";
    /** ����INSURELISTCODE */
    private String insurelistcode = "";
    /** ����KINDCODE */
    private String kindcode = "";
    /** ����SERIALNO */
    private int serialno = 0;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�HerdsettlelistDtoBase����
     */
    public HerdsettlelistDtoBase(){
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
     * ��������EARLABEL
     * @param earlabel �����õ�����EARLABEL��ֵ
     */
    public void setEarlabel(String earlabel){
        this.earlabel = StringUtils.rightTrim(earlabel);
    }

    /**
     * ��ȡ����EARLABEL
     * @return ����EARLABEL��ֵ
     */
    public String getEarlabel(){
        return earlabel;
    }

    /**
     * ��������FCODE
     * @param fcode �����õ�����FCODE��ֵ
     */
    public void setFcode(String fcode){
        this.fcode = StringUtils.rightTrim(fcode);
    }

    /**
     * ��ȡ����FCODE
     * @return ����FCODE��ֵ
     */
    public String getFcode(){
        return fcode;
    }

    /**
     * ��������FNAME
     * @param fname �����õ�����FNAME��ֵ
     */
    public void setFname(String fname){
        this.fname = StringUtils.rightTrim(fname);
    }

    /**
     * ��ȡ����FNAME
     * @return ����FNAME��ֵ
     */
    public String getFname(){
        return fname;
    }

    /**
     * ��������FIDCARD
     * @param fidcard �����õ�����FIDCARD��ֵ
     */
    public void setFidcard(String fidcard){
        this.fidcard = StringUtils.rightTrim(fidcard);
    }

    /**
     * ��ȡ����FIDCARD
     * @return ����FIDCARD��ֵ
     */
    public String getFidcard(){
        return fidcard;
    }

    /**
     * ��������BREEDINGAREACODE
     * @param breedingareacode �����õ�����BREEDINGAREACODE��ֵ
     */
    public void setBreedingareacode(String breedingareacode){
        this.breedingareacode = StringUtils.rightTrim(breedingareacode);
    }

    /**
     * ��ȡ����BREEDINGAREACODE
     * @return ����BREEDINGAREACODE��ֵ
     */
    public String getBreedingareacode(){
        return breedingareacode;
    }

    /**
     * ��������BREEDINGAREANAME
     * @param breedingareaname �����õ�����BREEDINGAREANAME��ֵ
     */
    public void setBreedingareaname(String breedingareaname){
        this.breedingareaname = StringUtils.rightTrim(breedingareaname);
    }

    /**
     * ��ȡ����BREEDINGAREANAME
     * @return ����BREEDINGAREANAME��ֵ
     */
    public String getBreedingareaname(){
        return breedingareaname;
    }

    /**
     * ��������BANKNAME
     * @param bankname �����õ�����BANKNAME��ֵ
     */
    public void setBankname(String bankname){
        this.bankname = StringUtils.rightTrim(bankname);
    }

    /**
     * ��ȡ����BANKNAME
     * @return ����BANKNAME��ֵ
     */
    public String getBankname(){
        return bankname;
    }

    /**
     * ��������BANKACCOUNT
     * @param bankaccount �����õ�����BANKACCOUNT��ֵ
     */
    public void setBankaccount(String bankaccount){
        this.bankaccount = StringUtils.rightTrim(bankaccount);
    }

    /**
     * ��ȡ����BANKACCOUNT
     * @return ����BANKACCOUNT��ֵ
     */
    public String getBankaccount(){
        return bankaccount;
    }

    /**
     * ��������DAMAGETIME
     * @param damagetime �����õ�����DAMAGETIME��ֵ
     */
    public void setDamagetime(String damagetime){
        this.damagetime = StringUtils.rightTrim(damagetime);
    }

    /**
     * ��ȡ����DAMAGETIME
     * @return ����DAMAGETIME��ֵ
     */
    public String getDamagetime(){
        return damagetime;
    }

    /**
     * ��������REPORTTIME
     * @param reporttime �����õ�����REPORTTIME��ֵ
     */
    public void setReporttime(String reporttime){
        this.reporttime = StringUtils.rightTrim(reporttime);
    }

    /**
     * ��ȡ����REPORTTIME
     * @return ����REPORTTIME��ֵ
     */
    public String getReporttime(){
        return reporttime;
    }

    /**
     * ��������DEADREASON
     * @param deadreason �����õ�����DEADREASON��ֵ
     */
    public void setDeadreason(String deadreason){
        this.deadreason = StringUtils.rightTrim(deadreason);
    }

    /**
     * ��ȡ����DEADREASON
     * @return ����DEADREASON��ֵ
     */
    public String getDeadreason(){
        return deadreason;
    }

    /**
     * ��������DEADNUMBER
     * @param deadnumber �����õ�����DEADNUMBER��ֵ
     */
    public void setDeadnumber(int deadnumber){
        this.deadnumber = deadnumber;
    }

    /**
     * ��ȡ����DEADNUMBER
     * @return ����DEADNUMBER��ֵ
     */
    public int getDeadnumber(){
        return deadnumber;
    }

    /**
     * ��������CULLNUMBER
     * @param cullnumber �����õ�����CULLNUMBER��ֵ
     */
    public void setCullnumber(int cullnumber){
        this.cullnumber = cullnumber;
    }

    /**
     * ��ȡ����CULLNUMBER
     * @return ����CULLNUMBER��ֵ
     */
    public int getCullnumber(){
        return cullnumber;
    }

    /**
     * ��������SETTLEAMOUNT
     * @param settleamount �����õ�����SETTLEAMOUNT��ֵ
     */
    public void setSettleamount(int settleamount){
        this.settleamount = settleamount;
    }

    /**
     * ��ȡ����SETTLEAMOUNT
     * @return ����SETTLEAMOUNT��ֵ
     */
    public int getSettleamount(){
        return settleamount;
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
     * ��������INSURELISTCODE
     * @param insurelistcode �����õ�����INSURELISTCODE��ֵ
     */
    public void setInsurelistcode(String insurelistcode){
        this.insurelistcode = StringUtils.rightTrim(insurelistcode);
    }

    /**
     * ��ȡ����INSURELISTCODE
     * @return ����INSURELISTCODE��ֵ
     */
    public String getInsurelistcode(){
        return insurelistcode;
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
     * ��������SERIALNO
     * @param serialno �����õ�����SERIALNO��ֵ
     */
    public void setSerialno(int serialno){
        this.serialno = serialno;
    }

    /**
     * ��ȡ����SERIALNO
     * @return ����SERIALNO��ֵ
     */
    public int getSerialno(){
        return serialno;
    }
}
