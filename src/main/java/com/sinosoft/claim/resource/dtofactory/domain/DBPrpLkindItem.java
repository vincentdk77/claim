package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是承保险别标的表的数据访问对象类<br>
 * 创建于 2007-07-05 14:54:47.140<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLkindItem extends DBPrpLkindItemBase{
    private static Log logger = LogFactory.getLog(DBPrpLkindItem.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLkindItem(DBManager dbManager){
        super(dbManager);
    }
}
