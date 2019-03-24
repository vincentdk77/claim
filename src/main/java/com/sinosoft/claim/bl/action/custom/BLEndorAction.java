package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.EndorDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBEndor;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * 冲减保额逻辑
 * <p>Title: 车险理赔样本程序</p>
 * <p>Description: 车险理赔样本程序冲减保额action</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author 车险理赔项目组
 * @version 1.0
 */
public class BLEndorAction
{
  public BLEndorAction()
  {
  }

  /**
   * 保存冲减保额
   * @param endorDto：自定义冲减保额对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,EndorDto endorDto)
    throws SQLException,Exception
  {
    DBEndor dbEndor = null;
    //业务操作
    dbEndor = new DBEndor();
    dbEndor.insert(dbManager,endorDto);
  }

}
