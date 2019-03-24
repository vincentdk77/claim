package com.sinosoft.function.power.resource.dtofactory.custom;
/**
 * <p>Title: 通用SQL处理</p>
 * <p>Description: 理赔产品组通用SQL查询，查询系统表</p>
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

import com.sinosoft.sysframework.reference.DBManager;


public class DBCommonSQL {
  protected DBManager dbManager = null; //资源管理类
  private static Log logger = LogFactory.getLog(DBCommonSQL.class);

  /**
   * 构造函数
   * @param dbManager 资源管理类
   */
  public DBCommonSQL(DBManager dbManager){
      this.dbManager = dbManager;
  }

 /**
  * 根据SQL语句获取结果集
  */
   public boolean checkSysColumns(String iTableName,String iColName) throws SQLException,Exception
   {
       boolean blnFoundFlag = false;
       String statement = "";
       String strDatabaseName = "";
       String strServerName = "";
       int    count = -1;
       //此SQL是针对oracle
       iTableName = iTableName.toLowerCase();
       iColName = iColName.toLowerCase();
       statement = " SELECT COUNT(*) FROM USER_TAB_COLUMNS " +
                      " WHERE TABLE_NAME = '" + iTableName.toUpperCase()  + "'" +
                      " AND COLUMN_NAME = '" + iColName.toUpperCase()  + "'";
       logger.debug(statement);
       Collection collection = new ArrayList();

       ResultSet resultSet = dbManager.executeQuery(statement);
       resultSet.next() ;
       count = dbManager.getInt(resultSet,1);
       if(count==1)
       {
         blnFoundFlag=true;
       }
       else
       {
           blnFoundFlag = false;
       }
       
       resultSet.close();

       //此SQL针对Informix
       /*获取不到，则检查同义词表*/
       //strSqlStatement = " SELECT * FROM syssyntable " +
       //               " WHERE syssyntable.tabname = '" + iTableName + "'";


       //   strSqlStatement = " SELECT * FROM " + strDatabaseName.trim() + ":syscolumns " +
       //                  " WHERE colname = '" + iColName + "' AND tabid IN " +
       //                  "(SELECT tabid FROM " + strDatabaseName.trim() + ":systables " +
       //                  " WHERE tabname = '" + iTableName + "')";


       return blnFoundFlag;
   }

}
