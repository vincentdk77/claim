package com.gyic.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PLANTINGSETTLELIST的数据传输对象基类<br>
 */
public class MedicalsettlelisttempDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
	    		
    /** 属性STRINGTIMESTAMP */
    private String stringtimestamp = "";
	/** 属性REGISTCODE */
	private String registcode = "";
	
    /** 属性CLASSCODE */
    private String classcode = "";
    /** 属性RISKCODE */
    private String riskcode = "";
	
    /** 属性SUMINSURED */
    private double suminsured = 0D;
    /** 属性MEDICALCARD */
    private String medicalcard = "";
	/** 属性MEDICALFAMILY */
    private String medicalfamily = "";
    /** 属性NAME */
    private String name = "";
    /** 属性IDCARD */
    private String idcard = "";
	
    /** 属性INUSRELISTCODE */
    private String inusrelistcode = "";
    /** 属性CREDITCARD */
    private String creditcard = "";

    /** 属性SETTLESUM */
    private double settlesum = 0D;
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

    /** 属性NODETYPE */
    private String nodetype = "";
    /** 属性INDEXOFSETTLE */
    private int indexofsettle = 0;
    /** 属性PHONE */
    private String phone = "";
    /** 属性BANK */
    private String bank = "";


    /**
     *  默认构造方法,构造一个默认的MedicalsettlelistDtoBase对象
     */
    public MedicalsettlelisttempDtoBase(){
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
     * 设置属性SUMINSURED
     * @param suminsured 待设置的属性SUMINSURED的值
     */
    public void setSuminsured(double suminsured){
        this.suminsured = suminsured;
    }

    /**
     * 获取属性SUMINSURED
     * @return 属性SUMINSURED的值
     */
    public double getSuminsured(){
        return suminsured;
    }

    /**
     * 设置属性MEDICALCARD
     * @param zhibuka 待设置的属性ZHIBUKA的值
     */
    public void setMedicalcard(String medicalcard){
        this.medicalcard = StringUtils.rightTrim(medicalcard);
    }

    /**
     * 获取属性MEDICALCARD
     * @return 属性MEDICALCARD的值
     */
    public String getMedicalcard(){
        return medicalcard;
    }

	
	    /**
     * 设置属性MEDICALFAMILY
     * @param zhibuka 待设置的属性MEDICALFAMILY的值
     */
    public void setMedicalfamily(String medicalfamily){
        this.medicalfamily = StringUtils.rightTrim(medicalfamily);
    }

    /**
     * 获取属性MEDICALFAMILY
     * @return 属性MEDICALFAMILY的值
     */
    public String getMedicalfamily(){
        return medicalfamily;
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
     * 设置属性IDCARD
     * @param idcard 待设置的属性IDCARD的值
     */
    public void setIdcard(String idcard){
        this.idcard = StringUtils.rightTrim(idcard);
    }

    /**
     * 获取属性FIDCARD
     * @return 属性FIDCARD的值
     */
    public String getIdcard(){
        return idcard;
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
     * 设置属性CREDITCARD
     * @param CREDITCARD 待设置的属性CREDITCARD的值
     */
    public void setCreditcard(String creditcard){
        this.creditcard = StringUtils.rightTrim(creditcard);
    }

    /**
     * 获取属性CREDITCARD
     * @return 属性CREDITCARD的值
     */
    public String getCreditcard(){
        return creditcard;
    }


    /**
     * 设置属性SETTLESUM
     * @param settlesum 待设置的属性SETTLESUM的值
     */
    public void setSettlesum(double settlesum){
        this.settlesum = settlesum;
    }

    /**
     * 获取属性SETTLESUM
     * @return 属性SETTLESUM的值
     */
    public double getSettlesum(){
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
     * 将信息转储到MedicalsettlelistDto 中
     * @return MedicalsettlelistDto
     */
    public MedicalsettlelistDto evaluate(String settleListCode, int index){
    	MedicalsettlelistDto MedicalSettleListDto = new MedicalsettlelistDto();
    	MedicalSettleListDto.setSettlelistcode(settleListCode);

    	MedicalSettleListDto.setClasscode(classcode);
    	MedicalSettleListDto.setRiskcode(riskcode);

    	MedicalSettleListDto.setSuminsured(suminsured);
    	MedicalSettleListDto.setMedicalcard(medicalcard);
    	MedicalSettleListDto.setMedicalfamily(medicalfamily);
    	MedicalSettleListDto.setName(name);
    	MedicalSettleListDto.setIdcard(idcard);
    	MedicalSettleListDto.setCreditcard(creditcard);
    	MedicalSettleListDto.setInusrelistcode(inusrelistcode);

    	MedicalSettleListDto.setSettlesum(settlesum);
    	MedicalSettleListDto.setOpcode(opcode);
    	MedicalSettleListDto.setOptime(optime);
    	MedicalSettleListDto.setRemark(remark);
    	MedicalSettleListDto.setValidity(validity);
    	MedicalSettleListDto.setSettledate(settledate);

    	MedicalSettleListDto.setNodetype(nodetype);
    	MedicalSettleListDto.setIndexofsettle(index);
    	MedicalSettleListDto.setPhone(phone);
    	MedicalSettleListDto.setBank(bank);

    	return MedicalSettleListDto;
    }
}
