package com.sinosoft.claimciplatform.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是理赔信息上传平台日志表的数据访问对象类<br>
 * 创建于 2006-06-21 20:29:06.890<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCIClaimUploadLog extends DBCIClaimUploadLogBase{
    private static Log logger = LogFactory.getLog(DBCIClaimUploadLog.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBCIClaimUploadLog(DBManager dbManager){
        super(dbManager);
    }
    
    /**
     * 根据业务号查询上传序号
     * @param businessNo 业务号
     * @return 满足模糊查询条件的记录数
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
     * 查询最大序号
     * @param uploadNo 上传序号
     * @return 最大序号
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
