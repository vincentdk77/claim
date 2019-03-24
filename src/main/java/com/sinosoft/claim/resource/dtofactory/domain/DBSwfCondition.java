package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfConditionDto��������������������ݷ��ʶ�����<br>
 * ������ 2004-08-09 19:54:51.892<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBSwfCondition extends DBSwfConditionBase{
    private static Log logger = LogFactory.getLog(DBSwfCondition.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSwfCondition(DBManager dbManager){
        super(dbManager);
    }

      /**
     * ��ѯҵ�������Ƿ�����������Լ��
     * @param conditions
     * @return boolean
     * @throws Exception
     */
    public boolean executeResult(String conditions)
        throws Exception{
        boolean  result =false;
        int count =-1;
        String statement = conditions;
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBClaim.getConditionExecuteResult() success!");
        if (count>0)
        {
          result=true;
        }

        return result;
    }

}
