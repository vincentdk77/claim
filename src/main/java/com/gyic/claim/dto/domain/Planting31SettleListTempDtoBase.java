package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Planting31SettleListTemp�����ݴ���������<br>
 */
public class Planting31SettleListTempDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����RegistCode */
    private String registCode = "";
    /** ����StringTimeStamp */
    private String stringTimeStamp = "";
    /** ����IndexOfSettle */
    private int indexOfSettle = 0;
    /** ����FCode */
    private String fcode = "";
    /** ����KindCode */
    private String kindCode = "";
    /** ����ItemCode */
    private String itemCode = "";
    /** ����ClassCode */
    private String classCode = "";
    /** ����RiskCode */
    private String riskCode = "";
    /** ����InsureArea */
    private double insureArea = 0D;
    /** ����SumInsured */
    private double sumInsured = 0D;
    /** ����ZhiBuKa */
    private String zhiBuKa = "";
    /** ����FName */
    private String fname = "";
    /** ����FIDCard */
    private String fidCard = "";
    /** ����FAreaCode */
    private String fareaCode = "";
    /** ����InusreListCode */
    private String inusreListCode = "";
    /** ����GrowingSeason */
    private double growingSeason = 0D;
    /** ����LossRate */
    private double lossRate = 0D;
    /** ����SettleArea */
    private double settleArea = 0D;
    /** ����SettleSum */
    private double settleSum = 0D;
    /** ����OpCode */
    private String opCode = "";
    /** ����OpTime */
    private DateTime opTime = new DateTime();
    /** ����Remark */
    private String remark = "";
    /** ����Validity */
    private String validity = "";
    /** ����SettleDate */
    private DateTime settleDate = new DateTime();
    /** ����ClaimRate */
    private double claimRate = 0D;
    /** ����NodeType */
    private String nodeType = "";
    /** ����Phone */
    private String phone = "";
    /** ����Bank */
    private String bank = "";
    /** ����FieldSource */
    private String fieldSource = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�Planting31SettleListTempDtoBase����
     */
    public Planting31SettleListTempDtoBase(){
    }

    /**
     * ��������RegistCode
     * @param registCode �����õ�����RegistCode��ֵ
     */
    public void setRegistCode(String registCode){
        this.registCode = StringUtils.rightTrim(registCode);
    }

    /**
     * ��ȡ����RegistCode
     * @return ����RegistCode��ֵ
     */
    public String getRegistCode(){
        return registCode;
    }

    /**
     * ��������StringTimeStamp
     * @param stringTimeStamp �����õ�����StringTimeStamp��ֵ
     */
    public void setStringTimeStamp(String stringTimeStamp){
        this.stringTimeStamp = StringUtils.rightTrim(stringTimeStamp);
    }

    /**
     * ��ȡ����StringTimeStamp
     * @return ����StringTimeStamp��ֵ
     */
    public String getStringTimeStamp(){
        return stringTimeStamp;
    }

    /**
     * ��������IndexOfSettle
     * @param indexOfSettle �����õ�����IndexOfSettle��ֵ
     */
    public void setIndexOfSettle(int indexOfSettle){
        this.indexOfSettle = indexOfSettle;
    }

    /**
     * ��ȡ����IndexOfSettle
     * @return ����IndexOfSettle��ֵ
     */
    public int getIndexOfSettle(){
        return indexOfSettle;
    }

    /**
     * ��������FCode
     * @param fcode �����õ�����FCode��ֵ
     */
    public void setFcode(String fcode){
        this.fcode = StringUtils.rightTrim(fcode);
    }

    /**
     * ��ȡ����FCode
     * @return ����FCode��ֵ
     */
    public String getFcode(){
        return fcode;
    }

    /**
     * ��������KindCode
     * @param kindCode �����õ�����KindCode��ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ����KindCode
     * @return ����KindCode��ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * ��������ItemCode
     * @param itemCode �����õ�����ItemCode��ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ����ItemCode
     * @return ����ItemCode��ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * ��������ClassCode
     * @param classCode �����õ�����ClassCode��ֵ
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * ��ȡ����ClassCode
     * @return ����ClassCode��ֵ
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * ��������RiskCode
     * @param riskCode �����õ�����RiskCode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����RiskCode
     * @return ����RiskCode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������InsureArea
     * @param insureArea �����õ�����InsureArea��ֵ
     */
    public void setInsureArea(double insureArea){
        this.insureArea = insureArea;
    }

    /**
     * ��ȡ����InsureArea
     * @return ����InsureArea��ֵ
     */
    public double getInsureArea(){
        return insureArea;
    }

    /**
     * ��������SumInsured
     * @param sumInsured �����õ�����SumInsured��ֵ
     */
    public void setSumInsured(double sumInsured){
        this.sumInsured = sumInsured;
    }

    /**
     * ��ȡ����SumInsured
     * @return ����SumInsured��ֵ
     */
    public double getSumInsured(){
        return sumInsured;
    }

    /**
     * ��������ZhiBuKa
     * @param zhiBuKa �����õ�����ZhiBuKa��ֵ
     */
    public void setZhiBuKa(String zhiBuKa){
        this.zhiBuKa = StringUtils.rightTrim(zhiBuKa);
    }

    /**
     * ��ȡ����ZhiBuKa
     * @return ����ZhiBuKa��ֵ
     */
    public String getZhiBuKa(){
        return zhiBuKa;
    }

    /**
     * ��������FName
     * @param fname �����õ�����FName��ֵ
     */
    public void setFname(String fname){
        this.fname = StringUtils.rightTrim(fname);
    }

    /**
     * ��ȡ����FName
     * @return ����FName��ֵ
     */
    public String getFname(){
        return fname;
    }

    /**
     * ��������FIDCard
     * @param fidCard �����õ�����FIDCard��ֵ
     */
    public void setFidCard(String fidCard){
        this.fidCard = StringUtils.rightTrim(fidCard);
    }

    /**
     * ��ȡ����FIDCard
     * @return ����FIDCard��ֵ
     */
    public String getFidCard(){
        return fidCard;
    }

    /**
     * ��������FAreaCode
     * @param fareaCode �����õ�����FAreaCode��ֵ
     */
    public void setFareaCode(String fareaCode){
        this.fareaCode = StringUtils.rightTrim(fareaCode);
    }

    /**
     * ��ȡ����FAreaCode
     * @return ����FAreaCode��ֵ
     */
    public String getFareaCode(){
        return fareaCode;
    }

    /**
     * ��������InusreListCode
     * @param inusreListCode �����õ�����InusreListCode��ֵ
     */
    public void setInusreListCode(String inusreListCode){
        this.inusreListCode = StringUtils.rightTrim(inusreListCode);
    }

    /**
     * ��ȡ����InusreListCode
     * @return ����InusreListCode��ֵ
     */
    public String getInusreListCode(){
        return inusreListCode;
    }

    /**
     * ��������GrowingSeason
     * @param growingSeason �����õ�����GrowingSeason��ֵ
     */
    public void setGrowingSeason(double growingSeason){
        this.growingSeason = growingSeason;
    }

    /**
     * ��ȡ����GrowingSeason
     * @return ����GrowingSeason��ֵ
     */
    public double getGrowingSeason(){
        return growingSeason;
    }

    /**
     * ��������LossRate
     * @param lossRate �����õ�����LossRate��ֵ
     */
    public void setLossRate(double lossRate){
        this.lossRate = lossRate;
    }

    /**
     * ��ȡ����LossRate
     * @return ����LossRate��ֵ
     */
    public double getLossRate(){
        return lossRate;
    }

    /**
     * ��������SettleArea
     * @param settleArea �����õ�����SettleArea��ֵ
     */
    public void setSettleArea(double settleArea){
        this.settleArea = settleArea;
    }

    /**
     * ��ȡ����SettleArea
     * @return ����SettleArea��ֵ
     */
    public double getSettleArea(){
        return settleArea;
    }

    /**
     * ��������SettleSum
     * @param settleSum �����õ�����SettleSum��ֵ
     */
    public void setSettleSum(double settleSum){
        this.settleSum = settleSum;
    }

    /**
     * ��ȡ����SettleSum
     * @return ����SettleSum��ֵ
     */
    public double getSettleSum(){
        return settleSum;
    }

    /**
     * ��������OpCode
     * @param opCode �����õ�����OpCode��ֵ
     */
    public void setOpCode(String opCode){
        this.opCode = StringUtils.rightTrim(opCode);
    }

    /**
     * ��ȡ����OpCode
     * @return ����OpCode��ֵ
     */
    public String getOpCode(){
        return opCode;
    }

    /**
     * ��������OpTime
     * @param opTime �����õ�����OpTime��ֵ
     */
    public void setOpTime(DateTime opTime){
        this.opTime = opTime;
    }

    /**
     * ��ȡ����OpTime
     * @return ����OpTime��ֵ
     */
    public DateTime getOpTime(){
        return opTime;
    }

    /**
     * ��������Remark
     * @param remark �����õ�����Remark��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ����Remark
     * @return ����Remark��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * ��������Validity
     * @param validity �����õ�����Validity��ֵ
     */
    public void setValidity(String validity){
        this.validity = StringUtils.rightTrim(validity);
    }

    /**
     * ��ȡ����Validity
     * @return ����Validity��ֵ
     */
    public String getValidity(){
        return validity;
    }

    /**
     * ��������SettleDate
     * @param settleDate �����õ�����SettleDate��ֵ
     */
    public void setSettleDate(DateTime settleDate){
        this.settleDate = settleDate;
    }

    /**
     * ��ȡ����SettleDate
     * @return ����SettleDate��ֵ
     */
    public DateTime getSettleDate(){
        return settleDate;
    }

    /**
     * ��������ClaimRate
     * @param claimRate �����õ�����ClaimRate��ֵ
     */
    public void setClaimRate(double claimRate){
        this.claimRate = claimRate;
    }

    /**
     * ��ȡ����ClaimRate
     * @return ����ClaimRate��ֵ
     */
    public double getClaimRate(){
        return claimRate;
    }

    /**
     * ��������NodeType
     * @param nodeType �����õ�����NodeType��ֵ
     */
    public void setNodeType(String nodeType){
        this.nodeType = StringUtils.rightTrim(nodeType);
    }

    /**
     * ��ȡ����NodeType
     * @return ����NodeType��ֵ
     */
    public String getNodeType(){
        return nodeType;
    }

    /**
     * ��������Phone
     * @param phone �����õ�����Phone��ֵ
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * ��ȡ����Phone
     * @return ����Phone��ֵ
     */
    public String getPhone(){
        return phone;
    }

    /**
     * ��������Bank
     * @param bank �����õ�����Bank��ֵ
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * ��ȡ����Bank
     * @return ����Bank��ֵ
     */
    public String getBank(){
        return bank;
    }

    /**
     * ��������FieldSource
     * @param fieldSource �����õ�����FieldSource��ֵ
     */
    public void setFieldSource(String fieldSource){
        this.fieldSource = StringUtils.rightTrim(fieldSource);
    }

    /**
     * ��ȡ����FieldSource
     * @return ����FieldSource��ֵ
     */
    public String getFieldSource(){
        return fieldSource;
    }
}
