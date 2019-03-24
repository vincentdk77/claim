package com.sinosoft.claimzy.facade;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.aip.webservice.server.PrepaidMainInfo;
import com.sinosoft.claimzy.util.BLComCodeConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是农险（中央政策性）的预赔案主信息的数据访问类
 * @author CDB
 *
 */
public class DBPrpPrepaidMainInfoZY {
	/**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = new DBManager();
    private static Log logger = LogFactory.getLog(DBPrpPrepaidMainInfoZY.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpPrepaidMainInfoZY(DBManager dbManager){
    	this.dbManager = dbManager;
    }
    /**
     * 按主键查找数据
     * @throws Exception 
     */
    public PrepaidMainInfo findByPrimaryKey(String preCompensateNo) throws Exception{
    	BLComCodeConvert bcc = new BLComCodeConvert();//用于机构代码的转换
		StringBuffer buffer = new StringBuffer(200);
		//拼接SQL
		buffer.append("select ");
		buffer.append(" prplprepay.comcode, ");
		buffer.append(" prplprepay.policyno, ");
		buffer.append(" prplprepay.claimno, ");
		buffer.append(" prplprepay.precompensateno, ");
		buffer.append(" prplprepay.underwriteenddate, ");
		buffer.append(" prplprepay.sumprepaid, ");
		buffer.append(" prplprepay.sumPreChargePaid, ");
		buffer.append(" prpcmain.suminsured ");
		buffer.append(" from prplprepay,prpcmain ");
		if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append(" where prplprepay.policyno = prpcmain.policyno ");
            debugBuffer.append(" And preCompensateNo=").append("'").append(preCompensateNo).append("'");
            logger.debug(debugBuffer.toString());
        }
    	buffer.append(" where prplprepay.policyno = prpcmain.policyno "); 
    	buffer.append(" And preCompensateNo=? ");
    	dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
    	 dbManager.setString(1,preCompensateNo);
         ResultSet resultSet = dbManager.executePreparedQuery();
         PrepaidMainInfo prepaidMainInfo = null;
         if(resultSet.next()){
        	 prepaidMainInfo = new PrepaidMainInfo();
        	 String comCode = dbManager.getString(resultSet, 1);
        	 prepaidMainInfo.setCompanyCode(bcc.getNewComCode(comCode));//保险公司机构代码
        	 prepaidMainInfo.setPolicyNumber(dbManager.getString(resultSet, 2));//保单号
        	 prepaidMainInfo.setClaimNumber(dbManager.getString(resultSet, 3));//立案号
        	 prepaidMainInfo.setPrepayCaseNumber(dbManager.getString(resultSet, 4));//预赔案号
        	 prepaidMainInfo.setAssessmentDate(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND, 5));//核赔日期
        	 prepaidMainInfo.setPrepaidAmount(dbManager.getDouble(resultSet, 6));//预付赔款
        	 prepaidMainInfo.setPrepaidDirectExpense(dbManager.getDouble(resultSet, 7));//其中：预付直接理赔费用
        	 prepaidMainInfo.setFarmerCount(dbManager.getLong(resultSet, 8));//分户预赔付清单记录数
        	 prepaidMainInfo.setClaimSequenceNo("");//理赔编码
         }
    	return prepaidMainInfo;
    	
    }
}
