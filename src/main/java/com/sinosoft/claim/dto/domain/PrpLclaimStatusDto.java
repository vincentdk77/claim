package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是PrpLclaimStatus理赔节点状态表的数据传输对象类<br>
 * 创建于 2004-05-09 11:07:22.399<br>
 * JToolpad(1.2.9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLclaimStatusDto extends PrpLclaimStatusDtoBase implements Serializable{
  /**
     *  默认构造方法,构造一个默认的PrpLclaimStatusDto对象
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

    /** 属性显示列表*/
    private Collection claimList ;
    /** 编辑类型 */
    private String editType = "";
    /** 属性类型标志 */
    private String typeFlagName = "";


    /**设置编辑类型
     * @param editType 编辑类型
     */
    public void setEditType(String editType) {
      this.editType = editType;
    }

    /**设置属性显示列表
     * @param prpLctextList 属性显示列表
     */
    public void setClaimList(Collection claimList) {
      this.claimList = claimList;
    }

  public void setTypeFlagName(String typeFlagName) {
    this.typeFlagName = typeFlagName;
  }

  /**得到属性显示列表
  * @return 属性显示列表
  */
    public Collection getClaimList() {
      return claimList;
    }

    /**设置编辑类型
     * @param editType 编辑类型
     */
    public String getEditType() {
      return editType;
    }

  public String getTypeFlagName() {
    return typeFlagName;
  }

}
