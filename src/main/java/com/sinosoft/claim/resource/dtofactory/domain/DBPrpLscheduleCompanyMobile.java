package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLscheduleCompanyMobile--调度中心电话表的数据访问对象类<br>
 * 创建于 2005-09-01 10:09:58.243<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLscheduleCompanyMobile extends DBPrpLscheduleCompanyMobileBase{
    private static Log logger = LogFactory.getLog(DBPrpLscheduleCompanyMobile.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLscheduleCompanyMobile(DBManager dbManager){
        super(dbManager);
    }
}
