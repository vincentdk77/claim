package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是WfCondition工作流条件描述表的数据传输对象类<br>
 * 创建于 2004-08-09 19:54:50.620<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfConditionDto extends SwfConditionDtoBase implements Serializable{
  /** 编辑类型 */
    private String editType = "";
  /** 路径名*/
  private String pathName = "" ;
  /**
     *  默认构造方法,构造一个默认的SwfConditionDto对象
     */
    public SwfConditionDto(){
    }
    /** 属性显示列表*/
    private Collection conditionList ;


    /**
     * 获取列表
     * @return 属性列表
     */
    public Collection getConditionList(){
      return conditionList;
    }
    /**
     * 设置列表
     * @param nodeList 待设置的列表
     */
    public void setConditionList(Collection conditionList) {
      this.conditionList = conditionList;
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
 * 设置路径名
 * @param pathName 待设置的路径的值
 */
public void setPathName(String pathName){
    this.pathName = StringUtils.rightTrim(pathName);
}

/**
 * 获取路径名
 * @return 属性路径名
 */
public String getPathName(){
    return pathName;
}

}
