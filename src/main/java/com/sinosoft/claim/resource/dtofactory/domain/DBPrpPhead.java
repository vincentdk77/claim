package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpphead批改信息表的数据访问对象类<br>
 * 创建于 2004-11-22 15:24:17.390<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPhead extends DBPrpPheadBase{
    private static Log logger = LogFactory.getLog(DBPrpPhead.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpPhead(DBManager dbManager){
        super(dbManager);
    }
}
