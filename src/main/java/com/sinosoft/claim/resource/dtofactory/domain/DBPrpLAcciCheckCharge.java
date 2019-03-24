package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * 这是调查费用表-PrpLAcciCheckCharge的数据访问对象类<br>
 * 创建于 2006-01-23 15:30:13.843<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLAcciCheckCharge extends DBPrpLAcciCheckChargeBase{
    private static Log logger = LogFactory.getLog(DBPrpLAcciCheckCharge.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLAcciCheckCharge(DBManager dbManager){
        super(dbManager);
    }
}
