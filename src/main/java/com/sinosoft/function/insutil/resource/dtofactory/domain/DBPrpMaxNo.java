package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpMaxNoDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpmaxno的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:16:30<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpMaxNo extends DBPrpMaxNoBase{
    private static Log log = LogFactory.getLog(DBPrpMaxNo.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpMaxNo(DBManager dbManager){
        super(dbManager);
    }
    
   /**
   * 从单号表PrpMaxNo获取最大和最小单号
   * @param iGroupNo
   * @param iTableName
   * @return String[]  String[1]:最大号MaxNo,String[2]:最小号MinNo,String[3]:记录数Count
   * @throws Exception
   * @throws SQLException
   */
  /*public String[] getMaxMinNo(String groupNo,String tableName)
      throws Exception,SQLException
  {
    String[] strMaxMinNo=new String[3];
    String statement = " SELECT MAX(MaxNo),MIN(MaxNo),COUNT(*) FROM PrpMaxNo WHERE groupNo =? AND tableName =?";
    log.debug(statement);
    dbManager.prepareStatement(statement);
    //设置条件字段;
    dbManager.setString(1,groupNo);
    dbManager.setString(2,tableName);
    ResultSet resultSet = dbManager.executePreparedQuery();
    strMaxMinNo[2]="0";
    while(resultSet.next())
    {
      strMaxMinNo[0] = dbManager.getString(resultSet,1);
      strMaxMinNo[1] = dbManager.getString(resultSet,2);
      strMaxMinNo[2] = dbManager.getString(resultSet,3);
    }
    resultSet.close();
    log.info("DBPrpMaxNo.getMaxMinNo success!");
    return strMaxMinNo;
  }*/
    public String[] getMaxMinNo(String groupNo, String tableName)
			throws Exception, SQLException {
		String[] strMaxMinNo = new String[3];
		String statement = " SELECT MAX(MaxNo),MIN(MaxNo),COUNT(*) FROM PrpMaxNo WHERE groupNo =? AND tableName =?";
		log.debug(statement);
		dbManager.prepareStatement(statement);
		//设置条件字段;
		dbManager.setString(1, groupNo);
		dbManager.setString(2, tableName);
		ResultSet resultSet = dbManager.executePreparedQuery();
		strMaxMinNo[2] = "0";
		while (resultSet.next()) {
			strMaxMinNo[0] = dbManager.getString(resultSet, 1);
			strMaxMinNo[1] = dbManager.getString(resultSet, 2);
			strMaxMinNo[2] = dbManager.getString(resultSet, 3);
		}
		resultSet.close();

		// 如果没有取到，则插入一条数据
		if ("0".equals(strMaxMinNo[2])) {
			PrpMaxNoDto maxNoDto = new PrpMaxNoDto();
			maxNoDto.setGroupNo(groupNo);
			maxNoDto.setTableName(tableName);
			maxNoDto.setMaxNo("000001");
			maxNoDto.setFlag("0");
			this.insert(maxNoDto);
			log.info("单号初始化成功！！");
			strMaxMinNo[0] = "000001";
			strMaxMinNo[1] = "000001";
		}
		return strMaxMinNo;
	}
}
