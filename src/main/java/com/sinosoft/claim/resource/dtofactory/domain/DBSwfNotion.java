package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ���ǹ�����������������ݷ��ʶ�����<br>
 * ������ 2005-04-05 10:45:03.125<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBSwfNotion extends DBSwfNotionBase{
    private static Log logger = LogFactory.getLog(DBSwfNotion.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSwfNotion(DBManager dbManager){
        super(dbManager);
    }
    
         /**
     * ��ȡlogno��
     * @param flowID
     * @return LogNo
     * @throws Exception
     */
    public int getMaxLineNo(String flowID,int logNo)
        throws Exception{
        int LineNo = -1;
        String statement = "Select max(LineNo+1) from swfNotion Where flowID='" +flowID+"'"
                         + " and logNo="+logNo;
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        LineNo = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfLog.getMaxLineNo() success!");
        if (LineNo==0)
        {
          LineNo=1;
        }

        return LineNo ;
    }
}
