package com.gyic.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PLANTINGSETTLELISTTEMP的数据传输对象基类<br>
 */
public class PlantingsettlelisttempDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性REGISTCODE */
    private String registcode = "";
    /** 属性INDEXOFSETTLE */
    private int indexofsettle = 0;
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
    /** 属性PHONE */
    private String phone = "";
    /** 属性BANK */
    private String bank = "";
    /** 属性FIELDSOURCE */
    private String fieldsource = "";
    /** 属性STRINGTIMESTAMP */
    private String stringtimestamp = "";
    /** 属性WARRANT 林权证*/
    private String Warrant= "";
    /** 属性TAXAREA */
    private double taxarea = 0D;
    
    private String LitterArea = "";
    
    private String Atarea = "";
    
    //实有林地
    private double WoodlandArea= 0D;
    
    

    /**
     *  默认构造方法,构造一个默认的PlantingsettlelisttempDtoBase对象
     */
    public PlantingsettlelisttempDtoBase(){
    }

    /**
     * 设置属性REGISTCODE
     * @param registcode 待设置的属性REGISTCODE的值
     */
    public void setRegistcode(String registcode){
        this.registcode = StringUtils.rightTrim(registcode);
    }

    /**
     * 获取属性REGISTCODE
     * @return 属性REGISTCODE的值
     */
    public String getRegistcode(){
        return registcode;
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
     * 设置属性STRINGTIMESTAMP
     * @param stringtimestamp 待设置的属性STRINGTIMESTAMP的值
     */
    public void setStringtimestamp(String stringtimestamp){
        this.stringtimestamp = StringUtils.rightTrim(stringtimestamp);
    }
     /**
      * 获取属性STRINGTIMESTAMP
      * @return 属性STRINGTIMESTAMP的值
      */
     public String getStringtimestamp(){
         return stringtimestamp;
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
     * 将信息转储到PlantingsettlelistDto 中
     * @return PlantingsettlelistDto
     */
    public PlantingsettlelistDto evaluate(String settleListCode, int index){
    	PlantingsettlelistDto plantingSettleListDto = new PlantingsettlelistDto();
    	plantingSettleListDto.setSettlelistcode(settleListCode);
    	plantingSettleListDto.setFcode(fcode);
    	plantingSettleListDto.setKindcode(kindcode);
    	plantingSettleListDto.setClasscode(classcode);
    	plantingSettleListDto.setRiskcode(riskcode);
    	plantingSettleListDto.setInsurearea(insurearea);
    	plantingSettleListDto.setSuminsured(suminsured);
    	plantingSettleListDto.setZhibuka(zhibuka);
    	plantingSettleListDto.setFname(fname);
    	plantingSettleListDto.setFidcard(fidcard);
    	plantingSettleListDto.setFareacode(fareacode);
    	plantingSettleListDto.setInusrelistcode(inusrelistcode);
    	plantingSettleListDto.setGrowingseason(growingseason);
    	plantingSettleListDto.setLossrate(lossrate);
    	plantingSettleListDto.setSettlearea(settlearea);
    	plantingSettleListDto.setSettlesum(settlesum);
    	plantingSettleListDto.setOpcode(opcode);
    	plantingSettleListDto.setOptime(optime);
    	plantingSettleListDto.setRemark(remark);
    	plantingSettleListDto.setValidity(validity);
    	plantingSettleListDto.setSettledate(settledate);
    	plantingSettleListDto.setClaimrate(claimrate);
    	plantingSettleListDto.setNodetype(nodetype);
    	plantingSettleListDto.setIndexofsettle(index);
    	plantingSettleListDto.setPhone(phone);
    	plantingSettleListDto.setBank(bank);
    	plantingSettleListDto.setFieldsource(fieldsource);
    	plantingSettleListDto.setWarrant(Warrant);
    	plantingSettleListDto.setTaxarea(taxarea);
    	plantingSettleListDto.setAtarea(Atarea);
    	plantingSettleListDto.setLitterArea(LitterArea);
    	plantingSettleListDto.setWoodlandArea(WoodlandArea);
    	return plantingSettleListDto;
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
