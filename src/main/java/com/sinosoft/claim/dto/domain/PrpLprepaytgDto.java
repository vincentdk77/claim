package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prplprepayԤ��ǼǱ�����ݴ��������<br>
 * ������ 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLprepaytgDto extends PrpLprepaytgDtoBase implements Serializable{


    /** ���Դ����˴��� */
    private String agentCode = "";
    /** ���Գ��տ�ʼ���� */
    private String damageStartMinute = "";
    /** ���Ե�ַ���� */
    private String addressCode = "";
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
    /**���ƺ���  */
    private String licenseNo = "";
    /**���Ƶ�ɫ����  */
    private String licenseColorCode = "";
    /** ���������� */
    private DateTime startDate = new DateTime();
    /** �����ձ����� */
    private DateTime endDate = new DateTime();
    /** ���Ա�����ʧ��� */
    private double sumClaim = 0d;
    /** ����ҵ������������� */
    private String comCode = "";
    /** �����ܱ��� */
    private double sumAmount = 0d;
    /** �����ܱ��� */
    private double sumPremium = 0d;
    /** ���Գ��յص������� */
    private String damageAddressType = "";
    /** ���Գ��յص� */
    private String damageAddress = "";
    /**���Ƶ�ɫ����  */
    private String licenseColor ="";
    /**��������  */
    private String engineNo = "";
    /** ���Գ��������� */
    private DateTime damageStartDate = new DateTime();
    /** ���Գ��տ�ʼСʱ */
    private String damageStartHour = "";
    /**���ܺ�  */
    private String frameNo = "";
    /**�����ͺ�  */
    private String brandName = "";
    /**��������  */
    private String carKindCode = "";
    /**��������  */
    private String carKind="";
    /** tgDto����ʱ�ı༭״̬����Eidt,Add�ȵ� */
    private String editType ="";
    /**�ұ�����  */
    private String currencyName = "";
      /** ����������� */
    private String classCode = "";
  
    
    /** ���Գ��մ��� */
    private int perilCount = 0;

    /** �б�*/
    Collection claimList ;
    /** ���Դ˲鿱�����Ĳ���״̬ 1��δ���� 2�����ڴ��� 3������� 4�����ύ 5�� ���� */
    private String status ="";             //Modify By Sunhao,2004-08-24
    /**���Դ˲鿱�����Ĳ���ʱ��*/
    private DateTime operateDate = new DateTime();//Modify By Sunhao,2004-08-24
    
    private String registNo;
    
     /** �����б�*/
   Collection registList ;

     /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLctexttgDto����
     */
    public PrpLprepaytgDto(){

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
     * �������Բ���״̬
     * @param status �����õ����Բ���״̬
     * Modify By Sunhao,2004-08-24
     */
    public void setStatus(String status){
        this.status = StringUtils.rightTrim(status);
    }
    /**
     * �������Ծ����˴���
     * @param handlerName ���Ծ����˴���
     */
    public void setHandlerName(String handlerName){
      this.handlerName = StringUtils.rightTrim(handlerName);
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
     * �������Ե�ַ����
     * @param addressCode �����õ����Ե�ַ�����ֵ
     */
    public void setAddressCode(String addressCode){
        this.addressCode = StringUtils.rightTrim(addressCode);
    }

    /**
     * ��ȡ���Ե�ַ����
     * @return ���Ե�ַ����
     */
    public String getAddressCode(){
        return addressCode;
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
     * ��ȡ�����˴���
     * @return agentCode �����˴���
     */
    public String getAgentCode() {
      return agentCode;
    }
   /**
     * ��ȡ�ձ�����
     * @return �ձ�����
     */
    public DateTime getEndDate() {
      return endDate;
    }
    /**
     * ��ȡ������
     * @return ������
     */
    public DateTime getStartDate() {
      return startDate;
    }
    /**
     * ��ȡ���ܺ�
     * @return ���ܺ�
     */
    public String getFrameNo() {
      return frameNo;
    }
    /**
     * ��ȡ��������
     * @return ��������
     */
    public String getEngineNo() {
      return engineNo;
    }
    /**
     * ��ȡ���տ�ʼСʱ
     * @return ���տ�ʼСʱ
     */
    public String getDamageStartHour() {
      return damageStartHour;
    }
    /**
     * ��ȡ����������
     * @return ����������
     */
    public DateTime getDamageStartDate() {
      return damageStartDate;
    }
    /**
     * ��ȡ���յص�������
     * @return ���յص�������
     */
    public String getDamageAddressType() {
      return damageAddressType;
    }
    /**
     * ��ȡ���յص�
     * @return ���յص�
     */
    public String getDamageAddress() {
      return damageAddress;
    }
    /**
     * ��ȡ�ܱ���
     * @return �ܱ���
     */
    public double getSumPremium() {
      return sumPremium;
    }
    /**
     * ��ȡ�ܱ���
     * @return �ܱ���
     */
    public double getSumAmount() {
      return sumAmount;
    }
    /**
     * ��ȡ������ʧ���
     * @return ������ʧ���
     */
    public double getSumClaim() {
      return sumClaim;
    }
    /**
     * ��ȡҵ�������������
     * @return ҵ�������������
     */
    public String getComCode() {
      return comCode;
    }

    /**
     * �������Դ���������
     * @param AgentName �����õ����Դ���������
     */
    public void setAgentName(String agentName){
        this.agentName = StringUtils.rightTrim(agentName);
    }
    /**
     * ��ȡҵ�������������
     * @return ҵ�������������
     */
    public void setAgentCode(String agentCode) {
      this.agentCode = agentCode;
    }
    /**
     * ��ȡ�ձ�����
     * @return endDate �ձ�����
     */
    public void setEndDate(DateTime endDate) {
      this.endDate = endDate;
    }
    /**
     * ��ȡ������
     * @return endDate ������
     */
    public void setStartDate(DateTime startDate) {
      this.startDate = startDate;
    }
    /**
     * ��ȡ���ܺ�
     * @return frameNo ���ܺ�
     */
    public void setFrameNo(String frameNo) {
      this.frameNo = frameNo;
    }
    /**
     * ��ȡ��������
     * @return engineNo ��������
     */
    public void setEngineNo(String engineNo) {
      this.engineNo = engineNo;
    }
    /**
     * ��ȡ���տ�ʼСʱ
     * @return damageStartHour ���տ�ʼСʱ
     */
    public void setDamageStartHour(String damageStartHour) {
      this.damageStartHour = damageStartHour;
    }
    /**
     * ��ȡ����������
     * @return damageStartDate ����������
     */
    public void setDamageStartDate(DateTime damageStartDate) {
      this.damageStartDate = damageStartDate;
    }
    /**
     * ��ȡ���յص�������
     * @return damageAddressType ���յص�������
     */
    public void setDamageAddressType(String damageAddressType) {
      this.damageAddressType = damageAddressType;
    }
    /**
     * ��ȡ���յص�������
     * @return damageAddress ���յص�������
     */
    public void setDamageAddress(String damageAddress) {
      this.damageAddress = damageAddress;
    }
    /**
     * ��ȡ�ܱ���
     * @return sumPremium �ܱ���
     */
    public void setSumPremium(double sumPremium) {
      this.sumPremium = sumPremium;
    }
    /**
     * ��ȡ�ܱ���
     * @return sumAmount �ܱ���
     */
    public void setSumAmount(double sumAmount) {
      this.sumAmount = sumAmount;
    }
    /**
     * ��ȡ������ʧ���
     * @return sumClaim ������ʧ���
     */
    public void setSumClaim(double sumClaim) {
      this.sumClaim = sumClaim;
    }
    /**
     * ��ȡҵ�������������
     * @return comCode ҵ�������������
     */
    public void setComCode(String comCode) {
      this.comCode = comCode;
    }

   /**
    * �������Բ���ʱ��
    * @param operateDate �����õ����Բ���ʱ��
    * Modify By Sunhao,2004-08-24
    */
    public void setOperateDate(DateTime operateDate){
        this.operateDate = operateDate;
    }

  public void setCurrencyName(String currencyName) {
    this.currencyName = currencyName;
  }

  /**
     * ��ȡ���Բ���ʱ������
     * @param status �����õ����Բ���ʱ��
     * Modify By Sunhao,2004-08-24
     */

    public DateTime getOperateDate(){
         return operateDate;
     }

  public String getCurrencyName() {
    return currencyName;
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
     * ���������������
     * @param classCode �����õ�������������ֵ
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * ��ȡ�����������
     * @return ������������ֵ
     */
    public String getClassCode(){
        return classCode;
    }

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

}

