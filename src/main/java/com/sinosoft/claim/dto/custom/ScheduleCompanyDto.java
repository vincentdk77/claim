package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpLscheduleCompanyDto;
/**
 * �°�����ʾ���ݴ������
 * <p>Title: �°�����ʾDTO</p>
 * <p>Description: ������������ڵ�</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */
public class ScheduleCompanyDto implements Serializable
{
   /** ��������������Ϣ*/
  private PrpLscheduleCompanyDto prpLscheduleCompanyDto;
  
   /** �������ĵ绰��*/
  private Collection  prpLschecduleCompanyMobileDtoList ;
  
  
public Collection getPrpLschecduleCompanyMobileDtoList() {
	return prpLschecduleCompanyMobileDtoList;
}
/**
 * @param prpLschecduleCompanyMobileDtoList The prpLschecduleCompanyMobileDtoList to set.
 */
public void setPrpLschecduleCompanyMobileDtoList(Collection prpLschecduleCompanyMobileDtoList) {
	this.prpLschecduleCompanyMobileDtoList = prpLschecduleCompanyMobileDtoList;
}

  /**�õ�����������Ϣ
   * @return ����������Ϣ
   */
  public PrpLscheduleCompanyDto getPrpLscheduleCompanyDto()
  {
    return prpLscheduleCompanyDto;
  }

  /**���õ���������Ϣ
   * @param prpLscheduleCompanyDto ����������Ϣ
   */
  public void setPrpLscheduleCompanyDto(PrpLscheduleCompanyDto prpLscheduleCompanyDto)
  {
     this.prpLscheduleCompanyDto = prpLscheduleCompanyDto;
  }

}
