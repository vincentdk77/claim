package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLacciCheck�����ݷ��ʶ�����<br>
 * ������ 2005-06-14 12:01:09.343<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLacciCheck extends DBPrpLacciCheckBase{
    private static Log logger = LogFactory.getLog(DBPrpLacciCheck.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLacciCheck(DBManager dbManager){
        super(dbManager);
    }
    
    /**
     * �������ò���һ������
     * @param checkNo CheckNo
     * @return PrpLacciCheckDto
     * @throws Exception
     */
    public int findByRegistNoMaxTimes(String registNo) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT max(Times) times ");
        buffer.append(" FROM PrpLacciCheck ");
        int time = 0;
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer);
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append(" WHERE ");
        buffer.append("checkNo = ?");
        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,registNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            time = resultSet.getInt("times");
        }else{
            logger.info("DBPrpLacciCheckBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return time;
    }
    /**
     * ��õ���ĳ�������ŵ����е�������ܺ�
     * @param registNo
     * @return
     * @throws Exception
     */
    public double getSumAcciCheckFeeByRegistNo(String registNo) throws Exception{
    	double sumCheckFee = 0;
    	StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT sum(checkFee) sumCheckFee");
        buffer.append(" FROM PrpLacciCheck ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer);
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append(" WHERE ");
        buffer.append("RegistNo = ?");
        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,registNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
        	sumCheckFee = resultSet.getInt("sumCheckFee");
        }else{
            logger.info("DBPrpLacciCheck.getSumAcciCheckFeeByRegistNo() failure!");
        }
        resultSet.close();
        return sumCheckFee;        
    }
}
