package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpCmainLoan的数据访问对象类<br>
 * 创建于 2006-04-30 11:46:20.437<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpCmainLoan extends DBPrpCmainLoanBase{
    private static Log logger = LogFactory.getLog(DBPrpCmainLoan.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCmainLoan(DBManager dbManager){
        super(dbManager);
    }
}
