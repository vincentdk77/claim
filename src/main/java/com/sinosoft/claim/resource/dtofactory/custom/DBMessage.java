package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.domain.PrpLmessageDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLmessage;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * 理赔流转讨论留言DB层
 * <p>Title:理赔流转讨论留言DB层 </p>
 * <p>Description:理赔流转讨论留言DB层 </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company:sinosoft </p>
 * @author Sunhao
 * @version 1.0
 */
public class DBMessage {
  /**
   * 默认构造函数
   */
  public DBMessage() {
  }

  /**
   * 保存留言
   * @param dbManager DBManager
   * @param prpLmessageDto prpLmessageDto
   * @throws SQLException
   * @throws Exception
   */
  public void insert(DBManager dbManager,PrpLmessageDto prpLmessageDto
  ) throws SQLException,Exception
  {
    new DBPrpLmessage(dbManager).insert(prpLmessageDto);
  }

  /*
     * 序号取得方法
     * @param serialNo 序号
     * @throws SQLException
     * @throws Exception
     * @return 无
     */
    public int getNo(DBManager dbManager,String registNo)
      throws SQLException,Exception
    {
         return new DBPrpLmessage(dbManager).getNo(registNo);
    }


}
