package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Prplcompensateear�����ݴ���������<br>
 */
public class PrplcompensateearDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����EARNO */
    private String earno = "";
    /** ����POLICYNO */
    private String policyno = "";
    /** ����REGISTNO */
    private String registno = "";
    /** ����CLAIMNO */
    private String claimno = "";
    /** ����COMPENSATENO */
    private String compensateno = "";
    /** ����COMBINENO */
    private String combineno = "";
    /** ����CASENO */
    private String caseno = "";
    /** ����DAMAGESTARTDATE */
    private DateTime damagestartdate = new DateTime();
    /** ����DAMAGESTARTHOUR */
    private String damagestarthour = "";
    /** ����DAMAGEENDDATE */
    private DateTime damageenddate = new DateTime();
    /** ����DAMAGECODE */
    private String damagecode = "";
    /** ����DAMAGENAME */
    private String damagename = "";
    /** ����NAME */
    private String name = "";
    /** ����ID_CARD */
    private String id_card = "";
    /** ����BANK */
    private String bank = "";
    /** ����ACCOUNT */
    private String account = "";
    /** ����UNITAMOUNT */
    private double unitamount = 0D;
    /** ����ESTIMATELOSS */
    private double estimateloss = 0D;
    /** ����RESTFEE */
    private double restfee = 0D;
    /** ����CLAIMRATE */
    private double claimrate = 0D;
    /** ����DEDUCTIBLERATE */
    private double deductiblerate = 0D;
    /** ����DEDUCTIBLE */
    private double deductible = 0D;
    /** ����SUMREALPAY */
    private double sumrealpay = 0D;
    /** ����NODENO */
    private int nodeno = 0;
    /** ����NODETYPE */
    private String nodetype = "";
    /** ����CULLNUMBER */
    private int cullnumber = 0;
    /** ����DEADNUMBER */
    private int deadnumber = 0;
    /** ����DEADREASON */
    private String deadreason = "";
    /** ����BREEDINGAREANAME */
    private String breedingareaname = "";
    /** ����FCODE */
    private String fcode = "";
    /** ����BREEDINGAREACODE */
    private String breedingareacode = "";
    /** ����KINDCODE */
    private String kindcode = "";
    /** ����INUSRELISTCODE */
    private String inusrelistcode = "";
    /** ����REPORTTIME */
    private String reporttime = "";
    
    private String businessno = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplcompensateearDtoBase����
     */
    public PrplcompensateearDtoBase(){
    }

    /**
     * ��������EARNO
     * @param earno �����õ�����EARNO��ֵ
     */
    public void setEarno(String earno){
        this.earno = StringUtils.rightTrim(earno);
    }

    /**
     * ��ȡ����EARNO
     * @return ����EARNO��ֵ
     */
    public String getEarno(){
        return earno;
    }

    /**
     * ��������POLICYNO
     * @param policyno �����õ�����POLICYNO��ֵ
     */
    public void setPolicyno(String policyno){
        this.policyno = StringUtils.rightTrim(policyno);
    }

    /**
     * ��ȡ����POLICYNO
     * @return ����POLICYNO��ֵ
     */
    public String getPolicyno(){
        return policyno;
    }

    /**
     * ��������REGISTNO
     * @param registno �����õ�����REGISTNO��ֵ
     */
    public void setRegistno(String registno){
        this.registno = StringUtils.rightTrim(registno);
    }

    /**
     * ��ȡ����REGISTNO
     * @return ����REGISTNO��ֵ
     */
    public String getRegistno(){
        return registno;
    }

    /**
     * ��������CLAIMNO
     * @param claimno �����õ�����CLAIMNO��ֵ
     */
    public void setClaimno(String claimno){
        this.claimno = StringUtils.rightTrim(claimno);
    }

    /**
     * ��ȡ����CLAIMNO
     * @return ����CLAIMNO��ֵ
     */
    public String getClaimno(){
        return claimno;
    }

    /**
     * ��������COMPENSATENO
     * @param compensateno �����õ�����COMPENSATENO��ֵ
     */
    public void setCompensateno(String compensateno){
        this.compensateno = StringUtils.rightTrim(compensateno);
    }

    /**
     * ��ȡ����COMPENSATENO
     * @return ����COMPENSATENO��ֵ
     */
    public String getCompensateno(){
        return compensateno;
    }

    /**
     * ��������COMBINENO
     * @param combineno �����õ�����COMBINENO��ֵ
     */
    public void setCombineno(String combineno){
        this.combineno = StringUtils.rightTrim(combineno);
    }

    /**
     * ��ȡ����COMBINENO
     * @return ����COMBINENO��ֵ
     */
    public String getCombineno(){
        return combineno;
    }

    /**
     * ��������CASENO
     * @param caseno �����õ�����CASENO��ֵ
     */
    public void setCaseno(String caseno){
        this.caseno = StringUtils.rightTrim(caseno);
    }

    /**
     * ��ȡ����CASENO
     * @return ����CASENO��ֵ
     */
    public String getCaseno(){
        return caseno;
    }

    /**
     * ��������DAMAGESTARTDATE
     * @param damagestartdate �����õ�����DAMAGESTARTDATE��ֵ
     */
    public void setDamagestartdate(DateTime damagestartdate){
        this.damagestartdate = damagestartdate;
    }

    /**
     * ��ȡ����DAMAGESTARTDATE
     * @return ����DAMAGESTARTDATE��ֵ
     */
    public DateTime getDamagestartdate(){
        return damagestartdate;
    }

    /**
     * ��������DAMAGESTARTHOUR
     * @param damagestarthour �����õ�����DAMAGESTARTHOUR��ֵ
     */
    public void setDamagestarthour(String damagestarthour){
        this.damagestarthour = StringUtils.rightTrim(damagestarthour);
    }

    /**
     * ��ȡ����DAMAGESTARTHOUR
     * @return ����DAMAGESTARTHOUR��ֵ
     */
    public String getDamagestarthour(){
        return damagestarthour;
    }

    /**
     * ��������DAMAGEENDDATE
     * @param damageenddate �����õ�����DAMAGEENDDATE��ֵ
     */
    public void setDamageenddate(DateTime damageenddate){
        this.damageenddate = damageenddate;
    }

    /**
     * ��ȡ����DAMAGEENDDATE
     * @return ����DAMAGEENDDATE��ֵ
     */
    public DateTime getDamageenddate(){
        return damageenddate;
    }

    /**
     * ��������DAMAGECODE
     * @param damagecode �����õ�����DAMAGECODE��ֵ
     */
    public void setDamagecode(String damagecode){
        this.damagecode = StringUtils.rightTrim(damagecode);
    }

    /**
     * ��ȡ����DAMAGECODE
     * @return ����DAMAGECODE��ֵ
     */
    public String getDamagecode(){
        return damagecode;
    }

    /**
     * ��������DAMAGENAME
     * @param damagename �����õ�����DAMAGENAME��ֵ
     */
    public void setDamagename(String damagename){
        this.damagename = StringUtils.rightTrim(damagename);
    }

    /**
     * ��ȡ����DAMAGENAME
     * @return ����DAMAGENAME��ֵ
     */
    public String getDamagename(){
        return damagename;
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
     * ��������ID_CARD
     * @param id_card �����õ�����ID_CARD��ֵ
     */
    public void setId_card(String id_card){
        this.id_card = StringUtils.rightTrim(id_card);
    }

    /**
     * ��ȡ����ID_CARD
     * @return ����ID_CARD��ֵ
     */
    public String getId_card(){
        return id_card;
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
     * ��������ACCOUNT
     * @param account �����õ�����ACCOUNT��ֵ
     */
    public void setAccount(String account){
        this.account = StringUtils.rightTrim(account);
    }

    /**
     * ��ȡ����ACCOUNT
     * @return ����ACCOUNT��ֵ
     */
    public String getAccount(){
        return account;
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
     * ��������ESTIMATELOSS
     * @param estimateloss �����õ�����ESTIMATELOSS��ֵ
     */
    public void setEstimateloss(double estimateloss){
        this.estimateloss = estimateloss;
    }

    /**
     * ��ȡ����ESTIMATELOSS
     * @return ����ESTIMATELOSS��ֵ
     */
    public double getEstimateloss(){
        return estimateloss;
    }

    /**
     * ��������RESTFEE
     * @param restfee �����õ�����RESTFEE��ֵ
     */
    public void setRestfee(double restfee){
        this.restfee = restfee;
    }

    /**
     * ��ȡ����RESTFEE
     * @return ����RESTFEE��ֵ
     */
    public double getRestfee(){
        return restfee;
    }

    /**
     * ��������CLAIMRATE
     * @param claimrate �����õ�����CLAIMRATE��ֵ
     */
    public void setClaimrate(double claimrate){
        this.claimrate = claimrate;
    }

    /**
     * ��ȡ����CLAIMRATE
     * @return ����CLAIMRATE��ֵ
     */
    public double getClaimrate(){
        return claimrate;
    }

    /**
     * ��������DEDUCTIBLERATE
     * @param deductiblerate �����õ�����DEDUCTIBLERATE��ֵ
     */
    public void setDeductiblerate(double deductiblerate){
        this.deductiblerate = deductiblerate;
    }

    /**
     * ��ȡ����DEDUCTIBLERATE
     * @return ����DEDUCTIBLERATE��ֵ
     */
    public double getDeductiblerate(){
        return deductiblerate;
    }

    /**
     * ��������DEDUCTIBLE
     * @param deductible �����õ�����DEDUCTIBLE��ֵ
     */
    public void setDeductible(double deductible){
        this.deductible = deductible;
    }

    /**
     * ��ȡ����DEDUCTIBLE
     * @return ����DEDUCTIBLE��ֵ
     */
    public double getDeductible(){
        return deductible;
    }

    /**
     * ��������SUMREALPAY
     * @param sumrealpay �����õ�����SUMREALPAY��ֵ
     */
    public void setSumrealpay(double sumrealpay){
        this.sumrealpay = sumrealpay;
    }

    /**
     * ��ȡ����SUMREALPAY
     * @return ����SUMREALPAY��ֵ
     */
    public double getSumrealpay(){
        return sumrealpay;
    }

    /**
     * ��������NODENO
     * @param nodeno �����õ�����NODENO��ֵ
     */
    public void setNodeno(int nodeno){
        this.nodeno = nodeno;
    }

    /**
     * ��ȡ����NODENO
     * @return ����NODENO��ֵ
     */
    public int getNodeno(){
        return nodeno;
    }

    /**
     * ��������NODETYPE
     * @param nodetype �����õ�����NODETYPE��ֵ
     */
    public void setNodetype(String nodetype){
        this.nodetype = StringUtils.rightTrim(nodetype);
    }

    /**
     * ��ȡ����NODETYPE
     * @return ����NODETYPE��ֵ
     */
    public String getNodetype(){
        return nodetype;
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
     * ��������Businessno
     * @param Businessno �����õ�����Businessno��ֵ
     */
    public void setBusinessno(String businessno){
        this.businessno = StringUtils.rightTrim(businessno);
    }

    /**
     * ��ȡ����Businessno
     * @return ����Businessno��ֵ
     */
    public String getBusinessno(){
        return businessno;
    }
}
