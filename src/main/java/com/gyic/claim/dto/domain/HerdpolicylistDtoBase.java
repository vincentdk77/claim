package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是HERDPOLICYLIST的数据传输对象基类<br>
 */
public class HerdpolicylistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性INUSRELISTCODE */
    private String inusrelistcode = "";
    /** 属性EARLABEL */
    private String earlabel = "";
    /** 属性KINDCODE */
    private String kindcode = "";
    /** 属性INDEXCODE */
    private String indexcode = "";
    /** 属性FCODE */
    private String fcode = "";
    /** 属性FNAME */
    private String fname = "";
    /** 属性FIDCARD */
    private String fidcard = "";
    /** 属性BREEDINGAREACODE */
    private String breedingareacode = "";
    /** 属性SPECIES */
    private String species = "";
    /** 属性BREEDINGKIND */
    private String breedingkind = "";
    /** 属性BANK */
    private String bank = "";
    /** 属性BANKCARD */
    private String bankcard = "";
    /** 属性INSURENUMBER */
    private long insurenumber = 0L;
    /** 属性AMOUNT */
    private double amount = 0D;
    /** 属性RATE */
    private double rate = 0D;
    /** 属性SHORTRATEFLAG */
    private String shortrateflag = "";
    /** 属性SHORTRATE */
    private double shortrate = 0D;
    /** 属性SUMAMOUNT */
    private double sumamount = 0D;
    /** 属性SUMPREMIUM */
    private double sumpremium = 0D;
    /** 属性STARTDATE */
    private DateTime startdate = new DateTime();
    /** 属性ENDDATE */
    private DateTime enddate = new DateTime();
    /** 属性CALCULATEFLAG */
    private String calculateflag = "";
    /** 属性OPCODE */
    private String opcode = "";
    /** 属性OPTIME */
    private DateTime optime = new DateTime();
    /** 属性VALIDITY */
    private String validity = "";
    /** 属性REMARK */
    private String remark = "";
    /** 属性BREEDINGNUMBER */
    private long breedingnumber = 0L;
    /** 属性BREEDINGAREANAME */
    private String breedingareaname = "";
    /** 属性STARTTIME */
    private String starttime = "";
    /** 属性ENDTIME */
    private String endtime = "";
    /** 属性PHONE */
    private String phone = "";
    /** 属性SETTLENUMBER */
    private long settlenumber = 0L;
    
    private double AreaNumber = 0D;
    
    private String LitterArea = "";
    
    private String fieldsource = "";
    /**
     *  默认构造方法,构造一个默认的HerdpolicylistDtoBase对象
     */
    public HerdpolicylistDtoBase(){
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
     * 设置属性SPECIES
     * @param species 待设置的属性SPECIES的值
     */
    public void setSpecies(String species){
        this.species = StringUtils.rightTrim(species);
    }

    /**
     * 获取属性SPECIES
     * @return 属性SPECIES的值
     */
    public String getSpecies(){
        return species;
    }

    /**
     * 设置属性BREEDINGKIND
     * @param breedingkind 待设置的属性BREEDINGKIND的值
     */
    public void setBreedingkind(String breedingkind){
        this.breedingkind = StringUtils.rightTrim(breedingkind);
    }

    /**
     * 获取属性BREEDINGKIND
     * @return 属性BREEDINGKIND的值
     */
    public String getBreedingkind(){
        return breedingkind;
    }

    /**
     * 设置属性BANK
     * @param bank 待设置的属性BANK的值
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * 获取属性BANK
     * @return 属性BANK的值
     */
    public String getBank(){
        return bank;
    }

    /**
     * 设置属性BANKCARD
     * @param bankcard 待设置的属性BANKCARD的值
     */
    public void setBankcard(String bankcard){
        this.bankcard = StringUtils.rightTrim(bankcard);
    }

    /**
     * 获取属性BANKCARD
     * @return 属性BANKCARD的值
     */
    public String getBankcard(){
        return bankcard;
    }

    /**
     * 设置属性INSURENUMBER
     * @param insurenumber 待设置的属性INSURENUMBER的值
     */
    public void setInsurenumber(long insurenumber){
        this.insurenumber = insurenumber;
    }

    /**
     * 获取属性INSURENUMBER
     * @return 属性INSURENUMBER的值
     */
    public long getInsurenumber(){
        return insurenumber;
    }

    /**
     * 设置属性AMOUNT
     * @param amount 待设置的属性AMOUNT的值
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * 获取属性AMOUNT
     * @return 属性AMOUNT的值
     */
    public double getAmount(){
        return amount;
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
     * 设置属性BREEDINGNUMBER
     * @param breedingnumber 待设置的属性BREEDINGNUMBER的值
     */
    public void setBreedingnumber(long breedingnumber){
        this.breedingnumber = breedingnumber;
    }

    /**
     * 获取属性BREEDINGNUMBER
     * @return 属性BREEDINGNUMBER的值
     */
    public long getBreedingnumber(){
        return breedingnumber;
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
     * 设置属性STARTTIME
     * @param starttime 待设置的属性STARTTIME的值
     */
    public void setStarttime(String starttime){
        this.starttime = StringUtils.rightTrim(starttime);
    }

    /**
     * 获取属性STARTTIME
     * @return 属性STARTTIME的值
     */
    public String getStarttime(){
        return starttime;
    }

    /**
     * 设置属性ENDTIME
     * @param endtime 待设置的属性ENDTIME的值
     */
    public void setEndtime(String endtime){
        this.endtime = StringUtils.rightTrim(endtime);
    }

    /**
     * 获取属性ENDTIME
     * @return 属性ENDTIME的值
     */
    public String getEndtime(){
        return endtime;
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
     * 设置属性SETTLENUMBER
     * @param settlenumber 待设置的属性SETTLENUMBER的值
     */
    public void setSettlenumber(long settlenumber){
        this.settlenumber = settlenumber;
    }

    /**
     * 获取属性SETTLENUMBER
     * @return 属性SETTLENUMBER的值
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
     * 设置属性FIELDSOURCE
     * @param fieldsource 待设置的属性FIELDSOURCE的值
     */
    public void setFieldsource(String fieldsource){
        this.fieldsource = StringUtils.rightTrim(fieldsource);
    }

    /**
     * 获取属性FIELDSOURCE
     * @return 属性FIELDSOURCE的值
     */
    public String getFieldsource(){
        return fieldsource;
    }
   
}
