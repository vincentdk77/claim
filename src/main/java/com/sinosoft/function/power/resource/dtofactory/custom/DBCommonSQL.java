package com.sinosoft.function.power.resource.dtofactory.custom;
/**
 * <p>Title: ͨ��SQL����</p>
 * <p>Description: �����Ʒ��ͨ��SQL��ѯ����ѯϵͳ��</p>
 * <p>Copyright: Copyright (c) 2004.11</p>
 * <p>Company: Sinosoft</p>
 * @author �����Ʒ�� κʿ��
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
  protected DBManager dbManager = null; //��Դ������
  private static Log logger = LogFactory.getLog(DBCommonSQL.class);

  /**
   * ���캯��
   * @param dbManager ��Դ������
   */
  public DBCommonSQL(DBManager dbManager){
      this.dbManager = dbManager;
  }

 /**
  * ����SQL����ȡ�����
  */
   public boolean checkSysColumns(String iTableName,String iColName) throws SQLException,Exception
   {
       boolean blnFoundFlag = false;
       String statement = "";
       String strDatabaseName = "";
       String strServerName = "";
       int    count = -1;
       //��SQL�����oracle
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

       //��SQL���Informix
       /*��ȡ����������ͬ��ʱ�*/
       //strSqlStatement = " SELECT * FROM syssyntable " +
       //               " WHERE syssyntable.tabname = '" + iTableName + "'";


       //   strSqlStatement = " SELECT * FROM " + strDatabaseName.trim() + ":syscolumns " +
       //                  " WHERE colname = '" + iColName + "' AND tabid IN " +
       //                  "(SELECT tabid FROM " + strDatabaseName.trim() + ":systables " +
       //                  " WHERE tabname = '" + iTableName + "')";


       return blnFoundFlag;
   }

}
