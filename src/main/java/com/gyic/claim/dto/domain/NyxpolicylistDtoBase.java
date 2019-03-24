package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXPOLICYLIST�����ݴ���������<br>
 */
public class NyxpolicylistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����INUSRELISTCODE */
    private String inusrelistcode = "";
    /** ����BUSINESSNO */
    private String businessno = "";
    /** ����KINDCODE */
    private String kindcode = "";
    /** ����ITEMCODE */
    private String itemcode = "";
    /** ����INDEXCODE */
    private String indexcode = "";
    /** ����FCODE */
    private String fcode = "";
    /** ����FNAME */
    private String fname = "";
    /** ����ZHIBUKA */
    private String zhibuka = "";
    /** ����PHONE */
    private String phone = "";
    /** ����BANK */
    private String bank = "";
    /** ����BANKCARD */
    private String bankcard = "";
    /** ����INSURENUMBER */
    private long insurenumber = 0L;
    /** ����BREEDINGAREACODE */
    private String breedingareacode = "";
    /** ����SPECIES */
    private String species = "";
    /** ����BREEDINGKIND */
    private String breedingkind = "";
    /** ����BREEDINGNUMBER */
    private long breedingnumber = 0L;
    /** ����BREEDINGAREANAME */
    private String breedingareaname = "";
    /** ����SETTLENUMBER */
    private long settlenumber = 0L;
    /** ����CLASSCODE */
    private String classcode = "";
    /** ����RISKCODE */
    private String riskcode = "";
    /** ����FAREACODE */
    private String fareacode = "";
    /** ����TAXAREA */
    private double taxarea = 0D;
    /** ����INSUREAREA */
    private double insurearea = 0D;
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
    /** ����STARTTIME */
    private String starttime = "";
    /** ����ENDTIME */
    private String endtime = "";
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
    /** ����FPREMIUM */
    private double fpremium = 0D;
    /** ����FIDCARD */
    private String fidcard = "";
    /** ����TEAMNAME */
    private String teamname = "";
    /** ����CENTRALPREMIUM */
    private double centralpremium = 0D;
    /** ����PROVINCEPREMIUM */
    private double provincepremium = 0D;
    /** ����CITYPREMIUM */
    private double citypremium = 0D;
    /** ����TOWNPREMIUM */
    private double townpremium = 0D;
    /** ����OTHERPREMIUM */
    private double otherpremium = 0D;
    /** ����AREANUMBER */
    private double areanumber = 0D;
    /** ����FIELDSOURCE */
    private String fieldsource = "";
    /** ����LITTERAREA */
    private String litterarea = "";
    /** ����ATAREA */
    private String atarea = "";
    /** ����MULCHDATE */
    private String mulchdate = "";
    /** ����MULCHTYPE */
    private String mulchtype = "";
    /** ����WARRANT */
    private String warrant = "";
    /** ����TEMP1 */
    private String temp1 = "";
    /** ����TEMP2 */
    private String temp2 = "";
    /** ����TEMP3 */
    private String temp3 = "";
    /** ����TEMP4 */
    private String temp4 = "";
    /** ����TEMP5 */
    private String temp5 = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�NyxpolicylistDtoBase����
     */
    public NyxpolicylistDtoBase(){
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
     * ��������BUSINESSNO
     * @param businessno �����õ�����BUSINESSNO��ֵ
     */
    public void setBusinessno(String businessno){
        this.businessno = StringUtils.rightTrim(businessno);
    }

    /**
     * ��ȡ����BUSINESSNO
     * @return ����BUSINESSNO��ֵ
     */
    public String getBusinessno(){
        return businessno;
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
     * ��������ZHIBUKA
     * @param zhibuka �����õ�����ZHIBUKA��ֵ
     */
    public void setZhibuka(String zhibuka){
        this.zhibuka = StringUtils.rightTrim(zhibuka);
    }

    /**
     * ��ȡ����ZHIBUKA
     * @return ����ZHIBUKA��ֵ
     */
    public String getZhibuka(){
        return zhibuka;
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
     * ��������CLASSCODE
     * @param classcode �����õ�����CLASSCODE��ֵ
     */
    public void setClasscode(String classcode){
        this.classcode = StringUtils.rightTrim(classcode);
    }

    /**
     * ��ȡ����CLASSCODE
     * @return ����CLASSCODE��ֵ
     */
    public String getClasscode(){
        return classcode;
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
     * ��������FAREACODE
     * @param fareacode �����õ�����FAREACODE��ֵ
     */
    public void setFareacode(String fareacode){
        this.fareacode = StringUtils.rightTrim(fareacode);
    }

    /**
     * ��ȡ����FAREACODE
     * @return ����FAREACODE��ֵ
     */
    public String getFareacode(){
        return fareacode;
    }

    /**
     * ��������TAXAREA
     * @param taxarea �����õ�����TAXAREA��ֵ
     */
    public void setTaxarea(double taxarea){
        this.taxarea = taxarea;
    }

    /**
     * ��ȡ����TAXAREA
     * @return ����TAXAREA��ֵ
     */
    public double getTaxarea(){
        return taxarea;
    }

    /**
     * ��������INSUREAREA
     * @param insurearea �����õ�����INSUREAREA��ֵ
     */
    public void setInsurearea(double insurearea){
        this.insurearea = insurearea;
    }

    /**
     * ��ȡ����INSUREAREA
     * @return ����INSUREAREA��ֵ
     */
    public double getInsurearea(){
        return insurearea;
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
     * ��������FPREMIUM
     * @param fpremium �����õ�����FPREMIUM��ֵ
     */
    public void setFpremium(double fpremium){
        this.fpremium = fpremium;
    }

    /**
     * ��ȡ����FPREMIUM
     * @return ����FPREMIUM��ֵ
     */
    public double getFpremium(){
        return fpremium;
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
     * ��������TEAMNAME
     * @param teamname �����õ�����TEAMNAME��ֵ
     */
    public void setTeamname(String teamname){
        this.teamname = StringUtils.rightTrim(teamname);
    }

    /**
     * ��ȡ����TEAMNAME
     * @return ����TEAMNAME��ֵ
     */
    public String getTeamname(){
        return teamname;
    }

    /**
     * ��������CENTRALPREMIUM
     * @param centralpremium �����õ�����CENTRALPREMIUM��ֵ
     */
    public void setCentralpremium(double centralpremium){
        this.centralpremium = centralpremium;
    }

    /**
     * ��ȡ����CENTRALPREMIUM
     * @return ����CENTRALPREMIUM��ֵ
     */
    public double getCentralpremium(){
        return centralpremium;
    }

    /**
     * ��������PROVINCEPREMIUM
     * @param provincepremium �����õ�����PROVINCEPREMIUM��ֵ
     */
    public void setProvincepremium(double provincepremium){
        this.provincepremium = provincepremium;
    }

    /**
     * ��ȡ����PROVINCEPREMIUM
     * @return ����PROVINCEPREMIUM��ֵ
     */
    public double getProvincepremium(){
        return provincepremium;
    }

    /**
     * ��������CITYPREMIUM
     * @param citypremium �����õ�����CITYPREMIUM��ֵ
     */
    public void setCitypremium(double citypremium){
        this.citypremium = citypremium;
    }

    /**
     * ��ȡ����CITYPREMIUM
     * @return ����CITYPREMIUM��ֵ
     */
    public double getCitypremium(){
        return citypremium;
    }

    /**
     * ��������TOWNPREMIUM
     * @param townpremium �����õ�����TOWNPREMIUM��ֵ
     */
    public void setTownpremium(double townpremium){
        this.townpremium = townpremium;
    }

    /**
     * ��ȡ����TOWNPREMIUM
     * @return ����TOWNPREMIUM��ֵ
     */
    public double getTownpremium(){
        return townpremium;
    }

    /**
     * ��������OTHERPREMIUM
     * @param otherpremium �����õ�����OTHERPREMIUM��ֵ
     */
    public void setOtherpremium(double otherpremium){
        this.otherpremium = otherpremium;
    }

    /**
     * ��ȡ����OTHERPREMIUM
     * @return ����OTHERPREMIUM��ֵ
     */
    public double getOtherpremium(){
        return otherpremium;
    }

    /**
     * ��������AREANUMBER
     * @param areanumber �����õ�����AREANUMBER��ֵ
     */
    public void setAreanumber(double areanumber){
        this.areanumber = areanumber;
    }

    /**
     * ��ȡ����AREANUMBER
     * @return ����AREANUMBER��ֵ
     */
    public double getAreanumber(){
        return areanumber;
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

    /**
     * ��������LITTERAREA
     * @param litterarea �����õ�����LITTERAREA��ֵ
     */
    public void setLitterarea(String litterarea){
        this.litterarea = StringUtils.rightTrim(litterarea);
    }

    /**
     * ��ȡ����LITTERAREA
     * @return ����LITTERAREA��ֵ
     */
    public String getLitterarea(){
        return litterarea;
    }

    /**
     * ��������ATAREA
     * @param atarea �����õ�����ATAREA��ֵ
     */
    public void setAtarea(String atarea){
        this.atarea = StringUtils.rightTrim(atarea);
    }

    /**
     * ��ȡ����ATAREA
     * @return ����ATAREA��ֵ
     */
    public String getAtarea(){
        return atarea;
    }

    /**
     * ��������MULCHDATE
     * @param mulchdate �����õ�����MULCHDATE��ֵ
     */
    public void setMulchdate(String mulchdate){
        this.mulchdate = StringUtils.rightTrim(mulchdate);
    }

    /**
     * ��ȡ����MULCHDATE
     * @return ����MULCHDATE��ֵ
     */
    public String getMulchdate(){
        return mulchdate;
    }

    /**
     * ��������MULCHTYPE
     * @param mulchtype �����õ�����MULCHTYPE��ֵ
     */
    public void setMulchtype(String mulchtype){
        this.mulchtype = StringUtils.rightTrim(mulchtype);
    }

    /**
     * ��ȡ����MULCHTYPE
     * @return ����MULCHTYPE��ֵ
     */
    public String getMulchtype(){
        return mulchtype;
    }

    /**
     * ��������WARRANT
     * @param warrant �����õ�����WARRANT��ֵ
     */
    public void setWarrant(String warrant){
        this.warrant = StringUtils.rightTrim(warrant);
    }

    /**
     * ��ȡ����WARRANT
     * @return ����WARRANT��ֵ
     */
    public String getWarrant(){
        return warrant;
    }

    /**
     * ��������TEMP1
     * @param temp1 �����õ�����TEMP1��ֵ
     */
    public void setTemp1(String temp1){
        this.temp1 = StringUtils.rightTrim(temp1);
    }

    /**
     * ��ȡ����TEMP1
     * @return ����TEMP1��ֵ
     */
    public String getTemp1(){
        return temp1;
    }

    /**
     * ��������TEMP2
     * @param temp2 �����õ�����TEMP2��ֵ
     */
    public void setTemp2(String temp2){
        this.temp2 = StringUtils.rightTrim(temp2);
    }

    /**
     * ��ȡ����TEMP2
     * @return ����TEMP2��ֵ
     */
    public String getTemp2(){
        return temp2;
    }

    /**
     * ��������TEMP3
     * @param temp3 �����õ�����TEMP3��ֵ
     */
    public void setTemp3(String temp3){
        this.temp3 = StringUtils.rightTrim(temp3);
    }

    /**
     * ��ȡ����TEMP3
     * @return ����TEMP3��ֵ
     */
    public String getTemp3(){
        return temp3;
    }

    /**
     * ��������TEMP4
     * @param temp4 �����õ�����TEMP4��ֵ
     */
    public void setTemp4(String temp4){
        this.temp4 = StringUtils.rightTrim(temp4);
    }

    /**
     * ��ȡ����TEMP4
     * @return ����TEMP4��ֵ
     */
    public String getTemp4(){
        return temp4;
    }

    /**
     * ��������TEMP5
     * @param temp5 �����õ�����TEMP5��ֵ
     */
    public void setTemp5(String temp5){
        this.temp5 = StringUtils.rightTrim(temp5);
    }

    /**
     * ��ȡ����TEMP5
     * @return ����TEMP5��ֵ
     */
    public String getTemp5(){
        return temp5;
    }
}
