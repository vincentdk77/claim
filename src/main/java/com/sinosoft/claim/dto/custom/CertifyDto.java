package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;

/**
 * �Զ��嵥֤���ݴ������
 * <p>Title: �������ⵥ֤DTO</p>
 * <p>Description: �������ⵥ֤��������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */ 
public class CertifyDto implements Serializable
{
  /** ��֤�ռ�����Ϣ*/
  private ArrayList prpLcertifyCollectDtoList;
  /** ��֤�ռ�����Ϣ*/
  private PrpLcertifyCollectDto prpLcertifyCollectDto;
  /** ��֤��Ӱ����Ϣ */
  private ArrayList prpLcertifyImgDtoList;
  /** ����ָ����Ϣ */
  private ArrayList prpLcertifyDirectDtoList;
  /** ������������*/
  private ArrayList prpLqualityCheckList; 
  /** ����״̬��Ϣ*/
  private PrpLclaimStatusDto prpLclaimStatusDto;
  /** ����״̬��Ϣ(����)*/
  private ArrayList prpLclaimStatusDtoList;
  /** ������Ϣ����˵��*/
  private ArrayList prpLregistExtDtoList;
  /** �ڵ�����*/
  private String nodeType;
  /**�ط�����**/
  private PrplreturnvisitswflogDto prplreturnvisitswflogDto;

  /**
   *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CertifyDto����
   */
  public CertifyDto(){
  }

  /**
   * �������Ե�֤�ռ�����Ϣ
   * @param prpLcertifyCollectDtoList �����õ����Ե�֤�ռ�����Ϣ
   */
  public void setPrpLcertifyCollectDtoList(ArrayList prpLcertifyCollectDtoList){
      this.prpLcertifyCollectDtoList = prpLcertifyCollectDtoList;
  }

  /**
   * ��ȡ���Ե�֤�ռ�����Ϣ
   * @return ���Ե�֤�ռ�����Ϣ��ֵ
   */
  public ArrayList getPrpLcertifyCollectDtoList(){
      return prpLcertifyCollectDtoList;
  }

  /**
   * �������Ե�֤��Ӱ����Ϣ
   * @param prpLcertifyImgDtoList �����õ����Ե�֤��Ӱ����Ϣ��ֵ
   */
  public void setPrpLcertifyImgDtoList(ArrayList prpLcertifyImgDtoList){
      this.prpLcertifyImgDtoList = prpLcertifyImgDtoList;
  }

  /**
   * ��ȡ���Ե�֤��Ӱ����Ϣ
   * @return ���Ե�֤��Ӱ����Ϣ��ֵ
   */
  public ArrayList getPrpLcertifyImgDtoList(){
      return prpLcertifyImgDtoList;
  }

  /**
   * �������Բ���״̬��Ϣ
   * @param ����״̬��Ϣ �����õ����Բ���״̬��Ϣ��ֵ
   */
  public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto){
      this.prpLclaimStatusDto = prpLclaimStatusDto;
  }

  public void setPrpLcertifyCollectDto(PrpLcertifyCollectDto
                                       prpLcertifyCollectDto) {
    this.prpLcertifyCollectDto = prpLcertifyCollectDto;
  }

  public void setNodeType(String nodeType) {
    this.nodeType = nodeType;
  }

  public void setPrpLcertifyDirectDtoList(ArrayList prpLcertifyDirectDtoList) {
    this.prpLcertifyDirectDtoList = prpLcertifyDirectDtoList;
  }

  /**
   * ��ȡ���Բ���״̬��Ϣ
   * @return ���Բ���״̬��Ϣ��ֵ
   */
  public PrpLclaimStatusDto getPrpLclaimStatusDto(){
      return prpLclaimStatusDto;
  }

  public PrpLcertifyCollectDto getPrpLcertifyCollectDto() {
    return prpLcertifyCollectDto;
  }

  public String getNodeType() {
    return nodeType;
  }

  public ArrayList getPrpLcertifyDirectDtoList() {
    return prpLcertifyDirectDtoList;
  }
/**
 * @return Returns the prpLqualityCheckList.
 */
public ArrayList getPrpLqualityCheckList() {
	return prpLqualityCheckList;
}
/**
 * @param prpLqualityCheckList The prpLqualityCheckList to set.
 */
public void setPrpLqualityCheckList(ArrayList prpLqualityCheckList) {
	this.prpLqualityCheckList = prpLqualityCheckList;
}
/**
 * @return Returns the prpLregistExtDtoList.
 */
public ArrayList getPrpLregistExtDtoList() {
	return prpLregistExtDtoList;
}
/**
 * @param prpLregistExtDtoList The prpLregistExtDtoList to set.
 */
public void setPrpLregistExtDtoList(ArrayList prpLregistExtDtoList) {
	this.prpLregistExtDtoList = prpLregistExtDtoList;
}

public ArrayList getPrpLclaimStatusDtoList() {
	return prpLclaimStatusDtoList;
}

public void setPrpLclaimStatusDtoList(ArrayList prpLclaimStatusDtoList) {
	this.prpLclaimStatusDtoList = prpLclaimStatusDtoList;
}

public PrplreturnvisitswflogDto getPrplreturnvisitswflogDto() {
	return prplreturnvisitswflogDto;
}

public void setPrplreturnvisitswflogDto(
		PrplreturnvisitswflogDto prplreturnvisitswflogDto) {
	this.prplreturnvisitswflogDto = prplreturnvisitswflogDto;
}

}
