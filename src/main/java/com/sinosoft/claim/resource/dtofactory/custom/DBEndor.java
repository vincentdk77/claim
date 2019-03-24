package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.EndorDto;
import com.sinosoft.claim.dto.domain.PrpLendorDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLendor;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 冲减保额数据库管理对象
 * <p>Title: 车险理赔冲减保额数据管理</p>
 * <p>Description: 车险理赔冲减保额数据管理</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class DBEndor
{
  private DBManager dbManager = null; //资源管理类

  /**
   * 构造函数
   * @param dbManager 资源管理类
   */
  public DBEndor()
  {

  }

  /**
   * 冲减保额保存方法
   *@param endorDto 冲减保额对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void insert(DBManager dbManager,EndorDto endorDto)
    throws SQLException,Exception
  {
    if(endorDto.getPrpLendorList()!=null ){
    	for(int i=0;i<endorDto.getPrpLendorList().size();i++)
    	{
		    PrpLendorDto prpLendor =  (PrpLendorDto)endorDto.getPrpLendorList().get(i);
		    String condition = " claimNo = " + "'" + prpLendor.getClaimNo() + "' and COMPENSATENO = " + "'" + prpLendor.getCompensateNo() +"' and endorType = "+ "'" + prpLendor.getEndorType() +"'";
		    String statement = " DELETE FROM PrpLendor Where " + condition;
		    dbManager.executeUpdate(statement);
    	}
    new DBPrpLendor(dbManager).insertAll(endorDto.getPrpLendorList());
    }
  }
}


