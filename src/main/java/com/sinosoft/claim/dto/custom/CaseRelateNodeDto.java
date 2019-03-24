package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
/**
 * ������ؽڵ����
 * <p>Title: ������ؽڵ����</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company:sinosoft </p>
 * @author sunhao
 * @version 1.0
 */
public class CaseRelateNodeDto implements Serializable
{
  /**����*/
  PrpCmainDto prpCmainDto= null;
  /**����*/
  PrpLregistDto prpLregistDto= null;
  /**����*/
  PrpLscheduleMainWFDto prpLscheduleMainWFDto= null;
  /**�鿱*/
  PrpLcheckDto prpLcheckDto= null;
  /**����/����*/
  PrpLverifyLossDto prpLverifyLossDto= null;
  /**����*/
  PrpLclaimDto prpLclaimDto= null;
  /**��֤*/
  PrpLcertifyCollectDto prpLcertifyCollectDto= null;
  /**Ԥ��*/
  PrpLprepayDto prpLprepayDto= null;
  /**ʵ��*/
  PrpLcompensateDto prpLcompensateDto= null;
  /**�᰸*/
  EndcaseDto endcaseDto= null;
  /**�ձ�*/
  private String riskCode = null;
  public PrpLcertifyCollectDto getPrpLcertifyCollectDto() {
    return prpLcertifyCollectDto;
  }

  public EndcaseDto getEndcaseDto() {
    return endcaseDto;
  }

  public PrpLclaimDto getPrpLclaimDto() {
    return prpLclaimDto;
  }

  public PrpLscheduleMainWFDto getPrpLscheduleMainWFDto() {
    return prpLscheduleMainWFDto;
  }

  public PrpLverifyLossDto getPrpLverifyLossDto() {
    return prpLverifyLossDto;
  }

  public PrpLcompensateDto getPrpLcompensateDto() {
    return prpLcompensateDto;
  }

  public PrpLprepayDto getPrpLprepayDto() {
    return prpLprepayDto;
  }

  public PrpLcheckDto getPrpLcheckDto() {
    return prpLcheckDto;
  }

  public PrpCmainDto getPrpCmainDto() {
    return prpCmainDto;
  }

  public PrpLregistDto getPrpLregistDto() {
    return prpLregistDto;
  }

  public void setRiskCode(String riskCode) {
    this.riskCode = riskCode;
  }

  public void setPrpLcertifyCollectDto(PrpLcertifyCollectDto
                                       prpLcertifyCollectDto) {
    this.prpLcertifyCollectDto = prpLcertifyCollectDto;
  }

  public void setEndcaseDto(EndcaseDto endcaseDto) {
    this.endcaseDto = endcaseDto;
  }

  public void setPrpLclaimDto(PrpLclaimDto prpLclaimDto) {
    this.prpLclaimDto = prpLclaimDto;
  }

  public void setPrpLscheduleMainWFDto(PrpLscheduleMainWFDto prpLscheduleMainWFDto) {
    this.prpLscheduleMainWFDto = prpLscheduleMainWFDto;
  }

  public void setPrpLverifyLossDto(PrpLverifyLossDto prpLverifyLossDto) {
    this.prpLverifyLossDto = prpLverifyLossDto;
  }

  public void setPrpLcompensateDto(PrpLcompensateDto prpLcompensateDto) {
    this.prpLcompensateDto = prpLcompensateDto;
  }

  public void setPrpLprepayDto(PrpLprepayDto prpLprepayDto) {
    this.prpLprepayDto = prpLprepayDto;
  }

  public void setPrpLcheckDto(PrpLcheckDto prpLcheckDto) {
    this.prpLcheckDto = prpLcheckDto;
  }

  public void setPrpCmainDto(PrpCmainDto prpCmainDto) {
    this.prpCmainDto = prpCmainDto;
  }

  public void setPrpLregistDto(PrpLregistDto prpLregistDto) {
    this.prpLregistDto = prpLregistDto;
  }

  public String getRiskCode() {
    return riskCode;
  }

  public CaseRelateNodeDto() {

  }

}
