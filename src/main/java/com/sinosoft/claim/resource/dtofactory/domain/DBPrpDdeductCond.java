package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDdeductCond 免赔条件表的数据访问对象类<br>
 * 创建于 2005-01-20 09:47:05.750<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDdeductCond extends DBPrpDdeductCondBase{
    private static Log logger = LogFactory.getLog(DBPrpDdeductCond.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDdeductCond(DBManager dbManager){
        super(dbManager);
    }
}
