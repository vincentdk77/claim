package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;
/**
 * ����prpldriver���ռ�ʻԱ��Ϣ������ݴ��������<br>
 * ������ 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLdriverDto extends PrpLdriverDtoBase implements Serializable{
   /** ������ʾ�б�*/
    private Collection driverList ;

   /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLdriverDto����
     */
    public PrpLdriverDto(){
    }

    /**
     * ��ȡ�б�
     * @return �����б�
     */
    public Collection getDriverList(){
      return driverList;
    }
    /**
     * �����б�
     * @param driverList �����õ��б�
     */
    public void setDriverList(Collection driverList) {
      this.driverList = driverList;
    }

}
