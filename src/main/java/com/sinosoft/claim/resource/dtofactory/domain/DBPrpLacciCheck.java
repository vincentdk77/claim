package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLacciCheck的数据访问对象类<br>
 * 创建于 2005-06-14 12:01:09.343<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLacciCheck extends DBPrpLacciCheckBase{
    private static Log logger = LogFactory.getLog(DBPrpLacciCheck.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLacciCheck(DBManager dbManager){
        super(dbManager);
    }
    
    /**
     * 按报案好查找一条数据
     * @param checkNo CheckNo
     * @return PrpLacciCheckDto
     * @throws Exception
     */
    public int findByRegistNoMaxTimes(String registNo) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
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
        //设置条件字段;
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
     * 获得等于某个报案号的所有调查费用总和
     * @param registNo
     * @return
     * @throws Exception
     */
    public double getSumAcciCheckFeeByRegistNo(String registNo) throws Exception{
    	double sumCheckFee = 0;
    	StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
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
        //设置条件字段;
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
