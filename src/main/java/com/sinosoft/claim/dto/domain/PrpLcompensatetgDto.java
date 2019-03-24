package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.utility.string.Str;

/**
 * ����prplcompensate�������������ݴ��������
 * <br> ������ 2004-4-5 15:31:56
 * <br> JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcompensatetgDto extends PrpLcompensatetgDtoBase implements Serializable{

	/** ���Ը����� */
	private String payrefName="";
	/** ���Ը�������*/
	private DateTime payrefDate=new DateTime();
	/** ���Ա������˴��� */
    private String insuredCode = "";
    /** ���Ա����������� */
    private String insuredName = "";
    /** ���������� */
    private DateTime startDate = new DateTime();
    /** ������Сʱ */
    private int startHour = 0;
    /** �����ձ����� */
    private DateTime endDate = new DateTime();
    /** �����ձ�Сʱ */
    private int endHour = 0;
    /** ����������� */
    private String clauseType = "";
    /** ������������ */
    private String clauseName = "";
    /** ���Գ��ƺ� */
    private String licenseNo = "";
    /** ���Գ��Ƶ�ɫ���� */
    private String licenseColorCode = "";
    /** ���Գ��Ƶ�ɫ */
    private String licenseColor = "";
    /** ���Գ���������� */
    private String carKindCode = "";
    /** ���Գ������� */
    private String carKind = "";
    
    /** ���Ժ˶���λ���� */
    private String seatCount = "";
        
    /** ���Բ������� */
    private String comName = "";
    /** ���Թ���ҵ��Ա���� */
    private String handler1Name = "";
    /** ���Գ����ͺ� */
    private String brandName = "";
    /** ���Է������� */
    private String engineNo = "";
    /** ���Գ��ܺ� */
    private String frameNo = "";
    /** ���Գ��������� */
    private DateTime damageStartDate = new DateTime();
    /** ���Գ��տ�ʼСʱ */
    private String damageStartHour = "";
    /** ���Գ��տ�ʼ���� */
    private String damageStartMinute = "";
    /** ���Գ��յص������� */
    private String damageAddressType = "";
    /** ���Գ��յص� */
    private String damageAddress = "";
    /** �����ܱ��ս�� */
    private double sumAmount = 0d;
    /** �����ܱ��� */
    private double sumPremium = 0d;
    /** ���Ա�����ʧ��� */
    private double sumClaim = 0d;
    /** �������ϼ� */
    private double sumDutyPaid1 = 0d;
    /** ���Ծ��������� */
    private String handlerName = "";
    /** ���Բ鿱/���鿱��1 */
    private String checker1 = "";
    /** ���Ի������ƴ��� */
    private String currency = "";
    /** �������Ĳ���״̬ 1��δ���� 2�����ڴ��� 3������� 4�����ύ 5�� ���� */
    private String status ="";
    /** ���� **/
    Collection compensateList;
    /** �༭���� */
    private String editType = "";
    /**���Դ˰����Ĳ���ʱ��*/
    private DateTime operateDate = new DateTime();//Modify By Sunhao,2004-08-24

    /** �����б�*/
    private Collection registList ;
     /** ���Գ��մ��� */
    private int perilCount = 0;
    /** �����ⰸ�������� */
    private String caseTypeName = "";

    /** clauseTypeCode */
    private String clauseTypeCode = "";
    /** DeductibleTerm */
    private String deductibleTerm = "";
    /** EscapeFlag */
    private String escapeFlag = "";
    /** PurchasePrice */
    private String purchasePrice = "";
    private double sumCheckFee = 0d;
    
    //add by wunier 20080102
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
    //end by wunier 20080102
    
    private String businessType;
    private String businessType1;
    //�����־��0��ֱ��ҵ��1������ҵ��
    private String businessFlag = "";
    //������־����Ӧprpcmain�е�otherFlag��
    private String otherFlag = ""; 
    /**���Ƴ̶�*/
    private String woundGrade = "";
    //modify by luqin 2005-04-08 start
    /** �����Ѹ����� */
    private int payFee = 0;
    //modify by luqin 2005-04-08 end
    /** �����⳥���δ��� */
    private String indemnityDutyName = "";
    private TurnPageDto turnPageDto;
    //add by qinyongli 2005-7-19
      //���ӹ�����Ϣ
    /** ������Ϣ */
    private String coinsFlag = "";
    //����ҵ����Դ��Ϣ
    /**ҵ����Դ*/
    private String businessNature = "";
    /** ���Գ���ԭ����� */
    private String damageCode = "";
    /** ���Գ���ԭ��˵�� */
    private String damageName = "";
    /**���������⸶��������Ϣ*/
    double sumPaidAll = 0 ;
    /**���Աұ���������*/
    String currencyName = "";
    //add by qinyongli end 2005-7-19
    
     /** �����Ƿ������׷�� */
    private String replevyFlag = "";
    
    /**���԰������� 2005-08-03*/
    private String claimType = "";
    
    /**���԰��������� 2005-08-03*/
    private String claimTypeName = "";
    
    /**���Ա����� 2005-08-07*/
    private String registNo = "";
    /**���Խ��ѱ�־ 2005-12-22  -1Ϊδ�ɷѣ�0Ϊδ��ȫ��1Ϊ��ȫ*/
    private int palyFlag = 1;
    
    /** ����Ͷ�������� */
    private String appliName = "";
    
    /** ���Ա�������ʾ���� */
    private String insuredNameShow = "";
    /**
     * �Ʋ���ʧ(��prplLoss���е��⸶�����ʧSumRealPay֮��)
     */
    private double lossSumRealPay = 0;
    
    /**
     * ������ʧ(��PrplPersonLoss���е��⸶��ʧSumRealPay֮��)
     */
    private double personLossSumRealPay = 0;
    
    /** ����ҽ������ ������ר�� */
    private String medicalType = "";
    
    /**
     * ����������Ϣ
     */
    private ArrayList prpLdeductCondtgDtoList;

    /**
     * ���߳����ƺ�
     */
    private String thridLicenseNos;
    
    /**
     * ���߳��а���˾
     */
    private String  thridCompanys;
    
    //֧������
    private String  ojectName;
    //֧������֤������
    private String  ojectType;
    //֧������֤������
    private String  ojectCode;
    
    /**�б�����*/
    private int sumInsured;
    
    /**�����嵥������*/
    private String claimRelationNo;
    
    /**Ԥ������*/
    private double sumPreChargeAmount = 0.0;
    /**���⸶ԭ��*/
    private String zeroLossType;
    /**���⸶-ע����������*/
    private String zeroLossCaseType;
    /**���⸶-ע������ԭ��*/
    private String zeroLossDetailReason;
    private double coinsOtherPaid = 0.0 ;
    
    /**�Ƿ�����*/
    private String lawsuitFlag;
    
    /**�����ָ����ؿ�����*/
    private String reopenedType;
    
    
    
	public String getReopenedType() {
		return reopenedType;
	}

	public void setReopenedType(String reopenedType) {
		this.reopenedType = reopenedType;
	}

	public String getLawsuitFlag() {
		return lawsuitFlag;
	}

	public void setLawsuitFlag(String lawsuitFlag) {
		this.lawsuitFlag = lawsuitFlag;
	}

	public String getClaimRelationNo() {
		return Str.rightTrim(claimRelationNo);
	}

	public void setClaimRelationNo(String claimRelationNo) {
		this.claimRelationNo = Str.rightTrim(claimRelationNo);
	}

	public ArrayList getPrpLdeductCondtgDtoList() {
		return prpLdeductCondtgDtoList;
	}

	public void setPrpLdeductCondtgDtoList(ArrayList prpLdeductCondtgDtoList) {
		this.prpLdeductCondtgDtoList = prpLdeductCondtgDtoList;
	}

	/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcompensatetgDto����
     */
    public PrpLcompensatetgDto(){
    }

    /**�õ���λ��
     * @return ��λ��
     */
    public String getSeatCount() {
      return seatCount;
    }

    /**������λ��
     * @param seatCount ��λ��
     */
    public void setSeatCount(String seatCount) {
      this.seatCount = seatCount;
    }
 
    /**�õ����յص�������
     * @return ���յص�������
     */
    public String getDamageAddressType() {
      return damageAddressType;
    }

    /**�õ����յص�
     * @return ���յص�
     */
    public String getDamageAddress() {
      return damageAddress;
    }

    /**�õ��ձ�����
     * @return �ձ�����
     */
    public DateTime getEndDate() {
      return endDate;
    }
    /**�õ����ܺ�
     * @return ���ܺ�
     */
    public String getFrameNo() {
      return frameNo;
    }
    /**�õ�����������
     * @return ����������
     */
    public String getHandlerName() {
      return handlerName;
    }
    /**�õ��ܱ���
     * @return �ܱ���
     */
    public double getSumPremium() {
      return sumPremium;
    }
    /**�õ��ܱ���
     * @return �ܱ���
     */
    public double getSumAmount() {
      return sumAmount;
    }

    /**�õ���������
     * @return ��������
     */
    public String getClauseName() {
      return clauseName;
    }
    /**�õ��ձ�Сʱ
     * @return �ձ�Сʱ
     */
    public int getEndHour() {
      return endHour;
    }
    /**�õ�����������
     * @return ����������
     */
    public DateTime getDamageStartDate() {
      return damageStartDate;
    }
    /**�õ��������
     * @return �������
     */
    public String getClauseType() {
      return clauseType;
    }
    /**�õ������������
     * @return �����������
     */
    public String getCarKindCode() {
      return carKindCode;
    }
    /**�õ����ϼ�
     * @return ���ϼ�
     */
    public double getSumDutyPaid1() {
      return sumDutyPaid1;
    }

    /**�õ����Ƶ�ɫ����
     * @return ���Ƶ�ɫ����
     */
    public String getLicenseColorCode() {
      return licenseColorCode;
    }

    /**�õ����տ�ʼСʱ
     * @return ���տ�ʼСʱ
     */
    public String getDamageStartHour() {
      return damageStartHour;
    }

    /**�õ�������������
     * @return ������������
     */
    public String getInsuredName() {
      return insuredName;
    }

    /**�õ������ͺ�
     * @return �����ͺ�
     */
    public String getBrandName() {
      return brandName;
    }

    /**�õ��������˴���
     * @return �������˴���
     */
    public String getInsuredCode() {
      return insuredCode;
    }

    /**�õ��鿱/���鿱��1
     * @return �鿱/���鿱��1
     */
    public String getChecker1() {
      return checker1;
    }

    /**�õ�������ʧ���
     * @return ������ʧ���
     */
    public double getSumClaim() {
      return sumClaim;
    }

    /**�õ��������ƴ���
     * @return �������ƴ���
     */
    public String getCurrency() {
      return currency;
    }
    /**�õ���Сʱ
     * @return ��Сʱ
     */
    public int getStartHour() {
      return startHour;
    }
     /**�õ����ƺ�
     * @return ���ƺ�
     */
    public String getLicenseNo() {
      return licenseNo;
    }
    /**�õ���������
     * @return ��������
     */
    public String getEngineNo() {
      return engineNo;
    }
    /**�õ�������
     * @return ������
     */
    public void setStartDate(DateTime startDate) {
      this.startDate = startDate;
    }

    /**���ó��յص�������
     * @param damageAddressType ���յص�������
     */
    public void setDamageAddressType(String damageAddressType) {
      this.damageAddressType = damageAddressType;
    }

    /**���ó��յص�
     * @param damageAddress ���յص�
     */
    public void setDamageAddress(String damageAddress) {
      this.damageAddress = damageAddress;
    }

    /**�����ձ�����
     * @param endDate �ձ�����
     */
    public void setEndDate(DateTime endDate) {
      this.endDate = endDate;
    }

    /**���ó��ܺ�
     * @param frameNo ���ܺ�
     */
    public void setFrameNo(String frameNo) {
      this.frameNo = frameNo;
    }

    /**���þ���������
     * @param handlerName ����������
     */
    public void setHandlerName(String handlerName) {
      this.handlerName = handlerName;
    }

    /**�����ܱ���
     * @param sumPremium �ܱ���
     */
    public void setSumPremium(double sumPremium) {
      this.sumPremium = sumPremium;
    }

    /**�����ܱ���
     * @param sumAmount �ܱ���
     */
    public void setSumAmount(double sumAmount) {
      this.sumAmount = sumAmount;
    }

    /**������������
     * @param clauseName ��������
     */
    public void setClauseName(String clauseName) {
      this.clauseName = clauseName;
    }

    /**�����ձ�Сʱ
     * @param endHour �ձ�Сʱ
     */
    public void setEndHour(int endHour) {
      this.endHour = endHour;
    }

    /**���ó���������
     * @param damageStartDate ����������
     */
    public void setDamageStartDate(DateTime damageStartDate) {
      this.damageStartDate = damageStartDate;
    }

    /**�����������
     * @param clauseType �������
     */
    public void setClauseType(String clauseType) {
      this.clauseType = clauseType;
    }

    /**���ó����������
     * @param carKindCode �����������
     */
    public void setCarKindCode(String carKindCode) {
      this.carKindCode = carKindCode;
    }

    /**�������ϼ�
     * @param sumDutyPaid1 ���ϼ�
     */
    public void setSumDutyPaid1(double sumDutyPaid1) {
      this.sumDutyPaid1 = sumDutyPaid1;
    }

    /**���ó��Ƶ�ɫ����
     * @param licenseColorCode ���Ƶ�ɫ����
     */
    public void setLicenseColorCode(String licenseColorCode) {
      this.licenseColorCode = licenseColorCode;
    }

    /**���ó��տ�ʼСʱ
     * @param damageStartHour ���տ�ʼСʱ
     */
    public void setDamageStartHour(String damageStartHour) {
      this.damageStartHour = damageStartHour;
    }

    /**���ñ�����������
     * @param insuredName ������������
     */
    public void setInsuredName(String insuredName) {
      this.insuredName = insuredName;
    }

    /**���ó����ͺ�
     * @param brandName �����ͺ�
     */
    public void setBrandName(String brandName) {
      this.brandName = brandName;
    }

    /**���ñ������˴���
     * @param insuredCode �������˴���
     */
    public void setInsuredCode(String insuredCode) {
      this.insuredCode = insuredCode;
    }

    /**���ò鿱/���鿱��1
     * @param checker1 �鿱/���鿱��1
     */
    public void setChecker1(String checker1) {
      this.checker1 = checker1;
    }

    /**���ñ�����ʧ���
     * @param sumClaim ������ʧ���
     */
    public void setSumClaim(double sumClaim) {
      this.sumClaim = sumClaim;
    }

    /**���û������ƴ���
     * @param currency �������ƴ���
     */
    public void setCurrency(String currency) {
      this.currency = currency;
    }

    /**������Сʱ
     * @param startHour ��Сʱ
     */
    public void setStartHour(int startHour) {
      this.startHour = startHour;
    }

    /**���÷�������
     * @param engineNo ��������
     */
    public void setEngineNo(String engineNo) {
      this.engineNo = engineNo;
    }

    /**���ó��ƺ�
     * @param licenseNo ���ƺ�
     */
    public void setLicenseNo(String licenseNo) {
      this.licenseNo = licenseNo;
    }

    /**���ô������Ĳ���״̬
     * @param prpLclaimtgDto �������Ĳ���״̬
     */
    public void setStatus(String status) {
      this.status = status;
    }
    /**���ó�������
     * @param carKind ��������
     */

    public void setCarKind(String carKind) {
      this.carKind = carKind;
    }

    /**���ó��Ƶ�ɫ
     * @param licenseColor ���Ƶ�ɫ
     */
    public void setLicenseColor(String licenseColor) {
      this.licenseColor = licenseColor;
    }

    /**���ù���ҵ��Ա����
     * @param handler1Name ����ҵ��Ա����
     */
    public void setHandler1Name(String handler1Name) {
      this.handler1Name = handler1Name;
    }

    /**���ò�������
     * @param prpLclaimtgDto ��������
     */
    public void setComName(String comName) {
      this.comName = comName;
    }

    /**����
     * @param compensateList ����
     */
    public void setCompensateList(Collection compensateList) {
      this.compensateList = compensateList;
    }

    /**���ñ༭����
     * @param editType �༭����
     */
    public void setEditType(String editType) {
      this.editType = editType;
    }

    /**����������
     * @param startDate ������
     */
    public DateTime getStartDate() {
      return startDate;
    }

    /**���ô������Ĳ���״̬
     * @param status �������Ĳ���״̬
     */
    public String getStatus() {
      return status;
    }

    /**���ó�������
     * @param prpLclaimtgDto ��������
     */
    public String getCarKind() {
      return carKind;
    }

    /**���ó��Ƶ�ɫ
     * @param prpLclaimtgDto ���Ƶ�ɫ
     */
    public String getLicenseColor() {
      return licenseColor;
    }

    /**���ù���ҵ��Ա����
     * @param handler1Name ����ҵ��Ա����
     */
    public String getHandler1Name() {
      return handler1Name;
    }

    /**���ò�������
     * @param comName ��������
     */
    public String getComName() {
      return comName;
    }

    /**���ü���
     * @param compensateList ����
     */
    public Collection getCompensateList() {
      return compensateList;
    }

    /**���ñ༭����
     * @param editType �༭����
     */
    public String getEditType() {
      return editType;
    }

   /**
    * �������Բ���ʱ��
    * @param operateDate �����õ����Բ���ʱ��
    * Modify By Sunhao,2004-08-24
    */
    public void setOperateDate(DateTime operateDate){
        this.operateDate = operateDate;
    }

  public void setDamageStartMinute(String damageStartMinute) {
    this.damageStartMinute = damageStartMinute;
  }

  /**
     * ��ȡ���Բ���ʱ������
     * @param status �����õ����Բ���ʱ��
     * Modify By Sunhao,2004-08-24
     */

    public DateTime getOperateDate(){
         return operateDate;
     }

  public String getDamageStartMinute() {
    return damageStartMinute;
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
     * ���������ⰸ��������
     * @param caseTypeName �����õ������ⰸ�������Ƶ�ֵ
     */
    public void setCaseTypeName(String caseTypeName){
        this.caseTypeName = StringUtils.rightTrim(caseTypeName);
    }

  public void setEscapeFlag(String escapeFlag) {
    this.escapeFlag = escapeFlag;
  }

  public void setDeductibleTerm(String deductibleTerm) {
    this.deductibleTerm = deductibleTerm;
  }

 

  public void setClauseTypeCode(String clauseTypeCode) {
    this.clauseTypeCode = clauseTypeCode;
  }

  public void setPurchasePrice(String purchasePrice) {
    this.purchasePrice = purchasePrice;
  }

  /**
     * ��ȡ�����ⰸ��������
     * @return �����ⰸ�������Ƶ�ֵ
     */
    public String getCaseTypeName(){
        return caseTypeName;
    }

  public String getEscapeFlag() {
    return escapeFlag;
  }

  public String getDeductibleTerm() {
    return deductibleTerm;
  }


  public String getClauseTypeCode() {
    return clauseTypeCode;
  }

  public String getPurchasePrice() {
    return purchasePrice;
  }
  
  //modify by luqin 2005-04-08 start
  /**�õ��ѽ�������Ϣ
   * @return �ѽ�����
   */
  public int getPayFee(){
    return payFee;
  }
  /**�����ѽ�������Ϣ
  * @param payFee �ѽ�����
  */
  public void setPayFee(int payFee){
    this.payFee = payFee;
  }
  //modify by luqin 2005-04-08 end

	/**
	 * @return Returns the indemnityDutyName.
	 */
	public String getIndemnityDutyName() {
		return indemnityDutyName;
	}
	/**
	 * @param indemnityDutyName The indemnityDutyName to set.
	 */
	public void setIndemnityDutyName(String indemnityDutyName) {
		this.indemnityDutyName = indemnityDutyName;
	}
	/**
	 * @return Returns the turnPagetgDto.
	 */
	public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}
	/**
	 * @param turnPagetgDto The turnPagetgDto to set.
	 */
	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}
    /**
     * ���������Ƿ������׷��
     * @param replevyFlag �����õ������Ƿ������׷����ֵ
     */
    public void setReplevyFlag(String replevyFlag){
        this.replevyFlag = StringUtils.rightTrim(replevyFlag);
    }

    /**
     * ��ȡ�����Ƿ������׷��
     * @return �����Ƿ������׷����ֵ
     */
    public String getReplevyFlag(){
        return replevyFlag;
    }
    /**
     * �������Թ�����Ϣ
     * @param coinsFlag ������Ϣ
     */
    public void setCoinsFlag(String coinsFlag){
        this.coinsFlag = coinsFlag;
    }

    /**
     * ��ȡ���Թ�����Ϣ
     * @return ���Թ�����Ϣ
     */
    public String getCoinsFlag(){
        return coinsFlag;
    }
    /**
     * ��������ҵ����Դ
     * @param businessNature ҵ����Դ
     */
    public void setBusinessNature(String businessNature){
        this.businessNature = businessNature;
    }
    /**
     * ��ȡ����ҵ����Դ
     * @return ����ҵ����Դ
     */
    public String getBusinessNature(){
        return businessNature;
    }
    /**
     * �������Գ���ԭ�����
     * @param damageCode �����õ����Գ���ԭ������ֵ
     */
    public void setDamageCode(String damageCode){
        this.damageCode = StringUtils.rightTrim(damageCode);
    }

    /**
     * ��ȡ���Գ���ԭ�����
     * @return ���Գ���ԭ������ֵ
     */
    public String getDamageCode(){
        return damageCode;
    }

    /**
     * �������Գ���ԭ��˵��
     * @param damageName �����õ����Գ���ԭ��˵����ֵ
     */
    public void setDamageName(String damageName){
        this.damageName = StringUtils.rightTrim(damageName);
    }

    /**
     * ��ȡ���Գ���ԭ��˵��
     * @return ���Գ���ԭ��˵����ֵ
     */
    public String getDamageName(){
        return damageName;
    }
 
    /**
     * �������԰�������
     * @param claimType �����õ����԰������͵�ֵ
     */
    public void setClaimType(String claimType){
        this.claimType = StringUtils.rightTrim(claimType);
    }

    /**
     * ��ȡ���԰�������
     * @return ���԰������͵�ֵ
     */
    public String getClaimType(){
        return claimType;
    }
    
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
     * �������Ա�����
     * @return ���Ա�����
     * */
    public void setRegistNo(String registNo) {
    	this.registNo = registNo;
    }
    
    /**
     * ��ȡ���Ա�����
     * @return ���Ա�����
     * */
    public String getRegistNo() {
    	return this.registNo;
    }
    /**
     * ���������⸶��������Ϣ
     * @return ���������⸶��������Ϣ
     * */
    public void setSumPaidAll(double sumPaidAll) {
    	this.sumPaidAll = sumPaidAll;
    }
    
    /**
     * ���������⸶��������Ϣ
     * @return ���������⸶��������Ϣ
     * */
    public double getSumPaidAll() {
    	return this.sumPaidAll;
    }
    /**
     * ���Աұ���������
     * @return ���Աұ���������
     * */
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
    
    /**
     * ���Աұ���������
     * @return ���Աұ���������
     * */
    public String getCurrencyName() {
        return this.currencyName;
    }

	/** 
	 * @param intReturn
	 */
	public void setPalyFlag(int palyFlag) {
		// TODO �Զ����ɷ������
	   	this.palyFlag = palyFlag;
	    		
	}
	   public int getPalyFlag() {
        return this.palyFlag;
    }
   public double getSumCheckFee() {
	     return sumCheckFee;
    }
   public void setSumCheckFee(double sumCheckFee) {
	this.sumCheckFee = sumCheckFee;
   }
	   
	  /**
     * ��������Ͷ��������
     * @param appliName �����õ�����Ͷ�������Ƶ�ֵ
     */
    public void setAppliName(String appliName){
        this.appliName = StringUtils.rightTrim(appliName);
    }

    /**
     * ��ȡ����Ͷ��������
     * @return ����Ͷ�������Ƶ�ֵ
     */
    public String getAppliName(){
        return appliName;
    }
   
    /**
     * �������� ����������ʾ����
     * @param appliName �����õ����Ա���������ʾ���Ƶ�ֵ
     */
    public void setInsuredNameShow(String insuredNameShow){
        this.insuredNameShow = StringUtils.rightTrim(insuredNameShow);
    }

    /**
     * ��ȡ���Ա���������ʾ����
     * @return ���Ա���������ʾ���Ƶ�ֵ
     */
    public String getInsuredNameShow(){
        return insuredNameShow;
    }
    
    
    public String getDefaultCompensateResult(){
    	//Ĭ��Ϊ����(����Ϊ"1")
    	return "1";
    }

	public double getPersonLossSumRealPay() {
		return personLossSumRealPay;
	}

	public void setPersonLossSumRealPay(double sumPersonLoss) {
		this.personLossSumRealPay = sumPersonLoss;
	}

	public double getLossSumRealPay() {
		return lossSumRealPay;
	}

	public void setLossSumRealPay(double sumPropLoss) {
		this.lossSumRealPay = sumPropLoss;
	}
	
	//���������˺͸�������
    public void setPayrefName(String currencyName) {
        this.payrefName = payrefName;
    }
    
    public String getPayrefName() {
        return this.payrefName;
    }
    
    public void setPayrefDate(DateTime payrefDate) {
        this.payrefDate = payrefDate;
    }
    
    public DateTime getPayrefDate() {
        return this.payrefDate;
    }

	public double getLossesNumber() {
		return lossesNumber;
	}

	public void setLossesNumber(double lossesNumber) {
		this.lossesNumber = lossesNumber;
	}

	public String getLossesUnitCode() {
		return lossesUnitCode;
	}

	public void setLossesUnitCode(String lossesUnitCode) {
		this.lossesUnitCode = lossesUnitCode;
	}

	public double getDamageInsured() {
		return damageInsured;
	}

	public void setDamageInsured(double damageInsured) {
		this.damageInsured = damageInsured;
	}

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

	public String getWoundGrade() {
		return woundGrade;
	}

	public void setWoundGrade(String woundGrade) {
		this.woundGrade = woundGrade;
	}

	public String getThridLicenseNos() {
		return thridLicenseNos;
	}

	public void setThridLicenseNos(String thridLicenseNos) {
		this.thridLicenseNos = thridLicenseNos;
	}

	public String getThridCompanys() {
		return thridCompanys;
	}

	public void setThridCompanys(String thridCompanys) {
		this.thridCompanys = thridCompanys;
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

	public String getOjectName() {
		return ojectName;
	}

	public void setOjectName(String ojectName) {
		this.ojectName = ojectName;
	}

	public String getOjectType() {
		return ojectType;
	}

	public void setOjectType(String ojectType) {
		this.ojectType = ojectType;
	}

	public String getOjectCode() {
		return ojectCode;
	}

	public void setOjectCode(String ojectCode) {
		this.ojectCode = ojectCode;
	}

	public int getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(int sumInsured) {
		this.sumInsured = sumInsured;
	}

	public double getSumPreChargeAmount() {
		return sumPreChargeAmount;
	}

	public void setSumPreChargeAmount(double sumPreChargeAmount) {
		this.sumPreChargeAmount = sumPreChargeAmount;
	}

	public String getZeroLossType() {
		return zeroLossType;
	}

	public void setZeroLossType(String zeroLossType) {
		this.zeroLossType = zeroLossType;
	}

	public String getZeroLossCaseType() {
		return zeroLossCaseType;
	}

	public void setZeroLossCaseType(String zeroLossCaseType) {
		this.zeroLossCaseType = zeroLossCaseType;
	}

	public String getZeroLossDetailReason() {
		return zeroLossDetailReason;
	}

	public void setZeroLossDetailReason(String zeroLossDetailReason) {
		this.zeroLossDetailReason = zeroLossDetailReason;
	}
	
	public double getCoinsOtherPaid() {
		return coinsOtherPaid;
	}

	public void setCoinsOtherPaid(double coinsOtherPaid) {
		this.coinsOtherPaid = coinsOtherPaid;
	}


}
