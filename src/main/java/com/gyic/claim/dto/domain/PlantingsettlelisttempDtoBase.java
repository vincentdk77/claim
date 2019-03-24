package com.gyic.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PLANTINGSETTLELISTTEMP�����ݴ���������<br>
 */
public class PlantingsettlelisttempDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����REGISTCODE */
    private String registcode = "";
    /** ����INDEXOFSETTLE */
    private int indexofsettle = 0;
    /** ����FCODE */
    private String fcode = "";
    /** ����KINDCODE */
    private String kindcode = "";
    /** ����CLASSCODE */
    private String classcode = "";
    /** ����RISKCODE */
    private String riskcode = "";
    /** ����INSUREAREA */
    private double insurearea = 0D;
    /** ����SUMINSURED */
    private String suminsured = "";
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
    private String settlesum = "";
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
    /** ����FIELDSOURCE */
    private String fieldsource = "";
    /** ����STRINGTIMESTAMP */
    private String stringtimestamp = "";
    /** ����WARRANT ��Ȩ֤*/
    private String Warrant= "";
    /** ����TAXAREA */
    private double taxarea = 0D;
    
    private String LitterArea = "";
    
    private String Atarea = "";
    
    //ʵ���ֵ�
    private double WoodlandArea= 0D;
    
    

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PlantingsettlelisttempDtoBase����
     */
    public PlantingsettlelisttempDtoBase(){
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
    public void setSuminsured(String suminsured){
        this.suminsured = suminsured;
    }

    /**
     * ��ȡ����SUMINSURED
     * @return ����SUMINSURED��ֵ
     */
    public String getSuminsured(){
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
    public void setSettlesum(String settlesum){
        this.settlesum = settlesum;
    }

    /**
     * ��ȡ����SETTLESUM
     * @return ����SETTLESUM��ֵ
     */
    public String getSettlesum(){
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
      * ��ȡ����WARRANT
      * @return ����WARRANT��ֵ
      */
     public String getWarrant(){
         return Warrant;
     }
     /**
      * ��������STRINGTIMESTAMP
      * @param stringtimestamp �����õ�����STRINGTIMESTAMP��ֵ
      */
     public void setWarrant(String Warrant){
         this.Warrant = StringUtils.rightTrim(Warrant);
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
     * ����Ϣת����PlantingsettlelistDto ��
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
