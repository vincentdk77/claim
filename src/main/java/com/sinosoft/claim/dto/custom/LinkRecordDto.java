package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * �Զ���Ԥ�����ݴ������
 * <p>Title: ��������Ԥ��DTO</p>
 * <p>Description: ��������Ԥ����������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class LinkRecordDto implements Serializable
{
  /** ��λ*/
  private String comCode; 
  /** ��λ����*/
  private String comName;
  /** �ⰸ��ţ����ⰸ��*/
  private String claimNo;
  /** �ӱ�������*/
  private DateTime reportDate = new DateTime();
  /** �������� */
  private DateTime copyPolicyDate = new DateTime();
  /** ��ͻ���ϵ���� */
  private DateTime linkCustomDate = new DateTime();
  /** �ֳ��鿱����*/
  private DateTime checkDate = new DateTime();
  /** �᰸����*/
  private DateTime endCaseDate = new DateTime();
  /** ��֤��������*/
  private DateTime finishDocDate = new DateTime();
  private Collection prpLregistExtList = new ArrayList();
  private PrpLregistExtDto prpLregistExtDto = new PrpLregistExtDto();

  public LinkRecordDto()
  {
  }

  /**�õ���������
   * @return ��������
   */
  public String getComCode()
  {
    return comCode;
  }

  /**���ù�������
   * @param comCode ��������
   */
  public void setComCode(String comCode)
  {
     this.comCode = comCode;
  }
  /**�õ�������������
   * @return ������������
   */
  public String getComName()
  {
    return comName;
  }

  /**���ù�����������
   * @param comName ������������
   */
  public void setComName(String comName)
  {
     this.comName = comName;
  }
  
  /**�õ��ⰸ��
   * @return �ⰸ��
   */
  public String getClaimNo()
  {
    return claimNo;
  }

  /**�����ⰸ��
   * @param claimNo �ⰸ��
   */
  public void setClaimNo(String claimNo)
  {
     this.claimNo = claimNo;
  }
  
  /**�õ��ӱ�������
   * @return �ӱ�������
   */
  public DateTime getReportDate()
  {
    return reportDate;
  }

  /**���ýӱ�������
   * @param reportDate �ӱ�������
   */
  public void setReportDate(DateTime reportDate)
  {
     this.reportDate = reportDate;
  }
  
  /**�õ���������
   * @return ��������
   */
  public DateTime getCopyPolicyDate()
  {
    return copyPolicyDate;
  }

  /**���ó�������
   * @param copyPolicyDate ��������
   */
  public void setCopyPolicyDate(DateTime copyPolicyDate)
  {
     this.copyPolicyDate = copyPolicyDate;
  }

  /**�õ��ֳ��鿱����
   * @return �ֳ��鿱����
   */
  public DateTime getCheckDate()
  {
    return checkDate;
  }

  /**�����ֳ��鿱����
   * @param checkDate �ֳ��鿱����
   */
  public void setCheckDate(DateTime checkDate)
  {
     this.checkDate = checkDate;
  }

  /**�õ���ͻ���ϵ����
   * @return ��ͻ���ϵ����
   */
  public DateTime getLinkCustomDate()
  {
    return linkCustomDate;
  }

  /**������ͻ���ϵ����
   * @param linkCustomDate ��ͻ���ϵ����
   */
  public void setLinkCustomDate(DateTime linkCustomDate)
  {
     this.linkCustomDate = linkCustomDate;
  }

  /**�õ��᰸����
   * @return �᰸����
   */
  public DateTime getEndCaseDate()
  {
    return endCaseDate;
  }

  /**���ý᰸����
   * @param endCaseDate �᰸����
   */
  public void setEndCaseDate(DateTime endCaseDate)
  {
     this.endCaseDate = endCaseDate;
  }

  /**�õ���֤��������
   * @return ��֤��������
   */
  public DateTime getFinishDocDate()
  {
    return finishDocDate;
  }

  /**���õ�֤��������
   * @param finishDocDate ��֤��������
   */
  public void setFinishDocDate(DateTime finishDocDate)
  {
     this.finishDocDate = finishDocDate;
  }

  /**�õ���ϵ������¼�б�
   * @return ��ϵ������¼�б�
   */
  public Collection getPrpLregistExtList()
  {
    return prpLregistExtList;
  }

  /**������ϵ������¼�б�
   * @param prpLregistExtList ��ϵ������¼�б�
   */
  public void setPrpLregistExtList(Collection prpLregistExtList)
  {
     this.prpLregistExtList = prpLregistExtList;
  }
  
 
}
