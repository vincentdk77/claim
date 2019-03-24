package com.gyic.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;
import java.text.DecimalFormat;
/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PLANTINGSETTLELIST的数据传输对象基类<br>
 */
public class PlantingsettlelistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性SETTLELISTCODE */
    private String settlelistcode = "";
    /** 属性FCODE */
    private String fcode = "";
    /** 属性KINDCODE */
    private String kindcode = "";
    /** 属性CLASSCODE */
    private String classcode = "";
    /** 属性RISKCODE */
    private String riskcode = "";
    /** 属性INSUREAREA */
    private double insurearea = 0D;
    /** 属性SUMINSURED */
    private String suminsured = "";
    /** 属性ZHIBUKA */
    private String zhibuka = "";
    /** 属性FNAME */
    private String fname = "";
    /** 属性FIDCARD */
    private String fidcard = "";
    /** 属性FAREACODE */
    private String fareacode = "";
    /** 属性INUSRELISTCODE */
    private String inusrelistcode = "";
    /** 属性GROWINGSEASON */
    private double growingseason = 0D;
    /** 属性LOSSRATE */
    private double lossrate = 0D;
    /** 属性SETTLEAREA */
    private double settlearea = 0D;
    /** 属性SETTLESUM */
    private String settlesum = "";
    /** 属性OPCODE */
    private String opcode = "";
    /** 属性OPTIME */
    private DateTime optime = new DateTime();
    /** 属性REMARK */
    private String remark = "";
    /** 属性VALIDITY */
    private String validity = "";
    /** 属性SETTLEDATE */
    private DateTime settledate = new DateTime();
    /** 属性CLAIMRATE */
    private double claimrate = 0D;
    /** 属性NODETYPE */
    private String nodetype = "";
    /** 属性INDEXOFSETTLE */
    private int indexofsettle = 0;
    /** 属性PHONE */
    private String phone = "";
    /** 属性BANK */
    private String bank = "";
    /** 属性FIELDSOURCE */
    private String fieldSource = "";
    /** 属性WARRANT 林权证*/
    private String Warrant= "";
    /** 属性TAXAREA */
    private double taxarea = 0D;
    
    private String LitterArea = "";
    
    private String Atarea = "";
    
    //实有林地
    private double WoodlandArea= 0D;

    /**
     *  默认构造方法,构造一个默认的PlantingsettlelistDtoBase对象
     */
    public PlantingsettlelistDtoBase(){
    }

    /**
     * 设置属性SETTLELISTCODE
     * @param settlelistcode 待设置的属性SETTLELISTCODE的值
     */
    public void setSettlelistcode(String settlelistcode){
        this.settlelistcode = StringUtils.rightTrim(settlelistcode);
    }

    /**
     * 获取属性SETTLELISTCODE
     * @return 属性SETTLELISTCODE的值
     */
    public String getSettlelistcode(){
        return settlelistcode;
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
     * 设置属性SUMINSURED
     * @param suminsured 待设置的属性SUMINSURED的值
     */
    public void setSuminsured(String suminsured){
        this.suminsured = suminsured;
    }

    /**
     * 获取属性SUMINSURED
     * @return 属性SUMINSURED的值
     */
    public String getSuminsured(){
        return suminsured;
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
     * 设置属性GROWINGSEASON
     * @param growingseason 待设置的属性GROWINGSEASON的值
     */
    public void setGrowingseason(double growingseason){
        this.growingseason = growingseason;
    }

    /**
     * 获取属性GROWINGSEASON
     * @return 属性GROWINGSEASON的值
     */
    public double getGrowingseason(){
        return growingseason;
    }

    /**
     * 设置属性LOSSRATE
     * @param lossrate 待设置的属性LOSSRATE的值
     */
    public void setLossrate(double lossrate){
        this.lossrate = lossrate;
    }

    /**
     * 获取属性LOSSRATE
     * @return 属性LOSSRATE的值
     */
    public double getLossrate(){
        return lossrate;
    }

    /**
     * 设置属性SETTLEAREA
     * @param settlearea 待设置的属性SETTLEAREA的值
     */
    public void setSettlearea(double settlearea){
        this.settlearea = settlearea;
    }

    /**
     * 获取属性SETTLEAREA
     * @return 属性SETTLEAREA的值
     */
    public double getSettlearea(){
        return settlearea;
    }

    /**
     * 设置属性SETTLESUM
     * @param settlesum 待设置的属性SETTLESUM的值
     */
    public void setSettlesum(String settlesum){
        this.settlesum = settlesum;
    }

    /**
     * 获取属性SETTLESUM
     * @return 属性SETTLESUM的值
     */
    public String getSettlesum(){
        return settlesum;
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
     * 设置属性SETTLEDATE
     * @param settledate 待设置的属性SETTLEDATE的值
     */
    public void setSettledate(DateTime settledate){
        this.settledate = settledate;
    }

    /**
     * 获取属性SETTLEDATE
     * @return 属性SETTLEDATE的值
     */
    public DateTime getSettledate(){
        return settledate;
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
     * 设置属性INDEXOFSETTLE
     * @param indexofsettle 待设置的属性INDEXOFSETTLE的值
     */
    public void setIndexofsettle(int indexofsettle){
        this.indexofsettle = indexofsettle;
    }

    /**
     * 获取属性INDEXOFSETTLE
     * @return 属性INDEXOFSETTLE的值
     */
    public int getIndexofsettle(){
        return indexofsettle;
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
     * 设置属性FIELDSOURCE
     * @param fieldSource 待设置的属性BANK的值
     */
    public void setFieldsource(String fieldSource){
        this.fieldSource = StringUtils.rightTrim(fieldSource);
    }

    /**
     * 获取属性FIELDSOURCE
     * @return 属性FIELDSOURCE的值
     */
    public String getFieldsource(){
        return fieldSource;
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
     * 将信息转储到PlantingsettlelisttempDto 中
     * @return PlantingsettlelisttempDto
     */
    public PlantingsettlelisttempDto evaluate(String registNo, int index, String timeStamp){
    	PlantingsettlelisttempDto plantingSettleListTempDto = new PlantingsettlelisttempDto();
    	plantingSettleListTempDto.setRegistcode(registNo);
    	plantingSettleListTempDto.setStringtimestamp(timeStamp);
    	plantingSettleListTempDto.setIndexofsettle(index);
    	plantingSettleListTempDto.setFcode(fcode);
    	plantingSettleListTempDto.setKindcode(kindcode);
    	plantingSettleListTempDto.setClasscode(classcode);
    	plantingSettleListTempDto.setRiskcode(riskcode);
    	plantingSettleListTempDto.setInsurearea(insurearea);
    	DecimalFormat df = new DecimalFormat("##0.00");
    	Double number=Double.parseDouble(suminsured.toString());
    	
		 String strSumAmount = df.format(number);
        plantingSettleListTempDto.setSuminsured(strSumAmount);
    	plantingSettleListTempDto.setZhibuka(zhibuka);
    	plantingSettleListTempDto.setFname(fname);
    	plantingSettleListTempDto.setFidcard(fidcard);
    	plantingSettleListTempDto.setFareacode(fareacode);
    	plantingSettleListTempDto.setInusrelistcode(inusrelistcode);
    	plantingSettleListTempDto.setGrowingseason(growingseason);
    	plantingSettleListTempDto.setLossrate(lossrate);
    	plantingSettleListTempDto.setSettlearea(settlearea);
    	plantingSettleListTempDto.setSettlesum(settlesum);
    	plantingSettleListTempDto.setOpcode(opcode);
    	plantingSettleListTempDto.setOptime(optime);
    	plantingSettleListTempDto.setRemark(remark);
    	plantingSettleListTempDto.setValidity(validity);
    	plantingSettleListTempDto.setSettledate(settledate);
    	plantingSettleListTempDto.setClaimrate(claimrate);
    	plantingSettleListTempDto.setNodetype(nodetype);
    	plantingSettleListTempDto.setPhone(phone);
    	plantingSettleListTempDto.setBank(bank);
    	plantingSettleListTempDto.setFieldsource(fieldSource);
    	plantingSettleListTempDto.setWarrant(Warrant);
    	plantingSettleListTempDto.setTaxarea(taxarea);
    	plantingSettleListTempDto.setAtarea(Atarea);
    	plantingSettleListTempDto.setLitterArea(LitterArea);
    	plantingSettleListTempDto.setWoodlandArea(WoodlandArea);
    	return plantingSettleListTempDto;
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
