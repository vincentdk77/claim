package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����prpldoc���ⵥ֤��Ϣ������ݴ��������<br>
 * ������ 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLdocDto extends PrpLdocDtoBase implements Serializable{
    private Collection docList ;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLdocDto����
     */
    public PrpLdocDto(){
    }
    /**
     * ��ȡ�б�
     * @return �����б�
     */
    public Collection getDocList(){
      return docList;
    }
    /**
     * �����б�
     * @param driverList �����õ��б�
     */
    public void setDocList(Collection docList) {
      this.docList = docList;
    }
	
}
