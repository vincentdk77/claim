package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLscheduleCompany--调度中心提示信息设置表的数据传输对象类<br>
 * 创建于 2005-08-08 21:52:05.033<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLscheduleCompanyDto extends PrpLscheduleCompanyDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpLscheduleCompanyDto对象
     */
    public PrpLscheduleCompanyDto(){
    }
    
     /** 属性提示标题信息 */
    private String promptTitle = "";
    /** 属性调度中心名称信息 */
    private String comName = "";
    
    /** 列表*/ 
    Collection scheduleMobileList ;
    
    /**
     * 获取列表
     * @return 属性列表
     */
    public Collection getScheduleMobileList(){
      return scheduleMobileList;
    }
    
    /**
     * 设置列表
     * @param registList 待设置的列表
     */
    public void setScheduleMobileList(Collection scheduleMobileList) {
      this.scheduleMobileList = scheduleMobileList;
    }
    
     /**
     * 设置属性提示标题信息
     * @param promptTitle 待设置的属性提示标题信息的值
     */
    public void setPromptTitle(String promptTitle){
        this.promptTitle = StringUtils.rightTrim(promptTitle);
    }

    /**
     * 获取属性提示标题信息
     * @return 属性提示标题信息的值
     */
    public String getPromptTitle(){
        return promptTitle;
    }
    
  
     /**
     * 设置属性调度中心名称信息
     * @param comName 待设置的属性调度中心名称信息的值
     */
    public void setComName(String comName){
        this.comName = StringUtils.rightTrim(comName);
    }

    /**
     * 获取属性调度中心名称信息
     * @return 属性调度中心名称信息的值
     */
    public String getComName(){
        return comName;
    }
}
