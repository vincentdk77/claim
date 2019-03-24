package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PLANTINGPOLICYLIST的数据传输对象基类<br>
 */
public class PlantingpolicylistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性INUSRELISTCODE */
    private String inusrelistcode = "";
    /** 属性FCODE */
    private String fcode = "";
    /** 属性KINDCODE */
    private String kindcode = "";
    /** 属性INDEXCODE */
    private String indexcode = "";
    /** 属性PHONE */
    private String phone = "";
    /** 属性BANK */
    private String bank = "";
    /** 属性ZHIBUKA */
    private String zhibuka = "";
    /** 属性FNAME */
    private String fname = "";
    /** 属性FIDCARD */
    private String fidcard = "";
    /** 属性CLASSCODE */
    private String classcode = "";
    /** 属性RISKCODE */
    private String riskcode = "";
    /** 属性FAREACODE */
    private String fareacode = "";
    /** 属性TAXAREA */
    private double taxarea = 0D;
    /** 属性INSUREAREA */
    private double insurearea = 0D;
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
    /** 属性FPREMIUM */
    private double fpremium = 0D;
    /** 属性TEAMNAME */
    private String teamname = "";
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
    /** 属性FIELDSOURCE */
    private String fieldsource = "";
    /** 属性WARRANT 林权证*/
    private String Warrant= "";
    
    private String LitterArea = "";
    
    private String Atarea = "";
    
    
    //实有林地
    private double WoodlandArea= 0D;

    /**
     *  默认构造方法,构造一个默认的PlantingpolicylistDtoBase对象
     */
    public PlantingpolicylistDtoBase(){
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
     * 设置属性ZHIBUKA
     * @param zhibuka 待设置的属性ZHIBUKA的值
     */
    public void setZhibuka(String zhibuka){
        this.zhibuka = StringUtils.rightTrim(zhibuka);
    }

    /**
     * 获取属性ZHIBUKA
     * @return 属性ZHIBUKA的值
     */
    public String getZhibuka(){
        return zhibuka;
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
     * 设置属性FAREACODE
     * @param fareacode 待设置的属性FAREACODE的值
     */
    public void setFareacode(String fareacode){
        this.fareacode = StringUtils.rightTrim(fareacode);
    }

    /**
     * 获取属性FAREACODE
     * @return 属性FAREACODE的值
     */
    public String getFareacode(){
        return fareacode;
    }

    /**
     * 设置属性TAXAREA
     * @param taxarea 待设置的属性TAXAREA的值
     */
    public void setTaxarea(double taxarea){
        this.taxarea = taxarea;
    }

    /**
     * 获取属性TAXAREA
     * @return 属性TAXAREA的值
     */
    public double getTaxarea(){
        return taxarea;
    }

    /**
     * 设置属性INSUREAREA
     * @param insurearea 待设置的属性INSUREAREA的值
     */
    public void setInsurearea(double insurearea){
        this.insurearea = insurearea;
    }

    /**
     * 获取属性INSUREAREA
     * @return 属性INSUREAREA的值
     */
    public double getInsurearea(){
        return insurearea;
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
     * 设置属性TEAMNAME
     * @param teamname 待设置的属性TEAMNAME的值
     */
    public void setTeamname(String teamname){
        this.teamname = StringUtils.rightTrim(teamname);
    }

    /**
     * 获取属性TEAMNAME
     * @return 属性TEAMNAME的值
     */
    public String getTeamname(){
        return teamname;
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
    /**
     * 获取属性WARRANT
     * @return 属性WARRANT的值
     */
    public String getWarrant(){
        return Warrant;
    }
    /**
     * 设置属性STRINGTIMESTAMP
     * @param stringtimestamp 待设置的属性STRINGTIMESTAMP的值
     */
    public void setWarrant(String Warrant){
        this.Warrant = StringUtils.rightTrim(Warrant);
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
	 * @return the litterArea
	 */
	public String getAtarea() {
		return Atarea;
	}

	/**
	 * @param litterArea the litterArea to set
	 */
	public void setAtarea(String Atarea) {
		this.Atarea = StringUtils.rightTrim(Atarea);
	}

	/**
	 * @return the woodlandArea
	 */
	public double getWoodlandArea() {
		return WoodlandArea;
	}

	/**
	 * @param woodlandArea the woodlandArea to set
	 */
	public void setWoodlandArea(double woodlandArea) {
		WoodlandArea = woodlandArea;
	}
}
