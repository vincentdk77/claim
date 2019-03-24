package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prppmain批改保单信息表的数据访问对象类<br>
 * 创建于 2004-11-22 15:24:17.468<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPmain extends DBPrpPmainBase{
    private static Log logger = LogFactory.getLog(DBPrpPmain.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpPmain(DBManager dbManager){
        super(dbManager);
    }
    
//modify by liuyanmei add 20051111 satrt
//reason:交验此保单是否处于批改状态
    public int checkStatus(String policyNo)
    throws Exception{
    int checkFlag = -1;
    
    String statement = "Select count(1) from PrpPmain Where policyNo= '"+policyNo + "' and underwriteFlag <> '1' ";
     statement = SqlUtils.getWherePartForGetCount(statement);
    logger.debug(statement);
    ResultSet resultSet = dbManager.executeQuery(statement);
    resultSet.next();
    checkFlag = dbManager.getInt(resultSet,1);
    resultSet.close();
    logger.info("DBPrpPmainBase.checkStatus() success!");
    return checkFlag;
}
//  modify by liuyanmei add 20051111 end
}
