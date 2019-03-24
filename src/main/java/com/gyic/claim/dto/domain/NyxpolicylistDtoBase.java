package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是NYXPOLICYLIST的数据传输对象基类<br>
 */
public class NyxpolicylistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性INUSRELISTCODE */
    private String inusrelistcode = "";
    /** 属性BUSINESSNO */
    private String businessno = "";
    /** 属性KINDCODE */
    private String kindcode = "";
    /** 属性ITEMCODE */
    private String itemcode = "";
    /** 属性INDEXCODE */
    private String indexcode = "";
    /** 属性FCODE */
    private String fcode = "";
    /** 属性FNAME */
    private String fname = "";
    /** 属性ZHIBUKA */
    private String zhibuka = "";
    /** 属性PHONE */
    private String phone = "";
    /** 属性BANK */
    private String bank = "";
    /** 属性BANKCARD */
    private String bankcard = "";
    /** 属性INSURENUMBER */
    private long insurenumber = 0L;
    /** 属性BREEDINGAREACODE */
    private String breedingareacode = "";
    /** 属性SPECIES */
    private String species = "";
    /** 属性BREEDINGKIND */
    private String breedingkind = "";
    /** 属性BREEDINGNUMBER */
    private long breedingnumber = 0L;
    /** 属性BREEDINGAREANAME */
    private String breedingareaname = "";
    /** 属性SETTLENUMBER */
    private long settlenumber = 0L;
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
    /** 属性STARTTIME */
    private String starttime = "";
    /** 属性ENDTIME */
    private String endtime = "";
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
    /** 属性FIDCARD */
    private String fidcard = "";
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
    /** 属性AREANUMBER */
    private double areanumber = 0D;
    /** 属性FIELDSOURCE */
    private String fieldsource = "";
    /** 属性LITTERAREA */
    private String litterarea = "";
    /** 属性ATAREA */
    private String atarea = "";
    /** 属性MULCHDATE */
    private String mulchdate = "";
    /** 属性MULCHTYPE */
    private String mulchtype = "";
    /** 属性WARRANT */
    private String warrant = "";
    /** 属性TEMP1 */
    private String temp1 = "";
    /** 属性TEMP2 */
    private String temp2 = "";
    /** 属性TEMP3 */
    private String temp3 = "";
    /** 属性TEMP4 */
    private String temp4 = "";
    /** 属性TEMP5 */
    private String temp5 = "";

    /**
     *  默认构造方法,构造一个默认的NyxpolicylistDtoBase对象
     */
    public NyxpolicylistDtoBase(){
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
     * 设置属性BUSINESSNO
     * @param businessno 待设置的属性BUSINESSNO的值
     */
    public void setBusinessno(String businessno){
        this.businessno = StringUtils.rightTrim(businessno);
    }

    /**
     * 获取属性BUSINESSNO
     * @return 属性BUSINESSNO的值
     */
    public String getBusinessno(){
        return businessno;
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
     * 设置属性AREANUMBER
     * @param areanumber 待设置的属性AREANUMBER的值
     */
    public void setAreanumber(double areanumber){
        this.areanumber = areanumber;
    }

    /**
     * 获取属性AREANUMBER
     * @return 属性AREANUMBER的值
     */
    public double getAreanumber(){
        return areanumber;
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
     * 设置属性LITTERAREA
     * @param litterarea 待设置的属性LITTERAREA的值
     */
    public void setLitterarea(String litterarea){
        this.litterarea = StringUtils.rightTrim(litterarea);
    }

    /**
     * 获取属性LITTERAREA
     * @return 属性LITTERAREA的值
     */
    public String getLitterarea(){
        return litterarea;
    }

    /**
     * 设置属性ATAREA
     * @param atarea 待设置的属性ATAREA的值
     */
    public void setAtarea(String atarea){
        this.atarea = StringUtils.rightTrim(atarea);
    }

    /**
     * 获取属性ATAREA
     * @return 属性ATAREA的值
     */
    public String getAtarea(){
        return atarea;
    }

    /**
     * 设置属性MULCHDATE
     * @param mulchdate 待设置的属性MULCHDATE的值
     */
    public void setMulchdate(String mulchdate){
        this.mulchdate = StringUtils.rightTrim(mulchdate);
    }

    /**
     * 获取属性MULCHDATE
     * @return 属性MULCHDATE的值
     */
    public String getMulchdate(){
        return mulchdate;
    }

    /**
     * 设置属性MULCHTYPE
     * @param mulchtype 待设置的属性MULCHTYPE的值
     */
    public void setMulchtype(String mulchtype){
        this.mulchtype = StringUtils.rightTrim(mulchtype);
    }

    /**
     * 获取属性MULCHTYPE
     * @return 属性MULCHTYPE的值
     */
    public String getMulchtype(){
        return mulchtype;
    }

    /**
     * 设置属性WARRANT
     * @param warrant 待设置的属性WARRANT的值
     */
    public void setWarrant(String warrant){
        this.warrant = StringUtils.rightTrim(warrant);
    }

    /**
     * 获取属性WARRANT
     * @return 属性WARRANT的值
     */
    public String getWarrant(){
        return warrant;
    }

    /**
     * 设置属性TEMP1
     * @param temp1 待设置的属性TEMP1的值
     */
    public void setTemp1(String temp1){
        this.temp1 = StringUtils.rightTrim(temp1);
    }

    /**
     * 获取属性TEMP1
     * @return 属性TEMP1的值
     */
    public String getTemp1(){
        return temp1;
    }

    /**
     * 设置属性TEMP2
     * @param temp2 待设置的属性TEMP2的值
     */
    public void setTemp2(String temp2){
        this.temp2 = StringUtils.rightTrim(temp2);
    }

    /**
     * 获取属性TEMP2
     * @return 属性TEMP2的值
     */
    public String getTemp2(){
        return temp2;
    }

    /**
     * 设置属性TEMP3
     * @param temp3 待设置的属性TEMP3的值
     */
    public void setTemp3(String temp3){
        this.temp3 = StringUtils.rightTrim(temp3);
    }

    /**
     * 获取属性TEMP3
     * @return 属性TEMP3的值
     */
    public String getTemp3(){
        return temp3;
    }

    /**
     * 设置属性TEMP4
     * @param temp4 待设置的属性TEMP4的值
     */
    public void setTemp4(String temp4){
        this.temp4 = StringUtils.rightTrim(temp4);
    }

    /**
     * 获取属性TEMP4
     * @return 属性TEMP4的值
     */
    public String getTemp4(){
        return temp4;
    }

    /**
     * 设置属性TEMP5
     * @param temp5 待设置的属性TEMP5的值
     */
    public void setTemp5(String temp5){
        this.temp5 = StringUtils.rightTrim(temp5);
    }

    /**
     * 获取属性TEMP5
     * @return 属性TEMP5的值
     */
    public String getTemp5(){
        return temp5;
    }
}
