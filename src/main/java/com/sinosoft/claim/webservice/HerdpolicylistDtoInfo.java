package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

public class HerdpolicylistDtoInfo implements Serializable{

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
    private String insurenumber = "0";
    /** ����AMOUNT */
    private String amount = "0";
    /** ����RATE */
    private String rate = "0";
    /** ����SHORTRATEFLAG */
    private String shortrateflag = "";
    /** ����SHORTRATE */
    private String shortrate = "0";
    /** ����SUMAMOUNT */
    private String sumamount = "0";
    /** ����SUMPREMIUM */
    private String sumpremium = "0";
    /** ����STARTDATE */
    private Date startdate = new Date();
    /** ����ENDDATE */
    private Date enddate = new Date();
    /** ����CALCULATEFLAG */
    private String calculateflag = "";
    /** ����OPCODE */
    private String opcode = "";
    /** ����OPTIME */
    private Date optime = new Date();
    /** ����VALIDITY */
    private String validity = "";
    /** ����REMARK */
    private String remark = "";
    /** ����BREEDINGNUMBER */
    private String breedingnumber = "0";
    /** ����BREEDINGAREANAME */
    private String breedingareaname = "";
    /** ����STARTTIME */
    private String starttime = "";
    /** ����ENDTIME */
    private String endtime = "";
    /** ����PHONE */
    private String phone = "";
    /** ����SETTLENUMBER */
    private String settlenumber = "0";
    /** ���������� */
    private String businessAreaName = "";
    
    private String processing ="";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�HerdpolicylistDtoBase����
     */
    public HerdpolicylistDtoInfo(){
    }

		
    

	public HerdpolicylistDtoInfo(String inusrelistcode, String earlabel,
			String kindcode,String fidcard ,String bankcard, String fcode, String fname,
			String breedingareacode, String bank, String amount,
			String sumamount, String breedingareaname) {
		super();
		this.inusrelistcode = inusrelistcode;
		this.earlabel = earlabel;
		this.kindcode = kindcode;
		this.fidcard = fidcard;
		this.bankcard = bankcard;
		this.fcode = fcode;
		this.fname = fname;
		this.breedingareacode = breedingareacode;
		this.bank = bank;
		this.amount = amount;
		this.sumamount = sumamount;
		this.breedingareaname = breedingareaname;
	}
	public HerdpolicylistDtoInfo(String inusrelistcode, String earlabel,
			String kindcode,String fidcard ,String bankcard, String fcode, String fname,
			String breedingareacode, String bank, String amount,
			String sumamount, String breedingareaname,String businessAreaName) {
		super();
		this.inusrelistcode = inusrelistcode;
		this.earlabel = earlabel;
		this.kindcode = kindcode;
		this.fidcard = fidcard;
		this.bankcard = bankcard;
		this.fcode = fcode;
		this.fname = fname;
		this.breedingareacode = breedingareacode;
		this.bank = bank;
		this.amount = amount;
		this.sumamount = sumamount;
		this.breedingareaname = breedingareaname;
		this.businessAreaName = businessAreaName;
	}
	public HerdpolicylistDtoInfo(String inusrelistcode, String earlabel,
			String kindcode,String fidcard ,String bankcard, String fcode, String fname,
			String breedingareacode, String bank, String amount,
			String sumamount, String breedingareaname,String businessAreaName,String processing) {
		super();
		this.inusrelistcode = inusrelistcode;
		this.earlabel = earlabel;
		this.kindcode = kindcode;
		this.fidcard = fidcard;
		this.bankcard = bankcard;
		this.fcode = fcode;
		this.fname = fname;
		this.breedingareacode = breedingareacode;
		this.bank = bank;
		this.amount = amount;
		this.sumamount = sumamount;
		this.breedingareaname = breedingareaname;
		this.businessAreaName = businessAreaName;
		this.processing = processing;
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
    public void setInsurenumber(String insurenumber){
        this.insurenumber = insurenumber;
    }

    /**
     * ��ȡ����INSURENUMBER
     * @return ����INSURENUMBER��ֵ
     */
    public String getInsurenumber(){
        return insurenumber;
    }

    /**
     * ��������AMOUNT
     * @param amount �����õ�����AMOUNT��ֵ
     */
    public void setAmount(String amount){
        this.amount = amount;
    }

    /**
     * ��ȡ����AMOUNT
     * @return ����AMOUNT��ֵ
     */
    public String getAmount(){
        return amount;
    }

    /**
     * ��������RATE
     * @param rate �����õ�����RATE��ֵ
     */
    public void setRate(String rate){
        this.rate = rate;
    }

    /**
     * ��ȡ����RATE
     * @return ����RATE��ֵ
     */
    public String getRate(){
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
    public void setShortrate(String shortrate){
        this.shortrate = shortrate;
    }

    /**
     * ��ȡ����SHORTRATE
     * @return ����SHORTRATE��ֵ
     */
    public String getShortrate(){
        return shortrate;
    }

    /**
     * ��������SUMAMOUNT
     * @param sumamount �����õ�����SUMAMOUNT��ֵ
     */
    public void setSumamount(String sumamount){
        this.sumamount = sumamount;
    }

    /**
     * ��ȡ����SUMAMOUNT
     * @return ����SUMAMOUNT��ֵ
     */
    public String getSumamount(){
        return sumamount;
    }

    /**
     * ��������SUMPREMIUM
     * @param sumpremium �����õ�����SUMPREMIUM��ֵ
     */
    public void setSumpremium(String sumpremium){
        this.sumpremium = sumpremium;
    }

    /**
     * ��ȡ����SUMPREMIUM
     * @return ����SUMPREMIUM��ֵ
     */
    public String getSumpremium(){
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
     * ��������ENDDATE
     * @param enddate �����õ�����ENDDATE��ֵ
     */
    public void setEnddate(DateTime enddate){
        this.enddate = enddate;
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
    public void setBreedingnumber(String breedingnumber){
        this.breedingnumber = breedingnumber;
    }

    /**
     * ��ȡ����BREEDINGNUMBER
     * @return ����BREEDINGNUMBER��ֵ
     */
    public String getBreedingnumber(){
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
    public void setSettlenumber(String settlenumber){
        this.settlenumber = settlenumber;
    }

    /**
     * ��ȡ����SETTLENUMBER
     * @return ����SETTLENUMBER��ֵ
     */
    public String getSettlenumber(){
        return settlenumber;
    }

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Date getOptime() {
		return optime;
	}

	public void setOptime(Date optime) {
		this.optime = optime;
	}




	




	public String getBusinessAreaName() {
		return businessAreaName;
	}




	public void setBusinessAreaName(String businessAreaName) {
		this.businessAreaName = businessAreaName;
	}




	public String getProcessing() {
		return processing;
	}




	public void setProcessing(String processing) {
		this.processing = processing;
	}
	

	

	
   
}
