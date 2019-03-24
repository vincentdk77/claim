package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����WfCondition��������������������ݴ��������<br>
 * ������ 2004-08-09 19:54:50.620<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfConditionDto extends SwfConditionDtoBase implements Serializable{
  /** �༭���� */
    private String editType = "";
  /** ·����*/
  private String pathName = "" ;
  /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�SwfConditionDto����
     */
    public SwfConditionDto(){
    }
    /** ������ʾ�б�*/
    private Collection conditionList ;


    /**
     * ��ȡ�б�
     * @return �����б�
     */
    public Collection getConditionList(){
      return conditionList;
    }
    /**
     * �����б�
     * @param nodeList �����õ��б�
     */
    public void setConditionList(Collection conditionList) {
      this.conditionList = conditionList;
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
 * ����·����
 * @param pathName �����õ�·����ֵ
 */
public void setPathName(String pathName){
    this.pathName = StringUtils.rightTrim(pathName);
}

/**
 * ��ȡ·����
 * @return ����·����
 */
public String getPathName(){
    return pathName;
}

}
