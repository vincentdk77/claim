package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpgroup�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:16:30<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpGroup extends DBPrpGroupBase{
    private static Log log = LogFactory.getLog(DBPrpGroup.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpGroup(DBManager dbManager){
        super(dbManager);
    }


  /**
  * ��ȡ���ű���
  * @param subGroupNo  �ӱ���
  * @return strGroupNo ������
  * @throws Exception
  */
 public String getGroupNo(String subGroupNo) throws Exception{

   String strGroupNo = "";
   String statement = " Select distinct GroupNo From PrpGroup Where subGroupNo = ?";
   log.debug(statement);
   dbManager.prepareStatement(statement);
     //���������ֶ�;
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
