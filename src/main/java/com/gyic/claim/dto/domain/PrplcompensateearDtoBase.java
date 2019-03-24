package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是Prplcompensateear的数据传输对象基类<br>
 */
public class PrplcompensateearDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性EARNO */
    private String earno = "";
    /** 属性POLICYNO */
    private String policyno = "";
    /** 属性REGISTNO */
    private String registno = "";
    /** 属性CLAIMNO */
    private String claimno = "";
    /** 属性COMPENSATENO */
    private String compensateno = "";
    /** 属性COMBINENO */
    private String combineno = "";
    /** 属性CASENO */
    private String caseno = "";
    /** 属性DAMAGESTARTDATE */
    private DateTime damagestartdate = new DateTime();
    /** 属性DAMAGESTARTHOUR */
    private String damagestarthour = "";
    /** 属性DAMAGEENDDATE */
    private DateTime damageenddate = new DateTime();
    /** 属性DAMAGECODE */
    private String damagecode = "";
    /** 属性DAMAGENAME */
    private String damagename = "";
    /** 属性NAME */
    private String name = "";
    /** 属性ID_CARD */
    private String id_card = "";
    /** 属性BANK */
    private String bank = "";
    /** 属性ACCOUNT */
    private String account = "";
    /** 属性UNITAMOUNT */
    private double unitamount = 0D;
    /** 属性ESTIMATELOSS */
    private double estimateloss = 0D;
    /** 属性RESTFEE */
    private double restfee = 0D;
    /** 属性CLAIMRATE */
    private double claimrate = 0D;
    /** 属性DEDUCTIBLERATE */
    private double deductiblerate = 0D;
    /** 属性DEDUCTIBLE */
    private double deductible = 0D;
    /** 属性SUMREALPAY */
    private double sumrealpay = 0D;
    /** 属性NODENO */
    private int nodeno = 0;
    /** 属性NODETYPE */
    private String nodetype = "";
    /** 属性CULLNUMBER */
    private int cullnumber = 0;
    /** 属性DEADNUMBER */
    private int deadnumber = 0;
    /** 属性DEADREASON */
    private String deadreason = "";
    /** 属性BREEDINGAREANAME */
    private String breedingareaname = "";
    /** 属性FCODE */
    private String fcode = "";
    /** 属性BREEDINGAREACODE */
    private String breedingareacode = "";
    /** 属性KINDCODE */
    private String kindcode = "";
    /** 属性INUSRELISTCODE */
    private String inusrelistcode = "";
    /** 属性REPORTTIME */
    private String reporttime = "";
    
    private String businessno = "";

    /**
     *  默认构造方法,构造一个默认的PrplcompensateearDtoBase对象
     */
    public PrplcompensateearDtoBase(){
    }

    /**
     * 设置属性EARNO
     * @param earno 待设置的属性EARNO的值
     */
    public void setEarno(String earno){
        this.earno = StringUtils.rightTrim(earno);
    }

    /**
     * 获取属性EARNO
     * @return 属性EARNO的值
     */
    public String getEarno(){
        return earno;
    }

    /**
     * 设置属性POLICYNO
     * @param policyno 待设置的属性POLICYNO的值
     */
    public void setPolicyno(String policyno){
        this.policyno = StringUtils.rightTrim(policyno);
    }

    /**
     * 获取属性POLICYNO
     * @return 属性POLICYNO的值
     */
    public String getPolicyno(){
        return policyno;
    }

    /**
     * 设置属性REGISTNO
     * @param registno 待设置的属性REGISTNO的值
     */
    public void setRegistno(String registno){
        this.registno = StringUtils.rightTrim(registno);
    }

    /**
     * 获取属性REGISTNO
     * @return 属性REGISTNO的值
     */
    public String getRegistno(){
        return registno;
    }

    /**
     * 设置属性CLAIMNO
     * @param claimno 待设置的属性CLAIMNO的值
     */
    public void setClaimno(String claimno){
        this.claimno = StringUtils.rightTrim(claimno);
    }

    /**
     * 获取属性CLAIMNO
     * @return 属性CLAIMNO的值
     */
    public String getClaimno(){
        return claimno;
    }

    /**
     * 设置属性COMPENSATENO
     * @param compensateno 待设置的属性COMPENSATENO的值
     */
    public void setCompensateno(String compensateno){
        this.compensateno = StringUtils.rightTrim(compensateno);
    }

    /**
     * 获取属性COMPENSATENO
     * @return 属性COMPENSATENO的值
     */
    public String getCompensateno(){
        return compensateno;
    }

    /**
     * 设置属性COMBINENO
     * @param combineno 待设置的属性COMBINENO的值
     */
    public void setCombineno(String combineno){
        this.combineno = StringUtils.rightTrim(combineno);
    }

    /**
     * 获取属性COMBINENO
     * @return 属性COMBINENO的值
     */
    public String getCombineno(){
        return combineno;
    }

    /**
     * 设置属性CASENO
     * @param caseno 待设置的属性CASENO的值
     */
    public void setCaseno(String caseno){
        this.caseno = StringUtils.rightTrim(caseno);
    }

    /**
     * 获取属性CASENO
     * @return 属性CASENO的值
     */
    public String getCaseno(){
        return caseno;
    }

    /**
     * 设置属性DAMAGESTARTDATE
     * @param damagestartdate 待设置的属性DAMAGESTARTDATE的值
     */
    public void setDamagestartdate(DateTime damagestartdate){
        this.damagestartdate = damagestartdate;
    }

    /**
     * 获取属性DAMAGESTARTDATE
     * @return 属性DAMAGESTARTDATE的值
     */
    public DateTime getDamagestartdate(){
        return damagestartdate;
    }

    /**
     * 设置属性DAMAGESTARTHOUR
     * @param damagestarthour 待设置的属性DAMAGESTARTHOUR的值
     */
    public void setDamagestarthour(String damagestarthour){
        this.damagestarthour = StringUtils.rightTrim(damagestarthour);
    }

    /**
     * 获取属性DAMAGESTARTHOUR
     * @return 属性DAMAGESTARTHOUR的值
     */
    public String getDamagestarthour(){
        return damagestarthour;
    }

    /**
     * 设置属性DAMAGEENDDATE
     * @param damageenddate 待设置的属性DAMAGEENDDATE的值
     */
    public void setDamageenddate(DateTime damageenddate){
        this.damageenddate = damageenddate;
    }

    /**
     * 获取属性DAMAGEENDDATE
     * @return 属性DAMAGEENDDATE的值
     */
    public DateTime getDamageenddate(){
        return damageenddate;
    }

    /**
     * 设置属性DAMAGECODE
     * @param damagecode 待设置的属性DAMAGECODE的值
     */
    public void setDamagecode(String damagecode){
        this.damagecode = StringUtils.rightTrim(damagecode);
    }

    /**
     * 获取属性DAMAGECODE
     * @return 属性DAMAGECODE的值
     */
    public String getDamagecode(){
        return damagecode;
    }

    /**
     * 设置属性DAMAGENAME
     * @param damagename 待设置的属性DAMAGENAME的值
     */
    public void setDamagename(String damagename){
        this.damagename = StringUtils.rightTrim(damagename);
    }

    /**
     * 获取属性DAMAGENAME
     * @return 属性DAMAGENAME的值
     */
    public String getDamagename(){
        return damagename;
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
     * 设置属性ID_CARD
     * @param id_card 待设置的属性ID_CARD的值
     */
    public void setId_card(String id_card){
        this.id_card = StringUtils.rightTrim(id_card);
    }

    /**
     * 获取属性ID_CARD
     * @return 属性ID_CARD的值
     */
    public String getId_card(){
        return id_card;
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
     * 设置属性ACCOUNT
     * @param account 待设置的属性ACCOUNT的值
     */
    public void setAccount(String account){
        this.account = StringUtils.rightTrim(account);
    }

    /**
     * 获取属性ACCOUNT
     * @return 属性ACCOUNT的值
     */
    public String getAccount(){
        return account;
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
     * 设置属性ESTIMATELOSS
     * @param estimateloss 待设置的属性ESTIMATELOSS的值
     */
    public void setEstimateloss(double estimateloss){
        this.estimateloss = estimateloss;
    }

    /**
     * 获取属性ESTIMATELOSS
     * @return 属性ESTIMATELOSS的值
     */
    public double getEstimateloss(){
        return estimateloss;
    }

    /**
     * 设置属性RESTFEE
     * @param restfee 待设置的属性RESTFEE的值
     */
    public void setRestfee(double restfee){
        this.restfee = restfee;
    }

    /**
     * 获取属性RESTFEE
     * @return 属性RESTFEE的值
     */
    public double getRestfee(){
        return restfee;
    }

    /**
     * 设置属性CLAIMRATE
     * @param claimrate 待设置的属性CLAIMRATE的值
     */
    public void setClaimrate(double claimrate){
        this.claimrate = claimrate;
    }

    /**
     * 获取属性CLAIMRATE
     * @return 属性CLAIMRATE的值
     */
    public double getClaimrate(){
        return claimrate;
    }

    /**
     * 设置属性DEDUCTIBLERATE
     * @param deductiblerate 待设置的属性DEDUCTIBLERATE的值
     */
    public void setDeductiblerate(double deductiblerate){
        this.deductiblerate = deductiblerate;
    }

    /**
     * 获取属性DEDUCTIBLERATE
     * @return 属性DEDUCTIBLERATE的值
     */
    public double getDeductiblerate(){
        return deductiblerate;
    }

    /**
     * 设置属性DEDUCTIBLE
     * @param deductible 待设置的属性DEDUCTIBLE的值
     */
    public void setDeductible(double deductible){
        this.deductible = deductible;
    }

    /**
     * 获取属性DEDUCTIBLE
     * @return 属性DEDUCTIBLE的值
     */
    public double getDeductible(){
        return deductible;
    }

    /**
     * 设置属性SUMREALPAY
     * @param sumrealpay 待设置的属性SUMREALPAY的值
     */
    public void setSumrealpay(double sumrealpay){
        this.sumrealpay = sumrealpay;
    }

    /**
     * 获取属性SUMREALPAY
     * @return 属性SUMREALPAY的值
     */
    public double getSumrealpay(){
        return sumrealpay;
    }

    /**
     * 设置属性NODENO
     * @param nodeno 待设置的属性NODENO的值
     */
    public void setNodeno(int nodeno){
        this.nodeno = nodeno;
    }

    /**
     * 获取属性NODENO
     * @return 属性NODENO的值
     */
    public int getNodeno(){
        return nodeno;
    }

    /**
     * 设置属性NODETYPE
     * @param nodetype 待设置的属性NODETYPE的值
     */
    public void setNodetype(String nodetype){
        this.nodetype = StringUtils.rightTrim(nodetype);
    }

    /**
     * 获取属性NODETYPE
     * @return 属性NODETYPE的值
     */
    public String getNodetype(){
        return nodetype;
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
     * 设置属性Businessno
     * @param Businessno 待设置的属性Businessno的值
     */
    public void setBusinessno(String businessno){
        this.businessno = StringUtils.rightTrim(businessno);
    }

    /**
     * 获取属性Businessno
     * @return 属性Businessno的值
     */
    public String getBusinessno(){
        return businessno;
    }
}
