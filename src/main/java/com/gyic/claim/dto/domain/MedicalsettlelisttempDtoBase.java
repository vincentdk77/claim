package com.gyic.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PLANTINGSETTLELIST�����ݴ���������<br>
 */
public class MedicalsettlelisttempDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
	    		
    /** ����STRINGTIMESTAMP */
    private String stringtimestamp = "";
	/** ����REGISTCODE */
	private String registcode = "";
	
    /** ����CLASSCODE */
    private String classcode = "";
    /** ����RISKCODE */
    private String riskcode = "";
	
    /** ����SUMINSURED */
    private double suminsured = 0D;
    /** ����MEDICALCARD */
    private String medicalcard = "";
	/** ����MEDICALFAMILY */
    private String medicalfamily = "";
    /** ����NAME */
    private String name = "";
    /** ����IDCARD */
    private String idcard = "";
	
    /** ����INUSRELISTCODE */
    private String inusrelistcode = "";
    /** ����CREDITCARD */
    private String creditcard = "";

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

    /** ����NODETYPE */
    private String nodetype = "";
    /** ����INDEXOFSETTLE */
    private int indexofsettle = 0;
    /** ����PHONE */
    private String phone = "";
    /** ����BANK */
    private String bank = "";


    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�MedicalsettlelistDtoBase����
     */
    public MedicalsettlelisttempDtoBase(){
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
     * ��������MEDICALCARD
     * @param zhibuka �����õ�����ZHIBUKA��ֵ
     */
    public void setMedicalcard(String medicalcard){
        this.medicalcard = StringUtils.rightTrim(medicalcard);
    }

    /**
     * ��ȡ����MEDICALCARD
     * @return ����MEDICALCARD��ֵ
     */
    public String getMedicalcard(){
        return medicalcard;
    }

	
	    /**
     * ��������MEDICALFAMILY
     * @param zhibuka �����õ�����MEDICALFAMILY��ֵ
     */
    public void setMedicalfamily(String medicalfamily){
        this.medicalfamily = StringUtils.rightTrim(medicalfamily);
    }

    /**
     * ��ȡ����MEDICALFAMILY
     * @return ����MEDICALFAMILY��ֵ
     */
    public String getMedicalfamily(){
        return medicalfamily;
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
     * ��������IDCARD
     * @param idcard �����õ�����IDCARD��ֵ
     */
    public void setIdcard(String idcard){
        this.idcard = StringUtils.rightTrim(idcard);
    }

    /**
     * ��ȡ����FIDCARD
     * @return ����FIDCARD��ֵ
     */
    public String getIdcard(){
        return idcard;
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
     * ��������CREDITCARD
     * @param CREDITCARD �����õ�����CREDITCARD��ֵ
     */
    public void setCreditcard(String creditcard){
        this.creditcard = StringUtils.rightTrim(creditcard);
    }

    /**
     * ��ȡ����CREDITCARD
     * @return ����CREDITCARD��ֵ
     */
    public String getCreditcard(){
        return creditcard;
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
     * ����Ϣת����MedicalsettlelistDto ��
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
