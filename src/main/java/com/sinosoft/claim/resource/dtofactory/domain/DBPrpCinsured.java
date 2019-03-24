package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcinsured���չ�ϵ�˱�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCinsured extends DBPrpCinsuredBase{
    private static Log log = LogFactory.getLog(DBPrpCinsured.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCinsured(DBManager dbManager){
        super(dbManager);
    }
    
//modify by liuyanmei add 20051108 start
    public String  getIdentifyNumber(String conditions) throws Exception{
    	 String identifyNumber="";
    	 String statement = "Select DISTINCT identifyNumber From PrpCinsured where  " +conditions ;
         log.debug(statement);
         //PrpLverifyLossDto prpLverifyLossDto = null;
         ResultSet resultSet = dbManager.executeQuery(statement);
         //identifyNumber= dbManager.executeQuery(statement);

        while(resultSet.next()){
             identifyNumber=dbManager.getString(resultSet,1);
         }
        resultSet.close();
         //log.info("DBPrpCinsured.getIdentifyNumber() success!");
         return identifyNumber;
     }
    
    
    
    
//modify by liuyanmei add 20051108 end
    
    
}
