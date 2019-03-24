package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLscheduleCompany--调度中心提示信息设置表的数据访问对象类<br>
 * 创建于 2005-08-08 21:52:10.851<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLscheduleCompany extends DBPrpLscheduleCompanyBase{
    private static Log logger = LogFactory.getLog(DBPrpLscheduleCompany.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLscheduleCompany(DBManager dbManager){
        super(dbManager);
    }
}
