package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXSETTLELISTTEMP�����ݴ���������<br>
 */
public class NyxsettlelisttempDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����REGISTCODE */
    private String registcode = "";
    /** ����STRINGTIMESTAMP */
    private String stringtimestamp = "";
    /** ����INDEXOFSETTLE */
    private int indexofsettle = 0;
    /** ����FCODE */
    private String fcode = "";
    /** ����KINDCODE */
    private String kindcode = "";
    /** ����ITEMCODE */
    private String itemcode = "";
    /** ����CLASSCODE */
    private String classcode = "";
    /** ����RISKCODE */
    private String riskcode = "";
    /** ����INSUREAREA */
    private double insurearea = 0D;
    /** ����SUMINSURED */
    private double suminsured = 0D;
    /** ����ZHIBUKA */
    private String zhibuka = "";
    /** ����FNAME */
    private String fname = "";
    /** ����FIDCARD */
    private String fidcard = "";
    /** ����FAREACODE */
    private String fareacode = "";
    /** ����INUSRELISTCODE */
    private String inusrelistcode = "";
    /** ����GROWINGSEASON */
    private double growingseason = 0D;
    /** ����LOSSRATE */
    private double lossrate = 0D;
    /** ����SETTLEAREA */
    private double settlearea = 0D;
    /** ����SETTLESUM */
    private double settlesum = 0D;
    /** ����OPCODE */
    private String opcode = "";
    /** ����OPTIME */
    private DateTime optime = new DateTime();
    /** ����REMARK */
    private String remark = "";
    /** ����VALIDITY */
    private String validity = "";
    /** ����SETTLEDATE */
    private DateTime settledate = new DateTime();
    /** ����CLAIMRATE */
    private double claimrate = 0D;
    /** ����NODETYPE */
    private String nodetype = "";
    /** ����PHONE */
    private String phone = "";
    /** ����BANK */
    private String bank = "";
    /** ����WARRANT */
    private String warrant = "";
    /** ����TAXAREA */
    private double taxarea = 0D;
    /** ����ATAREA */
    private String atarea = "";
    /** ����LITTLEAREANAME */
    private String littleareaname = "";
    /** ����FIELDSOURCE */
    private String fieldsource = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�NyxsettlelisttempDtoBase����
     */
    public NyxsettlelisttempDtoBase(){
    }

    /**
     * ��������REGISTCODE
     * @param registcode �����õ�����REGISTCODE��ֵ
     */
    public void setRegistcode(String registcode){
        this.registcode = StringUtils.rightTrim(registcode);
    }

    /**
     * ��ȡ����REGISTCODE
     * @return ����REGISTCODE��ֵ
     */
    public String getRegistcode(){
        return registcode;
    }

    /**
     * ��������STRINGTIMESTAMP
     * @param stringtimestamp �����õ�����STRINGTIMESTAMP��ֵ
     */
    public void setStringtimestamp(String stringtimestamp){
        this.stringtimestamp = StringUtils.rightTrim(stringtimestamp);
    }

    /**
     * ��ȡ����STRINGTIMESTAMP
     * @return ����STRINGTIMESTAMP��ֵ
     */
    public String getStringtimestamp(){
        return stringtimestamp;
    }

    /**
     * ��������INDEXOFSETTLE
     * @param indexofsettle �����õ�����INDEXOFSETTLE��ֵ
     */
    public void setIndexofsettle(int indexofsettle){
        this.indexofsettle = indexofsettle;
    }

    /**
     * ��ȡ����INDEXOFSETTLE
     * @return ����INDEXOFSETTLE��ֵ
     */
    public int getIndexofsettle(){
        return indexofsettle;
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
     * ��������SUMINSURED
     * @param suminsured �����õ�����SUMINSURED��ֵ
     */
    public void setSuminsured(double suminsured){
        this.suminsured = suminsured;
    }

    /**
     * ��ȡ����SUMINSURED
     * @return ����SUMINSURED��ֵ
     */
    public double getSuminsured(){
        return suminsured;
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
     * ��������GROWINGSEASON
     * @param growingseason �����õ�����GROWINGSEASON��ֵ
     */
    public void setGrowingseason(double growingseason){
        this.growingseason = growingseason;
    }

    /**
     * ��ȡ����GROWINGSEASON
     * @return ����GROWINGSEASON��ֵ
     */
    public double getGrowingseason(){
        return growingseason;
    }

    /**
     * ��������LOSSRATE
     * @param lossrate �����õ�����LOSSRATE��ֵ
     */
    public void setLossrate(double lossrate){
        this.lossrate = lossrate;
    }

    /**
     * ��ȡ����LOSSRATE
     * @return ����LOSSRATE��ֵ
     */
    public double getLossrate(){
        return lossrate;
    }

    /**
     * ��������SETTLEAREA
     * @param settlearea �����õ�����SETTLEAREA��ֵ
     */
    public void setSettlearea(double settlearea){
        this.settlearea = settlearea;
    }

    /**
     * ��ȡ����SETTLEAREA
     * @return ����SETTLEAREA��ֵ
     */
    public double getSettlearea(){
        return settlearea;
    }

    /**
     * ��������SETTLESUM
     * @param settlesum �����õ�����SETTLESUM��ֵ
     */
    public void setSettlesum(double settlesum){
        this.settlesum = settlesum;
    }

    /**
     * ��ȡ����SETTLESUM
     * @return ����SETTLESUM��ֵ
     */
    public double getSettlesum(){
        return settlesum;
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
     * ��������SETTLEDATE
     * @param settledate �����õ�����SETTLEDATE��ֵ
     */
    public void setSettledate(DateTime settledate){
        this.settledate = settledate;
    }

    /**
     * ��ȡ����SETTLEDATE
     * @return ����SETTLEDATE��ֵ
     */
    public DateTime getSettledate(){
        return settledate;
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
     * ��������LITTLEAREANAME
     * @param littleareaname �����õ�����LITTLEAREANAME��ֵ
     */
    public void setLittleareaname(String littleareaname){
        this.littleareaname = StringUtils.rightTrim(littleareaname);
    }

    /**
     * ��ȡ����LITTLEAREANAME
     * @return ����LITTLEAREANAME��ֵ
     */
    public String getLittleareaname(){
        return littleareaname;
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