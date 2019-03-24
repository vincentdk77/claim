package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLverifyLoss��������������ݴ��������<br>
 * ������ 2004-07-19 14:23:54.248<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLverifyLossDto extends PrpLverifyLossDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLverifyLossDto����
     */
    public PrpLverifyLossDto(){
    }

    /** ���� **/
    Collection verifyLossList;
    /** �༭���� */
    private String editType = "";
    /** �������Ĳ���״̬ 1��δ���� 2�����ڴ��� 3������� 4�����ύ 5�� ���� */
    private String status ="";// Modify By Sunhao,2004-08-24
    /**���Դ˰����Ĳ���ʱ��*/
    private DateTime operateDate = new DateTime();// Modify By Sunhao,2004-08-24
    /** ����������� */
    private String clauseType = "";
    /** ������������ */
    private String clauseName = "";
    /**���Ƶ�ɫ����  */
    private String licenseColor ="";
    /**��������  */
    private String carKind="";
    /**�ұ�����  */
    private String currencyName="";
    /** ���Գ��մ��� */
    private int perilCount = 0;
    /** �Ƿ���������Ĺ����� */
    private boolean isUpdateSumClaim = false; 
    /** ����ѯ����Ϣ */
    private String verifPriceOuterMsg="";
    /** ���������˻صĲ����� */
    private String compensateApproverName = "";
    /** �������̱�� */
    private String flowID = "";
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

    
    //����������
	//add by zhouliu start at 2006-6-9
	//reason:ǿ����ѯ
    private Collection relatepolicyNo=null;
    
    //add by zhaolu 20060803 start
    TurnPageDto	turnPageDto = null;
    //add by zhaolu 20060803 end
    
    public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}
	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}
	public Collection getRelatepolicyNo() {
		return relatepolicyNo;
	}
	public void setRelatepolicyNo(Collection relatepolicyNo) {
		this.relatepolicyNo = relatepolicyNo;
	}
	//add by zhouliu end at 2006-6-9
	/**
     * ��ȡ���Գ�������
     * @return ���Գ�������ֵ
     */
    public String getCarKind(){
        return carKind;
    }
     /**
     * �������Գ�������
     * @param carKind�����õ����Գ��������ֵ
     */
    public void setCarKind(String carKind){
        this.carKind = StringUtils.rightTrim(carKind);
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
    /**�õ���֤�Ĳ���״̬
    * @return ��֤�Ĳ���״̬
    * Modify By Sunhao,2004-08-24
    */
     public String getStatus() {
       return status;
     }

    /**���õ�֤�Ĳ���״̬
    * @param status ��֤�Ĳ���״̬
    * Modify By Sunhao,2004-08-24
    */
     public void setStatus(String status) {
       this.status = status;
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
     * ��������ѯ����Ϣ
     * @param verifPriceOuterMsg ����������ѯ����Ϣ��ֵ
     */
    public void setVerifPriceOuterMsg(String verifPriceOuterMsg){
        this.verifPriceOuterMsg = StringUtils.rightTrim(verifPriceOuterMsg);
    }

    /**
     * ��ȡ����ѯ����Ϣ
     * @return ��������ѯ����Ϣ
     */
    public String getVerifPriceOuterMsg(){
        return verifPriceOuterMsg;
    }

    
	
    /**�õ���֤����
    * @return ��֤������Ϣ
    */
    public Collection getVerifyLossList() {
      return  verifyLossList;
    }
    /**���õ�֤����
    * @param verifyLossList ��֤����
    */
    public void setVerifyLossList(Collection verifyLossList) {
      this.verifyLossList = verifyLossList;
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

    public void setIsUpdateSumClaim(boolean isUpdateSumClaim) {
      this.isUpdateSumClaim = isUpdateSumClaim;
    }

  /**
     * ��ȡ���Գ��մ���
     * @return ���Գ��մ�����ֵ
     */
    public int getPerilCount(){
        return perilCount;
    }

    public boolean isIsUpdateSumClaim() {
      return isUpdateSumClaim;
    }
    
      /**
     * �������������˻صĲ�����
     * @param compensateApproverCode �����õ����������˻صĲ����˵�ֵ
     */
    public void setCompensateApproverName(String compensateApproverName){
        this.compensateApproverName = StringUtils.rightTrim(compensateApproverName);
    }

    /**
     * ��ȡ���������˻صĲ�����
     * @return ���������˻صĲ����˵�ֵ
     */
    public String getCompensateApproverName(){
        return compensateApproverName;
    }
    /**
     * �����������̱��
     * @param flowID �����õ��������̱�ŵ�ֵ
     */
    public void setFlowID(String flowID){
        this.flowID = StringUtils.rightTrim(flowID);
    }

    /**
     * ��ȡ�������̱��
     * @return �������̱�ŵ�ֵ
     */
    public String getFlowID(){
        return flowID;
    }
	public boolean isUpdateSumClaim() {
		return isUpdateSumClaim;
	}
	public void setUpdateSumClaim(boolean isUpdateSumClaim) {
		this.isUpdateSumClaim = isUpdateSumClaim;
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
  }
