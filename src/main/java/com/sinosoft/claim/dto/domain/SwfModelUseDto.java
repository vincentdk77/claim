package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����WfModelUseģ��ʹ�����õ����ݴ��������<br>
 * ������ 2004-08-10 10:49:19.939<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfModelUseDto extends SwfModelUseDtoBase implements Serializable{
  /** �༭���� */
    private String editType = "";
    /** �б�*/
   Collection modelUseList ;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�WfModelUseDto����
     */
    public SwfModelUseDto(){
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
  public Collection getModelUseList(){
    return modelUseList;
  }

  /**
   * �����б�
   * @param modelMainList �����õ��б�
   */
  public void setModelUseList(Collection modelUseList) {
    this.modelUseList = modelUseList;
  }


}
