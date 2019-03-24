package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prppfee批改保额保费变化表的数据访问对象类<br>
 * 创建于 2004-11-22 15:24:17.671<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPfee extends DBPrpPfeeBase{
    private static Log logger = LogFactory.getLog(DBPrpPfee.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpPfee(DBManager dbManager){
        super(dbManager);
    }
}
