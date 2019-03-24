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
 * 案件相关节点对象
 * <p>Title: 案件相关节点对象</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company:sinosoft </p>
 * @author sunhao
 * @version 1.0
 */
public class CaseRelateNodeDto implements Serializable
{
  /**保单*/
  PrpCmainDto prpCmainDto= null;
  /**报案*/
  PrpLregistDto prpLregistDto= null;
  /**调度*/
  PrpLscheduleMainWFDto prpLscheduleMainWFDto= null;
  /**查勘*/
  PrpLcheckDto prpLcheckDto= null;
  /**定损/核损*/
  PrpLverifyLossDto prpLverifyLossDto= null;
  /**立案*/
  PrpLclaimDto prpLclaimDto= null;
  /**单证*/
  PrpLcertifyCollectDto prpLcertifyCollectDto= null;
  /**预赔*/
  PrpLprepayDto prpLprepayDto= null;
  /**实赔*/
  PrpLcompensateDto prpLcompensateDto= null;
  /**结案*/
  EndcaseDto endcaseDto= null;
  /**险别*/
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
