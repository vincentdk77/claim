package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLbackVisitQue--回访问询表的数据访问对象类<br>
 * 创建于 2005-03-23 09:00:21.593<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLbackVisitQue extends DBPrpLbackVisitQueBase{
    private static Log logger = LogFactory.getLog(DBPrpLbackVisitQue.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLbackVisitQue(DBManager dbManager){
        super(dbManager);
    }
}
