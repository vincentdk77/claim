package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcheckItemLog-查勘任务信息处理日志表的数据访问对象类<br>
 * 创建于 2005-03-18 15:44:09.156<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLcheckItemLog extends DBPrpLcheckItemLogBase{
    private static Log logger = LogFactory.getLog(DBPrpLcheckItemLog.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcheckItemLog(DBManager dbManager){
        super(dbManager);
    }
}
