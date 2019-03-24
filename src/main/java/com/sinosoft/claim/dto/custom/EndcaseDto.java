package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;

/**
 * �Զ���᰸���ݴ������
 * <p>Title: ��������᰸DTO</p>
 * <p>Description: ��������᰸��������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class EndcaseDto implements Serializable
{
  /** �ⰸ�ű�����Ϣ*/
  private ArrayList prpLcaseNoDtoList;
  /** ������Ϣ*/
  private PrpLclaimDto prpLclaimDto;
  
  
  private PrpLrecaseDto prpLrecaseDto;
  /** ����������Ϣ*/
  private ArrayList prpLcompensateDtoList;
  /** �᰸����*/
  private ArrayList prpLltextDtoList;
  /** ����״̬��Ϣ*/
  private PrpLclaimStatusDto prpLclaimStatusDto;
  /**����ԭ����ϸ��Ϣ*/
  private ArrayList prpLltextDtoList3;
  
  /** �ط����� */
	private PrplreturnvisitswflogDto prplreturnvisitswflogDto;
	
  public ArrayList getPrpLltextDtoList3() {
	return prpLltextDtoList3;
  }

  public void setPrpLltextDtoList3(ArrayList prpLltextDtoList3) {
	this.prpLltextDtoList3 = prpLltextDtoList3;
  }

/**�õ�������������Ϣ
   * @return ������������Ϣ
   */
  public ArrayList getPrpLcompensateDtoList() {
    return prpLcompensateDtoList;
  }

  /**�õ��᰸�ı���Ϣ
   * @return  �᰸�ı���Ϣ
   */
  public ArrayList getPrpLltextDtoList() {
    return prpLltextDtoList;
  }

  /**�õ�����������Ϣ
   * @return ����������Ϣ
   */
  public PrpLclaimDto getPrpLclaimDto() {
    return prpLclaimDto;
  }
  
  public PrpLrecaseDto getPrpLrecaseDto() {
    return prpLrecaseDto;
  }
  /**�õ��᰸������Ϣ
   * @return �᰸������Ϣ
   */
  public ArrayList getPrpLcaseNoDtoList() {
    return prpLcaseNoDtoList;
  }
  
  /**���ò���״̬��Ϣ
   * @param prpLclaimStatusDto ����״̬��Ϣ
   */
  public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
    this.prpLclaimStatusDto = prpLclaimStatusDto;
  }
    
  /**����������������Ϣ
   * @param setPrpLcompensateDtoList ������������Ϣ
   */
  public void setPrpLcompensateDtoList(ArrayList prpLcompensateDtoList) {
    this.prpLcompensateDtoList = prpLcompensateDtoList;
  }

  /**���ý᰸�ı���Ϣ
   * @param prpLltextDtoList �᰸�ı���Ϣ
   */
  public void setPrpLltextDtoList(ArrayList prpLltextDtoList) {
    this.prpLltextDtoList = prpLltextDtoList;
  }
  
  /**��������������Ϣ
   * @param prpLclaimDto ����������Ϣ
   */
  public void setPrpLclaimDto(PrpLclaimDto prpLclaimDto) {
    this.prpLclaimDto = prpLclaimDto;
  }
  
  public void setPrpLrecaseDto(PrpLrecaseDto prpLrecaseDto) {
    this.prpLrecaseDto = prpLrecaseDto;
  }

  /**���ý᰸������Ϣ
   * @param prpLperpayDto �᰸������Ϣ
   */
  public void setPrpLcaseNoDtoList(ArrayList prpLcaseNoDtoList) {
    this.prpLcaseNoDtoList = prpLcaseNoDtoList;
  }
  
  /**�õ�����״̬��Ϣ
   * @return  ����״̬��Ϣ
   */   
  public PrpLclaimStatusDto getPrpLclaimStatusDto() {
    return prpLclaimStatusDto;
  }

  public PrplreturnvisitswflogDto getPrplreturnvisitswflogDto() {
	return prplreturnvisitswflogDto;
  }

  public void setPrplreturnvisitswflogDto(
		PrplreturnvisitswflogDto prplreturnvisitswflogDto) {
	this.prplreturnvisitswflogDto = prplreturnvisitswflogDto;
  }

  public EndcaseDto()
  {
  }


}
