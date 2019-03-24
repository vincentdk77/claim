package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLQs_list清算中心通赔结算明细清单的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:32:09<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLQsList extends DBPrpLQsListBase{
    private static Log log = LogFactory.getLog(DBPrpLQsList.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLQsList(DBManager dbManager){
        super(dbManager);
    }
}
