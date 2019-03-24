package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpgroup的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:16:30<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpGroup extends DBPrpGroupBase{
    private static Log log = LogFactory.getLog(DBPrpGroup.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpGroup(DBManager dbManager){
        super(dbManager);
    }


  /**
  * 获取单号编组
  * @param subGroupNo  子编组
  * @return strGroupNo 主编组
  * @throws Exception
  */
 public String getGroupNo(String subGroupNo) throws Exception{

   String strGroupNo = "";
   String statement = " Select distinct GroupNo From PrpGroup Where subGroupNo = ?";
   log.debug(statement);
   dbManager.prepareStatement(statement);
     //设置条件字段;
   dbManager.setString(1,subGroupNo);
   ResultSet resultSet = dbManager.executePreparedQuery();
   if(resultSet.next()){
     strGroupNo = dbManager.getString(resultSet,1);
   }
   else{

     strGroupNo = subGroupNo;
   }
   resultSet.close();
   log.info("DBPrpGroup.getGroupNo success!");
   return strGroupNo;
 }

}
