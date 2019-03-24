package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;
/**
 * 这是prpLcheckItem查勘任务标的表的数据传输对象类<br>
 * 创建于 2004-07-28 16:15:24.734<br>
 * JToolpad(1.2.12-RC9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcheckItemDto extends PrpLcheckItemDtoBase implements Serializable{
    
    /** 属性显示列表*/
   private Collection checkItemList ;
   
   /** 属性操作员名称 */
    private String operatorName = "";
    
    
    /**
     *  默认构造方法,构造一个默认的PrpLcheckItemDto对象
     */
    public PrpLcheckItemDto(){
    }
    
    
       /**设置属性显示列表
     * @param prpLcheckItemList 属性显示列表
     */
    public void setCheckItemList(Collection checkItemList) {
      this.checkItemList = checkItemList;
    }

  /**得到属性显示列表
  * @return 属性显示列表
  */
    public Collection getCheckItemList() {
      return checkItemList;
    }
    
   /**
     * 设置属性操作员名称
     * @param operatorName 待设置的属性操作员名称的值
     */
    public void setOperatorName(String operatorName){
        this.operatorName = StringUtils.rightTrim(operatorName);
    }

    /**
     * 获取属性操作员名称
     * @return 属性操作员名称的值
     */
    public String getOperatorName(){
        return operatorName;
    }

}
