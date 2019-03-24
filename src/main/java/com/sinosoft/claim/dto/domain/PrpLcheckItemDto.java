package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;
/**
 * ����prpLcheckItem�鿱�����ı�����ݴ��������<br>
 * ������ 2004-07-28 16:15:24.734<br>
 * JToolpad(1.2.12-RC9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcheckItemDto extends PrpLcheckItemDtoBase implements Serializable{
    
    /** ������ʾ�б�*/
   private Collection checkItemList ;
   
   /** ���Բ���Ա���� */
    private String operatorName = "";
    
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcheckItemDto����
     */
    public PrpLcheckItemDto(){
    }
    
    
       /**����������ʾ�б�
     * @param prpLcheckItemList ������ʾ�б�
     */
    public void setCheckItemList(Collection checkItemList) {
      this.checkItemList = checkItemList;
    }

  /**�õ�������ʾ�б�
  * @return ������ʾ�б�
  */
    public Collection getCheckItemList() {
      return checkItemList;
    }
    
   /**
     * �������Բ���Ա����
     * @param operatorName �����õ����Բ���Ա���Ƶ�ֵ
     */
    public void setOperatorName(String operatorName){
        this.operatorName = StringUtils.rightTrim(operatorName);
    }

    /**
     * ��ȡ���Բ���Ա����
     * @return ���Բ���Ա���Ƶ�ֵ
     */
    public String getOperatorName(){
        return operatorName;
    }

}
