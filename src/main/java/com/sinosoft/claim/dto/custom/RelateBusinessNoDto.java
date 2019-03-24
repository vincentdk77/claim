package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
/**
 * ����ҵ��Ŵ������
 * <p>Title: ����ҵ��Ŵ������</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company:sinosoft </p>
 * @author sunhao
 * @version 1.0
 */
public class RelateBusinessNoDto implements Serializable
{
  /**������*/
  private String policyNo = "";
  /**������*/
  private String registNo = "";
  /**���Ⱥ�*/
  private String scheduleNo = "";
  /**�鿱��*/
  private String checkNo = "";
  /**�����*/
  private String certainLossNo = "";
  /**�����*/
  private String verifyLossNo = "";
  /**�ⰸ��*/
  private String claimNo = "";
  /**��֤��*/
  private String certifyNo = "";
  /**Ԥ���*/
  private String prepayNo = "";
  /**ʵ���*/
  private String compensateNo = "";
  /**�᰸��*/
  private String endcaseNo = "";
  /**�ձ�*/
  private String riskCode = "";

  public RelateBusinessNoDto() {

  }


  /**
   * �������Ա�������
   * @return ���������ֵ
   */
  public void setPolicyNo(String policyNo){
      this.policyNo = policyNo;
  }

  /**
   * ��ȡ���Ա�������
   * @return ���Ա��������ֵ
   */
  public String getPolicyNo(){
      return policyNo;
  }

  /**
   * �������Ա�����
   * @return �����ŵ�ֵ
   */
  public void setRegistNo(String registNo){
      this.registNo = registNo;
  }

  /**
   * ��ȡ���Ա�����
   * @return ���Ա����ŵ�ֵ
   */
  public String getRegistNo(){
      return registNo;
  }

  /**
   * ���������ⰸ��
   * @return �ⰸ�ŵ�ֵ
   */
  public void setClaimNo(String claimNo){
      this.claimNo = claimNo;
  }

  public void setPrepayNo(String prepayNo) {
    this.prepayNo = prepayNo;
  }

  public void setCompensateNo(String compensateNo) {
    this.compensateNo = compensateNo;
  }

  public void setCheckNo(String checkNo) {
    this.checkNo = checkNo;
  }

  public void setVerifyLossNo(String verifyLossNo) {
    this.verifyLossNo = verifyLossNo;
  }

  public void setCertifyNo(String certifyNo) {
    this.certifyNo = certifyNo;
  }

  public void setEndcaseNo(String endcaseNo) {
    this.endcaseNo = endcaseNo;
  }

  public void setScheduleNo(String scheduleNo) {
    this.scheduleNo = scheduleNo;
  }

  public void setCertainLossNo(String certainLossNo) {
    this.certainLossNo = certainLossNo;
  }

  public void setRiskCode(String riskCode) {
    this.riskCode = riskCode;
  }

  /**
   * ��ȡ�����ⰸ��
   * @return �����ⰸ�ŵ�ֵ
   */
  public String getClaimNo(){
      return claimNo;
  }

  public String getPrepayNo() {
    return prepayNo;
  }

  public String getCompensateNo() {
    return compensateNo;
  }

  public String getCheckNo() {
    return checkNo;
  }

  public String getVerifyLossNo() {
    return verifyLossNo;
  }

  public String getCertifyNo() {
    return certifyNo;
  }

  public String getEndcaseNo() {
    return endcaseNo;
  }

  public String getScheduleNo() {
    return scheduleNo;
  }

  public String getCertainLossNo() {
    return certainLossNo;
  }

  public String getRiskCode() {
    return riskCode;
  }

}
