package com.sinosoft.claimciplatform.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����������Ϣ�ϴ�ƽ̨��־������ݷ��ʶ�����<br>
 * ������ 2006-06-21 20:29:06.890<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCIClaimUploadLog extends DBCIClaimUploadLogBase{
    private static Log logger = LogFactory.getLog(DBCIClaimUploadLog.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCIClaimUploadLog(DBManager dbManager){
        super(dbManager);
    }
    
    /**
     * ����ҵ��Ų�ѯ�ϴ����
     * @param businessNo ҵ���
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public String getUplaodNo(String businessNo) 
        throws Exception{
        String uploadNo = null;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT Distinct uploadNo FROM CIClaimUploadLog WHERE ");
        buffer.append(" businessNo = '" + businessNo + "'");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        while(resultSet.next()){
            uploadNo = dbManager.getString(resultSet,1);
        }
        resultSet.close();
        return uploadNo;
    }
    /**
     * ��ѯ������
     * @param uploadNo �ϴ����
     * @return ������
     * @throws Exception
     */
    public int getMaxSerialNo(String uploadNo)throws Exception{
    	int maxSerialNo = 0;
    	String strSql = " select max(serialNo) from CIClaimUploadLog where uploadNo = '" + uploadNo + "'";
    	if(logger.isDebugEnabled()){
            logger.debug(strSql);
        }
    	ResultSet resultSet = dbManager.executeQuery(strSql);
    	if(resultSet.next()){
    		maxSerialNo = dbManager.getInt(resultSet, 1);
    	}
    	resultSet.close();
    	return maxSerialNo;
    }
}
