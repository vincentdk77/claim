package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是prpldoc索赔单证信息表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLdocDto extends PrpLdocDtoBase implements Serializable{
    private Collection docList ;
    /**
     *  默认构造方法,构造一个默认的PrpLdocDto对象
     */
    public PrpLdocDto(){
    }
    /**
     * 获取列表
     * @return 属性列表
     */
    public Collection getDocList(){
      return docList;
    }
    /**
     * 设置列表
     * @param driverList 待设置的列表
     */
    public void setDocList(Collection docList) {
      this.docList = docList;
    }
	
}
