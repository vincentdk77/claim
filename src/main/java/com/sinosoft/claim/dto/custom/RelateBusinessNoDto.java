package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
/**
 * 关联业务号传输对象
 * <p>Title: 关联业务号传输对象</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company:sinosoft </p>
 * @author sunhao
 * @version 1.0
 */
public class RelateBusinessNoDto implements Serializable
{
  /**保单号*/
  private String policyNo = "";
  /**报案号*/
  private String registNo = "";
  /**调度号*/
  private String scheduleNo = "";
  /**查勘号*/
  private String checkNo = "";
  /**定损号*/
  private String certainLossNo = "";
  /**核损号*/
  private String verifyLossNo = "";
  /**赔案号*/
  private String claimNo = "";
  /**单证号*/
  private String certifyNo = "";
  /**预赔号*/
  private String prepayNo = "";
  /**实赔号*/
  private String compensateNo = "";
  /**结案号*/
  private String endcaseNo = "";
  /**险别*/
  private String riskCode = "";

  public RelateBusinessNoDto() {

  }


  /**
   * 设置属性保单号码
   * @return 保单号码的值
   */
  public void setPolicyNo(String policyNo){
      this.policyNo = policyNo;
  }

  /**
   * 获取属性保单号码
   * @return 属性保单号码的值
   */
  public String getPolicyNo(){
      return policyNo;
  }

  /**
   * 设置属性报案号
   * @return 报案号的值
   */
  public void setRegistNo(String registNo){
      this.registNo = registNo;
  }

  /**
   * 获取属性报案号
   * @return 属性报案号的值
   */
  public String getRegistNo(){
      return registNo;
  }

  /**
   * 设置属性赔案号
   * @return 赔案号的值
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
   * 获取属性赔案号
   * @return 属性赔案号的值
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
