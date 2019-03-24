package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLbackVisit--回访信息主表的数据访问对象类<br>
 * 创建于 2005-03-25 20:44:44.828<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLbackVisit extends DBPrpLbackVisitBase{
    private static Log logger = LogFactory.getLog(DBPrpLbackVisit.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLbackVisit(DBManager dbManager){
        super(dbManager);
    }
}
