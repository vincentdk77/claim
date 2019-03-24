package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PRPCMAINCARGO-货运险保单信息的数据访问对象类<br>
 * 创建于 2005-06-02 10:27:47.265<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCmainCargo extends DBPrpCmainCargoBase{
    private static Log logger = LogFactory.getLog(DBPrpCmainCargo.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCmainCargo(DBManager dbManager){
        super(dbManager);
    }
}
