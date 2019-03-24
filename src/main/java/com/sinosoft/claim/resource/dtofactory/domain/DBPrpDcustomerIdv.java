package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcustomer_idv个人客户代码表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcustomerIdv extends DBPrpDcustomerIdvBase{
    private static Log log = LogFactory.getLog(DBPrpDcustomerIdv.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDcustomerIdv(DBManager dbManager){
        super(dbManager);
    }
}
