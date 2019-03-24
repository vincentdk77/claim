package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcarLoss定损车辆表的数据访问对象类<br>
 * 创建于 2004-07-19 14:23:57.112<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLcarLoss extends DBPrpLcarLossBase{
    private static Log logger = LogFactory.getLog(DBPrpLcarLoss.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcarLoss(DBManager dbManager){
        super(dbManager);
    }
}
