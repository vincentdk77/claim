package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpCitemHouse的数据访问对象类<br>
 * 创建于 2006-04-30 14:20:10.406<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpCitemHouse extends DBPrpCitemHouseBase{
    private static Log logger = LogFactory.getLog(DBPrpCitemHouse.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCitemHouse(DBManager dbManager){
        super(dbManager);
    }
}
