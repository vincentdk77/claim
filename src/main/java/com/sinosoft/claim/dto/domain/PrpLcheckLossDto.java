package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����prplcheckloss�鿱�¹ʹ����������ݴ��������<br>
 * ������ 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcheckLossDto extends PrpLcheckLossDtoBase implements Serializable{

  /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcheckLossDto����
     */
    public PrpLcheckLossDto(){
    }
    /** ������ʾ�б�*/
    private Collection prpLcheckLossList ;
    /** �����ձ����� */
    private String kindName = "";

   /**����������ʾ�б�
    * @param prpLctextList ������ʾ�б�
    */
    public void setPrpLcheckLossList(Collection prpLcheckLossList) {
      this.prpLcheckLossList = prpLcheckLossList;
    }

    /**���������ձ�����
     * @param kindName �ձ�����
     */

    public void setKindName(String kindName) {
      this.kindName = kindName;
    }

  /**�õ�������ʾ�б�
   * @return ������ʾ�б�
   */
    public Collection getPrpLcheckLossList() {
      return prpLcheckLossList;
    }
    /**�õ��ձ�����
     * @return �ձ�����
     */
    public String getKindName() {
      return kindName;
    }

}
