package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是WfModelUse模板使用设置的数据传输对象类<br>
 * 创建于 2004-08-10 10:49:19.939<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfModelUseDto extends SwfModelUseDtoBase implements Serializable{
  /** 编辑类型 */
    private String editType = "";
    /** 列表*/
   Collection modelUseList ;

    /**
     *  默认构造方法,构造一个默认的WfModelUseDto对象
     */
    public SwfModelUseDto(){
    }

    /**
   * 设置编辑类型
   * @param editType 待设置的编辑类型的值
   */
  public void setEditType(String editType){
      this.editType = StringUtils.rightTrim(editType);
  }

  /**
   * 获取编辑类型
   * @return 属性编辑类型
   */
  public String getEditType(){
      return editType;
  }

  /**
   * 获取列表
   * @return 属性列表
   */
  public Collection getModelUseList(){
    return modelUseList;
  }

  /**
   * 设置列表
   * @param modelMainList 待设置的列表
   */
  public void setModelUseList(Collection modelUseList) {
    this.modelUseList = modelUseList;
  }


}
