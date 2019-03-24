package com.sinosoft.claimzy.facade;



import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.aip.webservice.server.PrepaidFarmerInfo;
import com.sinosoft.claimzy.common.NXZYAppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是农险（中央政策性）分户预赔付信息的数据访问类
 * @author CDB
 *
 */
public class DBPrpPrepaidFarmerInfoZY {
	/**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = new DBManager();
    private static Log logger = LogFactory.getLog(DBPrpPrepaidFarmerInfoZY.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpPrepaidFarmerInfoZY(DBManager dbManager){
    	this.dbManager = dbManager;
    }
    
    /**
     * 按主键查找数据
     * @throws Exception 
     */
    public PrepaidFarmerInfo[] findByPrimaryKey(String preCompensateNo) throws Exception{
		StringBuffer buffer = new StringBuffer(200);
		//拼接SQL
		buffer.append("select ");
		buffer.append(" Distinct ");
		buffer.append(" a.precompensateno, ");
		buffer.append(" c.insuredname, ");//农户姓名(从prpcinsured表中查出来)
		buffer.append(" c.identifytype, ");
		buffer.append(" c.identifynumber, ");//证件号码(从prpcinsured表中查出来)
		buffer.append(" c.phonenumber, ");//联系电话(从prpcinsured表中查出来)
		buffer.append(" a.sumprepaid, ");//预付赔款
		buffer.append(" c.serialno ");//序号（从清单子表中查询出来）
		buffer.append(" from prplprepay a,prpcinsured c ");
		if(logger.isDebugEnabled()){
			StringBuffer debugBuffer = new StringBuffer(buffer.length()*4);
			debugBuffer.append(buffer.toString());
			debugBuffer.append(" where a.policyno = c.policyno ");
            debugBuffer.append(" And preCompensateNo=").append("'").append(preCompensateNo).append("'");
            logger.debug(debugBuffer.toString());
		}
		buffer.append(" where a.policyno = c.policyno ");
		buffer.append(" And preCompensateNo=? ");
		dbManager.prepareStatement(buffer.toString());
		//设置条件字段
		dbManager.setString(1, preCompensateNo);
		ResultSet resultSet = dbManager.executePreparedQuery();
		PrepaidFarmerInfo prepaidFarmerInfo =null;
		if(resultSet.next()){
			prepaidFarmerInfo = new PrepaidFarmerInfo();
			prepaidFarmerInfo.setPrepayCaseNumber(dbManager.getString(resultSet, 1));//预赔案号
			prepaidFarmerInfo.setFarmerName(dbManager.getString(resultSet, 2));//农户姓名
			//设置证件类型
        	if(dbManager.getString(resultSet, 3).equals("61")){
        		prepaidFarmerInfo.setFarmerIDType("71");//组织机构代码证
        	}else if(dbManager.getString(resultSet, 3).equals("62")){
        		prepaidFarmerInfo.setFarmerIDType("72");//税务登记证
        	}else{
        		prepaidFarmerInfo.setFarmerIDType(dbManager.getString(resultSet, 3));
        	}
            prepaidFarmerInfo.setFarmerIDNumber(dbManager.getString(resultSet, 4));//证件号码
            prepaidFarmerInfo.setFarmerTelephone(dbManager.getString(resultSet, 5));//联系电话
            prepaidFarmerInfo.setPrepaidLoss(dbManager.getDouble(resultSet, 6));//预付赔款
            prepaidFarmerInfo.setSerialNo(dbManager.getLong(resultSet, 7));//序号
		}
		List<PrepaidFarmerInfo> list = new ArrayList<PrepaidFarmerInfo>();
		list.add(prepaidFarmerInfo);
		PrepaidFarmerInfo[] prepaidFarmerInfoList = new PrepaidFarmerInfo[list.size()];
		for(int i=0;i<list.size();i++){
			prepaidFarmerInfoList[i] = list.get(i);
		}
		 resultSet.close();
    	return prepaidFarmerInfoList;
    	
    }
}
