package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����PrpLthirdCarLoss��ʧ��λ�����ݴ��������<br>
 * ������ 2004-12-06 12:08:34.673<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLthirdCarLossDto extends PrpLthirdCarLossDtoBase implements Serializable{
  public void setThirdCarLossList(Collection thirdCarLossList) {
    this.thirdCarLossList = thirdCarLossList;
  }

  public Collection getThirdCarLossList() {
    return thirdCarLossList;
  }

  /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLthirdCarLossDto����
     */
    public PrpLthirdCarLossDto(){
  }
   /** ������ʾ�б�*/
    private Collection thirdCarLossList ;
}
