package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpMaxNoDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpmaxno�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:16:30<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpMaxNo extends DBPrpMaxNoBase{
    private static Log log = LogFactory.getLog(DBPrpMaxNo.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpMaxNo(DBManager dbManager){
        super(dbManager);
    }
    
   /**
   * �ӵ��ű�PrpMaxNo��ȡ������С����
   * @param iGroupNo
   * @param iTableName
   * @return String[]  String[1]:����MaxNo,String[2]:��С��MinNo,String[3]:��¼��Count
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
    //���������ֶ�;
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
		//���������ֶ�;
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

		// ���û��ȡ���������һ������
		if ("0".equals(strMaxMinNo[2])) {
			PrpMaxNoDto maxNoDto = new PrpMaxNoDto();
			maxNoDto.setGroupNo(groupNo);
			maxNoDto.setTableName(tableName);
			maxNoDto.setMaxNo("000001");
			maxNoDto.setFlag("0");
			this.insert(maxNoDto);
			log.info("���ų�ʼ���ɹ�����");
			strMaxMinNo[0] = "000001";
			strMaxMinNo[1] = "000001";
		}
		return strMaxMinNo;
	}
}
