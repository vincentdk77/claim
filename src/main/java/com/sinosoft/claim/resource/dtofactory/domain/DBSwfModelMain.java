package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����WfModelMainģ����������ݷ��ʶ�����<br>
 * ������ 2004-08-09 19:54:51.852<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBSwfModelMain extends DBSwfModelMainBase{
    private static Log logger = LogFactory.getLog(DBSwfModelMain.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSwfModelMain(DBManager dbManager){
        super(dbManager);
    }

 /**
 * ��ȡmodelNo
 * @return ModelNo
 * @throws Exception
 */
public int getModelNo()
    throws Exception{
    int modelNo = -1;
    String statement = "Select max(modelNo+1) from SwfModelMain";
    logger.debug(statement);
    ResultSet resultSet = dbManager.executeQuery(statement);
    resultSet.next();
    modelNo  = dbManager.getInt(resultSet,1);
    resultSet.close();
    if (modelNo==0)
    {
      modelNo=1;
    }

    return modelNo ;
}

}
