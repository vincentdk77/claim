package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����WfModelMainģ����������ݴ��������<br>
 * ������ 2004-08-09 19:54:50.600<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfModelMainDto extends SwfModelMainDtoBase implements Serializable{
  /** �༭���� */
    private String editType = "";
    /** �б�*/
   Collection modelMainList ;
   /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�WfModelMainDto����
     */
    public SwfModelMainDto(){
    }

    /**
   * ���ñ༭����
   * @param editType �����õı༭���͵�ֵ
   */
  public void setEditType(String editType){
      this.editType = StringUtils.rightTrim(editType);
  }

  /**
   * ��ȡ�༭����
   * @return ���Ա༭����
   */
  public String getEditType(){
      return editType;
  }

  /**
   * ��ȡ�б�
   * @return �����б�
   */
  public Collection getModelMainList(){
    return modelMainList;
  }

  /**
   * �����б�
   * @param modelMainList �����õ��б�
   */
  public void setModelMainList(Collection modelMainList) {
    this.modelMainList = modelMainList;
  }


}
