package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是prpcengage特别约定表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCengageDto extends PrpCengageDtoBase implements Serializable{

  /**
     *  默认构造方法,构造一个默认的PrpCengageDto对象
     */
    public PrpCengageDto(){
    }
    /** 属性显示列表*/
    private Collection prpCengageList ;
    /** 属性特别约定内容*/
    private String context="";

    /**设置属性显示列表
     * @param prpLctextList 属性显示列表
     */
	  public void setPrpCengageList(Collection prpCengageList) {
	    this.prpCengageList = prpCengageList;
	  }

  public void setContext(String context) {
    this.context = context;
  }

  /**得到属性显示列表
    * @return 属性显示列表
    */
	  public Collection getPrpCengageList() {
	    return prpCengageList;
	  }

  public String getContext() {
    return context;
  }

}
