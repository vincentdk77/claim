package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����PrpLclaimStatus����ڵ�״̬������ݴ��������<br>
 * ������ 2004-05-09 11:07:22.399<br>
 * JToolpad(1.2.9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLclaimStatusDto extends PrpLclaimStatusDtoBase implements Serializable{
  /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLclaimStatusDto����
     */
    public PrpLclaimStatusDto(){
    	 this.setBusinessNo("");
         this.setPolicyNo("") ;
         this.setNodeType ( "");
         this.setStatus("");
         this.setFlowID ( "");
         this.setFlag ("");
         this.setSerialNo(0);
    }

    /** ������ʾ�б�*/
    private Collection claimList ;
    /** �༭���� */
    private String editType = "";
    /** �������ͱ�־ */
    private String typeFlagName = "";


    /**���ñ༭����
     * @param editType �༭����
     */
    public void setEditType(String editType) {
      this.editType = editType;
    }

    /**����������ʾ�б�
     * @param prpLctextList ������ʾ�б�
     */
    public void setClaimList(Collection claimList) {
      this.claimList = claimList;
    }

  public void setTypeFlagName(String typeFlagName) {
    this.typeFlagName = typeFlagName;
  }

  /**�õ�������ʾ�б�
  * @return ������ʾ�б�
  */
    public Collection getClaimList() {
      return claimList;
    }

    /**���ñ༭����
     * @param editType �༭����
     */
    public String getEditType() {
      return editType;
    }

  public String getTypeFlagName() {
    return typeFlagName;
  }

}
