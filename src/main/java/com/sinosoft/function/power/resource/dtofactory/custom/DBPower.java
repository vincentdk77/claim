package com.sinosoft.function.power.resource.dtofactory.custom;
/**
 * <p>Title: 人员权限处理</p>
 * <p>Description: 节点人员权限处理</p>
 * <p>Copyright: Copyright (c) 2004.11</p>
 * <p>Company: Sinosoft</p>
 * @author 理赔产品组 魏士鑫
 * @version 1.0
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpDuserDto;
import com.sinosoft.sysframework.reference.DBManager;


public class DBPower {
  protected DBManager dbManager = null; //资源管理类
  private static Log logger = LogFactory.getLog(DBPower.class);

  /**
   * 构造函数
   * @param dbManager 资源管理类
   */
  public DBPower(DBManager dbManager){
      this.dbManager = dbManager;
  }


 /**
  * 根据岗位（任务）及险种，部门条件获得某岗位的人员权限
  * @param conditions String
  * @throws SQLException
  * @throws Exception
  * @return Collection
  */
 public Collection findByTask(String conditions) throws SQLException,Exception
   {
       Collection powerList = new ArrayList();
       String statement = "";

       //根据条件查询
       logger.debug(conditions);

       PrpDuserDto prpDuserDto = null;
       ResultSet resultSet = dbManager.executeQuery(conditions);
       int count=0;

       while(resultSet.next())
       {
           count++;

           prpDuserDto = new PrpDuserDto();
           prpDuserDto.setUserCode(dbManager.getString(resultSet,1));
           prpDuserDto.setUserName(dbManager.getString(resultSet,2));
           powerList.add(prpDuserDto);
       }
       resultSet.close();
       logger.info("DBPower.findByTask() success!");
       return powerList;

   }

}
