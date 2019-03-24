package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayExtDto;

/**
 * 这是支付处理意见表的数据访问对象类<br>
 * 创建于 2013-07-30 09:39:36.607<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLpayExt extends DBPrpLpayExtBase{
    private static Logger logger = Logger.getLogger(DBPrpLpayExt.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpayExt(DBManager dbManager){
        super(dbManager);
    }
    /**
     * 更新日志暂存状态为完成
     * @param dbManager
     * @param paymentNo 支付编号
     * @throws Exception
     */
    public void updateFlagByPaymentNo(String paymentNo) throws Exception{
    	String statement ="update prplpayExt " +
		"set  flag='Y' " +
		"where paymentNo=? ";

		dbManager.prepareStatement(statement);
		dbManager.setString(1,paymentNo);
		dbManager.executePreparedUpdate();
		logger.info("DBPrpLpayExt.updateFlagByPaymentNo() success!");
    }
    /**
     * 查询同一支付编号下的记录数
     * @param paymentNo 支付编号
     * @return 满足条件的记录数
     * @throws Exception
     */
    public int getMaxSerialNo(String paymentNo) throws Exception{
    	int serialNo = -1;
        String statement = "Select max(serialNo+1) from prplpayExt Where paymentNo ='"+paymentNo+"'";
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        serialNo = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("prplpayExt.getMaxSerialNo() success!");
        if (serialNo==0)
        {
        	serialNo=1;
        }

        return serialNo ;
    }
}
