package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplprop财产核定损明细清单表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLprop extends DBPrpLpropBase{
    private static Log log = LogFactory.getLog(DBPrpLprop.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLprop(DBManager dbManager){
        super(dbManager);
    }
}
