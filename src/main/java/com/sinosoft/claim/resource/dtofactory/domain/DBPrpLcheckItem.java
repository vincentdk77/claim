package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpLcheckItem查勘任务标的表的数据访问对象类<br>
 * 创建于 2004-07-28 16:34:57.625<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLcheckItem extends DBPrpLcheckItemBase{
    private static Log logger = LogFactory.getLog(DBPrpLcheckItem.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcheckItem(DBManager dbManager){
        super(dbManager);
    }
}
