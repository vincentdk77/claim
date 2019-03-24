package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prplcheck�鿱/���鿱��Ϣ������ݴ��������<br>
 * ������ 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcheckDto extends PrpLcheckDtoBase implements Serializable{

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcheckDto����
     */
    public PrpLcheckDto(){
    }

    /** ���� **/
    Collection checkList;
    /** �༭���� */
    private String editType = "";
    /** ����������� */
    private String clauseType = "";
    /** ������������ */
    private String clauseName = "";
    /** ���Գ��������� */
    private DateTime damageStartDate = new DateTime();
    /** ���Գ��տ�ʼСʱ */
    private String damageStartHour = "";
    /** ���Գ��տ�ʼ���� */
    private String damageStartMinute = "";
    /** ���Գ�������ֹ */
    private DateTime damageEndDate = new DateTime();
    /** ���Գ�����ֹСʱ */
    private String damageEndHour = "";
    /** ���Գ�����ֹ���� */
    private String damageEndMinute = "";
    /** ���Գ������� */
    private String damageAreaName = "";
    /** �����¹ʴ����� */
    private String handleUnitName = "";
    /** ���Դ˲鿱�����Ĳ���״̬ 1��δ���� 2�����ڴ��� 3������� 4�����ύ 5�� ���� */
    private String status ="";       // Modify By Sunhao,2004-08-24
    /**���Դ˲鿱�����Ĳ���ʱ��*/
    private DateTime operateDate = new DateTime();  // Modify By Sunhao,2004-08-24
    /** ���Ա����� */
    private String lossItemCode = "";
    /** ���Գ��ƺ��� */
    private String lossItemName = "";
    /** �����Ƿ�Ϊ���������� */
    private String insureCarFlag = "";

    private String damageAddress = "";

    /** �Ƿ���������Ĺ����� */
    private boolean isUpdateSumClaim = false;

    /** �����б�*/
    Collection registList;

    /** ���Գ��մ��� */
    private int perilCount = 0;

    //modify by wangwei add start 20050602
    //ԭ�����ӱ�����ͱ������
    /**������*/
    private double registEstimateLoss = 0D;
    /**�������*/
    private double registEstimateFee = 0D;
    //modify by wangwei add end 20050602
    //modify by qinyongli add start 20050718
    //���ӹ�����־
    private String coinsFlag = "";
    //modify by qinyongli add end 20050718

    private String currency = "";//add by wuxiaodong 050905 reasin ���ӱұ������ʾ
    /**����������Ϣ*/
    private String insuredName;
    //��������
	//add by zhouliu start at 2006-6-9
	//reason:ǿ����ѯ
    private Collection relatepolicyNo=null;
    
    //add by zhaolu 20060802 start
    TurnPageDto turnPageDto = null;
    //add by zhaolu 20060802 end
	
   public Collection getRelatepolicyNo() {
		return relatepolicyNo;
	}

	public void setRelatepolicyNo(Collection relatepolicyNo) {
		this.relatepolicyNo = relatepolicyNo;
	}
	//add by zhouliu end at 2006-6-9

/**�õ��¹ʴ�����
   * @return �¹ʴ�����
   */
  public String getHandleUnitName() {
    return handleUnitName;
  }

   /**�õ���������ֹ
   * @return ��������ֹ
   */
  public DateTime getDamageEndDate() {
    return damageEndDate;
  }

   /**�õ���������
   * @return ��������
   */
  public String getClauseName() {
    return clauseName;
  }

   /**�õ��鿱����
   * @return �鿱������Ϣ
   */
  public Collection getCheckList() {
    return checkList;
  }

   /**�õ����տ�ʼСʱ
   * @return ���տ�ʼСʱ
   */
  public String getDamageStartHour() {
    return damageStartHour;
  }

   /**�õ�������ֹСʱ
   * @return ������ֹСʱ
   */
  public String getDamageEndHour() {
    return damageEndHour;
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

   /**�õ���������
   * @return ��������
   */
  public String getDamageAreaName() {
    return damageAreaName;
  }

   /**���ñ༭����
   * @param editType �༭����
   */
  public void setEditType(String editType) {
    this.editType = editType;
  }

   /**�����¹ʴ�����
   * @param handleUnitName �¹ʴ�����
   */
  public void setHandleUnitName(String handleUnitName) {
    this.handleUnitName = handleUnitName;
  }

   /**���ó�������ֹ
   * @param damageEndDate ��������ֹ
   */
  public void setDamageEndDate(DateTime damageEndDate) {
    this.damageEndDate = damageEndDate;
  }

   /**������������
   * @param clauseName ��������
   */
  public void setClauseName(String clauseName) {
    this.clauseName = clauseName;
  }

   /**���ò鿱����
   * @param checkList �鿱����
   */
  public void setCheckList(Collection checkList) {
    this.checkList = checkList;
  }

   /**���ó��տ�ʼСʱ
   * @param damageStartHour ���տ�ʼСʱ
   */
  public void setDamageStartHour(String damageStartHour) {
    this.damageStartHour = damageStartHour;
  }

   /**���ó�����ֹСʱ
   * @param damageEndHour ������ֹСʱ
   */
  public void setDamageEndHour(String damageEndHour) {
    this.damageEndHour = damageEndHour;
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

  /**���ò鿱����
   * @param prpLregistTextDtoList �鿱����
   */
  public void setDamageAreaName(String damageAreaName) {
    this.damageAreaName = damageAreaName;
  }

  /**���ñ༭����
   * @param editType �༭����
   */
  public String getEditType() {
    return editType;
  }

  /**
   * �������Բ���״̬
   * @param status �����õ����Բ���״̬
   * Modify By Sunhao,2004-08-24
   */
  public void setStatus(String status) {
    this.status = StringUtils.rightTrim(status);
  }

  /**
   * ��ȡ���Բ���״̬
   * @return ���Բ���״̬
   * Modify By Sunhao,2004-08-24
   */
  public String getStatus() {
    return status;
  }

  /**
   * �������Բ���ʱ��
   * @param operateDate �����õ����Բ���ʱ��
   * Modify By Sunhao,2004-08-24
   */
  public void setOperateDate(DateTime operateDate) {
    this.operateDate = operateDate;
  }

  public void setDamageEndMinute(String damageEndMinute) {
    this.damageEndMinute = damageEndMinute;
  }

  public void setDamageStartMinute(String damageStartMinute) {
    this.damageStartMinute = damageStartMinute;
  }

  /**
   * ��ȡ���Բ���ʱ������
   * @param status �����õ����Բ���ʱ��
   * Modify By Sunhao,2004-08-24
   */

  public DateTime getOperateDate() {
    return operateDate;
  }

  public String getDamageEndMinute() {
    return damageEndMinute;
  }

  public String getDamageStartMinute() {
    return damageStartMinute;
  }

  /**
   * �������Գ��մ���
   * @param perilCount �����õ����Գ��մ�����ֵ
   */
  public void setPerilCount(int perilCount) {
    this.perilCount = perilCount;
  }

  /**
   * ��ȡ���Գ��մ���
   * @return ���Գ��մ�����ֵ
   */
  public int getPerilCount() {
    return perilCount;
  }

  /**
   * ��ȡ�б�
   * @return �����б�
   */
  public Collection getRegistList() {
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
   * �������Ա�����
   * @param lossItemCode �����õ����Ա����ŵ�ֵ
   */
  public void setLossItemCode(String lossItemCode) {
    this.lossItemCode = StringUtils.rightTrim(lossItemCode);
  }

  /**
   * ��ȡ���Ա�����
   * @return ���Ա����ŵ�ֵ
   */
  public String getLossItemCode() {
    return lossItemCode;
  }

  /**
   * �������Գ��ƺ���
   * @param lossItemName �����õ����Գ��ƺ����ֵ
   */
  public void setLossItemName(String lossItemName) {
    this.lossItemName = StringUtils.rightTrim(lossItemName);
  }

  /**
   * ��ȡ���Գ��ƺ���
   * @return ���Գ��ƺ����ֵ
   */
  public String getLossItemName() {
    return lossItemName;
  }

  /**
   * ���������Ƿ�Ϊ����������
   * @param insureCarFlag �����õ������Ƿ�Ϊ������������ֵ
   */
  public void setInsureCarFlag(String insureCarFlag) {
    this.insureCarFlag = StringUtils.rightTrim(insureCarFlag);
  }

  /**
   * ��ȡ�����Ƿ�Ϊ����������
   * @return �����Ƿ�Ϊ������������ֵ
   */
  public String getInsureCarFlag() {
    return insureCarFlag;
  }

  /**
   * ���������Ƿ�Ϊ����������
   * @param insureCarFlag �����õ������Ƿ�Ϊ������������ֵ
   */
  public void setDamageAddress(String damageAddress) {
    this.damageAddress = StringUtils.rightTrim(damageAddress);
  }

  public void setIsUpdateSumClaim(boolean isUpdateSumClaim) {
    this.isUpdateSumClaim = isUpdateSumClaim;
  }

  /**
   * ��ȡ�����Ƿ�Ϊ����������
   * @return �����Ƿ�Ϊ������������ֵ
   */
  public String getDamageAddress() {
    return damageAddress;
  }

  public boolean isIsUpdateSumClaim() {
    return isUpdateSumClaim;
  }

  //modify by wangwei add start 20050602
  //ԭ�����ӱ�����ͱ������
  /**
   * ��ȡ���Ա�����
   * @return������
   * */
  public double getRegistEstimateLoss() {
  	  return this.registEstimateLoss;
  }

  /**
   * �������Ա�����
   * @param registEstmateLoss ������*/
  public void setRegistEstimateLoss(double registEstmateLoss) {
  	  this.registEstimateLoss = registEstmateLoss;
  }

  /**
   * ��ȡ���Ա������
   * @return �������
   * */
  public  double getRegistEstimateFee() {
  	  return this.registEstimateFee;
  }

  /**
   * �������Ա������
   * @param registEstmateFee �������*/
  public void setRegistEstimateFee(double registEstimateFee) {
  	  this.registEstimateFee = registEstimateFee;
  }
  //modify by wangwei add end 20050602

  /**
   * ��ȡ���Ա������
   * @return �������
   * */
  public String getCoinsFlag() {
  	  return this.coinsFlag;
  }

  /**
   * �������Ա������
   * @param registEstmateFee �������*/
  public void setCoinsFlag(String coinsFlag) {
  	  this.coinsFlag = coinsFlag;
  }

  /**add by wuxiaodong 050905 begain
   * �������Աұ�
   * @return String
   */
  public String getCurrency() {
      return this.currency;
  }

  /**
   * �������Աұ�
   * @param currency ���Աұ�*/
  public void setCurrency(String currency) {
      this.currency = currency;
  }
  //add by wuxiaodong 050905 end


	/**
	 * @return Returns the insuredName.
	 */
	public String getInsuredName() {
		return insuredName;
	}
	/**
	 * @param insuredName The insuredName to set.
	 */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}

	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}
}
