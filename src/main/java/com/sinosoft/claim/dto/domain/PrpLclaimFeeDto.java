package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;
/**
 * 这是prplclaimfee估损金额表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLclaimFeeDto extends PrpLclaimFeeDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpLclaimFeeDto对象
     */
    private Collection claimFeeList ;

    private String currencyName = "";
	
    public PrpLclaimFeeDto(){
    }

    /**
     * 获取列表
     * @return 属性列表
     */
    public Collection getClaimFeeList(){
      return claimFeeList ;
    }
    /**
     * 设置列表
     * @param driverList 待设置的列表
     */
    public void setClaimFeeList(Collection claimFeeList ) {
      this.claimFeeList  = claimFeeList ;
    }

    /**
     * 设置属性币别名称
     * @param currencyName 待设置的属性币别名称的值
     */
    public void setCurrencyName(String currencyName){
        this.currencyName = StringUtils.rightTrim(currencyName);
    }

    /**
     * 获取属性币别名称
     * @return 属性币别名称的值
     */
    public String getCurrencyName(){
        return currencyName;
    }
	
	
}
