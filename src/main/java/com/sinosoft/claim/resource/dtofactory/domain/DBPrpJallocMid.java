package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjallocmid长期险业务保费分摊中间表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJallocMid extends DBPrpJallocMidBase{
    private static Log log = LogFactory.getLog(DBPrpJallocMid.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpJallocMid(DBManager dbManager){
        super(dbManager);
    }
}
