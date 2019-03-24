package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是Planting31SettleList的数据传输对象基类<br>
 */
public class Planting31SettleListDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性SettleListCode */
    private String settleListCode = "";
    /** 属性FCode */
    private String fcode = "";
    /** 属性KindCode */
    private String kindCode = "";
    /** 属性ItemCode */
    private String itemCode = "";
    /** 属性ClassCode */
    private String classCode = "";
    /** 属性RiskCode */
    private String riskCode = "";
    /** 属性InsureArea */
    private double insureArea = 0D;
    /** 属性SumInsured */
    private double sumInsured = 0D;
    /** 属性ZhiBuKa */
    private String zhiBuKa = "";
    /** 属性FName */
    private String fname = "";
    /** 属性FIDCard */
    private String fidCard = "";
    /** 属性FAreaCode */
    private String fareaCode = "";
    /** 属性InusreListCode */
    private String inusreListCode = "";
    /** 属性GrowingSeason */
    private double growingSeason = 0D;
    /** 属性LossRate */
    private double lossRate = 0D;
    /** 属性SettleArea */
    private double settleArea = 0D;
    /** 属性SettleSum */
    private double settleSum = 0D;
    /** 属性OpCode */
    private String opCode = "";
    /** 属性OpTime */
    private DateTime opTime = new DateTime();
    /** 属性Remark */
    private String remark = "";
    /** 属性Validity */
    private String validity = "";
    /** 属性SettleDate */
    private DateTime settleDate = new DateTime();
    /** 属性ClaimRate */
    private double claimRate = 0D;
    /** 属性NodeType */
    private String nodeType = "";
    /** 属性IndexOfSettle */
    private int indexOfSettle = 0;
    /** 属性Phone */
    private String phone = "";
    /** 属性Bank */
    private String bank = "";
    /** 属性FieldSource */
    private String fieldSource = "";
    /** 属性FCodeModify */
    private String fcodeModify = "";

    /**
     *  默认构造方法,构造一个默认的Planting31SettleListDtoBase对象
     */
    public Planting31SettleListDtoBase(){
    }

    /**
     * 设置属性SettleListCode
     * @param settleListCode 待设置的属性SettleListCode的值
     */
    public void setSettleListCode(String settleListCode){
        this.settleListCode = StringUtils.rightTrim(settleListCode);
    }

    /**
     * 获取属性SettleListCode
     * @return 属性SettleListCode的值
     */
    public String getSettleListCode(){
        return settleListCode;
    }

    /**
     * 设置属性FCode
     * @param fcode 待设置的属性FCode的值
     */
    public void setFcode(String fcode){
        this.fcode = StringUtils.rightTrim(fcode);
    }

    /**
     * 获取属性FCode
     * @return 属性FCode的值
     */
    public String getFcode(){
        return fcode;
    }

    /**
     * 设置属性KindCode
     * @param kindCode 待设置的属性KindCode的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性KindCode
     * @return 属性KindCode的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性ItemCode
     * @param itemCode 待设置的属性ItemCode的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性ItemCode
     * @return 属性ItemCode的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性ClassCode
     * @param classCode 待设置的属性ClassCode的值
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * 获取属性ClassCode
     * @return 属性ClassCode的值
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * 设置属性RiskCode
     * @param riskCode 待设置的属性RiskCode的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性RiskCode
     * @return 属性RiskCode的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性InsureArea
     * @param insureArea 待设置的属性InsureArea的值
     */
    public void setInsureArea(double insureArea){
        this.insureArea = insureArea;
    }

    /**
     * 获取属性InsureArea
     * @return 属性InsureArea的值
     */
    public double getInsureArea(){
        return insureArea;
    }

    /**
     * 设置属性SumInsured
     * @param sumInsured 待设置的属性SumInsured的值
     */
    public void setSumInsured(double sumInsured){
        this.sumInsured = sumInsured;
    }

    /**
     * 获取属性SumInsured
     * @return 属性SumInsured的值
     */
    public double getSumInsured(){
        return sumInsured;
    }

    /**
     * 设置属性ZhiBuKa
     * @param zhiBuKa 待设置的属性ZhiBuKa的值
     */
    public void setZhiBuKa(String zhiBuKa){
        this.zhiBuKa = StringUtils.rightTrim(zhiBuKa);
    }

    /**
     * 获取属性ZhiBuKa
     * @return 属性ZhiBuKa的值
     */
    public String getZhiBuKa(){
        return zhiBuKa;
    }

    /**
     * 设置属性FName
     * @param fname 待设置的属性FName的值
     */
    public void setFname(String fname){
        this.fname = StringUtils.rightTrim(fname);
    }

    /**
     * 获取属性FName
     * @return 属性FName的值
     */
    public String getFname(){
        return fname;
    }

    /**
     * 设置属性FIDCard
     * @param fidCard 待设置的属性FIDCard的值
     */
    public void setFidCard(String fidCard){
        this.fidCard = StringUtils.rightTrim(fidCard);
    }

    /**
     * 获取属性FIDCard
     * @return 属性FIDCard的值
     */
    public String getFidCard(){
        return fidCard;
    }

    /**
     * 设置属性FAreaCode
     * @param fareaCode 待设置的属性FAreaCode的值
     */
    public void setFareaCode(String fareaCode){
        this.fareaCode = StringUtils.rightTrim(fareaCode);
    }

    /**
     * 获取属性FAreaCode
     * @return 属性FAreaCode的值
     */
    public String getFareaCode(){
        return fareaCode;
    }

    /**
     * 设置属性InusreListCode
     * @param inusreListCode 待设置的属性InusreListCode的值
     */
    public void setInusreListCode(String inusreListCode){
        this.inusreListCode = StringUtils.rightTrim(inusreListCode);
    }

    /**
     * 获取属性InusreListCode
     * @return 属性InusreListCode的值
     */
    public String getInusreListCode(){
        return inusreListCode;
    }

    /**
     * 设置属性GrowingSeason
     * @param growingSeason 待设置的属性GrowingSeason的值
     */
    public void setGrowingSeason(double growingSeason){
        this.growingSeason = growingSeason;
    }

    /**
     * 获取属性GrowingSeason
     * @return 属性GrowingSeason的值
     */
    public double getGrowingSeason(){
        return growingSeason;
    }

    /**
     * 设置属性LossRate
     * @param lossRate 待设置的属性LossRate的值
     */
    public void setLossRate(double lossRate){
        this.lossRate = lossRate;
    }

    /**
     * 获取属性LossRate
     * @return 属性LossRate的值
     */
    public double getLossRate(){
        return lossRate;
    }

    /**
     * 设置属性SettleArea
     * @param settleArea 待设置的属性SettleArea的值
     */
    public void setSettleArea(double settleArea){
        this.settleArea = settleArea;
    }

    /**
     * 获取属性SettleArea
     * @return 属性SettleArea的值
     */
    public double getSettleArea(){
        return settleArea;
    }

    /**
     * 设置属性SettleSum
     * @param settleSum 待设置的属性SettleSum的值
     */
    public void setSettleSum(double settleSum){
        this.settleSum = settleSum;
    }

    /**
     * 获取属性SettleSum
     * @return 属性SettleSum的值
     */
    public double getSettleSum(){
        return settleSum;
    }

    /**
     * 设置属性OpCode
     * @param opCode 待设置的属性OpCode的值
     */
    public void setOpCode(String opCode){
        this.opCode = StringUtils.rightTrim(opCode);
    }

    /**
     * 获取属性OpCode
     * @return 属性OpCode的值
     */
    public String getOpCode(){
        return opCode;
    }

    /**
     * 设置属性OpTime
     * @param opTime 待设置的属性OpTime的值
     */
    public void setOpTime(DateTime opTime){
        this.opTime = opTime;
    }

    /**
     * 获取属性OpTime
     * @return 属性OpTime的值
     */
    public DateTime getOpTime(){
        return opTime;
    }

    /**
     * 设置属性Remark
     * @param remark 待设置的属性Remark的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性Remark
     * @return 属性Remark的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性Validity
     * @param validity 待设置的属性Validity的值
     */
    public void setValidity(String validity){
        this.validity = StringUtils.rightTrim(validity);
    }

    /**
     * 获取属性Validity
     * @return 属性Validity的值
     */
    public String getValidity(){
        return validity;
    }

    /**
     * 设置属性SettleDate
     * @param settleDate 待设置的属性SettleDate的值
     */
    public void setSettleDate(DateTime settleDate){
        this.settleDate = settleDate;
    }

    /**
     * 获取属性SettleDate
     * @return 属性SettleDate的值
     */
    public DateTime getSettleDate(){
        return settleDate;
    }

    /**
     * 设置属性ClaimRate
     * @param claimRate 待设置的属性ClaimRate的值
     */
    public void setClaimRate(double claimRate){
        this.claimRate = claimRate;
    }

    /**
     * 获取属性ClaimRate
     * @return 属性ClaimRate的值
     */
    public double getClaimRate(){
        return claimRate;
    }

    /**
     * 设置属性NodeType
     * @param nodeType 待设置的属性NodeType的值
     */
    public void setNodeType(String nodeType){
        this.nodeType = StringUtils.rightTrim(nodeType);
    }

    /**
     * 获取属性NodeType
     * @return 属性NodeType的值
     */
    public String getNodeType(){
        return nodeType;
    }

    /**
     * 设置属性IndexOfSettle
     * @param indexOfSettle 待设置的属性IndexOfSettle的值
     */
    public void setIndexOfSettle(int indexOfSettle){
        this.indexOfSettle = indexOfSettle;
    }

    /**
     * 获取属性IndexOfSettle
     * @return 属性IndexOfSettle的值
     */
    public int getIndexOfSettle(){
        return indexOfSettle;
    }

    /**
     * 设置属性Phone
     * @param phone 待设置的属性Phone的值
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * 获取属性Phone
     * @return 属性Phone的值
     */
    public String getPhone(){
        return phone;
    }

    /**
     * 设置属性Bank
     * @param bank 待设置的属性Bank的值
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * 获取属性Bank
     * @return 属性Bank的值
     */
    public String getBank(){
        return bank;
    }

    /**
     * 设置属性FieldSource
     * @param fieldSource 待设置的属性FieldSource的值
     */
    public void setFieldSource(String fieldSource){
        this.fieldSource = StringUtils.rightTrim(fieldSource);
    }

    /**
     * 获取属性FieldSource
     * @return 属性FieldSource的值
     */
    public String getFieldSource(){
        return fieldSource;
    }

    /**
     * 设置属性FCodeModify
     * @param fcodeModify 待设置的属性FCodeModify的值
     */
    public void setFcodeModify(String fcodeModify){
        this.fcodeModify = StringUtils.rightTrim(fcodeModify);
    }

    /**
     * 获取属性FCodeModify
     * @return 属性FCodeModify的值
     */
    public String getFcodeModify(){
        return fcodeModify;
    }
    /**
     * 将信息转储到PlantingsettlelisttempDto 中
     * @return PlantingsettlelisttempDto
     */
    public Planting31SettleListTempDto evaluate(String registNo, int index, String timeStamp){
    	Planting31SettleListTempDto planting31SettleListTempDto = new Planting31SettleListTempDto();
    	planting31SettleListTempDto.setRegistCode(registNo);
    	planting31SettleListTempDto.setStringTimeStamp(timeStamp);
    	planting31SettleListTempDto.setIndexOfSettle(index);
    	planting31SettleListTempDto.setFcode(fcode);
    	planting31SettleListTempDto.setKindCode(kindCode);
    	planting31SettleListTempDto.setItemCode(itemCode);
    	planting31SettleListTempDto.setClassCode(classCode);
    	planting31SettleListTempDto.setRiskCode(riskCode);
    	planting31SettleListTempDto.setInsureArea(insureArea);
    	planting31SettleListTempDto.setSumInsured(sumInsured);
    	planting31SettleListTempDto.setZhiBuKa(zhiBuKa);
    	planting31SettleListTempDto.setFname(fname);
    	planting31SettleListTempDto.setFidCard(fidCard);
    	planting31SettleListTempDto.setFareaCode(fareaCode);
    	planting31SettleListTempDto.setInusreListCode(inusreListCode);
    	planting31SettleListTempDto.setGrowingSeason(growingSeason);
    	planting31SettleListTempDto.setLossRate(lossRate);
    	planting31SettleListTempDto.setSettleArea(settleArea);
    	planting31SettleListTempDto.setSettleSum(settleSum);
    	planting31SettleListTempDto.setOpCode(opCode);
    	planting31SettleListTempDto.setOpTime(opTime);
    	planting31SettleListTempDto.setRemark(remark);
    	planting31SettleListTempDto.setValidity(validity);
    	planting31SettleListTempDto.setSettleDate(settleDate);
    	planting31SettleListTempDto.setClaimRate(claimRate);
    	planting31SettleListTempDto.setNodeType(nodeType);
    	planting31SettleListTempDto.setPhone(phone);
    	planting31SettleListTempDto.setBank(bank);
    	planting31SettleListTempDto.setFieldSource(fieldSource);
    	return planting31SettleListTempDto;
    }
}
