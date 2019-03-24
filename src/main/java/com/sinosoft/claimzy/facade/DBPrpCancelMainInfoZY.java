package com.sinosoft.claimzy.facade;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.aip.webservice.server.CancelMainInfo;
import com.sinosoft.claimzy.util.BLComCodeConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是农险（中央政策性）的注销/拒赔信息的数据访问类
 * @author Administrator
 *
 */
public class DBPrpCancelMainInfoZY {
	/**
	 * 资源管理类的实例，处理数据库操作
	 */
	protected DBManager dbManager = new DBManager();
    private static Log logger = LogFactory.getLog(DBPrpCancelMainInfoZY.class);
    
    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCancelMainInfoZY(DBManager dbManager){
    	this.dbManager = dbManager;
    }
    /**
     * 按主键查找数据
     * @throws Exception 
     */
    public CancelMainInfo findByPrimaryKey(String claimNo) throws Exception{
    	BLComCodeConvert bcc = new BLComCodeConvert();//用于机构代码的转换
    	StringBuffer buffer = new StringBuffer(200);
    	//拼接SQL
    	buffer.append("select ");
    	////理赔编码claimSequenceNo(未找到)
    	buffer.append("prplclaim.comcode, ");
        buffer.append("prplclaim.policyno, ");
 	    buffer.append("prplclaim.claimno, ");
 	    buffer.append("prplclaim.casetype, ");//注销类型
 		buffer.append("prplclaim.canceldate, ");
 		buffer.append("prplclaim.cancelreason ");//原因描述
        buffer.append(" from prplclaim");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append(" Where claimNo=").append("'").append(claimNo).append("'");
            logger.debug(debugBuffer.toString());
        }
    	buffer.append(" Where claimNo=? ");
    	dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,claimNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        CancelMainInfo cancelMainInfo = null;
        if(resultSet.next()){
        	cancelMainInfo = new CancelMainInfo();
        	String comCode = dbManager.getString(resultSet, 1);
        	cancelMainInfo.setCompanyCode(bcc.getNewComCode(comCode));//保险公司机构代码
        	cancelMainInfo.setPolicyNumber(dbManager.getString(resultSet, 2));//保单号
        	cancelMainInfo.setClaimNumber(dbManager.getString(resultSet, 3));//立案号
        	//注销/拒赔类型转码
        	String cancelType = dbManager.getString(resultSet, 4);
        	if(cancelType.equals("0")){//注销类型
        		cancelMainInfo.setCancelType("01");//立案注销
        	}else if(cancelType.equals("1")){
        		cancelMainInfo.setCancelType("02");//立案拒赔
        	}else{
        		cancelMainInfo.setCancelType(dbManager.getString(resultSet, 4));
        	}
        	cancelMainInfo.setCancelTime(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND, 5));//立案注销/拒赔时间
        	//原因描述(处理)
        	String cancelReason = dbManager.getString(resultSet, 6);
        	if(cancelReason.equals("")){
        		cancelMainInfo.setCancelReason("**");
        	}else{
        		cancelMainInfo.setCancelReason(dbManager.getString(resultSet, 6));
        	}
        	cancelMainInfo.setClaimSequenceNo("");//理赔编码置空
        }
        resultSet.close();
		return cancelMainInfo;
    	
    }
}
