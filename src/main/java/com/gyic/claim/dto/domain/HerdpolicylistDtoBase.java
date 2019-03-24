package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����HERDPOLICYLIST�����ݴ���������<br>
 */
public class HerdpolicylistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����INUSRELISTCODE */
    private String inusrelistcode = "";
    /** ����EARLABEL */
    private String earlabel = "";
    /** ����KINDCODE */
    private String kindcode = "";
    /** ����INDEXCODE */
    private String indexcode = "";
    /** ����FCODE */
    private String fcode = "";
    /** ����FNAME */
    private String fname = "";
    /** ����FIDCARD */
    private String fidcard = "";
    /** ����BREEDINGAREACODE */
    private String breedingareacode = "";
    /** ����SPECIES */
    private String species = "";
    /** ����BREEDINGKIND */
    private String breedingkind = "";
    /** ����BANK */
    private String bank = "";
    /** ����BANKCARD */
    private String bankcard = "";
    /** ����INSURENUMBER */
    private long insurenumber = 0L;
    /** ����AMOUNT */
    private double amount = 0D;
    /** ����RATE */
    private double rate = 0D;
    /** ����SHORTRATEFLAG */
    private String shortrateflag = "";
    /** ����SHORTRATE */
    private double shortrate = 0D;
    /** ����SUMAMOUNT */
    private double sumamount = 0D;
    /** ����SUMPREMIUM */
    private double sumpremium = 0D;
    /** ����STARTDATE */
    private DateTime startdate = new DateTime();
    /** ����ENDDATE */
    private DateTime enddate = new DateTime();
    /** ����CALCULATEFLAG */
    private String calculateflag = "";
    /** ����OPCODE */
    private String opcode = "";
    /** ����OPTIME */
    private DateTime optime = new DateTime();
    /** ����VALIDITY */
    private String validity = "";
    /** ����REMARK */
    private String remark = "";
    /** ����BREEDINGNUMBER */
    private long breedingnumber = 0L;
    /** ����BREEDINGAREANAME */
    private String breedingareaname = "";
    /** ����STARTTIME */
    private String starttime = "";
    /** ����ENDTIME */
    private String endtime = "";
    /** ����PHONE */
    private String phone = "";
    /** ����SETTLENUMBER */
    private long settlenumber = 0L;
    
    private double AreaNumber = 0D;
    
    private String LitterArea = "";
    
    private String fieldsource = "";
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�HerdpolicylistDtoBase����
     */
    public HerdpolicylistDtoBase(){
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
     * ��������SPECIES
     * @param species �����õ�����SPECIES��ֵ
     */
    public void setSpecies(String species){
        this.species = StringUtils.rightTrim(species);
    }

    /**
     * ��ȡ����SPECIES
     * @return ����SPECIES��ֵ
     */
    public String getSpecies(){
        return species;
    }

    /**
     * ��������BREEDINGKIND
     * @param breedingkind �����õ�����BREEDINGKIND��ֵ
     */
    public void setBreedingkind(String breedingkind){
        this.breedingkind = StringUtils.rightTrim(breedingkind);
    }

    /**
     * ��ȡ����BREEDINGKIND
     * @return ����BREEDINGKIND��ֵ
     */
    public String getBreedingkind(){
        return breedingkind;
    }

    /**
     * ��������BANK
     * @param bank �����õ�����BANK��ֵ
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * ��ȡ����BANK
     * @return ����BANK��ֵ
     */
    public String getBank(){
        return bank;
    }

    /**
     * ��������BANKCARD
     * @param bankcard �����õ�����BANKCARD��ֵ
     */
    public void setBankcard(String bankcard){
        this.bankcard = StringUtils.rightTrim(bankcard);
    }

    /**
     * ��ȡ����BANKCARD
     * @return ����BANKCARD��ֵ
     */
    public String getBankcard(){
        return bankcard;
    }

    /**
     * ��������INSURENUMBER
     * @param insurenumber �����õ�����INSURENUMBER��ֵ
     */
    public void setInsurenumber(long insurenumber){
        this.insurenumber = insurenumber;
    }

    /**
     * ��ȡ����INSURENUMBER
     * @return ����INSURENUMBER��ֵ
     */
    public long getInsurenumber(){
        return insurenumber;
    }

    /**
     * ��������AMOUNT
     * @param amount �����õ�����AMOUNT��ֵ
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * ��ȡ����AMOUNT
     * @return ����AMOUNT��ֵ
     */
    public double getAmount(){
        return amount;
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
     * ��������BREEDINGNUMBER
     * @param breedingnumber �����õ�����BREEDINGNUMBER��ֵ
     */
    public void setBreedingnumber(long breedingnumber){
        this.breedingnumber = breedingnumber;
    }

    /**
     * ��ȡ����BREEDINGNUMBER
     * @return ����BREEDINGNUMBER��ֵ
     */
    public long getBreedingnumber(){
        return breedingnumber;
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
     * ��������STARTTIME
     * @param starttime �����õ�����STARTTIME��ֵ
     */
    public void setStarttime(String starttime){
        this.starttime = StringUtils.rightTrim(starttime);
    }

    /**
     * ��ȡ����STARTTIME
     * @return ����STARTTIME��ֵ
     */
    public String getStarttime(){
        return starttime;
    }

    /**
     * ��������ENDTIME
     * @param endtime �����õ�����ENDTIME��ֵ
     */
    public void setEndtime(String endtime){
        this.endtime = StringUtils.rightTrim(endtime);
    }

    /**
     * ��ȡ����ENDTIME
     * @return ����ENDTIME��ֵ
     */
    public String getEndtime(){
        return endtime;
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
     * ��������SETTLENUMBER
     * @param settlenumber �����õ�����SETTLENUMBER��ֵ
     */
    public void setSettlenumber(long settlenumber){
        this.settlenumber = settlenumber;
    }

    /**
     * ��ȡ����SETTLENUMBER
     * @return ����SETTLENUMBER��ֵ
     */
    public long getSettlenumber(){
        return settlenumber;
    }
    
    /**
	 * @return the areaNumber
	 */
	public double getAreaNumber() {
		return AreaNumber;
	}

	/**
	 * @param areaNumber the areaNumber to set
	 */
	public void setAreaNumber(double areaNumber) {
		AreaNumber = areaNumber;
	}

	/**
	 * @return the litterArea
	 */
	public String getLitterArea() {
		return LitterArea;
	}

	/**
	 * @param litterArea the litterArea to set
	 */
	public void setLitterArea(String litterArea) {
		LitterArea = StringUtils.rightTrim(litterArea);
	}
	
    /**
     * ��������FIELDSOURCE
     * @param fieldsource �����õ�����FIELDSOURCE��ֵ
     */
    public void setFieldsource(String fieldsource){
        this.fieldsource = StringUtils.rightTrim(fieldsource);
    }

    /**
     * ��ȡ����FIELDSOURCE
     * @return ����FIELDSOURCE��ֵ
     */
    public String getFieldsource(){
        return fieldsource;
    }
   
}
