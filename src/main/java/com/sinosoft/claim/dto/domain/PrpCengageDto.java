package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����prpcengage�ر�Լ��������ݴ��������<br>
 * ������ 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCengageDto extends PrpCengageDtoBase implements Serializable{

  /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCengageDto����
     */
    public PrpCengageDto(){
    }
    /** ������ʾ�б�*/
    private Collection prpCengageList ;
    /** �����ر�Լ������*/
    private String context="";

    /**����������ʾ�б�
     * @param prpLctextList ������ʾ�б�
     */
	  public void setPrpCengageList(Collection prpCengageList) {
	    this.prpCengageList = prpCengageList;
	  }

  public void setContext(String context) {
    this.context = context;
  }

  /**�õ�������ʾ�б�
    * @return ������ʾ�б�
    */
	  public Collection getPrpCengageList() {
	    return prpCengageList;
	  }

  public String getContext() {
    return context;
  }

}
