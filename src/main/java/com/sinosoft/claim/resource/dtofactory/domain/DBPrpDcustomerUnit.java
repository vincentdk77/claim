package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcustomerUnitDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDcustomerUnit单位客户代码表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcustomerUnit extends DBPrpDcustomerUnitBase{
    private static Log log = LogFactory.getLog(DBPrpDcustomerUnit.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDcustomerUnit(DBManager dbManager){
        super(dbManager);
    }
    
    //modify by wangli add start 20050602
    /** 根据客户代码得到客户姓名
     * @param agentCode 客户代码
     */
  public String translateCustomerCName(String customerCode)
    throws SQLException,Exception
    {
  	    PrpDcustomerUnitDto prpDcustomerUnitDto = new PrpDcustomerUnitDto();	
  	    prpDcustomerUnitDto = this.findByPrimaryKey(customerCode);
    	if(prpDcustomerUnitDto==null)
    	{
    		return "" ;
    	}
    	return prpDcustomerUnitDto.getCustomerCName();
    
    }
    
 //  modify by wangli add start 20050602
}
