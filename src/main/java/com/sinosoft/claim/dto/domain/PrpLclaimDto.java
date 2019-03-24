package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;
/**
 * ����prplclaim����������Ϣ������ݴ��������<br>
 * ������ 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLclaimDto extends PrpLclaimDtoBase implements Serializable{

    /** ���Գ��տ�ʼ���� */
    private String damageStartMinute = "";
    
    /** ���Ծ��������� */
    private String handlerName = "";
    /** ���Դ��������� */
    private String agentName = "";
    /** ���Թ���ҵ��Ա���� */
    private String handler1Name = "";
    /** ���Բ������� */
    private String comName = "";
    /** ����������� */
    private String clauseType = "";
     /** ������������ */
    private String clauseName = "";
    /** ��������Ǽǻ������� */
    private String makeComName = "";
    /**���ƺ���  */
    private String licenseNo = "";
    /** �����ⰸ��� */
    //private String claimType = "";
    /** �����ⰸ������� */
    private String claimTypeName = "";
    /**���Ƶ�ɫ����  */
    private String licenseColorCode = "";
    /**���Ƶ�ɫ����  */
    private String licenseColor ="";
    /** �����⳥�������� */
    private String indemnityDutyName = "";
    /** ���Բ���Ա���� */
    private String operatorName = "";
    /**�����ͺ�  */
    private String brandName = "";
    /**��������  */
    private String carKindCode = "";
    private String carKind="";
    /** Dto����ʱ�ı༭״̬����Eidt,Add�ȵ� */
    private String editType ="";
      /** ������������� */
    private String compensateNo = "";
    /** ���Գ��մ��� */
    private int perilCount = 0;
    /** �˱���ʱ�� */
    private String reportDate ="";       // Modify By liuyanmei,2005-11-08

    /** �������Ĳ���״̬ 1��δ���� 2�����ڴ��� 3������� 4�����ύ 5�� ���� */
    private String status ="";       // Modify By Sunhao,2004-08-24
    /**���Դ˲鿱�����Ĳ���ʱ��*/
    private DateTime operateDate = new DateTime(); //Modify By Sunhao,2004-08-24

    /**��������ʾ���õ�  */
    private String alertMessage="";
    /**������һ����ѯ���õĲ�ѯ���*/
    private String whereString="";
    /** ���Գ�����ֹ���� */
    private String damageEndMinute = "";
    /** ���Ա��� */
    private int count =0;
    /** ������������ */
    private String riskCodeName="";
    /**�������ݱ�־�ĵڶ�λ*/
    private String escapeFlag2="";
    /**���Ծ������������*/
    private String dealerName="";
    /** �����б�*/
    Collection registList ;

    /** �б�*/
    Collection claimList ;
    // modify by qinyongli add start 2005-07-19
    /**������Ϣ*/
    private String coinsFlag = "";
    /**�˱�����*/
    private DateTime underWriteEndDate = null;
    /**��־λ��Ϣ*/
    private String othFlag  = "";
    /**����������� */
    private int familyNo = 0;
    /**�����������*/
    private String customerType = "";
    // modify by qinyongli add end  2005-07-19   
    //modify by wangwei add start 2005-06-16
    //ԭ����ӳ�����Ա��Ϣ
    /** ����AcciCode */
    private String acciCode = "";
    /** ����AcciName */
    private String acciName = "";
    /** ����Sex */
    private String sex = "";
    /** ����Age */
    private int age = 0;
    /** ����IdentifyNumber */
    private String identifyNumber = "";
    
    private String caseTypeName = ""; //���԰�������
    
    private String businessNatureName = ""; //���԰�������
    private String languageName = ""; //��������
    /**���Աұ�estiCurrency*/
    private String estiCurrency = "";               
    /**����ж������,���ڻ�����*/
    private Date prpLextUnloadDate = null;
    
    private String insuredNameShow  = ""; 
    private String appliNameShow = "";
    //add by zhaolu 20060802 start
    TurnPageDto turnPageDto = null;
    //add by zhaolu 20060802 end
    
   
    private double lossesNumber;
    private String lossesUnitCode;
    private double damageInsured;
    private double disasterArea;
    private String disasterUnit;
    private double affectedArea;
    private String affectedUnit;
    private double noProductionArea;
    private String noProductionUnit;
    private double deathQuantity;
    private String deathUnit;
    private double killQuantity;
    private String killUnit;

    
    private String businessType;
    private String businessType1;
    //�����־��0��ֱ��ҵ��1������ҵ��
    private String businessFlag = "";
    //������־����Ӧprpcmain�е�otherFlag��
    private String otherFlag = ""; 
    /** ����ҽ������ ������ͳ��ר�� */
    private String medicalType;
    
    /**���Գб�����*/
    private int sumInsured;
    /**����ע��ԭ��˵��*/
    private String cancelReasonExplan;

    
    public double getDisasterArea() {
		return disasterArea;
	}

	public void setDisasterArea(double disasterArea) {
		this.disasterArea = disasterArea;
	}

	public String getDisasterUnit() {
		return disasterUnit;
	}

	public void setDisasterUnit(String disasterUnit) {
		this.disasterUnit = disasterUnit;
	}

	public double getDamageInsured() {
		return damageInsured;
	}

	public void setDamageInsured(double damageInsured) {
		this.damageInsured = damageInsured;
	}

	public void setAppliNameShow(String appliNameShow){
    	
    	this.appliNameShow = StringUtils.rightTrim(appliNameShow);
    }
    
    public String getAppliNameShow(){
    	
    	return appliNameShow;
    }
    
    public void setInsuredNameShow(String insuredNameShow){
    	
    	this.insuredNameShow = StringUtils.rightTrim(insuredNameShow);
    }
    
    public String getInsuredNameShow(){
    	
    	return insuredNameShow;
    }
    /**
     * ��������businessNatureName
     * @param businessNatureName �����õ�����businessNatureName��ֵ
     */
    public void setBusinessNatureName(String businessNatureName){
        this.businessNatureName = StringUtils.rightTrim(businessNatureName);
    }

    /**
     * ��ȡ����businessNatureName
     * @return ����businessNatureName��ֵ
     */
    public String getBusinessNatureName(){
        return businessNatureName;
    }
    
     /**
     * ��������businessNatureName
     * @param businessNatureName �����õ�����businessNatureName��ֵ
     */
    public void setLanguageName(String languageName){
        this.languageName = StringUtils.rightTrim(languageName);
    }

    /**
     * ��ȡ����businessNatureName
     * @return ����businessNatureName��ֵ
     */
    public String getLanguageName(){
        return languageName;
    }
   
    /**
     * ��������AcciCode
     * @param acciCode �����õ�����AcciCode��ֵ
     */
    public void setAcciCode(String acciCode){
        this.acciCode = StringUtils.rightTrim(acciCode);
    }

    /**
     * ��ȡ����AcciCode
     * @return ����AcciCode��ֵ
     */
    public String getAcciCode(){
        return acciCode;
    }

    /**
     * ��������AcciName
     * @param acciName �����õ�����AcciName��ֵ
     */
    public void setAcciName(String acciName){
        this.acciName = StringUtils.rightTrim(acciName);
    }

    /**
     * ��ȡ����AcciName
     * @return ����AcciName��ֵ
     */
    public String getAcciName(){
        return acciName;
    }

    /**
     * ��������Sex
     * @param sex �����õ�����Sex��ֵ
     */
    public void setSex(String sex){
        this.sex = StringUtils.rightTrim(sex);
    }

    /**
     * ��ȡ����Sex
     * @return ����Sex��ֵ
     */
    public String getSex(){
        return sex;
    }

    /**
     * ��������Age
     * @param age �����õ�����Age��ֵ
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * ��ȡ����Age
     * @return ����Age��ֵ
     */
    public int getAge(){
        return age;
    }
    
    /**
     * ��������IdentifyNumber
     * @param identifyNumber �����õ�����IdentifyNumber��ֵ
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * ��ȡ����IdentifyNumber
     * @return ����IdentifyNumber��ֵ
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    //modify by wangwei add end  2005-06-16
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLclaimDto����
     */
     public PrpLclaimDto(){
     	
     	escapeFlag2="N";
    }

    public void setHandlerName(String handlerName){
        this.handlerName = StringUtils.rightTrim(handlerName);
    }

    /**
     * ��ȡ�����⳥��������
     * @return �����⳥�������Ƶ�ֵ
     */
    public String getIndemnityDutyName(){
        return indemnityDutyName;
    }

    /**
     * ���������⳥��������
     * @param indemnityDutyName �����õ������⳥�������Ƶ�ֵ
     */
    public void setIndemnityDutyName(String indemnityDutyName){
        this.indemnityDutyName = StringUtils.rightTrim(indemnityDutyName);
    }

    /**
     * ��ȡ���Ծ����˴���
     * @return ���Ծ����˴����ֵ
     */
    public String getHandler1Name(){
        return handler1Name;
    }

    /**
     * �������Ծ����˴���
     * @param handlerCode �����õ����Ծ����˴����ֵ
     */
    public void setHandler1Name(String handler1Name){
        this.handler1Name = StringUtils.rightTrim(handler1Name);
    }

    /**
     * ��ȡ���Ծ����˴���
     * @return ���Ծ����˴����ֵ
     */
    public String getHandlerName(){
        return handlerName;
    }

    /**
     * �������Բ���
     * @param comName �����õ����Բ��ŵ�ֵ
     */
    public void setComName(String comName){
        this.comName = StringUtils.rightTrim(comName);
    }

    /**
     * ��ȡ���Բ���
     * @return ���Բ��ŵ�ֵ
     */
    public String getComName(){
        return comName;
    }

    /**
     * �������Գ��տ�ʼ����
     * @param damageStartMinute �����õ����Գ��տ�ʼ���ӵ�ֵ
     */
    public void setDamageStartMinute(String damageStartMinute){
        this.damageStartMinute= StringUtils.rightTrim(damageStartMinute);
    }

    /**
     * ��ȡ���Գ��տ�ʼ����
     * @return ���Գ��տ�ʼ���ӵ�ֵ
     */
    public String getDamageStartMinute(){
        return damageStartMinute;
    }

   /**
    * ���ñ༭����
    * @param editType �����õı༭���͵�ֵ
    */
   public void setEditType(String editType){
       this.editType = StringUtils.rightTrim(editType);
   }

   /**
    * ��ȡ�༭����
    * @return ���Ա༭����
    */
   public String getEditType(){
       return editType;
   }
/**
    * ��ȡ�б�
    * @return �����б�
    */
   public Collection getClaimList(){
     return claimList;
   }

   /**
    * �����б�
    * @param registList �����õ��б�
    */
   public void setClaimList(Collection claimList) {
     this.claimList = claimList;
   }

 /**
     * ���������������
     * @param clauseType �����õ�������������ֵ
     */
    public void setClauseType(String clauseType){
        this.clauseType = StringUtils.rightTrim(clauseType);
    }

    /**
     * ��ȡ�����������
     * @return ������������ֵ
     */
    public String getClauseType(){
        return clauseType;
    }

 /**
     * �������Գ��ƺ���
     * @param licenseNo �����õ����Գ��ƺ����ֵ
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * ��ȡ���Գ��ƺ���
     * @return ���Գ��ƺ����ֵ
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * �������Գ��Ƶ�ɫ����
     * @param licenseColorCode �����õ����Գ��Ƶ�ɫ�����ֵ
     */
    public void setLicenseColorCode(String licenseColorCode){
        this.licenseColorCode = StringUtils.rightTrim(licenseColorCode);
    }

    /**
     * ��ȡ���Գ��Ƶ�ɫ����
     * @return ���Գ��Ƶ�ɫ�����ֵ
     */
    public String getLicenseColorCode(){
        return licenseColorCode;
    }

     /**
     * �������Գ��Ƶ�ɫ����
     * @param licenseColorCode �����õ����Գ��Ƶ�ɫ�����ֵ
     */
    public void setLicenseColor(String licenseColor){
        this.licenseColor = StringUtils.rightTrim(licenseColor);
    }

    /**
     * ��ȡ���Գ��Ƶ�ɫ����
     * @return ���Գ��Ƶ�ɫ�����ֵ
     */
    public String getLicenseColor(){
        return licenseColor;
    }


    /**
     * �������Գ����������
     * @param carKindCode �����õ����Գ�����������ֵ
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * ��ȡ���Գ����������
     * @return ���Գ�����������ֵ
     */
    public String getCarKindCode(){
        return carKindCode;
    }

     /**
     * �������Գ�������
     * @param carKind�����õ����Գ��������ֵ
     */
    public void setCarKind(String carKind){
        this.carKind = StringUtils.rightTrim(carKind);
    }

    /**
     * ���������ⰸ���
     * @param claimType �����õ������ⰸ����ֵ
     */
   /* public void setClaimType(String claimType){
        this.claimType = StringUtils.rightTrim(claimType);
    }*/

    /**
     * ��ȡ�����ⰸ���
     * @return �����ⰸ����ֵ
     */
    /*public String getClaimType(){
        return claimType;
    }
   */
    
    /**
     * ���������ⰸ�������
     * @param claimTypeName �����õ������ⰸ������Ƶ�ֵ
     */
    public void setClaimTypeName(String claimTypeName){
        this.claimTypeName = StringUtils.rightTrim(claimTypeName);
    }

    /**
     * ��ȡ�����ⰸ�������
     * @return �����ⰸ������Ƶ�ֵ
     */
    public String getClaimTypeName(){
        return claimTypeName;
    }
    /**
     * ��ȡ���Գ�������
     * @return ���Գ�������ֵ
     */
    public String getCarKind(){
        return carKind;
    }

    /**
     * ����������������
     * @param clauseName �����õ������������Ƶ�ֵ
     */
    public void setClauseName(String clauseName){
        this.clauseName = StringUtils.rightTrim(clauseName);
    }

    /**
     * ������������Ǽǻ�������
     * @param makeComName �����õ���������Ǽǻ������Ƶ�ֵ
     */
    public void setMakeComName(String makeComName){
        this.makeComName = StringUtils.rightTrim(makeComName);
    }

    /**
     * ��ȡ��������Ǽǻ�������
     * @return ��������Ǽǻ������Ƶ�ֵ
     */
    public String getMakeComName(){
        return makeComName;
    }

    /**
     * ��ȡ������������
     * @return �����������Ƶ�ֵ
     */
    public String getClauseName(){
        return clauseName;
    }

      /**
     * �������Գ����ͺ�
     * @param brandName �����õ����Գ����ͺŵ�ֵ
     */
    public void setBrandName(String brandName){
        this.brandName = StringUtils.rightTrim(brandName);
    }

    /**
     * ��ȡ���Գ����ͺ�
     * @return ���Գ����ͺŵ�ֵ
     */
    public String getBrandName(){
        return brandName;
    }


   /**
     * ��ȡ���Դ���������
     * @return ���Դ��������Ƶ�ֵ
     */
    public String getAgentName(){
        return agentName;
    }

    /**
     * �������Դ���������
     * @param AgentName �����õ����Դ���������
     */
    public void setAgentName(String agentName){
        this.agentName = StringUtils.rightTrim(agentName);
    }

    /**
     * �������Բ���Ա����
     * @param operatorName �����õ����Բ���Ա���Ƶ�ֵ
     */
    public void setOperatorName(String operatorName){
        this.operatorName = StringUtils.rightTrim(operatorName);
    }

    /**
     * ��ȡ���Բ���Ա����
     * @return ���Բ���Ա���Ƶ�ֵ
     */
    public String getOperatorName(){
        return operatorName;
    }

    /**
     * �������Բ���״̬
     * @param status �����õ����Բ���״̬
     * Modify By Sunhao,2004-08-24
     */
    public void setStatus(String status){
        this.status = StringUtils.rightTrim(status);
    }

    /**
     * ��ȡ���Բ���״̬
     * @return ���Բ���״̬
     * Modify By Sunhao,2004-08-24
     */
    public String getStatus(){
        return status;
    }

   /**
    * �������Բ���ʱ��
    * @param operateDate �����õ����Բ���ʱ��
    * Modify By Sunhao,2004-08-24
    */
    public void setOperateDate(DateTime operateDate){
        this.operateDate = operateDate;
    }

    /**
     * ��ȡ���Բ���ʱ������
     * @param status �����õ����Բ���ʱ��
     * Modify By Sunhao,2004-08-24
     */

    public DateTime getOperateDate(){
         return operateDate;
     }


     /**
     * ����������������ʾ���õ���Ϣ
     * @param alertMessage �����õ�������������ʾ���õ���Ϣ��ֵ
     */
    public void setAlertMessage(String alertMessage){
        this.alertMessage = StringUtils.rightTrim(alertMessage);
    }

    /**
     * ��ȡ��������ʾ���õ���Ϣ
     * @return ������������ʾ���õ���Ϣ
     */
    public String getAlertMessage(){
        return alertMessage;
    }


 /**
     * �������Ա�����һ����ѯ���õĲ�ѯ���
     * @param whereString �����õ����Ա�����һ����ѯ���õĲ�ѯ����ֵ
     */
    public void setWhereString(String whereString){
        this.whereString = StringUtils.rightTrim(whereString);
    }

  public void setDamageEndMinute(String damageEndMinute) {
    this.damageEndMinute = damageEndMinute;
  }

  /**
     * ��ȡ������һ����ѯ���õĲ�ѯ���
     * @return ���Ա�����һ����ѯ���õĲ�ѯ���
     */
    public String getWhereString(){
        return whereString;
    }

  public String getDamageEndMinute() {
    return damageEndMinute;
  }


  /**
     * �������Ա���
     * @param count �����õ����Ա�����ֵ
     */
    public void setCount(int count){
        this.count = count;
    }

    /**
     * ��ȡ���Ա���
     * @return ���Ա�����ֵ
     */
    public int getCount(){
        return count;
    }
    /**
         * ����������������
         * @param riskCodeName �����õ������������Ƶ�ֵ
         */
        public void setRiskCodeName(String riskCodeName){
            this.riskCodeName = StringUtils.rightTrim(riskCodeName);
        }

        /**
         * ��ȡ������������
         * @return �����������Ƶ�ֵ
         */
        public String getRiskCodeName(){
            return riskCodeName;
        }

 /**
     * �����������������
     * @param compensateNo �����õ�������������ŵ�ֵ
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * ��ȡ�������������
     * @return ������������ŵ�ֵ
     */
    public String getCompensateNo(){
        return compensateNo;
    }
    
    
    /**
     * �������Գ��մ���
     * @param perilCount �����õ����Գ��մ�����ֵ
     */
    public void setPerilCount(int perilCount){
        this.perilCount = perilCount;
    }

    /**
     * ��ȡ���Գ��մ���
     * @return ���Գ��մ�����ֵ
     */
    public int getPerilCount(){
        return perilCount;
    }
    
    /**
     * ��ȡ�б�
     * @return �����б�
     */
    public Collection getRegistList(){
      return registList;
    }

    /**
     * �����б�
     * @param registList �����õ��б�
     */
    public void setRegistList(Collection registList) {
      this.registList = registList;
    }
    
    
     /**
     * ���������Ƿ�Ϊȫ��
     * @param escapeFlag �����õ������Ƿ�Ϊȫ���ֵ
     */
    public void setEscapeFlag2(String escapeFlag2){
        this.escapeFlag2 = StringUtils.rightTrim(escapeFlag2);
    }

    /**
     * ��ȡ�����Ƿ�Ϊȫ��
     * @return �����Ƿ�Ϊȫ���ֵ
     */
    public String getEscapeFlag2(){
        return escapeFlag2;
    }
    
     /**
     * �������Ծ������������
     * @param dealerName �����õ����Ծ�����������Ƶ�ֵ
     */
    public void setDealerName (String dealerName ){
        this.dealerName  = StringUtils.rightTrim(dealerName );
    }

    /**
     * ��ȡ���Ծ������������
     * @return ���Ծ�����������Ƶ�ֵ
     */
    public String getDealerName (){
        return dealerName ;
    }
    /**
     * �������Թ�����Ϣ
     * @param coinsFlag ������Ϣ
     */
    public void setCoinsFlag(String coinsFlag ){
        this.coinsFlag  = coinsFlag ;
    }

    /**
     * ��ȡ���Թ�����Ϣ
     * @return ������Ϣ
     */
    public String getCoinsFlag(){
        return coinsFlag ;
    }
    /**
     * �������Ժ˱���Ϣ
     * @param coinsFlag �˱���Ϣ
     */
    public void setUnderWriteEndDate(DateTime underWriteEndDate ){
        this.underWriteEndDate  = underWriteEndDate ;
    }

    /**
     * ��ȡ���Ժ˱���Ϣ
     * @return �˱���Ϣ
     */
    public DateTime getUnderWriteEndDate(){
        return underWriteEndDate ;
    }
    /**
     * �������Ժ˱���Ϣ
     * @param coinsFlag �˱���Ϣ
     */
    public void setOthFlag(String othFlag ){
        this.othFlag  = othFlag ;
    }

    /**
     * ��ȡ���Ժ˱���ϢothFlag
     * @return �˱���Ϣ
     */
    public String getOthFlag(){
        return othFlag ;
    }
    
    /**
     * �������԰�������
     * @param ��������
     * */
    public void setCaseTypeName(String caseTypeName) {
    	 this.caseTypeName = caseTypeName;
    }
    
    /**
     * ������԰�������
     * @return caseTypeName ��������
     * */
    public String getCaseTypeName() {
    	return this.caseTypeName;
    }
    /**
     * �������
     * @param ���
     * */
    public void setFamilyNo(int familyNo) {
    	 this.familyNo = familyNo;
    }
    
    /**
     * ����������
     * @return caseTypeName ���
     * */
    public int getFamilyNo() {
    	return this.familyNo;
    }
    /**
     * �����������
     * @param �����������
     * */
    public void setCustomerType(String customerType) {
    	 this.customerType = customerType;
    }
    
    /**
     * �����������
     * @return  �����������
     * */
    public String getCustomerType() {
    	return this.customerType;
    }
    
    /**
     * ���ñұ���Ϣ
     * @param EstiCurrency �ұ�
     * */
    public void setEstiCurrency(String estiCurrency) {
    	this.estiCurrency = estiCurrency;
    }
    /**
     * ��ñұ���Ϣ
     * @return EstiCurrency �ұ���Ϣ
     * */   
    public String getEstiCurrency() {
    	return this.estiCurrency;
    }
    /**
     * ����ж������
     * @param ����ж������
     * */
    public void setprpLextUnloadDate(Date prpLextUnloadDate) {
    	this.prpLextUnloadDate = prpLextUnloadDate;
    }
    /**
     * ����ж������
     * @return ����ж������
     * */   
    public Date getprpLextUnloadDate() {
    	return this.prpLextUnloadDate;
    }
//modify by liuyanmei add 
    public void setReportDate(String reportDate){
        this.reportDate = StringUtils.rightTrim(reportDate);
    }

    /**
     * ��ȡ����AcciName
     * @return ����AcciName��ֵ
     */
    public String getReportDate(){
        return reportDate;
    }

	public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}

	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}


	public String getLossesUnitCode() {
		return lossesUnitCode;
	}

	public void setLossesUnitCode(String lossesUnitCode) {
		this.lossesUnitCode = lossesUnitCode;
	}

	public double getLossesNumber() {
		return lossesNumber;
	}

	public void setLossesNumber(double lossesNumber) {
		this.lossesNumber = lossesNumber;
	}

	public double getAffectedArea() {
		return affectedArea;
	}

	public void setAffectedArea(double affectedArea) {
		this.affectedArea = affectedArea;
	}

	public String getAffectedUnit() {
		return affectedUnit;
	}

	public void setAffectedUnit(String affectedUnit) {
		this.affectedUnit = affectedUnit;
	}

	public double getNoProductionArea() {
		return noProductionArea;
	}

	public void setNoProductionArea(double noProductionArea) {
		this.noProductionArea = noProductionArea;
	}

	public String getNoProductionUnit() {
		return noProductionUnit;
	}

	public void setNoProductionUnit(String noProductionUnit) {
		this.noProductionUnit = noProductionUnit;
	}

	public double getDeathQuantity() {
		return deathQuantity;
	}

	public void setDeathQuantity(double deathQuantity) {
		this.deathQuantity = deathQuantity;
	}

	public String getDeathUnit() {
		return deathUnit;
	}

	public void setDeathUnit(String deathUnit) {
		this.deathUnit = deathUnit;
	}

	public double getKillQuantity() {
		return killQuantity;
	}

	public void setKillQuantity(double killQuantity) {
		this.killQuantity = killQuantity;
	}

	public String getKillUnit() {
		return killUnit;
	}

	public void setKillUnit(String killUnit) {
		this.killUnit = killUnit;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessType1() {
		return businessType1;
	}

	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	}
	
	public String getBusinessFlag() {
		return businessFlag;
	}

	public void setBusinessFlag(String businessFlag) {
		this.businessFlag = businessFlag;
	}

	public String getOtherFlag() {
		return otherFlag;
	}

	public void setOtherFlag(String otherFlag) {
		this.otherFlag = otherFlag;
	}

	/**
	 * ��ȡ����ҽ������
	 * @return
	 */
	public String getMedicalType() {
		return medicalType;
	}

	/**
	 * ��������ҽ������
	 * @param medicalType
	 */
	public void setMedicalType(String medicalType) {
		this.medicalType = medicalType;
	}

	/**
	 * �������Գб�����
	 * @return
	 */
	public int getSumInsured() {
		return sumInsured;
	}
	
	/**
	 * �������Գб�����
	 * @return sumInsured
	 */
	public void setSumInsured(int sumInsured) {
		this.sumInsured = sumInsured;
	}

	public String getCancelReasonExplan() {
		return cancelReasonExplan;
	}

	public void setCancelReasonExplan(String cancelReasonExplan) {
		this.cancelReasonExplan = cancelReasonExplan;
	}

	
	
	
}
